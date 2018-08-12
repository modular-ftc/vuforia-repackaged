/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class CustomViewerParameters
extends ViewerParameters {
    private long swigCPtr;

    protected CustomViewerParameters(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.CustomViewerParameters_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    public CustomViewerParameters(float version, String name, String manufacturer) {
        this(VuforiaJNI.new_CustomViewerParameters__SWIG_0(version, name, manufacturer), true);
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public CustomViewerParameters(CustomViewerParameters arg0) {
        this(VuforiaJNI.new_CustomViewerParameters__SWIG_1(CustomViewerParameters.getCPtr(arg0), arg0), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof CustomViewerParameters) {
            equal = ((CustomViewerParameters)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    protected static long getCPtr(CustomViewerParameters obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_CustomViewerParameters(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public void setButtonType(int val) {
        VuforiaJNI.CustomViewerParameters_setButtonType(this.swigCPtr, this, val);
    }

    public void setScreenToLensDistance(float val) {
        VuforiaJNI.CustomViewerParameters_setScreenToLensDistance(this.swigCPtr, this, val);
    }

    public void setInterLensDistance(float val) {
        VuforiaJNI.CustomViewerParameters_setInterLensDistance(this.swigCPtr, this, val);
    }

    public void setTrayAlignment(int val) {
        VuforiaJNI.CustomViewerParameters_setTrayAlignment(this.swigCPtr, this, val);
    }

    public void setLensCentreToTrayDistance(float val) {
        VuforiaJNI.CustomViewerParameters_setLensCentreToTrayDistance(this.swigCPtr, this, val);
    }

    public void clearDistortionCoefficients() {
        VuforiaJNI.CustomViewerParameters_clearDistortionCoefficients(this.swigCPtr, this);
    }

    public void addDistortionCoefficient(float val) {
        VuforiaJNI.CustomViewerParameters_addDistortionCoefficient(this.swigCPtr, this, val);
    }

    public void setFieldOfView(Vec4F val) {
        VuforiaJNI.CustomViewerParameters_setFieldOfView(this.swigCPtr, this, Vec4F.getCPtr(val), val);
    }

    public void setContainsMagnet(boolean val) {
        VuforiaJNI.CustomViewerParameters_setContainsMagnet(this.swigCPtr, this, val);
    }
}

