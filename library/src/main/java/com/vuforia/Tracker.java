/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class Tracker {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Tracker(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Tracker tracker) {
        return tracker == null ? 0L : tracker.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Tracker(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Tracker) {
            bl = ((Tracker)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Tracker_getClassType(), true);
    }

    public Type getType() {
        return new Type(VuforiaJNI.Tracker_getType(this.swigCPtr, this), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Tracker_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }

    public boolean start() {
        return VuforiaJNI.Tracker_start(this.swigCPtr, this);
    }

    public void stop() {
        VuforiaJNI.Tracker_stop(this.swigCPtr, this);
    }
}

