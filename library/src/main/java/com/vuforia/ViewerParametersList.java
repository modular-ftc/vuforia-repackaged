/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ViewerParametersList
implements Iterable<ViewerParameters> {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected ViewerParametersList(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(ViewerParametersList obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public static ViewerParametersList getListForAuthoringTools() {
        return new ViewerParametersList(VuforiaJNI.ViewerParametersList_getListForAuthoringTools(), false);
    }

    @Override
    public Iterator<ViewerParameters> iterator() {
        return new VPIterator();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_ViewerParametersList(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setSDKFilter(String filter) {
        VuforiaJNI.ViewerParametersList_setSDKFilter(this.swigCPtr, this, filter);
    }

    public long size() {
        return VuforiaJNI.ViewerParametersList_size(this.swigCPtr, this);
    }

    public ViewerParameters get(long idx) {
        long cPtr = VuforiaJNI.ViewerParametersList_get__SWIG_0(this.swigCPtr, this, idx);
        return cPtr == 0L ? null : new ViewerParameters(cPtr, false);
    }

    public ViewerParameters get(String name, String manufacturer) {
        long cPtr = VuforiaJNI.ViewerParametersList_get__SWIG_1(this.swigCPtr, this, name, manufacturer);
        return cPtr == 0L ? null : new ViewerParameters(cPtr, false);
    }

    private ViewerParameters begin() {
        long cPtr = VuforiaJNI.ViewerParametersList_begin(this.swigCPtr, this);
        return cPtr == 0L ? null : new ViewerParameters(cPtr, false);
    }

    private ViewerParameters end() {
        long cPtr = VuforiaJNI.ViewerParametersList_end(this.swigCPtr, this);
        return cPtr == 0L ? null : new ViewerParameters(cPtr, false);
    }

    private ViewerParameters next(ViewerParameters last) {
        long cPtr = VuforiaJNI.ViewerParametersList_next(this.swigCPtr, this, ViewerParameters.getCPtr(last), last);
        return cPtr == 0L ? null : new ViewerParameters(cPtr, false);
    }

    private class VPIterator
    implements Iterator<ViewerParameters> {
        private ViewerParameters next = null;

        VPIterator() {
            if (ViewerParametersList.this.size() > 0L) {
                this.next = ViewerParametersList.this.begin();
            }
        }

        @Override
        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public ViewerParameters next() throws NoSuchElementException {
            if (this.next != null) {
                ViewerParameters toReturn = this.next;
                this.next = ViewerParametersList.this.next(toReturn);
                return toReturn;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

}

