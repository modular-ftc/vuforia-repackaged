/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.GuideView;
import com.vuforia.Obb3D;
import com.vuforia.ObjectTarget;
import com.vuforia.Type;
import com.vuforia.Vec3F;
import com.vuforia.VuforiaJNI;

public class ModelTarget
extends ObjectTarget {
    private long swigCPtr;

    protected ModelTarget(long l, boolean bl) {
        super(VuforiaJNI.ModelTarget_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(ModelTarget modelTarget) {
        return modelTarget == null ? 0L : modelTarget.swigCPtr;
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
                VuforiaJNI.delete_ModelTarget(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof ModelTarget) {
            bl = ((ModelTarget)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ModelTarget_getClassType(), true);
    }

    @Override
    public String getUniqueTargetId() {
        return VuforiaJNI.ModelTarget_getUniqueTargetId(this.swigCPtr, this);
    }

    @Override
    public Vec3F getSize() {
        return new Vec3F(VuforiaJNI.ModelTarget_getSize(this.swigCPtr, this), true);
    }

    @Override
    public boolean setSize(Vec3F vec3F) {
        return VuforiaJNI.ModelTarget_setSize(this.swigCPtr, this, Vec3F.getCPtr(vec3F), vec3F);
    }

    public Obb3D getBoundingBox() {
        return new Obb3D(VuforiaJNI.ModelTarget_getBoundingBox(this.swigCPtr, this), false);
    }

    public int getNumGuideViews() {
        return VuforiaJNI.ModelTarget_getNumGuideViews(this.swigCPtr, this);
    }

    public GuideView getGuideView(int n) {
        long l = VuforiaJNI.ModelTarget_getGuideView(this.swigCPtr, this, n);
        return l == 0L ? null : new GuideView(l, false);
    }
}

