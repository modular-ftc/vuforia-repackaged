/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

import java.nio.ByteBuffer;

public class Surface
extends SmartTerrainTrackable {
    private long swigCPtr;

    protected Surface(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.Surface_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Surface obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Surface_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Surface) {
            equal = ((Surface)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Surface(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public Mesh getNavMesh() {
        long cPtr = VuforiaJNI.Surface_getNavMesh(this.swigCPtr, this);
        return cPtr == 0L ? null : new Mesh(cPtr, false);
    }

    public Rectangle getBoundingBox() {
        return new Rectangle(VuforiaJNI.Surface_getBoundingBox(this.swigCPtr, this), false);
    }

    public int getNumMeshBoundaries() {
        return VuforiaJNI.Surface_getNumMeshBoundaries(this.swigCPtr, this);
    }

    public ByteBuffer getMeshBoundaries() {
        return VuforiaJNI.Surface_getMeshBoundaries(this.swigCPtr, this);
    }
}

