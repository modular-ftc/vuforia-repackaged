/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.vuforia.ar.pl;

import android.util.Log;

public class DebugLog {
    private static final String LOGTAG = "AR";

    public static final void LOGE(String string, String string2) {
        if (string.length() > 0) {
            string2 = string + ": " + string2;
        }
        Log.e((String)LOGTAG, (String)string2);
    }

    public static final void LOGW(String string, String string2) {
        if (string.length() > 0) {
            string2 = string + ": " + string2;
        }
        Log.w((String)LOGTAG, (String)string2);
    }

    public static final void LOGD(String string, String string2) {
        if (string.length() > 0) {
            string2 = string + ": " + string2;
        }
        Log.d((String)LOGTAG, (String)string2);
    }

    public static final void LOGI(String string, String string2) {
        if (string.length() > 0) {
            string2 = string + ": " + string2;
        }
        Log.i((String)LOGTAG, (String)string2);
    }
}

