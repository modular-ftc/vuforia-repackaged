/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class MultiTarget
extends ObjectTarget {
    private long swigCPtr;

    protected MultiTarget(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.MultiTarget_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(MultiTarget obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.MultiTarget_getClassType(), true);
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
                VuforiaJNI.delete_MultiTarget(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof MultiTarget) {
            equal = ((MultiTarget)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public int getNumParts() {
        return VuforiaJNI.MultiTarget_getNumParts(this.swigCPtr, this);
    }

    public Trackable getPart(int idx) {
        long cPtr = VuforiaJNI.MultiTarget_getPart__SWIG_0(this.swigCPtr, this, idx);
        if (cPtr == 0) {
            return null;
        }
        Trackable tmp = new Trackable(cPtr, false);
        if (tmp.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(cPtr, false);
        }
        if (tmp.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(cPtr, false);
        }
        if (tmp.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(cPtr, false);
        }
        if (tmp.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(cPtr, false);
        }
        if (tmp.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(cPtr, false);
        }
        if (tmp.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(cPtr, false);
        }
        if (tmp.isOfType(Word.getClassType())) {
            return new Word(cPtr, false);
        }
        if (tmp.isOfType(Marker.getClassType())) {
            return new Marker(cPtr, false);
        }
        if (tmp.isOfType(Surface.getClassType())) {
            return new Surface(cPtr, false);
        }
        if (tmp.isOfType(Prop.getClassType())) {
            return new Prop(cPtr, false);
        }
        if (tmp.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(cPtr, false);
        }
        return null;
    }

    public Trackable getPart(String name) {
        long cPtr = VuforiaJNI.MultiTarget_getPart__SWIG_1(this.swigCPtr, this, name);
        if (cPtr == 0) {
            return null;
        }
        Trackable tmp = new Trackable(cPtr, false);
        if (tmp.isOfType(ImageTarget.getClassType())) {
            return new ImageTarget(cPtr, false);
        }
        if (tmp.isOfType(CylinderTarget.getClassType())) {
            return new CylinderTarget(cPtr, false);
        }
        if (tmp.isOfType(MultiTarget.getClassType())) {
            return new MultiTarget(cPtr, false);
        }
        if (tmp.isOfType(VuMarkTarget.getClassType())) {
            return new VuMarkTarget(cPtr, false);
        }
        if (tmp.isOfType(VuMarkTemplate.getClassType())) {
            return new VuMarkTemplate(cPtr, false);
        }
        if (tmp.isOfType(ObjectTarget.getClassType())) {
            return new ObjectTarget(cPtr, false);
        }
        if (tmp.isOfType(Word.getClassType())) {
            return new Word(cPtr, false);
        }
        if (tmp.isOfType(Marker.getClassType())) {
            return new Marker(cPtr, false);
        }
        if (tmp.isOfType(Surface.getClassType())) {
            return new Surface(cPtr, false);
        }
        if (tmp.isOfType(Prop.getClassType())) {
            return new Prop(cPtr, false);
        }
        if (tmp.isOfType(DeviceTrackable.getClassType())) {
            return new DeviceTrackable(cPtr, false);
        }
        return null;
    }

    public int addPart(Trackable trackable) {
        return VuforiaJNI.MultiTarget_addPart(this.swigCPtr, this, Trackable.getCPtr(trackable), trackable);
    }

    public boolean removePart(int idx) {
        return VuforiaJNI.MultiTarget_removePart(this.swigCPtr, this, idx);
    }

    public boolean setPartOffset(int idx, Matrix34F offset) {
        return VuforiaJNI.MultiTarget_setPartOffset(this.swigCPtr, this, idx, Matrix34F.getCPtr(offset), offset);
    }

    public boolean getPartOffset(int idx, Matrix34F offset) {
        return VuforiaJNI.MultiTarget_getPartOffset(this.swigCPtr, this, idx, Matrix34F.getCPtr(offset), offset);
    }
}

