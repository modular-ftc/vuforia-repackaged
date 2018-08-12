/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class MultiTargetResult
extends ObjectTargetResult {
    private long swigCPtr;

    protected MultiTargetResult(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.MultiTargetResult_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(MultiTargetResult obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.MultiTargetResult_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof MultiTargetResult) {
            equal = ((MultiTargetResult)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_MultiTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public Trackable getTrackable() {
        return new MultiTarget(VuforiaJNI.MultiTargetResult_getTrackable(this.swigCPtr, this), false);
    }

    public int getNumPartResults() {
        return VuforiaJNI.MultiTargetResult_getNumPartResults(this.swigCPtr, this);
    }

    public TrackableResult getPartResult(int idx) {
        long cPtr = VuforiaJNI.MultiTargetResult_getPartResult__SWIG_0(this.swigCPtr, this, idx);
        if (cPtr == 0L) {
            return null;
        }
        TrackableResult tmp = new TrackableResult(cPtr, false);
        if (tmp.isOfType(ImageTargetResult.getClassType())) {
            return new ImageTargetResult(cPtr, false);
        }
        if (tmp.isOfType(CylinderTargetResult.getClassType())) {
            return new CylinderTargetResult(cPtr, false);
        }
        if (tmp.isOfType(MultiTargetResult.getClassType())) {
            return new MultiTargetResult(cPtr, false);
        }
        if (tmp.isOfType(VuMarkTargetResult.getClassType())) {
            return new VuMarkTargetResult(cPtr, false);
        }
        if (tmp.isOfType(ObjectTargetResult.getClassType())) {
            return new ObjectTargetResult(cPtr, false);
        }
        if (tmp.isOfType(WordResult.getClassType())) {
            return new WordResult(cPtr, false);
        }
        if (tmp.isOfType(MarkerResult.getClassType())) {
            return new MarkerResult(cPtr, false);
        }
        if (tmp.isOfType(SurfaceResult.getClassType())) {
            return new SurfaceResult(cPtr, false);
        }
        if (tmp.isOfType(PropResult.getClassType())) {
            return new PropResult(cPtr, false);
        }
        if (tmp.isOfType(DeviceTrackableResult.getClassType())) {
            return new DeviceTrackableResult(cPtr, false);
        }
        return null;
    }

    public TrackableResult getPartResult(String name) {
        long cPtr = VuforiaJNI.MultiTargetResult_getPartResult__SWIG_1(this.swigCPtr, this, name);
        if (cPtr == 0L) {
            return null;
        }
        TrackableResult tmp = new TrackableResult(cPtr, false);
        if (tmp.isOfType(ImageTargetResult.getClassType())) {
            return new ImageTargetResult(cPtr, false);
        }
        if (tmp.isOfType(CylinderTargetResult.getClassType())) {
            return new CylinderTargetResult(cPtr, false);
        }
        if (tmp.isOfType(MultiTargetResult.getClassType())) {
            return new MultiTargetResult(cPtr, false);
        }
        if (tmp.isOfType(VuMarkTargetResult.getClassType())) {
            return new VuMarkTargetResult(cPtr, false);
        }
        if (tmp.isOfType(ObjectTargetResult.getClassType())) {
            return new ObjectTargetResult(cPtr, false);
        }
        if (tmp.isOfType(WordResult.getClassType())) {
            return new WordResult(cPtr, false);
        }
        if (tmp.isOfType(MarkerResult.getClassType())) {
            return new MarkerResult(cPtr, false);
        }
        if (tmp.isOfType(SurfaceResult.getClassType())) {
            return new SurfaceResult(cPtr, false);
        }
        if (tmp.isOfType(PropResult.getClassType())) {
            return new PropResult(cPtr, false);
        }
        if (tmp.isOfType(DeviceTrackableResult.getClassType())) {
            return new DeviceTrackableResult(cPtr, false);
        }
        return null;
    }
}

