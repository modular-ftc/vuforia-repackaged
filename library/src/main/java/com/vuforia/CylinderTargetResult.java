/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class CylinderTargetResult
extends ObjectTargetResult {
    private long swigCPtr;

    protected CylinderTargetResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.CylinderTargetResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(CylinderTargetResult obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.CylinderTargetResult_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof CylinderTargetResult) {
            equal = ((CylinderTargetResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_CylinderTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public Trackable getTrackable() {
        return new CylinderTarget(VuforiaJNI.CylinderTargetResult_getTrackable(this.swigCPtr, this), false);
    }
}

