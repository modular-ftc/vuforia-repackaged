/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class Matrix34F {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Matrix34F(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Matrix34F() {
        this(VuforiaJNI.new_Matrix34F__SWIG_0(), true);
    }

    protected void finalize() {
        this.delete();
    }

    public Matrix34F(Matrix34F other) {
        this(VuforiaJNI.new_Matrix34F__SWIG_1(Matrix34F.getCPtr(other), other), true);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Matrix34F) {
            equal = ((Matrix34F)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public void setData(float[] value) {
        VuforiaJNI.Matrix34F_data_set(this.swigCPtr, this, value);
    }

    protected static long getCPtr(Matrix34F obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Matrix34F(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public float[] getData() {
        return VuforiaJNI.Matrix34F_data_get(this.swigCPtr, this);
    }
}

