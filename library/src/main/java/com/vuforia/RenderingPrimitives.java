/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class RenderingPrimitives {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected RenderingPrimitives(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public RenderingPrimitives(RenderingPrimitives other) {
        this(VuforiaJNI.new_RenderingPrimitives(RenderingPrimitives.getCPtr(other), other), true);
    }

    protected static long getCPtr(RenderingPrimitives obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_RenderingPrimitives(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof RenderingPrimitives) {
            equal = ((RenderingPrimitives)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public ViewList getRenderingViews() {
        return new ViewList(VuforiaJNI.RenderingPrimitives_getRenderingViews(this.swigCPtr, this), false);
    }

    public Vec4I getViewport(int viewID) {
        return new Vec4I(VuforiaJNI.RenderingPrimitives_getViewport(this.swigCPtr, this, viewID), true);
    }

    public Vec4F getNormalizedViewport(int viewID) {
        return new Vec4F(VuforiaJNI.RenderingPrimitives_getNormalizedViewport(this.swigCPtr, this, viewID), true);
    }

    public Matrix34F getProjectionMatrix(int viewID, int csType, boolean adjustForViewportCentreToEyeAxis) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getProjectionMatrix__SWIG_0(this.swigCPtr, this, viewID, csType, adjustForViewportCentreToEyeAxis), true);
    }

    public Matrix34F getProjectionMatrix(int viewID, int csType) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getProjectionMatrix__SWIG_1(this.swigCPtr, this, viewID, csType), true);
    }

    public Vec4F getEffectiveFov(int viewID) {
        return new Vec4F(VuforiaJNI.RenderingPrimitives_getEffectiveFov(this.swigCPtr, this, viewID), true);
    }

    public Vec2F getViewportCentreToEyeAxis(int viewID, int csType) {
        return new Vec2F(VuforiaJNI.RenderingPrimitives_getViewportCentreToEyeAxis(this.swigCPtr, this, viewID, csType), true);
    }

    public Matrix34F getEyeDisplayAdjustmentMatrix(int viewID) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getEyeDisplayAdjustmentMatrix(this.swigCPtr, this, viewID), true);
    }

    public Vec2I getVideoBackgroundTextureSize() {
        return new Vec2I(VuforiaJNI.RenderingPrimitives_getVideoBackgroundTextureSize(this.swigCPtr, this), true);
    }

    public Matrix34F getVideoBackgroundProjectionMatrix(int viewID, int csType, boolean adjustForViewportCentreToEyeAxis) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getVideoBackgroundProjectionMatrix__SWIG_0(this.swigCPtr, this, viewID, csType, adjustForViewportCentreToEyeAxis), true);
    }

    public Matrix34F getVideoBackgroundProjectionMatrix(int viewID, int csType) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getVideoBackgroundProjectionMatrix__SWIG_1(this.swigCPtr, this, viewID, csType), true);
    }

    public Mesh getVideoBackgroundMesh(int viewID) {
        return new Mesh(VuforiaJNI.RenderingPrimitives_getVideoBackgroundMesh(this.swigCPtr, this, viewID), false);
    }

    public Vec2I getDistortionTextureSize(int viewID) {
        return new Vec2I(VuforiaJNI.RenderingPrimitives_getDistortionTextureSize(this.swigCPtr, this, viewID), true);
    }

    public Vec4I getDistortionTextureViewport(int viewID) {
        return new Vec4I(VuforiaJNI.RenderingPrimitives_getDistortionTextureViewport(this.swigCPtr, this, viewID), true);
    }

    public Mesh getDistortionTextureMesh(int viewID) {
        return new Mesh(VuforiaJNI.RenderingPrimitives_getDistortionTextureMesh(this.swigCPtr, this, viewID), false);
    }
}

