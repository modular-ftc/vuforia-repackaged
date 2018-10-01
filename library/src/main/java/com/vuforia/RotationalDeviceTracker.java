/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.DeviceTracker;
import com.vuforia.HandheldTransformModel;
import com.vuforia.HeadTransformModel;
import com.vuforia.TransformModel;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class RotationalDeviceTracker
extends DeviceTracker {
    private long swigCPtr;

    protected RotationalDeviceTracker(long l, boolean bl) {
        super(VuforiaJNI.RotationalDeviceTracker_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(RotationalDeviceTracker rotationalDeviceTracker) {
        return rotationalDeviceTracker == null ? 0L : rotationalDeviceTracker.swigCPtr;
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
                VuforiaJNI.delete_RotationalDeviceTracker(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof RotationalDeviceTracker) {
            bl = ((RotationalDeviceTracker)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.RotationalDeviceTracker_getClassType(), true);
    }

    public boolean recenter() {
        return VuforiaJNI.RotationalDeviceTracker_recenter(this.swigCPtr, this);
    }

    public boolean setPosePrediction(boolean bl) {
        return VuforiaJNI.RotationalDeviceTracker_setPosePrediction(this.swigCPtr, this, bl);
    }

    public boolean getPosePrediction() {
        return VuforiaJNI.RotationalDeviceTracker_getPosePrediction(this.swigCPtr, this);
    }

    public boolean setModelCorrection(TransformModel transformModel) {
        return VuforiaJNI.RotationalDeviceTracker_setModelCorrection(this.swigCPtr, this, TransformModel.getCPtr(transformModel), transformModel);
    }

    public TransformModel getModelCorrection() {
        long l = VuforiaJNI.RotationalDeviceTracker_getModelCorrection(this.swigCPtr, this);
        if (l == 0L) {
            return null;
        }
        TransformModel transformModel = new TransformModel(l, false);
        switch (transformModel.getType()) {
            case 0: {
                return new HeadTransformModel(l, false);
            }
            case 1: {
                return new HandheldTransformModel(l, false);
            }
        }
        return null;
    }

    public HeadTransformModel getDefaultHeadModel() {
        long l = VuforiaJNI.RotationalDeviceTracker_getDefaultHeadModel(this.swigCPtr, this);
        return l == 0L ? null : new HeadTransformModel(l, false);
    }

    public HandheldTransformModel getDefaultHandheldModel() {
        long l = VuforiaJNI.RotationalDeviceTracker_getDefaultHandheldModel(this.swigCPtr, this);
        return l == 0L ? null : new HandheldTransformModel(l, false);
    }
}

