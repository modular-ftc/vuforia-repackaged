/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Area;
import com.vuforia.Rectangle;
import com.vuforia.RectangleInt;
import com.vuforia.VuforiaJNI;

public class VirtualButton {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected VirtualButton(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(VirtualButton virtualButton) {
        return virtualButton == null ? 0L : virtualButton.swigCPtr;
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
        if (object instanceof VirtualButton) {
            bl = ((VirtualButton)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public boolean setArea(Area area) {
        return VuforiaJNI.VirtualButton_setArea(this.swigCPtr, this, Area.getCPtr(area), area);
    }

    public Area getArea() {
        long l = VuforiaJNI.VirtualButton_getArea(this.swigCPtr, this);
        if (l == 0L) {
            return null;
        }
        Area area = new Area(l, false);
        switch (area.getType()) {
            case 0: {
                return new Rectangle(l, false);
            }
            case 1: {
                return new RectangleInt(l, false);
            }
        }
        return null;
    }

    public boolean setSensitivity(int n) {
        return VuforiaJNI.VirtualButton_setSensitivity(this.swigCPtr, this, n);
    }

    public boolean setEnabled(boolean bl) {
        return VuforiaJNI.VirtualButton_setEnabled(this.swigCPtr, this, bl);
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

