/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.vuforia;

import android.app.Activity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Vuforia
extends VuforiaBase
implements VuforiaConstants {
    protected static Map<Integer, Object> sUserDataMap;
    private static boolean initializedJava = false;
    private static UpdateCallback sUpdateCallback;
    private static UpdateCallbackInterface sUpdateCallbackInterface;

    static {
        if (!Vuforia.loadLibrary("Vuforia")) {
            System.exit(1);
        }
        sUpdateCallback = null;
        sUpdateCallbackInterface = null;
        sUserDataMap = new ConcurrentHashMap<Integer, Object>(16, 0.75f, 4);
    }

    protected static boolean wasInitializedJava() {
        return initializedJava;
    }

    protected static void setHint() {
        Vuforia.setHint(-858996736, 2796202);
    }

    public static void setInitParameters(Activity activity, int flags, String licenseKey) {
        if (!initializedJava) {
            Vuforia.setHint();
            initializedJava = true;
        }
        VuforiaBase.setInitParameters(activity, flags, licenseKey);
    }

    private static boolean loadLibrary(String nLibName) {
        try {
            System.loadLibrary(nLibName);
            System.out.println("Native library lib" + nLibName + ".so loaded");
            return true;
        }
        catch (UnsatisfiedLinkError ulee) {
            System.err.println("The library lib" + nLibName + ".so could not be loaded");
        }
        catch (SecurityException se) {
            System.err.println("The library lib" + nLibName + ".so was not allowed to be loaded");
        }
        return false;
    }

    public static boolean isInitialized() {
        return VuforiaBase.isInitialized();
    }

    public static void deinit() {
        VuforiaBase.deinit();
    }

    protected static UpdateCallback registerLocalReference(UpdateCallbackInterface cbi) {
        if (cbi == null) {
            sUpdateCallback = null;
            sUpdateCallbackInterface = null;
            return null;
        }
        sUpdateCallbackInterface = cbi;
        sUpdateCallback = new UpdateCallback(){

            @Override
            public void Vuforia_onUpdate(State s) {
                sUpdateCallbackInterface.Vuforia_onUpdate(s);
                s.delete();
            }
        };
        return sUpdateCallback;
    }

    protected static short[] convertStringToShortArray(String str) {
        int codePoint;
        if (str == null) {
            return null;
        }
        short[] codes = new short[str.codePointCount(0, str.length()) + 1];
        int idx = 0;
        int length = str.length();
        for (int offset = 0; offset < length; offset += Character.charCount((int)codePoint)) {
            codePoint = str.codePointAt(offset);
            if (codePoint > 65535) {
                codes[idx++] = (short)(codePoint >> 16);
            }
            codes[idx++] = (short)codePoint;
        }
        codes[codes.length - 1] = 0;
        return codes;
    }

    protected static boolean updateUserDataMap(Integer trackableId, Object userData) {
        if (trackableId == null) {
            return false;
        }
        if (userData == null) {
            sUserDataMap.remove(trackableId);
        } else {
            sUserDataMap.put(trackableId, userData);
        }
        return true;
    }

    protected static Object retreiveFromUserDataMap(Integer trackableId) {
        if (!sUserDataMap.containsKey(trackableId)) {
            return null;
        }
        return sUserDataMap.get(trackableId);
    }

    public static boolean setHint(long hint, int value) {
        return VuforiaJNI.setHint(hint, value);
    }

    public static void registerCallback(UpdateCallbackInterface object) {
        VuforiaJNI.registerCallback(UpdateCallback.getCPtr(Vuforia.registerLocalReference(object)), sUpdateCallback);
    }

    public static boolean setFrameFormat(int format, boolean enabled) {
        return VuforiaJNI.setFrameFormat(format, enabled);
    }

    public static int getBitsPerPixel(int format) {
        return VuforiaJNI.getBitsPerPixel(format);
    }

    public static boolean requiresAlpha() {
        return VuforiaJNI.requiresAlpha();
    }

    public static int getBufferSize(int width, int height, int format) {
        return VuforiaJNI.getBufferSize(width, height, format);
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

    public static void onSurfaceChanged(int width, int height) {
        VuforiaJNI.onSurfaceChanged(width, height);
    }

    public static String getLibraryVersion() {
        return VuforiaJNI.getLibraryVersion();
    }

    public static interface UpdateCallbackInterface {
        public void Vuforia_onUpdate(State var1);
    }

}

