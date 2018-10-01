/*
 * Decompiled with CFR 0_133.
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

    protected VuMarkTarget(long l, boolean bl) {
        super(VuforiaJNI.VuMarkTarget_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(VuMarkTarget vuMarkTarget) {
        return vuMarkTarget == null ? 0L : vuMarkTarget.swigCPtr;
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
                VuforiaJNI.delete_VuMarkTarget(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof VuMarkTarget) {
            bl = ((VuMarkTarget)object).swigCPtr == this.swigCPtr;
        }
        return bl;
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

