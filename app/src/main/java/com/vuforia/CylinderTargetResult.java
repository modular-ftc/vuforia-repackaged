/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.CylinderTarget;
import com.vuforia.ObjectTargetResult;
import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class CylinderTargetResult
extends ObjectTargetResult {
    private long swigCPtr;

    protected CylinderTargetResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.CylinderTargetResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(CylinderTargetResult obj) {
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
                VuforiaJNI.delete_CylinderTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof CylinderTargetResult) {
            equal = ((CylinderTargetResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.CylinderTargetResult_getClassType(), true);
    }

    @Override
    public Trackable getTrackable() {
        return new CylinderTarget(VuforiaJNI.CylinderTargetResult_getTrackable(this.swigCPtr, this), false);
    }
}

