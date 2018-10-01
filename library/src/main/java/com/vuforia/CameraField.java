/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;

public class CameraField {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected CameraField(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(CameraField cameraField) {
        return cameraField == null ? 0L : cameraField.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_CameraField(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof CameraField) {
            bl = ((CameraField)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public CameraField() {
        this(VuforiaJNI.new_CameraField(), true);
    }

    public int getType() {
        return VuforiaJNI.CameraField_Type_get(this.swigCPtr, this);
    }

    public String getKey() {
        return VuforiaJNI.CameraField_Key_get(this.swigCPtr, this);
    }

    public static final class DataType {
        public static final int TypeString = 0;
        public static final int TypeInt64 = 1;
        public static final int TypeFloat = 2;
        public static final int TypeBool = 3;
        public static final int TypeInt64Range = 4;
        public static final int TypeUnknown = 5;

        private DataType() {
        }
    }

}

