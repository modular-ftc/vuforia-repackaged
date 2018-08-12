/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class StateUpdater {
    private long swigCPtr;
    private static final Object sStateMutex = new Object();
    private static State sState = null;
    protected boolean swigCMemOwn;

    protected StateUpdater(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(StateUpdater obj) {
        return obj == null ? 0L : obj.swigCPtr;
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

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof StateUpdater) {
            equal = ((StateUpdater)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
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

