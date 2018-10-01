/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;
import java.nio.ByteBuffer;

public class Mesh {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Mesh(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Mesh mesh) {
        return mesh == null ? 0L : mesh.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Mesh(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Mesh) {
            bl = ((Mesh)object).swigCPtr == this.swigCPtr;
        }
        return bl;
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

