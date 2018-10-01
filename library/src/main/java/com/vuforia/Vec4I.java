/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Vec4I {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Vec4I(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Vec4I vec4I) {
        return vec4I == null ? 0L : vec4I.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec4I(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Vec4I) {
            bl = ((Vec4I)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Vec4I() {
        this(VuforiaJNI.new_Vec4I__SWIG_0(), true);
    }

    public Vec4I(int[] arrn) {
        this(VuforiaJNI.new_Vec4I__SWIG_1(arrn), true);
    }

    public void setData(int[] arrn) {
        VuforiaJNI.Vec4I_data_set(this.swigCPtr, this, arrn);
    }

    public int[] getData() {
        return VuforiaJNI.Vec4I_data_get(this.swigCPtr, this);
    }
}

