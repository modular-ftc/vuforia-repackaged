/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Vec2F {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Vec2F(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Vec2F vec2F) {
        return vec2F == null ? 0L : vec2F.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec2F(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Vec2F) {
            bl = ((Vec2F)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Vec2F() {
        this(VuforiaJNI.new_Vec2F__SWIG_0(), true);
    }

    public Vec2F(float[] arrf) {
        this(VuforiaJNI.new_Vec2F__SWIG_1(arrf), true);
    }

    public Vec2F(float f, float f2) {
        this(VuforiaJNI.new_Vec2F__SWIG_2(f, f2), true);
    }

    public void setData(float[] arrf) {
        VuforiaJNI.Vec2F_data_set(this.swigCPtr, this, arrf);
    }

    public float[] getData() {
        return VuforiaJNI.Vec2F_data_get(this.swigCPtr, this);
    }

    public Vec2F(Vec2F vec2F) {
        this(VuforiaJNI.new_Vec2F__SWIG_3(Vec2F.getCPtr(vec2F), vec2F), true);
    }
}

