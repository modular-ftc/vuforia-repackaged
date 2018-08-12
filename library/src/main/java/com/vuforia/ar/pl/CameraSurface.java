/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Camera
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 */
package com.vuforia.ar.pl;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

class CameraSurface
extends SurfaceView
implements SurfaceHolder.Callback {
    Camera camera = null;
    private static final String MODULENAME = "CameraSurface";
    SurfaceHolder surfaceHolder = this.getHolder();

    public CameraSurface(Context context) {
        super(context);
        this.surfaceHolder.addCallback((SurfaceHolder.Callback)this);
        this.surfaceHolder.setType(3);
    }

    public void setCamera(Camera cam) {
        this.camera = cam;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        try {
            if (this.camera != null) {
                this.camera.setPreviewDisplay(holder);
            }
        }
        catch (IOException exception) {
            this.camera = null;
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        this.camera = null;
    }
}

