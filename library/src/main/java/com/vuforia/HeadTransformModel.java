/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class HeadTransformModel
extends TransformModel {
    private long swigCPtr;

    protected HeadTransformModel(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.HeadTransformModel_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    public HeadTransformModel() {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_0(), true);
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public HeadTransformModel(HeadTransformModel other) {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_1(HeadTransformModel.getCPtr(other), other), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof HeadTransformModel) {
            equal = ((HeadTransformModel)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    public int getType() {
        return VuforiaJNI.HeadTransformModel_getType(this.swigCPtr, this);
    }

    public HeadTransformModel(Vec3F pivotPos) {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_2(Vec3F.getCPtr(pivotPos), pivotPos), true);
    }

    protected static long getCPtr(HeadTransformModel obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_HeadTransformModel(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean setPivotPoint(Vec3F pivot) {
        return VuforiaJNI.HeadTransformModel_setPivotPoint(this.swigCPtr, this, Vec3F.getCPtr(pivot), pivot);
    }

    public Vec3F getPivotPoint() {
        return new Vec3F(VuforiaJNI.HeadTransformModel_getPivotPoint(this.swigCPtr, this), false);
    }
}

