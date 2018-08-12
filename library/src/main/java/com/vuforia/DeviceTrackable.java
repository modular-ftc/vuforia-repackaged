/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class DeviceTrackable
extends Trackable {
    private long swigCPtr;

    protected DeviceTrackable(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.DeviceTrackable_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(DeviceTrackable obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTrackable_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof DeviceTrackable) {
            equal = ((DeviceTrackable)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_DeviceTrackable(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }
}

