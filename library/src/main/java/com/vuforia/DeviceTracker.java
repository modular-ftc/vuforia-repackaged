/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Matrix34F;
import com.vuforia.Tracker;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class DeviceTracker
extends Tracker {
    private long swigCPtr;

    protected DeviceTracker(long l, boolean bl) {
        super(VuforiaJNI.DeviceTracker_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(DeviceTracker deviceTracker) {
        return deviceTracker == null ? 0L : deviceTracker.swigCPtr;
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
                VuforiaJNI.delete_DeviceTracker(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof DeviceTracker) {
            bl = ((DeviceTracker)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTracker_getClassType(), true);
    }

    public boolean setWorldToDeviceBaseTransform(Matrix34F matrix34F) {
        return VuforiaJNI.DeviceTracker_setWorldToDeviceBaseTransform(this.swigCPtr, this, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public Matrix34F getWorldToDeviceBaseTransform() {
        return new Matrix34F(VuforiaJNI.DeviceTracker_getWorldToDeviceBaseTransform(this.swigCPtr, this), true);
    }
}

