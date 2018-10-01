/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.vuforia;

import android.app.Activity;
import com.vuforia.State;
import com.vuforia.UpdateCallback;
import com.vuforia.VuforiaJNI;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Vuforia {
    public static final int GL_20 = 1;
    public static final int GL_30 = 8;
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
    private static boolean initializedJava = false;
    private static UpdateCallback sUpdateCallback;
    private static UpdateCallbackInterface sUpdateCallbackInterface;
    protected static Map<Integer, Object> sUserDataMap;

    protected static short[] convertStringToShortArray(String string) {
        int n;
        if (string == null) {
            return null;
        }
        short[] arrs = new short[string.codePointCount(0, string.length()) + 1];
        int n2 = 0;
        int n3 = string.length();
        for (int i = 0; i < n3; i += Character.charCount((int)n)) {
            n = string.codePointAt(i);
            if (n > 65535) {
                arrs[n2++] = (short)(n >> 16);
            }
            arrs[n2++] = (short)n;
        }
        arrs[arrs.length - 1] = 0;
        return arrs;
    }

    protected static boolean wasInitializedJava() {
        return initializedJava;
    }

    protected static void setHint() {
        Vuforia.setHint(-858996736L, 2796202);
    }

    private static native void privateSetInitParameters(Activity var0, int var1, String var2);

    public static void setInitParameters(Activity activity, int n, String string) {
        if (!initializedJava) {
            Vuforia.setHint();
            initializedJava = true;
        }
        Vuforia.privateSetInitParameters(activity, n, string);
    }

    private static boolean loadLibrary(String string) {
        try {
            System.loadLibrary(string);
            System.out.println("Native library lib" + string + ".so loaded");
            return true;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            System.err.println("The library lib" + string + ".so could not be loaded");
        }
        catch (SecurityException securityException) {
            System.err.println("The library lib" + string + ".so was not allowed to be loaded");
        }
        return false;
    }

    protected static UpdateCallback registerLocalReference(UpdateCallbackInterface updateCallbackInterface) {
        if (updateCallbackInterface == null) {
            sUpdateCallback = null;
            sUpdateCallbackInterface = null;
            return null;
        }
        sUpdateCallbackInterface = updateCallbackInterface;
        sUpdateCallback = new UpdateCallback(){

            @Override
            public void Vuforia_onUpdate(State state) {
                sUpdateCallbackInterface.Vuforia_onUpdate(state);
                state.delete();
            }
        };
        return sUpdateCallback;
    }

    protected static boolean updateUserDataMap(Integer n, Object object) {
        if (n == null) {
            return false;
        }
        if (object == null) {
            sUserDataMap.remove(n);
        } else {
            sUserDataMap.put(n, object);
        }
        return true;
    }

    protected static Object retreiveFromUserDataMap(Integer n) {
        if (!sUserDataMap.containsKey(n)) {
            return null;
        }
        return sUserDataMap.get(n);
    }

    public static int init() {
        return VuforiaJNI.init();
    }

    public static boolean isInitialized() {
        return VuforiaJNI.isInitialized();
    }

    public static void deinit() {
        VuforiaJNI.deinit();
    }

    public static boolean setHint(long l, int n) {
        return VuforiaJNI.setHint(l, n);
    }

    public static void registerCallback(UpdateCallbackInterface updateCallbackInterface) {
        VuforiaJNI.registerCallback(UpdateCallback.getCPtr(Vuforia.registerLocalReference(updateCallbackInterface)), sUpdateCallback);
    }

    public static boolean setFrameFormat(int n, boolean bl) {
        return VuforiaJNI.setFrameFormat(n, bl);
    }

    public static int getBitsPerPixel(int n) {
        return VuforiaJNI.getBitsPerPixel(n);
    }

    public static boolean requiresAlpha() {
        return VuforiaJNI.requiresAlpha();
    }

    public static int getBufferSize(int n, int n2, int n3) {
        return VuforiaJNI.getBufferSize(n, n2, n3);
    }

    public static void onResume() {
        VuforiaJNI.onResume();
    }

    public static void onPause() {
        VuforiaJNI.onPause();
    }

    public static void onSurfaceCreated() {
        VuforiaJNI.onSurfaceCreated();
    }

    public static void onSurfaceChanged(int n, int n2) {
        VuforiaJNI.onSurfaceChanged(n, n2);
    }

    public static String getLibraryVersion() {
        return VuforiaJNI.getLibraryVersion();
    }

    static {
        if (!Vuforia.loadLibrary("Vuforia")) {
            System.exit(1);
        }
        sUpdateCallback = null;
        sUpdateCallbackInterface = null;
        sUserDataMap = new ConcurrentHashMap<Integer, Object>(16, 0.75f, 4);
    }

    public static interface UpdateCallbackInterface {
        public void Vuforia_onUpdate(State var1);
    }

}

