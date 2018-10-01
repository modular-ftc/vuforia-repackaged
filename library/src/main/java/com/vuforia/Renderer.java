/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.State;
import com.vuforia.TextureData;
import com.vuforia.TextureUnit;
import com.vuforia.VideoBackgroundConfig;
import com.vuforia.VideoBackgroundTextureInfo;
import com.vuforia.Vuforia;
import com.vuforia.VuforiaJNI;

public class Renderer {
    private long swigCPtr;
    protected boolean swigCMemOwn;
    private static State sState = null;
    private static final Object sStateMutex = new Object();
    public static final int TARGET_FPS_CONTINUOUS = -1;

    protected Renderer(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Renderer renderer) {
        return renderer == null ? 0L : renderer.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Renderer(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Renderer) {
            bl = ((Renderer)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static Renderer getInstance() {
        if (!Vuforia.wasInitializedJava()) {
            throw new RuntimeException("Use of the Java Vuforia APIs requires initalization via the com.vuforia.Vuforia class");
        }
        return new Renderer(VuforiaJNI.Renderer_getInstance(), false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public State begin() {
        Object object = sStateMutex;
        synchronized (object) {
            if (sState != null) {
                sState.delete();
            }
            sState = new State(VuforiaJNI.Renderer_begin__SWIG_0(this.swigCPtr, this), true);
        }
        return sState;
    }

    public void begin(State state) {
        VuforiaJNI.Renderer_begin__SWIG_1(this.swigCPtr, this, State.getCPtr(state), state);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void end() {
        VuforiaJNI.Renderer_end(this.swigCPtr, this);
        Object object = sStateMutex;
        synchronized (object) {
            if (sState != null) {
                sState.delete();
                sState = null;
            }
        }
    }

    public boolean updateVideoBackgroundTexture(TextureUnit textureUnit) {
        return VuforiaJNI.Renderer_updateVideoBackgroundTexture__SWIG_0(this.swigCPtr, this, TextureUnit.getCPtr(textureUnit), textureUnit);
    }

    public boolean updateVideoBackgroundTexture() {
        return VuforiaJNI.Renderer_updateVideoBackgroundTexture__SWIG_1(this.swigCPtr, this);
    }

    public void setVideoBackgroundConfig(VideoBackgroundConfig videoBackgroundConfig) {
        VuforiaJNI.Renderer_setVideoBackgroundConfig(this.swigCPtr, this, VideoBackgroundConfig.getCPtr(videoBackgroundConfig), videoBackgroundConfig);
    }

    public VideoBackgroundConfig getVideoBackgroundConfig() {
        return new VideoBackgroundConfig(VuforiaJNI.Renderer_getVideoBackgroundConfig(this.swigCPtr, this), false);
    }

    public VideoBackgroundTextureInfo getVideoBackgroundTextureInfo() {
        return new VideoBackgroundTextureInfo(VuforiaJNI.Renderer_getVideoBackgroundTextureInfo(this.swigCPtr, this), false);
    }

    public boolean setVideoBackgroundTexture(TextureData textureData) {
        return VuforiaJNI.Renderer_setVideoBackgroundTexture(this.swigCPtr, this, TextureData.getCPtr(textureData), textureData);
    }

    public boolean setTargetFps(int n) {
        return VuforiaJNI.Renderer_setTargetFps(this.swigCPtr, this, n);
    }

    public int getRecommendedFps(int n) {
        return VuforiaJNI.Renderer_getRecommendedFps__SWIG_0(this.swigCPtr, this, n);
    }

    public int getRecommendedFps() {
        return VuforiaJNI.Renderer_getRecommendedFps__SWIG_1(this.swigCPtr, this);
    }

    public static final class FPSHINT_FLAGS {
        public static final int FPSHINT_NONE = 0;
        public static final int FPSHINT_NO_VIDEOBACKGROUND = 1;
        public static final int FPSHINT_POWER_EFFICIENCY = 2;
        public static final int FPSHINT_FAST = 4;
        public static final int FPSHINT_DEFAULT_FLAGS = 0;
    }

}

