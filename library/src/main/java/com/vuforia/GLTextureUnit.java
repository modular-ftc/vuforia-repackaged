/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.TextureUnit;
import com.vuforia.VuforiaJNI;

public class GLTextureUnit
extends TextureUnit {
    private long swigCPtr;

    protected GLTextureUnit(long l, boolean bl) {
        super(VuforiaJNI.GLTextureUnit_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(GLTextureUnit gLTextureUnit) {
        return gLTextureUnit == null ? 0L : gLTextureUnit.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_GLTextureUnit(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof GLTextureUnit) {
            bl = ((GLTextureUnit)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public GLTextureUnit(int n) {
        this(VuforiaJNI.new_GLTextureUnit__SWIG_0(n), true);
    }

    public GLTextureUnit() {
        this(VuforiaJNI.new_GLTextureUnit__SWIG_1(), true);
    }

    public void setTextureUnit(int n) {
        VuforiaJNI.GLTextureUnit_TextureUnit_set(this.swigCPtr, this, n);
    }

    public int getTextureUnit() {
        return VuforiaJNI.GLTextureUnit_TextureUnit_get(this.swigCPtr, this);
    }
}

