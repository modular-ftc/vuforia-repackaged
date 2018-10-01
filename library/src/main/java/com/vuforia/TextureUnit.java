/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class TextureUnit {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TextureUnit(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(TextureUnit textureUnit) {
        return textureUnit == null ? 0L : textureUnit.swigCPtr;
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
        if (object instanceof TextureUnit) {
            bl = ((TextureUnit)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public int type() {
        return VuforiaJNI.TextureUnit_type(this.swigCPtr, this);
    }
}

