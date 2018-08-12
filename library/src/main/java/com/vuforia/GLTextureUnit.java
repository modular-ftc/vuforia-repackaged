/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class GLTextureUnit
extends TextureUnit {
    private long swigCPtr;

    protected GLTextureUnit(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.GLTextureUnit_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    public GLTextureUnit(int unit) {
        this(VuforiaJNI.new_GLTextureUnit__SWIG_0(unit), true);
    }

    protected static long getCPtr(GLTextureUnit obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    public GLTextureUnit() {
        this(VuforiaJNI.new_GLTextureUnit__SWIG_1(), true);
    }

    protected void finalize() {
        this.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof GLTextureUnit) {
            equal = ((GLTextureUnit) obj).swigCPtr == this.swigCPtr;
        }
        return equal;
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

    public void setTextureUnit(int value) {
        VuforiaJNI.GLTextureUnit_TextureUnit_set(this.swigCPtr, this, value);
    }

    public int getTextureUnit() {
        return VuforiaJNI.GLTextureUnit_TextureUnit_get(this.swigCPtr, this);
    }
}

