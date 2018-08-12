/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.vuforia.ar.pl;

import android.util.Log;

public class DebugLog {
    private static final String LOGTAG = "AR";

    public static final void LOGE(String subtag, String nMessage) {
        if (subtag.length() > 0) {
            nMessage = subtag + ": " + nMessage;
        }
        Log.e((String) LOGTAG, (String) nMessage);
    }

    public static final void LOGW(String subtag, String nMessage) {
        if (subtag.length() > 0) {
            nMessage = subtag + ": " + nMessage;
        }
        Log.w((String) LOGTAG, (String) nMessage);
    }

    public static final void LOGD(String subtag, String nMessage) {
        if (subtag.length() > 0) {
            nMessage = subtag + ": " + nMessage;
        }
        Log.d((String) LOGTAG, (String) nMessage);
    }

    public static final void LOGI(String subtag, String nMessage) {
        if (subtag.length() > 0) {
            nMessage = subtag + ": " + nMessage;
        }
        Log.i((String) LOGTAG, (String) nMessage);
    }
}

