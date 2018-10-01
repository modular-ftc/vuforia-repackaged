/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.EyewearCalibrationReading;
import com.vuforia.Matrix34F;
import com.vuforia.VuforiaJNI;

public class EyewearUserCalibrator {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected EyewearUserCalibrator(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(EyewearUserCalibrator eyewearUserCalibrator) {
        return eyewearUserCalibrator == null ? 0L : eyewearUserCalibrator.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_EyewearUserCalibrator(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean getProjectionMatrix(EyewearCalibrationReading[] arreyewearCalibrationReading, Matrix34F matrix34F, Matrix34F matrix34F2) {
        if (matrix34F == null || matrix34F2 == null) {
            throw new NullPointerException("Matrix34F argument is null");
        }
        return this.getProjectionMatrix(arreyewearCalibrationReading, arreyewearCalibrationReading.length, matrix34F, matrix34F2);
    }

    public int getProjectionMatrices(EyewearCalibrationReading[] arreyewearCalibrationReading, EyewearCalibrationReading[] arreyewearCalibrationReading2, Matrix34F matrix34F, Matrix34F matrix34F2, Matrix34F matrix34F3, Matrix34F matrix34F4) {
        if (matrix34F == null || matrix34F2 == null || matrix34F3 == null || matrix34F4 == null) {
            throw new NullPointerException("Matrix34F argument is null");
        }
        return this.getProjectionMatrices(arreyewearCalibrationReading, arreyewearCalibrationReading.length, arreyewearCalibrationReading2, arreyewearCalibrationReading2.length, matrix34F, matrix34F2, matrix34F3, matrix34F4);
    }

    public boolean init(long l, long l2, float f, float f2) {
        return VuforiaJNI.EyewearUserCalibrator_init(this.swigCPtr, this, l, l2, f, f2);
    }

    public float getMinScaleHint() {
        return VuforiaJNI.EyewearUserCalibrator_getMinScaleHint(this.swigCPtr, this);
    }

    public float getMaxScaleHint() {
        return VuforiaJNI.EyewearUserCalibrator_getMaxScaleHint(this.swigCPtr, this);
    }

    public float getDrawingAspectRatio(long l, long l2) {
        return VuforiaJNI.EyewearUserCalibrator_getDrawingAspectRatio(this.swigCPtr, this, l, l2);
    }

    public boolean isStereoStretched() {
        return VuforiaJNI.EyewearUserCalibrator_isStereoStretched(this.swigCPtr, this);
    }

    private boolean getProjectionMatrix(EyewearCalibrationReading[] arreyewearCalibrationReading, int n, Matrix34F matrix34F, Matrix34F matrix34F2) {
        return VuforiaJNI.EyewearUserCalibrator_getProjectionMatrix(this.swigCPtr, this, EyewearCalibrationReading.cArrayUnwrap(arreyewearCalibrationReading), n, Matrix34F.getCPtr(matrix34F), matrix34F, Matrix34F.getCPtr(matrix34F2), matrix34F2);
    }

    private int getProjectionMatrices(EyewearCalibrationReading[] arreyewearCalibrationReading, int n, EyewearCalibrationReading[] arreyewearCalibrationReading2, int n2, Matrix34F matrix34F, Matrix34F matrix34F2, Matrix34F matrix34F3, Matrix34F matrix34F4) {
        return VuforiaJNI.EyewearUserCalibrator_getProjectionMatrices(this.swigCPtr, this, EyewearCalibrationReading.cArrayUnwrap(arreyewearCalibrationReading), n, EyewearCalibrationReading.cArrayUnwrap(arreyewearCalibrationReading2), n2, Matrix34F.getCPtr(matrix34F), matrix34F, Matrix34F.getCPtr(matrix34F2), matrix34F2, Matrix34F.getCPtr(matrix34F3), matrix34F3, Matrix34F.getCPtr(matrix34F4), matrix34F4);
    }

    public static final class CONSISTENCY {
        public static final int NONE = 0;
        public static final int VERY_BAD = 1;
        public static final int BAD = 2;
        public static final int OK = 3;
        public static final int GOOD = 4;
        public static final int CONSISTENCY_LEN = 5;
    }

}

