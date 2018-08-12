/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class TrackerManager {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TrackerManager(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(TrackerManager obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public static TrackerManager getInstance() {
        if (!Vuforia.wasInitializedJava()) {
            throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
        }
        return new TrackerManager(VuforiaJNI.TrackerManager_getInstance(), false);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof TrackerManager) {
            equal = ((TrackerManager)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
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

    public Tracker initTracker(Type type) {
        long cPtr = VuforiaJNI.TrackerManager_initTracker(this.swigCPtr, this, Type.getCPtr(type), type);
        if (cPtr == 0L) {
            return null;
        }
        Tracker tmp = new Tracker(cPtr, false);
        if (tmp.isOfType(ObjectTracker.getClassType())) {
            return new ObjectTracker(cPtr, false);
        }
        if (tmp.isOfType(TextTracker.getClassType())) {
            return new TextTracker(cPtr, false);
        }
        if (tmp.isOfType(MarkerTracker.getClassType())) {
            return new MarkerTracker(cPtr, false);
        }
        if (tmp.isOfType(SmartTerrainTracker.getClassType())) {
            return new SmartTerrainTracker(cPtr, false);
        }
        if (tmp.isOfType(RotationalDeviceTracker.getClassType())) {
            return new RotationalDeviceTracker(cPtr, false);
        }
        return null;
    }

    public Tracker getTracker(Type type) {
        long cPtr = VuforiaJNI.TrackerManager_getTracker(this.swigCPtr, this, Type.getCPtr(type), type);
        if (cPtr == 0L) {
            return null;
        }
        Tracker tmp = new Tracker(cPtr, false);
        if (tmp.isOfType(ObjectTracker.getClassType())) {
            return new ObjectTracker(cPtr, false);
        }
        if (tmp.isOfType(TextTracker.getClassType())) {
            return new TextTracker(cPtr, false);
        }
        if (tmp.isOfType(MarkerTracker.getClassType())) {
            return new MarkerTracker(cPtr, false);
        }
        if (tmp.isOfType(SmartTerrainTracker.getClassType())) {
            return new SmartTerrainTracker(cPtr, false);
        }
        if (tmp.isOfType(RotationalDeviceTracker.getClassType())) {
            return new RotationalDeviceTracker(cPtr, false);
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

