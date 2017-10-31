/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia.ar.pl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

public class ARHttpRequest {
    private static final String MODULENAME = "ARHttpRequest";
    public String url;
    public String method;
    public String[] headers;
    public String contentType = null;
    public String contentEncoding = null;
    public String contentPath = null;
    public byte[] content = null;
    public long nativeRequestPtr;
    boolean isQuery;

    public static HttpURLConnection createHttpRequest(ARHttpRequest arRequest) throws IOException {
        URL url = new URL(arRequest.url);
        HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
        for (int i = 0; i < arRequest.headers.length / 2; ++i) {
            httpConnection.addRequestProperty(arRequest.headers[2 * i], arRequest.headers[2 * i + 1]);
        }
        httpConnection.setRequestMethod(arRequest.method);
        if (arRequest.method.equals("POST") && !arRequest.isQuery) {
            if (arRequest.contentType != null) {
                httpConnection.addRequestProperty("content-type", arRequest.contentType);
            }
            if (arRequest.contentEncoding != null) {
                httpConnection.addRequestProperty("content-encoding", arRequest.contentEncoding);
            }
            httpConnection.setDoOutput(true);
            Buffer data = null;
            if (arRequest.contentPath != null) {
                File f = new File(arRequest.contentPath);
                if (!f.exists() || !f.canRead()) {
                    throw new FileNotFoundException("Unable to read file " + arRequest.contentPath);
                }
                httpConnection.setFixedLengthStreamingMode((int)f.length());
                data = ByteBuffer.allocate((int)f.length());
                FileInputStream fis = new FileInputStream(arRequest.contentPath);
                while (data.position() < data.limit()) {
                    fis.getChannel().read((ByteBuffer)data);
                }
                fis.close();
                data.flip();
            } else if (arRequest.content != null) {
                httpConnection.setFixedLengthStreamingMode(arRequest.content.length);
                data = ByteBuffer.wrap(arRequest.content);
            }
            WritableByteChannel wbc = Channels.newChannel(httpConnection.getOutputStream());
            while (data.position() < data.limit()) {
                wbc.write((ByteBuffer)data);
            }
            data.flip();
        }
        return httpConnection;
    }
}

