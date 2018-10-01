/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Vec3F;
import com.vuforia.VuforiaJNI;

public class Obb3D {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Obb3D(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Obb3D obb3D) {
        return obb3D == null ? 0L : obb3D.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Obb3D(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Obb3D) {
            bl = ((Obb3D)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Obb3D() {
        this(VuforiaJNI.new_Obb3D__SWIG_0(), true);
    }

    public Obb3D(Obb3D obb3D) {
        this(VuforiaJNI.new_Obb3D__SWIG_1(Obb3D.getCPtr(obb3D), obb3D), true);
    }

    public Obb3D(Vec3F vec3F, Vec3F vec3F2, float f) {
        this(VuforiaJNI.new_Obb3D__SWIG_2(Vec3F.getCPtr(vec3F), vec3F, Vec3F.getCPtr(vec3F2), vec3F2, f), true);
    }

    public Vec3F getCenter() {
        return new Vec3F(VuforiaJNI.Obb3D_getCenter(this.swigCPtr, this), false);
    }

    public Vec3F getHalfExtents() {
        return new Vec3F(VuforiaJNI.Obb3D_getHalfExtents(this.swigCPtr, this), false);
    }

    public float getRotationZ() {
        return VuforiaJNI.Obb3D_getRotationZ(this.swigCPtr, this);
    }
}

