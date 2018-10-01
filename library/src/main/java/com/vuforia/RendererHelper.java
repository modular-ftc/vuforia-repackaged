/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class RendererHelper {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected RendererHelper(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(RendererHelper rendererHelper) {
        return rendererHelper == null ? 0L : rendererHelper.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_RendererHelper(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof RendererHelper) {
            bl = ((RendererHelper)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static boolean drawVideoBackground() {
        return VuforiaJNI.RendererHelper_drawVideoBackground();
    }

    public RendererHelper() {
        this(VuforiaJNI.new_RendererHelper(), true);
    }
}

