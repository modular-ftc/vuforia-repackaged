/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class Tracker {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Tracker(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Tracker obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Tracker_getClassType(), true);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Tracker) {
            equal = ((Tracker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Tracker(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public Type getType() {
        return new Type(VuforiaJNI.Tracker_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Tracker_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public boolean start() {
        return VuforiaJNI.Tracker_start(this.swigCPtr, this);
    }

    public void stop() {
        VuforiaJNI.Tracker_stop(this.swigCPtr, this);
    }
}

