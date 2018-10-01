/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.vuforia.ar.pl.DebugLog;
import java.lang.reflect.Method;

public class SystemTools {
    public static final int AR_ERROR_NONE = 0;
    public static final int AR_ERROR_UNKNOWN = 1;
    public static final int AR_ERROR_INVALID_VALUE = 2;
    public static final int AR_ERROR_INVALID_ENUM = 3;
    public static final int AR_ERROR_INVALID_HANDLE = 4;
    public static final int AR_ERROR_INVALID_OPERATION = 5;
    public static final int AR_ERROR_OPERATION_FAILED = 6;
    public static final int AR_ERROR_OPERATION_CANCELED = 7;
    public static final int AR_ERROR_OPERATION_TIMEOUT = 8;
    public static final int AR_DEVICE_ORIENTATION_UNKNOWN = 268455952;
    public static final int AR_DEVICE_ORIENTATION_0 = 268455954;
    public static final int AR_DEVICE_ORIENTATION_180 = 268455955;
    public static final int AR_DEVICE_ORIENTATION_90 = 268455956;
    public static final int AR_DEVICE_ORIENTATION_270 = 268455957;
    public static final int AR_VIDEOTEXTURE_ROTATION_UNKNOWN = 268455952;
    public static final int AR_RENDERING_TEXTURE_ROTATION_AUTO = 268455953;
    public static final int AR_RENDERING_TEXTURE_ROTATION_PORTRAIT = 268455954;
    public static final int AR_RENDERING_TEXTURE_ROTATION_PORTRAIT_UPSIDEDOWN = 268455955;
    public static final int AR_RENDERING_TEXTURE_ROTATION_LANDSCAPE_LEFT = 268455956;
    public static final int AR_RENDERING_TEXTURE_ROTATION_LANDSCAPE_RIGHT = 268455957;
    private static final String MODULENAME = "SystemTools";

    public static native void setSystemErrorCode(int var0);

    public static native void logSystemError(String var0);

    public static native Activity getActivityFromNative();

    public static boolean checkMinimumApiLevel(int n) {
        return Build.VERSION.SDK_INT >= n;
    }

    public static void sendKillSignal(final int n) {
        final Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable(){

            @Override
            public void run() {
                activity.setResult(n);
                activity.finish();
            }
        });
    }

    public static /* varargs */ Method retrieveClassMethod(Class<?> class_, String string, Class<?> ... arrclass) {
        Method method = null;
        try {
            method = class_.getMethod(string, arrclass);
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (method != null) {
            // empty if block
        }
        return method;
    }

    public static int getDeviceOrientation(Activity activity) {
        if (activity == null) {
            return 268455952;
        }
        Configuration configuration = activity.getResources().getConfiguration();
        Display display = ((WindowManager)activity.getSystemService("window")).getDefaultDisplay();
        int n = SystemTools.checkMinimumApiLevel(8) ? display.getRotation() : display.getOrientation();
        int n2 = n == 0 ? 268455954 : (n == 1 ? 268455956 : (n == 2 ? 268455955 : (n == 3 ? 268455957 : 268455952)));
        return n2;
    }

    public static int getActivityOrientation(Activity activity) {
        if (activity == null) {
            return 268455952;
        }
        Configuration configuration = activity.getResources().getConfiguration();
        Display display = ((WindowManager)activity.getSystemService("window")).getDefaultDisplay();
        int n = SystemTools.checkMinimumApiLevel(8) ? display.getRotation() : display.getOrientation();
        int n2 = 268455952;
        switch (configuration.orientation) {
            case 1: 
            case 3: {
                n2 = n == 0 || n == 3 ? 268455954 : 268455955;
                break;
            }
            case 2: {
                n2 = n == 0 || n == 1 ? 268455956 : 268455957;
                break;
            }
        }
        return n2;
    }

    public static String getNativeLibraryPath(Activity activity) {
        if (activity == null) {
            return null;
        }
        String string = null;
        try {
            ApplicationInfo applicationInfo = activity.getApplicationInfo();
            if (applicationInfo != null) {
                if (SystemTools.checkMinimumApiLevel(9)) {
                    string = applicationInfo.nativeLibraryDir;
                    if (string != null && string.length() > 0 && string.charAt(string.length() - 1) != '/') {
                        string = string + '/';
                    }
                } else {
                    string = "/data/data/" + activity.getPackageName() + "/lib/";
                }
            }
        }
        catch (Exception exception) {
            return null;
        }
        return string;
    }

    public static int[] getActivitySize(Activity activity) {
        if (activity == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int n = displayMetrics.widthPixels;
        int n2 = displayMetrics.heightPixels;
        if (n > 0 && n2 > 0) {
            int[] arrn = new int[]{n, n2};
            return arrn;
        }
        return null;
    }

    public static float[] getDisplayDpi(Activity activity) {
        if (activity == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (SystemTools.checkMinimumApiLevel(17)) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        float f = displayMetrics.xdpi;
        float f2 = displayMetrics.ydpi;
        if (f > 0.0f && f2 > 0.0f) {
            float[] arrf = new float[]{f, f2};
            return arrf;
        }
        return null;
    }

    public static int[] getDisplaySize(Activity activity) {
        if (activity == null) {
            return null;
        }
        Point point = new Point();
        try {
            activity.getWindowManager().getDefaultDisplay().getRealSize(point);
            if (point.x > 0 && point.y > 0) {
                int[] arrn = new int[2];
                if (point.y > point.x) {
                    arrn[0] = point.y;
                    arrn[1] = point.x;
                } else {
                    arrn[0] = point.x;
                    arrn[1] = point.y;
                }
                return arrn;
            }
        }
        catch (NoSuchMethodError noSuchMethodError) {
            DebugLog.LOGE("SystemTools", "Display.getRealSize is not supported on this platform");
        }
        return null;
    }

}

