/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.Vec3F;
import com.vuforia.VuforiaJNI;

public class ObjectTarget
extends Trackable {
    private long swigCPtr;

    protected ObjectTarget(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.ObjectTarget_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(ObjectTarget obj) {
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
                VuforiaJNI.delete_ObjectTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof ObjectTarget) {
            equal = ((ObjectTarget)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
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

    public boolean setSize(Vec3F size) {
        return VuforiaJNI.ObjectTarget_setSize(this.swigCPtr, this, Vec3F.getCPtr(size), size);
    }
}

