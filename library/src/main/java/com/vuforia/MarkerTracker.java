/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class MarkerTracker
extends Tracker {
    private long swigCPtr;

    protected MarkerTracker(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.MarkerTracker_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(MarkerTracker obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.MarkerTracker_getClassType(), true);
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
                VuforiaJNI.delete_MarkerTracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof MarkerTracker) {
            equal = ((MarkerTracker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public Marker createFrameMarker(int markerId, String name, Vec2F size) {
        long cPtr = VuforiaJNI.MarkerTracker_createFrameMarker(this.swigCPtr, this, markerId, name, Vec2F.getCPtr(size), size);
        return cPtr == 0 ? null : new Marker(cPtr, false);
    }

    public boolean destroyMarker(Marker marker) {
        return VuforiaJNI.MarkerTracker_destroyMarker(this.swigCPtr, this, Marker.getCPtr(marker), marker);
    }

    public int getNumMarkers() {
        return VuforiaJNI.MarkerTracker_getNumMarkers(this.swigCPtr, this);
    }

    public Marker getMarker(int idx) {
        long cPtr = VuforiaJNI.MarkerTracker_getMarker(this.swigCPtr, this, idx);
        return cPtr == 0 ? null : new Marker(cPtr, false);
    }
}

