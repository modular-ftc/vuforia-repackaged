/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class CylinderTarget
extends ObjectTarget {
    private long swigCPtr;

    protected CylinderTarget(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.CylinderTarget_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(CylinderTarget obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.CylinderTarget_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof CylinderTarget) {
            equal = ((CylinderTarget)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
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

    public float getSideLength() {
        return VuforiaJNI.CylinderTarget_getSideLength(this.swigCPtr, this);
    }

    public boolean setSideLength(float sideLength) {
        return VuforiaJNI.CylinderTarget_setSideLength(this.swigCPtr, this, sideLength);
    }

    public float getTopDiameter() {
        return VuforiaJNI.CylinderTarget_getTopDiameter(this.swigCPtr, this);
    }

    public boolean setTopDiameter(float topDiameter) {
        return VuforiaJNI.CylinderTarget_setTopDiameter(this.swigCPtr, this, topDiameter);
    }

    public float getBottomDiameter() {
        return VuforiaJNI.CylinderTarget_getBottomDiameter(this.swigCPtr, this);
    }

    public boolean setBottomDiameter(float bottomDiameter) {
        return VuforiaJNI.CylinderTarget_setBottomDiameter(this.swigCPtr, this, bottomDiameter);
    }
}

