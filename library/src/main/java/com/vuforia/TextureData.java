/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class TextureData {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TextureData(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(TextureData obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof TextureData) {
            equal = ((TextureData)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public int type() {
        return VuforiaJNI.TextureData_type(this.swigCPtr, this);
    }
}

