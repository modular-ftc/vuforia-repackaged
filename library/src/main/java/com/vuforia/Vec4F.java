/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Vec4F {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Vec4F(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Vec4F vec4F) {
        return vec4F == null ? 0L : vec4F.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec4F(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Vec4F) {
            bl = ((Vec4F)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Vec4F() {
        this(VuforiaJNI.new_Vec4F__SWIG_0(), true);
    }

    public Vec4F(float[] arrf) {
        this(VuforiaJNI.new_Vec4F__SWIG_1(arrf), true);
    }

    public Vec4F(float f, float f2, float f3, float f4) {
        this(VuforiaJNI.new_Vec4F__SWIG_2(f, f2, f3, f4), true);
    }

    public void setData(float[] arrf) {
        VuforiaJNI.Vec4F_data_set(this.swigCPtr, this, arrf);
    }

    public float[] getData() {
        return VuforiaJNI.Vec4F_data_get(this.swigCPtr, this);
    }

    public Vec4F(Vec4F vec4F) {
        this(VuforiaJNI.new_Vec4F__SWIG_3(Vec4F.getCPtr(vec4F), vec4F), true);
    }
}

