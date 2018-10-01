/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Vec3F;
import com.vuforia.VuforiaJNI;

public class Box3D {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Box3D(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Box3D box3D) {
        return box3D == null ? 0L : box3D.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Box3D(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Box3D) {
            bl = ((Box3D)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Box3D() {
        this(VuforiaJNI.new_Box3D__SWIG_0(), true);
    }

    public Box3D(Box3D box3D) {
        this(VuforiaJNI.new_Box3D__SWIG_1(Box3D.getCPtr(box3D), box3D), true);
    }

    public Box3D(Vec3F vec3F, Vec3F vec3F2) {
        this(VuforiaJNI.new_Box3D__SWIG_2(Vec3F.getCPtr(vec3F), vec3F, Vec3F.getCPtr(vec3F2), vec3F2), true);
    }

    public Vec3F getMinimumPosition() {
        return new Vec3F(VuforiaJNI.Box3D_getMinimumPosition(this.swigCPtr, this), false);
    }

    public Vec3F getMaximumPosition() {
        return new Vec3F(VuforiaJNI.Box3D_getMaximumPosition(this.swigCPtr, this), false);
    }
}

