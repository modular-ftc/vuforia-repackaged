/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.vuforia;

import android.app.Activity;

public class VuforiaBase {
    public static final int GL_20 = 1;
    public static final int INIT_ERROR = -1;
    public static final int INIT_DEVICE_NOT_SUPPORTED = -2;
    public static final int INIT_NO_CAMERA_ACCESS = -3;
    public static final int INIT_LICENSE_ERROR_MISSING_KEY = -4;
    public static final int INIT_LICENSE_ERROR_INVALID_KEY = -5;
    public static final int INIT_LICENSE_ERROR_NO_NETWORK_PERMANENT = -6;
    public static final int INIT_LICENSE_ERROR_NO_NETWORK_TRANSIENT = -7;
    public static final int INIT_LICENSE_ERROR_CANCELED_KEY = -8;
    public static final int INIT_LICENSE_ERROR_PRODUCT_TYPE_MISMATCH = -9;
    public static final int INIT_EXTERNAL_DEVICE_NOT_DETECTED = -10;

    public static int init() {
        return VuforiaBase.progressiveInit();
    }

    public static void setInitParameters(Activity nActivity, int nFlags, String nLicenseKey) {
        VuforiaBase.privateSetInitParameters(nActivity, nFlags, nLicenseKey);
    }

    public static native boolean isInitialized();

    private static native void privateSetInitParameters(Activity var0, int var1, String var2);

    private static native int progressiveInit();

    public static native void deinit();

    public static native boolean requiresAlpha();

    public static native void onResume();

    public static native void onPause();

    public static native void onSurfaceCreated();

    public static native void onSurfaceChanged(int var0, int var1);
}

