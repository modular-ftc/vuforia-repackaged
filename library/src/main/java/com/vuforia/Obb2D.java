/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Vec2F;
import com.vuforia.VuforiaJNI;

public class Obb2D {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Obb2D(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Obb2D obb2D) {
        return obb2D == null ? 0L : obb2D.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Obb2D(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Obb2D) {
            bl = ((Obb2D)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Obb2D() {
        this(VuforiaJNI.new_Obb2D__SWIG_0(), true);
    }

    public Obb2D(Obb2D obb2D) {
        this(VuforiaJNI.new_Obb2D__SWIG_1(Obb2D.getCPtr(obb2D), obb2D), true);
    }

    public Obb2D(Vec2F vec2F, Vec2F vec2F2, float f) {
        this(VuforiaJNI.new_Obb2D__SWIG_2(Vec2F.getCPtr(vec2F), vec2F, Vec2F.getCPtr(vec2F2), vec2F2, f), true);
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

