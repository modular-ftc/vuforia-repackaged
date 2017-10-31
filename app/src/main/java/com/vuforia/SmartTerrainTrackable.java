/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Matrix34F;
import com.vuforia.Mesh;
import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class SmartTerrainTrackable
extends Trackable {
    private long swigCPtr;

    protected SmartTerrainTrackable(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.SmartTerrainTrackable_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(SmartTerrainTrackable obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_SmartTerrainTrackable(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof SmartTerrainTrackable) {
            equal = ((SmartTerrainTrackable)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.SmartTerrainTrackable_getClassType(), true);
    }

    public Mesh getMesh() {
        long cPtr = VuforiaJNI.SmartTerrainTrackable_getMesh(this.swigCPtr, this);
        return cPtr == 0 ? null : new Mesh(cPtr, false);
    }

    public int getRevision() {
        return VuforiaJNI.SmartTerrainTrackable_getRevision(this.swigCPtr, this);
    }

    public Matrix34F getLocalPose() {
        return new Matrix34F(VuforiaJNI.SmartTerrainTrackable_getLocalPose(this.swigCPtr, this), false);
    }

    public SmartTerrainTrackable getParent() {
        long cPtr = VuforiaJNI.SmartTerrainTrackable_getParent(this.swigCPtr, this);
        return cPtr == 0 ? null : new SmartTerrainTrackable(cPtr, false);
    }

    public long getChildrenCount() {
        return VuforiaJNI.SmartTerrainTrackable_getChildrenCount(this.swigCPtr, this);
    }

    public SmartTerrainTrackable getChild(long idx) {
        long cPtr = VuforiaJNI.SmartTerrainTrackable_getChild(this.swigCPtr, this, idx);
        return cPtr == 0 ? null : new SmartTerrainTrackable(cPtr, false);
    }
}

