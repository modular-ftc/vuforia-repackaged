/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Rect
 *  android.graphics.YuvImage
 */
package com.vuforia.ar.pl;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class ImageTools {
    private static final String MODULENAME = "ImageTools";
    private static final int CAMERA_IMAGE_FORMAT_RGB565 = 268439810;
    private static final int CAMERA_IMAGE_FORMAT_NV12 = 268439815;
    private static final int CAMERA_IMAGE_FORMAT_NV21 = 268439817;
    private static final int CAMERA_IMAGE_FORMAT_LUM = 268439809;

    public static byte[] encodeImage(byte[] pixels, int width, int height, int format, int stride, int quality) {
        if (pixels == null) {
            return null;
        }
        if (format == 268439817) {
            YuvImage yuvImage = new YuvImage(pixels, 17, width, height, null);
            ByteArrayOutputStream encodedBuffer = new ByteArrayOutputStream();
            if (yuvImage.compressToJpeg(new Rect(0, 0, width, height), quality, (OutputStream)encodedBuffer)) {
                return encodedBuffer.toByteArray();
            }
            return null;
        }
        if (format == 268439809) {
            ByteArrayOutputStream encodedBuffer;
            int numPixels = width * height;
            int[] colors = new int[numPixels];
            for (int p = 0; p < numPixels; ++p) {
                colors[p] = pixels[p] << 24 | 16777215;
            }
            Bitmap bmp = Bitmap.createBitmap((int[])colors, (int)0, (int)width, (int)width, (int)height, (Bitmap.Config)Bitmap.Config.ARGB_8888);
            if (bmp.compress(Bitmap.CompressFormat.JPEG, quality, (OutputStream)(encodedBuffer = new ByteArrayOutputStream()))) {
                return encodedBuffer.toByteArray();
            }
            return null;
        }
        return null;
    }
}

