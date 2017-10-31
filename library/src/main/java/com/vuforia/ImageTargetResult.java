/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class ImageTargetResult
extends ObjectTargetResult {
    private long swigCPtr;

    protected ImageTargetResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.ImageTargetResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(ImageTargetResult obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ImageTargetResult_getClassType(), true);
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ImageTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof ImageTargetResult) {
            equal = ((ImageTargetResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    public Trackable getTrackable() {
        return new ImageTarget(VuforiaJNI.ImageTargetResult_getTrackable(this.swigCPtr, this), false);
    }

    public int getNumVirtualButtons() {
        return VuforiaJNI.ImageTargetResult_getNumVirtualButtons(this.swigCPtr, this);
    }

    public VirtualButtonResult getVirtualButtonResult(int idx) {
        long cPtr = VuforiaJNI.ImageTargetResult_getVirtualButtonResult__SWIG_0(this.swigCPtr, this, idx);
        return cPtr == 0 ? null : new VirtualButtonResult(cPtr, false);
    }

    public VirtualButtonResult getVirtualButtonResult(String name) {
        long cPtr = VuforiaJNI.ImageTargetResult_getVirtualButtonResult__SWIG_1(this.swigCPtr, this, name);
        return cPtr == 0 ? null : new VirtualButtonResult(cPtr, false);
    }
}

