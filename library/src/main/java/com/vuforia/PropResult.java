/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class PropResult
extends TrackableResult {
    private long swigCPtr;

    protected PropResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.PropResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(PropResult obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.PropResult_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof PropResult) {
            equal = ((PropResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_PropResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public Trackable getTrackable() {
        return new Prop(VuforiaJNI.PropResult_getTrackable(this.swigCPtr, this), false);
    }
}

