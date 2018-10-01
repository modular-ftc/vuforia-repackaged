/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Vec2I {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Vec2I(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Vec2I vec2I) {
        return vec2I == null ? 0L : vec2I.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec2I(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Vec2I) {
            bl = ((Vec2I)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Vec2I() {
        this(VuforiaJNI.new_Vec2I__SWIG_0(), true);
    }

    public Vec2I(int[] arrn) {
        this(VuforiaJNI.new_Vec2I__SWIG_1(arrn), true);
    }

    public Vec2I(int n, int n2) {
        this(VuforiaJNI.new_Vec2I__SWIG_2(n, n2), true);
    }

    public void setData(int[] arrn) {
        VuforiaJNI.Vec2I_data_set(this.swigCPtr, this, arrn);
    }

    public int[] getData() {
        return VuforiaJNI.Vec2I_data_get(this.swigCPtr, this);
    }

    public Vec2I(Vec2I vec2I) {
        this(VuforiaJNI.new_Vec2I__SWIG_3(Vec2I.getCPtr(vec2I), vec2I), true);
    }
}

