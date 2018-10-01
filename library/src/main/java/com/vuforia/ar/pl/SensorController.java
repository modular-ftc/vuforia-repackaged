/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.app.Application;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.vuforia.ar.pl.SystemTools;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class SensorController
extends HandlerThread
implements SensorEventListener {
    private SensorManager sensorManager;
    private Vector<SensorCacheInfo> sensorCacheInfo = null;
    private HashMap<Sensor, Integer> sensorIndexMap = null;
    private Handler sensorEventHandler;
    private static final int AR_SENSOR_TYPE_UNKNOWN = 1342177280;
    private static final int AR_SENSOR_TYPE_GYROSCOPE = 1342177281;
    private static final int AR_SENSOR_TYPE_ACCELEROMETER = 1342177282;
    private static final int AR_SENSOR_TYPE_MAGNETOMETER = 1342177283;
    private static final int AR_SENSOR_TYPE_PROXIMITY = 1342177285;
    private static final int AR_SENSOR_TYPE_AMBIENT_LIGHT = 1342177286;
    private static final int AR_SENSOR_TYPE_STEP_DETECTOR = 1342177287;
    private static final int AR_SENSOR_TYPE_DEVICE_ROTATION = 1342177288;
    private static final int[] SENSOR_TYPE_CONVERSIONTABLE = new int[]{4, 1342177281, 1, 1342177282, 2, 1342177283, 8, 1342177285, 5, 1342177286, 18, 1342177287, 11, 1342177288};
    private static boolean CONVERT_FORMAT_TO_PL = true;
    private static boolean CONVERT_FORMAT_TO_ANDROID = false;
    private static final int SENSORINFO_VALUE_PLSENSORTYPE = 0;
    private static final int SENSORINFO_VALUE_ANDROIDSENSORTYPE = 1;
    private static final int SENSORINFO_VALUE_ISDEFAULT = 2;
    private static final int _NUM_SENSORINFO_VALUE_ = 3;
    private static int AR_SENSOR_INDEX_DONTCARE = -1;
    private static final int AR_SENSOR_STATUS_UNKNOWN = 1342242816;
    private static final int AR_SENSOR_STATUS_UNINITIALIZED = 1342242817;
    private static final int AR_SENSOR_STATUS_IDLE = 1342242818;
    private static final int AR_SENSOR_STATUS_RUNNING = 1342242819;
    private static final int AR_SENSOR_PARAMTYPE_BASE = Integer.MIN_VALUE;
    private static final int AR_SENSOR_PARAMTYPE_DATARANGE_MIN = -2147483647;
    private static final int AR_SENSOR_PARAMTYPE_DATARANGE_MAX = -2147483646;
    private static final int AR_SENSOR_PARAMTYPE_RESOLUTION = -2147483644;
    private static final int AR_SENSOR_PARAMTYPE_ACCURACY = -2147483640;
    private static final int AR_SENSOR_PARAMTYPE_SENSITIVITY = -2147483632;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL = -2147483616;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_ABSTRACT = -2147483584;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_MIN = -2147483520;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_ENFORCED = -2147483392;
    private static final int AR_SENSOR_CONFIDENCE_UNKNOWN = 0;
    private static final int AR_SENSOR_CONFIDENCE_UNRELIABLE = 1;
    private static final int AR_SENSOR_CONFIDENCE_LOW = 2;
    private static final int AR_SENSOR_CONFIDENCE_MEDIUM = 3;
    private static final int AR_SENSOR_CONFIDENCE_HIGH = 4;
    private static final int AR_SENSOR_UPDATEINTERVAL_UNKNOWN = 0;
    private static final int AR_SENSOR_UPDATEINTERVAL_LOWRATE = 1;
    private static final int AR_SENSOR_UPDATEINTERVAL_MEDIUMRATE = 2;
    private static final int AR_SENSOR_UPDATEINTERVAL_HIGHRATE = 3;
    private static final int AR_SENSOR_UPDATEINTERVAL_HIGHESTRATE = 4;
    private static final String MODULENAME = "SensorController";

    public SensorController() {
        super(MODULENAME);
    }

    private SensorCacheInfo getSensorCacheInfo(int n) {
        if (n < 0 || n >= this.sensorCacheInfo.size()) {
            return null;
        }
        return this.sensorCacheInfo.get(n);
    }

    private int translateSensorType(int n, boolean bl) {
        for (int i = 0; i < SENSOR_TYPE_CONVERSIONTABLE.length / 2; ++i) {
            int n2;
            int n3 = n2 = bl == CONVERT_FORMAT_TO_PL ? SENSOR_TYPE_CONVERSIONTABLE[i * 2] : SENSOR_TYPE_CONVERSIONTABLE[i * 2 + 1];
            if (n != n2) continue;
            return bl == CONVERT_FORMAT_TO_PL ? SENSOR_TYPE_CONVERSIONTABLE[i * 2 + 1] : SENSOR_TYPE_CONVERSIONTABLE[i * 2];
        }
        return bl == CONVERT_FORMAT_TO_PL ? 1342177280 : 0;
    }

    private int translateSensorUpdateIntervalToAndroid(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 0;
                break;
            }
        }
        return n2;
    }

    public void onAccuracyChanged(Sensor sensor, int n) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Integer n = this.sensorIndexMap.get((Object)sensorEvent.sensor);
        if (n == null) {
            return;
        }
        int n2 = n;
        SensorCacheInfo sensorCacheInfo = this.getSensorCacheInfo(n2);
        if (sensorCacheInfo == null) {
            return;
        }
        int n3 = 0;
        switch (sensorEvent.accuracy) {
            case 0: {
                n3 = 1;
                break;
            }
            case 1: {
                n3 = 2;
                break;
            }
            case 2: {
                n3 = 3;
                break;
            }
            case 3: {
                n3 = 4;
                break;
            }
        }
        this.newDataAvailable(sensorCacheInfo.cacheIndex, sensorEvent.timestamp, n3, sensorEvent.values);
    }

    private native void newDataAvailable(int var1, long var2, int var4, float[] var5);

    public boolean init() {
        this.sensorManager = null;
        this.sensorCacheInfo = new Vector<E>();
        this.sensorIndexMap = new HashMap<K, V>();
        return true;
    }

    public int getAllSupportedSensors() {
        Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            SystemTools.logSystemError("No valid activity set in native!");
            return -1;
        }
        Application application = activity.getApplication();
        if (application == null) {
            return -1;
        }
        this.sensorManager = (SensorManager)application.getSystemService("sensor");
        if (this.sensorManager == null) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to retrieve Context's Sensor Service");
            return -1;
        }
        if (this.sensorCacheInfo.size() > 0) {
            return this.sensorCacheInfo.size();
        }
        List list = this.sensorManager.getSensorList(-1);
        boolean bl = false;
        for (Sensor sensor : list) {
            int n = sensor.getType();
            boolean bl2 = sensor.equals((Object)this.sensorManager.getDefaultSensor(n));
            int n2 = this.translateSensorType(n, CONVERT_FORMAT_TO_PL);
            if (n2 == 1342177280) continue;
            SensorCacheInfo sensorCacheInfo = new SensorCacheInfo();
            sensorCacheInfo.sensor = sensor;
            sensorCacheInfo.plSensorType = n2;
            sensorCacheInfo.isDefaultSensor = bl2;
            sensorCacheInfo.cacheIndex = this.sensorCacheInfo.size();
            sensorCacheInfo.requestedAbstractUpdateRate = 0;
            this.sensorCacheInfo.add(sensorCacheInfo);
            this.sensorIndexMap.put(sensorCacheInfo.sensor, sensorCacheInfo.cacheIndex);
        }
        return this.sensorCacheInfo.size();
    }

    boolean open(int n, int n2) {
        SensorCacheInfo sensorCacheInfo;
        sensorCacheInfo = null;
        if (n2 == AR_SENSOR_INDEX_DONTCARE) {
            for (int i = 0; i < this.sensorCacheInfo.size(); ++i) {
                SensorCacheInfo sensorCacheInfo2 = this.sensorCacheInfo.get(i);
                if (sensorCacheInfo2.plSensorType != n || !sensorCacheInfo2.isDefaultSensor) continue;
                sensorCacheInfo = sensorCacheInfo2;
                break;
            }
        } else {
            sensorCacheInfo = this.sensorCacheInfo.get(n2);
        }
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(2);
            SystemTools.logSystemError("No sensor matching the requested sensor device info has been found");
            return false;
        }
        if (this.sensorEventHandler == null) {
            try {
                this.start();
                this.sensorEventHandler = new Handler(this.getLooper());
            }
            catch (Exception exception) {
                SystemTools.setSystemErrorCode(6);
                SystemTools.logSystemError("Failed to " + (this.isAlive() ? "retrieve a handler for the sensor event handler thread" : "start Java handler thread for sensor events") + ": " + exception.toString());
                return false;
            }
        }
        return true;
    }

    boolean close(int n) {
        SensorCacheInfo sensorCacheInfo = this.getSensorCacheInfo(n);
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return false;
        }
        boolean bl = false;
        try {
            this.sensorManager.unregisterListener((SensorEventListener)this, sensorCacheInfo.sensor);
            bl = true;
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to unregister sensor event listerer");
        }
        System.gc();
        return bl;
    }

    int[] getSensorInfoValues(int n) {
        SensorCacheInfo sensorCacheInfo = this.getSensorCacheInfo(n);
        if (sensorCacheInfo == null) {
            return null;
        }
        int[] arrn = new int[3];
        arrn[0] = sensorCacheInfo.plSensorType;
        arrn[1] = sensorCacheInfo.sensor.getType();
        arrn[2] = sensorCacheInfo.isDefaultSensor ? 1 : 0;
        return arrn;
    }

    String getSensorName(int n) {
        SensorCacheInfo sensorCacheInfo = this.getSensorCacheInfo(n);
        if (sensorCacheInfo == null) {
            return null;
        }
        return sensorCacheInfo.sensor.getName();
    }

    Object getTypedSensorParameter(int n, int n2) {
        SensorCacheInfo sensorCacheInfo = this.getSensorCacheInfo(n);
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return null;
        }
        try {
            switch (n2) {
                case -2147483647: 
                case -2147483640: 
                case -2147483632: 
                case -2147483616: {
                    SystemTools.setSystemErrorCode(3);
                    SystemTools.logSystemError("Querying sensor parameter " + n2 + " is not supported for sensor type " + sensorCacheInfo.plSensorType + (n2 == -2147483616 ? " when using the Java-based sensor API" : ""));
                    break;
                }
                case -2147483646: {
                    return Float.valueOf(sensorCacheInfo.sensor.getMaximumRange());
                }
                case -2147483644: {
                    return Float.valueOf(sensorCacheInfo.sensor.getResolution());
                }
                case -2147483520: {
                    if (SystemTools.checkMinimumApiLevel(9)) {
                        return sensorCacheInfo.sensor.getMinDelay();
                    }
                    SystemTools.setSystemErrorCode(3);
                    SystemTools.logSystemError("Unknown sensor parameter");
                    break;
                }
                case -2147483584: {
                    return sensorCacheInfo.requestedAbstractUpdateRate;
                }
                default: {
                    SystemTools.setSystemErrorCode(3);
                    SystemTools.logSystemError("Unknown sensor parameter");
                    break;
                }
            }
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to get sensor parameter: " + exception.toString());
        }
        return null;
    }

    boolean setTypedSensorParameter(int n, int n2, Object object) {
        SensorCacheInfo sensorCacheInfo = this.getSensorCacheInfo(n);
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return false;
        }
        try {
            switch (n2) {
                case -2147483647: 
                case -2147483646: 
                case -2147483644: 
                case -2147483640: 
                case -2147483632: 
                case -2147483616: 
                case -2147483520: {
                    SystemTools.setSystemErrorCode(3);
                    SystemTools.logSystemError("Sensor parameter " + n2 + " cannot be set for sensor type " + sensorCacheInfo.plSensorType + (n2 == -2147483616 ? " when using the Java-based sensor API" : ""));
                    break;
                }
                case -2147483584: {
                    int n3 = ((Number)object).intValue();
                    if (n3 < 1 || n3 > 4) {
                        SystemTools.setSystemErrorCode(2);
                        SystemTools.logSystemError("Invalid abstract sensor update interval (" + n3 + ")");
                        return false;
                    }
                    sensorCacheInfo.requestedAbstractUpdateRate = n3;
                    return true;
                }
                default: {
                    SystemTools.setSystemErrorCode(3);
                    SystemTools.logSystemError("Unknown sensor parameter");
                    break;
                }
            }
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to get sensor parameter: " + exception.toString());
        }
        return false;
    }

    boolean start(int n) {
        SensorCacheInfo sensorCacheInfo = this.getSensorCacheInfo(n);
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return false;
        }
        int n2 = this.translateSensorUpdateIntervalToAndroid(sensorCacheInfo.requestedAbstractUpdateRate);
        int n3 = n2 < 0 ? 1 : n2;
        boolean bl = false;
        try {
            bl = this.sensorManager.registerListener((SensorEventListener)this, sensorCacheInfo.sensor, n3, this.sensorEventHandler);
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (!bl) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to start sensor, could not register sensor event listerer");
        }
        return bl;
    }

    boolean stop(int n) {
        SensorCacheInfo sensorCacheInfo = this.getSensorCacheInfo(n);
        if (sensorCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return false;
        }
        boolean bl = false;
        try {
            this.sensorManager.unregisterListener((SensorEventListener)this, sensorCacheInfo.sensor);
            bl = true;
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to stop sensor, could not unregister sensor event listerer");
        }
        return bl;
    }

    public class SensorCacheInfo {
        Sensor sensor;
        int plSensorType;
        boolean isDefaultSensor;
        int cacheIndex;
        int requestedAbstractUpdateRate;
        float[] valuesForForcedSensorEvent;
    }

}

