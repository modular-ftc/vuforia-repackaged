/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class State
implements Cloneable {
    protected boolean swigCMemOwn;
    private long swigCPtr;
    private Frame mFrame = null;
    private Object mFrameMutex = new Object();

    protected State(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public State() {
        this(VuforiaJNI.new_State__SWIG_0(), true);
    }

    public State(State other) {
        this(VuforiaJNI.new_State__SWIG_1(State.getCPtr(other), other), true);
    }

    protected static long getCPtr(State obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_State(this.swigCPtr);
            }
            Object object = this.mFrameMutex;
            synchronized (object) {
                if (this.mFrame != null) {
                    this.mFrame.delete();
                    this.mFrame = null;
                }
            }
            this.swigCPtr = 0;
        }
    }

    public State clone() {
        return new State(this);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof State) {
            equal = ((State)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Frame getFrame() {
        Object object = this.mFrameMutex;
        synchronized (object) {
            if (this.mFrame == null) {
                this.mFrame = new Frame(VuforiaJNI.State_getFrame(this.swigCPtr, this), true);
            }
        }
        return this.mFrame;
    }

    public int getNumTrackables() {
        return VuforiaJNI.State_getNumTrackables(this.swigCPtr, this);
    }

    public Trackable getTrackable(int idx) {
        long cPtr = VuforiaJNI.State_getTrackable(this.swigCPtr, this, idx);
        if (cPtr == 0) {
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

    public int getNumTrackableResults() {
        return VuforiaJNI.State_getNumTrackableResults(this.swigCPtr, this);
    }

    public TrackableResult getTrackableResult(int idx) {
        long cPtr = VuforiaJNI.State_getTrackableResult(this.swigCPtr, this, idx);
        if (cPtr == 0) {
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

