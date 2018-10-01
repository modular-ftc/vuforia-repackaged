/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.ImageTarget;
import com.vuforia.ObjectTargetResult;
import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.VirtualButtonResult;
import com.vuforia.VuforiaJNI;

public class ImageTargetResult
extends ObjectTargetResult {
    private long swigCPtr;

    protected ImageTargetResult(long l, boolean bl) {
        super(VuforiaJNI.ImageTargetResult_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(ImageTargetResult imageTargetResult) {
        return imageTargetResult == null ? 0L : imageTargetResult.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ImageTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof ImageTargetResult) {
            bl = ((ImageTargetResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ImageTargetResult_getClassType(), true);
    }

    @Override
    public Trackable getTrackable() {
        return new ImageTarget(VuforiaJNI.ImageTargetResult_getTrackable(this.swigCPtr, this), false);
    }

    public int getNumVirtualButtons() {
        return VuforiaJNI.ImageTargetResult_getNumVirtualButtons(this.swigCPtr, this);
    }

    public VirtualButtonResult getVirtualButtonResult(int n) {
        long l = VuforiaJNI.ImageTargetResult_getVirtualButtonResult__SWIG_0(this.swigCPtr, this, n);
        return l == 0L ? null : new VirtualButtonResult(l, false);
    }

    public VirtualButtonResult getVirtualButtonResult(String string) {
        long l = VuforiaJNI.ImageTargetResult_getVirtualButtonResult__SWIG_1(this.swigCPtr, this, string);
        return l == 0L ? null : new VirtualButtonResult(l, false);
    }
}

