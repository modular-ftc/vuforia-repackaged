/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.ObjectTarget;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class CylinderTarget
extends ObjectTarget {
    private long swigCPtr;

    protected CylinderTarget(long l, boolean bl) {
        super(VuforiaJNI.CylinderTarget_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(CylinderTarget cylinderTarget) {
        return cylinderTarget == null ? 0L : cylinderTarget.swigCPtr;
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
                VuforiaJNI.delete_CylinderTarget(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof CylinderTarget) {
            bl = ((CylinderTarget)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.CylinderTarget_getClassType(), true);
    }

    public float getSideLength() {
        return VuforiaJNI.CylinderTarget_getSideLength(this.swigCPtr, this);
    }

    public boolean setSideLength(float f) {
        return VuforiaJNI.CylinderTarget_setSideLength(this.swigCPtr, this, f);
    }

    public float getTopDiameter() {
        return VuforiaJNI.CylinderTarget_getTopDiameter(this.swigCPtr, this);
    }

    public boolean setTopDiameter(float f) {
        return VuforiaJNI.CylinderTarget_setTopDiameter(this.swigCPtr, this, f);
    }

    public float getBottomDiameter() {
        return VuforiaJNI.CylinderTarget_getBottomDiameter(this.swigCPtr, this);
    }

    public boolean setBottomDiameter(float f) {
        return VuforiaJNI.CylinderTarget_setBottomDiameter(this.swigCPtr, this, f);
    }
}

