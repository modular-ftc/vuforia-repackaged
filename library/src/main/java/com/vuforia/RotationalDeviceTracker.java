/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class RotationalDeviceTracker
extends DeviceTracker {
    private long swigCPtr;

    protected RotationalDeviceTracker(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.RotationalDeviceTracker_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(RotationalDeviceTracker obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.RotationalDeviceTracker_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof RotationalDeviceTracker) {
            equal = ((RotationalDeviceTracker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
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

    public boolean recenter() {
        return VuforiaJNI.RotationalDeviceTracker_recenter(this.swigCPtr, this);
    }

    public boolean setPosePrediction(boolean enable) {
        return VuforiaJNI.RotationalDeviceTracker_setPosePrediction(this.swigCPtr, this, enable);
    }

    public boolean getPosePrediction() {
        return VuforiaJNI.RotationalDeviceTracker_getPosePrediction(this.swigCPtr, this);
    }

    public boolean setModelCorrection(TransformModel transformationmodel) {
        return VuforiaJNI.RotationalDeviceTracker_setModelCorrection(this.swigCPtr, this, TransformModel.getCPtr(transformationmodel), transformationmodel);
    }

    public TransformModel getModelCorrection() {
        long cPtr = VuforiaJNI.RotationalDeviceTracker_getModelCorrection(this.swigCPtr, this);
        if (cPtr == 0L) {
            return null;
        }
        TransformModel tmp = new TransformModel(cPtr, false);
        switch (tmp.getType()) {
            case 0: {
                return new HeadTransformModel(cPtr, false);
            }
            case 1: {
                return new HandheldTransformModel(cPtr, false);
            }
        }
        return null;
    }

    public HeadTransformModel getDefaultHeadModel() {
        long cPtr = VuforiaJNI.RotationalDeviceTracker_getDefaultHeadModel(this.swigCPtr, this);
        return cPtr == 0L ? null : new HeadTransformModel(cPtr, false);
    }

    public HandheldTransformModel getDefaultHandheldModel() {
        long cPtr = VuforiaJNI.RotationalDeviceTracker_getDefaultHandheldModel(this.swigCPtr, this);
        return cPtr == 0L ? null : new HandheldTransformModel(cPtr, false);
    }
}

