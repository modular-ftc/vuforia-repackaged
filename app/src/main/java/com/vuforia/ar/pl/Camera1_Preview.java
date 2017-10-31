/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.pm.PackageManager
 *  android.graphics.PixelFormat
 *  android.graphics.Rect
 *  android.graphics.SurfaceTexture
 *  android.hardware.Camera
 *  android.hardware.Camera$Area
 *  android.hardware.Camera$AutoFocusCallback
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PreviewCallback
 *  android.hardware.Camera$Size
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.vuforia.ar.pl.CameraSurface;
import com.vuforia.ar.pl.DebugLog;
import com.vuforia.ar.pl.SurfaceManager;
import com.vuforia.ar.pl.SystemTools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public class Camera1_Preview
implements Camera.PreviewCallback {
    private SurfaceManager surfaceManager = null;
    private Vector<CameraCacheInfo> cameraCacheInfo = null;
    private HashMap<Camera, Integer> cameraCacheInfoIndexCache = null;
    private static final int CAMERA_CAPTUREINFO_VALUE_WIDTH = 0;
    private static final int CAMERA_CAPTUREINFO_VALUE_HEIGHT = 1;
    private static final int CAMERA_CAPTUREINFO_VALUE_FORMAT = 2;
    private static final int CAMERA_CAPTUREINFO_VALUE_FRAMERATE = 3;
    private static final int CAMERA_CAPTUREINFO_VALUE_PREVIEWSURFACEENABLED = 4;
    private static final int _NUM_CAMERA_CAPTUREINFO_VALUE_ = 5;
    private static final int CAMERA_CAPSINFO_VALUE_SUPPORTED_QUERYABLE_PARAMS = 0;
    private static final int CAMERA_CAPSINFO_VALUE_SUPPORTED_SETTABLE_PARAMS = 1;
    private static final int CAMERA_CAPSINFO_VALUE_SUPPORTED_PARAMVALUES = 2;
    private static final int CAMERA_CAPSINFO_VALUE_NUM_SUPPORTED_IMAGESIZES = 3;
    private static final int CAMERA_CAPSINFO_VALUE_NUM_SUPPORTED_FRAMERATES = 4;
    private static final int CAMERA_CAPSINFO_VALUE_NUM_SUPPORTED_IMAGEFORMATS = 5;
    private static final int _NUM_CAMERA_CAPSINFO_VALUE_ = 6;
    private static final int AR_CAMERA_PARAMTYPE_BASE = 536870912;
    private static final int AR_CAMERA_PARAMTYPE_TORCHMODE = 536870913;
    private static final int AR_CAMERA_PARAMTYPE_FOCUSMODE = 536870914;
    private static final int AR_CAMERA_PARAMTYPE_FOCUSVALUE = 536870916;
    private static final int AR_CAMERA_PARAMTYPE_FOCUSRANGE = 536870920;
    private static final int AR_CAMERA_PARAMTYPE_FOCUSREGION = 536870928;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSUREMODE = 536870944;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSUREVALUE = 536870976;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSURERANGE = 536871040;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONVALUE = 536871168;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSURECOMPENSATIONRANGE = 536871424;
    private static final int AR_CAMERA_PARAMTYPE_WHITEBALANCEMODE = 536871936;
    private static final int AR_CAMERA_PARAMTYPE_WHITEBALANCEVALUE = 536872960;
    private static final int AR_CAMERA_PARAMTYPE_WHITEBALANCERANGE = 536875008;
    private static final int AR_CAMERA_PARAMTYPE_ZOOMVALUE = 536879104;
    private static final int AR_CAMERA_PARAMTYPE_ZOOMRANGE = 536887296;
    private static final int AR_CAMERA_PARAMTYPE_BRIGHTNESSVALUE = 536903680;
    private static final int AR_CAMERA_PARAMTYPE_BRIGHTNESSRANGE = 536936448;
    private static final int AR_CAMERA_PARAMTYPE_CONTRASTVALUE = 537001984;
    private static final int AR_CAMERA_PARAMTYPE_CONTRASTRANGE = 537133056;
    private static final int AR_CAMERA_PARAMTYPE_ROTATION = 537395200;
    private static final int AR_CAMERA_PARAMTYPE_ISO = 537919488;
    private static final int AR_CAMERA_PARAMTYPE_RECORDING_HINT = 538968064;
    private static final int AR_CAMERA_PARAMTYPE_VIDEO_STABILIZATION = 545259520;
    private static final int AR_CAMERA_PARAMVALUE_BASE = 805306368;
    private static final int AR_CAMERA_TORCHMODE_OFF = 805306369;
    private static final int AR_CAMERA_TORCHMODE_ON = 805306370;
    private static final int AR_CAMERA_TORCHMODE_AUTO = 805306372;
    private static final int AR_CAMERA_TORCHMODE_CONTINUOUSAUTO = 805306376;
    private static final int AR_CAMERA_FOCUSMODE_NORMAL = 805306384;
    private static final int AR_CAMERA_FOCUSMODE_AUTO = 805306400;
    private static final int AR_CAMERA_FOCUSMODE_CONTINUOUSAUTO = 805306432;
    private static final int AR_CAMERA_FOCUSMODE_MACRO = 805306496;
    private static final int AR_CAMERA_FOCUSMODE_INFINITY = 805306624;
    private static final int AR_CAMERA_FOCUSMODE_FIXED = 805306880;
    private static final int AR_CAMERA_EXPOSUREMODE_LOCKED = 805310464;
    private static final int AR_CAMERA_EXPOSUREMODE_AUTO = 805314560;
    private static final int AR_CAMERA_EXPOSUREMODE_CONTINUOUSAUTO = 805322752;
    private static final int AR_CAMERA_WHITEBALANCEMODE_LOCKED = 805371904;
    private static final int AR_CAMERA_WHITEBALANCEMODE_AUTO = 805437440;
    private static final int AR_CAMERA_WHITEBALANCEMODE_CONTINUOUSAUTO = 805568512;
    private static final int AR_CAMERA_TYPE_UNKNOWN = 268447760;
    private static final int AR_CAMERA_TYPE_MONO = 268447761;
    private static final int AR_CAMERA_TYPE_STEREO = 268447762;
    private static final int AR_CAMERA_DIRECTION_UNKNOWN = 268443664;
    private static final int AR_CAMERA_DIRECTION_BACK = 268443665;
    private static final int AR_CAMERA_DIRECTION_FRONT = 268443666;
    private static final int AR_CAMERA_STATUS_UNKNOWN = 268443648;
    private static final int AR_CAMERA_STATUS_UNINITIALIZED = 268443649;
    private static final int AR_CAMERA_STATUS_OPENED = 268443650;
    private static final int AR_CAMERA_STATUS_CAPTURE_RUNNING = 268443651;
    private static final int AR_CAMERA_IMAGE_FORMAT_UNKNOWN = 268439808;
    private static final int AR_CAMERA_IMAGE_FORMAT_LUM = 268439809;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGB565 = 268439810;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGB888 = 268439811;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGB24 = 268439811;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGBA8888 = 268439812;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGBA32 = 268439812;
    private static final int AR_CAMERA_IMAGE_FORMAT_ARGB8888 = 268439813;
    private static final int AR_CAMERA_IMAGE_FORMAT_ARGB32 = 268439813;
    private static final int AR_CAMERA_IMAGE_FORMAT_BGRA8888 = 268439814;
    private static final int AR_CAMERA_IMAGE_FORMAT_BGRA32 = 268439814;
    private static final int AR_CAMERA_IMAGE_FORMAT_NV12 = 268439815;
    private static final int AR_CAMERA_IMAGE_FORMAT_NV16 = 268439816;
    private static final int AR_CAMERA_IMAGE_FORMAT_NV21 = 268439817;
    private static final int AR_CAMERA_IMAGE_FORMAT_YV12 = 268439818;
    private static final int AR_CAMERA_IMAGE_FORMAT_YV16 = 268439819;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGBA5551 = 268439820;
    private static final int AR_CAMERA_IMAGE_FORMAT_RGBA4444 = 268439821;
    private static final int AR_CAMERA_IMAGE_FORMAT_BGR888 = 268439822;
    private static final int AR_CAMERA_IMAGE_FORMAT_BGR24 = 268439822;
    private static final int[] CAMERA_IMAGE_FORMAT_CONVERSIONTABLE = new int[]{16, 268439816, 17, 268439817, 4, 268439810, 842094169, 268439818};
    private static boolean CONVERT_FORMAT_TO_PL = true;
    private static boolean CONVERT_FORMAT_TO_ANDROID = false;
    private static final int NUM_CAPTURE_BUFFERS = 2;
    private static final int NUM_CAPTURE_BUFFERS_TO_ADD = 2;
    private static final int NUM_MAX_CAMERAOPEN_RETRY = 10;
    private static final int TIME_CAMERAOPEN_RETRY_DELAY_MS = 250;
    private static final String MODULENAME = "Camera1_Preview";
    private static final String FOCUS_MODE_NORMAL = "normal";
    private static final String SAMSUNG_PARAM_VRMODE_SUPPORTED = "vrmode-supported";
    private static final String SAMSUNG_PARAM_VRMODE = "vrmode";
    private static final String SAMSUNG_PARAM_FAST_FPS_MODE = "fast-fps-mode";

    private boolean checkPermission() {
        try {
            Activity activity = SystemTools.getActivityFromNative();
            if (activity == null) {
                return false;
            }
            PackageManager pm = activity.getPackageManager();
            int isPermissionGranted = pm.checkPermission("android.permission.CAMERA", activity.getPackageName());
            if (isPermissionGranted == 0) {
                return true;
            }
        }
        catch (Exception activity) {
            // empty catch block
        }
        return false;
    }

    private int getCameraDeviceIndex(int camIndex, int type, int direction) {
        if (type != 268447760) {
            // empty if block
        }
        if (SystemTools.checkMinimumApiLevel(9)) {
            int camInfoDirection = -1;
            switch (direction) {
                case 268443664: {
                    break;
                }
                case 268443665: {
                    camInfoDirection = 0;
                    break;
                }
                case 268443666: {
                    camInfoDirection = 1;
                    break;
                }
                default: {
                    SystemTools.setSystemErrorCode(2);
                    return -1;
                }
            }
            int num = Camera.getNumberOfCameras();
            for (int i = 0; i < num; ++i) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                try {
                    Camera.getCameraInfo((int)i, (Camera.CameraInfo)cameraInfo);
                }
                catch (Exception e) {
                    continue;
                }
                if (camInfoDirection >= 0 && camInfoDirection != cameraInfo.facing || camIndex >= 0 && camIndex != i) continue;
                return i;
            }
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (direction == 268443666) {
            SystemTools.setSystemErrorCode(2);
            return -1;
        }
        if (camIndex >= 1) {
            SystemTools.setSystemErrorCode(2);
            return -1;
        }
        return 0;
    }

    private Camera.Parameters getCameraParameters(Camera camera) {
        Camera.Parameters params = null;
        try {
            params = camera.getParameters();
        }
        catch (Exception exception) {
            // empty catch block
        }
        return params;
    }

    private CameraCacheInfo getCameraCacheInfo(int cameraCacheInfoIndex) {
        if (cameraCacheInfoIndex < 0 || cameraCacheInfoIndex >= this.cameraCacheInfo.size()) {
            return null;
        }
        return this.cameraCacheInfo.get(cameraCacheInfoIndex);
    }

    private boolean setCustomCameraParams(Camera.Parameters cameraParams, String customData) {
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(customData);
        }
        catch (JSONException e) {
            return false;
        }
        Iterator elements = jsonObj.keys();
        while (elements.hasNext()) {
            Object value;
            String key = (String)elements.next();
            try {
                value = jsonObj.get(key);
            }
            catch (JSONException e) {
                return false;
            }
            if (value.getClass() == String.class) {
                cameraParams.set(key, (String)value);
                continue;
            }
            if (value.getClass() == Integer.class) {
                cameraParams.set(key, ((Integer)value).intValue());
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean setCameraPreviewFps(int fps, Camera.Parameters params) {
        List<int[]> supportedFpsRanges = params.getSupportedPreviewFpsRange();
        int min_fps = fps * 1000;
        int best_range = Integer.MAX_VALUE;
        int[] selected_range = null;
        if ((fps == 60 || fps == 120) && "true".equalsIgnoreCase(params.get("vrmode-supported"))) {
            selected_range = new int[2];
            params.set("vrmode", 1);
            params.setRecordingHint(true);
            params.set("focus-mode", "continuous-video");
            if (fps == 60) {
                params.set("fast-fps-mode", 1);
                selected_range[0] = 60000;
                selected_range[1] = 60000;
            }
            if (fps == 120) {
                params.set("fast-fps-mode", 2);
                selected_range[0] = 120000;
                selected_range[1] = 120000;
            }
        } else {
            if ("true".equalsIgnoreCase(params.get("vrmode-supported")) && params.get("fast-fps-mode") != null && params.getInt("fast-fps-mode") != 0) {
                params.set("vrmode", 0);
                params.set("fast-fps-mode", 0);
            }
            for (int[] range : supportedFpsRanges) {
                int delta;
                if (range[0] != min_fps || (delta = range[1] - range[0]) >= best_range) continue;
                selected_range = range;
            }
        }
        if (selected_range != null) {
            params.setPreviewFpsRange(selected_range[0], selected_range[1]);
            return true;
        }
        return false;
    }

    private boolean setCameraCaptureParams(CameraCacheInfo camCacheInfo, Camera.Parameters camParams, int[] captureInfo, int[] overrideCaptureInfo) {
        boolean previewSurfaceEnabled;
        if (captureInfo != null || overrideCaptureInfo != null) {
            camCacheInfo.overrideWidth = overrideCaptureInfo != null ? overrideCaptureInfo[0] : captureInfo[0];
            camCacheInfo.overrideHeight = overrideCaptureInfo != null ? overrideCaptureInfo[1] : captureInfo[1];
            camCacheInfo.overrideFormatAndroid = this.translateImageFormat(overrideCaptureInfo != null ? overrideCaptureInfo[2] : captureInfo[2], CONVERT_FORMAT_TO_ANDROID);
        }
        if (captureInfo == null) {
            return true;
        }
        camCacheInfo.requestWidth = captureInfo[0];
        camCacheInfo.requestHeight = captureInfo[1];
        camCacheInfo.requestFormatAndroid = this.translateImageFormat(captureInfo[2], CONVERT_FORMAT_TO_ANDROID);
        int framerate = captureInfo[3];
        try {
            if (camCacheInfo.requestWidth > 0 && camCacheInfo.requestHeight > 0) {
                camParams.setPreviewSize(camCacheInfo.requestWidth, camCacheInfo.requestHeight);
            }
            if (framerate > 0) {
                if (SystemTools.checkMinimumApiLevel(8)) {
                    if (!this.setCameraPreviewFps(framerate, camParams)) {
                        camParams.setPreviewFrameRate(framerate);
                    }
                } else {
                    camParams.setPreviewFrameRate(framerate);
                }
            }
            if (camCacheInfo.requestFormatAndroid != 0) {
                camParams.setPreviewFormat(camCacheInfo.requestFormatAndroid);
            }
        }
        catch (Exception e) {
            return false;
        }
        boolean bl = previewSurfaceEnabled = captureInfo[4] > 0;
        if (previewSurfaceEnabled) {
            if (SystemTools.checkMinimumApiLevel(11)) {
                int textureID = -1;
                try {
                    camCacheInfo.surfaceTexture = new SurfaceTexture(textureID);
                }
                catch (Exception e) {
                    return false;
                }
                try {
                    camCacheInfo.camera.setPreviewTexture(camCacheInfo.surfaceTexture);
                }
                catch (Exception e) {}
            } else if (this.surfaceManager != null) {
                boolean result = this.surfaceManager.addCameraSurface(camCacheInfo);
                if (!result) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean checkSamsungHighFPS(CameraCacheInfo cci) {
        Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        if ("true".equalsIgnoreCase(cameraParams.get("vrmode-supported")) && cci.requestWidth > 0 && cci.requestHeight > 0 && cameraParams.get("fast-fps-mode") != null && cameraParams.getInt("fast-fps-mode") != 0 && (cci.requestWidth != cameraParams.getPreviewSize().width || cci.requestHeight != cameraParams.getPreviewSize().height)) {
            DebugLog.LOGW("Camera1_Preview", "Detected Samsung high fps camera driver bug.");
            DebugLog.LOGW("Camera1_Preview", "Preview size doesn't match request; width " + cci.requestWidth + "!=" + cameraParams.getPreviewSize().width + " or height " + cci.requestHeight + "!=" + cameraParams.getPreviewSize().height);
            this.setCameraPreviewFps(30, cameraParams);
            cameraParams.setPreviewSize(cci.requestWidth, cci.requestHeight);
            try {
                cci.camera.setParameters(cameraParams);
            }
            catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
            cameraParams = this.getCameraParameters(cci.camera);
            if (cci.requestWidth != cameraParams.getPreviewSize().width || cci.requestHeight != cameraParams.getPreviewSize().height) {
                DebugLog.LOGE("Camera1_Preview", "Unable to workaround Samsung high fps camera driver bug.");
                DebugLog.LOGE("Camera1_Preview", "Preview size doesn't match request; width " + cci.requestWidth + "!=" + cameraParams.getPreviewSize().width + " or height " + cci.requestHeight + "!=" + cameraParams.getPreviewSize().height);
                return false;
            }
        }
        return true;
    }

    private boolean setupPreviewBuffer(CameraCacheInfo cci) {
        int bitsPerPixel;
        block7 : {
            Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
            if (cameraParams == null) {
                return false;
            }
            int bufferFormatAndroid = 0;
            try {
                cci.bufferWidth = cci.requestWidth == cci.overrideWidth ? cameraParams.getPreviewSize().width : cci.overrideWidth;
                cci.bufferHeight = cci.requestHeight == cci.overrideHeight ? cameraParams.getPreviewSize().height : cci.overrideHeight;
                bufferFormatAndroid = cci.requestFormatAndroid == cci.overrideFormatAndroid ? cameraParams.getPreviewFormat() : cci.overrideFormatAndroid;
                cci.bufferFormatPL = this.translateImageFormat(bufferFormatAndroid, CONVERT_FORMAT_TO_PL);
            }
            catch (Exception e) {
                return false;
            }
            bitsPerPixel = 0;
            try {
                PixelFormat pixelFormatInfo = new PixelFormat();
                PixelFormat.getPixelFormatInfo((int)bufferFormatAndroid, (PixelFormat)pixelFormatInfo);
                bitsPerPixel = pixelFormatInfo.bitsPerPixel;
            }
            catch (Exception e) {
                bitsPerPixel = this.getBitsPerPixel(bufferFormatAndroid);
                if (bitsPerPixel != 0) break block7;
                return false;
            }
        }
        int bufferSize = cci.bufferWidth * cci.bufferHeight * bitsPerPixel / 8 + 4096;
        if (bufferSize <= cci.bufferSize) {
            cci.camera.setPreviewCallbackWithBuffer((Camera.PreviewCallback)this);
            return true;
        }
        cci.buffer = new byte[2][];
        for (int i = 0; i < 2; ++i) {
            cci.buffer[i] = new byte[bufferSize];
            if (i >= 2) continue;
            cci.camera.addCallbackBuffer(cci.buffer[i]);
        }
        cci.bufferSize = bufferSize;
        cci.camera.setPreviewCallbackWithBuffer((Camera.PreviewCallback)this);
        System.gc();
        return true;
    }

    private void setCameraCapsBit(CameraCacheInfo cci, int capsIndex, int paramType, boolean value) {
        int baseValue = 0;
        switch (capsIndex) {
            case 2: {
                baseValue = 805306368;
                break;
            }
            case 0: 
            case 1: {
                baseValue = 536870912;
                break;
            }
            default: {
                return;
            }
        }
        int index = (int)(Math.log(paramType & ~ baseValue) / Math.log(2.0));
        if (value) {
            int[] arrn = cci.caps;
            int n = capsIndex;
            arrn[n] = arrn[n] | 1 << index;
        } else {
            int[] arrn = cci.caps;
            int n = capsIndex;
            arrn[n] = arrn[n] & ~ (1 << index);
        }
    }

    private int translateImageFormat(int fromValue, boolean conversionMode) {
        for (int i = 0; i < CAMERA_IMAGE_FORMAT_CONVERSIONTABLE.length / 2; ++i) {
            int compareValue;
            int n = compareValue = conversionMode == CONVERT_FORMAT_TO_PL ? CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i * 2] : CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i * 2 + 1];
            if (fromValue != compareValue) continue;
            return conversionMode == CONVERT_FORMAT_TO_PL ? CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i * 2 + 1] : CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i * 2];
        }
        return conversionMode == CONVERT_FORMAT_TO_PL ? 268439808 : 0;
    }

    int getBitsPerPixel(int imgFormat) {
        switch (imgFormat) {
            case 16: {
                return 16;
            }
            case 4: {
                return 16;
            }
            case 17: {
                return 12;
            }
            case 842094169: {
                return 12;
            }
        }
        return 0;
    }

    public void onPreviewFrame(byte[] capturedBuffer, Camera camera) {
        Integer intObj;
        long frameTimeStamp = System.nanoTime();
        if (SystemTools.checkMinimumApiLevel(18)) {
            // empty if block
        }
        if ((intObj = this.cameraCacheInfoIndexCache.get((Object)camera)) == null) {
            if (SystemTools.checkMinimumApiLevel(18)) {
                // empty if block
            }
            return;
        }
        int cameraCacheInfoIndex = intObj;
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            if (SystemTools.checkMinimumApiLevel(18)) {
                // empty if block
            }
            return;
        }
        this.newFrameAvailable(cci.deviceHandle, cameraCacheInfoIndex, cci.bufferWidth, cci.bufferHeight, cci.bufferFormatPL, capturedBuffer, frameTimeStamp);
        camera.addCallbackBuffer(capturedBuffer);
        if (SystemTools.checkMinimumApiLevel(18)) {
            // empty if block
        }
    }

    private native void newFrameAvailable(long var1, int var3, int var4, int var5, int var6, byte[] var7, long var8);

    public boolean init() {
        this.cameraCacheInfo = new Vector<>();
        this.cameraCacheInfoIndexCache = new HashMap<>();
        return true;
    }

    public void setSurfaceManager(SurfaceManager sm) {
        this.surfaceManager = sm;
    }

    public int getNumberOfCameras() {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (SystemTools.checkMinimumApiLevel(9)) {
            try {
                int num = Camera.getNumberOfCameras();
                return num;
            }
            catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
        }
        boolean deviceHasCamera = false;
        try {
            PackageManager pm = SystemTools.getActivityFromNative().getPackageManager();
            deviceHasCamera = pm.hasSystemFeature("android.hardware.camera");
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        return deviceHasCamera ? 1 : 0;
    }

    public int getOrientation(int cameraID) {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (SystemTools.checkMinimumApiLevel(9)) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            try {
                Camera.getCameraInfo((int)cameraID, (Camera.CameraInfo)cameraInfo);
            }
            catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
            return cameraInfo.orientation;
        }
        SystemTools.setSystemErrorCode(6);
        return -1;
    }

    public int getDirection(int cameraID) {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (SystemTools.checkMinimumApiLevel(9)) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            try {
                Camera.getCameraInfo((int)cameraID, (Camera.CameraInfo)cameraInfo);
            }
            catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
            switch (cameraInfo.facing) {
                case 0: {
                    return 268443665;
                }
                case 1: {
                    return 268443666;
                }
            }
            return 268443664;
        }
        return 268443665;
    }

    public int getDeviceID(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return -1;
        }
        return cci.deviceID;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int open(long deviceHandle, int camIndex, int type, int direction, String customData, int[] captureInfo, int[] overrideCaptureInfo) {
        boolean setCustomData;
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        int cameraDeviceIndex = this.getCameraDeviceIndex(camIndex, type, direction);
        if (cameraDeviceIndex < 0) {
            return -1;
        }
        int cameraCacheInfoIndex = -1;
        CameraCacheInfo cci = null;
        int cameraCacheInfoSize = this.cameraCacheInfo.size();
        for (int i = 0; i < cameraCacheInfoSize; ++i) {
            cci = this.cameraCacheInfo.get(i);
            if (cci.deviceID != cameraDeviceIndex) continue;
            cameraCacheInfoIndex = i;
            break;
        }
        if (cameraCacheInfoIndex < 0) {
            cci = new CameraCacheInfo();
            cci.deviceID = cameraDeviceIndex;
            cci.deviceHandle = deviceHandle;
            cci.camera = null;
            cci.surface = null;
            cci.buffer = null;
            cci.overrideWidth = 0;
            cci.requestWidth = 0;
            cci.bufferWidth = 0;
            cci.overrideHeight = 0;
            cci.requestHeight = 0;
            cci.bufferHeight = 0;
            cci.bufferFormatPL = 268439808;
            cci.overrideFormatAndroid = 0;
            cci.requestFormatAndroid = 0;
            cci.caps = null;
            cci.status = 268443649;
            cci.isAutoFocusing = false;
            cci.isHalDriven = false;
        }
        cci.bufferSize = 0;
        boolean resultCameraOpened = false;
        int cameraOpenRetryCount = 10;
        do {
            try {
                if (SystemTools.checkMinimumApiLevel(9)) {
                    cci.camera = Camera.open((int)cci.deviceID);
                } else if (cci.deviceID == 0) {
                    cci.camera = Camera.open();
                }
                resultCameraOpened = cci.camera != null;
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (resultCameraOpened) continue;
            try {
                if (cameraOpenRetryCount <= 0) continue;
                Camera1_Preview camera1_Preview = this;
                synchronized (camera1_Preview) {
                    this.wait(250);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        } while (!resultCameraOpened && cameraOpenRetryCount-- > 0);
        if (cci.camera == null) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        boolean setCaptureInfo = captureInfo != null && captureInfo.length > 0 || overrideCaptureInfo != null && overrideCaptureInfo.length > 0;
        boolean bl = setCustomData = customData != null && customData.length() > 0;
        if (setCaptureInfo || setCustomData) {
            boolean result;
            Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
            if (cameraParams == null) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
            if (setCaptureInfo) {
                if (captureInfo != null && captureInfo.length != 5) {
                    SystemTools.setSystemErrorCode(2);
                    return -1;
                }
                result = this.setCameraCaptureParams(cci, cameraParams, captureInfo, overrideCaptureInfo);
                if (!result) {
                    SystemTools.setSystemErrorCode(6);
                    return -1;
                }
            }
            if (setCustomData && !(result = this.setCustomCameraParams(cameraParams, customData))) {
                SystemTools.setSystemErrorCode(2);
                return -1;
            }
            try {
                cci.camera.setParameters(cameraParams);
            }
            catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
            if (!this.checkSamsungHighFPS(cci)) {
                return -1;
            }
        }
        cci.status = 268443650;
        if (cameraCacheInfoIndex < 0) {
            this.cameraCacheInfo.add(cci);
            cameraCacheInfoIndex = this.cameraCacheInfo.size() - 1;
        }
        this.cameraCacheInfoIndexCache.put(cci.camera, cameraCacheInfoIndex);
        return cameraCacheInfoIndex;
    }

    public int registerHalCamera(int camIndex, int type, int direction, String customData, int[] captureInfo, int[] overrideCaptureInfo) {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        int cameraDeviceIndex = this.getCameraDeviceIndex(camIndex, type, direction);
        if (cameraDeviceIndex < 0) {
            return -1;
        }
        int cameraCacheInfoIndex = -1;
        CameraCacheInfo cci = null;
        int cameraCacheInfoSize = this.cameraCacheInfo.size();
        for (int i = 0; i < cameraCacheInfoSize; ++i) {
            cci = this.cameraCacheInfo.get(i);
            if (cci.deviceID != cameraDeviceIndex || !cci.isHalDriven) continue;
            cameraCacheInfoIndex = i;
            break;
        }
        if (cameraCacheInfoIndex < 0) {
            cci = new CameraCacheInfo();
            cci.deviceID = cameraDeviceIndex;
            cci.camera = null;
            cci.surface = null;
            cci.buffer = null;
            cci.overrideWidth = 0;
            cci.requestWidth = 0;
            cci.bufferWidth = 0;
            cci.overrideHeight = 0;
            cci.requestHeight = 0;
            cci.bufferHeight = 0;
            cci.bufferFormatPL = 268439808;
            cci.overrideFormatAndroid = 0;
            cci.requestFormatAndroid = 0;
            cci.caps = null;
            cci.status = 268443649;
            cci.isAutoFocusing = false;
            cci.isHalDriven = true;
        }
        cci.bufferSize = 0;
        if (cameraCacheInfoIndex < 0) {
            this.cameraCacheInfo.add(cci);
            cameraCacheInfoIndex = this.cameraCacheInfo.size() - 1;
            DebugLog.LOGD("Camera1_Preview", "New HAL camera cache info added to cache");
        }
        return cameraCacheInfoIndex;
    }

    public boolean close(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        if (cci.isHalDriven) {
            DebugLog.LOGW("Camera1_Preview", "We shouldn't be here for HAL driven camera!");
            return true;
        }
        this.cameraCacheInfoIndexCache.remove((Object)cci.camera);
        boolean result = false;
        try {
            cci.camera.release();
            result = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        cci.camera = null;
        cci.buffer = null;
        cci.status = 268443649;
        System.gc();
        return result;
    }

    public int[] getCameraCapabilities(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        if (cci.caps != null) {
            return cci.caps;
        }
        Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        List<Camera.Size> supportedImageSizes = cameraParams.getSupportedPreviewSizes();
        List<Integer> supportedFrameRates = cameraParams.getSupportedPreviewFrameRates();
        List<Integer> supportedImageFormats = cameraParams.getSupportedPreviewFormats();
        List<String> supportedFlashModes = cameraParams.getSupportedFlashModes();
        List<String> supportedFocusModes = cameraParams.getSupportedFocusModes();
        int numSupportedImageSizes = supportedImageSizes != null ? supportedImageSizes.size() : 0;
        int numSupportedFrameRates = supportedFrameRates != null ? supportedFrameRates.size() : 0;
        int numSupportedImageFormats = supportedImageFormats != null ? supportedImageFormats.size() : 0;
        int capsArraySize = 6 + numSupportedImageSizes * 2 + numSupportedFrameRates + numSupportedImageFormats;
        cci.caps = new int[capsArraySize];
        int capsIndex = 0;
        cci.caps[capsIndex] = 536870912;
        this.setCameraCapsBit(cci, capsIndex, 536870913, supportedFlashModes != null ? supportedFlashModes.contains("torch") || supportedFlashModes.contains("on") : false);
        this.setCameraCapsBit(cci, capsIndex, 536870914, true);
        this.setCameraCapsBit(cci, capsIndex, 536870916, SystemTools.checkMinimumApiLevel(8));
        this.setCameraCapsBit(cci, capsIndex, 536870928, SystemTools.checkMinimumApiLevel(14));
        this.setCameraCapsBit(cci, capsIndex, 536871168, SystemTools.checkMinimumApiLevel(8));
        this.setCameraCapsBit(cci, capsIndex, 536871424, SystemTools.checkMinimumApiLevel(8));
        this.setCameraCapsBit(cci, capsIndex, 536879104, SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported());
        this.setCameraCapsBit(cci, capsIndex, 536887296, SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported());
        this.setCameraCapsBit(cci, capsIndex, 545259520, SystemTools.checkMinimumApiLevel(15));
        capsIndex = 1;
        cci.caps[capsIndex] = 536870912;
        this.setCameraCapsBit(cci, capsIndex, 536870913, supportedFlashModes != null ? supportedFlashModes.contains("torch") || supportedFlashModes.contains("on") : false);
        this.setCameraCapsBit(cci, capsIndex, 536870914, true);
        this.setCameraCapsBit(cci, capsIndex, 536870928, SystemTools.checkMinimumApiLevel(14));
        this.setCameraCapsBit(cci, capsIndex, 536871168, SystemTools.checkMinimumApiLevel(8));
        this.setCameraCapsBit(cci, capsIndex, 536879104, SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported());
        this.setCameraCapsBit(cci, capsIndex, 545259520, SystemTools.checkMinimumApiLevel(15));
        capsIndex = 2;
        cci.caps[capsIndex] = 805306368;
        if (supportedFlashModes != null && (supportedFlashModes.contains("torch") || supportedFlashModes.contains("on"))) {
            this.setCameraCapsBit(cci, capsIndex, 805306369, true);
            this.setCameraCapsBit(cci, capsIndex, 805306370, true);
        }
        if (supportedFocusModes != null) {
            this.setCameraCapsBit(cci, capsIndex, 805306384, true);
            this.setCameraCapsBit(cci, capsIndex, 805306400, supportedFocusModes.contains("auto"));
            this.setCameraCapsBit(cci, capsIndex, 805306432, supportedFocusModes.contains("continuous-video"));
            this.setCameraCapsBit(cci, capsIndex, 805306496, supportedFocusModes.contains("macro"));
            this.setCameraCapsBit(cci, capsIndex, 805306624, supportedFocusModes.contains("infinity"));
            this.setCameraCapsBit(cci, capsIndex, 805306880, supportedFocusModes.contains("fixed"));
        }
        cci.caps[3] = numSupportedImageSizes;
        cci.caps[4] = numSupportedFrameRates;
        cci.caps[5] = numSupportedImageFormats;
        int indexOffset = 6;
        if (numSupportedImageSizes > 0) {
            ListIterator<Camera.Size> iterSizes = supportedImageSizes.listIterator();
            while (iterSizes.hasNext()) {
                Camera.Size size = iterSizes.next();
                cci.caps[indexOffset] = size.width;
                cci.caps[indexOffset + 1] = size.height;
                indexOffset += 2;
            }
        }
        if (numSupportedFrameRates > 0) {
            ListIterator<Integer> iterFramerates = supportedFrameRates.listIterator();
            while (iterFramerates.hasNext()) {
                cci.caps[indexOffset] = iterFramerates.next();
                ++indexOffset;
            }
        }
        if (numSupportedImageFormats > 0) {
            ListIterator<Integer> iterFormats = supportedImageFormats.listIterator();
            while (iterFormats.hasNext()) {
                int format = iterFormats.next();
                cci.caps[indexOffset] = this.translateImageFormat(format, true);
                ++indexOffset;
            }
        }
        return cci.caps;
    }

    public boolean setCaptureInfo(int cameraCacheInfoIndex, int[] captureInfo, int[] overrideCaptureInfo) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        if (captureInfo.length != 5) {
            SystemTools.setSystemErrorCode(2);
            return false;
        }
        Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        boolean result = this.setCameraCaptureParams(cci, cameraParams, captureInfo, overrideCaptureInfo);
        if (!result) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        try {
            cci.camera.setParameters(cameraParams);
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        if (!this.checkSamsungHighFPS(cci)) {
            return false;
        }
        return true;
    }

    public int[] getCaptureInfo(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        int[] captureInfo = null;
        try {
            captureInfo = new int[5];
            captureInfo[0] = cameraParams.getPreviewSize().width;
            captureInfo[1] = cameraParams.getPreviewSize().height;
            captureInfo[2] = this.translateImageFormat(cameraParams.getPreviewFormat(), CONVERT_FORMAT_TO_PL);
            captureInfo[3] = cameraParams.getPreviewFrameRate();
            captureInfo[4] = cci.surface != null || cci.surfaceTexture != null ? 1 : 0;
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        return captureInfo;
    }

    public boolean start(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        if (!this.setupPreviewBuffer(cci)) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        try {
            cci.camera.startPreview();
            cci.status = 268443651;
            return true;
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    public boolean stop(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        try {
            cci.camera.stopPreview();
            cci.status = 268443650;
            return true;
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    public boolean setBatchParameters(int cameraCacheInfoIndex, String customData) {
        if (customData == null) {
            return false;
        }
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        if (!this.setCustomCameraParams(cameraParams, customData)) {
            return false;
        }
        cci.camera.setParameters(cameraParams);
        return true;
    }

    boolean setUntypedCameraParameter(int cameraCacheInfoIndex, String name, String value) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        try {
            cameraParams.set(name, value);
            cci.camera.setParameters(cameraParams);
            return true;
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    String getUntypedCameraParameter(int cameraCacheInfoIndex, String name) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        String parameterValue = cameraParams.get(name);
        if (parameterValue == null) {
            SystemTools.setSystemErrorCode(6);
        }
        return parameterValue;
    }

    String getFlattenedParameters(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return "";
        }
        Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return "";
        }
        return cameraParams.flatten();
    }

    boolean setTypedCameraParameter(int cameraCacheInfoIndex, int type, Object value) {
        Camera.Parameters cameraParams;
        boolean doPostSetAction;
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        block75 : {
            if (cci == null || cci.camera == null) {
                SystemTools.setSystemErrorCode(4);
                return false;
            }
            cameraParams = this.getCameraParameters(cci.camera);
            if (cameraParams == null) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
            doPostSetAction = false;
            try {
                block3 : switch (type) {
                    case 537919488: {
                        String isoValStr = Integer.toString(((Number)value).intValue());
                        String supportedIsoValues = cameraParams.get("iso-values");
                        if (supportedIsoValues != null) {
                            String[] supportedIsoValuesParts = supportedIsoValues.split(",");
                            for (int x = 0; x < supportedIsoValuesParts.length; ++x) {
                                if (!supportedIsoValuesParts[x].toLowerCase().contains(isoValStr.toLowerCase())) continue;
                                isoValStr = supportedIsoValuesParts[x];
                                break;
                            }
                        }
                        cameraParams.set("iso", isoValStr);
                        break;
                    }
                    case 538968064: {
                        int val = ((Number)value).intValue();
                        if (SystemTools.checkMinimumApiLevel(14)) {
                            cameraParams.setRecordingHint(val != 0);
                            break;
                        }
                        cameraParams.set("recording-hint", val != 0 ? "true" : "false");
                        break;
                    }
                    case 536870913: {
                        int torchMode = ((Number)value).intValue();
                        switch (torchMode) {
                            case 805306370: {
                                if (cameraParams.getSupportedFlashModes().contains("torch")) {
                                    cameraParams.setFlashMode("torch");
                                    break block3;
                                }
                                cameraParams.setFlashMode("on");
                                break block3;
                            }
                            case 805306369: {
                                cameraParams.setFlashMode("off");
                                break block3;
                            }
                            case 805306372: {
                                SystemTools.setSystemErrorCode(3);
                                return false;
                            }
                        }
                        SystemTools.setSystemErrorCode(3);
                        return false;
                    }
                    case 536870914: {
                        cci.camera.cancelAutoFocus();
                        int focusMode = ((Number)value).intValue();
                        switch (focusMode) {
                            case 805306384: {
                                if (cameraParams.getSupportedFocusModes().contains("normal")) {
                                    cameraParams.setFocusMode("normal");
                                    break block3;
                                }
                                cameraParams.setFocusMode("auto");
                                doPostSetAction = true;
                                break block3;
                            }
                            case 805306400: {
                                cameraParams.setFocusMode("auto");
                                doPostSetAction = true;
                                break block3;
                            }
                            case 805306432: {
                                if (cameraParams.getSupportedFocusModes().contains("continuous-video")) {
                                    cameraParams.setFocusMode("continuous-video");
                                    break block3;
                                }
                                SystemTools.setSystemErrorCode(6);
                                return false;
                            }
                            case 805306496: {
                                cameraParams.setFocusMode("macro");
                                break block3;
                            }
                            case 805306624: {
                                cameraParams.setFocusMode("infinity");
                                break block3;
                            }
                            case 805306880: {
                                cameraParams.setFocusMode("fixed");
                                break block3;
                            }
                        }
                        SystemTools.setSystemErrorCode(3);
                        return false;
                    }
                    case 536870916: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536870920: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536870928: {
                        if (SystemTools.checkMinimumApiLevel(14)) {
                            float[] focusRegion = (float[])value;
                            if (focusRegion.length != 5) {
                                SystemTools.setSystemErrorCode(2);
                                return false;
                            }
                            if (focusRegion[0] < 0.0f || focusRegion[0] > 1.0f || focusRegion[1] < 0.0f || focusRegion[1] > 1.0f || focusRegion[2] < 0.0f || focusRegion[2] > 1.0f || focusRegion[3] < 0.0f || focusRegion[3] > 1.0f || focusRegion[4] < 0.0f || focusRegion[4] > 1.0f) {
                                SystemTools.setSystemErrorCode(2);
                                return false;
                            }
                            Rect focusRect = new Rect((int)((double)focusRegion[0] * 2000.0) - 1000, (int)((double)focusRegion[1] * 2000.0) - 1000, (int)((double)focusRegion[2] * 2000.0) - 1000, (int)((double)focusRegion[3] * 2000.0) - 1000);
                            ArrayList<Camera.Area> focusAreaList = new ArrayList<Camera.Area>();
                            Camera.Area focusArea = new Camera.Area(focusRect, (int)((double)focusRegion[4] * 1000.0));
                            focusAreaList.add(focusArea);
                            if (cameraParams.getMaxNumFocusAreas() > 0) {
                                cameraParams.setFocusAreas(focusAreaList);
                            }
                            break;
                        }
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536870944: {
                        int exposureMode = ((Number)value).intValue();
                        switch (exposureMode) {
                            case 805310464: {
                                if (cameraParams.isAutoExposureLockSupported()) {
                                    cameraParams.setAutoExposureLock(true);
                                    break block3;
                                }
                                break block75;
                            }
                            case 805314560: 
                            case 805322752: {
                                if (cameraParams.isAutoExposureLockSupported()) {
                                    cameraParams.setAutoExposureLock(false);
                                    break block3;
                                }
                                break block75;
                            }
                        }
                        SystemTools.setSystemErrorCode(3);
                        return false;
                    }
                    case 536870976: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536871040: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536871168: {
                        if (SystemTools.checkMinimumApiLevel(8)) {
                            int expCompValue = ((Number)value).intValue();
                            cameraParams.setExposureCompensation(expCompValue);
                            break;
                        }
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536871424: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536871936: {
                        int whiteBalanceMode = ((Number)value).intValue();
                        switch (whiteBalanceMode) {
                            case 805371904: {
                                if (cameraParams.isAutoWhiteBalanceLockSupported()) {
                                    cameraParams.setAutoWhiteBalanceLock(true);
                                    break block3;
                                }
                                break block75;
                            }
                            case 805437440: 
                            case 805568512: {
                                if (cameraParams.isAutoWhiteBalanceLockSupported()) {
                                    cameraParams.setAutoWhiteBalanceLock(false);
                                    break block3;
                                }
                                break block75;
                            }
                            default: {
                                SystemTools.setSystemErrorCode(3);
                                SystemTools.logSystemError("Cannot set unknown white balance mode (" + whiteBalanceMode + ")");
                                return false;
                            }
                        }
                    }
                    case 536872960: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536875008: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536879104: {
                        if (SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported()) {
                            int zoomValue = ((Number)value).intValue();
                            cameraParams.setZoom(zoomValue);
                            break;
                        }
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536887296: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536903680: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536936448: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 537001984: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 537133056: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 537395200: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 545259520: {
                        boolean videoStabilizationMode = (Boolean)value;
                        if (videoStabilizationMode) {
                            cameraParams.setVideoStabilization(true);
                            break;
                        }
                        cameraParams.setVideoStabilization(false);
                        break;
                    }
                    default: {
                        return false;
                    }
                }
            }
            catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
        try {
            cci.camera.setParameters(cameraParams);
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        if (doPostSetAction) {
            try {
                switch (type) {
                    case 536870914: {
                        cci.isAutoFocusing = true;
                        cci.camera.autoFocus(new Camera.AutoFocusCallback(){

                            public void onAutoFocus(boolean success, Camera camera) {
                                CameraCacheInfo cci;
                                int cameraCacheInfoIndex;
                                Object intObj = Camera1_Preview.this.cameraCacheInfoIndexCache.get((Object)camera);
                                if (intObj != null && (cci = Camera1_Preview.this.getCameraCacheInfo(cameraCacheInfoIndex = ((Integer)intObj).intValue())) != null) {
                                    cci.isAutoFocusing = false;
                                }
                            }
                        });
                        break;
                    }
                }
            }
            catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
        return true;
    }

    Object getTypedCameraParameter(int cameraCacheInfoIndex, int type) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Camera.Parameters cameraParams = this.getCameraParameters(cci.camera);
        if (cameraParams == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        try {
            switch (type) {
                case 536870913: {
                    String flashMode = cameraParams.getFlashMode();
                    if (flashMode.equals("torch") || flashMode.equals("on")) {
                        return 805306370;
                    }
                    if (flashMode.equals("off")) {
                        return 805306369;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870914: {
                    String focusMode = cameraParams.getFocusMode();
                    if (focusMode.equals("auto")) {
                        return cci.isAutoFocusing ? 805306400 : 805306384;
                    }
                    if (focusMode.equals("continuous-video")) {
                        return 805306432;
                    }
                    if (focusMode.equals("infinity")) {
                        return 805306624;
                    }
                    if (focusMode.equals("macro")) {
                        return 805306496;
                    }
                    if (focusMode.equals("fixed")) {
                        return 805306880;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870916: {
                    if (SystemTools.checkMinimumApiLevel(8)) {
                        return Float.valueOf(cameraParams.getFocalLength());
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870920: {
                    if (SystemTools.checkMinimumApiLevel(9)) {
                        float[] focusDistances = new float[3];
                        cameraParams.getFocusDistances(focusDistances);
                        float[] focusValueRange = new float[]{focusDistances[0], focusDistances[2]};
                        return focusValueRange;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870928: {
                    List focusAreas;
                    if (SystemTools.checkMinimumApiLevel(14) && cameraParams.getMaxNumFocusAreas() > 0 && (focusAreas = cameraParams.getFocusAreas()).size() > 0) {
                        Camera.Area focusArea = (Camera.Area)focusAreas.get(0);
                        float[] focusRegion = new float[]{focusArea.rect.left, focusArea.rect.top, focusArea.rect.right, focusArea.rect.bottom, focusArea.weight};
                        return focusRegion;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870944: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870976: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536871040: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536871168: {
                    if (SystemTools.checkMinimumApiLevel(8)) {
                        return cameraParams.getExposureCompensation();
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536871424: {
                    if (SystemTools.checkMinimumApiLevel(8)) {
                        int[] exposureCompRange = new int[]{cameraParams.getMinExposureCompensation(), cameraParams.getMaxExposureCompensation()};
                        return exposureCompRange;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536871936: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536872960: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536875008: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536879104: {
                    if (SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported()) {
                        return cameraParams.getZoom();
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536887296: {
                    if (SystemTools.checkMinimumApiLevel(8) && cameraParams.isZoomSupported()) {
                        int[] zoomRange = new int[]{0, cameraParams.getMaxZoom()};
                        return zoomRange;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536903680: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536936448: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 537001984: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 537133056: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 537395200: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 545259520: {
                    if (cameraParams.getVideoStabilization()) {
                        return true;
                    }
                    return false;
                }
            }
            return null;
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
    }

    int getStatus(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return 268443648;
        }
        return cci.status;
    }

    public class CameraCacheInfo {
        int deviceID;
        long deviceHandle;
        Camera camera;
        CameraSurface surface;
        SurfaceTexture surfaceTexture;
        byte[][] buffer;
        int bufferWidth;
        int bufferHeight;
        int bufferFormatPL;
        int requestWidth;
        int requestHeight;
        int requestFormatAndroid;
        int overrideWidth;
        int overrideHeight;
        int overrideFormatAndroid;
        int bufferSize;
        int[] caps;
        int status;
        boolean isAutoFocusing;
        boolean isHalDriven;
    }

}

