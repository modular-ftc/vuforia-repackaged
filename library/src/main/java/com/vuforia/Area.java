/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Area {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Area(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Area area) {
        return area == null ? 0L : area.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Area(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Area) {
            bl = ((Area)object).swigCPtr == this.swigCPtr;
        }
        return bl;
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

