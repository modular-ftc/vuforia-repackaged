/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class Anchor
extends Trackable {
    private long swigCPtr;

    protected Anchor(long l, boolean bl) {
        super(VuforiaJNI.Anchor_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(Anchor anchor) {
        return anchor == null ? 0L : anchor.swigCPtr;
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
                VuforiaJNI.delete_Anchor(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Anchor) {
            bl = ((Anchor)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Anchor_getClassType(), true);
    }
}

