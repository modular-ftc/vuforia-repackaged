/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class ObjectTargetResult
extends TrackableResult {
    private long swigCPtr;

    protected ObjectTargetResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.ObjectTargetResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(ObjectTargetResult obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ObjectTargetResult_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof ObjectTargetResult) {
            equal = ((ObjectTargetResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
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
    public Trackable getTrackable() {
        return new ObjectTarget(VuforiaJNI.ObjectTargetResult_getTrackable(this.swigCPtr, this), false);
    }
}

