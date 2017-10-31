/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.ObjectTargetResult;
import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.VuMarkTarget;
import com.vuforia.VuforiaJNI;

public class VuMarkTargetResult
extends ObjectTargetResult {
    private long swigCPtr;

    protected VuMarkTargetResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.VuMarkTargetResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(VuMarkTargetResult obj) {
        return obj == null ? 0 : obj.swigCPtr;
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
                VuforiaJNI.delete_VuMarkTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof VuMarkTargetResult) {
            equal = ((VuMarkTargetResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.VuMarkTargetResult_getClassType(), true);
    }

    @Override
    public Trackable getTrackable() {
        return new VuMarkTarget(VuforiaJNI.VuMarkTargetResult_getTrackable(this.swigCPtr, this), false);
    }

    public int getId() {
        return VuforiaJNI.VuMarkTargetResult_getId(this.swigCPtr, this);
    }
}

