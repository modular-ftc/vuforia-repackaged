/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.EyewearDevice;
import com.vuforia.RenderingPrimitives;
import com.vuforia.Type;
import com.vuforia.ViewerParameters;
import com.vuforia.ViewerParametersList;
import com.vuforia.Vuforia;
import com.vuforia.VuforiaJNI;

public class Device {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Device(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Device device) {
        return device == null ? 0L : device.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Device(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Device) {
            bl = ((Device)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Device getInstance() {
        if (!Vuforia.wasInitializedJava()) {
            throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
        }
        long l = VuforiaJNI.Device_getInstance();
        if (VuforiaJNI.Device_isOfType(l, null, Type.getCPtr(EyewearDevice.getClassType()), EyewearDevice.getClassType())) {
            return new EyewearDevice(l, false);
        }
        return new Device(l, false);
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Device_getClassType(), true);
    }

    public Type getType() {
        return new Type(VuforiaJNI.Device_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Device_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public boolean setMode(int n) {
        return VuforiaJNI.Device_setMode(this.swigCPtr, this, n);
    }

    public int getMode() {
        return VuforiaJNI.Device_getMode(this.swigCPtr, this);
    }

    public void setViewerActive(boolean bl) {
        VuforiaJNI.Device_setViewerActive(this.swigCPtr, this, bl);
    }

    public boolean isViewerActive() {
        return VuforiaJNI.Device_isViewerActive(this.swigCPtr, this);
    }

    public ViewerParametersList getViewerList() {
        return new ViewerParametersList(VuforiaJNI.Device_getViewerList(this.swigCPtr, this), false);
    }

    public boolean selectViewer(ViewerParameters viewerParameters) {
        return VuforiaJNI.Device_selectViewer(this.swigCPtr, this, ViewerParameters.getCPtr(viewerParameters), viewerParameters);
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

