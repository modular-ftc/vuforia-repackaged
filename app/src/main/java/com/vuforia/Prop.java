/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Obb3D;
import com.vuforia.SmartTerrainTrackable;
import com.vuforia.Type;
import com.vuforia.Vec2F;
import com.vuforia.VuforiaJNI;

public class Prop
extends SmartTerrainTrackable {
    private long swigCPtr;

    protected Prop(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.Prop_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Prop obj) {
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
                VuforiaJNI.delete_Prop(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Prop) {
            equal = ((Prop)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Prop_getClassType(), true);
    }

    public Obb3D getBoundingBox() {
        return new Obb3D(VuforiaJNI.Prop_getBoundingBox(this.swigCPtr, this), false);
    }

    public Vec2F getLocalPosition() {
        return new Vec2F(VuforiaJNI.Prop_getLocalPosition(this.swigCPtr, this), false);
    }
}

