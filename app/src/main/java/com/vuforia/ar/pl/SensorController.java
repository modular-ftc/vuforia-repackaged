/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  android.app.Activity
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
import android.content.Context;
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
    private static final int AR_SENSOR_PARAMTYPE_BASE = 1879048192;
    private static final int AR_SENSOR_PARAMTYPE_DATARANGE_MIN = 1879048193;
    private static final int AR_SENSOR_PARAMTYPE_DATARANGE_MAX = 1879048194;
    private static final int AR_SENSOR_PARAMTYPE_RESOLUTION = 1879048196;
    private static final int AR_SENSOR_PARAMTYPE_ACCURACY = 1879048200;
    private static final int AR_SENSOR_PARAMTYPE_SENSITIVITY = 1879048208;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL = 1879048224;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_ABSTRACT = 1879048256;
    private static final int AR_SENSOR_PARAMTYPE_UPDATEINTERVAL_MIN = 1879048320;
    private static final int AR_SENSOR_PARAMTYPE_UPDATERATE_MIN = 1879048448;
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
        super("SensorController");
    }

    private SensorCacheInfo getSensorCacheInfo(int sensorCacheInfoIndex) {
        if (sensorCacheInfoIndex < 0 || sensorCacheInfoIndex >= this.sensorCacheInfo.size()) {
            return null;
        }
        return this.sensorCacheInfo.get(sensorCacheInfoIndex);
    }

    private int translateSensorType(int fromValue, boolean conversionMode) {
        for (int i = 0; i < SENSOR_TYPE_CONVERSIONTABLE.length / 2; ++i) {
            int compareValue;
            int n = compareValue = conversionMode == CONVERT_FORMAT_TO_PL ? SENSOR_TYPE_CONVERSIONTABLE[i * 2] : SENSOR_TYPE_CONVERSIONTABLE[i * 2 + 1];
            if (fromValue != compareValue) continue;
            return conversionMode == CONVERT_FORMAT_TO_PL ? SENSOR_TYPE_CONVERSIONTABLE[i * 2 + 1] : SENSOR_TYPE_CONVERSIONTABLE[i * 2];
        }
        return conversionMode == CONVERT_FORMAT_TO_PL ? 1342177280 : 0;
    }

    private int translateSensorUpdateIntervalToAndroid(int updateIntervalValue_PL) {
        int updateIntervalValue_Android = -1;
        switch (updateIntervalValue_PL) {
            case 1: {
                updateIntervalValue_Android = 3;
                break;
            }
            case 2: {
                updateIntervalValue_Android = 2;
                break;
            }
            case 3: {
                updateIntervalValue_Android = 1;
                break;
            }
            case 4: {
                updateIntervalValue_Android = 0;
                break;
            }
        }
        return updateIntervalValue_Android;
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        Integer intObj = this.sensorIndexMap.get(event.sensor);
        if (intObj == null) {
            return;
        }
        int sensorCacheInfoIndex = intObj;
        SensorCacheInfo sci = this.getSensorCacheInfo(sensorCacheInfoIndex);
        if (sci == null) {
            return;
        }
        int plConfidenceValue = 0;
        switch (event.accuracy) {
            case 0: {
                plConfidenceValue = 1;
                break;
            }
            case 1: {
                plConfidenceValue = 2;
                break;
            }
            case 2: {
                plConfidenceValue = 3;
                break;
            }
            case 3: {
                plConfidenceValue = 4;
                break;
            }
        }
        this.newDataAvailable(sci.cacheIndex, event.timestamp, plConfidenceValue, event.values);
    }

    private native void newDataAvailable(int var1, long var2, int var4, float[] var5);

    public boolean init() {
        this.sensorManager = null;
        this.sensorCacheInfo = new Vector<>();
        this.sensorIndexMap = new HashMap<>();
        return true;
    }

    public int getAllSupportedSensors() {
        Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            SystemTools.logSystemError("No valid activity set in native!");
            return -1;
        }
        this.sensorManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
        if (this.sensorManager == null) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to retrieve Context's Sensor Service");
            return -1;
        }
        if (this.sensorCacheInfo.size() > 0) {
            return this.sensorCacheInfo.size();
        }
        List<Sensor> supportedSensors = this.sensorManager.getSensorList(-1);
        boolean supportedSensorIndex = false;
        for (Sensor sensor : supportedSensors) {
            int sensorType = sensor.getType();
            boolean isDefaultSensor = sensor.equals(this.sensorManager.getDefaultSensor(sensorType));
            int plSensorType = this.translateSensorType(sensorType, CONVERT_FORMAT_TO_PL);
            if (plSensorType == 1342177280) continue;
            SensorCacheInfo sci = new SensorCacheInfo();
            sci.sensor = sensor;
            sci.plSensorType = plSensorType;
            sci.isDefaultSensor = isDefaultSensor;
            sci.cacheIndex = this.sensorCacheInfo.size();
            sci.requestedAbstractUpdateRate = 0;
            this.sensorCacheInfo.add(sci);
            this.sensorIndexMap.put(sci.sensor, sci.cacheIndex);
        }
        return this.sensorCacheInfo.size();
    }

    boolean open(int sensorType, int index) {
        SensorCacheInfo sci;
        sci = null;
        if (index == AR_SENSOR_INDEX_DONTCARE) {
            for (int i = 0; i < this.sensorCacheInfo.size(); ++i) {
                SensorCacheInfo tmpSCI = this.sensorCacheInfo.get(i);
                if (tmpSCI.plSensorType != sensorType || !tmpSCI.isDefaultSensor) continue;
                sci = tmpSCI;
                break;
            }
        } else {
            sci = this.sensorCacheInfo.get(index);
        }
        if (sci == null) {
            SystemTools.setSystemErrorCode(2);
            SystemTools.logSystemError("No sensor matching the requested sensor device info has been found");
            return false;
        }
        if (this.sensorEventHandler == null) {
            try {
                this.start();
                this.sensorEventHandler = new Handler(this.getLooper());
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                SystemTools.logSystemError("Failed to " + (this.isAlive() ? "retrieve a handler for the sensor event handler thread" : "start Java handler thread for sensor events") + ": " + e.toString());
                return false;
            }
        }
        return true;
    }

    boolean close(int sensorCacheInfoIndex) {
        SensorCacheInfo sci = this.getSensorCacheInfo(sensorCacheInfoIndex);
        if (sci == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return false;
        }
        boolean result = false;
        try {
            this.sensorManager.unregisterListener(this, sci.sensor);
            result = true;
        } catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to unregister sensor event listerer");
        }
        System.gc();
        return result;
    }

    int[] getSensorInfoValues(int sensorCacheInfoIndex) {
        SensorCacheInfo sci = this.getSensorCacheInfo(sensorCacheInfoIndex);
        if (sci == null) {
            return null;
        }
        int[] sensorInfoValues = new int[3];
        sensorInfoValues[0] = sci.plSensorType;
        sensorInfoValues[1] = sci.sensor.getType();
        sensorInfoValues[2] = sci.isDefaultSensor ? 1 : 0;
        return sensorInfoValues;
    }

    String getSensorName(int sensorCacheInfoIndex) {
        SensorCacheInfo sci = this.getSensorCacheInfo(sensorCacheInfoIndex);
        if (sci == null) {
            return null;
        }
        return sci.sensor.getName();
    }

    Object getTypedSensorParameter(int sensorCacheInfoIndex, int type) {
        block11:
        {
            SensorCacheInfo sci = this.getSensorCacheInfo(sensorCacheInfoIndex);
            if (sci == null) {
                SystemTools.setSystemErrorCode(4);
                SystemTools.logSystemError("Sensor handle is invalid");
                return null;
            }
            try {
                switch (type) {
                    case 1879048193:
                    case 1879048200:
                    case 1879048208:
                    case 1879048224: {
                        SystemTools.setSystemErrorCode(3);
                        SystemTools.logSystemError("Querying sensor parameter " + type + " is not supported for sensor type " + sci.plSensorType + (type == 1879048224 ? " when using the Java-based sensor API" : ""));
                        break block11;
                    }
                    case 1879048194: {
                        return Float.valueOf(sci.sensor.getMaximumRange());
                    }
                    case 1879048196: {
                        return Float.valueOf(sci.sensor.getResolution());
                    }
                    case 1879048320: {
                        if (SystemTools.checkMinimumApiLevel(9)) {
                            return sci.sensor.getMinDelay();
                        }
                        SystemTools.setSystemErrorCode(3);
                        SystemTools.logSystemError("Unknown sensor parameter");
                        break block11;
                    }
                    case 1879048256: {
                        return sci.requestedAbstractUpdateRate;
                    }
                }
                SystemTools.setSystemErrorCode(3);
                SystemTools.logSystemError("Unknown sensor parameter");
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                SystemTools.logSystemError("Failed to get sensor parameter: " + e.toString());
            }
        }
        return null;
    }

    boolean setTypedSensorParameter(int sensorCacheInfoIndex, int type, Object value) {
        block8:
        {
            SensorCacheInfo sci = this.getSensorCacheInfo(sensorCacheInfoIndex);
            if (sci == null) {
                SystemTools.setSystemErrorCode(4);
                SystemTools.logSystemError("Sensor handle is invalid");
                return false;
            }
            try {
                switch (type) {
                    case 1879048193:
                    case 1879048194:
                    case 1879048196:
                    case 1879048200:
                    case 1879048208:
                    case 1879048224:
                    case 1879048320: {
                        SystemTools.setSystemErrorCode(3);
                        SystemTools.logSystemError("Sensor parameter " + type + " cannot be set for sensor type " + sci.plSensorType + (type == 1879048224 ? " when using the Java-based sensor API" : ""));
                        break block8;
                    }
                    case 1879048256: {
                        int updateIntervalValue = ((Number) value).intValue();
                        if (updateIntervalValue < 1 || updateIntervalValue > 4) {
                            SystemTools.setSystemErrorCode(2);
                            SystemTools.logSystemError("Invalid abstract sensor update interval (" + updateIntervalValue + ")");
                            return false;
                        }
                        sci.requestedAbstractUpdateRate = updateIntervalValue;
                        return true;
                    }
                }
                SystemTools.setSystemErrorCode(3);
                SystemTools.logSystemError("Unknown sensor parameter");
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                SystemTools.logSystemError("Failed to get sensor parameter: " + e.toString());
            }
        }
        return false;
    }

    boolean start(int sensorCacheInfoIndex) {
        SensorCacheInfo sci = this.getSensorCacheInfo(sensorCacheInfoIndex);
        if (sci == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return false;
        }
        int updateRateAndroid = this.translateSensorUpdateIntervalToAndroid(sci.requestedAbstractUpdateRate);
        int requestedUpdateRateAndroid = updateRateAndroid < 0 ? 1 : updateRateAndroid;
        boolean result = false;
        try {
            result = this.sensorManager.registerListener(this, sci.sensor, requestedUpdateRateAndroid, this.sensorEventHandler);
        } catch (Exception exception) {
            // empty catch block
        }
        if (!result) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to start sensor, could not register sensor event listerer");
        }
        return result;
    }

    boolean stop(int sensorCacheInfoIndex) {
        SensorCacheInfo sci = this.getSensorCacheInfo(sensorCacheInfoIndex);
        if (sci == null) {
            SystemTools.setSystemErrorCode(4);
            SystemTools.logSystemError("Sensor handle is invalid");
            return false;
        }
        boolean result = false;
        try {
            this.sensorManager.unregisterListener(this, sci.sensor);
            result = true;
        } catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            SystemTools.logSystemError("Failed to stop sensor, could not unregister sensor event listerer");
        }
        return result;
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

