/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Vec2F;
import com.vuforia.Vec4F;
import com.vuforia.VuforiaJNI;

public class CameraCalibration {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected CameraCalibration(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(CameraCalibration cameraCalibration) {
        return cameraCalibration == null ? 0L : cameraCalibration.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_CameraCalibration(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof CameraCalibration) {
            bl = ((CameraCalibration)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Vec2F getSize() {
        return new Vec2F(VuforiaJNI.CameraCalibration_getSize(this.swigCPtr, this), true);
    }

    public Vec2F getFocalLength() {
        return new Vec2F(VuforiaJNI.CameraCalibration_getFocalLength(this.swigCPtr, this), true);
    }

    public Vec2F getPrincipalPoint() {
        return new Vec2F(VuforiaJNI.CameraCalibration_getPrincipalPoint(this.swigCPtr, this), true);
    }

    public Vec4F getDistortionParameters() {
        return new Vec4F(VuforiaJNI.CameraCalibration_getDistortionParameters(this.swigCPtr, this), true);
    }

    public Vec2F getFieldOfViewRads() {
        return new Vec2F(VuforiaJNI.CameraCalibration_getFieldOfViewRads(this.swigCPtr, this), true);
    }
}

