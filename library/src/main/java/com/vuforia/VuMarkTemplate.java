/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.ObjectTarget;
import com.vuforia.Type;
import com.vuforia.Vec2F;
import com.vuforia.VuforiaJNI;

public class VuMarkTemplate
extends ObjectTarget {
    private long swigCPtr;

    protected VuMarkTemplate(long l, boolean bl) {
        super(VuforiaJNI.VuMarkTemplate_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(VuMarkTemplate vuMarkTemplate) {
        return vuMarkTemplate == null ? 0L : vuMarkTemplate.swigCPtr;
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
                VuforiaJNI.delete_VuMarkTemplate(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof VuMarkTemplate) {
            bl = ((VuMarkTemplate)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.VuMarkTemplate_getClassType(), true);
    }

    public String getVuMarkUserData() {
        return VuforiaJNI.VuMarkTemplate_getVuMarkUserData(this.swigCPtr, this);
    }

    public void setTrackingFromRuntimeAppearance(boolean bl) {
        VuforiaJNI.VuMarkTemplate_setTrackingFromRuntimeAppearance(this.swigCPtr, this, bl);
    }

    public boolean isTrackingFromRuntimeAppearanceEnabled() {
        return VuforiaJNI.VuMarkTemplate_isTrackingFromRuntimeAppearanceEnabled(this.swigCPtr, this);
    }

    public Vec2F getOrigin() {
        return new Vec2F(VuforiaJNI.VuMarkTemplate_getOrigin(this.swigCPtr, this), true);
    }
}

