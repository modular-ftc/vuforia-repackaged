/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class EyewearCalibrationProfileManager {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected EyewearCalibrationProfileManager(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(EyewearCalibrationProfileManager obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_EyewearCalibrationProfileManager(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof EyewearCalibrationProfileManager) {
            equal = ((EyewearCalibrationProfileManager)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public long getMaxCount() {
        return VuforiaJNI.EyewearCalibrationProfileManager_getMaxCount(this.swigCPtr, this);
    }

    public long getUsedCount() {
        return VuforiaJNI.EyewearCalibrationProfileManager_getUsedCount(this.swigCPtr, this);
    }

    public boolean isProfileUsed(int profileID) {
        return VuforiaJNI.EyewearCalibrationProfileManager_isProfileUsed(this.swigCPtr, this, profileID);
    }

    public int getActiveProfile() {
        return VuforiaJNI.EyewearCalibrationProfileManager_getActiveProfile(this.swigCPtr, this);
    }

    public boolean setActiveProfile(int profileID) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setActiveProfile(this.swigCPtr, this, profileID);
    }

    public Matrix34F getCameraToEyePose(int profileID, int eyeID) {
        return new Matrix34F(VuforiaJNI.EyewearCalibrationProfileManager_getCameraToEyePose(this.swigCPtr, this, profileID, eyeID), true);
    }

    public Matrix34F getEyeProjection(int profileID, int eyeID) {
        return new Matrix34F(VuforiaJNI.EyewearCalibrationProfileManager_getEyeProjection(this.swigCPtr, this, profileID, eyeID), true);
    }

    public boolean setCameraToEyePose(int profileID, int eyeID, Matrix34F cameraToEyePose) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setCameraToEyePose(this.swigCPtr, this, profileID, eyeID, Matrix34F.getCPtr(cameraToEyePose), cameraToEyePose);
    }

    public boolean setEyeProjection(int profileID, int eyeID, Matrix34F eyeProjection) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setEyeProjection(this.swigCPtr, this, profileID, eyeID, Matrix34F.getCPtr(eyeProjection), eyeProjection);
    }

    public String getProfileName(int profileID) {
        short[] codes = VuforiaJNI.EyewearCalibrationProfileManager_getProfileName(this.swigCPtr, this, profileID);
        if (codes == null) {
            return null;
        }
        StringBuilder result = new StringBuilder(codes.length);
        for (short code : codes) {
            result.appendCodePoint(code);
        }
        return result.toString();
    }

    public boolean setProfileName(int profileID, String name) {
        return VuforiaJNI.EyewearCalibrationProfileManager_setProfileName(this.swigCPtr, this, profileID, Vuforia.convertStringToShortArray(name));
    }

    public boolean clearProfile(int profileID) {
        return VuforiaJNI.EyewearCalibrationProfileManager_clearProfile(this.swigCPtr, this, profileID);
    }
}

