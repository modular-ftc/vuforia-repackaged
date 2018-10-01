/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Matrix34F;
import com.vuforia.VuforiaJNI;

public class HitTestResult {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected HitTestResult(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(HitTestResult hitTestResult) {
        return hitTestResult == null ? 0L : hitTestResult.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_HitTestResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof HitTestResult) {
            bl = ((HitTestResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Matrix34F getPose() {
        return new Matrix34F(VuforiaJNI.HitTestResult_getPose(this.swigCPtr, this), true);
    }
}

