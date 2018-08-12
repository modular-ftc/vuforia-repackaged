/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.hardware.Camera
 *  android.opengl.GLSurfaceView
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SurfaceManager {
    boolean renderWhenDirtyEnabled = false;
    GLSurfaceView glSurfaceView = null;
    int glSurfaceViewChildPosition = 0;
    View cameraSurfaceParentView = null;
    Camera1_Preview.CameraCacheInfo cciForSurface;
    Lock viewLock = new ReentrantLock();
    Lock addSurfaceLock = new ReentrantLock();
    private static final String MODULENAME = "SurfaceManager";

    private GLSurfaceView searchForGLSurfaceView(View rootView) {
        GLSurfaceView result;
        result = null;
        this.glSurfaceViewChildPosition = 0;
        try {
            ViewGroup rootViewGroup = (ViewGroup) rootView;
            int numChildren = rootViewGroup.getChildCount();
            for (int i = 0; i < numChildren; ++i) {
                View childView = rootViewGroup.getChildAt(i);
                if (childView instanceof GLSurfaceView) {
                    result = (GLSurfaceView) childView;
                    this.glSurfaceViewChildPosition = i;
                } else if (!(childView instanceof ViewGroup) || (result = this.searchForGLSurfaceView(childView)) == null) {
                    continue;
                }
                break;
            }
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    private boolean applyRenderWhenDirty() {
        if (this.glSurfaceView != null) {
            this.glSurfaceView.setRenderMode(this.renderWhenDirtyEnabled ? 0 : 1);
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void setupCameraSurface(Camera1_Preview.CameraCacheInfo cci) {
        if (cci.surface == null) {
            Activity a = SystemTools.getActivityFromNative();
            if (a == null) return;
            cci.surface = new CameraSurface((Context) a);
        } else if (cci.surface.getParent() != null && ViewGroup.class.isInstance((Object) cci.surface.getParent())) {
            ViewGroup vg = (ViewGroup) cci.surface.getParent();
            vg.removeView((View) cci.surface);
        }
        cci.surface.setCamera(cci.camera);
    }

    public boolean retrieveGLSurfaceView() {
        try {
            Activity activity = SystemTools.getActivityFromNative();
            if (activity == null) {
                return false;
            }
            View decorView = activity.getWindow().getDecorView();
            this.glSurfaceView = this.searchForGLSurfaceView(decorView);
            this.cameraSurfaceParentView = this.glSurfaceView == null ? decorView : (View) this.glSurfaceView.getParent();
        } catch (Exception e) {
            return false;
        }
        return this.glSurfaceView != null;
    }

    public boolean setEnableRenderWhenDirty(boolean enabled) {
        this.renderWhenDirtyEnabled = enabled;
        boolean result = this.applyRenderWhenDirty();
        return result;
    }

    public void requestRender() {
        if (this.glSurfaceView != null) {
            this.glSurfaceView.requestRender();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addCameraSurface(Camera1_Preview.CameraCacheInfo cci) {
        boolean didExceptionHappen;
        Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            return false;
        }
        this.cciForSurface = cci;
        didExceptionHappen = false;
        this.viewLock.lock();
        try {
            activity.runOnUiThread(new Runnable() {

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void run() {
                    block5:
                    {
                        SurfaceManager.this.addSurfaceLock.lock();
                        SurfaceManager.this.retrieveGLSurfaceView();
                        try {
                            SurfaceManager.this.setupCameraSurface(SurfaceManager.this.cciForSurface);
                            ViewGroup vg = (ViewGroup) SurfaceManager.this.cameraSurfaceParentView;
                            vg.addView((View) SurfaceManager.this.cciForSurface.surface, SurfaceManager.this.glSurfaceViewChildPosition + 1, (ViewGroup.LayoutParams) new FrameLayout.LayoutParams(-1, -1));
                            SurfaceManager.this.cciForSurface.surface.setVisibility(0);
                            break block5;
                        } catch (Exception vg) {
                            break block5;
                        } finally {
                            SurfaceManager.this.addSurfaceLock.unlock();
                        }
                    }
                }
            });
        } catch (Exception exception) {
            didExceptionHappen = true;
        } finally {
            this.viewLock.unlock();
        }
        return !didExceptionHappen;
    }

}

