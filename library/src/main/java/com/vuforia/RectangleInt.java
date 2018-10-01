/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Area;
import com.vuforia.VuforiaJNI;

public class RectangleInt
extends Area {
    private long swigCPtr;

    protected RectangleInt(long l, boolean bl) {
        super(VuforiaJNI.RectangleInt_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(RectangleInt rectangleInt) {
        return rectangleInt == null ? 0L : rectangleInt.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
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

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof RectangleInt) {
            bl = ((RectangleInt)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public RectangleInt() {
        this(VuforiaJNI.new_RectangleInt__SWIG_0(), true);
    }

    public RectangleInt(RectangleInt rectangleInt) {
        this(VuforiaJNI.new_RectangleInt__SWIG_1(RectangleInt.getCPtr(rectangleInt), rectangleInt), true);
    }

    public RectangleInt(int n, int n2, int n3, int n4) {
        this(VuforiaJNI.new_RectangleInt__SWIG_2(n, n2, n3, n4), true);
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

