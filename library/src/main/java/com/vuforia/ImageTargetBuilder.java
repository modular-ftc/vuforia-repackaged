/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.TrackableSource;
import com.vuforia.VuforiaJNI;

public class ImageTargetBuilder {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected ImageTargetBuilder(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(ImageTargetBuilder imageTargetBuilder) {
        return imageTargetBuilder == null ? 0L : imageTargetBuilder.swigCPtr;
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
        if (object instanceof ImageTargetBuilder) {
            bl = ((ImageTargetBuilder)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public boolean build(String string, float f) {
        return VuforiaJNI.ImageTargetBuilder_build(this.swigCPtr, this, string, f);
    }

    public void startScan() {
        VuforiaJNI.ImageTargetBuilder_startScan(this.swigCPtr, this);
    }

    public void stopScan() {
        VuforiaJNI.ImageTargetBuilder_stopScan(this.swigCPtr, this);
    }

    public int getFrameQuality() {
        return VuforiaJNI.ImageTargetBuilder_getFrameQuality(this.swigCPtr, this);
    }

    public TrackableSource getTrackableSource() {
        long l = VuforiaJNI.ImageTargetBuilder_getTrackableSource(this.swigCPtr, this);
        return l == 0L ? null : new TrackableSource(l, false);
    }

    public static final class FRAME_QUALITY {
        public static final int FRAME_QUALITY_NONE = -1;
        public static final int FRAME_QUALITY_LOW = 0;
        public static final int FRAME_QUALITY_MEDIUM = 1;
        public static final int FRAME_QUALITY_HIGH = 2;

        private FRAME_QUALITY() {
        }
    }

}

