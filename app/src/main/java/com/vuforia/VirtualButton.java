/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Area;
import com.vuforia.Rectangle;
import com.vuforia.RectangleInt;
import com.vuforia.VuforiaJNI;

public class VirtualButton {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected VirtualButton(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(VirtualButton obj) {
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
        if (obj instanceof VirtualButton) {
            equal = ((VirtualButton)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public boolean setArea(Area area) {
        return VuforiaJNI.VirtualButton_setArea(this.swigCPtr, this, Area.getCPtr(area), area);
    }

    public Area getArea() {
        long cPtr = VuforiaJNI.VirtualButton_getArea(this.swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        Area tmp = new Area(cPtr, false);
        switch (tmp.getType()) {
            case 0: {
                return new Rectangle(cPtr, false);
            }
            case 1: {
                return new RectangleInt(cPtr, false);
            }
        }
        return null;
    }

    public boolean setSensitivity(int sensitivity) {
        return VuforiaJNI.VirtualButton_setSensitivity(this.swigCPtr, this, sensitivity);
    }

    public boolean setEnabled(boolean enabled) {
        return VuforiaJNI.VirtualButton_setEnabled(this.swigCPtr, this, enabled);
    }

    public boolean isEnabled() {
        return VuforiaJNI.VirtualButton_isEnabled(this.swigCPtr, this);
    }

    public String getName() {
        return VuforiaJNI.VirtualButton_getName(this.swigCPtr, this);
    }

    public int getID() {
        return VuforiaJNI.VirtualButton_getID(this.swigCPtr, this);
    }

    public static final class SENSITIVITY {
        public static final int HIGH = 0;
        public static final int MEDIUM = 1;
        public static final int LOW = 2;

        private SENSITIVITY() {
        }
    }

}

