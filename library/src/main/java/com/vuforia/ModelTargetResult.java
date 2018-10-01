/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.ModelTarget;
import com.vuforia.ObjectTargetResult;
import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class ModelTargetResult
extends ObjectTargetResult {
    private long swigCPtr;

    protected ModelTargetResult(long l, boolean bl) {
        super(VuforiaJNI.ModelTargetResult_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(ModelTargetResult modelTargetResult) {
        return modelTargetResult == null ? 0L : modelTargetResult.swigCPtr;
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
                VuforiaJNI.delete_ModelTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof ModelTargetResult) {
            bl = ((ModelTargetResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ModelTargetResult_getClassType(), true);
    }

    @Override
    public Trackable getTrackable() {
        return new ModelTarget(VuforiaJNI.ModelTargetResult_getTrackable(this.swigCPtr, this), false);
    }
}

