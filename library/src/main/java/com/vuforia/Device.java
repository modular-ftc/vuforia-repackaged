/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class Device {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Device(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Device obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    public static Device getInstance() {
        if (!Vuforia.wasInitializedJava()) {
            throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
        }
        long instancePtr = VuforiaJNI.Device_getInstance();
        if (VuforiaJNI.Device_isOfType(instancePtr, null, Type.getCPtr(EyewearDevice.getClassType()), EyewearDevice.getClassType())) {
            return new EyewearDevice(instancePtr, false);
        }
        return new Device(instancePtr, false);
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Device_getClassType(), true);
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Device(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Device) {
            equal = ((Device)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public Type getType() {
        return new Type(VuforiaJNI.Device_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Device_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public boolean setMode(int m) {
        return VuforiaJNI.Device_setMode(this.swigCPtr, this, m);
    }

    public int getMode() {
        return VuforiaJNI.Device_getMode(this.swigCPtr, this);
    }

    public boolean isViewerActive() {
        return VuforiaJNI.Device_isViewerActive(this.swigCPtr, this);
    }

    public void setViewerActive(boolean active) {
        VuforiaJNI.Device_setViewerActive(this.swigCPtr, this, active);
    }

    public ViewerParametersList getViewerList() {
        return new ViewerParametersList(VuforiaJNI.Device_getViewerList(this.swigCPtr, this), false);
    }

    public boolean selectViewer(ViewerParameters vp) {
        return VuforiaJNI.Device_selectViewer(this.swigCPtr, this, ViewerParameters.getCPtr(vp), vp);
    }

    public ViewerParameters getSelectedViewer() {
        return new ViewerParameters(VuforiaJNI.Device_getSelectedViewer(this.swigCPtr, this), true);
    }

    public void setConfigurationChanged() {
        VuforiaJNI.Device_setConfigurationChanged(this.swigCPtr, this);
    }

    public RenderingPrimitives getRenderingPrimitives() {
        return new RenderingPrimitives(VuforiaJNI.Device_getRenderingPrimitives(this.swigCPtr, this), true);
    }

    public static final class MODE {
        public static final int MODE_AR = 0;
        public static final int MODE_VR = 1;
    }

}

