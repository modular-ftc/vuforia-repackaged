/*
 * Decompiled with CFR 0_133.
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
    private static final int AR_CAMERA_PARAMTYPE_ISO = 536870976;
    private static final int AR_CAMERA_PARAMTYPE_ISORANGE = 536871040;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSURETIME = 536871168;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSURETIMERANGE = 536871424;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSUREVALUE = 536871936;
    private static final int AR_CAMERA_PARAMTYPE_EXPOSUREVALUERANGE = 536872960;
    private static final int AR_CAMERA_PARAMTYPE_WHITEBALANCEMODE = 536875008;
    private static final int AR_CAMERA_PARAMTYPE_WHITEBALANCEVALUE = 536879104;
    private static final int AR_CAMERA_PARAMTYPE_WHITEBALANCERANGE = 536887296;
    private static final int AR_CAMERA_PARAMTYPE_ZOOMVALUE = 536903680;
    private static final int AR_CAMERA_PARAMTYPE_ZOOMRANGE = 536936448;
    private static final int AR_CAMERA_PARAMTYPE_BRIGHTNESSVALUE = 537001984;
    private static final int AR_CAMERA_PARAMTYPE_BRIGHTNESSRANGE = 537133056;
    private static final int AR_CAMERA_PARAMTYPE_CONTRASTVALUE = 537395200;
    private static final int AR_CAMERA_PARAMTYPE_CONTRASTRANGE = 537919488;
    private static final int AR_CAMERA_PARAMTYPE_ROTATION = 538968064;
    private static final int AR_CAMERA_PARAMTYPE_RECORDING_HINT = 541065216;
    private static final int AR_CAMERA_PARAMTYPE_LENS_IS_ADJUSTING = 545259520;
    private static final int AR_CAMERA_PARAMTYPE_VIDEO_STABILIZATION = 553648128;
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
    private static final int AR_CAMERA_WHITEBALANCEMODE_LOCKED = 806354944;
    private static final int AR_CAMERA_WHITEBALANCEMODE_AUTO = 807403520;
    private static final int AR_CAMERA_WHITEBALANCEMODE_CONTINUOUSAUTO = 809500672;
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
            PackageManager packageManager = activity.getPackageManager();
            int n = packageManager.checkPermission("android.permission.CAMERA", activity.getPackageName());
            if (n == 0) {
                return true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    private int getCameraDeviceIndex(int n, int n2, int n3) {
        if (n2 != 268447760) {
            // empty if block
        }
        if (SystemTools.checkMinimumApiLevel(9)) {
            int n4 = -1;
            switch (n3) {
                case 268443664: {
                    break;
                }
                case 268443665: {
                    n4 = 0;
                    break;
                }
                case 268443666: {
                    n4 = 1;
                    break;
                }
                default: {
                    SystemTools.setSystemErrorCode(2);
                    return -1;
                }
            }
            int n5 = Camera.getNumberOfCameras();
            for (int i = 0; i < n5; ++i) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                try {
                    Camera.getCameraInfo((int)i, (Camera.CameraInfo)cameraInfo);
                }
                catch (Exception exception) {
                    continue;
                }
                if (n4 >= 0 && n4 != cameraInfo.facing || n >= 0 && n != i) continue;
                return i;
            }
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (n3 == 268443666) {
            SystemTools.setSystemErrorCode(2);
            return -1;
        }
        if (n >= 1) {
            SystemTools.setSystemErrorCode(2);
            return -1;
        }
        return 0;
    }

    private Camera.Parameters getCameraParameters(Camera camera) {
        Camera.Parameters parameters = null;
        try {
            parameters = camera.getParameters();
        }
        catch (Exception exception) {
            // empty catch block
        }
        return parameters;
    }

    private CameraCacheInfo getCameraCacheInfo(int n) {
        if (n < 0 || n >= this.cameraCacheInfo.size()) {
            return null;
        }
        return this.cameraCacheInfo.get(n);
    }

    private boolean setCustomCameraParams(Camera.Parameters parameters, String string) {
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(string);
        }
        catch (JSONException jSONException) {
            return false;
        }
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            Object object;
            String string2 = (String)iterator.next();
            try {
                object = jSONObject.get(string2);
            }
            catch (JSONException jSONException) {
                return false;
            }
            if (object.getClass() == String.class) {
                parameters.set(string2, (String)object);
                continue;
            }
            if (object.getClass() == Integer.class) {
                parameters.set(string2, ((Integer)object).intValue());
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean setCameraPreviewFps(int n, Camera.Parameters parameters) {
        List list = parameters.getSupportedPreviewFpsRange();
        int n2 = n * 1000;
        int n3 = Integer.MAX_VALUE;
        int[] arrn = null;
        if ((n == 60 || n == 120) && "true".equalsIgnoreCase(parameters.get(SAMSUNG_PARAM_VRMODE_SUPPORTED))) {
            arrn = new int[2];
            parameters.set(SAMSUNG_PARAM_VRMODE, 1);
            parameters.setRecordingHint(true);
            parameters.set("focus-mode", "continuous-video");
            if (n == 60) {
                parameters.set(SAMSUNG_PARAM_FAST_FPS_MODE, 1);
                arrn[0] = 60000;
                arrn[1] = 60000;
            }
            if (n == 120) {
                parameters.set(SAMSUNG_PARAM_FAST_FPS_MODE, 2);
                arrn[0] = 120000;
                arrn[1] = 120000;
            }
        } else {
            if ("true".equalsIgnoreCase(parameters.get(SAMSUNG_PARAM_VRMODE_SUPPORTED)) && parameters.get(SAMSUNG_PARAM_FAST_FPS_MODE) != null && parameters.getInt(SAMSUNG_PARAM_FAST_FPS_MODE) != 0) {
                parameters.set(SAMSUNG_PARAM_VRMODE, 0);
                parameters.set(SAMSUNG_PARAM_FAST_FPS_MODE, 0);
            }
            for (int[] arrn2 : list) {
                int n4;
                if (arrn2[0] != n2 || (n4 = arrn2[1] - arrn2[0]) >= n3) continue;
                arrn = arrn2;
            }
        }
        if (arrn != null) {
            parameters.setPreviewFpsRange(arrn[0], arrn[1]);
            return true;
        }
        return false;
    }

    private boolean setCameraCaptureParams(CameraCacheInfo cameraCacheInfo, Camera.Parameters parameters, int[] arrn, int[] arrn2) {
        boolean bl;
        if (arrn != null || arrn2 != null) {
            cameraCacheInfo.overrideWidth = arrn2 != null ? arrn2[0] : arrn[0];
            cameraCacheInfo.overrideHeight = arrn2 != null ? arrn2[1] : arrn[1];
            cameraCacheInfo.overrideFormatAndroid = this.translateImageFormat(arrn2 != null ? arrn2[2] : arrn[2], CONVERT_FORMAT_TO_ANDROID);
        }
        if (arrn == null) {
            return true;
        }
        cameraCacheInfo.requestWidth = arrn[0];
        cameraCacheInfo.requestHeight = arrn[1];
        cameraCacheInfo.requestFormatAndroid = this.translateImageFormat(arrn[2], CONVERT_FORMAT_TO_ANDROID);
        int n = arrn[3];
        try {
            if (cameraCacheInfo.requestWidth > 0 && cameraCacheInfo.requestHeight > 0) {
                parameters.setPreviewSize(cameraCacheInfo.requestWidth, cameraCacheInfo.requestHeight);
            }
            if (n > 0) {
                if (SystemTools.checkMinimumApiLevel(8)) {
                    if (!this.setCameraPreviewFps(n, parameters)) {
                        parameters.setPreviewFrameRate(n);
                    }
                } else {
                    parameters.setPreviewFrameRate(n);
                }
            }
            if (cameraCacheInfo.requestFormatAndroid != 0) {
                parameters.setPreviewFormat(cameraCacheInfo.requestFormatAndroid);
            }
        }
        catch (Exception exception) {
            return false;
        }
        boolean bl2 = bl = arrn[4] > 0;
        if (bl) {
            if (SystemTools.checkMinimumApiLevel(11)) {
                int n2 = -1;
                try {
                    cameraCacheInfo.surfaceTexture = new SurfaceTexture(n2);
                }
                catch (Exception exception) {
                    return false;
                }
                try {
                    cameraCacheInfo.camera.setPreviewTexture(cameraCacheInfo.surfaceTexture);
                }
                catch (Exception exception) {}
            } else if (this.surfaceManager != null) {
                boolean bl3 = this.surfaceManager.addCameraSurface(cameraCacheInfo);
                if (!bl3) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean checkSamsungHighFPS(CameraCacheInfo cameraCacheInfo) {
        Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
        if (parameters == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        if ("true".equalsIgnoreCase(parameters.get(SAMSUNG_PARAM_VRMODE_SUPPORTED)) && cameraCacheInfo.requestWidth > 0 && cameraCacheInfo.requestHeight > 0 && parameters.get(SAMSUNG_PARAM_FAST_FPS_MODE) != null && parameters.getInt(SAMSUNG_PARAM_FAST_FPS_MODE) != 0 && (cameraCacheInfo.requestWidth != parameters.getPreviewSize().width || cameraCacheInfo.requestHeight != parameters.getPreviewSize().height)) {
            DebugLog.LOGW(MODULENAME, "Detected Samsung high fps camera driver bug.");
            DebugLog.LOGW(MODULENAME, "Preview size doesn't match request; width " + cameraCacheInfo.requestWidth + "!=" + parameters.getPreviewSize().width + " or height " + cameraCacheInfo.requestHeight + "!=" + parameters.getPreviewSize().height);
            this.setCameraPreviewFps(30, parameters);
            parameters.setPreviewSize(cameraCacheInfo.requestWidth, cameraCacheInfo.requestHeight);
            try {
                cameraCacheInfo.camera.setParameters(parameters);
            }
            catch (Exception exception) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
            parameters = this.getCameraParameters(cameraCacheInfo.camera);
            if (cameraCacheInfo.requestWidth != parameters.getPreviewSize().width || cameraCacheInfo.requestHeight != parameters.getPreviewSize().height) {
                DebugLog.LOGE(MODULENAME, "Unable to workaround Samsung high fps camera driver bug.");
                DebugLog.LOGE(MODULENAME, "Preview size doesn't match request; width " + cameraCacheInfo.requestWidth + "!=" + parameters.getPreviewSize().width + " or height " + cameraCacheInfo.requestHeight + "!=" + parameters.getPreviewSize().height);
                return false;
            }
        }
        return true;
    }

    private boolean setupPreviewBuffer(CameraCacheInfo cameraCacheInfo) {
        int n;
        block7 : {
            Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
            if (parameters == null) {
                return false;
            }
            int n2 = 0;
            try {
                cameraCacheInfo.bufferWidth = cameraCacheInfo.requestWidth == cameraCacheInfo.overrideWidth ? parameters.getPreviewSize().width : cameraCacheInfo.overrideWidth;
                cameraCacheInfo.bufferHeight = cameraCacheInfo.requestHeight == cameraCacheInfo.overrideHeight ? parameters.getPreviewSize().height : cameraCacheInfo.overrideHeight;
                n2 = cameraCacheInfo.requestFormatAndroid == cameraCacheInfo.overrideFormatAndroid ? parameters.getPreviewFormat() : cameraCacheInfo.overrideFormatAndroid;
                cameraCacheInfo.bufferFormatPL = this.translateImageFormat(n2, CONVERT_FORMAT_TO_PL);
            }
            catch (Exception exception) {
                return false;
            }
            n = 0;
            try {
                PixelFormat pixelFormat = new PixelFormat();
                PixelFormat.getPixelFormatInfo((int)n2, (PixelFormat)pixelFormat);
                n = pixelFormat.bitsPerPixel;
            }
            catch (Exception exception) {
                n = this.getBitsPerPixel(n2);
                if (n != 0) break block7;
                return false;
            }
        }
        int n3 = cameraCacheInfo.bufferWidth * cameraCacheInfo.bufferHeight * n / 8 + 4096;
        if (n3 <= cameraCacheInfo.bufferSize) {
            cameraCacheInfo.camera.setPreviewCallbackWithBuffer((Camera.PreviewCallback)this);
            return true;
        }
        cameraCacheInfo.buffer = new byte[2][];
        for (int i = 0; i < 2; ++i) {
            cameraCacheInfo.buffer[i] = new byte[n3];
            if (i >= 2) continue;
            cameraCacheInfo.camera.addCallbackBuffer(cameraCacheInfo.buffer[i]);
        }
        cameraCacheInfo.bufferSize = n3;
        cameraCacheInfo.camera.setPreviewCallbackWithBuffer((Camera.PreviewCallback)this);
        System.gc();
        return true;
    }

    private void setCameraCapsBit(CameraCacheInfo cameraCacheInfo, int n, int n2, boolean bl) {
        int n3 = 0;
        switch (n) {
            case 2: {
                n3 = 805306368;
                break;
            }
            case 0: 
            case 1: {
                n3 = 536870912;
                break;
            }
            default: {
                return;
            }
        }
        int n4 = (int)(Math.log(n2 & ~ n3) / Math.log(2.0));
        if (bl) {
            int[] arrn = cameraCacheInfo.caps;
            int n5 = n;
            arrn[n5] = arrn[n5] | 1 << n4;
        } else {
            int[] arrn = cameraCacheInfo.caps;
            int n6 = n;
            arrn[n6] = arrn[n6] & ~ (1 << n4);
        }
    }

    private int translateImageFormat(int n, boolean bl) {
        for (int i = 0; i < CAMERA_IMAGE_FORMAT_CONVERSIONTABLE.length / 2; ++i) {
            int n2;
            int n3 = n2 = bl == CONVERT_FORMAT_TO_PL ? CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i * 2] : CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i * 2 + 1];
            if (n != n2) continue;
            return bl == CONVERT_FORMAT_TO_PL ? CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i * 2 + 1] : CAMERA_IMAGE_FORMAT_CONVERSIONTABLE[i * 2];
        }
        return bl == CONVERT_FORMAT_TO_PL ? 268439808 : 0;
    }

    int getBitsPerPixel(int n) {
        switch (n) {
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

    public void onPreviewFrame(byte[] arrby, Camera camera) {
        Integer n;
        long l = System.nanoTime();
        if (SystemTools.checkMinimumApiLevel(18)) {
            // empty if block
        }
        if ((n = this.cameraCacheInfoIndexCache.get((Object)camera)) == null) {
            if (SystemTools.checkMinimumApiLevel(18)) {
                // empty if block
            }
            return;
        }
        int n2 = n;
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n2);
        if (cameraCacheInfo == null) {
            if (SystemTools.checkMinimumApiLevel(18)) {
                // empty if block
            }
            return;
        }
        this.newFrameAvailable(cameraCacheInfo.deviceHandle, n2, cameraCacheInfo.bufferWidth, cameraCacheInfo.bufferHeight, cameraCacheInfo.bufferFormatPL, arrby, l);
        camera.addCallbackBuffer(arrby);
        if (SystemTools.checkMinimumApiLevel(18)) {
            // empty if block
        }
    }

    private native void newFrameAvailable(long var1, int var3, int var4, int var5, int var6, byte[] var7, long var8);

    public boolean init() {
        this.cameraCacheInfo = new Vector<E>();
        this.cameraCacheInfoIndexCache = new HashMap<K, V>();
        return true;
    }

    public void setSurfaceManager(SurfaceManager surfaceManager) {
        this.surfaceManager = surfaceManager;
    }

    public int getNumberOfCameras() {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (SystemTools.checkMinimumApiLevel(9)) {
            try {
                int n = Camera.getNumberOfCameras();
                return n;
            }
            catch (Exception exception) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
        }
        boolean bl = false;
        try {
            PackageManager packageManager = SystemTools.getActivityFromNative().getPackageManager();
            bl = packageManager.hasSystemFeature("android.hardware.camera");
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        return bl ? 1 : 0;
    }

    public int getOrientation(int n) {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (SystemTools.checkMinimumApiLevel(9)) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            try {
                Camera.getCameraInfo((int)n, (Camera.CameraInfo)cameraInfo);
            }
            catch (Exception exception) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
            return cameraInfo.orientation;
        }
        SystemTools.setSystemErrorCode(6);
        return -1;
    }

    public int getDirection(int n) {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (SystemTools.checkMinimumApiLevel(9)) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            try {
                Camera.getCameraInfo((int)n, (Camera.CameraInfo)cameraInfo);
            }
            catch (Exception exception) {
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

    public int getDeviceID(int n) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return -1;
        }
        return cameraCacheInfo.deviceID;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int open(long l, int n, int n2, int n3, String string, int[] arrn, int[] arrn2) {
        boolean bl;
        int n4;
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        int n5 = this.getCameraDeviceIndex(n, n2, n3);
        if (n5 < 0) {
            return -1;
        }
        int n6 = -1;
        CameraCacheInfo cameraCacheInfo = null;
        int n7 = this.cameraCacheInfo.size();
        for (n4 = 0; n4 < n7; ++n4) {
            cameraCacheInfo = this.cameraCacheInfo.get(n4);
            if (cameraCacheInfo.deviceID != n5) continue;
            n6 = n4;
            break;
        }
        if (n6 < 0) {
            cameraCacheInfo = new CameraCacheInfo();
            cameraCacheInfo.deviceID = n5;
            cameraCacheInfo.deviceHandle = l;
            cameraCacheInfo.camera = null;
            cameraCacheInfo.surface = null;
            cameraCacheInfo.buffer = null;
            cameraCacheInfo.overrideWidth = 0;
            cameraCacheInfo.requestWidth = 0;
            cameraCacheInfo.bufferWidth = 0;
            cameraCacheInfo.overrideHeight = 0;
            cameraCacheInfo.requestHeight = 0;
            cameraCacheInfo.bufferHeight = 0;
            cameraCacheInfo.bufferFormatPL = 268439808;
            cameraCacheInfo.overrideFormatAndroid = 0;
            cameraCacheInfo.requestFormatAndroid = 0;
            cameraCacheInfo.caps = null;
            cameraCacheInfo.status = 268443649;
            cameraCacheInfo.isAutoFocusing = false;
            cameraCacheInfo.isHalDriven = false;
        }
        cameraCacheInfo.bufferSize = 0;
        n4 = 0;
        int n8 = 10;
        do {
            try {
                if (SystemTools.checkMinimumApiLevel(9)) {
                    cameraCacheInfo.camera = Camera.open((int)cameraCacheInfo.deviceID);
                } else if (cameraCacheInfo.deviceID == 0) {
                    cameraCacheInfo.camera = Camera.open();
                }
                n4 = cameraCacheInfo.camera != null ? 1 : 0;
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (n4 != 0) continue;
            try {
                if (n8 <= 0) continue;
                Camera1_Preview camera1_Preview = this;
                synchronized (camera1_Preview) {
                    this.wait(250L);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        } while (n4 == 0 && n8-- > 0);
        if (cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        boolean bl2 = arrn != null && arrn.length > 0 || arrn2 != null && arrn2.length > 0;
        boolean bl3 = bl = string != null && string.length() > 0;
        if (bl2 || bl) {
            boolean bl4;
            Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
            if (parameters == null) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
            if (bl2) {
                if (arrn != null && arrn.length != 5) {
                    SystemTools.setSystemErrorCode(2);
                    return -1;
                }
                bl4 = this.setCameraCaptureParams(cameraCacheInfo, parameters, arrn, arrn2);
                if (!bl4) {
                    SystemTools.setSystemErrorCode(6);
                    return -1;
                }
            }
            if (bl && !(bl4 = this.setCustomCameraParams(parameters, string))) {
                SystemTools.setSystemErrorCode(2);
                return -1;
            }
            try {
                cameraCacheInfo.camera.setParameters(parameters);
            }
            catch (Exception exception) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
            if (!this.checkSamsungHighFPS(cameraCacheInfo)) {
                return -1;
            }
        }
        cameraCacheInfo.status = 268443650;
        if (n6 < 0) {
            this.cameraCacheInfo.add(cameraCacheInfo);
            n6 = this.cameraCacheInfo.size() - 1;
        }
        this.cameraCacheInfoIndexCache.put(cameraCacheInfo.camera, n6);
        return n6;
    }

    public int registerHalCamera(int n, int n2, int n3, String string, int[] arrn, int[] arrn2) {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        int n4 = this.getCameraDeviceIndex(n, n2, n3);
        if (n4 < 0) {
            return -1;
        }
        int n5 = -1;
        CameraCacheInfo cameraCacheInfo = null;
        int n6 = this.cameraCacheInfo.size();
        for (int i = 0; i < n6; ++i) {
            cameraCacheInfo = this.cameraCacheInfo.get(i);
            if (cameraCacheInfo.deviceID != n4 || !cameraCacheInfo.isHalDriven) continue;
            n5 = i;
            break;
        }
        if (n5 < 0) {
            cameraCacheInfo = new CameraCacheInfo();
            cameraCacheInfo.deviceID = n4;
            cameraCacheInfo.camera = null;
            cameraCacheInfo.surface = null;
            cameraCacheInfo.buffer = null;
            cameraCacheInfo.overrideWidth = 0;
            cameraCacheInfo.requestWidth = 0;
            cameraCacheInfo.bufferWidth = 0;
            cameraCacheInfo.overrideHeight = 0;
            cameraCacheInfo.requestHeight = 0;
            cameraCacheInfo.bufferHeight = 0;
            cameraCacheInfo.bufferFormatPL = 268439808;
            cameraCacheInfo.overrideFormatAndroid = 0;
            cameraCacheInfo.requestFormatAndroid = 0;
            cameraCacheInfo.caps = null;
            cameraCacheInfo.status = 268443649;
            cameraCacheInfo.isAutoFocusing = false;
            cameraCacheInfo.isHalDriven = true;
        }
        cameraCacheInfo.bufferSize = 0;
        if (n5 < 0) {
            this.cameraCacheInfo.add(cameraCacheInfo);
            n5 = this.cameraCacheInfo.size() - 1;
            DebugLog.LOGD("Camera1_Preview", "New HAL camera cache info added to cache");
        }
        return n5;
    }

    public boolean close(int n) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        if (cameraCacheInfo.isHalDriven) {
            DebugLog.LOGW("Camera1_Preview", "We shouldn't be here for HAL driven camera!");
            return true;
        }
        this.cameraCacheInfoIndexCache.remove((Object)cameraCacheInfo.camera);
        boolean bl = false;
        try {
            cameraCacheInfo.camera.release();
            bl = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        cameraCacheInfo.camera = null;
        cameraCacheInfo.buffer = null;
        cameraCacheInfo.status = 268443649;
        System.gc();
        return bl;
    }

    public int[] getCameraCapabilities(int n) {
        ListIterator<E> listIterator;
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        if (cameraCacheInfo.caps != null) {
            return cameraCacheInfo.caps;
        }
        Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
        if (parameters == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        List list = parameters.getSupportedPreviewSizes();
        List list2 = parameters.getSupportedPreviewFrameRates();
        List list3 = parameters.getSupportedPreviewFormats();
        List list4 = parameters.getSupportedFlashModes();
        List list5 = parameters.getSupportedFocusModes();
        int n2 = list != null ? list.size() : 0;
        int n3 = list2 != null ? list2.size() : 0;
        int n4 = list3 != null ? list3.size() : 0;
        int n5 = 6 + n2 * 2 + n3 + n4;
        cameraCacheInfo.caps = new int[n5];
        int n6 = 0;
        cameraCacheInfo.caps[n6] = 536870912;
        this.setCameraCapsBit(cameraCacheInfo, n6, 536870913, list4 != null ? list4.contains("torch") || list4.contains("on") : false);
        this.setCameraCapsBit(cameraCacheInfo, n6, 536870914, true);
        this.setCameraCapsBit(cameraCacheInfo, n6, 536870916, SystemTools.checkMinimumApiLevel(8));
        this.setCameraCapsBit(cameraCacheInfo, n6, 536870928, SystemTools.checkMinimumApiLevel(14));
        this.setCameraCapsBit(cameraCacheInfo, n6, 536871936, SystemTools.checkMinimumApiLevel(8));
        this.setCameraCapsBit(cameraCacheInfo, n6, 536872960, SystemTools.checkMinimumApiLevel(8));
        this.setCameraCapsBit(cameraCacheInfo, n6, 536903680, SystemTools.checkMinimumApiLevel(8) && parameters.isZoomSupported());
        this.setCameraCapsBit(cameraCacheInfo, n6, 536936448, SystemTools.checkMinimumApiLevel(8) && parameters.isZoomSupported());
        this.setCameraCapsBit(cameraCacheInfo, n6, 553648128, SystemTools.checkMinimumApiLevel(15));
        n6 = 1;
        cameraCacheInfo.caps[n6] = 536870912;
        this.setCameraCapsBit(cameraCacheInfo, n6, 536870913, list4 != null ? list4.contains("torch") || list4.contains("on") : false);
        this.setCameraCapsBit(cameraCacheInfo, n6, 536870914, true);
        this.setCameraCapsBit(cameraCacheInfo, n6, 536870928, SystemTools.checkMinimumApiLevel(14));
        this.setCameraCapsBit(cameraCacheInfo, n6, 536871936, SystemTools.checkMinimumApiLevel(8));
        this.setCameraCapsBit(cameraCacheInfo, n6, 536903680, SystemTools.checkMinimumApiLevel(8) && parameters.isZoomSupported());
        this.setCameraCapsBit(cameraCacheInfo, n6, 553648128, SystemTools.checkMinimumApiLevel(15));
        n6 = 2;
        cameraCacheInfo.caps[n6] = 805306368;
        if (list4 != null && (list4.contains("torch") || list4.contains("on"))) {
            this.setCameraCapsBit(cameraCacheInfo, n6, 805306369, true);
            this.setCameraCapsBit(cameraCacheInfo, n6, 805306370, true);
        }
        if (list5 != null) {
            this.setCameraCapsBit(cameraCacheInfo, n6, 805306384, true);
            this.setCameraCapsBit(cameraCacheInfo, n6, 805306400, list5.contains("auto"));
            this.setCameraCapsBit(cameraCacheInfo, n6, 805306432, list5.contains("continuous-video"));
            this.setCameraCapsBit(cameraCacheInfo, n6, 805306496, list5.contains("macro"));
            this.setCameraCapsBit(cameraCacheInfo, n6, 805306624, list5.contains("infinity"));
            this.setCameraCapsBit(cameraCacheInfo, n6, 805306880, list5.contains("fixed"));
        }
        cameraCacheInfo.caps[3] = n2;
        cameraCacheInfo.caps[4] = n3;
        cameraCacheInfo.caps[5] = n4;
        int n7 = 6;
        if (n2 > 0) {
            listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                Camera.Size size = (Camera.Size)listIterator.next();
                cameraCacheInfo.caps[n7] = size.width;
                cameraCacheInfo.caps[n7 + 1] = size.height;
                n7 += 2;
            }
        }
        if (n3 > 0) {
            listIterator = list2.listIterator();
            while (listIterator.hasNext()) {
                int n8;
                cameraCacheInfo.caps[n7] = n8 = ((Integer)listIterator.next()).intValue();
                ++n7;
            }
        }
        if (n4 > 0) {
            listIterator = list3.listIterator();
            while (listIterator.hasNext()) {
                int n9 = (Integer)listIterator.next();
                cameraCacheInfo.caps[n7] = this.translateImageFormat(n9, true);
                ++n7;
            }
        }
        return cameraCacheInfo.caps;
    }

    public boolean setCaptureInfo(int n, int[] arrn, int[] arrn2) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        if (arrn.length != 5) {
            SystemTools.setSystemErrorCode(2);
            return false;
        }
        Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
        if (parameters == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        boolean bl = this.setCameraCaptureParams(cameraCacheInfo, parameters, arrn, arrn2);
        if (!bl) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        try {
            cameraCacheInfo.camera.setParameters(parameters);
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        if (!this.checkSamsungHighFPS(cameraCacheInfo)) {
            return false;
        }
        return true;
    }

    public int[] getCaptureInfo(int n) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
        if (parameters == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        int[] arrn = null;
        try {
            arrn = new int[5];
            arrn[0] = parameters.getPreviewSize().width;
            arrn[1] = parameters.getPreviewSize().height;
            arrn[2] = this.translateImageFormat(parameters.getPreviewFormat(), CONVERT_FORMAT_TO_PL);
            arrn[3] = parameters.getPreviewFrameRate();
            arrn[4] = cameraCacheInfo.surface != null || cameraCacheInfo.surfaceTexture != null ? 1 : 0;
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        return arrn;
    }

    public boolean start(int n) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        if (!this.setupPreviewBuffer(cameraCacheInfo)) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        try {
            cameraCacheInfo.camera.startPreview();
            cameraCacheInfo.status = 268443651;
            return true;
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    public boolean stop(int n) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        try {
            cameraCacheInfo.camera.stopPreview();
            cameraCacheInfo.status = 268443650;
            return true;
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    public boolean setBatchParameters(int n, String string) {
        if (string == null) {
            return false;
        }
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
        if (parameters == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        if (!this.setCustomCameraParams(parameters, string)) {
            return false;
        }
        cameraCacheInfo.camera.setParameters(parameters);
        return true;
    }

    boolean setUntypedCameraParameter(int n, String string, String string2) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
        if (parameters == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        try {
            parameters.set(string, string2);
            cameraCacheInfo.camera.setParameters(parameters);
            return true;
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    String getUntypedCameraParameter(int n, String string) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
        if (parameters == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        String string2 = parameters.get(string);
        if (string2 == null) {
            SystemTools.setSystemErrorCode(6);
        }
        return string2;
    }

    String getFlattenedParameters(int n) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return "";
        }
        Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
        if (parameters == null) {
            SystemTools.setSystemErrorCode(6);
            return "";
        }
        return parameters.flatten();
    }

    boolean setTypedCameraParameter(int n, int n2, Object object) {
        CameraCacheInfo cameraCacheInfo;
        Camera.Parameters parameters;
        boolean bl;
        block74 : {
            cameraCacheInfo = this.getCameraCacheInfo(n);
            if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
                SystemTools.setSystemErrorCode(4);
                return false;
            }
            parameters = this.getCameraParameters(cameraCacheInfo.camera);
            if (parameters == null) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
            bl = false;
            try {
                block3 : switch (n2) {
                    case 536870976: {
                        String string = Integer.toString(((Number)object).intValue());
                        String string2 = parameters.get("iso-values");
                        if (string2 != null) {
                            String[] arrstring = string2.split(",");
                            for (int i = 0; i < arrstring.length; ++i) {
                                if (!arrstring[i].toLowerCase().contains(string.toLowerCase())) continue;
                                string = arrstring[i];
                                break;
                            }
                        }
                        parameters.set("iso", string);
                        break;
                    }
                    case 541065216: {
                        int n3 = ((Number)object).intValue();
                        if (SystemTools.checkMinimumApiLevel(14)) {
                            parameters.setRecordingHint(n3 != 0);
                            break;
                        }
                        parameters.set("recording-hint", n3 != 0 ? "true" : "false");
                        break;
                    }
                    case 536870913: {
                        int n4 = ((Number)object).intValue();
                        switch (n4) {
                            case 805306370: {
                                if (parameters.getSupportedFlashModes().contains("torch")) {
                                    parameters.setFlashMode("torch");
                                    break block3;
                                }
                                parameters.setFlashMode("on");
                                break block3;
                            }
                            case 805306369: {
                                parameters.setFlashMode("off");
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
                        cameraCacheInfo.camera.cancelAutoFocus();
                        int n5 = ((Number)object).intValue();
                        switch (n5) {
                            case 805306384: {
                                if (parameters.getSupportedFocusModes().contains("normal")) {
                                    parameters.setFocusMode("normal");
                                    break block3;
                                }
                                parameters.setFocusMode("auto");
                                bl = true;
                                break block3;
                            }
                            case 805306400: {
                                parameters.setFocusMode("auto");
                                bl = true;
                                break block3;
                            }
                            case 805306432: {
                                if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                                    parameters.setFocusMode("continuous-video");
                                    break block3;
                                }
                                SystemTools.setSystemErrorCode(6);
                                return false;
                            }
                            case 805306496: {
                                parameters.setFocusMode("macro");
                                break block3;
                            }
                            case 805306624: {
                                parameters.setFocusMode("infinity");
                                break block3;
                            }
                            case 805306880: {
                                parameters.setFocusMode("fixed");
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
                            float[] arrf = (float[])object;
                            if (arrf.length != 5) {
                                SystemTools.setSystemErrorCode(2);
                                return false;
                            }
                            if (arrf[0] < 0.0f || arrf[0] > 1.0f || arrf[1] < 0.0f || arrf[1] > 1.0f || arrf[2] < 0.0f || arrf[2] > 1.0f || arrf[3] < 0.0f || arrf[3] > 1.0f || arrf[4] < 0.0f || arrf[4] > 1.0f) {
                                SystemTools.setSystemErrorCode(2);
                                return false;
                            }
                            Rect rect = new Rect((int)((double)arrf[0] * 2000.0) - 1000, (int)((double)arrf[1] * 2000.0) - 1000, (int)((double)arrf[2] * 2000.0) - 1000, (int)((double)arrf[3] * 2000.0) - 1000);
                            ArrayList<Camera.Area> arrayList = new ArrayList<Camera.Area>();
                            Camera.Area area = new Camera.Area(rect, (int)((double)arrf[4] * 1000.0));
                            arrayList.add(area);
                            if (parameters.getMaxNumFocusAreas() > 0) {
                                parameters.setFocusAreas(arrayList);
                            }
                            break;
                        }
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536870944: {
                        int n6 = ((Number)object).intValue();
                        switch (n6) {
                            case 805310464: {
                                if (parameters.isAutoExposureLockSupported()) {
                                    parameters.setAutoExposureLock(true);
                                    break block3;
                                }
                                break block74;
                            }
                            case 805322752: {
                                if (parameters.isAutoExposureLockSupported()) {
                                    parameters.setAutoExposureLock(false);
                                    break block3;
                                }
                                break block74;
                            }
                            default: {
                                SystemTools.setSystemErrorCode(3);
                                return false;
                            }
                        }
                    }
                    case 536871936: {
                        if (SystemTools.checkMinimumApiLevel(8)) {
                            float f = ((Number)object).floatValue();
                            float f2 = parameters.getExposureCompensationStep();
                            if (f2 == 0.0f) {
                                SystemTools.setSystemErrorCode(6);
                                return false;
                            }
                            parameters.setExposureCompensation(Math.round(f / f2));
                            break;
                        }
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536872960: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536875008: {
                        int n7 = ((Number)object).intValue();
                        switch (n7) {
                            case 806354944: {
                                if (parameters.isAutoWhiteBalanceLockSupported()) {
                                    parameters.setAutoWhiteBalanceLock(true);
                                    break block3;
                                }
                                break block74;
                            }
                            case 809500672: {
                                if (parameters.isAutoWhiteBalanceLockSupported()) {
                                    parameters.setAutoWhiteBalanceLock(false);
                                    break block3;
                                }
                                break block74;
                            }
                            default: {
                                SystemTools.setSystemErrorCode(3);
                                SystemTools.logSystemError("Cannot set unknown white balance mode (" + n7 + ")");
                                return false;
                            }
                        }
                    }
                    case 536879104: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536887296: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536903680: {
                        if (SystemTools.checkMinimumApiLevel(8) && parameters.isZoomSupported()) {
                            int n8 = ((Number)object).intValue();
                            parameters.setZoom(n8);
                            break;
                        }
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
                    case 537919488: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 538968064: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 553648128: {
                        boolean bl2 = (Boolean)object;
                        if (bl2) {
                            parameters.setVideoStabilization(true);
                            break;
                        }
                        parameters.setVideoStabilization(false);
                        break;
                    }
                    default: {
                        return false;
                    }
                }
            }
            catch (Exception exception) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
        try {
            cameraCacheInfo.camera.setParameters(parameters);
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        if (bl) {
            try {
                switch (n2) {
                    case 536870914: {
                        cameraCacheInfo.isAutoFocusing = true;
                        cameraCacheInfo.camera.autoFocus(new Camera.AutoFocusCallback(){

                            public void onAutoFocus(boolean bl, Camera camera) {
                                int n;
                                CameraCacheInfo cameraCacheInfo;
                                Object v = Camera1_Preview.this.cameraCacheInfoIndexCache.get((Object)camera);
                                if (v != null && (cameraCacheInfo = Camera1_Preview.this.getCameraCacheInfo(n = ((Integer)v).intValue())) != null) {
                                    cameraCacheInfo.isAutoFocusing = false;
                                }
                            }
                        });
                        break;
                    }
                }
            }
            catch (Exception exception) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
        return true;
    }

    Object getTypedCameraParameter(int n, int n2) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.camera == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Camera.Parameters parameters = this.getCameraParameters(cameraCacheInfo.camera);
        if (parameters == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        try {
            switch (n2) {
                case 536870913: {
                    String string = parameters.getFlashMode();
                    if (string.equals("torch") || string.equals("on")) {
                        return 805306370;
                    }
                    if (string.equals("off")) {
                        return 805306369;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870914: {
                    String string = parameters.getFocusMode();
                    if (string.equals("auto")) {
                        return cameraCacheInfo.isAutoFocusing ? 805306400 : 805306384;
                    }
                    if (string.equals("continuous-video")) {
                        return 805306432;
                    }
                    if (string.equals("infinity")) {
                        return 805306624;
                    }
                    if (string.equals("macro")) {
                        return 805306496;
                    }
                    if (string.equals("fixed")) {
                        return 805306880;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870916: {
                    if (SystemTools.checkMinimumApiLevel(8)) {
                        return Float.valueOf(parameters.getFocalLength());
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870920: {
                    if (SystemTools.checkMinimumApiLevel(9)) {
                        float[] arrf = new float[3];
                        parameters.getFocusDistances(arrf);
                        float[] arrf2 = new float[]{arrf[0], arrf[2]};
                        return arrf2;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870928: {
                    List list;
                    if (SystemTools.checkMinimumApiLevel(14) && parameters.getMaxNumFocusAreas() > 0 && (list = parameters.getFocusAreas()).size() > 0) {
                        Camera.Area area = (Camera.Area)list.get(0);
                        float[] arrf = new float[]{area.rect.left, area.rect.top, area.rect.right, area.rect.bottom, area.weight};
                        return arrf;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870944: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536871936: {
                    if (SystemTools.checkMinimumApiLevel(8)) {
                        return Float.valueOf(parameters.getExposureCompensationStep() * (float)parameters.getExposureCompensation());
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536872960: {
                    if (SystemTools.checkMinimumApiLevel(8)) {
                        float[] arrf = new float[]{parameters.getExposureCompensationStep() * (float)parameters.getMinExposureCompensation(), parameters.getExposureCompensationStep() * (float)parameters.getMaxExposureCompensation()};
                        return arrf;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536875008: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536879104: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536887296: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536903680: {
                    if (SystemTools.checkMinimumApiLevel(8) && parameters.isZoomSupported()) {
                        return parameters.getZoom();
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536936448: {
                    if (SystemTools.checkMinimumApiLevel(8) && parameters.isZoomSupported()) {
                        int[] arrn = new int[]{0, parameters.getMaxZoom()};
                        return arrn;
                    }
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
                case 537919488: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 538968064: {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 553648128: {
                    if (parameters.getVideoStabilization()) {
                        return true;
                    }
                    return false;
                }
            }
            return null;
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
    }

    int getStatus(int n) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return 268443648;
        }
        return cameraCacheInfo.status;
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

