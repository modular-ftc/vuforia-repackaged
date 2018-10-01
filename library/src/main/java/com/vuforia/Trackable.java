/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Type;
import com.vuforia.Vuforia;
import com.vuforia.VuforiaJNI;

public class Trackable {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Trackable(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Trackable trackable) {
        return trackable == null ? 0L : trackable.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Trackable(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public Object getUserData() {
        return Vuforia.retreiveFromUserDataMap(this.getId());
    }

    public boolean setUserData(Object object) {
        return Vuforia.updateUserDataMap(this.getId(), object);
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Trackable) {
            bl = ((Trackable)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Trackable_getClassType(), true);
    }

    public Type getType() {
        return new Type(VuforiaJNI.Trackable_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Trackable_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public int getId() {
        return VuforiaJNI.Trackable_getId(this.swigCPtr, this);
    }

    public String getName() {
        return VuforiaJNI.Trackable_getName(this.swigCPtr, this);
    }

    public boolean startExtendedTracking() {
        return VuforiaJNI.Trackable_startExtendedTracking(this.swigCPtr, this);
    }

    public boolean stopExtendedTracking() {
        return VuforiaJNI.Trackable_stopExtendedTracking(this.swigCPtr, this);
    }

    public boolean isExtendedTrackingStarted() {
        return VuforiaJNI.Trackable_isExtendedTrackingStarted(this.swigCPtr, this);
    }
}

