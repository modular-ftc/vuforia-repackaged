/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class TextTracker
extends Tracker {
    private long swigCPtr;

    protected TextTracker(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.TextTracker_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(TextTracker obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.TextTracker_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof TextTracker) {
            equal = ((TextTracker)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TextTracker(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean setRegionOfInterest(RectangleInt detectionROI, RectangleInt trackingROI, int upDirection) {
        return VuforiaJNI.TextTracker_setRegionOfInterest(this.swigCPtr, this, RectangleInt.getCPtr(detectionROI), detectionROI, RectangleInt.getCPtr(trackingROI), trackingROI, upDirection);
    }

    public void getRegionOfInterest(RectangleInt detectionROI, RectangleInt trackingROI, int[] upDirection) {
        VuforiaJNI.TextTracker_getRegionOfInterest(this.swigCPtr, this, RectangleInt.getCPtr(detectionROI), detectionROI, RectangleInt.getCPtr(trackingROI), trackingROI, upDirection);
    }

    public WordList getWordList() {
        long cPtr = VuforiaJNI.TextTracker_getWordList(this.swigCPtr, this);
        return cPtr == 0L ? null : new WordList(cPtr, false);
    }

    public static final class UP_DIRECTION {
        public static final int REGIONOFINTEREST_UP_IS_0_HRS = 1;
        public static final int REGIONOFINTEREST_UP_IS_3_HRS = 2;
        public static final int REGIONOFINTEREST_UP_IS_6_HRS = 3;
        public static final int REGIONOFINTEREST_UP_IS_9_HRS = 4;

        private UP_DIRECTION() {
        }
    }

}

