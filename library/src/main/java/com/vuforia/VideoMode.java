/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class VideoMode {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected VideoMode(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public VideoMode() {
        this(VuforiaJNI.new_VideoMode__SWIG_0(), true);
    }

    public VideoMode(VideoMode other) {
        this(VuforiaJNI.new_VideoMode__SWIG_1(VideoMode.getCPtr(other), other), true);
    }

    protected static long getCPtr(VideoMode obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VideoMode(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof VideoMode) {
            equal = ((VideoMode)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public int getWidth() {
        return VuforiaJNI.VideoMode_Width_get(this.swigCPtr, this);
    }

    public int getHeight() {
        return VuforiaJNI.VideoMode_Height_get(this.swigCPtr, this);
    }

    public float getFramerate() {
        return VuforiaJNI.VideoMode_Framerate_get(this.swigCPtr, this);
    }
}

