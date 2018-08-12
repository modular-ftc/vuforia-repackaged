/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class VideoMode {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected VideoMode(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public VideoMode() {
        this(VuforiaJNI.new_VideoMode__SWIG_0(), true);
    }

    protected void finalize() {
        this.delete();
    }

    public VideoMode(VideoMode other) {
        this(VuforiaJNI.new_VideoMode__SWIG_1(VideoMode.getCPtr(other), other), true);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof VideoMode) {
            equal = ((VideoMode)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    protected static long getCPtr(VideoMode obj) {
        return obj == null ? 0L : obj.swigCPtr;
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

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VideoMode(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }
}

