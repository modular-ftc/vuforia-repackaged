/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.State;
import com.vuforia.VuforiaJNI;

class UpdateCallback {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected UpdateCallback(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(UpdateCallback updateCallback) {
        return updateCallback == null ? 0L : updateCallback.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_UpdateCallback(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        this.delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        VuforiaJNI.UpdateCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        VuforiaJNI.UpdateCallback_change_ownership(this, this.swigCPtr, true);
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof UpdateCallback) {
            bl = ((UpdateCallback)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public void Vuforia_onUpdate(State state) {
        VuforiaJNI.UpdateCallback_Vuforia_onUpdate(this.swigCPtr, this, State.getCPtr(state), state);
    }

    public UpdateCallback() {
        this(VuforiaJNI.new_UpdateCallback(), true);
        VuforiaJNI.UpdateCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}

