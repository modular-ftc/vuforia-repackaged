/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class ViewerParameters {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ViewerParameters(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public ViewerParameters(ViewerParameters arg0) {
        this(VuforiaJNI.new_ViewerParameters(ViewerParameters.getCPtr(arg0), arg0), true);
    }

    protected static long getCPtr(ViewerParameters obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ViewerParameters(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof ViewerParameters) {
            equal = ((ViewerParameters)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public float getVersion() {
        return VuforiaJNI.ViewerParameters_getVersion(this.swigCPtr, this);
    }

    public String getName() {
        return VuforiaJNI.ViewerParameters_getName(this.swigCPtr, this);
    }

    public String getManufacturer() {
        return VuforiaJNI.ViewerParameters_getManufacturer(this.swigCPtr, this);
    }

    public int getButtonType() {
        return VuforiaJNI.ViewerParameters_getButtonType(this.swigCPtr, this);
    }

    public float getScreenToLensDistance() {
        return VuforiaJNI.ViewerParameters_getScreenToLensDistance(this.swigCPtr, this);
    }

    public float getInterLensDistance() {
        return VuforiaJNI.ViewerParameters_getInterLensDistance(this.swigCPtr, this);
    }

    public int getTrayAlignment() {
        return VuforiaJNI.ViewerParameters_getTrayAlignment(this.swigCPtr, this);
    }

    public float getLensCentreToTrayDistance() {
        return VuforiaJNI.ViewerParameters_getLensCentreToTrayDistance(this.swigCPtr, this);
    }

    public long getNumDistortionCoefficients() {
        return VuforiaJNI.ViewerParameters_getNumDistortionCoefficients(this.swigCPtr, this);
    }

    public float getDistortionCoefficient(int idx) {
        return VuforiaJNI.ViewerParameters_getDistortionCoefficient(this.swigCPtr, this, idx);
    }

    public Vec4F getFieldOfView() {
        return new Vec4F(VuforiaJNI.ViewerParameters_getFieldOfView(this.swigCPtr, this), true);
    }

    public boolean containsMagnet() {
        return VuforiaJNI.ViewerParameters_containsMagnet(this.swigCPtr, this);
    }

    public static final class TRAY_ALIGNMENT {
        public static final int TRAY_ALIGN_BOTTOM = 0;
        public static final int TRAY_ALIGN_CENTRE = 1;
        public static final int TRAY_ALIGN_TOP = 2;
    }

    public static final class BUTTON_TYPE {
        public static final int BUTTON_TYPE_NONE = 0;
        public static final int BUTTON_TYPE_MAGNET = 1;
        public static final int BUTTON_TYPE_FINGER_TOUCH = 2;
        public static final int BUTTON_TYPE_BUTTON_TOUCH = 3;
    }

}

