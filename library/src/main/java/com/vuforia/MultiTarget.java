/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Anchor;
import com.vuforia.CylinderTarget;
import com.vuforia.DeviceTrackable;
import com.vuforia.ImageTarget;
import com.vuforia.Matrix34F;
import com.vuforia.ModelTarget;
import com.vuforia.ObjectTarget;
import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.VuMarkTarget;
import com.vuforia.VuMarkTemplate;
import com.vuforia.VuforiaJNI;

public class MultiTarget
extends ObjectTarget {
    private long swigCPtr;

    protected MultiTarget(long l, boolean bl) {
        super(VuforiaJNI.MultiTarget_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(MultiTarget multiTarget) {
        return multiTarget == null ? 0L : multiTarget.swigCPtr;
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
                VuforiaJNI.delete_MultiTarget(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof MultiTarget) {
            bl = ((MultiTarget)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.MultiTarget_getClassType(), true);
    }

    public int getNumParts() {
        return VuforiaJNI.MultiTarget_getNumParts(this.swigCPtr, this);
    }

    public Trackable getPart(int n) {
        long l = VuforiaJNI.MultiTarget_getPart__SWIG_0(this.swigCPtr, this, n);
        if (l == 0L) {
            return null;
        }
        Trackable trackable = new Trackable(l, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(l, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(l, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(l, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(l, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(l, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(l, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(l, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(l, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(l, false);
        }
        return null;
    }

    public Trackable getPart(String string) {
        long l = VuforiaJNI.MultiTarget_getPart__SWIG_1(this.swigCPtr, this, string);
        if (l == 0L) {
            return null;
        }
        Trackable trackable = new Trackable(l, false);
        if (trackable.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(l, false);
        }
        if (trackable.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(l, false);
        }
        if (trackable.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(l, false);
        }
        if (trackable.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(l, false);
        }
        if (trackable.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(l, false);
        }
        if (trackable.isOfType(ModelTarget.getClassType())) {
            return new ModelTarget(l, false);
        }
        if (trackable.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(l, false);
        }
        if (trackable.isOfType(Anchor.getClassType())) {
            return new Anchor(l, false);
        }
        if (trackable.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(l, false);
        }
        return null;
    }

    public int addPart(Trackable trackable) {
        return VuforiaJNI.MultiTarget_addPart(this.swigCPtr, this, Trackable.getCPtr(trackable), trackable);
    }

    public boolean removePart(int n) {
        return VuforiaJNI.MultiTarget_removePart(this.swigCPtr, this, n);
    }

    public boolean setPartOffset(int n, Matrix34F matrix34F) {
        return VuforiaJNI.MultiTarget_setPartOffset(this.swigCPtr, this, n, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public boolean getPartOffset(int n, Matrix34F matrix34F) {
        return VuforiaJNI.MultiTarget_getPartOffset(this.swigCPtr, this, n, Matrix34F.getCPtr(matrix34F), matrix34F);
    }
}

