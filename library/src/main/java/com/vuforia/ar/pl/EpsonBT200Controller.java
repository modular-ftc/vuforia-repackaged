/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.Display
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EpsonBT200Controller {
    private static final String MODULENAME = "EpsonBT200Controller";
    private boolean stereoEnabled = false;

    public EpsonBT200Controller() {
        final Activity activity = SystemTools.getActivityFromNative();
        if (activity != null) {
            activity.runOnUiThread(new Runnable(){

                @Override
                public void run() {
                    Window win = activity.getWindow();
                    WindowManager.LayoutParams winParams = win.getAttributes();
                    winParams.flags |= Integer.MIN_VALUE;
                    win.setAttributes(winParams);
                }
            });
        }
    }

    public boolean setStereo(boolean enable) {
        int newDisplayMode = 0;
        if (enable) {
            newDisplayMode = 1;
        }
        try {
            Activity activity = SystemTools.getActivityFromNative();
            if (activity == null) {
                return false;
            }
            WindowManager wm = (WindowManager)activity.getSystemService("window");
            Display display = wm.getDefaultDisplay();
            Method setDisplayModeMethod = Display.class.getDeclaredMethod("setDisplayMode", Integer.TYPE);
            boolean result = (Boolean)setDisplayModeMethod.invoke((Object)display, newDisplayMode);
            if (result) {
                this.stereoEnabled = enable;
            }
            return result;
        }
        catch (NoSuchMethodException nsme) {
            return false;
        }
        catch (IllegalAccessException iae) {
            return false;
        }
        catch (InvocationTargetException ite) {
            return false;
        }
    }

    public boolean getStereo() {
        return this.stereoEnabled;
    }

}

