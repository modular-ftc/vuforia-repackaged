/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Anchor;
import com.vuforia.AnchorResult;
import com.vuforia.CameraCalibration;
import com.vuforia.CylinderTarget;
import com.vuforia.CylinderTargetResult;
import com.vuforia.DeviceTrackable;
import com.vuforia.DeviceTrackableResult;
import com.vuforia.Frame;
import com.vuforia.Illumination;
import com.vuforia.ImageTarget;
import com.vuforia.ImageTargetResult;
import com.vuforia.ModelTarget;
import com.vuforia.ModelTargetResult;
import com.vuforia.MultiTarget;
import com.vuforia.MultiTargetResult;
import com.vuforia.ObjectTarget;
import com.vuforia.ObjectTargetResult;
import com.vuforia.Trackable;
import com.vuforia.TrackableResult;
import com.vuforia.Type;
import com.vuforia.VuMarkTarget;
import com.vuforia.VuMarkTargetResult;
import com.vuforia.VuMarkTemplate;
import com.vuforia.VuforiaJNI;

public class State
implements Cloneable {
    private long swigCPtr;
    protected boolean swigCMemOwn;
    private Frame mFrame = null;
    private Object mFrameMutex = new Object();

    protected State(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(State state) {
        return state == null ? 0L : state.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
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
            this.swigCPtr = 0L;
        }
    }

    public State clone() {
        return new State(this);
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof State) {
            bl = ((State)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public State() {
        this(VuforiaJNI.new_State__SWIG_0(), true);
    }

    public State(State state) {
        this(VuforiaJNI.new_State__SWIG_1(State.getCPtr(state), state), true);
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

    public CameraCalibration getCameraCalibration() {
        long l = VuforiaJNI.State_getCameraCalibration(this.swigCPtr, this);
        return l == 0L ? null : new CameraCalibration(l, false);
    }

    public Illumination getIllumination() {
        long l = VuforiaJNI.State_getIllumination(this.swigCPtr, this);
        return l == 0L ? null : new Illumination(l, false);
    }

    public int getNumTrackables() {
        return VuforiaJNI.State_getNumTrackables(this.swigCPtr, this);
    }

    public Trackable getTrackable(int n) {
        long l = VuforiaJNI.State_getTrackable(this.swigCPtr, this, n);
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

    public int getNumTrackableResults() {
        return VuforiaJNI.State_getNumTrackableResults(this.swigCPtr, this);
    }

    public TrackableResult getTrackableResult(int n) {
        long l = VuforiaJNI.State_getTrackableResult(this.swigCPtr, this, n);
        if (l == 0L) {
            return null;
        }
        TrackableResult trackableResult = new TrackableResult(l, false);
        if (trackableResult.isOfType(ImageTargetResult.getClassType())) {
            return new ImageTargetResult(l, false);
        }
        if (trackableResult.isOfType(CylinderTargetResult.getClassType())) {
            return new CylinderTargetResult(l, false);
        }
        if (trackableResult.isOfType(MultiTargetResult.getClassType())) {
            return new MultiTargetResult(l, false);
        }
        if (trackableResult.isOfType(VuMarkTargetResult.getClassType())) {
            return new VuMarkTargetResult(l, false);
        }
        if (trackableResult.isOfType(ModelTargetResult.getClassType())) {
            return new ModelTargetResult(l, false);
        }
        if (trackableResult.isOfType(ObjectTargetResult.getClassType())) {
            return new ObjectTargetResult(l, false);
        }
        if (trackableResult.isOfType(AnchorResult.getClassType())) {
            return new AnchorResult(l, false);
        }
        if (trackableResult.isOfType(DeviceTrackableResult.getClassType())) {
            return new DeviceTrackableResult(l, false);
        }
        return null;
    }

    public DeviceTrackableResult getDeviceTrackableResult() {
        long l = VuforiaJNI.State_getDeviceTrackableResult(this.swigCPtr, this);
        return l == 0L ? null : new DeviceTrackableResult(l, false);
    }
}

