/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class Trackable {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Trackable(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Trackable obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Trackable_getClassType(), true);
    }

    public Object getUserData() {
        return Vuforia.retreiveFromUserDataMap(this.getId());
    }

    public boolean setUserData(Object userData) {
        return Vuforia.updateUserDataMap(this.getId(), userData);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Trackable) {
            equal = ((Trackable)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
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

