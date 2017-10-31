/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class VirtualButtonResult {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VirtualButtonResult(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(VirtualButtonResult obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof VirtualButtonResult) {
            equal = ((VirtualButtonResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public VirtualButton getVirtualButton() {
        return new VirtualButton(VuforiaJNI.VirtualButtonResult_getVirtualButton(this.swigCPtr, this), false);
    }

    public boolean isPressed() {
        return VuforiaJNI.VirtualButtonResult_isPressed(this.swigCPtr, this);
    }
}

