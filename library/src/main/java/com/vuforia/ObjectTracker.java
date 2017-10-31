/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class ObjectTracker
extends Tracker {
    private long swigCPtr;

    protected ObjectTracker(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.ObjectTracker_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(ObjectTracker obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ObjectTracker_getClassType(), true);
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
                VuforiaJNI.delete_ObjectTracker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof ObjectTracker) {
            equal = ((ObjectTracker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public DataSet createDataSet() {
        long cPtr = VuforiaJNI.ObjectTracker_createDataSet(this.swigCPtr, this);
        return cPtr == 0 ? null : new DataSet(cPtr, false);
    }

    public boolean destroyDataSet(DataSet dataset) {
        return VuforiaJNI.ObjectTracker_destroyDataSet(this.swigCPtr, this, DataSet.getCPtr(dataset), dataset);
    }

    public boolean activateDataSet(DataSet dataset) {
        return VuforiaJNI.ObjectTracker_activateDataSet(this.swigCPtr, this, DataSet.getCPtr(dataset), dataset);
    }

    public boolean deactivateDataSet(DataSet dataset) {
        return VuforiaJNI.ObjectTracker_deactivateDataSet(this.swigCPtr, this, DataSet.getCPtr(dataset), dataset);
    }

    public DataSet getActiveDataSet(int idx) {
        long cPtr = VuforiaJNI.ObjectTracker_getActiveDataSet__SWIG_0(this.swigCPtr, this, idx);
        return cPtr == 0 ? null : new DataSet(cPtr, false);
    }

    public DataSet getActiveDataSet() {
        long cPtr = VuforiaJNI.ObjectTracker_getActiveDataSet__SWIG_1(this.swigCPtr, this);
        return cPtr == 0 ? null : new DataSet(cPtr, false);
    }

    public int getActiveDataSetCount() {
        return VuforiaJNI.ObjectTracker_getActiveDataSetCount(this.swigCPtr, this);
    }

    public ImageTargetBuilder getImageTargetBuilder() {
        long cPtr = VuforiaJNI.ObjectTracker_getImageTargetBuilder(this.swigCPtr, this);
        return cPtr == 0 ? null : new ImageTargetBuilder(cPtr, false);
    }

    public TargetFinder getTargetFinder() {
        long cPtr = VuforiaJNI.ObjectTracker_getTargetFinder(this.swigCPtr, this);
        return cPtr == 0 ? null : new TargetFinder(cPtr, false);
    }

    public boolean persistExtendedTracking(boolean on) {
        return VuforiaJNI.ObjectTracker_persistExtendedTracking(this.swigCPtr, this, on);
    }

    public boolean resetExtendedTracking() {
        return VuforiaJNI.ObjectTracker_resetExtendedTracking(this.swigCPtr, this);
    }
}

