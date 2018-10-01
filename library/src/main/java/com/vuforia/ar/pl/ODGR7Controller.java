/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  com.osterhoutgroup.api.ext.ExtendDisplay
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.osterhoutgroup.api.ext.ExtendDisplay;
import com.vuforia.ar.pl.DebugLog;
import com.vuforia.ar.pl.SystemTools;
import java.util.ArrayList;
import java.util.List;

public class ODGR7Controller {
    private static final String MODULENAME = "ODGR7Controller";
    private boolean stereoEnabled = false;

    public ODGR7Controller() throws ClassNotFoundException {
        Class.forName("com.osterhoutgroup.api.ext.ExtendDisplay");
    }

    private void logMetrics(String string, Activity activity, Window window) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ExtendDisplay.getDisplayMetrics((Context)activity, (Window)window, (DisplayMetrics)displayMetrics);
        int n = displayMetrics.widthPixels;
        int n2 = displayMetrics.heightPixels;
        DebugLog.LOGD(MODULENAME, string + " display metrics " + n + " x " + n2);
    }

    public boolean getStereo() {
        return this.stereoEnabled;
    }

    public boolean setStereo(final boolean bl) {
        Window window;
        boolean bl2 = false;
        Activity activity = SystemTools.getActivityFromNative();
        if (activity != null && (window = activity.getWindow()) != null) {
            List<SurfaceView> list = this.findSurfaceViews(window);
            if (list.size() == 0) {
                DebugLog.LOGE(MODULENAME, "ODG Display control: Cannot change display mode, there are no SurfaceViews created.");
            } else {
                activity.runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        ExtendDisplay.extendWindow((Window)window, (boolean)bl);
                        ODGR7Controller.this.setStereoSurfaces(window, bl);
                        ODGR7Controller.this.stereoEnabled = bl;
                    }
                });
                bl2 = true;
            }
        }
        return bl2;
    }

    private void setStereoSurfaces(Window window, boolean bl) {
        List<SurfaceView> list = this.findSurfaceViews(window);
        for (SurfaceView surfaceView : list) {
            if (!surfaceView.getHolder().getSurface().isValid()) continue;
            ExtendDisplay.extendSurface((SurfaceView)surfaceView, (boolean)bl);
        }
    }

    private List<SurfaceView> findSurfaceViews(Window window) {
        ArrayList<SurfaceView> arrayList = new ArrayList<SurfaceView>();
        ViewGroup viewGroup = (ViewGroup)window.getDecorView();
        this.findSurfaceViews(viewGroup, arrayList);
        return arrayList;
    }

    private void findSurfaceViews(ViewGroup viewGroup, List<SurfaceView> list) {
        int n = viewGroup.getChildCount();
        for (int i = 0; i < n; ++i) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof SurfaceView) {
                SurfaceView surfaceView = (SurfaceView)view;
                list.add(surfaceView);
                continue;
            }
            if (!(view instanceof ViewGroup)) continue;
            this.findSurfaceViews((ViewGroup)view, list);
        }
    }

}

