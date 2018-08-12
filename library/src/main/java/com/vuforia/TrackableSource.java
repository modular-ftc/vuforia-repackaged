/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class TrackableSource {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TrackableSource(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public TrackableSource() {
        this(VuforiaJNI.new_TrackableSource(), true);
    }

    protected void finalize() {
        this.delete();
    }

    protected static long getCPtr(TrackableSource obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof TrackableSource) {
            equal = ((TrackableSource)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TrackableSource(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }
}

