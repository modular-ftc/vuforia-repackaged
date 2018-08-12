/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class Word
extends Trackable {
    private long swigCPtr;

    protected Word(long cPtr, boolean cMemoryOwn) {
        super(VuforiaJNI.Word_SWIGUpcast(cPtr), cMemoryOwn);
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Word obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    public static Type getClassType() {
        return new Type(VuforiaJNI.Word_getClassType(), true);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Word) {
            equal = ((Word)obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }

    @Override
    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Word(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
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
        return cPtr == 0L ? null : new Image(cPtr, false);
    }

    public Rectangle getLetterBoundingBox(int idx) {
        long cPtr = VuforiaJNI.Word_getLetterBoundingBox(this.swigCPtr, this, idx);
        return cPtr == 0L ? null : new Rectangle(cPtr, false);
    }
}

