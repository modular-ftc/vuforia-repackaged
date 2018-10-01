/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.AnchorResult;
import com.vuforia.CylinderTargetResult;
import com.vuforia.DeviceTrackableResult;
import com.vuforia.ImageTargetResult;
import com.vuforia.ModelTargetResult;
import com.vuforia.MultiTarget;
import com.vuforia.ObjectTargetResult;
import com.vuforia.Trackable;
import com.vuforia.TrackableResult;
import com.vuforia.Type;
import com.vuforia.VuMarkTargetResult;
import com.vuforia.VuforiaJNI;

public class MultiTargetResult
extends ObjectTargetResult {
    private long swigCPtr;

    protected MultiTargetResult(long l, boolean bl) {
        super(VuforiaJNI.MultiTargetResult_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(MultiTargetResult multiTargetResult) {
        return multiTargetResult == null ? 0L : multiTargetResult.swigCPtr;
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
                VuforiaJNI.delete_MultiTargetResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof MultiTargetResult) {
            bl = ((MultiTargetResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.MultiTargetResult_getClassType(), true);
    }

    @Override
    public Trackable getTrackable() {
        return new MultiTarget(VuforiaJNI.MultiTargetResult_getTrackable(this.swigCPtr, this), false);
    }

    public int getNumPartResults() {
        return VuforiaJNI.MultiTargetResult_getNumPartResults(this.swigCPtr, this);
    }

    public TrackableResult getPartResult(int n) {
        long l = VuforiaJNI.MultiTargetResult_getPartResult__SWIG_0(this.swigCPtr, this, n);
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

    public TrackableResult getPartResult(String string) {
        long l = VuforiaJNI.MultiTargetResult_getPartResult__SWIG_1(this.swigCPtr, this, string);
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
}

