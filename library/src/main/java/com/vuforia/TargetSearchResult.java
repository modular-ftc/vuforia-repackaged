/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class TargetSearchResult {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TargetSearchResult(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(TargetSearchResult obj) {
        return obj == null ? 0L : obj.swigCPtr;
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

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof TargetSearchResult) {
            equal = ((TargetSearchResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
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

