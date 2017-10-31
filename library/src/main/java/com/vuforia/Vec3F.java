/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class Vec3F {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Vec3F(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Vec3F() {
        this(VuforiaJNI.new_Vec3F__SWIG_0(), true);
    }

    public Vec3F(float[] v) {
        this(VuforiaJNI.new_Vec3F__SWIG_1(v), true);
    }

    public Vec3F(float v0, float v1, float v2) {
        this(VuforiaJNI.new_Vec3F__SWIG_2(v0, v1, v2), true);
    }

    public Vec3F(Vec3F other) {
        this(VuforiaJNI.new_Vec3F__SWIG_3(Vec3F.getCPtr(other), other), true);
    }

    protected static long getCPtr(Vec3F obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec3F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Vec3F) {
            equal = ((Vec3F)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public float[] getData() {
        return VuforiaJNI.Vec3F_data_get(this.swigCPtr, this);
    }

    public void setData(float[] value) {
        VuforiaJNI.Vec3F_data_set(this.swigCPtr, this, value);
    }
}

