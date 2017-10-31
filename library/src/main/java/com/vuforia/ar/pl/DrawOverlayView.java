/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.WindowManager
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class DrawOverlayView
extends View {
    private static final String MODULENAME = "DrawOverlayView";
    private double mLeft;
    private double mTop;
    private float[] mScale;
    private int[] mSize;
    private DisplayMetrics metrics;
    private Bitmap overlayBitmap;
    private Drawable drawable = null;

    public DrawOverlayView(Context context) {
        super(context);
    }

    public DrawOverlayView(Context context, byte[] byteArray, int left, int top, float[] scale, int[] size) {
        super(context);
        this.mLeft = left;
        this.mTop = top;
        this.mScale = scale;
        this.mSize = size;
        byte[] byteArrayRGBA = new byte[byteArray.length * 4];
        for (int i = 0; i < this.mSize[0] * this.mSize[1]; ++i) {
            byteArrayRGBA[i * 4] = byteArray[i];
            byteArrayRGBA[i * 4 + 1] = byteArray[i];
            byteArrayRGBA[i * 4 + 2] = byteArray[i];
            byteArrayRGBA[i * 4 + 3] = -1;
        }
        this.overlayBitmap = Bitmap.createBitmap((int)this.mSize[0], (int)this.mSize[1], (Bitmap.Config)Bitmap.Config.ARGB_8888);
        this.overlayBitmap.copyPixelsFromBuffer((Buffer)ByteBuffer.wrap(byteArrayRGBA));
        this.drawable = new BitmapDrawable(this.overlayBitmap);
        this.metrics = new DisplayMetrics();
        Activity activity = (Activity)this.getContext();
        activity.getWindowManager().getDefaultDisplay().getMetrics(this.metrics);
    }

    protected void onDraw(Canvas canvas) {
        if (this.overlayBitmap == null) {
            super.dispatchDraw(canvas);
            return;
        }
        double maxTop = (double)this.metrics.heightPixels - (double)((float)this.drawable.getIntrinsicHeight() * this.mScale[1]);
        if (maxTop < this.mTop) {
            this.mTop = maxTop;
        }
        int right = (int)(this.mLeft + (double)((float)this.drawable.getIntrinsicWidth() * this.metrics.density * this.mScale[0]));
        int bottom = (int)(this.mTop + (double)((float)this.drawable.getIntrinsicHeight() * this.metrics.density * this.mScale[1]));
        this.drawable.setBounds((int)this.mLeft, (int)this.mTop, right, bottom);
        this.drawable.setAlpha(100);
        this.drawable.draw(canvas);
        super.dispatchDraw(canvas);
    }

    public void addOverlay(Activity activity) {
        ((ViewGroup)activity.getWindow().getDecorView()).addView((View)this);
        this.setVisibility(0);
    }

    public void removeOverlay(Activity activity, View childView) {
        try {
            ((ViewGroup)activity.getWindow().getDecorView()).removeView(childView);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

