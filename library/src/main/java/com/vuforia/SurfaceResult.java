/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class SurfaceResult
extends TrackableResult {
    private long swigCPtr;

    protected SurfaceResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.SurfaceResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(SurfaceResult obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.SurfaceResult_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof SurfaceResult) {
            equal = ((SurfaceResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_SurfaceResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public Trackable getTrackable() {
        return new Surface(VuforiaJNI.SurfaceResult_getTrackable(this.swigCPtr, this), false);
    }
}

