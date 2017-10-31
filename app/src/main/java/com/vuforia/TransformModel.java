/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class TransformModel {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected TransformModel(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(TransformModel obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TransformModel(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof TransformModel) {
            equal = ((TransformModel)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public int getType() {
        return VuforiaJNI.TransformModel_getType(this.swigCPtr, this);
    }

    public static final class TYPE {
        public static final int TRANSFORM_MODEL_HEAD = 0;
        public static final int TRANSFORM_MODEL_HANDHELD = 1;
    }

}

