/*
 * Decompiled with CFR 0_133.
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
import com.vuforia.ar.pl.SystemTools;
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
                    Window window = activity.getWindow();
                    WindowManager.LayoutParams layoutParams = window.getAttributes();
                    layoutParams.flags |= Integer.MIN_VALUE;
                    window.setAttributes(layoutParams);
                }
            });
        }
    }

    public boolean setStereo(boolean bl) {
        int n = 0;
        if (bl) {
            n = 1;
        }
        try {
            Activity activity = SystemTools.getActivityFromNative();
            if (activity == null) {
                return false;
            }
            WindowManager windowManager = (WindowManager)activity.getSystemService("window");
            Display display = windowManager.getDefaultDisplay();
            Method method = Display.class.getDeclaredMethod("setDisplayMode", Integer.TYPE);
            boolean bl2 = (Boolean)method.invoke((Object)display, n);
            if (bl2) {
                this.stereoEnabled = bl;
            }
            return bl2;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return false;
        }
        catch (IllegalAccessException illegalAccessException) {
            return false;
        }
        catch (InvocationTargetException invocationTargetException) {
            return false;
        }
    }

    public boolean getStereo() {
        return this.stereoEnabled;
    }

}

