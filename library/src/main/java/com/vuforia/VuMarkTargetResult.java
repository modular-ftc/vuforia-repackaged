/*
 * Decompiled with CFR 0_133.
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

    protected VuMarkTargetResult(long l, boolean bl) {
        super(VuforiaJNI.VuMarkTargetResult_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(VuMarkTargetResult vuMarkTargetResult) {
        return vuMarkTargetResult == null ? 0L : vuMarkTargetResult.swigCPtr;
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
                VuforiaJNI.delete_VuMarkTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof VuMarkTargetResult) {
            bl = ((VuMarkTargetResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
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

