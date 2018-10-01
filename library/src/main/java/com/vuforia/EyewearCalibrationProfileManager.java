/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Matrix34F;
import com.vuforia.Vuforia;
import com.vuforia.VuforiaJNI;

public class EyewearCalibrationProfileManager {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected EyewearCalibrationProfileManager(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(EyewearCalibrationProfileManager eyewearCalibrationProfileManager) {
        return eyewearCalibrationProfileManager == null ? 0L : eyewearCalibrationProfileManager.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_EyewearCalibrationProfileManager(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof EyewearCalibrationProfileManager) {
            bl = ((EyewearCalibrationProfileManager)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public long getMaxCount() {
        return VuforiaJNI.EyewearCalibrationProfileManager_getMaxCount(this.swigCPtr, this);
    }

    public long getUsedCount() {
        return VuforiaJNI.EyewearCalibrationProfileManager_getUsedCount(this.swigCPtr, this);
    }

    public boolean isProfileUsed(int n) {
        return VuforiaJNI.EyewearCalibrationProfileManager_isProfileUsed(this.swigCPtr, this, n);
    }

    public int getActiveProfile() {
        return VuforiaJNI.EyewearCalibrationProfileManager_getActiveProfile(this.swigCPtr, this);
    }

    public boolean setActiveProfile(int n) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setActiveProfile(this.swigCPtr, this, n);
    }

    public Matrix34F getCameraToEyePose(int n, int n2) {
        return new Matrix34F(VuforiaJNI.EyewearCalibrationProfileManager_getCameraToEyePose(this.swigCPtr, this, n, n2), true);
    }

    public Matrix34F getEyeProjection(int n, int n2) {
        return new Matrix34F(VuforiaJNI.EyewearCalibrationProfileManager_getEyeProjection(this.swigCPtr, this, n, n2), true);
    }

    public boolean setCameraToEyePose(int n, int n2, Matrix34F matrix34F) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setCameraToEyePose(this.swigCPtr, this, n, n2, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public boolean setEyeProjection(int n, int n2, Matrix34F matrix34F) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setEyeProjection(this.swigCPtr, this, n, n2, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public String getProfileName(int n) {
        short[] arrs = VuforiaJNI.EyewearCalibrationProfileManager_getProfileName(this.swigCPtr, this, n);
        if (arrs == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(arrs.length);
        for (short s : arrs) {
            stringBuilder.appendCodePoint(s);
        }
        return stringBuilder.toString();
    }

    public boolean setProfileName(int n, String string) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setProfileName(this.swigCPtr, this, n, Vuforia.convertStringToShortArray(string));
    }

    public boolean clearProfile(int n) {
        return VuforiaJNI.EyewearCalibrationProfileManager_clearProfile(this.swigCPtr, this, n);
    }
}

