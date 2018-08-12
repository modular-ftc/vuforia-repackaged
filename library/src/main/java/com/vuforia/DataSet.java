/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class DataSet {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected DataSet(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(DataSet obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public static boolean exists(String path, int storageType) {
        return VuforiaJNI.DataSet_exists(path, storageType);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof DataSet) {
            equal = ((DataSet)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
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

    public boolean load(String path, int storageType) {
        return VuforiaJNI.DataSet_load(this.swigCPtr, this, path, storageType);
    }

    public int getNumTrackables() {
        return VuforiaJNI.DataSet_getNumTrackables(this.swigCPtr, this);
    }

    public Trackable getTrackable(int idx) {
        long cPtr = VuforiaJNI.DataSet_getTrackable(this.swigCPtr, this, idx);
        if (cPtr == 0L) {
            return null;
        }
        Trackable tmp = new Trackable(cPtr, false);
        if (tmp.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(cPtr, false);
        }
        if (tmp.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(cPtr, false);
        }
        if (tmp.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(cPtr, false);
        }
        if (tmp.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(cPtr, false);
        }
        if (tmp.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(cPtr, false);
        }
        if (tmp.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(cPtr, false);
        }
        if (tmp.isOfType(Word.getClassType())) {
            return new Word(cPtr, false);
        }
        if (tmp.isOfType(Marker.getClassType())) {
            return new Marker(cPtr, false);
        }
        if (tmp.isOfType(Surface.getClassType())) {
            return new Surface(cPtr, false);
        }
        if (tmp.isOfType(Prop.getClassType())) {
            return new Prop(cPtr, false);
        }
        if (tmp.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(cPtr, false);
        }
        return null;
    }

    public Trackable createTrackable(TrackableSource source) {
        long cPtr = VuforiaJNI.DataSet_createTrackable(this.swigCPtr, this, TrackableSource.getCPtr(source), source);
        if (cPtr == 0L) {
            return null;
        }
        Trackable tmp = new Trackable(cPtr, false);
        if (tmp.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(cPtr, false);
        }
        if (tmp.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(cPtr, false);
        }
        if (tmp.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(cPtr, false);
        }
        if (tmp.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(cPtr, false);
        }
        if (tmp.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(cPtr, false);
        }
        if (tmp.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(cPtr, false);
        }
        if (tmp.isOfType(Word.getClassType())) {
            return new Word(cPtr, false);
        }
        if (tmp.isOfType(Marker.getClassType())) {
            return new Marker(cPtr, false);
        }
        if (tmp.isOfType(Surface.getClassType())) {
            return new Surface(cPtr, false);
        }
        if (tmp.isOfType(Prop.getClassType())) {
            return new Prop(cPtr, false);
        }
        if (tmp.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(cPtr, false);
        }
        return null;
    }

    public MultiTarget createMultiTarget(String name) {
        long cPtr = VuforiaJNI.DataSet_createMultiTarget(this.swigCPtr, this, name);
        return cPtr == 0L ? null : new MultiTarget(cPtr, false);
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

