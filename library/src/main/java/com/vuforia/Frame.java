/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Image;
import com.vuforia.VuforiaJNI;

public class Frame
implements Cloneable {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Frame(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Frame frame) {
        return frame == null ? 0L : frame.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Frame(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public Frame clone() {
        return new Frame(this);
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Frame) {
            bl = ((Frame)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Frame() {
        this(VuforiaJNI.new_Frame__SWIG_0(), true);
    }

    public Frame(Frame frame) {
        this(VuforiaJNI.new_Frame__SWIG_1(Frame.getCPtr(frame), frame), true);
    }

    public double getTimeStamp() {
        return VuforiaJNI.Frame_getTimeStamp(this.swigCPtr, this);
    }

    public int getIndex() {
        return VuforiaJNI.Frame_getIndex(this.swigCPtr, this);
    }

    public long getNumImages() {
        return VuforiaJNI.Frame_getNumImages(this.swigCPtr, this);
    }

    public Image getImage(int n) {
        long l = VuforiaJNI.Frame_getImage(this.swigCPtr, this, n);
        return l == 0L ? null : new Image(l, false);
    }
}

