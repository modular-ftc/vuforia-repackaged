/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Vec2I;
import com.vuforia.VuforiaJNI;

public class VideoBackgroundTextureInfo {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected VideoBackgroundTextureInfo(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(VideoBackgroundTextureInfo obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VideoBackgroundTextureInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof VideoBackgroundTextureInfo) {
            equal = ((VideoBackgroundTextureInfo)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public Vec2I getTextureSize() {
        long cPtr = VuforiaJNI.VideoBackgroundTextureInfo_TextureSize_get(this.swigCPtr, this);
        return cPtr == 0 ? null : new Vec2I(cPtr, false);
    }

    public Vec2I getImageSize() {
        long cPtr = VuforiaJNI.VideoBackgroundTextureInfo_ImageSize_get(this.swigCPtr, this);
        return cPtr == 0 ? null : new Vec2I(cPtr, false);
    }

    public int getPixelFormat() {
        return VuforiaJNI.VideoBackgroundTextureInfo_PixelFormat_get(this.swigCPtr, this);
    }

    public VideoBackgroundTextureInfo() {
        this(VuforiaJNI.new_VideoBackgroundTextureInfo(), true);
    }
}

