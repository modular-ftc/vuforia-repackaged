/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Vec2F;
import com.vuforia.VuforiaJNI;

public class Obb2D {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Obb2D(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Obb2D obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Obb2D(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Obb2D) {
            equal = ((Obb2D)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public Obb2D() {
        this(VuforiaJNI.new_Obb2D__SWIG_0(), true);
    }

    public Obb2D(Obb2D other) {
        this(VuforiaJNI.new_Obb2D__SWIG_1(Obb2D.getCPtr(other), other), true);
    }

    public Obb2D(Vec2F nCenter, Vec2F nHalfExtents, float nRotation) {
        this(VuforiaJNI.new_Obb2D__SWIG_2(Vec2F.getCPtr(nCenter), nCenter, Vec2F.getCPtr(nHalfExtents), nHalfExtents, nRotation), true);
    }

    public Vec2F getCenter() {
        return new Vec2F(VuforiaJNI.Obb2D_getCenter(this.swigCPtr, this), false);
    }

    public Vec2F getHalfExtents() {
        return new Vec2F(VuforiaJNI.Obb2D_getHalfExtents(this.swigCPtr, this), false);
    }

    public float getRotation() {
        return VuforiaJNI.Obb2D_getRotation(this.swigCPtr, this);
    }
}

