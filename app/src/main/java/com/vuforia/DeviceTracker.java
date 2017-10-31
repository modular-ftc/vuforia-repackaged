/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Matrix34F;
import com.vuforia.Tracker;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class DeviceTracker
extends Tracker {
    private long swigCPtr;

    protected DeviceTracker(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.DeviceTracker_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(DeviceTracker obj) {
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
                VuforiaJNI.delete_DeviceTracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof DeviceTracker) {
            equal = ((DeviceTracker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTracker_getClassType(), true);
    }

    public boolean setWorldToDeviceBaseTransform(Matrix34F baseTransform) {
        return VuforiaJNI.DeviceTracker_setWorldToDeviceBaseTransform(this.swigCPtr, this, Matrix34F.getCPtr(baseTransform), baseTransform);
    }

    public Matrix34F getWorldToDeviceBaseTransform() {
        return new Matrix34F(VuforiaJNI.DeviceTracker_getWorldToDeviceBaseTransform(this.swigCPtr, this), true);
    }
}

