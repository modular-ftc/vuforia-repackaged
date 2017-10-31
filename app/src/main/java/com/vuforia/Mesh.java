/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;
import java.nio.ByteBuffer;

public class Mesh {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Mesh(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Mesh obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Mesh(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Mesh) {
            equal = ((Mesh)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public int getNumVertices() {
        return VuforiaJNI.Mesh_getNumVertices(this.swigCPtr, this);
    }

    public boolean hasPositions() {
        return VuforiaJNI.Mesh_hasPositions(this.swigCPtr, this);
    }

    public ByteBuffer getPositions() {
        return VuforiaJNI.Mesh_getPositions(this.swigCPtr, this);
    }

    public boolean hasNormals() {
        return VuforiaJNI.Mesh_hasNormals(this.swigCPtr, this);
    }

    public ByteBuffer getNormals() {
        return VuforiaJNI.Mesh_getNormals(this.swigCPtr, this);
    }

    public boolean hasUVs() {
        return VuforiaJNI.Mesh_hasUVs(this.swigCPtr, this);
    }

    public ByteBuffer getUVs() {
        return VuforiaJNI.Mesh_getUVs(this.swigCPtr, this);
    }

    public int getNumTriangles() {
        return VuforiaJNI.Mesh_getNumTriangles(this.swigCPtr, this);
    }

    public ByteBuffer getTriangles() {
        return VuforiaJNI.Mesh_getTriangles(this.swigCPtr, this);
    }
}

