/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class DeviceTrackable
extends Trackable {
    private long swigCPtr;

    protected DeviceTrackable(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.DeviceTrackable_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(DeviceTrackable obj) {
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
                VuforiaJNI.delete_DeviceTrackable(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof DeviceTrackable) {
            equal = ((DeviceTrackable)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTrackable_getClassType(), true);
    }
}

