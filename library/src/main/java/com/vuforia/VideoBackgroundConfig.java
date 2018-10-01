/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.Vec2I;
import com.vuforia.VuforiaJNI;

public class VideoBackgroundConfig {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected VideoBackgroundConfig(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(VideoBackgroundConfig videoBackgroundConfig) {
        return videoBackgroundConfig == null ? 0L : videoBackgroundConfig.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VideoBackgroundConfig(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof VideoBackgroundConfig) {
            bl = ((VideoBackgroundConfig)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public VideoBackgroundConfig() {
        this(VuforiaJNI.new_VideoBackgroundConfig(), true);
    }

    public void setEnabled(boolean bl) {
        VuforiaJNI.VideoBackgroundConfig_Enabled_set(this.swigCPtr, this, bl);
    }

    public boolean getEnabled() {
        return VuforiaJNI.VideoBackgroundConfig_Enabled_get(this.swigCPtr, this);
    }

    public void setPosition(Vec2I vec2I) {
        VuforiaJNI.VideoBackgroundConfig_Position_set(this.swigCPtr, this, Vec2I.getCPtr(vec2I), vec2I);
    }

    public Vec2I getPosition() {
        long l = VuforiaJNI.VideoBackgroundConfig_Position_get(this.swigCPtr, this);
        return l == 0L ? null : new Vec2I(l, false);
    }

    public void setSize(Vec2I vec2I) {
        VuforiaJNI.VideoBackgroundConfig_Size_set(this.swigCPtr, this, Vec2I.getCPtr(vec2I), vec2I);
    }

    public Vec2I getSize() {
        long l = VuforiaJNI.VideoBackgroundConfig_Size_get(this.swigCPtr, this);
        return l == 0L ? null : new Vec2I(l, false);
    }

    public void setReflection(int n) {
        VuforiaJNI.VideoBackgroundConfig_Reflection_set(this.swigCPtr, this, n);
    }

    public int getReflection() {
        return VuforiaJNI.VideoBackgroundConfig_Reflection_get(this.swigCPtr, this);
    }
}

