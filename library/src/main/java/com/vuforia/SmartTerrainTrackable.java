/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class SmartTerrainTrackable
extends Trackable {
    private long swigCPtr;

    protected SmartTerrainTrackable(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.SmartTerrainTrackable_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(SmartTerrainTrackable obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.SmartTerrainTrackable_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof SmartTerrainTrackable) {
            equal = ((SmartTerrainTrackable)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_SmartTerrainTrackable(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public Mesh getMesh() {
        long cPtr = VuforiaJNI.SmartTerrainTrackable_getMesh(this.swigCPtr, this);
        return cPtr == 0L ? null : new Mesh(cPtr, false);
    }

    public int getRevision() {
        return VuforiaJNI.SmartTerrainTrackable_getRevision(this.swigCPtr, this);
    }

    public Matrix34F getLocalPose() {
        return new Matrix34F(VuforiaJNI.SmartTerrainTrackable_getLocalPose(this.swigCPtr, this), false);
    }

    public SmartTerrainTrackable getParent() {
        long cPtr = VuforiaJNI.SmartTerrainTrackable_getParent(this.swigCPtr, this);
        return cPtr == 0L ? null : new SmartTerrainTrackable(cPtr, false);
    }

    public long getChildrenCount() {
        return VuforiaJNI.SmartTerrainTrackable_getChildrenCount(this.swigCPtr, this);
    }

    public SmartTerrainTrackable getChild(long idx) {
        long cPtr = VuforiaJNI.SmartTerrainTrackable_getChild(this.swigCPtr, this, idx);
        return cPtr == 0L ? null : new SmartTerrainTrackable(cPtr, false);
    }
}

