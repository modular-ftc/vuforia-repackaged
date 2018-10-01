/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Matrix44F {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Matrix44F(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Matrix44F matrix44F) {
        return matrix44F == null ? 0L : matrix44F.swigCPtr;
    }

    protected void finalize() {
        this.delete();
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

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Matrix44F) {
            bl = ((Matrix44F)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public void setData(float[] arrf) {
        VuforiaJNI.Matrix44F_data_set(this.swigCPtr, this, arrf);
    }

    public float[] getData() {
        return VuforiaJNI.Matrix44F_data_get(this.swigCPtr, this);
    }

    public Matrix44F() {
        this(VuforiaJNI.new_Matrix44F__SWIG_0(), true);
    }

    public Matrix44F(Matrix44F matrix44F) {
        this(VuforiaJNI.new_Matrix44F__SWIG_1(Matrix44F.getCPtr(matrix44F), matrix44F), true);
    }
}

