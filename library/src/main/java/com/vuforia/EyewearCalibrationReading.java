/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class EyewearCalibrationReading {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected EyewearCalibrationReading(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public EyewearCalibrationReading() {
        this(VuforiaJNI.new_EyewearCalibrationReading(), true);
    }

    protected static long getCPtr(EyewearCalibrationReading obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected static long[] cArrayUnwrap(EyewearCalibrationReading[] arrayWrapper) {
        long[] cArray = new long[arrayWrapper.length];
        for (int i = 0; i < arrayWrapper.length; ++i) {
            cArray[i] = EyewearCalibrationReading.getCPtr(arrayWrapper[i]);
        }
        return cArray;
    }

    protected static EyewearCalibrationReading[] cArrayWrap(long[] cArray, boolean cMemoryOwn) {
        EyewearCalibrationReading[] arrayWrapper = new EyewearCalibrationReading[cArray.length];
        for (int i = 0; i < cArray.length; ++i) {
            arrayWrapper[i] = new EyewearCalibrationReading(cArray[i], cMemoryOwn);
        }
        return arrayWrapper;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_EyewearCalibrationReading(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public Matrix34F getPose() {
        long cPtr = VuforiaJNI.EyewearCalibrationReading_Pose_get(this.swigCPtr, this);
        return cPtr == 0L ? null : new Matrix34F(cPtr, false);
    }

    public void setPose(Matrix34F value) {
        VuforiaJNI.EyewearCalibrationReading_Pose_set(this.swigCPtr, this, Matrix34F.getCPtr(value), value);
    }

    public float getScale() {
        return VuforiaJNI.EyewearCalibrationReading_Scale_get(this.swigCPtr, this);
    }

    public void setScale(float value) {
        VuforiaJNI.EyewearCalibrationReading_Scale_set(this.swigCPtr, this, value);
    }

    public float getCenterX() {
        return VuforiaJNI.EyewearCalibrationReading_CenterX_get(this.swigCPtr, this);
    }

    public void setCenterY(float value) {
        VuforiaJNI.EyewearCalibrationReading_CenterY_set(this.swigCPtr, this, value);
    }

    public void setCenterX(float value) {
        VuforiaJNI.EyewearCalibrationReading_CenterX_set(this.swigCPtr, this, value);
    }

    public float getCenterY() {
        return VuforiaJNI.EyewearCalibrationReading_CenterY_get(this.swigCPtr, this);
    }
}

