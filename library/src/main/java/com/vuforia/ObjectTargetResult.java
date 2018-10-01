/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.ObjectTarget;
import com.vuforia.Trackable;
import com.vuforia.TrackableResult;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class ObjectTargetResult
extends TrackableResult {
    private long swigCPtr;

    protected ObjectTargetResult(long l, boolean bl) {
        super(VuforiaJNI.ObjectTargetResult_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(ObjectTargetResult objectTargetResult) {
        return objectTargetResult == null ? 0L : objectTargetResult.swigCPtr;
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
                VuforiaJNI.delete_ObjectTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof ObjectTargetResult) {
            bl = ((ObjectTargetResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ObjectTargetResult_getClassType(), true);
    }

    @Override
    public Trackable getTrackable() {
        return new ObjectTarget(VuforiaJNI.ObjectTargetResult_getTrackable(this.swigCPtr, this), false);
    }
}

