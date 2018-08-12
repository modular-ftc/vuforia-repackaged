/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class Type {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Type(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Type() {
        this(VuforiaJNI.new_Type__SWIG_0(), true);
    }

    protected void finalize() {
        this.delete();
    }

    public Type(short data) {
        this(VuforiaJNI.new_Type__SWIG_1(data), true);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Type) {
            equal = ((Type)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    protected static long getCPtr(Type obj) {
        return obj == null ? 0L : obj.swigCPtr;
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

    public boolean isOfType(Type type) {
        return VuforiaJNI.Type_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }
}

