/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Anchor;
import com.vuforia.CylinderTarget;
import com.vuforia.DeviceTrackable;
import com.vuforia.ImageTarget;
import com.vuforia.Matrix34F;
import com.vuforia.ModelTarget;
import com.vuforia.MultiTarget;
import com.vuforia.ObjectTarget;
import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.VuMarkTarget;
import com.vuforia.VuMarkTemplate;
import com.vuforia.VuforiaJNI;

public class TrackableResult {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TrackableResult(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(TrackableResult trackableResult) {
        return trackableResult == null ? 0L : trackableResult.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TrackableResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof TrackableResult) {
            bl = ((TrackableResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.TrackableResult_getClassType(), true);
    }

    public Type getType() {
        return new Type(VuforiaJNI.TrackableResult_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.TrackableResult_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public double getTimeStamp() {
        return VuforiaJNI.TrackableResult_getTimeStamp(this.swigCPtr, this);
    }

    public int getStatus() {
        return VuforiaJNI.TrackableResult_getStatus(this.swigCPtr, this);
    }

    public int getStatusInfo() {
        return VuforiaJNI.TrackableResult_getStatusInfo(this.swigCPtr, this);
    }

    public Trackable getTrackable() {
        long l = VuforiaJNI.TrackableResult_getTrackable(this.swigCPtr, this);
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

    public Matrix34F getPose() {
        return new Matrix34F(VuforiaJNI.TrackableResult_getPose(this.swigCPtr, this), false);
    }

    public int getCoordinateSystem() {
        return VuforiaJNI.TrackableResult_getCoordinateSystem(this.swigCPtr, this);
    }

    public static final class STATUS_INFO {
        public static final int NORMAL = 0;
        public static final int UNKNOWN = 1;
        public static final int INITIALIZING = 2;
        public static final int EXCESSIVE_MOTION = 3;
        public static final int INSUFFICIENT_FEATURES = 4;
    }

    public static final class STATUS {
        public static final int NO_POSE = 0;
        public static final int LIMITED = 1;
        public static final int DETECTED = 2;
        public static final int TRACKED = 3;
        public static final int EXTENDED_TRACKED = 4;

        private STATUS() {
        }
    }

}

