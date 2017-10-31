/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class Vec2F {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Vec2F(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Vec2F() {
        this(VuforiaJNI.new_Vec2F__SWIG_0(), true);
    }

    public Vec2F(float[] v) {
        this(VuforiaJNI.new_Vec2F__SWIG_1(v), true);
    }

    public Vec2F(float v0, float v1) {
        this(VuforiaJNI.new_Vec2F__SWIG_2(v0, v1), true);
    }

    public Vec2F(Vec2F other) {
        this(VuforiaJNI.new_Vec2F__SWIG_3(Vec2F.getCPtr(other), other), true);
    }

    protected static long getCPtr(Vec2F obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec2F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Vec2F) {
            equal = ((Vec2F)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public float[] getData() {
        return VuforiaJNI.Vec2F_data_get(this.swigCPtr, this);
    }

    public void setData(float[] value) {
        VuforiaJNI.Vec2F_data_set(this.swigCPtr, this, value);
    }
}

