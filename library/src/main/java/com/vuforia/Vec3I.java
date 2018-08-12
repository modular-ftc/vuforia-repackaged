/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class Vec3I {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Vec3I(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Vec3I() {
        this(VuforiaJNI.new_Vec3I__SWIG_0(), true);
    }

    protected void finalize() {
        this.delete();
    }

    public Vec3I(int[] v) {
        this(VuforiaJNI.new_Vec3I__SWIG_1(v), true);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Vec3I) {
            equal = ((Vec3I)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    protected static long getCPtr(Vec3I obj) {
        return obj == null ? 0L : obj.swigCPtr;
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

    public void setData(int[] value) {
        VuforiaJNI.Vec3I_data_set(this.swigCPtr, this, value);
    }

    public int[] getData() {
        return VuforiaJNI.Vec3I_data_get(this.swigCPtr, this);
    }
}

