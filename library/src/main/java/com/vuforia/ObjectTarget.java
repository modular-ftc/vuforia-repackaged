/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.Vec3F;
import com.vuforia.VuforiaJNI;

public class ObjectTarget
extends Trackable {
    private long swigCPtr;

    protected ObjectTarget(long l, boolean bl) {
        super(VuforiaJNI.ObjectTarget_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(ObjectTarget objectTarget) {
        return objectTarget == null ? 0L : objectTarget.swigCPtr;
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
                VuforiaJNI.delete_ObjectTarget(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof ObjectTarget) {
            bl = ((ObjectTarget)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.ObjectTarget_getClassType(), true);
    }

    public String getUniqueTargetId() {
        return VuforiaJNI.ObjectTarget_getUniqueTargetId(this.swigCPtr, this);
    }

    public Vec3F getSize() {
        return new Vec3F(VuforiaJNI.ObjectTarget_getSize(this.swigCPtr, this), true);
    }

    public boolean setSize(Vec3F vec3F) {
        return VuforiaJNI.ObjectTarget_setSize(this.swigCPtr, this, Vec3F.getCPtr(vec3F), vec3F);
    }
}

