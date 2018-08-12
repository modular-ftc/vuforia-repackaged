/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class SmartTerrainTracker
extends Tracker {
    private long swigCPtr;

    protected SmartTerrainTracker(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.SmartTerrainTracker_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(SmartTerrainTracker obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.SmartTerrainTracker_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof SmartTerrainTracker) {
            equal = ((SmartTerrainTracker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_SmartTerrainTracker(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean setScaleToMillimeter(float scaleFactor) {
        return VuforiaJNI.SmartTerrainTracker_setScaleToMillimeter(this.swigCPtr, this, scaleFactor);
    }

    public float getScaleToMillimeter() {
        return VuforiaJNI.SmartTerrainTracker_getScaleToMillimeter(this.swigCPtr, this);
    }

    public SmartTerrainBuilder getSmartTerrainBuilder() {
        return new SmartTerrainBuilder(VuforiaJNI.SmartTerrainTracker_getSmartTerrainBuilder(this.swigCPtr, this), false);
    }
}

