/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia.ar.pl;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ARHttpResponse {
    private static final String MODULENAME = "ARHttpResponse";
    public static final int ERROR_NONE = 0;
    public static final int ERROR_CANCELED = 1;
    public static final int ERROR_OPERATION_FAILED = 2;
    public static final int ERROR_TIMEOUT = 3;
    public static final int MAXIMUM_ERROR = 3;
    public int statusCode;
    public int networkStatus;
    public String contentType;
    public String contentEncoding;
    public byte[] contentBytes;

    public static ARHttpResponse createARResponse(int errorReason) {
        if (errorReason > 0 && errorReason <= 3) {
            ARHttpResponse arResponse = new ARHttpResponse();
            arResponse.statusCode = 0;
            arResponse.contentBytes = null;
            arResponse.contentEncoding = null;
            arResponse.contentType = null;
            arResponse.networkStatus = errorReason;
            return arResponse;
        }
        return null;
    }

    public static ARHttpResponse createARResponse(HttpURLConnection connection) throws IOException {
        ARHttpResponse arResponse = new ARHttpResponse();
        arResponse.statusCode = connection.getResponseCode();
        arResponse.contentType = connection.getContentType();
        arResponse.contentEncoding = connection.getContentEncoding();
        InputStream in = null;
        try {
            in = connection.getInputStream();
        }
        catch (IOException ioe) {
            in = connection.getErrorStream();
        }
        if (in != null) {
            String contentLengthStr = connection.getHeaderField("content-length");
            if (contentLengthStr != null) {
                arResponse.contentBytes = new byte[Integer.parseInt(contentLengthStr)];
                ByteBuffer data = ByteBuffer.wrap(arResponse.contentBytes);
                ReadableByteChannel chan = Channels.newChannel(in);
                while (data.position() < data.limit()) {
                    chan.read(data);
                }
                chan.close();
            } else {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataInputStream dis = new DataInputStream(in);
                byte[] xfer = new byte[2048];
                int bytesRead = 0;
                while ((bytesRead = dis.read(xfer)) != -1) {
                    baos.write(xfer, 0, bytesRead);
                }
                arResponse.contentBytes = baos.toByteArray();
                dis.close();
            }
        } else {
            arResponse.contentType = null;
            arResponse.contentEncoding = null;
            arResponse.contentBytes = null;
        }
        return arResponse;
    }
}

