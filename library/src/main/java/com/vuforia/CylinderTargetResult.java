/*
 * Decompiled with CFR 0_133.
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

    protected CylinderTargetResult(long l, boolean bl) {
        super(VuforiaJNI.CylinderTargetResult_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(CylinderTargetResult cylinderTargetResult) {
        return cylinderTargetResult == null ? 0L : cylinderTargetResult.swigCPtr;
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
                VuforiaJNI.delete_CylinderTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof CylinderTargetResult) {
            bl = ((CylinderTargetResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.CylinderTargetResult_getClassType(), true);
    }

    @Override
    public Trackable getTrackable() {
        return new CylinderTarget(VuforiaJNI.CylinderTargetResult_getTrackable(this.swigCPtr, this), false);
    }
}

