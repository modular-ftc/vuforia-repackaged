/*
 * Decompiled with CFR 0_123.
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

    public HeadTransformModel(HeadTransformModel other) {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_1(HeadTransformModel.getCPtr(other), other), true);
    }

    public HeadTransformModel(Vec3F pivotPos) {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_2(Vec3F.getCPtr(pivotPos), pivotPos), true);
    }

    protected static long getCPtr(HeadTransformModel obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_HeadTransformModel(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
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

    public boolean setPivotPoint(Vec3F pivot) {
        return VuforiaJNI.HeadTransformModel_setPivotPoint(this.swigCPtr, this, Vec3F.getCPtr(pivot), pivot);
    }

    public Vec3F getPivotPoint() {
        return new Vec3F(VuforiaJNI.HeadTransformModel_getPivotPoint(this.swigCPtr, this), false);
    }
}

