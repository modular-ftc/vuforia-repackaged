/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Anchor;
import com.vuforia.Trackable;
import com.vuforia.TrackableResult;
import com.vuforia.Type;
import com.vuforia.VuforiaJNI;

public class AnchorResult
extends TrackableResult {
    private long swigCPtr;

    protected AnchorResult(long l, boolean bl) {
        super(VuforiaJNI.AnchorResult_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    protected static long getCPtr(AnchorResult anchorResult) {
        return anchorResult == null ? 0L : anchorResult.swigCPtr;
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
                VuforiaJNI.delete_AnchorResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof AnchorResult) {
            bl = ((AnchorResult)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.AnchorResult_getClassType(), true);
    }

    @Override
    public Trackable getTrackable() {
        return new Anchor(VuforiaJNI.AnchorResult_getTrackable(this.swigCPtr, this), false);
    }
}

