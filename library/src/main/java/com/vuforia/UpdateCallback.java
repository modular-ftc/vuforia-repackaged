/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

class UpdateCallback {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected UpdateCallback(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public UpdateCallback() {
        this(VuforiaJNI.new_UpdateCallback(), true);
        VuforiaJNI.UpdateCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected void finalize() {
        this.delete();
    }

    protected static long getCPtr(UpdateCallback obj) {
        return obj == null ? 0L : obj.swigCPtr;
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

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof UpdateCallback) {
            equal = ((UpdateCallback)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public void Vuforia_onUpdate(State state) {
        VuforiaJNI.UpdateCallback_Vuforia_onUpdate(this.swigCPtr, this, State.getCPtr(state), state);
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
}

