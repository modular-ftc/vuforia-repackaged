/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Area;
import com.vuforia.ObjectTarget;
import com.vuforia.Type;
import com.vuforia.VirtualButton;
import com.vuforia.VuforiaJNI;

public class ImageTarget
extends ObjectTarget {
    private long swigCPtr;

    protected ImageTarget(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.ImageTarget_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(ImageTarget obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ImageTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof ImageTarget) {
            equal = ((ImageTarget)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ImageTarget_getClassType(), true);
    }

    public int getNumVirtualButtons() {
        return VuforiaJNI.ImageTarget_getNumVirtualButtons(this.swigCPtr, this);
    }

    public VirtualButton getVirtualButton(int idx) {
        long cPtr = VuforiaJNI.ImageTarget_getVirtualButton__SWIG_0(this.swigCPtr, this, idx);
        return cPtr == 0 ? null : new VirtualButton(cPtr, false);
    }

    public VirtualButton getVirtualButton(String name) {
        long cPtr = VuforiaJNI.ImageTarget_getVirtualButton__SWIG_1(this.swigCPtr, this, name);
        return cPtr == 0 ? null : new VirtualButton(cPtr, false);
    }

    public VirtualButton createVirtualButton(String name, Area area) {
        long cPtr = VuforiaJNI.ImageTarget_createVirtualButton(this.swigCPtr, this, name, Area.getCPtr(area), area);
        return cPtr == 0 ? null : new VirtualButton(cPtr, false);
    }

    public boolean destroyVirtualButton(VirtualButton button) {
        return VuforiaJNI.ImageTarget_destroyVirtualButton(this.swigCPtr, this, VirtualButton.getCPtr(button), button);
    }

    public String getMetaData() {
        return VuforiaJNI.ImageTarget_getMetaData(this.swigCPtr, this);
    }
}

