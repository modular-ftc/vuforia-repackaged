/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class TrackableSource {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected TrackableSource(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public TrackableSource() {
        this(VuforiaJNI.new_TrackableSource(), true);
    }

    protected static long getCPtr(TrackableSource obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TrackableSource(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof TrackableSource) {
            equal = ((TrackableSource)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }
}

