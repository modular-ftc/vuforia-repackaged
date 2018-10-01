/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class Illumination {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Illumination(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(Illumination illumination) {
        return illumination == null ? 0L : illumination.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Illumination(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof Illumination) {
            bl = ((Illumination)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public static float getAMBIENT_INTENSITY_UNAVAILABLE() {
        return VuforiaJNI.Illumination_AMBIENT_INTENSITY_UNAVAILABLE_get();
    }

    public static float getAMBIENT_COLOR_TEMPERATURE_UNAVAILABLE() {
        return VuforiaJNI.Illumination_AMBIENT_COLOR_TEMPERATURE_UNAVAILABLE_get();
    }

    public float getAmbientIntensity() {
        return VuforiaJNI.Illumination_getAmbientIntensity(this.swigCPtr, this);
    }

    public float getAmbientColorTemperature() {
        return VuforiaJNI.Illumination_getAmbientColorTemperature(this.swigCPtr, this);
    }
}

