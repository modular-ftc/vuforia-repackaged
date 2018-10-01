/*
 * Decompiled with CFR 0_133.
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
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.vuforia.ar.pl.Camera1_Preview;
import com.vuforia.ar.pl.CameraSurface;
import com.vuforia.ar.pl.SystemTools;
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

    private GLSurfaceView searchForGLSurfaceView(View view) {
        GLSurfaceView gLSurfaceView;
        gLSurfaceView = null;
        this.glSurfaceViewChildPosition = 0;
        try {
            ViewGroup viewGroup = (ViewGroup)view;
            int n = viewGroup.getChildCount();
            for (int i = 0; i < n; ++i) {
                View view2 = viewGroup.getChildAt(i);
                if (view2 instanceof GLSurfaceView) {
                    gLSurfaceView = (GLSurfaceView)view2;
                    this.glSurfaceViewChildPosition = i;
                } else if (!(view2 instanceof ViewGroup) || (gLSurfaceView = this.searchForGLSurfaceView(view2)) == null) {
                    continue;
                }
                break;
            }
        }
        catch (Exception exception) {
            return null;
        }
        return gLSurfaceView;
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
    private void setupCameraSurface(Camera1_Preview.CameraCacheInfo cameraCacheInfo) {
        if (cameraCacheInfo.surface == null) {
            Activity activity = SystemTools.getActivityFromNative();
            if (activity == null) return;
            cameraCacheInfo.surface = new CameraSurface((Context)activity);
        } else if (cameraCacheInfo.surface.getParent() != null && ViewGroup.class.isInstance((Object)cameraCacheInfo.surface.getParent())) {
            ViewGroup viewGroup = (ViewGroup)cameraCacheInfo.surface.getParent();
            viewGroup.removeView((View)cameraCacheInfo.surface);
        }
        cameraCacheInfo.surface.setCamera(cameraCacheInfo.camera);
    }

    public boolean retrieveGLSurfaceView() {
        try {
            Activity activity = SystemTools.getActivityFromNative();
            if (activity == null) {
                return false;
            }
            View view = activity.getWindow().getDecorView();
            this.glSurfaceView = this.searchForGLSurfaceView(view);
            this.cameraSurfaceParentView = this.glSurfaceView == null ? view : (View)this.glSurfaceView.getParent();
        }
        catch (Exception exception) {
            return false;
        }
        return this.glSurfaceView != null;
    }

    public boolean setEnableRenderWhenDirty(boolean bl) {
        this.renderWhenDirtyEnabled = bl;
        boolean bl2 = this.applyRenderWhenDirty();
        return bl2;
    }

    public void requestRender() {
        if (this.glSurfaceView != null) {
            this.glSurfaceView.requestRender();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addCameraSurface(Camera1_Preview.CameraCacheInfo cameraCacheInfo) {
        boolean bl;
        Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            return false;
        }
        this.cciForSurface = cameraCacheInfo;
        bl = false;
        this.viewLock.lock();
        try {
            activity.runOnUiThread(new Runnable(){

                @Override
                public void run() {
                    SurfaceManager.this.addSurfaceLock.lock();
                    SurfaceManager.this.retrieveGLSurfaceView();
                    try {
                        SurfaceManager.this.setupCameraSurface(SurfaceManager.this.cciForSurface);
                        ViewGroup viewGroup = (ViewGroup)SurfaceManager.this.cameraSurfaceParentView;
                        viewGroup.addView((View)SurfaceManager.this.cciForSurface.surface, SurfaceManager.this.glSurfaceViewChildPosition + 1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                        SurfaceManager.this.cciForSurface.surface.setVisibility(0);
                    }
                    catch (Exception exception) {
                    }
                    finally {
                        SurfaceManager.this.addSurfaceLock.unlock();
                    }
                }
            });
        }
        catch (Exception exception) {
            bl = true;
        }
        finally {
            this.viewLock.unlock();
        }
        return !bl;
    }

}

