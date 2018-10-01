/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Type {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Type(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Type type) {
        return type == null ? 0L : type.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Type(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Type) {
            bl = ((Type)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Type() {
        this(VuforiaJNI.new_Type__SWIG_0(), true);
    }

    public Type(short s) {
        this(VuforiaJNI.new_Type__SWIG_1(s), true);
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Type_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }
}

