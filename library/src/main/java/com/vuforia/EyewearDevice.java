/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Device;
import com.vuforia.EyewearCalibrationProfileManager;
import com.vuforia.EyewearUserCalibrator;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class EyewearDevice
extends Device {
    private long swigCPtr;

    protected EyewearDevice(long l, boolean bl) {
        super(VuforiaJNI.EyewearDevice_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(EyewearDevice eyewearDevice) {
        return eyewearDevice == null ? 0L : eyewearDevice.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
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

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof EyewearDevice) {
            bl = ((EyewearDevice)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.EyewearDevice_getClassType(), true);
    }

    public boolean isSeeThru() {
        return VuforiaJNI.EyewearDevice_isSeeThru(this.swigCPtr, this);
    }

    public boolean isDualDisplay() {
        return VuforiaJNI.EyewearDevice_isDualDisplay(this.swigCPtr, this);
    }

    public boolean setDisplayExtended(boolean bl) {
        return VuforiaJNI.EyewearDevice_setDisplayExtended(this.swigCPtr, this, bl);
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

    public boolean setPredictiveTracking(boolean bl) {
        return VuforiaJNI.EyewearDevice_setPredictiveTracking(this.swigCPtr, this, bl);
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

