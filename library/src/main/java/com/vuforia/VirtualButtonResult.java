/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VirtualButton;
import com.vuforia.VuforiaJNI;

public class VirtualButtonResult {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected VirtualButtonResult(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(VirtualButtonResult virtualButtonResult) {
        return virtualButtonResult == null ? 0L : virtualButtonResult.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof VirtualButtonResult) {
            bl = ((VirtualButtonResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public VirtualButton getVirtualButton() {
        return new VirtualButton(VuforiaJNI.VirtualButtonResult_getVirtualButton(this.swigCPtr, this), false);
    }

    public boolean isPressed() {
        return VuforiaJNI.VirtualButtonResult_isPressed(this.swigCPtr, this);
    }
}

