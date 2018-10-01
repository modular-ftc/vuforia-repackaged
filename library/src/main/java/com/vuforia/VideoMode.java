/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class VideoMode {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected VideoMode(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(VideoMode videoMode) {
        return videoMode == null ? 0L : videoMode.swigCPtr;
    }

    protected void finalize() {
        this.delete();
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

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof VideoMode) {
            bl = ((VideoMode)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public VideoMode() {
        this(VuforiaJNI.new_VideoMode__SWIG_0(), true);
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

    public VideoMode(VideoMode videoMode) {
        this(VuforiaJNI.new_VideoMode__SWIG_1(VideoMode.getCPtr(videoMode), videoMode), true);
    }
}

