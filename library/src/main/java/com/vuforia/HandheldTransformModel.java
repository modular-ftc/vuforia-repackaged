/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.TransformModel;
import com.vuforia.Vec3F;
import com.vuforia.VuforiaJNI;

public class HandheldTransformModel
extends TransformModel {
    private long swigCPtr;

    protected HandheldTransformModel(long l, boolean bl) {
        super(VuforiaJNI.HandheldTransformModel_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(HandheldTransformModel handheldTransformModel) {
        return handheldTransformModel == null ? 0L : handheldTransformModel.swigCPtr;
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
                VuforiaJNI.delete_HandheldTransformModel(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof HandheldTransformModel) {
            bl = ((HandheldTransformModel)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    @Override
    public int getType() {
        return VuforiaJNI.HandheldTransformModel_getType(this.swigCPtr, this);
    }

    public HandheldTransformModel() {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_0(), true);
    }

    public HandheldTransformModel(HandheldTransformModel handheldTransformModel) {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_1(HandheldTransformModel.getCPtr(handheldTransformModel), handheldTransformModel), true);
    }

    public HandheldTransformModel(Vec3F vec3F) {
        this(VuforiaJNI.new_HandheldTransformModel__SWIG_2(Vec3F.getCPtr(vec3F), vec3F), true);
    }

    public boolean setPivotPoint(Vec3F vec3F) {
        return VuforiaJNI.HandheldTransformModel_setPivotPoint(this.swigCPtr, this, Vec3F.getCPtr(vec3F), vec3F);
    }

    public Vec3F getPivotPoint() {
        return new Vec3F(VuforiaJNI.HandheldTransformModel_getPivotPoint(this.swigCPtr, this), false);
    }
}

