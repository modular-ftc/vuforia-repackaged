/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.Vec2F;
import com.vuforia.VuforiaJNI;

public class Marker
extends Trackable {
    private long swigCPtr;

    protected Marker(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.Marker_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Marker obj) {
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
                VuforiaJNI.delete_Marker(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Marker) {
            equal = ((Marker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Marker_getClassType(), true);
    }

    public Vec2F getSize() {
        return new Vec2F(VuforiaJNI.Marker_getSize(this.swigCPtr, this), true);
    }

    public boolean setSize(Vec2F size) {
        return VuforiaJNI.Marker_setSize(this.swigCPtr, this, Vec2F.getCPtr(size), size);
    }

    public int getMarkerId() {
        return VuforiaJNI.Marker_getMarkerId(this.swigCPtr, this);
    }

    public int getMarkerType() {
        return VuforiaJNI.Marker_getMarkerType(this.swigCPtr, this);
    }

    public static final class MARKER_TYPE {
        public static final int INVALID = 0;
        public static final int ID_FRAME = 1;

        private MARKER_TYPE() {
        }
    }

}

