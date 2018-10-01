/*
 * Decompiled with CFR 0_133.
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

    protected ImageTarget(long l, boolean bl) {
        super(VuforiaJNI.ImageTarget_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(ImageTarget imageTarget) {
        return imageTarget == null ? 0L : imageTarget.swigCPtr;
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
                VuforiaJNI.delete_ImageTarget(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof ImageTarget) {
            bl = ((ImageTarget)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ImageTarget_getClassType(), true);
    }

    public int getNumVirtualButtons() {
        return VuforiaJNI.ImageTarget_getNumVirtualButtons(this.swigCPtr, this);
    }

    public VirtualButton getVirtualButton(int n) {
        long l = VuforiaJNI.ImageTarget_getVirtualButton__SWIG_0(this.swigCPtr, this, n);
        return l == 0L ? null : new VirtualButton(l, false);
    }

    public VirtualButton getVirtualButton(String string) {
        long l = VuforiaJNI.ImageTarget_getVirtualButton__SWIG_1(this.swigCPtr, this, string);
        return l == 0L ? null : new VirtualButton(l, false);
    }

    public VirtualButton createVirtualButton(String string, Area area) {
        long l = VuforiaJNI.ImageTarget_createVirtualButton(this.swigCPtr, this, string, Area.getCPtr(area), area);
        return l == 0L ? null : new VirtualButton(l, false);
    }

    public boolean destroyVirtualButton(VirtualButton virtualButton) {
        return VuforiaJNI.ImageTarget_destroyVirtualButton(this.swigCPtr, this, VirtualButton.getCPtr(virtualButton), virtualButton);
    }

    public String getMetaData() {
        return VuforiaJNI.ImageTarget_getMetaData(this.swigCPtr, this);
    }
}

