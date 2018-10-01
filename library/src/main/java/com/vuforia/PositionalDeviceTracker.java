/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Anchor;
import com.vuforia.DeviceTracker;
import com.vuforia.HitTestResult;
import com.vuforia.Matrix34F;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class PositionalDeviceTracker
extends DeviceTracker {
    private long swigCPtr;

    protected PositionalDeviceTracker(long l, boolean bl) {
        super(VuforiaJNI.PositionalDeviceTracker_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(PositionalDeviceTracker positionalDeviceTracker) {
        return positionalDeviceTracker == null ? 0L : positionalDeviceTracker.swigCPtr;
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
                VuforiaJNI.delete_PositionalDeviceTracker(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof PositionalDeviceTracker) {
            bl = ((PositionalDeviceTracker)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.PositionalDeviceTracker_getClassType(), true);
    }

    public Anchor createAnchor(String string, Matrix34F matrix34F) {
        long l = VuforiaJNI.PositionalDeviceTracker_createAnchor__SWIG_0(this.swigCPtr, this, string, Matrix34F.getCPtr(matrix34F), matrix34F);
        return l == 0L ? null : new Anchor(l, false);
    }

    public Anchor createAnchor(String string, HitTestResult hitTestResult) {
        long l = VuforiaJNI.PositionalDeviceTracker_createAnchor__SWIG_1(this.swigCPtr, this, string, HitTestResult.getCPtr(hitTestResult), hitTestResult);
        return l == 0L ? null : new Anchor(l, false);
    }

    public boolean destroyAnchor(Anchor anchor) {
        return VuforiaJNI.PositionalDeviceTracker_destroyAnchor(this.swigCPtr, this, Anchor.getCPtr(anchor), anchor);
    }

    public int getNumAnchors() {
        return VuforiaJNI.PositionalDeviceTracker_getNumAnchors(this.swigCPtr, this);
    }

    public Anchor getAnchor(int n) {
        long l = VuforiaJNI.PositionalDeviceTracker_getAnchor(this.swigCPtr, this, n);
        return l == 0L ? null : new Anchor(l, false);
    }
}

