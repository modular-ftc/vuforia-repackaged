/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.ObjectTarget;
import com.vuforia.Type;
import com.vuforia.Vec2F;
import com.vuforia.VuforiaJNI;

public class VuMarkTemplate
extends ObjectTarget {
    private long swigCPtr;

    protected VuMarkTemplate(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.VuMarkTemplate_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(VuMarkTemplate obj) {
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
                VuforiaJNI.delete_VuMarkTemplate(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof VuMarkTemplate) {
            equal = ((VuMarkTemplate)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.VuMarkTemplate_getClassType(), true);
    }

    public String getVuMarkUserData() {
        return VuforiaJNI.VuMarkTemplate_getVuMarkUserData(this.swigCPtr, this);
    }

    public void setTrackingFromRuntimeAppearance(boolean enable) {
        VuforiaJNI.VuMarkTemplate_setTrackingFromRuntimeAppearance(this.swigCPtr, this, enable);
    }

    public boolean isTrackingFromRuntimeAppearanceEnabled() {
        return VuforiaJNI.VuMarkTemplate_isTrackingFromRuntimeAppearanceEnabled(this.swigCPtr, this);
    }

    public Vec2F getOrigin() {
        return new Vec2F(VuforiaJNI.VuMarkTemplate_getOrigin(this.swigCPtr, this), true);
    }
}

