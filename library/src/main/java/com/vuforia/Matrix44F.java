/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class Matrix44F {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Matrix44F(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Matrix44F() {
        this(VuforiaJNI.new_Matrix44F__SWIG_0(), true);
    }

    protected void finalize() {
        this.delete();
    }

    public Matrix44F(Matrix44F other) {
        this(VuforiaJNI.new_Matrix44F__SWIG_1(Matrix44F.getCPtr(other), other), true);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Matrix44F) {
            equal = ((Matrix44F)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public void setData(float[] value) {
        VuforiaJNI.Matrix44F_data_set(this.swigCPtr, this, value);
    }

    protected static long getCPtr(Matrix44F obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Matrix44F(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public float[] getData() {
        return VuforiaJNI.Matrix44F_data_get(this.swigCPtr, this);
    }
}

