/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Image;
import com.vuforia.InstanceId;
import com.vuforia.ObjectTarget;
import com.vuforia.Type;
import com.vuforia.VuMarkTemplate;
import com.vuforia.VuforiaJNI;

public class VuMarkTarget
extends ObjectTarget {
    private long swigCPtr;

    protected VuMarkTarget(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.VuMarkTarget_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(VuMarkTarget obj) {
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
                VuforiaJNI.delete_VuMarkTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof VuMarkTarget) {
            equal = ((VuMarkTarget)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.VuMarkTarget_getClassType(), true);
    }

    public VuMarkTemplate getTemplate() {
        return new VuMarkTemplate(VuforiaJNI.VuMarkTarget_getTemplate(this.swigCPtr, this), false);
    }

    public InstanceId getInstanceId() {
        return new InstanceId(VuforiaJNI.VuMarkTarget_getInstanceId(this.swigCPtr, this), false);
    }

    public Image getInstanceImage() {
        return new Image(VuforiaJNI.VuMarkTarget_getInstanceImage(this.swigCPtr, this), false);
    }
}

