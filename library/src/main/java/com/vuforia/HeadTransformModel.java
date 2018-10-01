/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.TransformModel;
import com.vuforia.Vec3F;
import com.vuforia.VuforiaJNI;

public class HeadTransformModel
extends TransformModel {
    private long swigCPtr;

    protected HeadTransformModel(long l, boolean bl) {
        super(VuforiaJNI.HeadTransformModel_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(HeadTransformModel headTransformModel) {
        return headTransformModel == null ? 0L : headTransformModel.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
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

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof HeadTransformModel) {
            bl = ((HeadTransformModel)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    @Override
    public int getType() {
        return VuforiaJNI.HeadTransformModel_getType(this.swigCPtr, this);
    }

    public HeadTransformModel() {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_0(), true);
    }

    public HeadTransformModel(HeadTransformModel headTransformModel) {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_1(HeadTransformModel.getCPtr(headTransformModel), headTransformModel), true);
    }

    public HeadTransformModel(Vec3F vec3F) {
        this(VuforiaJNI.new_HeadTransformModel__SWIG_2(Vec3F.getCPtr(vec3F), vec3F), true);
    }

    public boolean setPivotPoint(Vec3F vec3F) {
        return VuforiaJNI.HeadTransformModel_setPivotPoint(this.swigCPtr, this, Vec3F.getCPtr(vec3F), vec3F);
    }

    public Vec3F getPivotPoint() {
        return new Vec3F(VuforiaJNI.HeadTransformModel_getPivotPoint(this.swigCPtr, this), false);
    }
}

