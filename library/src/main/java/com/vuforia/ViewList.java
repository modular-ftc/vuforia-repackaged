/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class ViewList {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected ViewList(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(ViewList viewList) {
        return viewList == null ? 0L : viewList.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ViewList(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof ViewList) {
            bl = ((ViewList)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public long getNumViews() {
        return VuforiaJNI.ViewList_getNumViews(this.swigCPtr, this);
    }

    public int getView(int n) {
        return VuforiaJNI.ViewList_getView(this.swigCPtr, this, n);
    }

    public boolean contains(int n) {
        return VuforiaJNI.ViewList_contains(this.swigCPtr, this, n);
    }
}

