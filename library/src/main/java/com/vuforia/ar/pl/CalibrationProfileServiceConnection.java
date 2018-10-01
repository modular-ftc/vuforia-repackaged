/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 */
package com.vuforia.ar.pl;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.vuforia.ar.pl.DebugLog;
import com.vuforia.ar.pl.VuforiaServiceConnection;
import com.vuforia.eyewear.Calibration.service.ICalibrationProfileService;
import java.nio.charset.Charset;

public class CalibrationProfileServiceConnection {
    private static final String SUBTAG = "CalibrationProfileServiceConn";
    private static final ComponentName CPS_COMPONENT_NAME = new ComponentName("com.vuforia.eyewear.Calibration", "com.vuforia.eyewear.Calibration.service.CalibrationProfileService");
    private VuforiaServiceConnection mConnection = new VuforiaServiceConnection();

    public boolean bind(Context context) {
        if (null == context) {
            DebugLog.LOGD(SUBTAG, "Activity is null");
            return false;
        }
        return this.mConnection.bindService(context, CPS_COMPONENT_NAME);
    }

    public boolean unbind(Context context) {
        if (null == context) {
            DebugLog.LOGD(SUBTAG, "Activity is null");
            return false;
        }
        return this.mConnection.unbindService(context);
    }

    public ICalibrationProfileService getCalibrationProfileClient() {
        IBinder iBinder = this.mConnection.awaitService();
        if (null == iBinder) {
            DebugLog.LOGD(SUBTAG, "getCalibrationProfileClient IBinder is null; returning null");
            return null;
        }
        return ICalibrationProfileService.Stub.asInterface(iBinder);
    }

    int getMaxProfileCount() {
        try {
            return this.getCalibrationProfileClient().getMaxProfileCount();
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "getMaxProfileCount; Remote Exception" + remoteException.getCause());
            return 0;
        }
    }

    int getUsedProfileCount() {
        try {
            return this.getCalibrationProfileClient().getUsedProfileCount();
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "getUsedProfileCount; Remote Exception" + remoteException.getCause());
            return 0;
        }
    }

    boolean isProfileUsed(int n) {
        try {
            return this.getCalibrationProfileClient().isProfileUsed(n);
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "isProfileUsed; Remote Exception" + remoteException.getCause());
            return false;
        }
    }

    int getActiveProfile() {
        try {
            return this.getCalibrationProfileClient().getActiveProfile();
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "getActiveProfile; Remote Exception" + remoteException.getCause());
            return 0;
        }
    }

    boolean setActiveProfile(int n) {
        try {
            return this.getCalibrationProfileClient().setActiveProfile(n);
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "setActiveProfile; Remote Exception" + remoteException.getCause());
            return false;
        }
    }

    byte[] getProfileName(int n) {
        try {
            return this.getCalibrationProfileClient().getProfileName(n).getBytes(Charset.forName("UTF-16LE"));
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "getProfileName; Remote Exception" + remoteException.getCause());
            return null;
        }
    }

    boolean setProfileName(int n, byte[] arrby) {
        try {
            return this.getCalibrationProfileClient().setProfileName(n, new String(arrby, Charset.forName("UTF-16LE")));
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "setProfileName; Remote Exception" + remoteException.getCause());
            return false;
        }
    }

    float[] getCameraToEyePose(int n, int n2) {
        try {
            return this.getCalibrationProfileClient().getCameraToEyePose(n, n2);
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "getCameraToEyePose; Remote Exception" + remoteException.getCause());
            return null;
        }
    }

    float[] getEyeProjection(int n, int n2) {
        try {
            return this.getCalibrationProfileClient().getEyeProjection(n, n2);
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "getEyeProjection; Remote Exception" + remoteException.getCause());
            return null;
        }
    }

    boolean setCameraToEyePose(int n, int n2, float[] arrf) {
        try {
            return this.getCalibrationProfileClient().setCameraToEyePose(n, n2, arrf);
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "setCameraToEyePose; Remote Exception" + remoteException.getCause());
            return false;
        }
    }

    boolean setEyeProjection(int n, int n2, float[] arrf) {
        try {
            return this.getCalibrationProfileClient().setEyeProjection(n, n2, arrf);
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "setEyeProjection; Remote Exception" + remoteException.getCause());
            return false;
        }
    }

    boolean clearProfile(int n) {
        try {
            return this.getCalibrationProfileClient().clearProfile(n);
        }
        catch (RemoteException remoteException) {
            DebugLog.LOGD(SUBTAG, "clearProfile; Remote Exception" + remoteException.getCause());
            return false;
        }
    }
}

