/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.TextureData;
import com.vuforia.VuforiaJNI;

public class GLTextureData
extends TextureData {
    private long swigCPtr;

    protected GLTextureData(long l, boolean bl) {
        super(VuforiaJNI.GLTextureData_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(GLTextureData gLTextureData) {
        return gLTextureData == null ? 0L : gLTextureData.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_GLTextureData(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof GLTextureData) {
            bl = ((GLTextureData)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public GLTextureData(int n) {
        this(VuforiaJNI.new_GLTextureData__SWIG_0(n), true);
    }

    public GLTextureData() {
        this(VuforiaJNI.new_GLTextureData__SWIG_1(), true);
    }

    public void setVideoBackgroundTextureID(int n) {
        VuforiaJNI.GLTextureData_VideoBackgroundTextureID_set(this.swigCPtr, this, n);
    }

    public int getVideoBackgroundTextureID() {
        return VuforiaJNI.GLTextureData_VideoBackgroundTextureID_get(this.swigCPtr, this);
    }
}

