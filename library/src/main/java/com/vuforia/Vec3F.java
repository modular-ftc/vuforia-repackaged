/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Vec3F {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Vec3F(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Vec3F vec3F) {
        return vec3F == null ? 0L : vec3F.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Vec3F(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Vec3F) {
            bl = ((Vec3F)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Vec3F() {
        this(VuforiaJNI.new_Vec3F__SWIG_0(), true);
    }

    public Vec3F(float[] arrf) {
        this(VuforiaJNI.new_Vec3F__SWIG_1(arrf), true);
    }

    public Vec3F(float f, float f2, float f3) {
        this(VuforiaJNI.new_Vec3F__SWIG_2(f, f2, f3), true);
    }

    public void setData(float[] arrf) {
        VuforiaJNI.Vec3F_data_set(this.swigCPtr, this, arrf);
    }

    public float[] getData() {
        return VuforiaJNI.Vec3F_data_get(this.swigCPtr, this);
    }

    public Vec3F(Vec3F vec3F) {
        this(VuforiaJNI.new_Vec3F__SWIG_3(Vec3F.getCPtr(vec3F), vec3F), true);
    }
}

