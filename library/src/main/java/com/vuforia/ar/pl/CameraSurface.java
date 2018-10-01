/*
 * Decompiled with CFR 0_133.
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
    SurfaceHolder surfaceHolder = this.getHolder();
    private static final String MODULENAME = "CameraSurface";

    public CameraSurface(Context context) {
        super(context);
        this.surfaceHolder.addCallback((SurfaceHolder.Callback)this);
        this.surfaceHolder.setType(3);
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            if (this.camera != null) {
                this.camera.setPreviewDisplay(surfaceHolder);
            }
        }
        catch (IOException iOException) {
            this.camera = null;
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int n, int n2, int n3) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.camera = null;
    }
}

