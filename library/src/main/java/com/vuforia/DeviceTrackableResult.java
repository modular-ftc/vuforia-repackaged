/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class DeviceTrackableResult
extends TrackableResult {
    private long swigCPtr;

    protected DeviceTrackableResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.DeviceTrackableResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(DeviceTrackableResult obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTrackableResult_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof DeviceTrackableResult) {
            equal = ((DeviceTrackableResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_DeviceTrackableResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public Trackable getTrackable() {
        return new DeviceTrackable(VuforiaJNI.DeviceTrackableResult_getTrackable(this.swigCPtr, this), false);
    }
}

