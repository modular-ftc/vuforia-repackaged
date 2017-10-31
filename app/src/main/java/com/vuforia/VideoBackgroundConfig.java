/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Vec2I;
import com.vuforia.VuforiaJNI;

public class VideoBackgroundConfig {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected VideoBackgroundConfig(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(VideoBackgroundConfig obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_VideoBackgroundConfig(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof VideoBackgroundConfig) {
            equal = ((VideoBackgroundConfig)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public VideoBackgroundConfig() {
        this(VuforiaJNI.new_VideoBackgroundConfig(), true);
    }

    public void setEnabled(boolean value) {
        VuforiaJNI.VideoBackgroundConfig_Enabled_set(this.swigCPtr, this, value);
    }

    public boolean getEnabled() {
        return VuforiaJNI.VideoBackgroundConfig_Enabled_get(this.swigCPtr, this);
    }

    public void setPosition(Vec2I value) {
        VuforiaJNI.VideoBackgroundConfig_Position_set(this.swigCPtr, this, Vec2I.getCPtr(value), value);
    }

    public Vec2I getPosition() {
        long cPtr = VuforiaJNI.VideoBackgroundConfig_Position_get(this.swigCPtr, this);
        return cPtr == 0 ? null : new Vec2I(cPtr, false);
    }

    public void setSize(Vec2I value) {
        VuforiaJNI.VideoBackgroundConfig_Size_set(this.swigCPtr, this, Vec2I.getCPtr(value), value);
    }

    public Vec2I getSize() {
        long cPtr = VuforiaJNI.VideoBackgroundConfig_Size_get(this.swigCPtr, this);
        return cPtr == 0 ? null : new Vec2I(cPtr, false);
    }

    public void setReflection(int value) {
        VuforiaJNI.VideoBackgroundConfig_Reflection_set(this.swigCPtr, this, value);
    }

    public int getReflection() {
        return VuforiaJNI.VideoBackgroundConfig_Reflection_get(this.swigCPtr, this);
    }
}

