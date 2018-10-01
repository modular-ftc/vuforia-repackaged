/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Anchor;
import com.vuforia.CylinderTarget;
import com.vuforia.DeviceTrackable;
import com.vuforia.ImageTarget;
import com.vuforia.ModelTarget;
import com.vuforia.MultiTarget;
import com.vuforia.ObjectTarget;
import com.vuforia.Trackable;
import com.vuforia.TrackableSource;
import com.vuforia.Type;
import com.vuforia.VuMarkTarget;
import com.vuforia.VuMarkTemplate;
import com.vuforia.VuforiaJNI;

public class DataSet {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected DataSet(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(DataSet dataSet) {
        return dataSet == null ? 0L : dataSet.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_DataSet(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof DataSet) {
            bl = ((DataSet)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static boolean exists(String string, int n) {
        return VuforiaJNI.DataSet_exists(string, n);
    }

    public boolean load(String string, int n) {
        return VuforiaJNI.DataSet_load(this.swigCPtr, this, string, n);
    }

    public int getNumTrackables() {
        return VuforiaJNI.DataSet_getNumTrackables(this.swigCPtr, this);
    }

    public Trackable getTrackable(int n) {
        long l = VuforiaJNI.DataSet_getTrackable(this.swigCPtr, this, n);
        if (l == 0L) {
            return null;
        }
        Trackable trackable = new Trackable(l, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(l, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(l, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(l, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(l, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(l, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(l, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(l, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(l, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(l, false);
        }
        return null;
    }

    public Trackable createTrackable(TrackableSource trackableSource) {
        long l = VuforiaJNI.DataSet_createTrackable(this.swigCPtr, this, TrackableSource.getCPtr(trackableSource), trackableSource);
        if (l == 0L) {
            return null;
        }
        Trackable trackable = new Trackable(l, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(l, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(l, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(l, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(l, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(l, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(l, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(l, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(l, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(l, false);
        }
        return null;
    }

    public MultiTarget createMultiTarget(String string) {
        long l = VuforiaJNI.DataSet_createMultiTarget(this.swigCPtr, this, string);
        return l == 0L ? null : new MultiTarget(l, false);
    }

    public boolean destroy(Trackable trackable) {
        return VuforiaJNI.DataSet_destroy(this.swigCPtr, this, Trackable.getCPtr(trackable), trackable);
    }

    public boolean hasReachedTrackableLimit() {
        return VuforiaJNI.DataSet_hasReachedTrackableLimit(this.swigCPtr, this);
    }

    public boolean isActive() {
        return VuforiaJNI.DataSet_isActive(this.swigCPtr, this);
    }
}

