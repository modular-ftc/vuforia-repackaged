/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Matrix34F {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Matrix34F(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Matrix34F matrix34F) {
        return matrix34F == null ? 0L : matrix34F.swigCPtr;
    }

    protected void finalize() {
        this.delete();
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

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Matrix34F) {
            bl = ((Matrix34F)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public void setData(float[] arrf) {
        VuforiaJNI.Matrix34F_data_set(this.swigCPtr, this, arrf);
    }

    public float[] getData() {
        return VuforiaJNI.Matrix34F_data_get(this.swigCPtr, this);
    }

    public Matrix34F() {
        this(VuforiaJNI.new_Matrix34F__SWIG_0(), true);
    }

    public Matrix34F(Matrix34F matrix34F) {
        this(VuforiaJNI.new_Matrix34F__SWIG_1(Matrix34F.getCPtr(matrix34F), matrix34F), true);
    }
}

