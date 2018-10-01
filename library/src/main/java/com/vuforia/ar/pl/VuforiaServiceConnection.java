/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.vuforia.ar.pl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.vuforia.ar.pl.DebugLog;
import java.util.concurrent.CountDownLatch;

public class VuforiaServiceConnection
implements ServiceConnection {
    private static final String SUBTAG = "VuforiaConn";
    private IBinder mService;
    private CountDownLatch mServiceLatch = null;

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = iBinder;
        this.mServiceLatch.countDown();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
        this.mServiceLatch = null;
    }

    public boolean bindService(Context context, ComponentName componentName) {
        this.mServiceLatch = new CountDownLatch(1);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        boolean bl = false;
        try {
            bl = context.bindService(intent, (ServiceConnection)this, 1);
        }
        catch (SecurityException securityException) {
            context.unbindService((ServiceConnection)this);
            DebugLog.LOGD(SUBTAG, "Not permitted to bind to service: " + (Object)componentName + securityException);
        }
        if (!bl) {
            context.unbindService((ServiceConnection)this);
            DebugLog.LOGD(SUBTAG, "Bind to service " + (Object)componentName + " failed");
            this.mServiceLatch = null;
        }
        return bl;
    }

    public boolean unbindService(Context context) {
        if (this.mService != null) {
            context.unbindService((ServiceConnection)this);
            this.mService = null;
        }
        return true;
    }

    public IBinder awaitService() {
        if (this.mServiceLatch == null) {
            DebugLog.LOGE(SUBTAG, "ERROR: awaitService called before bind()");
            return null;
        }
        try {
            this.mServiceLatch.await();
        }
        catch (InterruptedException interruptedException) {
            DebugLog.LOGD(SUBTAG, "bind failed to complete" + interruptedException);
            this.mServiceLatch = null;
            return null;
        }
        return this.mService;
    }
}

