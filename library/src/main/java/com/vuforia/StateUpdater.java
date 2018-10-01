/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.State;
import com.vuforia.VuforiaJNI;

public class StateUpdater {
    private long swigCPtr;
    protected boolean swigCMemOwn;
    private static State sState = null;
    private static final Object sStateMutex = new Object();

    protected StateUpdater(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(StateUpdater stateUpdater) {
        return stateUpdater == null ? 0L : stateUpdater.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_StateUpdater(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof StateUpdater) {
            bl = ((StateUpdater)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public State updateState() {
        Object object = sStateMutex;
        synchronized (object) {
            if (sState != null) {
                sState.delete();
            }
            sState = new State(VuforiaJNI.StateUpdater_updateState(this.swigCPtr, this), true);
        }
        return sState;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public State getLatestState() {
        Object object = sStateMutex;
        synchronized (object) {
            return sState;
        }
    }

    public double getCurrentTimeStamp() {
        return VuforiaJNI.StateUpdater_getCurrentTimeStamp(this.swigCPtr, this);
    }
}

