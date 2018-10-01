/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class TransformModel {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TransformModel(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(TransformModel transformModel) {
        return transformModel == null ? 0L : transformModel.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TransformModel(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof TransformModel) {
            bl = ((TransformModel)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public int getType() {
        return VuforiaJNI.TransformModel_getType(this.swigCPtr, this);
    }

    public static final class TYPE {
        public static final int TRANSFORM_MODEL_HEAD = 0;
        public static final int TRANSFORM_MODEL_HANDHELD = 1;
    }

}

