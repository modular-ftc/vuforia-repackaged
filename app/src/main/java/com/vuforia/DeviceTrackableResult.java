/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.DeviceTrackable;
import com.vuforia.Trackable;
import com.vuforia.TrackableResult;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class DeviceTrackableResult
extends TrackableResult {
    private long swigCPtr;

    protected DeviceTrackableResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.DeviceTrackableResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(DeviceTrackableResult obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_DeviceTrackableResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof DeviceTrackableResult) {
            equal = ((DeviceTrackableResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTrackableResult_getClassType(), true);
    }

    @Override
    public Trackable getTrackable() {
        return new DeviceTrackable(VuforiaJNI.DeviceTrackableResult_getTrackable(this.swigCPtr, this), false);
    }
}

