/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.CameraCalibration;
import com.vuforia.Image;
import com.vuforia.Matrix34F;
import com.vuforia.VuforiaJNI;

public class GuideView {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected GuideView(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(GuideView guideView) {
        return guideView == null ? 0L : guideView.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_GuideView(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof GuideView) {
            bl = ((GuideView)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public CameraCalibration getIntrinsics() {
        return new CameraCalibration(VuforiaJNI.GuideView_getIntrinsics(this.swigCPtr, this), false);
    }

    public Matrix34F getPose() {
        return new Matrix34F(VuforiaJNI.GuideView_getPose(this.swigCPtr, this), false);
    }

    public void setPose(Matrix34F matrix34F) {
        VuforiaJNI.GuideView_setPose(this.swigCPtr, this, Matrix34F.getCPtr(matrix34F), matrix34F);
    }

    public Image getImage() {
        long l = VuforiaJNI.GuideView_getImage(this.swigCPtr, this);
        return l == 0L ? null : new Image(l, false);
    }
}

