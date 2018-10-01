/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Vec3I {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Vec3I(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Vec3I vec3I) {
        return vec3I == null ? 0L : vec3I.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec3I(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Vec3I) {
            bl = ((Vec3I)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Vec3I() {
        this(VuforiaJNI.new_Vec3I__SWIG_0(), true);
    }

    public Vec3I(int[] arrn) {
        this(VuforiaJNI.new_Vec3I__SWIG_1(arrn), true);
    }

    public void setData(int[] arrn) {
        VuforiaJNI.Vec3I_data_set(this.swigCPtr, this, arrn);
    }

    public int[] getData() {
        return VuforiaJNI.Vec3I_data_get(this.swigCPtr, this);
    }
}

