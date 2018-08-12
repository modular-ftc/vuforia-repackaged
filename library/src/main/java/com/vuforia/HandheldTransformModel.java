/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class HandheldTransformModel
extends TransformModel {
    private long swigCPtr;

    protected HandheldTransformModel(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.HandheldTransformModel_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    public HandheldTransformModel() {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_0(), true);
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public HandheldTransformModel(HandheldTransformModel other) {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_1(HandheldTransformModel.getCPtr(other), other), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof HandheldTransformModel) {
            equal = ((HandheldTransformModel)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    public int getType() {
        return VuforiaJNI.HandheldTransformModel_getType(this.swigCPtr, this);
    }

    public HandheldTransformModel(Vec3F pivotPos) {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_2(Vec3F.getCPtr(pivotPos), pivotPos), true);
    }

    protected static long getCPtr(HandheldTransformModel obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_HandheldTransformModel(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean setPivotPoint(Vec3F pivot) {
        return VuforiaJNI.HandheldTransformModel_setPivotPoint(this.swigCPtr, this, Vec3F.getCPtr(pivot), pivot);
    }

    public Vec3F getPivotPoint() {
        return new Vec3F(VuforiaJNI.HandheldTransformModel_getPivotPoint(this.swigCPtr, this), false);
    }
}

