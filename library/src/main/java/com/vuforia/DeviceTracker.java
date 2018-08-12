/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class DeviceTracker
extends Tracker {
    private long swigCPtr;

    protected DeviceTracker(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.DeviceTracker_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(DeviceTracker obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTracker_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof DeviceTracker) {
            equal = ((DeviceTracker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_DeviceTracker(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean setWorldToDeviceBaseTransform(Matrix34F baseTransform) {
        return VuforiaJNI.DeviceTracker_setWorldToDeviceBaseTransform(this.swigCPtr, this, Matrix34F.getCPtr(baseTransform), baseTransform);
    }

    public Matrix34F getWorldToDeviceBaseTransform() {
        return new Matrix34F(VuforiaJNI.DeviceTracker_getWorldToDeviceBaseTransform(this.swigCPtr, this), true);
    }
}

