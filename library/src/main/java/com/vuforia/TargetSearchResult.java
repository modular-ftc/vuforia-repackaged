/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class TargetSearchResult {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TargetSearchResult(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(TargetSearchResult targetSearchResult) {
        return targetSearchResult == null ? 0L : targetSearchResult.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TargetSearchResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof TargetSearchResult) {
            bl = ((TargetSearchResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public String getTargetName() {
        return VuforiaJNI.TargetSearchResult_getTargetName(this.swigCPtr, this);
    }

    public String getUniqueTargetId() {
        return VuforiaJNI.TargetSearchResult_getUniqueTargetId(this.swigCPtr, this);
    }

    public float getTargetSize() {
        return VuforiaJNI.TargetSearchResult_getTargetSize(this.swigCPtr, this);
    }

    public String getMetaData() {
        return VuforiaJNI.TargetSearchResult_getMetaData(this.swigCPtr, this);
    }

    public short getTrackingRating() {
        return VuforiaJNI.TargetSearchResult_getTrackingRating(this.swigCPtr, this);
    }
}

