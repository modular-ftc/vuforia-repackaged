/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Vec3F;
import com.vuforia.VuforiaJNI;

public class Obb3D {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Obb3D(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Obb3D obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Obb3D(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Obb3D) {
            equal = ((Obb3D)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public Obb3D() {
        this(VuforiaJNI.new_Obb3D__SWIG_0(), true);
    }

    public Obb3D(Obb3D other) {
        this(VuforiaJNI.new_Obb3D__SWIG_1(Obb3D.getCPtr(other), other), true);
    }

    public Obb3D(Vec3F nCenter, Vec3F nHalfExtents, float nRotationZ) {
        this(VuforiaJNI.new_Obb3D__SWIG_2(Vec3F.getCPtr(nCenter), nCenter, Vec3F.getCPtr(nHalfExtents), nHalfExtents, nRotationZ), true);
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

