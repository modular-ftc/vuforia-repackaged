/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.HitTestResult;
import com.vuforia.State;
import com.vuforia.Tracker;
import com.vuforia.Type;
import com.vuforia.Vec2F;
import com.vuforia.VuforiaJNI;

public class SmartTerrain
extends Tracker {
    private long swigCPtr;

    protected SmartTerrain(long l, boolean bl) {
        super(VuforiaJNI.SmartTerrain_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(SmartTerrain smartTerrain) {
        return smartTerrain == null ? 0L : smartTerrain.swigCPtr;
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
                VuforiaJNI.delete_SmartTerrain(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof SmartTerrain) {
            bl = ((SmartTerrain)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.SmartTerrain_getClassType(), true);
    }

    public void hitTest(State state, Vec2F vec2F, float f, int n) {
        VuforiaJNI.SmartTerrain_hitTest(this.swigCPtr, this, State.getCPtr(state), state, Vec2F.getCPtr(vec2F), vec2F, f, n);
    }

    public int getHitTestResultCount() {
        return VuforiaJNI.SmartTerrain_getHitTestResultCount(this.swigCPtr, this);
    }

    public HitTestResult getHitTestResult(int n) {
        long l = VuforiaJNI.SmartTerrain_getHitTestResult(this.swigCPtr, this, n);
        return l == 0L ? null : new HitTestResult(l, false);
    }

    public static final class HITTEST_HINT {
        public static final int HITTEST_HINT_NONE = 0;
        public static final int HITTEST_HINT_HORIZONTAL_PLANE = 1;
        public static final int HITTEST_HINT_VERTICAL_PLANE = 2;
    }

}

