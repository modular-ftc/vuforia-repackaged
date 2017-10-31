/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

public class Area {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Area(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Area obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Area(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Area) {
            equal = ((Area)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public int getType() {
        return VuforiaJNI.Area_getType(this.swigCPtr, this);
    }

    public static final class TYPE {
        public static final int RECTANGLE = 0;
        public static final int RECTANGLE_INT = 1;
        public static final int INVALID = 2;

        private TYPE() {
        }
    }

}

