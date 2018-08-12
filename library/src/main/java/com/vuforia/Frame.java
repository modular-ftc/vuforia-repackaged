/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class Frame
implements Cloneable {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Frame(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Frame() {
        this(VuforiaJNI.new_Frame__SWIG_0(), true);
    }

    protected void finalize() {
        this.delete();
    }

    public Frame(Frame other) {
        this(VuforiaJNI.new_Frame__SWIG_1(Frame.getCPtr(other), other), true);
    }

    public Frame clone() {
        return new Frame(this);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Frame) {
            equal = ((Frame)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    protected static long getCPtr(Frame obj) {
        return obj == null ? 0L : obj.swigCPtr;
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

    public double getTimeStamp() {
        return VuforiaJNI.Frame_getTimeStamp(this.swigCPtr, this);
    }

    public int getIndex() {
        return VuforiaJNI.Frame_getIndex(this.swigCPtr, this);
    }

    public long getNumImages() {
        return VuforiaJNI.Frame_getNumImages(this.swigCPtr, this);
    }

    public Image getImage(int idx) {
        long cPtr = VuforiaJNI.Frame_getImage(this.swigCPtr, this, idx);
        return cPtr == 0L ? null : new Image(cPtr, false);
    }
}

