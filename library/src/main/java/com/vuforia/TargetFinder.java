/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.ImageTarget;
import com.vuforia.TargetSearchResult;
import com.vuforia.VuforiaJNI;

public class TargetFinder {
    private long swigCPtr;
    protected boolean swigCMemOwn;
    public static final int INIT_DEFAULT = 0;
    public static final int INIT_RUNNING = 1;
    public static final int INIT_SUCCESS = 2;
    public static final int INIT_ERROR_NO_NETWORK_CONNECTION = -1;
    public static final int INIT_ERROR_SERVICE_NOT_AVAILABLE = -2;
    public static final int UPDATE_NO_MATCH = 0;
    public static final int UPDATE_NO_REQUEST = 1;
    public static final int UPDATE_RESULTS_AVAILABLE = 2;
    public static final int UPDATE_ERROR_AUTHORIZATION_FAILED = -1;
    public static final int UPDATE_ERROR_PROJECT_SUSPENDED = -2;
    public static final int UPDATE_ERROR_NO_NETWORK_CONNECTION = -3;
    public static final int UPDATE_ERROR_SERVICE_NOT_AVAILABLE = -4;
    public static final int UPDATE_ERROR_BAD_FRAME_QUALITY = -5;
    public static final int UPDATE_ERROR_UPDATE_SDK = -6;
    public static final int UPDATE_ERROR_TIMESTAMP_OUT_OF_RANGE = -7;
    public static final int UPDATE_ERROR_REQUEST_TIMEOUT = -8;
    public static final int FILTER_NONE = 0;
    public static final int FILTER_CURRENTLY_TRACKED = 1;

    protected TargetFinder(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(TargetFinder targetFinder) {
        return targetFinder == null ? 0L : targetFinder.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_TargetFinder(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof TargetFinder) {
            bl = ((TargetFinder)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public boolean startInit(String string, String string2) {
        return VuforiaJNI.TargetFinder_startInit(this.swigCPtr, this, string, string2);
    }

    public int getInitState() {
        return VuforiaJNI.TargetFinder_getInitState(this.swigCPtr, this);
    }

    public void waitUntilInitFinished() {
        VuforiaJNI.TargetFinder_waitUntilInitFinished(this.swigCPtr, this);
    }

    public boolean deinit() {
        return VuforiaJNI.TargetFinder_deinit(this.swigCPtr, this);
    }

    public boolean startRecognition() {
        return VuforiaJNI.TargetFinder_startRecognition(this.swigCPtr, this);
    }

    public boolean stop() {
        return VuforiaJNI.TargetFinder_stop(this.swigCPtr, this);
    }

    public boolean isRequesting() {
        return VuforiaJNI.TargetFinder_isRequesting(this.swigCPtr, this);
    }

    public int updateSearchResults(int n) {
        return VuforiaJNI.TargetFinder_updateSearchResults__SWIG_0(this.swigCPtr, this, n);
    }

    public int updateSearchResults() {
        return VuforiaJNI.TargetFinder_updateSearchResults__SWIG_1(this.swigCPtr, this);
    }

    public int getResultCount() {
        return VuforiaJNI.TargetFinder_getResultCount(this.swigCPtr, this);
    }

    public TargetSearchResult getResult(int n) {
        long l = VuforiaJNI.TargetFinder_getResult(this.swigCPtr, this, n);
        return l == 0L ? null : new TargetSearchResult(l, false);
    }

    public ImageTarget enableTracking(TargetSearchResult targetSearchResult) {
        long l = VuforiaJNI.TargetFinder_enableTracking(this.swigCPtr, this, TargetSearchResult.getCPtr(targetSearchResult), targetSearchResult);
        return l == 0L ? null : new ImageTarget(l, false);
    }

    public void clearTrackables() {
        VuforiaJNI.TargetFinder_clearTrackables(this.swigCPtr, this);
    }

    public int getNumImageTargets() {
        return VuforiaJNI.TargetFinder_getNumImageTargets(this.swigCPtr, this);
    }

    public ImageTarget getImageTarget(int n) {
        long l = VuforiaJNI.TargetFinder_getImageTarget(this.swigCPtr, this, n);
        return l == 0L ? null : new ImageTarget(l, false);
    }
}

