/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Image;
import com.vuforia.Rectangle;
import com.vuforia.Trackable;
import com.vuforia.Type;
import com.vuforia.Vec2F;
import com.vuforia.VuforiaJNI;

public class Word
extends Trackable {
    private long swigCPtr;

    protected Word(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.Word_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Word obj) {
        return obj == null ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Word(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Word) {
            equal = ((Word)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Word_getClassType(), true);
    }

    public String getStringU() {
        short[] codes = VuforiaJNI.Word_getStringU(this.swigCPtr, this);
        if (codes == null) {
            return null;
        }
        StringBuilder result = new StringBuilder(codes.length);
        for (short code : codes) {
            result.appendCodePoint(code);
        }
        return result.toString();
    }

    public int getLength() {
        return VuforiaJNI.Word_getLength(this.swigCPtr, this);
    }

    public int getNumCodeUnits() {
        return VuforiaJNI.Word_getNumCodeUnits(this.swigCPtr, this);
    }

    public Vec2F getSize() {
        return new Vec2F(VuforiaJNI.Word_getSize(this.swigCPtr, this), true);
    }

    public Image getMask() {
        long cPtr = VuforiaJNI.Word_getMask(this.swigCPtr, this);
        return cPtr == 0 ? null : new Image(cPtr, false);
    }

    public Rectangle getLetterBoundingBox(int idx) {
        long cPtr = VuforiaJNI.Word_getLetterBoundingBox(this.swigCPtr, this, idx);
        return cPtr == 0 ? null : new Rectangle(cPtr, false);
    }
}

