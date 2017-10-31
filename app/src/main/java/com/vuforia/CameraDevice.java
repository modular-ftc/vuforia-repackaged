/*
 * Decompiled with CFR 0_123.
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

    protected CameraDevice(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(CameraDevice obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_CameraDevice(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof CameraDevice) {
            equal = ((CameraDevice)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static CameraDevice getInstance() {
        if (!Vuforia.wasInitializedJava()) {
            throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
        }
        return new CameraDevice(VuforiaJNI.CameraDevice_getInstance(), false);
    }

    public boolean init(int camera) {
        return VuforiaJNI.CameraDevice_init__SWIG_0(this.swigCPtr, this, camera);
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

    public VideoMode getVideoMode(int nIndex) {
        return new VideoMode(VuforiaJNI.CameraDevice_getVideoMode(this.swigCPtr, this, nIndex), true);
    }

    public int getCameraDirection() {
        return VuforiaJNI.CameraDevice_getCameraDirection(this.swigCPtr, this);
    }

    public boolean selectVideoMode(int index) {
        return VuforiaJNI.CameraDevice_selectVideoMode(this.swigCPtr, this, index);
    }

    public CameraCalibration getCameraCalibration() {
        return new CameraCalibration(VuforiaJNI.CameraDevice_getCameraCalibration(this.swigCPtr, this), false);
    }

    public boolean setFlashTorchMode(boolean on) {
        return VuforiaJNI.CameraDevice_setFlashTorchMode(this.swigCPtr, this, on);
    }

    public boolean setFocusMode(int focusMode) {
        return VuforiaJNI.CameraDevice_setFocusMode(this.swigCPtr, this, focusMode);
    }

    public boolean setField(String key, String value) {
        return VuforiaJNI.CameraDevice_setField__SWIG_0(this.swigCPtr, this, key, value);
    }

    public boolean setField(String key, long value) {
        return VuforiaJNI.CameraDevice_setField__SWIG_1(this.swigCPtr, this, key, value);
    }

    public boolean setField(String key, float value) {
        return VuforiaJNI.CameraDevice_setField__SWIG_2(this.swigCPtr, this, key, value);
    }

    public boolean setField(String key, boolean value) {
        return VuforiaJNI.CameraDevice_setField__SWIG_3(this.swigCPtr, this, key, value);
    }

    public boolean setField(String key, long[] intRange) {
        return VuforiaJNI.CameraDevice_setField__SWIG_4(this.swigCPtr, this, key, intRange);
    }

    public int getNumFields() {
        return VuforiaJNI.CameraDevice_getNumFields(this.swigCPtr, this);
    }

    public boolean getCameraField(int index, CameraField field) {
        return VuforiaJNI.CameraDevice_getCameraField(this.swigCPtr, this, index, CameraField.getCPtr(field), field);
    }

    public boolean getFieldString(String key, String value, long maxlength) {
        return VuforiaJNI.CameraDevice_getFieldString(this.swigCPtr, this, key, value, maxlength);
    }

    public boolean getFieldInt64(String key, long[] value) {
        return VuforiaJNI.CameraDevice_getFieldInt64(this.swigCPtr, this, key, value);
    }

    public boolean getFieldFloat(String key, float[] value) {
        return VuforiaJNI.CameraDevice_getFieldFloat(this.swigCPtr, this, key, value);
    }

    public boolean getFieldBool(String key, boolean[] value) {
        return VuforiaJNI.CameraDevice_getFieldBool(this.swigCPtr, this, key, value);
    }

    public boolean getFieldInt64Range(String key, long[] intRange) {
        return VuforiaJNI.CameraDevice_getFieldInt64Range(this.swigCPtr, this, key, intRange);
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

