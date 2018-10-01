/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Vec2I;
import com.vuforia.VuforiaJNI;

public class VideoBackgroundTextureInfo {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected VideoBackgroundTextureInfo(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(VideoBackgroundTextureInfo videoBackgroundTextureInfo) {
        return videoBackgroundTextureInfo == null ? 0L : videoBackgroundTextureInfo.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VideoBackgroundTextureInfo(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof VideoBackgroundTextureInfo) {
            bl = ((VideoBackgroundTextureInfo)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public Vec2I getTextureSize() {
        long l = VuforiaJNI.VideoBackgroundTextureInfo_TextureSize_get(this.swigCPtr, this);
        return l == 0L ? null : new Vec2I(l, false);
    }

    public Vec2I getImageSize() {
        long l = VuforiaJNI.VideoBackgroundTextureInfo_ImageSize_get(this.swigCPtr, this);
        return l == 0L ? null : new Vec2I(l, false);
    }

    public int getPixelFormat() {
        return VuforiaJNI.VideoBackgroundTextureInfo_PixelFormat_get(this.swigCPtr, this);
    }

    public VideoBackgroundTextureInfo() {
        this(VuforiaJNI.new_VideoBackgroundTextureInfo(), true);
    }
}

