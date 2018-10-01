/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.CameraCalibration;
import com.vuforia.Matrix34F;
import com.vuforia.Mesh;
import com.vuforia.Vec2F;
import com.vuforia.Vec2I;
import com.vuforia.Vec4F;
import com.vuforia.Vec4I;
import com.vuforia.ViewList;
import com.vuforia.VuforiaJNI;

public class RenderingPrimitives {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected RenderingPrimitives(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(RenderingPrimitives renderingPrimitives) {
        return renderingPrimitives == null ? 0L : renderingPrimitives.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_RenderingPrimitives(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof RenderingPrimitives) {
            bl = ((RenderingPrimitives)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public RenderingPrimitives(RenderingPrimitives renderingPrimitives) {
        this(VuforiaJNI.new_RenderingPrimitives(RenderingPrimitives.getCPtr(renderingPrimitives), renderingPrimitives), true);
    }

    public ViewList getRenderingViews() {
        return new ViewList(VuforiaJNI.RenderingPrimitives_getRenderingViews(this.swigCPtr, this), false);
    }

    public Vec4I getViewport(int n) {
        return new Vec4I(VuforiaJNI.RenderingPrimitives_getViewport(this.swigCPtr, this, n), true);
    }

    public Vec4F getNormalizedViewport(int n) {
        return new Vec4F(VuforiaJNI.RenderingPrimitives_getNormalizedViewport(this.swigCPtr, this, n), true);
    }

    public Matrix34F getProjectionMatrix(int n, int n2, CameraCalibration cameraCalibration, boolean bl) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getProjectionMatrix__SWIG_0(this.swigCPtr, this, n, n2, CameraCalibration.getCPtr(cameraCalibration), cameraCalibration, bl), true);
    }

    public Matrix34F getProjectionMatrix(int n, int n2, CameraCalibration cameraCalibration) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getProjectionMatrix__SWIG_1(this.swigCPtr, this, n, n2, CameraCalibration.getCPtr(cameraCalibration), cameraCalibration), true);
    }

    public Vec4F getEffectiveFov(int n) {
        return new Vec4F(VuforiaJNI.RenderingPrimitives_getEffectiveFov(this.swigCPtr, this, n), true);
    }

    public Vec2F getViewportCentreToEyeAxis(int n, int n2) {
        return new Vec2F(VuforiaJNI.RenderingPrimitives_getViewportCentreToEyeAxis(this.swigCPtr, this, n, n2), true);
    }

    public Matrix34F getEyeDisplayAdjustmentMatrix(int n) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getEyeDisplayAdjustmentMatrix(this.swigCPtr, this, n), true);
    }

    public Vec2I getVideoBackgroundTextureSize() {
        return new Vec2I(VuforiaJNI.RenderingPrimitives_getVideoBackgroundTextureSize(this.swigCPtr, this), true);
    }

    public Matrix34F getVideoBackgroundProjectionMatrix(int n, int n2, boolean bl) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getVideoBackgroundProjectionMatrix__SWIG_0(this.swigCPtr, this, n, n2, bl), true);
    }

    public Matrix34F getVideoBackgroundProjectionMatrix(int n, int n2) {
        return new Matrix34F(VuforiaJNI.RenderingPrimitives_getVideoBackgroundProjectionMatrix__SWIG_1(this.swigCPtr, this, n, n2), true);
    }

    public Mesh getVideoBackgroundMesh(int n) {
        return new Mesh(VuforiaJNI.RenderingPrimitives_getVideoBackgroundMesh(this.swigCPtr, this, n), false);
    }

    public Vec2I getDistortionTextureSize(int n) {
        return new Vec2I(VuforiaJNI.RenderingPrimitives_getDistortionTextureSize(this.swigCPtr, this, n), true);
    }

    public Vec4I getDistortionTextureViewport(int n) {
        return new Vec4I(VuforiaJNI.RenderingPrimitives_getDistortionTextureViewport(this.swigCPtr, this, n), true);
    }

    public Mesh getDistortionTextureMesh(int n) {
        return new Mesh(VuforiaJNI.RenderingPrimitives_getDistortionTextureMesh(this.swigCPtr, this, n), false);
    }
}

