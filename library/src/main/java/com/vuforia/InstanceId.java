/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.VuforiaJNI;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class InstanceId {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected InstanceId(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(InstanceId instanceId) {
        return instanceId == null ? 0L : instanceId.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_InstanceId(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object instanceof InstanceId) {
            bl = ((InstanceId)object).swigCPtr == this.swigCPtr;
        }
        return bl;
    }

    public ByteBuffer getBuffer() {
        return VuforiaJNI.InstanceId_getBuffer(this.swigCPtr, this);
    }

    public long getLength() {
        return VuforiaJNI.InstanceId_getLength(this.swigCPtr, this);
    }

    public BigInteger getNumericValue() {
        return VuforiaJNI.InstanceId_getNumericValue(this.swigCPtr, this);
    }

    public int getDataType() {
        return VuforiaJNI.InstanceId_getDataType(this.swigCPtr, this);
    }

    public static final class ID_DATA_TYPE {
        public static final int BYTES = 0;
        public static final int STRING = 1;
        public static final int NUMERIC = 2;
    }

}

