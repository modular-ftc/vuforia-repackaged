/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

import java.nio.ByteBuffer;

public class Image {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Image(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Image obj) {
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
        if (obj instanceof Image) {
            equal = ((Image)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public int getWidth() {
        return VuforiaJNI.Image_getWidth(this.swigCPtr, this);
    }

    public int getHeight() {
        return VuforiaJNI.Image_getHeight(this.swigCPtr, this);
    }

    public int getStride() {
        return VuforiaJNI.Image_getStride(this.swigCPtr, this);
    }

    public int getBufferWidth() {
        return VuforiaJNI.Image_getBufferWidth(this.swigCPtr, this);
    }

    public int getBufferHeight() {
        return VuforiaJNI.Image_getBufferHeight(this.swigCPtr, this);
    }

    public int getFormat() {
        return VuforiaJNI.Image_getFormat(this.swigCPtr, this);
    }

    public ByteBuffer getPixels() {
        return VuforiaJNI.Image_getPixels(this.swigCPtr, this);
    }
}

