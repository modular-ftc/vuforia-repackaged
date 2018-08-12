/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class EyewearDevice
extends Device {
    private long swigCPtr;

    protected EyewearDevice(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.EyewearDevice_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(EyewearDevice obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.EyewearDevice_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof EyewearDevice) {
            equal = ((EyewearDevice)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_EyewearDevice(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isSeeThru() {
        return VuforiaJNI.EyewearDevice_isSeeThru(this.swigCPtr, this);
    }

    public boolean isDualDisplay() {
        return VuforiaJNI.EyewearDevice_isDualDisplay(this.swigCPtr, this);
    }

    public boolean setDisplayExtended(boolean enable) {
        return VuforiaJNI.EyewearDevice_setDisplayExtended(this.swigCPtr, this, enable);
    }

    public boolean isDisplayExtended() {
        return VuforiaJNI.EyewearDevice_isDisplayExtended(this.swigCPtr, this);
    }

    public boolean isDisplayExtendedGLOnly() {
        return VuforiaJNI.EyewearDevice_isDisplayExtendedGLOnly(this.swigCPtr, this);
    }

    public int getScreenOrientation() {
        return VuforiaJNI.EyewearDevice_getScreenOrientation(this.swigCPtr, this);
    }

    public boolean setPredictiveTracking(boolean enable) {
        return VuforiaJNI.EyewearDevice_setPredictiveTracking(this.swigCPtr, this, enable);
    }

    public boolean isPredictiveTrackingEnabled() {
        return VuforiaJNI.EyewearDevice_isPredictiveTrackingEnabled(this.swigCPtr, this);
    }

    public EyewearCalibrationProfileManager getCalibrationProfileManager() {
        return new EyewearCalibrationProfileManager(VuforiaJNI.EyewearDevice_getCalibrationProfileManager(this.swigCPtr, this), false);
    }

    public EyewearUserCalibrator getUserCalibrator() {
        return new EyewearUserCalibrator(VuforiaJNI.EyewearDevice_getUserCalibrator(this.swigCPtr, this), false);
    }

    public static final class ORIENTATION {
        public static final int ORIENTATION_UNDEFINED = 0;
        public static final int ORIENTATION_PORTRAIT = 1;
        public static final int ORIENTATION_LANDSCAPE_LEFT = 2;
        public static final int ORIENTATION_LANDSCAPE_RIGHT = 3;
    }

}

