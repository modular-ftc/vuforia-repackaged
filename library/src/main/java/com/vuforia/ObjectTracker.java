/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.DataSet;
import com.vuforia.ImageTargetBuilder;
import com.vuforia.TargetFinder;
import com.vuforia.Tracker;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class ObjectTracker
extends Tracker {
    private long swigCPtr;

    protected ObjectTracker(long l, boolean bl) {
        super(VuforiaJNI.ObjectTracker_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(ObjectTracker objectTracker) {
        return objectTracker == null ? 0L : objectTracker.swigCPtr;
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
                VuforiaJNI.delete_ObjectTracker(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof ObjectTracker) {
            bl = ((ObjectTracker)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ObjectTracker_getClassType(), true);
    }

    public DataSet createDataSet() {
        long l = VuforiaJNI.ObjectTracker_createDataSet(this.swigCPtr, this);
        return l == 0L ? null : new DataSet(l, false);
    }

    public boolean destroyDataSet(DataSet dataSet) {
        return VuforiaJNI.ObjectTracker_destroyDataSet(this.swigCPtr, this, DataSet.getCPtr(dataSet), dataSet);
    }

    public boolean activateDataSet(DataSet dataSet) {
        return VuforiaJNI.ObjectTracker_activateDataSet(this.swigCPtr, this, DataSet.getCPtr(dataSet), dataSet);
    }

    public boolean deactivateDataSet(DataSet dataSet) {
        return VuforiaJNI.ObjectTracker_deactivateDataSet(this.swigCPtr, this, DataSet.getCPtr(dataSet), dataSet);
    }

    public DataSet getActiveDataSet(int n) {
        long l = VuforiaJNI.ObjectTracker_getActiveDataSet(this.swigCPtr, this, n);
        return l == 0L ? null : new DataSet(l, false);
    }

    public int getActiveDataSetCount() {
        return VuforiaJNI.ObjectTracker_getActiveDataSetCount(this.swigCPtr, this);
    }

    public ImageTargetBuilder getImageTargetBuilder() {
        long l = VuforiaJNI.ObjectTracker_getImageTargetBuilder(this.swigCPtr, this);
        return l == 0L ? null : new ImageTargetBuilder(l, false);
    }

    public TargetFinder getTargetFinder() {
        long l = VuforiaJNI.ObjectTracker_getTargetFinder(this.swigCPtr, this);
        return l == 0L ? null : new TargetFinder(l, false);
    }

    public boolean persistExtendedTracking(boolean bl) {
        return VuforiaJNI.ObjectTracker_persistExtendedTracking(this.swigCPtr, this, bl);
    }

    public boolean resetExtendedTracking() {
        return VuforiaJNI.ObjectTracker_resetExtendedTracking(this.swigCPtr, this);
    }
}

