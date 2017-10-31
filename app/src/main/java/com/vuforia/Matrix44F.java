/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Matrix44F {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Matrix44F(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Matrix44F obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Matrix44F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
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

    public float[] getData() {
        return VuforiaJNI.Matrix44F_data_get(this.swigCPtr, this);
    }

    public Matrix44F() {
        this(VuforiaJNI.new_Matrix44F__SWIG_0(), true);
    }

    public Matrix44F(Matrix44F other) {
        this(VuforiaJNI.new_Matrix44F__SWIG_1(Matrix44F.getCPtr(other), other), true);
    }
}

