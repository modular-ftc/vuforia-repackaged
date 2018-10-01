/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.ObjectTracker;
import com.vuforia.PositionalDeviceTracker;
import com.vuforia.RotationalDeviceTracker;
import com.vuforia.SmartTerrain;
import com.vuforia.StateUpdater;
import com.vuforia.Tracker;
import com.vuforia.Type;
import com.vuforia.Vuforia;
import com.vuforia.VuforiaJNI;

public class TrackerManager {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TrackerManager(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(TrackerManager trackerManager) {
        return trackerManager == null ? 0L : trackerManager.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TrackerManager(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof TrackerManager) {
            bl = ((TrackerManager)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static TrackerManager getInstance() {
        if (!Vuforia.wasInitializedJava()) {
            throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
        }
        return new TrackerManager(VuforiaJNI.TrackerManager_getInstance(), false);
    }

    public Tracker initTracker(Type type) {
        long l = VuforiaJNI.TrackerManager_initTracker(this.swigCPtr, this, Type.getCPtr(type), type);
        if (l == 0L) {
            return null;
        }
        Tracker tracker = new Tracker(l, false);
        if (tracker.isOfType(ObjectTracker.getClassType())) {
            return new ObjectTracker(l, false);
        }
        if (tracker.isOfType(SmartTerrain.getClassType())) {
            return new SmartTerrain(l, false);
        }
        if (tracker.isOfType(RotationalDeviceTracker.getClassType())) {
            return new RotationalDeviceTracker(l, false);
        }
        if (tracker.isOfType(PositionalDeviceTracker.getClassType())) {
            return new PositionalDeviceTracker(l, false);
        }
        return null;
    }

    public Tracker getTracker(Type type) {
        long l = VuforiaJNI.TrackerManager_getTracker(this.swigCPtr, this, Type.getCPtr(type), type);
        if (l == 0L) {
            return null;
        }
        Tracker tracker = new Tracker(l, false);
        if (tracker.isOfType(ObjectTracker.getClassType())) {
            return new ObjectTracker(l, false);
        }
        if (tracker.isOfType(SmartTerrain.getClassType())) {
            return new SmartTerrain(l, false);
        }
        if (tracker.isOfType(RotationalDeviceTracker.getClassType())) {
            return new RotationalDeviceTracker(l, false);
        }
        if (tracker.isOfType(PositionalDeviceTracker.getClassType())) {
            return new PositionalDeviceTracker(l, false);
        }
        return null;
    }

    public boolean deinitTracker(Type type) {
        return VuforiaJNI.TrackerManager_deinitTracker(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public StateUpdater getStateUpdater() {
        return new StateUpdater(VuforiaJNI.TrackerManager_getStateUpdater(this.swigCPtr, this), false);
    }
}

