/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Area;
import com.vuforia.VuforiaJNI;

public class Rectangle
extends Area {
    private long swigCPtr;

    protected Rectangle(long l, boolean bl) {
        super(VuforiaJNI.Rectangle_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(Rectangle rectangle) {
        return rectangle == null ? 0L : rectangle.swigCPtr;
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
                VuforiaJNI.delete_Rectangle(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Rectangle) {
            bl = ((Rectangle)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Rectangle() {
        this(VuforiaJNI.new_Rectangle__SWIG_0(), true);
    }

    public Rectangle(Rectangle rectangle) {
        this(VuforiaJNI.new_Rectangle__SWIG_1(Rectangle.getCPtr(rectangle), rectangle), true);
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        this(VuforiaJNI.new_Rectangle__SWIG_2(f, f2, f3, f4), true);
    }

    public float getLeftTopX() {
        return VuforiaJNI.Rectangle_getLeftTopX(this.swigCPtr, this);
    }

    public float getLeftTopY() {
        return VuforiaJNI.Rectangle_getLeftTopY(this.swigCPtr, this);
    }

    public float getRightBottomX() {
        return VuforiaJNI.Rectangle_getRightBottomX(this.swigCPtr, this);
    }

    public float getRightBottomY() {
        return VuforiaJNI.Rectangle_getRightBottomY(this.swigCPtr, this);
    }

    public float getWidth() {
        return VuforiaJNI.Rectangle_getWidth(this.swigCPtr, this);
    }

    public float getHeight() {
        return VuforiaJNI.Rectangle_getHeight(this.swigCPtr, this);
    }

    public float getAreaSize() {
        return VuforiaJNI.Rectangle_getAreaSize(this.swigCPtr, this);
    }

    @Override
    public int getType() {
        return VuforiaJNI.Rectangle_getType(this.swigCPtr, this);
    }
}

