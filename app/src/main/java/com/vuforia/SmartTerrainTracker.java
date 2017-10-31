/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.SmartTerrainBuilder;
import com.vuforia.Tracker;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class SmartTerrainTracker
extends Tracker {
    private long swigCPtr;

    protected SmartTerrainTracker(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.SmartTerrainTracker_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(SmartTerrainTracker obj) {
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
                VuforiaJNI.delete_SmartTerrainTracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof SmartTerrainTracker) {
            equal = ((SmartTerrainTracker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.SmartTerrainTracker_getClassType(), true);
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

