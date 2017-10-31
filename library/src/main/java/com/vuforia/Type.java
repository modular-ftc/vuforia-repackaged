/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class Type {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Type(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Type() {
        this(VuforiaJNI.new_Type__SWIG_0(), true);
    }

    public Type(short data) {
        this(VuforiaJNI.new_Type__SWIG_1(data), true);
    }

    protected static long getCPtr(Type obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Type(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Type) {
            equal = ((Type)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public boolean isOfType(Type type) {
        return VuforiaJNI.Type_isOfType(this.swigCPtr, this, Type.getCPtr(type), type);
    }
}

