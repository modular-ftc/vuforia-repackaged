/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class Reconstruction {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Reconstruction(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Reconstruction obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Reconstruction_getClassType(), true);
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Reconstruction) {
            equal = ((Reconstruction)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public Type getType() {
        return new Type(VuforiaJNI.Reconstruction_getType(this.swigCPtr, this), true);
    }

    public boolean setMaximumArea(Rectangle rect) {
        return VuforiaJNI.Reconstruction_setMaximumArea(this.swigCPtr, this, Rectangle.getCPtr(rect), rect);
    }

    public boolean getMaximumArea(Rectangle rect) {
        return VuforiaJNI.Reconstruction_getMaximumArea(this.swigCPtr, this, Rectangle.getCPtr(rect), rect);
    }

    public void setNavMeshPadding(float padding) {
        VuforiaJNI.Reconstruction_setNavMeshPadding(this.swigCPtr, this, padding);
    }

    public boolean start() {
        return VuforiaJNI.Reconstruction_start(this.swigCPtr, this);
    }

    public boolean stop() {
        return VuforiaJNI.Reconstruction_stop(this.swigCPtr, this);
    }

    public boolean reset() {
        return VuforiaJNI.Reconstruction_reset(this.swigCPtr, this);
    }

    public boolean isReconstructing() {
        return VuforiaJNI.Reconstruction_isReconstructing(this.swigCPtr, this);
    }
}

