/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.TextureUnit;
import com.vuforia.VuforiaJNI;

public class GLTextureUnit
extends TextureUnit {
    private long swigCPtr;

    protected GLTextureUnit(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.GLTextureUnit_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(GLTextureUnit obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_GLTextureUnit(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof GLTextureUnit) {
            equal = ((GLTextureUnit)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public GLTextureUnit(int unit) {
        this(VuforiaJNI.new_GLTextureUnit__SWIG_0(unit), true);
    }

    public GLTextureUnit() {
        this(VuforiaJNI.new_GLTextureUnit__SWIG_1(), true);
    }

    public void setTextureUnit(int value) {
        VuforiaJNI.GLTextureUnit_TextureUnit_set(this.swigCPtr, this, value);
    }

    public int getTextureUnit() {
        return VuforiaJNI.GLTextureUnit_TextureUnit_get(this.swigCPtr, this);
    }
}

