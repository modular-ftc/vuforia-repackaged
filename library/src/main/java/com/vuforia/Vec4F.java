/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class Vec4F {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Vec4F(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Vec4F() {
        this(VuforiaJNI.new_Vec4F__SWIG_0(), true);
    }

    protected static long getCPtr(Vec4F obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    public Vec4F(float[] v) {
        this(VuforiaJNI.new_Vec4F__SWIG_1(v), true);
    }

    protected void finalize() {
        this.delete();
    }

    public Vec4F(float v0, float v1, float v2, float v3) {
        this(VuforiaJNI.new_Vec4F__SWIG_2(v0, v1, v2, v3), true);
    }

    public Vec4F(Vec4F other) {
        this(VuforiaJNI.new_Vec4F__SWIG_3(Vec4F.getCPtr(other), other), true);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Vec4F) {
            equal = ((Vec4F) obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public void setData(float[] value) {
        VuforiaJNI.Vec4F_data_set(this.swigCPtr, this, value);
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

    public float[] getData() {
        return VuforiaJNI.Vec4F_data_get(this.swigCPtr, this);
    }
}

