/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class DeviceTrackable
extends Trackable {
    private long swigCPtr;

    protected DeviceTrackable(long l, boolean bl) {
        super(VuforiaJNI.DeviceTrackable_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(DeviceTrackable deviceTrackable) {
        return deviceTrackable == null ? 0L : deviceTrackable.swigCPtr;
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
                VuforiaJNI.delete_DeviceTrackable(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof DeviceTrackable) {
            bl = ((DeviceTrackable)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.DeviceTrackable_getClassType(), true);
    }
}

