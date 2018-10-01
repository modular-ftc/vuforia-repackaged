/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Matrix34F;
import com.vuforia.VuforiaJNI;

public class EyewearCalibrationReading {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected EyewearCalibrationReading(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(EyewearCalibrationReading eyewearCalibrationReading) {
        return eyewearCalibrationReading == null ? 0L : eyewearCalibrationReading.swigCPtr;
    }

    protected void finalize() {
        this.delete();
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

    protected static long[] cArrayUnwrap(EyewearCalibrationReading[] arreyewearCalibrationReading) {
        long[] arrl = new long[arreyewearCalibrationReading.length];
        for (int i = 0; i < arreyewearCalibrationReading.length; ++i) {
            arrl[i] = EyewearCalibrationReading.getCPtr(arreyewearCalibrationReading[i]);
        }
        return arrl;
    }

    protected static EyewearCalibrationReading[] cArrayWrap(long[] arrl, boolean bl) {
        EyewearCalibrationReading[] arreyewearCalibrationReading = new EyewearCalibrationReading[arrl.length];
        for (int i = 0; i < arrl.length; ++i) {
            arreyewearCalibrationReading[i] = new EyewearCalibrationReading(arrl[i], bl);
        }
        return arreyewearCalibrationReading;
    }

    public void setPose(Matrix34F matrix34F) {
        VuforiaJNI.EyewearCalibrationReading_Pose_set(this.swigCPtr, this, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public Matrix34F getPose() {
        long l = VuforiaJNI.EyewearCalibrationReading_Pose_get(this.swigCPtr, this);
        return l == 0L ? null : new Matrix34F(l, false);
    }

    public void setScale(float f) {
        VuforiaJNI.EyewearCalibrationReading_Scale_set(this.swigCPtr, this, f);
    }

    public float getScale() {
        return VuforiaJNI.EyewearCalibrationReading_Scale_get(this.swigCPtr, this);
    }

    public void setCenterX(float f) {
        VuforiaJNI.EyewearCalibrationReading_CenterX_set(this.swigCPtr, this, f);
    }

    public float getCenterX() {
        return VuforiaJNI.EyewearCalibrationReading_CenterX_get(this.swigCPtr, this);
    }

    public void setCenterY(float f) {
        VuforiaJNI.EyewearCalibrationReading_CenterY_set(this.swigCPtr, this, f);
    }

    public float getCenterY() {
        return VuforiaJNI.EyewearCalibrationReading_CenterY_get(this.swigCPtr, this);
    }

    public void setType(int n) {
        VuforiaJNI.EyewearCalibrationReading_Type_set(this.swigCPtr, this, n);
    }

    public int getType() {
        return VuforiaJNI.EyewearCalibrationReading_Type_get(this.swigCPtr, this);
    }

    public EyewearCalibrationReading() {
        this(VuforiaJNI.new_EyewearCalibrationReading(), true);
    }

    public static final class AlignmentType {
        public static final int RECTANGLE = 0;
        public static final int HORIZONTAL_LINE = 1;
        public static final int VERTICAL_LINE = 2;
    }

}

