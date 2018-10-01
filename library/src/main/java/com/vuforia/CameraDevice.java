/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.CameraCalibration;
import com.vuforia.CameraField;
import com.vuforia.VideoMode;
import com.vuforia.Vuforia;
import com.vuforia.VuforiaJNI;

public class CameraDevice {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected CameraDevice(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(CameraDevice cameraDevice) {
        return cameraDevice == null ? 0L : cameraDevice.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_CameraDevice(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof CameraDevice) {
            bl = ((CameraDevice)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static CameraDevice getInstance() {
        if (!Vuforia.wasInitializedJava()) {
            throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
        }
        return new CameraDevice(VuforiaJNI.CameraDevice_getInstance(), false);
    }

    public boolean init(int n) {
        return VuforiaJNI.CameraDevice_init__SWIG_0(this.swigCPtr, this, n);
    }

    public boolean init() {
        return VuforiaJNI.CameraDevice_init__SWIG_1(this.swigCPtr, this);
    }

    public boolean deinit() {
        return VuforiaJNI.CameraDevice_deinit(this.swigCPtr, this);
    }

    public boolean start() {
        return VuforiaJNI.CameraDevice_start(this.swigCPtr, this);
    }

    public boolean stop() {
        return VuforiaJNI.CameraDevice_stop(this.swigCPtr, this);
    }

    public int getNumVideoModes() {
        return VuforiaJNI.CameraDevice_getNumVideoModes(this.swigCPtr, this);
    }

    public VideoMode getVideoMode(int n) {
        return new VideoMode(VuforiaJNI.CameraDevice_getVideoMode(this.swigCPtr, this, n), true);
    }

    public int getCameraDirection() {
        return VuforiaJNI.CameraDevice_getCameraDirection(this.swigCPtr, this);
    }

    public boolean selectVideoMode(int n) {
        return VuforiaJNI.CameraDevice_selectVideoMode(this.swigCPtr, this, n);
    }

    public CameraCalibration getCameraCalibration() {
        return new CameraCalibration(VuforiaJNI.CameraDevice_getCameraCalibration(this.swigCPtr, this), false);
    }

    public boolean setFlashTorchMode(boolean bl) {
        return VuforiaJNI.CameraDevice_setFlashTorchMode(this.swigCPtr, this, bl);
    }

    public boolean setFocusMode(int n) {
        return VuforiaJNI.CameraDevice_setFocusMode(this.swigCPtr, this, n);
    }

    public boolean setField(String string, String string2) {
        return VuforiaJNI.CameraDevice_setField__SWIG_0(this.swigCPtr, this, string, string2);
    }

    public boolean setField(String string, long l) {
        return VuforiaJNI.CameraDevice_setField__SWIG_1(this.swigCPtr, this, string, l);
    }

    public boolean setField(String string, float f) {
        return VuforiaJNI.CameraDevice_setField__SWIG_2(this.swigCPtr, this, string, f);
    }

    public boolean setField(String string, boolean bl) {
        return VuforiaJNI.CameraDevice_setField__SWIG_3(this.swigCPtr, this, string, bl);
    }

    public boolean setField(String string, long[] arrl) {
        return VuforiaJNI.CameraDevice_setField__SWIG_4(this.swigCPtr, this, string, arrl);
    }

    public int getNumFields() {
        return VuforiaJNI.CameraDevice_getNumFields(this.swigCPtr, this);
    }

    public boolean getCameraField(int n, CameraField cameraField) {
        return VuforiaJNI.CameraDevice_getCameraField(this.swigCPtr, this, n, CameraField.getCPtr(cameraField), cameraField);
    }

    public boolean getFieldInt64(String string, long[] arrl) {
        return VuforiaJNI.CameraDevice_getFieldInt64(this.swigCPtr, this, string, arrl);
    }

    public boolean getFieldFloat(String string, float[] arrf) {
        return VuforiaJNI.CameraDevice_getFieldFloat(this.swigCPtr, this, string, arrf);
    }

    public boolean getFieldBool(String string, boolean[] arrbl) {
        return VuforiaJNI.CameraDevice_getFieldBool(this.swigCPtr, this, string, arrbl);
    }

    public boolean getFieldInt64Range(String string, long[] arrl) {
        return VuforiaJNI.CameraDevice_getFieldInt64Range(this.swigCPtr, this, string, arrl);
    }

    public String getFieldString(String string) {
        return VuforiaJNI.CameraDevice_getFieldString(this.swigCPtr, this, string);
    }

    public static final class CAMERA_DIRECTION {
        public static final int CAMERA_DIRECTION_DEFAULT = 0;
        public static final int CAMERA_DIRECTION_BACK = 1;
        public static final int CAMERA_DIRECTION_FRONT = 2;

        private CAMERA_DIRECTION() {
        }
    }

    public static final class FOCUS_MODE {
        public static final int FOCUS_MODE_NORMAL = 0;
        public static final int FOCUS_MODE_TRIGGERAUTO = 1;
        public static final int FOCUS_MODE_CONTINUOUSAUTO = 2;
        public static final int FOCUS_MODE_INFINITY = 3;
        public static final int FOCUS_MODE_MACRO = 4;

        private FOCUS_MODE() {
        }
    }

    public static final class MODE {
        public static final int MODE_DEFAULT = -1;
        public static final int MODE_OPTIMIZE_SPEED = -2;
        public static final int MODE_OPTIMIZE_QUALITY = -3;

        private MODE() {
        }
    }

}

