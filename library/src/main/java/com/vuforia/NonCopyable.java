/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class NonCopyable {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected NonCopyable(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(NonCopyable obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof NonCopyable) {
            equal = ((NonCopyable)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }
}

