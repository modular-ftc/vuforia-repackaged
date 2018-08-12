/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class WordResult
extends TrackableResult {
    private long swigCPtr;

    protected WordResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.WordResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(WordResult obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.WordResult_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof WordResult) {
            equal = ((WordResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_WordResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public Trackable getTrackable() {
        return new Word(VuforiaJNI.WordResult_getTrackable(this.swigCPtr, this), false);
    }

    public Obb2D getObb() {
        return new Obb2D(VuforiaJNI.WordResult_getObb(this.swigCPtr, this), false);
    }
}

