/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia.ar.pl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ARHttpClient {
    private static final String MODULENAME = "ARHttpClient";
    private Future<ARHttpResponse> requestTask = null;
    private Future<?> postDSNTimeoutTask = null;
    ExecutorService executor;

    public boolean execute(ARHttpRequest arRequest, ARHttpParams arParams) {
        if (arRequest == null) {
            return false;
        }
        try {
            this.executor = Executors.newFixedThreadPool(2);
            this.requestTask = this.executor.submit(new ARHttpResponseCallable(arRequest, arParams));
            this.postDSNTimeoutTask = this.executor.submit(new ARHttpResponseWatcher(arRequest, arParams));
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean cancel() {
        if (this.requestTask != null) {
            this.requestTask.cancel(true);
            return this.requestTask.isDone();
        }
        return false;
    }

    public native void nativeCallback(ARHttpResponse var1, long var2);

    private class ARHttpResponseWatcher
    implements Runnable {
        private ARHttpParams arParams;
        private ARHttpRequest arRequest;

        public ARHttpResponseWatcher(ARHttpRequest arRequest, ARHttpParams arParams) {
            this.arParams = arParams;
            this.arRequest = arRequest;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            ARHttpResponse arResponse;
            arResponse = null;
            int networkStatus = 0;
            try {
                arResponse = (ARHttpResponse)ARHttpClient.this.requestTask.get(this.arParams.delayedStart_ms + this.arParams.requestTimeout_ms, TimeUnit.MILLISECONDS);
                if (arResponse.statusCode != 200) {
                    // empty if block
                }
            }
            catch (CancellationException e) {
                networkStatus = 1;
            }
            catch (TimeoutException e) {
                networkStatus = 3;
            }
            catch (ExecutionException e) {
                Throwable cause = e.getCause();
                networkStatus = cause instanceof SocketTimeoutException ? 3 : 2;
            }
            catch (Exception e) {
                networkStatus = 2;
            }
            finally {
                if (ARHttpClient.this.requestTask != null && !ARHttpClient.this.requestTask.isCancelled()) {
                    ARHttpClient.this.requestTask.cancel(true);
                }
                if (networkStatus != 0) {
                    arResponse = ARHttpResponse.createARResponse(networkStatus);
                }
            }
            ARHttpClient.this.nativeCallback(arResponse, this.arRequest.nativeRequestPtr);
            ARHttpClient.this.executor.shutdownNow();
        }
    }

    private class ARHttpResponseCallable
    implements Callable<ARHttpResponse> {
        private ARHttpRequest arRequest;
        private ARHttpParams arParams;

        public ARHttpResponseCallable(ARHttpRequest arRequest, ARHttpParams arParams) {
            this.arRequest = arRequest;
            this.arParams = arParams;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public ARHttpResponse call() throws InterruptedException {
            ARHttpResponse arResponse;
            if (this.arParams.delayedStart_ms != 0) {
                Thread.sleep(this.arParams.delayedStart_ms);
            }
            arResponse = null;
            HttpURLConnection httpConnection = null;
            try {
                httpConnection = ARHttpRequest.createHttpRequest(this.arRequest);
                httpConnection.setReadTimeout(this.arParams.requestTimeout_ms);
                httpConnection.setConnectTimeout(this.arParams.requestTimeout_ms);
                arResponse = ARHttpResponse.createARResponse(httpConnection);
            }
            catch (IOException ioe) {
                arResponse = ARHttpResponse.createARResponse(2);
            }
            finally {
                if (httpConnection != null) {
                    httpConnection.disconnect();
                }
            }
            return arResponse;
        }
    }

}

