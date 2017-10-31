/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class TextureUnit {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TextureUnit(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(TextureUnit obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof TextureUnit) {
            equal = ((TextureUnit)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public int type() {
        return VuforiaJNI.TextureUnit_type(this.swigCPtr, this);
    }
}

