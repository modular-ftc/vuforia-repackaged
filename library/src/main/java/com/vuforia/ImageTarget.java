/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class ImageTarget
extends ObjectTarget {
    private long swigCPtr;

    protected ImageTarget(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.ImageTarget_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(ImageTarget obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ImageTarget_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof ImageTarget) {
            equal = ((ImageTarget)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ImageTarget(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public int getNumVirtualButtons() {
        return VuforiaJNI.ImageTarget_getNumVirtualButtons(this.swigCPtr, this);
    }

    public VirtualButton getVirtualButton(int idx) {
        long cPtr = VuforiaJNI.ImageTarget_getVirtualButton__SWIG_0(this.swigCPtr, this, idx);
        return cPtr == 0L ? null : new VirtualButton(cPtr, false);
    }

    public VirtualButton getVirtualButton(String name) {
        long cPtr = VuforiaJNI.ImageTarget_getVirtualButton__SWIG_1(this.swigCPtr, this, name);
        return cPtr == 0L ? null : new VirtualButton(cPtr, false);
    }

    public VirtualButton createVirtualButton(String name, Area area) {
        long cPtr = VuforiaJNI.ImageTarget_createVirtualButton(this.swigCPtr, this, name, Area.getCPtr(area), area);
        return cPtr == 0L ? null : new VirtualButton(cPtr, false);
    }

    public boolean destroyVirtualButton(VirtualButton button) {
        return VuforiaJNI.ImageTarget_destroyVirtualButton(this.swigCPtr, this, VirtualButton.getCPtr(button), button);
    }

    public String getMetaData() {
        return VuforiaJNI.ImageTarget_getMetaData(this.swigCPtr, this);
    }
}

