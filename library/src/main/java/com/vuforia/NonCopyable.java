/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

public class NonCopyable {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected NonCopyable(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(NonCopyable nonCopyable) {
        return nonCopyable == null ? 0L : nonCopyable.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof NonCopyable) {
            bl = ((NonCopyable)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }
}

