/*
 * Decompiled with CFR 0_133.
 */
package com.vuforia;

import com.vuforia.ViewerParameters;
import com.vuforia.VuforiaJNI;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ViewerParametersList
implements Iterable<ViewerParameters> {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected ViewerParametersList(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    protected static long getCPtr(ViewerParametersList viewerParametersList) {
        return viewerParametersList == null ? 0L : viewerParametersList.swigCPtr;
    }

    protected void finalize() {
        this.delete();
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

    @Override
    public Iterator<ViewerParameters> iterator() {
        return new VPIterator();
    }

    public static ViewerParametersList getListForAuthoringTools() {
        return new ViewerParametersList(VuforiaJNI.ViewerParametersList_getListForAuthoringTools(), false);
    }

    public void setSDKFilter(String string) {
        VuforiaJNI.ViewerParametersList_setSDKFilter(this.swigCPtr, this, string);
    }

    public long size() {
        return VuforiaJNI.ViewerParametersList_size(this.swigCPtr, this);
    }

    public ViewerParameters get(long l) {
        long l2 = VuforiaJNI.ViewerParametersList_get__SWIG_0(this.swigCPtr, this, l);
        return l2 == 0L ? null : new ViewerParameters(l2, false);
    }

    public ViewerParameters get(String string, String string2) {
        long l = VuforiaJNI.ViewerParametersList_get__SWIG_1(this.swigCPtr, this, string, string2);
        return l == 0L ? null : new ViewerParameters(l, false);
    }

    private ViewerParameters begin() {
        long l = VuforiaJNI.ViewerParametersList_begin(this.swigCPtr, this);
        return l == 0L ? null : new ViewerParameters(l, false);
    }

    private ViewerParameters end() {
        long l = VuforiaJNI.ViewerParametersList_end(this.swigCPtr, this);
        return l == 0L ? null : new ViewerParameters(l, false);
    }

    private ViewerParameters next(ViewerParameters viewerParameters) {
        long l = VuforiaJNI.ViewerParametersList_next(this.swigCPtr, this, ViewerParameters.getCPtr(viewerParameters), viewerParameters);
        return l == 0L ? null : new ViewerParameters(l, false);
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
                ViewerParameters viewerParameters = this.next;
                this.next = ViewerParametersList.this.next(viewerParameters);
                return viewerParameters;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() throws UnsupportedOperationException, IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

}

