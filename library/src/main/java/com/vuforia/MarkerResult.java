/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class MarkerResult
extends TrackableResult {
    private long swigCPtr;

    protected MarkerResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.MarkerResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(MarkerResult obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.MarkerResult_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof MarkerResult) {
            equal = ((MarkerResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_MarkerResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public Trackable getTrackable() {
        return new Marker(VuforiaJNI.MarkerResult_getTrackable(this.swigCPtr, this), false);
    }
}

