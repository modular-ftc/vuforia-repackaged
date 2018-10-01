/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.res.AssetManager
 *  android.os.Environment
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Environment;
import com.vuforia.ar.pl.SystemTools;
import java.io.File;

public class FileTools {
    private static final int FILE_PATHTYPEINDEX_ABSOLUTE = -1;
    private static final int FILE_PATHTYPEINDEX_ANDROID_ASSETS = 0;
    private static final int FILE_PATHTYPEINDEX_ANDROID_PRIVATEAPPSTORAGE = 1;
    private static final int FILE_PATHTYPEINDEX_ANDROID_PRIVATEAPPCACHE = 2;
    private static final int FILE_PATHTYPEINDEX_ANDROID_MEDIASTORAGE = 3;
    private static final int FILE_PATHTYPEINDEX_ANDROID_DATALOCAL = 4;
    private static final String MODULENAME = "FileTools";

    public static String getAbsolutePath(int n, String string) {
        String string2 = null;
        switch (n) {
            case 1: {
                Activity activity = SystemTools.getActivityFromNative();
                if (activity == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                File file = activity.getFilesDir();
                if (file == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                string2 = file.getAbsolutePath();
                break;
            }
            case 2: {
                Activity activity = SystemTools.getActivityFromNative();
                if (activity == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                File file = activity.getCacheDir();
                if (file == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                string2 = file.getAbsolutePath();
                break;
            }
            case 3: {
                File file = Environment.getExternalStorageDirectory();
                if (file == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                string2 = file.getAbsolutePath();
                break;
            }
            default: {
                SystemTools.setSystemErrorCode(6);
                return null;
            }
        }
        if (string2 != null && string != null) {
            if (string2.length() > 0 && string2.charAt(string2.length() - 1) != '/') {
                string2 = string2 + "/";
            }
            string2 = string2 + string;
        }
        return string2;
    }

    public static boolean mediastorage_isAvailable() {
        String string = Environment.getExternalStorageState();
        return "mounted".equals(string) || "mounted_ro".equals(string);
    }

    public static AssetManager get_assetmanager() {
        Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        return activity.getAssets();
    }
}

