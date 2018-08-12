/*
 * Decompiled with CFR 0_132.
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
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.MarkerTracker_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof MarkerTracker) {
            equal = ((MarkerTracker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_MarkerTracker(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public Marker createFrameMarker(int markerId, String name, Vec2F size) {
        long cPtr = VuforiaJNI.MarkerTracker_createFrameMarker(this.swigCPtr, this, markerId, name, Vec2F.getCPtr(size), size);
        return cPtr == 0L ? null : new Marker(cPtr, false);
    }

    public boolean destroyMarker(Marker marker) {
        return VuforiaJNI.MarkerTracker_destroyMarker(this.swigCPtr, this, Marker.getCPtr(marker), marker);
    }

    public int getNumMarkers() {
        return VuforiaJNI.MarkerTracker_getNumMarkers(this.swigCPtr, this);
    }

    public Marker getMarker(int idx) {
        long cPtr = VuforiaJNI.MarkerTracker_getMarker(this.swigCPtr, this, idx);
        return cPtr == 0L ? null : new Marker(cPtr, false);
    }
}

