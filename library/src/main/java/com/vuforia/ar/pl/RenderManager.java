/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class RenderManager {
    private static final int AR_RENDERING_MODE_UNKNOWN = 0;
    private static final int AR_RENDERING_MODE_DISABLED = 1;
    private static final int AR_RENDERING_MODE_CONTINUOUS = 2;
    private static final int AR_RENDERING_MODE_WHENDIRTY = 3;
    private static int viewId = 0;
    SurfaceManager surfaceManager;
    int renderMode;
    boolean synchronousMode;
    ScheduledThreadPoolExecutor timer;
    ScheduledFuture<?> fixedFrameRateRunnerTask;
    ScheduledFuture<?> renderRequestWatcherTask;
    AtomicBoolean renderRequestServiced;
    AtomicBoolean renderRequested;
    private static final String MODULENAME = "RenderManager";
    long delayMS = 0L;
    long minMS = 0L;
    long maxMS = 0L;

    public RenderManager(SurfaceManager sm) {
        this.surfaceManager = sm;
        this.renderMode = 2;
        this.timer = new ScheduledThreadPoolExecutor(1);
        this.synchronousMode = false;
        this.renderRequestServiced = new AtomicBoolean(false);
        this.renderRequested = new AtomicBoolean(false);
    }

    void startTimer() {
        if (this.timer.isShutdown()) {
            this.timer = new ScheduledThreadPoolExecutor(1);
        }
        if (this.fixedFrameRateRunnerTask != null && !this.fixedFrameRateRunnerTask.isCancelled()) {
            this.fixedFrameRateRunnerTask.cancel(true);
        }
        if (this.renderRequestWatcherTask != null && !this.renderRequestWatcherTask.isCancelled()) {
            this.renderRequestWatcherTask.cancel(true);
        }
        this.fixedFrameRateRunnerTask = null;
        this.renderRequestWatcherTask = null;
        long timerDelay = this.delayMS < 4L ? 1L : this.delayMS / 4L;
        this.renderRequestWatcherTask = this.timer.scheduleWithFixedDelay(new RenderRequestWatcher(), 0L, timerDelay, TimeUnit.MILLISECONDS);
    }

    void shutdownTimer() {
        if (!this.timer.isShutdown()) {
            this.timer.shutdown();
        }
    }

    public boolean canSetRenderMode() {
        boolean result = this.surfaceManager.retrieveGLSurfaceView();
        if (!result) {
            DebugLog.LOGD(MODULENAME, "Could not retrieve a valid GLSurfaceView in view hierarchy, therefore cannot set any render mode");
        }
        return result;
    }

    public int getRenderMode() {
        return this.renderMode;
    }

    public boolean setRenderMode(int mode) {
        boolean result = false;
        if (this.surfaceManager == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        this.surfaceManager.retrieveGLSurfaceView();
        switch (mode) {
            case 2: {
                result = this.surfaceManager.setEnableRenderWhenDirty(false);
                if (!result) break;
                this.shutdownTimer();
                break;
            }
            case 1: 
            case 3: {
                long delayMSTemp;
                result = this.surfaceManager.setEnableRenderWhenDirty(true);
                if (!result) break;
                if (mode == 1) {
                    this.shutdownTimer();
                    break;
                }
                if (mode == this.renderMode && !this.timer.isShutdown()) break;
                long l = delayMSTemp = this.synchronousMode ? this.minMS : this.maxMS;
                if (delayMSTemp == 0L) break;
                this.delayMS = delayMSTemp;
                this.startTimer();
                break;
            }
            default: {
                SystemTools.setSystemErrorCode(2);
                return false;
            }
        }
        if (!result) {
            SystemTools.setSystemErrorCode(6);
        } else {
            this.renderMode = mode;
        }
        return result;
    }

    public boolean setRenderFpsLimits(boolean synchronous, int minFps, int maxFps) {
        this.synchronousMode = synchronous;
        if (minFps == 0 || maxFps == 0) {
            SystemTools.setSystemErrorCode(2);
            return false;
        }
        this.minMS = minFps > 1000 ? 1L : 1000L / (long) minFps;
        long l = this.maxMS = maxFps > 1000 ? 1L : 1000L / (long) maxFps;
        if (this.renderMode == 3) {
            long delayMSTemp;
            long l2 = delayMSTemp = this.synchronousMode ? this.minMS : this.maxMS;
            if (delayMSTemp != this.delayMS) {
                this.delayMS = delayMSTemp;
                this.startTimer();
            }
        }
        return true;
    }

    public boolean requestRender() {
        this.renderRequested.set(true);
        return true;
    }

    public View addOverlay(byte[] byteArray, int left, int top, float[] scale, int[] size) {
        final Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            DebugLog.LOGE(MODULENAME, "drawOverlay could not get access to an activity");
            return null;
        }
        final DrawOverlayView wm = new DrawOverlayView((Context)activity, byteArray, left, top, scale, size);
        activity.runOnUiThread(new Runnable(){

            @Override
            public void run() {
                wm.addOverlay(activity);
            }
        });
        return wm;
    }

    public boolean removeOverlay(final View view) {
        final Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            return false;
        }
        if (view == null) {
            return false;
        }
        activity.runOnUiThread(new Runnable(){

            @Override
            public void run() {
                DrawOverlayView wm = new DrawOverlayView((Context)activity);
                wm.removeOverlay(activity, view);
            }
        });
        return true;
    }

    private final class FixedFrameRateRunner
    implements Runnable {
        private FixedFrameRateRunner() {
        }

        @Override
        public void run() {
            if (!RenderManager.this.renderRequestServiced.getAndSet(false) && RenderManager.this.surfaceManager != null) {
                RenderManager.this.surfaceManager.requestRender();
                if (!RenderManager.this.synchronousMode && !RenderManager.this.renderRequestWatcherTask.isCancelled()) {
                    RenderManager.this.renderRequestWatcherTask.cancel(false);
                }
            }
        }
    }

    private final class RenderRequestWatcher
    implements Runnable {
        private RenderRequestWatcher() {
        }

        @Override
        public void run() {
            if (RenderManager.this.renderRequested.compareAndSet(true, false) && RenderManager.this.surfaceManager != null) {
                RenderManager.this.surfaceManager.requestRender();
                RenderManager.this.renderRequestServiced.set(true);
                if (RenderManager.this.fixedFrameRateRunnerTask == null) {
                    RenderManager.this.fixedFrameRateRunnerTask = RenderManager.this.timer.scheduleAtFixedRate(new FixedFrameRateRunner(), 0L, RenderManager.this.delayMS, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

}

