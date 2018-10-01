/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class TextureData {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TextureData(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(TextureData textureData) {
        return textureData == null ? 0L : textureData.swigCPtr;
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

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof TextureData) {
            bl = ((TextureData)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public int type() {
        return VuforiaJNI.TextureData_type(this.swigCPtr, this);
    }
}

