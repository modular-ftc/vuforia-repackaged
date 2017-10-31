/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.TransformModel;
import com.vuforia.Vec3F;
import com.vuforia.VuforiaJNI;

public class HandheldTransformModel
extends TransformModel {
    private long swigCPtr;

    protected HandheldTransformModel(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.HandheldTransformModel_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(HandheldTransformModel obj) {
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
                VuforiaJNI.delete_HandheldTransformModel(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
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

    public HandheldTransformModel() {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_0(), true);
    }

    public HandheldTransformModel(HandheldTransformModel other) {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_1(HandheldTransformModel.getCPtr(other), other), true);
    }

    public HandheldTransformModel(Vec3F pivotPos) {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_2(Vec3F.getCPtr(pivotPos), pivotPos), true);
    }

    public boolean setPivotPoint(Vec3F pivot) {
        return VuforiaJNI.HandheldTransformModel_setPivotPoint(this.swigCPtr, this, Vec3F.getCPtr(pivot), pivot);
    }

    public Vec3F getPivotPoint() {
        return new Vec3F(VuforiaJNI.HandheldTransformModel_getPivotPoint(this.swigCPtr, this), false);
    }
}

