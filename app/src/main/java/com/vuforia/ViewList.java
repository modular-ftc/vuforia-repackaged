/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class ViewList {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected ViewList(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(ViewList obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ViewList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof ViewList) {
            equal = ((ViewList)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public long getNumViews() {
        return VuforiaJNI.ViewList_getNumViews(this.swigCPtr, this);
    }

    public int getView(int idx) {
        return VuforiaJNI.ViewList_getView(this.swigCPtr, this, idx);
    }

    public boolean contains(int view) {
        return VuforiaJNI.ViewList_contains(this.swigCPtr, this, view);
    }
}

