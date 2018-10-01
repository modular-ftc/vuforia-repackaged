/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Vec4F;
import com.vuforia.ViewerParameters;
import com.vuforia.VuforiaJNI;

public class CustomViewerParameters
extends ViewerParameters {
    private long swigCPtr;

    protected CustomViewerParameters(long l, boolean bl) {
        super(VuforiaJNI.CustomViewerParameters_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(CustomViewerParameters customViewerParameters) {
        return customViewerParameters == null ? 0L : customViewerParameters.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
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

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof CustomViewerParameters) {
            bl = ((CustomViewerParameters)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public CustomViewerParameters(float f, String string, String string2) {
        this(VuforiaJNI.new_CustomViewerParameters__SWIG_0(f, string, string2), true);
    }

    public CustomViewerParameters(CustomViewerParameters customViewerParameters) {
        this(VuforiaJNI.new_CustomViewerParameters__SWIG_1(CustomViewerParameters.getCPtr(customViewerParameters), customViewerParameters), true);
    }

    public void setButtonType(int n) {
        VuforiaJNI.CustomViewerParameters_setButtonType(this.swigCPtr, this, n);
    }

    public void setScreenToLensDistance(float f) {
        VuforiaJNI.CustomViewerParameters_setScreenToLensDistance(this.swigCPtr, this, f);
    }

    public void setInterLensDistance(float f) {
        VuforiaJNI.CustomViewerParameters_setInterLensDistance(this.swigCPtr, this, f);
    }

    public void setTrayAlignment(int n) {
        VuforiaJNI.CustomViewerParameters_setTrayAlignment(this.swigCPtr, this, n);
    }

    public void setLensCentreToTrayDistance(float f) {
        VuforiaJNI.CustomViewerParameters_setLensCentreToTrayDistance(this.swigCPtr, this, f);
    }

    public void clearDistortionCoefficients() {
        VuforiaJNI.CustomViewerParameters_clearDistortionCoefficients(this.swigCPtr, this);
    }

    public void addDistortionCoefficient(float f) {
        VuforiaJNI.CustomViewerParameters_addDistortionCoefficient(this.swigCPtr, this, f);
    }

    public void setFieldOfView(Vec4F vec4F) {
        VuforiaJNI.CustomViewerParameters_setFieldOfView(this.swigCPtr, this, Vec4F.getCPtr(vec4F), vec4F);
    }

    public void setContainsMagnet(boolean bl) {
        VuforiaJNI.CustomViewerParameters_setContainsMagnet(this.swigCPtr, this, bl);
    }
}

