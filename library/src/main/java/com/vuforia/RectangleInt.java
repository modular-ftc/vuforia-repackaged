/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class RectangleInt
extends Area {
    private long swigCPtr;

    protected RectangleInt(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.RectangleInt_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    public RectangleInt() {
        this(VuforiaJNI.new_RectangleInt__SWIG_0(), true);
    }

    protected static long getCPtr(RectangleInt obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    public RectangleInt(RectangleInt other) {
        this(VuforiaJNI.new_RectangleInt__SWIG_1(RectangleInt.getCPtr(other), other), true);
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public RectangleInt(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY) {
        this(VuforiaJNI.new_RectangleInt__SWIG_2(leftTopX, leftTopY, rightBottomX, rightBottomY), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof RectangleInt) {
            equal = ((RectangleInt) obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_RectangleInt(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public int getLeftTopX() {
        return VuforiaJNI.RectangleInt_getLeftTopX(this.swigCPtr, this);
    }

    public int getLeftTopY() {
        return VuforiaJNI.RectangleInt_getLeftTopY(this.swigCPtr, this);
    }

    public int getRightBottomX() {
        return VuforiaJNI.RectangleInt_getRightBottomX(this.swigCPtr, this);
    }

    public int getRightBottomY() {
        return VuforiaJNI.RectangleInt_getRightBottomY(this.swigCPtr, this);
    }

    public int getWidth() {
        return VuforiaJNI.RectangleInt_getWidth(this.swigCPtr, this);
    }

    public int getHeight() {
        return VuforiaJNI.RectangleInt_getHeight(this.swigCPtr, this);
    }

    public int getAreaSize() {
        return VuforiaJNI.RectangleInt_getAreaSize(this.swigCPtr, this);
    }

    @Override
    public int getType() {
        return VuforiaJNI.RectangleInt_getType(this.swigCPtr, this);
    }
}

