/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class Vec2I {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Vec2I(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Vec2I() {
        this(VuforiaJNI.new_Vec2I__SWIG_0(), true);
    }

    public Vec2I(int[] v) {
        this(VuforiaJNI.new_Vec2I__SWIG_1(v), true);
    }

    public Vec2I(int v0, int v1) {
        this(VuforiaJNI.new_Vec2I__SWIG_2(v0, v1), true);
    }

    public Vec2I(Vec2I other) {
        this(VuforiaJNI.new_Vec2I__SWIG_3(Vec2I.getCPtr(other), other), true);
    }

    protected static long getCPtr(Vec2I obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec2I(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Vec2I) {
            equal = ((Vec2I)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public int[] getData() {
        return VuforiaJNI.Vec2I_data_get(this.swigCPtr, this);
    }

    public void setData(int[] value) {
        VuforiaJNI.Vec2I_data_set(this.swigCPtr, this, value);
    }
}

