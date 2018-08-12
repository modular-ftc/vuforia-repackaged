/*
 * Decompiled with CFR 0_132.
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
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

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

    public static boolean checkMinimumApiLevel(int apiLevel) {
        return Build.VERSION.SDK_INT >= apiLevel;
    }

    public static void sendKillSignal() {
        SystemTools.sendKillSignal(0, true);
    }

    public static void sendKillSignal(int errorCode) {
        SystemTools.sendKillSignal(errorCode, true);
    }

    public static void sendKillSignal(boolean enableLifecycleEvents) {
        SystemTools.sendKillSignal(0, enableLifecycleEvents);
    }

    public static void sendKillSignal(final int errorCode, final boolean enableLifecycleEvents) {
        final Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable(){

            @Override
            public void run() {
                if (enableLifecycleEvents) {
                    block6 : {
                        try {
                            Method method = activity.getClass().getDeclaredMethod("onPause", new Class[0]);
                            method.setAccessible(true);
                            method.invoke((Object)activity, new Object[0]);
                            method = activity.getClass().getDeclaredMethod("onDestroy", new Class[0]);
                            method.setAccessible(true);
                            method.invoke((Object)activity, new Object[0]);
                        }
                        catch (Exception e) {
                            SystemTools.logSystemError("Error attempting to call onPause and onDestroy, will proceed with exiting");
                            if (e == null || e.getCause() == null) break block6;
                            SystemTools.logSystemError(e.getCause().toString());
                            for (StackTraceElement i : e.getStackTrace()) {
                                SystemTools.logSystemError(i.toString());
                            }
                        }
                    }
                    try {
                        Thread.sleep(1000L);
                    }
                    catch (InterruptedException e) {
                        // empty catch block
                    }
                }
                System.exit(errorCode);
            }
        });
    }

    public static /* varargs */ Method retrieveClassMethod(Class<?> cls, String name, Class<?> ... parameterTypes) {
        Method classMethod = null;
        try {
            classMethod = cls.getMethod(name, parameterTypes);
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (classMethod != null) {
            // empty if block
        }
        return classMethod;
    }

    public static int getDeviceOrientation(Activity activity) {
        if (activity == null) {
            return 268455952;
        }
        Configuration config = activity.getResources().getConfiguration();
        Display display = ((WindowManager)activity.getSystemService("window")).getDefaultDisplay();
        int displayRotation = SystemTools.checkMinimumApiLevel(8) ? display.getRotation() : display.getOrientation();
        int activityOrientation = displayRotation == 0 ? 268455954 : (displayRotation == 1 ? 268455956 : (displayRotation == 2 ? 268455955 : (displayRotation == 3 ? 268455957 : 268455952)));
        return activityOrientation;
    }

    public static int getActivityOrientation(Activity activity) {
        if (activity == null) {
            return 268455952;
        }
        Configuration config = activity.getResources().getConfiguration();
        Display display = ((WindowManager)activity.getSystemService("window")).getDefaultDisplay();
        int displayRotation = SystemTools.checkMinimumApiLevel(8) ? display.getRotation() : display.getOrientation();
        int activityOrientation = 268455952;
        switch (config.orientation) {
            case 1: 
            case 3: {
                activityOrientation = displayRotation == 0 || displayRotation == 3 ? 268455954 : 268455955;
                break;
            }
            case 2: {
                activityOrientation = displayRotation == 0 || displayRotation == 1 ? 268455956 : 268455957;
                break;
            }
        }
        return activityOrientation;
    }

    public static String getNativeLibraryPath(Activity activity) {
        if (activity == null) {
            return null;
        }
        String path = null;
        try {
            ApplicationInfo appInfo = activity.getApplicationInfo();
            if (appInfo != null) {
                if (SystemTools.checkMinimumApiLevel(9)) {
                    path = appInfo.nativeLibraryDir;
                    if (path != null && path.length() > 0 && path.charAt(path.length() - 1) != '/') {
                        path = path + '/';
                    }
                } else {
                    path = "/data/data/" + activity.getPackageName() + "/lib/";
                }
            }
        }
        catch (Exception e) {
            return null;
        }
        return path;
    }

    public static int[] getActivitySize(Activity activity) {
        if (activity == null) {
            return null;
        }
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;
        if (screenWidth > 0 && screenHeight > 0) {
            int[] screenSize = new int[]{screenWidth, screenHeight};
            return screenSize;
        }
        return null;
    }

    public static float[] getDisplayDpi(Activity activity) {
        if (activity == null) {
            return null;
        }
        DisplayMetrics metrics = new DisplayMetrics();
        if (SystemTools.checkMinimumApiLevel(17)) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        }
        float xdpi = metrics.xdpi;
        float ydpi = metrics.ydpi;
        if (xdpi > 0.0f && ydpi > 0.0f) {
            float[] dpi = new float[]{xdpi, ydpi};
            return dpi;
        }
        return null;
    }

    public static int[] getDisplaySize(Activity activity) {
        if (activity == null) {
            return null;
        }
        Point displaySize = new Point();
        try {
            activity.getWindowManager().getDefaultDisplay().getRealSize(displaySize);
            if (displaySize.x > 0 && displaySize.y > 0) {
                int[] displaySizes = new int[2];
                int orientation = SystemTools.getActivityOrientation(activity);
                if (orientation == 268455954 || orientation == 268455955) {
                    displaySizes[0] = displaySize.y;
                    displaySizes[1] = displaySize.x;
                } else {
                    displaySizes[0] = displaySize.x;
                    displaySizes[1] = displaySize.y;
                }
                return displaySizes;
            }
        }
        catch (NoSuchMethodError nsme) {
            DebugLog.LOGE("SystemTools", "Display.getRealSize is not supported on this platform");
        }
        return null;
    }

}

