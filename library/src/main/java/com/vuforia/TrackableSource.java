/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class TrackableSource {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TrackableSource(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(TrackableSource trackableSource) {
        return trackableSource == null ? 0L : trackableSource.swigCPtr;
    }

    protected void finalize() {
        this.delete();
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

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof TrackableSource) {
            bl = ((TrackableSource)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public TrackableSource() {
        this(VuforiaJNI.new_TrackableSource(), true);
    }
}

