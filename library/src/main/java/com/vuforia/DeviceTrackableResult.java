/*
 * Decompiled with CFR 0_133.
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

    protected DeviceTrackableResult(long l, boolean bl) {
        super(VuforiaJNI.DeviceTrackableResult_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(DeviceTrackableResult deviceTrackableResult) {
        return deviceTrackableResult == null ? 0L : deviceTrackableResult.swigCPtr;
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
                VuforiaJNI.delete_DeviceTrackableResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof DeviceTrackableResult) {
            bl = ((DeviceTrackableResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTrackableResult_getClassType(), true);
    }

    @Override
    public Trackable getTrackable() {
        return new DeviceTrackable(VuforiaJNI.DeviceTrackableResult_getTrackable(this.swigCPtr, this), false);
    }
}

