/*
 * Decompiled with CFR 0_133.
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

    public static byte[] encodeImage(byte[] arrby, int n, int n2, int n3, int n4, int n5) {
        if (arrby == null) {
            return null;
        }
        if (n3 == 268439817) {
            YuvImage yuvImage = new YuvImage(arrby, 17, n, n2, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (yuvImage.compressToJpeg(new Rect(0, 0, n, n2), n5, (OutputStream)byteArrayOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
            return null;
        }
        if (n3 == 268439809) {
            ByteArrayOutputStream byteArrayOutputStream;
            int n6 = n * n2;
            int[] arrn = new int[n6];
            for (int i = 0; i < n6; ++i) {
                arrn[i] = arrby[i] << 24 | 16777215;
            }
            Bitmap bitmap = Bitmap.createBitmap((int[])arrn, (int)0, (int)n, (int)n, (int)n2, (Bitmap.Config)Bitmap.Config.ARGB_8888);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, n5, (OutputStream)(byteArrayOutputStream = new ByteArrayOutputStream()))) {
                return byteArrayOutputStream.toByteArray();
            }
            return null;
        }
        return null;
    }
}

