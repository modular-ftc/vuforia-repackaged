/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.graphics.Rect
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CameraManager
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.CaptureResult$Key
 *  android.hardware.camera2.TotalCaptureResult
 *  android.hardware.camera2.params.MeteringRectangle
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.media.Image
 *  android.media.Image$Plane
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Trace
 *  android.util.Pair
 *  android.util.Range
 *  android.util.Size
 *  android.view.Surface
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.vuforia.ar.pl;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import android.view.Surface;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

@TargetApi(value = 21)
public class Camera2_Preview {
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
    private static final int AR_CAMERA_IMAGE_FORMAT_YUV420P = 268439828;
    private static final int[] CAMERA_IMAGE_FORMAT_CONVERSIONTABLE = new int[]{35, 268439817};
    private static final int NUM_CAPTURE_BUFFERS = 2;
    private static final int NUM_MAX_CAMERAOPEN_RETRY = 10;
    private static final int TIME_CAMERAOPEN_RETRY_DELAY_MS = 250;
    private static final String MODULENAME = "Camera2_Preview";
    private static final int MAX_LOWEST_FPS_ALLOWED = 150;
    private static final int MAX_HIGHEST_FPS_ALLOWED = 300;
    private static final Range<Integer> EMPTY_RANGE = new Range<>(0, 0);
    private static final String FOCUS_MODE_NORMAL = "normal";
    private static boolean CONVERT_FORMAT_TO_PL = true;
    private static boolean CONVERT_FORMAT_TO_ANDROID = false;
    private Vector<CameraCacheInfo> mCameraCacheInfos = null;
    private Vector<CameraCacheInfo> mCameraCacheInfosInProgress = null;
    private HashMap<ImageReader, Integer> mCameraCacheInfoIndexCache = null;
    private Context mContext;
    private CameraManager mCameraManager;
    private Semaphore mOpenCloseSemaphore = new Semaphore(1);
    private int mIsPermissionGranted;

    private boolean checkPermission() {
        if (this.mIsPermissionGranted == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        try {
            Activity activity = SystemTools.getActivityFromNative();
            PackageManager pm = activity.getPackageManager();
            this.mIsPermissionGranted = pm.checkPermission(Manifest.permission.CAMERA, activity.getPackageName());
            if (this.mIsPermissionGranted == PackageManager.PERMISSION_GRANTED) {
                return true;
            }
        } catch (Exception activity) {
            // empty catch block
        }
        return false;
    }

    private int getCameraDeviceIndex(int camIndex, int type, int direction) {
        if (type != 268447760) {
            // empty if block
        }
        int camInfoDirection = -1;
        switch (direction) {
            case 268443664: {
                break;
            }
            case 268443665: {
                camInfoDirection = 1;
                break;
            }
            case 268443666: {
                camInfoDirection = 0;
                break;
            }
            default: {
                SystemTools.setSystemErrorCode(2);
                return -1;
            }
        }
        try {
            String[] camIds = this.mCameraManager.getCameraIdList();
            for (int i = 0; i < camIds.length; ++i) {
                CameraCharacteristics cc = this.mCameraManager.getCameraCharacteristics(camIds[i]);
                if (camInfoDirection >= 0 && camInfoDirection != cc.get(CameraCharacteristics.LENS_FACING) || camIndex >= 0 && camIndex != i)
                    continue;
                return i;
            }
        } catch (CameraAccessException camIds) {
            // empty catch block
        }
        SystemTools.setSystemErrorCode(6);
        return -1;
    }

    private CameraCacheInfo getCameraCacheInfo(int cameraCacheInfoIndex) {
        if (cameraCacheInfoIndex < 0 || cameraCacheInfoIndex >= this.mCameraCacheInfos.size()) {
            return null;
        }
        return this.mCameraCacheInfos.get(cameraCacheInfoIndex);
    }

    private boolean setCustomCameraParams(CameraCacheInfo cci, String customData) {
        if (cci == null || cci.builder == null || cci.characteristics == null) {
            return false;
        }
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(customData);
        } catch (JSONException e) {
            return false;
        }
        Iterator elements = jsonObj.keys();
        while (elements.hasNext()) {
            Object value;
            String key = (String) elements.next();
            try {
                value = jsonObj.get(key);
            } catch (JSONException e) {
                return false;
            }
            Class clazz = value.getClass();
            if (clazz == String.class || clazz == Integer.class) {
                if (this.mapStringToKey(key, cci.characteristics, value) != null) {
                    cci.builder.set(this.mapStringToKey(key, cci.characteristics, value), value);
                    continue;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    private <T> CaptureRequest.Key<T> mapStringToKey(String keyString, CameraCharacteristics cc, T value) {
        List<CaptureRequest.Key<?>> avilableKeys = cc.getAvailableCaptureRequestKeys();
        for (CaptureRequest.Key key : avilableKeys) {
            if (!key.getName().equals(keyString)) continue;
            return key;
        }
        return null;
    }

    private boolean setCameraCaptureParams(CameraCacheInfo cci, int[] captureInfo, int[] overrideCaptureInfo) {
        Size s;
        if (captureInfo != null || overrideCaptureInfo != null) {
            cci.overrideWidth = overrideCaptureInfo != null ? overrideCaptureInfo[0] : captureInfo[0];
            cci.overrideHeight = overrideCaptureInfo != null ? overrideCaptureInfo[1] : captureInfo[1];
            cci.overrideFormatAndroid = this.translateImageFormat(overrideCaptureInfo != null ? overrideCaptureInfo[2] : captureInfo[2], CONVERT_FORMAT_TO_ANDROID);
        }
        if (captureInfo == null) {
            return true;
        }
        if (cci == null || cci.builder == null || cci.characteristics == null) {
            DebugLog.LOGE("Camera2_Preview", "CamCacheInfo not properly initialized in setCaptureParams");
            return false;
        }
        cci.requestWidth = captureInfo[0];
        cci.requestHeight = captureInfo[1];
        cci.requestFormatAndroid = this.translateImageFormat(captureInfo[2], CONVERT_FORMAT_TO_ANDROID);
        cci.requestFramerate = captureInfo[3];
        StreamConfigurationMap scm = cci.characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        Size[] sizes = scm.getOutputSizes(cci.requestFormatAndroid);
        if (sizes == null) {
            DebugLog.LOGD("Camera2_Preview", String.format("setCameraCaptureParams: format not supported. : %d", captureInfo[2]));
            return false;
        }
        boolean foundSize = false;
        Size[] arr$ = sizes;
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$ && !(foundSize = (s = arr$[i$]).equals(new Size(cci.requestWidth, cci.requestHeight))); ++i$) {
        }
        if (!foundSize) {
            DebugLog.LOGD("Camera2_Preview", String.format("setCameraCaptureParams: size not supported. : %d, %d", cci.requestWidth, cci.requestHeight));
            return false;
        }
        Range<Integer>[] fpsRanges = cci.characteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        Range<Integer> bestRange = null;
        int bestRangeSize = Integer.MAX_VALUE;
        for (Range<Integer> range : fpsRanges) {
            int size;
            if (range.getLower() >= 150 || range.getUpper() >= 300) {
                DebugLog.LOGW("Camera2_Preview", String.format("Detected odd fps values from Camera2 API: low=%d, high=%d.  Using first fps range as default instead of searching for perfect fit.", range.getLower(), range.getUpper()));
                bestRange = fpsRanges[0];
                break;
            }
            if (!range.contains(cci.requestFramerate) || (size = range.getUpper() - range.getLower()) >= bestRangeSize)
                continue;
            bestRange = range;
            bestRangeSize = size;
        }
        if (bestRange == null) {
            DebugLog.LOGD("Camera2_Preview", "setCameraCaptureParams: fps range not supported.");
            return false;
        }
        cci.builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, bestRange);
        return true;
    }

    private boolean setupPreviewBuffer(CameraCacheInfo cci) {
        cci.reader = ImageReader.newInstance(cci.requestWidth, cci.requestHeight, cci.requestFormatAndroid, 2);
        cci.imageSemaphore = new Semaphore(2);
        cci.images = new Image[2];
        cci.bufferWidth = cci.requestWidth == cci.overrideWidth ? cci.reader.getWidth() : cci.overrideWidth;
        cci.bufferHeight = cci.requestHeight == cci.overrideHeight ? cci.reader.getHeight() : cci.overrideHeight;
        int bufferFormatAndroid = cci.requestFormatAndroid == cci.overrideFormatAndroid ? cci.reader.getImageFormat() : cci.overrideFormatAndroid;
        cci.bufferFormatPL = this.translateImageFormat(bufferFormatAndroid, CONVERT_FORMAT_TO_PL);
        cci.reader.setOnImageAvailableListener(new OnCameraDataAvailable(), cci.handler);
        if (cci.surfaces == null) {
            cci.surfaces = new LinkedList<Surface>();
        }
        cci.surfaces.clear();
        cci.surfaces.add(cci.reader.getSurface());
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
        int index = (int) (Math.log(paramType & ~baseValue) / Math.log(2.0));
        if (value) {
            int[] arrn = cci.caps;
            int n = capsIndex;
            arrn[n] = arrn[n] | 1 << index;
        } else {
            int[] arrn = cci.caps;
            int n = capsIndex;
            arrn[n] = arrn[n] & ~(1 << index);
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

    private List<Integer> getSupportedPreviewFrameRates(CameraCharacteristics cc) {
        Range[] frameRateRanges = cc.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        int lowest = Integer.MAX_VALUE;
        int highest = Integer.MIN_VALUE;
        for (Range r : frameRateRanges) {
            lowest = Math.min(lowest, (Integer) r.getLower());
            highest = Math.max(highest, (Integer) r.getUpper());
        }
        LinkedList<Integer> supportedFrameRates = new LinkedList<Integer>();
        if (lowest < 0 || lowest >= 150 || highest < 0 || highest >= 300) {
            DebugLog.LOGW("Camera2_Preview", String.format("Detected odd fps values from Camera2 API: low=%d, high=%d.  Using saner defaults instead.", lowest, highest));
            supportedFrameRates.add(30);
        } else {
            block1:
            for (int i = lowest; i <= highest; ++i) {
                for (Range r : frameRateRanges) {
                    if (!r.contains(i)) continue;
                    supportedFrameRates.add(i);
                    continue block1;
                }
            }
        }
        return supportedFrameRates;
    }

    private boolean checkCameraManager() {
        if (this.mCameraManager != null) {
            return true;
        }
        Activity context = SystemTools.getActivityFromNative();
        if (context == null) {
            return false;
        }
        this.mCameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        if (this.mCameraManager == null) {
            return false;
        }
        return true;
    }

    private native void newFrameAvailable(long var1, int var3, int var4, int var5, int[] var6, int var7, ByteBuffer var8, long var9);

    private native long getBufferAddress(ByteBuffer var1);

    public boolean init() {
        this.mCameraCacheInfos = new Vector<>();
        this.mCameraCacheInfosInProgress = new Vector<>();
        this.mCameraCacheInfoIndexCache = new HashMap<>();
        return true;
    }

    public int getNumberOfCameras() {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (!this.checkCameraManager()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (SystemTools.checkMinimumApiLevel(21)) {
            try {
                return this.mCameraManager.getCameraIdList().length;
            } catch (Exception exception) {
                // empty catch block
            }
        }
        SystemTools.setSystemErrorCode(6);
        return -1;
    }

    public int getOrientation(int cameraID) {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (!this.checkCameraManager()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (SystemTools.checkMinimumApiLevel(21)) {
            try {
                String[] cameraIds = this.mCameraManager.getCameraIdList();
                if (cameraID < cameraIds.length) {
                    CameraCharacteristics cc = this.mCameraManager.getCameraCharacteristics(cameraIds[cameraID]);
                    return cc.get(CameraCharacteristics.SENSOR_ORIENTATION);
                }
            } catch (Exception cameraIds) {
                // empty catch block
            }
        }
        SystemTools.setSystemErrorCode(6);
        return -1;
    }

    public int getDirection(int cameraID) {
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (!this.checkCameraManager()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (SystemTools.checkMinimumApiLevel(21)) {
            try {
                String[] cameraIds = this.mCameraManager.getCameraIdList();
                if (cameraID < cameraIds.length) {
                    CameraCharacteristics cc = this.mCameraManager.getCameraCharacteristics(cameraIds[cameraID]);
                    Integer lensFacing = cc.get(CameraCharacteristics.LENS_FACING);
                    switch (lensFacing) {
                        case 1: {
                            return 268443665;
                        }
                        case 0: {
                            return 268443666;
                        }
                    }
                    return 268443664;
                }
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
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
        DebugLog.LOGI("Camera2_Preview", String.format("open called with handle: %x, %d, type: %d, direction: %d", deviceHandle, camIndex, type, direction));
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (!this.checkCameraManager()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        int cameraDeviceIndex = this.getCameraDeviceIndex(camIndex, type, direction);
        if (cameraDeviceIndex < 0) {
            return -1;
        }
        DebugLog.LOGD("Camera2_Preview", "Camera device index" + cameraDeviceIndex);
        int cameraCacheInfoIndex = -1;
        CameraCacheInfo cci = null;
        int cameraCacheInfoSize = this.mCameraCacheInfos.size();
        for (int i = 0; i < cameraCacheInfoSize; ++i) {
            cci = this.mCameraCacheInfos.get(i);
            if (cci.deviceID != cameraDeviceIndex) continue;
            cameraCacheInfoIndex = i;
            break;
        }
        if (cameraCacheInfoIndex < 0) {
            try {
                cci = new CameraCacheInfo();
                cci.deviceID = cameraDeviceIndex;
                cci.deviceHandle = deviceHandle;
                cci.deviceIDString = this.mCameraManager.getCameraIdList()[cci.deviceID];
                cci.characteristics = this.mCameraManager.getCameraCharacteristics(cci.deviceIDString);
                cci.device = null;
                cci.session = null;
                cci.builder = null;
                cci.surfaces = null;
                cci.reader = null;
                cci.images = null;
                cci.imageSemaphore = null;
                cci.thread = new HandlerThread(cci.deviceIDString + "_camera_thread");
                cci.thread.start();
                cci.handler = new Handler(cci.thread.getLooper());
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
            } catch (CameraAccessException cae) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
        }
        boolean resultCameraOpened = false;
        int cameraOpenRetryCount = 10;
        do {
            try {
                this.mOpenCloseSemaphore.acquire();
                this.mCameraCacheInfosInProgress.add(cci);
                this.mCameraManager.openCamera(cci.deviceIDString, new CameraDevice.StateCallback() {

                    /*
                     * WARNING - Removed try catching itself - possible behaviour change.
                     */
                    public void onOpened(CameraDevice camera) {
                        CameraCacheInfo _cci = null;
                        try {
                            for (CameraCacheInfo info : Camera2_Preview.this.mCameraCacheInfosInProgress) {
                                if (!info.deviceIDString.equals(camera.getId())) continue;
                                _cci = info;
                                _cci.device = camera;
                                _cci.builder = camera.createCaptureRequest(1);
                            }
                        } catch (CameraAccessException cae) {
                            _cci.builder = null;
                            _cci.device = null;
                        } finally {
                            Camera2_Preview.this.mOpenCloseSemaphore.release();
                        }
                    }

                    public void onError(CameraDevice camera, int error) {
                        camera.close();
                        Camera2_Preview.this.mOpenCloseSemaphore.release();
                    }

                    public void onDisconnected(CameraDevice camera) {
                        camera.close();
                        Camera2_Preview.this.mOpenCloseSemaphore.release();
                    }
                }, cci.handler);
                this.mOpenCloseSemaphore.acquire();
                this.mCameraCacheInfosInProgress.remove(cci);
                this.mOpenCloseSemaphore.release();
                resultCameraOpened = cci.device != null && cci.builder != null;
            } catch (Exception exception) {
                // empty catch block
            }
            if (resultCameraOpened) continue;
            try {
                if (cameraOpenRetryCount <= 0) continue;
                Camera2_Preview camera2_Preview = this;
                synchronized (camera2_Preview) {
                    this.wait(250);
                }
            } catch (Exception exception) {
                // empty catch block
            }
        } while (!resultCameraOpened && cameraOpenRetryCount-- > 0);
        if (cci.device == null || cci.builder == null) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        boolean setCaptureInfo = captureInfo != null && captureInfo.length > 0 || overrideCaptureInfo != null && overrideCaptureInfo.length > 0;
        boolean bl = setCustomData = customData != null && customData.length() > 0;
        if (setCaptureInfo || setCustomData) {
            boolean result;
            if (setCaptureInfo) {
                if (captureInfo != null && captureInfo.length != 5) {
                    SystemTools.setSystemErrorCode(2);
                    return -1;
                }
                result = this.setCameraCaptureParams(cci, captureInfo, overrideCaptureInfo);
                if (!result) {
                    SystemTools.setSystemErrorCode(6);
                    return -1;
                }
            }
            if (setCustomData && !(result = this.setCustomCameraParams(cci, customData))) {
                SystemTools.setSystemErrorCode(2);
                return -1;
            }
        }
        cci.status = 268443650;
        if (cameraCacheInfoIndex < 0) {
            this.mCameraCacheInfos.add(cci);
            cameraCacheInfoIndex = this.mCameraCacheInfos.size() - 1;
        }
        return cameraCacheInfoIndex;
    }

    public boolean close(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        this.mCameraCacheInfoIndexCache.remove(cci.reader);
        boolean result = false;
        try {
            cci.session.close();
            cci.device.close();
            cci.reader.close();
            result = true;
        } catch (Exception exception) {
            // empty catch block
        }
        cci.session = null;
        cci.reader = null;
        cci.images = null;
        cci.status = 268443649;
        System.gc();
        return result;
    }

    public int[] getCameraCapabilities(int cameraCacheInfoIndex) {
        StreamConfigurationMap scm;
        Boolean isFlashTorchSupported;
        boolean isZoomSupported;
        Integer numSupportedFocusRegions;
        if (!this.checkCameraManager()) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        if (cci.caps != null) {
            return cci.caps;
        }
        try {
            String deviceId = this.mCameraManager.getCameraIdList()[cci.deviceID];
            scm = this.mCameraManager.getCameraCharacteristics(deviceId).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        } catch (CameraAccessException e) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        Size[] supportedImageSizes = scm.getOutputSizes(35);
        List<Integer> supportedFrameRates = this.getSupportedPreviewFrameRates(cci.characteristics);
        int[] supportedFocusModes = cci.characteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        Arrays.sort(supportedFocusModes);
        LinkedList<Integer> supportedImageFormats = new LinkedList<Integer>();
        supportedImageFormats.add(35);
        int numSupportedImageSizes = supportedImageSizes != null ? supportedImageSizes.length : 0;
        int numSupportedFrameRates = supportedFrameRates != null ? supportedFrameRates.size() : 0;
        int numSupportedImageFormats = supportedImageFormats != null ? supportedImageFormats.size() : 0;
        float[] focalLengths = cci.characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        boolean bl = isZoomSupported = focalLengths != null && focalLengths.length > 0;
        if (isZoomSupported) {
            for (float f : focalLengths) {
                DebugLog.LOGD("Camera2_Preview", "Supported Focal Length is " + f + "mm");
            }
        }
        if ((isFlashTorchSupported = cci.characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)) == null) {
            isFlashTorchSupported = false;
        }
        boolean isFocusRegionSupported = (numSupportedFocusRegions = cci.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)) != null && numSupportedFocusRegions > 0;
        Range aeCompensationRange = cci.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        boolean isCompensationSupported = aeCompensationRange != null && !EMPTY_RANGE.equals(aeCompensationRange);
        int[] videoStabilizationModes = cci.characteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        boolean isVideoStabilizationSupported = videoStabilizationModes != null && videoStabilizationModes.length > 0;
        int capsArraySize = 6 + numSupportedImageSizes * 2 + numSupportedFrameRates + numSupportedImageFormats;
        cci.caps = new int[capsArraySize];
        int capsIndex = 0;
        cci.caps[capsIndex] = 536870912;
        this.setCameraCapsBit(cci, capsIndex, 536870913, isFlashTorchSupported);
        this.setCameraCapsBit(cci, capsIndex, 536870914, true);
        this.setCameraCapsBit(cci, capsIndex, 536870916, isZoomSupported);
        this.setCameraCapsBit(cci, capsIndex, 536870928, isFocusRegionSupported);
        this.setCameraCapsBit(cci, capsIndex, 536871168, isCompensationSupported);
        this.setCameraCapsBit(cci, capsIndex, 536871424, isCompensationSupported);
        this.setCameraCapsBit(cci, capsIndex, 536879104, isZoomSupported);
        this.setCameraCapsBit(cci, capsIndex, 536887296, isZoomSupported);
        this.setCameraCapsBit(cci, capsIndex, 545259520, isVideoStabilizationSupported);
        capsIndex = 1;
        cci.caps[capsIndex] = 536870912;
        this.setCameraCapsBit(cci, capsIndex, 536870913, isFlashTorchSupported);
        this.setCameraCapsBit(cci, capsIndex, 536870914, true);
        this.setCameraCapsBit(cci, capsIndex, 536870928, isFocusRegionSupported);
        this.setCameraCapsBit(cci, capsIndex, 536871168, isCompensationSupported);
        this.setCameraCapsBit(cci, capsIndex, 536879104, isZoomSupported);
        this.setCameraCapsBit(cci, capsIndex, 545259520, isVideoStabilizationSupported);
        capsIndex = 2;
        cci.caps[capsIndex] = 805306368;
        if (isFlashTorchSupported.booleanValue()) {
            this.setCameraCapsBit(cci, capsIndex, 805306369, true);
            this.setCameraCapsBit(cci, capsIndex, 805306370, true);
        }
        if (supportedFocusModes != null) {
            this.setCameraCapsBit(cci, capsIndex, 805306384, Arrays.binarySearch(supportedFocusModes, 1) != -1);
            this.setCameraCapsBit(cci, capsIndex, 805306400, Arrays.binarySearch(supportedFocusModes, 1) != -1);
            this.setCameraCapsBit(cci, capsIndex, 805306432, Arrays.binarySearch(supportedFocusModes, 3) != -1);
            this.setCameraCapsBit(cci, capsIndex, 805306496, Arrays.binarySearch(supportedFocusModes, 2) != -1);
            this.setCameraCapsBit(cci, capsIndex, 805306624, Arrays.binarySearch(supportedFocusModes, 0) != -1 && CaptureRequest.LENS_FOCUS_DISTANCE != null);
            this.setCameraCapsBit(cci, capsIndex, 805306880, Arrays.binarySearch(supportedFocusModes, 0) != -1);
        }
        cci.caps[3] = numSupportedImageSizes;
        cci.caps[4] = numSupportedFrameRates;
        cci.caps[5] = numSupportedImageFormats;
        int indexOffset = 6;
        if (numSupportedImageSizes > 0) {
            for (Size size : supportedImageSizes) {
                cci.caps[indexOffset] = size.getWidth();
                cci.caps[indexOffset + 1] = size.getHeight();
                indexOffset += 2;
            }
        }
        if (numSupportedFrameRates > 0) {
            for (Integer framerate : supportedFrameRates) {
                cci.caps[indexOffset] = framerate;
                ++indexOffset;
            }
        }
        if (numSupportedImageFormats > 0) {
            for (Integer format : supportedImageFormats) {
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
        boolean result = this.setCameraCaptureParams(cci, captureInfo, overrideCaptureInfo);
        if (!result) {
            SystemTools.setSystemErrorCode(6);
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
        int[] captureInfo = null;
        try {
            captureInfo = new int[5];
            if (cci.reader != null) {
                captureInfo[0] = cci.reader.getWidth();
                captureInfo[1] = cci.reader.getHeight();
                captureInfo[2] = this.translateImageFormat(cci.reader.getImageFormat(), CONVERT_FORMAT_TO_PL);
            } else {
                captureInfo[0] = cci.requestWidth;
                captureInfo[1] = cci.requestHeight;
                captureInfo[2] = this.translateImageFormat(cci.requestFormatAndroid, CONVERT_FORMAT_TO_PL);
            }
            if (cci.builder != null) {
                Range fpsRange = cci.builder.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
                captureInfo[3] = (Integer) fpsRange.getUpper();
            } else {
                captureInfo[3] = cci.requestFramerate;
            }
            captureInfo[4] = 1;
        } catch (Exception e) {
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
            if (cci.session == null) {
                this.mOpenCloseSemaphore.acquire();
                cci.device.createCaptureSession(cci.surfaces, new CameraCaptureSession.StateCallback() {

                    public void onConfigured(CameraCaptureSession session) {
                        CameraCacheInfo _cci = null;
                        for (CameraCacheInfo info : Camera2_Preview.this.mCameraCacheInfos) {
                            if (!info.deviceIDString.equals(session.getDevice().getId())) continue;
                            _cci = info;
                            break;
                        }
                        _cci.session = session;
                        for (Surface s : _cci.surfaces) {
                            _cci.builder.addTarget(s);
                        }
                        Camera2_Preview.this.mOpenCloseSemaphore.release();
                    }

                    public void onConfigureFailed(CameraCaptureSession session) {
                        session.close();
                        Camera2_Preview.this.mOpenCloseSemaphore.release();
                    }
                }, cci.handler);
                this.mOpenCloseSemaphore.acquire();
                this.mOpenCloseSemaphore.release();
                if (cci.session == null) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            }
            cci.session.setRepeatingRequest(cci.builder.build(), new OnFrameCapturedCallback(cci), cci.handler);
            cci.status = 268443651;
            this.mCameraCacheInfoIndexCache.put(cci.reader, cameraCacheInfoIndex);
            return true;
        } catch (Exception e) {
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
            cci.session.abortCaptures();
            cci.status = 268443650;
            return true;
        } catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    public boolean setBatchParameters(int cameraCacheInfoIndex, String customData) {
        if (customData == null) {
            return false;
        }
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.builder == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        if (!this.setCustomCameraParams(cci, customData)) {
            return false;
        }
        return true;
    }

    boolean setUntypedCameraParameter(int cameraCacheInfoIndex, String name, Object value) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.builder == null || cci.characteristics == null || name == null || value == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        List captureRequestKeys = cci.characteristics.getAvailableCaptureRequestKeys();
        for (int i = 0; i < captureRequestKeys.size(); ++i) {
            CaptureRequest.Key key = (CaptureRequest.Key) captureRequestKeys.get(i);
            if (!key.getName().equals(name)) continue;
            Object result = cci.builder.get(key);
            if (!(result instanceof Integer || result instanceof Float || result instanceof Boolean || result instanceof Byte || result instanceof Long)) {
                return false;
            }
            if (result instanceof Byte && value instanceof Long) {
                value = ((Long) value).byteValue();
            }
            if (result instanceof Integer && value instanceof Long) {
                value = ((Long) value).intValue();
            }
            if (!result.getClass().equals(value.getClass())) {
                return false;
            }
            try {
                cci.builder.set(key, value);
                if (cci.session != null) {
                    cci.session.setRepeatingRequest(cci.builder.build(), new OnFrameCapturedCallback(cci), cci.handler);
                }
                return true;
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
        SystemTools.setSystemErrorCode(6);
        return false;
    }

    Object getUntypedCameraParameter(int cameraCacheInfoIndex, String name) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.builder == null || cci.characteristics == null || name == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Object result = null;
        List captureRequestKeys = cci.characteristics.getAvailableCaptureRequestKeys();
        for (int i = 0; i < captureRequestKeys.size(); ++i) {
            CaptureRequest.Key key = (CaptureRequest.Key) captureRequestKeys.get(i);
            if (!key.getName().equals(name)) continue;
            result = cci.builder.get(key);
            break;
        }
        List cameraCharacteristicsKeys = cci.characteristics.getKeys();
        for (int i = 0; i < cameraCharacteristicsKeys.size(); ++i) {
            CameraCharacteristics.Key key = (CameraCharacteristics.Key) cameraCharacteristicsKeys.get(i);
            if (!key.getName().equals(name)) continue;
            result = cci.characteristics.get(key);
            break;
        }
        if (result == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        if (result instanceof Long || result instanceof Float || result instanceof Boolean || result instanceof String) {
            return result;
        }
        if (result instanceof Integer) {
            return ((Integer) result).longValue();
        }
        if (result instanceof Byte) {
            return ((Byte) result).longValue();
        }
        if (result instanceof Range) {
            Comparable lower = ((Range) result).getLower();
            Comparable upper = ((Range) result).getUpper();
            if (lower instanceof Integer) {
                long[] range = new long[]{((Integer) lower).longValue(), ((Integer) upper).longValue()};
                return range;
            }
            if (lower instanceof Long) {
                long[] range = new long[]{(Long) lower, (Long) upper};
                return range;
            }
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        SystemTools.setSystemErrorCode(6);
        return null;
    }

    int getUntypedCameraParameterType(int cameraCacheInfoIndex, String name) {
        boolean AR_CAMERA_NAMED_PARAMTYPE_STRING = false;
        boolean AR_CAMERA_NAMED_PARAMTYPE_INT = true;
        int AR_CAMERA_NAMED_PARAMTYPE_FLOAT = 2;
        int AR_CAMERA_NAMED_PARAMTYPE_BOOLEAN = 3;
        int AR_CAMERA_NAMED_PARAMTYPE_INTRANGE = 4;
        int AR_CAMERA_NAMED_PARAMTYPE_UNKNOWN = -1;
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.builder == null || cci.characteristics == null || name == null) {
            SystemTools.setSystemErrorCode(4);
            return -1;
        }
        Object paramValue = null;
        boolean paramFound = false;
        List captureRequestKeys = cci.characteristics.getAvailableCaptureRequestKeys();
        for (int i = 0; i < captureRequestKeys.size(); ++i) {
            CaptureRequest.Key key = (CaptureRequest.Key) captureRequestKeys.get(i);
            if (!key.getName().equals(name)) continue;
            paramValue = cci.builder.get(key);
            paramFound = true;
            break;
        }
        List cameraCharacteristicsKeys = cci.characteristics.getKeys();
        for (int i = 0; i < cameraCharacteristicsKeys.size(); ++i) {
            CameraCharacteristics.Key key = (CameraCharacteristics.Key) cameraCharacteristicsKeys.get(i);
            if (!key.getName().equals(name)) continue;
            paramValue = cci.characteristics.get(key);
            paramFound = true;
            break;
        }
        if (!paramFound) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (paramValue == null) {
            return -1;
        }
        if (paramValue instanceof Integer) {
            return 1;
        }
        if (paramValue instanceof Byte) {
            return 1;
        }
        if (paramValue instanceof Long) {
            return 1;
        }
        if (paramValue instanceof Float) {
            return 2;
        }
        if (paramValue instanceof Boolean) {
            return 3;
        }
        if (paramValue instanceof String) {
            return 0;
        }
        if (paramValue instanceof Range) {
            Comparable lower = ((Range) paramValue).getLower();
            if (lower instanceof Integer) {
                return 4;
            }
            if (lower instanceof Long) {
                return 4;
            }
        }
        return -1;
    }

    int getNamedParameterCount(int cameraCacheInfoIndex) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.builder == null || cci.characteristics == null) {
            SystemTools.setSystemErrorCode(4);
            return -1;
        }
        List captureRequestKeys = cci.characteristics.getAvailableCaptureRequestKeys();
        List cameraCharacteristicsKeys = cci.characteristics.getKeys();
        return captureRequestKeys.size() + cameraCharacteristicsKeys.size();
    }

    String getNamedParameter(int cameraCacheInfoIndex, int index) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.builder == null || cci.characteristics == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        List captureRequestKeys = cci.characteristics.getAvailableCaptureRequestKeys();
        List cameraCharacteristicsKeys = cci.characteristics.getKeys();
        if (index < captureRequestKeys.size()) {
            CaptureRequest.Key key = (CaptureRequest.Key) captureRequestKeys.get(index);
            if (key == null) {
                return null;
            }
            return key.getName();
        }
        if (index - captureRequestKeys.size() < cameraCharacteristicsKeys.size()) {
            CameraCharacteristics.Key key = (CameraCharacteristics.Key) cameraCharacteristicsKeys.get(index - captureRequestKeys.size());
            if (key == null) {
                return null;
            }
            return key.getName();
        }
        SystemTools.setSystemErrorCode(6);
        return null;
    }

    boolean setTypedCameraParameter(int cameraCacheInfoIndex, int type, Object value) {
        boolean doPostSetAction;
        CameraCacheInfo cci;
        block90:
        {
            cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
            if (cci == null || cci.builder == null || cci.characteristics == null) {
                SystemTools.setSystemErrorCode(4);
                return false;
            }
            doPostSetAction = false;
            try {
                block3:
                switch (type) {
                    case 538968064: {
                        if (CaptureRequest.CONTROL_CAPTURE_INTENT == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        int val = ((Number) value).intValue();
                        cci.builder.set(CaptureRequest.CONTROL_CAPTURE_INTENT, val != 0 ? 3 : 1);
                        break;
                    }
                    case 536870913: {
                        if (CaptureRequest.FLASH_MODE == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        int torchMode = ((Number) value).intValue();
                        switch (torchMode) {
                            case 805306370: {
                                cci.builder.set(CaptureRequest.FLASH_MODE, 2);
                                break block3;
                            }
                            case 805306369: {
                                cci.builder.set(CaptureRequest.FLASH_MODE, 0);
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
                        if (CaptureRequest.CONTROL_AF_MODE == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        int[] supportedFocusModes = cci.characteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
                        Arrays.sort(supportedFocusModes);
                        int focusMode = ((Number) value).intValue();
                        switch (focusMode) {
                            case 805306384:
                            case 805306400: {
                                if (Arrays.binarySearch(supportedFocusModes, 1) == -1) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cci.builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
                                doPostSetAction = true;
                                break block3;
                            }
                            case 805306432: {
                                if (Arrays.binarySearch(supportedFocusModes, 3) == -1) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cci.builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
                                break block3;
                            }
                            case 805306496: {
                                if (Arrays.binarySearch(supportedFocusModes, 2) == -1) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cci.builder.set(CaptureRequest.CONTROL_AF_MODE, 2);
                                doPostSetAction = true;
                                break block3;
                            }
                            case 805306624: {
                                if (CaptureRequest.LENS_FOCUS_DISTANCE == null) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                if (Arrays.binarySearch(supportedFocusModes, 0) == -1) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cci.builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
                                cci.builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, 0.0f);
                                break block3;
                            }
                            case 805306880: {
                                if (Arrays.binarySearch(supportedFocusModes, 0) == -1) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cci.builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
                                break block3;
                            }
                        }
                        SystemTools.setSystemErrorCode(3);
                        return false;
                    }
                    case 536870916: {
                        if (CaptureRequest.LENS_FOCUS_DISTANCE == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        Float focusDist = ((Number) value).floatValue();
                        cci.builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, focusDist);
                        break;
                    }
                    case 536870920: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536870928: {
                        float[] focusRegion = (float[]) value;
                        if (focusRegion.length != 5) {
                            SystemTools.setSystemErrorCode(2);
                            return false;
                        }
                        if (focusRegion[0] < 0.0f || focusRegion[0] > 1.0f || focusRegion[1] < 0.0f || focusRegion[1] > 1.0f || focusRegion[2] < 0.0f || focusRegion[2] > 1.0f || focusRegion[3] < 0.0f || focusRegion[3] > 1.0f || focusRegion[4] < 0.0f || focusRegion[4] > 1.0f) {
                            SystemTools.setSystemErrorCode(2);
                            return false;
                        }
                        Integer numRegons = cci.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                        if (CaptureRequest.CONTROL_AF_REGIONS == null || numRegons == null || numRegons == 0) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        Rect activeArraySize = cci.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        if (activeArraySize == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        MeteringRectangle[] focusRects = new MeteringRectangle[]{new MeteringRectangle(new Rect(Math.min((int) (focusRegion[0] * (float) activeArraySize.width()), activeArraySize.width() - 1), Math.min((int) (focusRegion[1] * (float) activeArraySize.height()), activeArraySize.height() - 1), Math.min((int) (focusRegion[2] * (float) activeArraySize.width()), activeArraySize.width() - 1), Math.min((int) (focusRegion[3] * (float) activeArraySize.height()), activeArraySize.height() - 1)), (int) (focusRegion[4] * 1000.0f + 0.0f))};
                        cci.builder.set(CaptureRequest.CONTROL_AF_REGIONS, focusRects);
                        doPostSetAction = true;
                        break;
                    }
                    case 536870944: {
                        int exposureMode = ((Number) value).intValue();
                        int[] aeModes = cci.characteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
                        if (aeModes == null || CaptureRequest.CONTROL_AE_MODE == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        switch (exposureMode) {
                            case 805310464: {
                                int mode;
                                boolean foundOff = false;
                                int[] arr$ = aeModes;
                                int len$ = arr$.length;
                                for (int i$ = 0; i$ < len$ && !(foundOff = (mode = arr$[i$]) == 0); ++i$) {
                                }
                                if (!foundOff) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cci.builder.set(CaptureRequest.CONTROL_AE_MODE, 0);
                                break block3;
                            }
                            case 805314560:
                            case 805322752: {
                                int mode;
                                boolean foundOn = false;
                                int[] arr$ = aeModes;
                                int len$ = arr$.length;
                                for (int i$ = 0; i$ < len$ && !(foundOn = (mode = arr$[i$]) == 1); ++i$) {
                                }
                                if (!foundOn) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cci.builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                                break block3;
                            }
                        }
                        SystemTools.setSystemErrorCode(3);
                        return false;
                    }
                    case 536870976:
                    case 537919488: {
                        Range range = cci.characteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
                        if (range == null || CaptureRequest.SENSOR_SENSITIVITY == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        int _value = ((Number) value).intValue();
                        if (range.contains(_value)) {
                            cci.builder.set(CaptureRequest.SENSOR_SENSITIVITY, _value);
                        }
                        break;
                    }
                    case 536871040: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536871168: {
                        int expCompValue = ((Number) value).intValue();
                        Range expCompRange = cci.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
                        if (EMPTY_RANGE.equals(expCompRange) || CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        if (expCompRange.contains(expCompValue)) {
                            cci.builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, expCompValue);
                        }
                        break;
                    }
                    case 536871424: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536871936: {
                        int whiteBalanceMode = ((Number) value).intValue();
                        switch (whiteBalanceMode) {
                            case 805371904: {
                                if (CaptureRequest.CONTROL_AWB_LOCK == null) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cci.builder.set(CaptureRequest.CONTROL_AWB_LOCK, true);
                                break block3;
                            }
                            case 805437440:
                            case 805568512: {
                                if (CaptureRequest.CONTROL_AWB_LOCK != null && cci.builder.get(CaptureRequest.CONTROL_AWB_LOCK).booleanValue()) {
                                    cci.builder.set(CaptureRequest.CONTROL_AWB_LOCK, false);
                                }
                                if (CaptureRequest.CONTROL_AE_MODE != null) {
                                    cci.builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                                    break block3;
                                }
                                break block90;
                            }
                            default: {
                                SystemTools.setSystemErrorCode(3);
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
                        int zoomValue = ((Number) value).intValue();
                        float[] zoomValues = cci.characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                        if (zoomValues == null || CaptureRequest.LENS_FOCAL_LENGTH == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        boolean setIt = false;
                        for (float possibleZoomValue : zoomValues) {
                            if (Math.abs(possibleZoomValue - (float) zoomValue) >= 0.01f) continue;
                            setIt = true;
                            cci.builder.set(CaptureRequest.LENS_FOCAL_LENGTH, possibleZoomValue);
                            break;
                        }
                        if (!setIt) {
                            SystemTools.setSystemErrorCode(2);
                            return false;
                        }
                        break;
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
                        boolean videoStabilizationMode = (Boolean) value;
                        if (CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        cci.builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, videoStabilizationMode ? 1 : 0);
                        break;
                    }
                    default: {
                        return false;
                    }
                }
            } catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
        if (cci.session != null) {
            try {
                cci.session.setRepeatingRequest(cci.builder.build(), new OnFrameCapturedCallback(cci), cci.handler);
            } catch (CameraAccessException e) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
            if (doPostSetAction) {
                try {
                    switch (type) {
                        case 536870914: {
                            MeteringRectangle[] regions;
                            Integer maxRegions = cci.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                            if (maxRegions != null && CameraCharacteristics.CONTROL_MAX_REGIONS_AF != null && maxRegions > 0 && CaptureRequest.CONTROL_AF_REGIONS != null && (regions = cci.builder.get(CaptureRequest.CONTROL_AF_REGIONS)) != null && regions.length > 0) {
                                MeteringRectangle[] newRegions = new MeteringRectangle[regions.length];
                                int rectIdx = 0;
                                for (MeteringRectangle rect : regions) {
                                    newRegions[rectIdx++] = new MeteringRectangle(rect.getRect(), 0);
                                }
                                cci.builder.set(CaptureRequest.CONTROL_AF_REGIONS, newRegions);
                            }
                        }
                        case 536870928: {
                            AutofocusRunner runner = new AutofocusRunner(cci);
                            if (!runner.triggerAutofocus()) {
                                SystemTools.setSystemErrorCode(6);
                                return false;
                            } else {
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            }
        }
        return true;
    }

    Object getTypedCameraParameter(int cameraCacheInfoIndex, int type) {
        CameraCacheInfo cci = this.getCameraCacheInfo(cameraCacheInfoIndex);
        if (cci == null || cci.characteristics == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        CaptureResult captureResult = cci.lastResult;
        if (captureResult == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        try {
            switch (type) {
                case 536870913: {
                    Integer flashMode = captureResult.get(CaptureResult.FLASH_MODE);
                    if (flashMode == null || CaptureResult.FLASH_MODE == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    if (flashMode.equals(2)) {
                        return 805306370;
                    }
                    if (flashMode.equals(0)) {
                        return 805306369;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870914: {
                    Integer focusMode = captureResult.get(CaptureResult.CONTROL_AF_MODE);
                    if (focusMode == null || CaptureResult.CONTROL_AF_MODE == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    if (focusMode.equals(1)) {
                        return cci.isAutoFocusing ? 805306400 : 805306384;
                    }
                    if (focusMode.equals(3)) {
                        return 805306432;
                    }
                    if (focusMode.equals(0)) {
                        Float focusDist = captureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
                        if (focusDist == null || CaptureResult.LENS_FOCUS_DISTANCE == null || !focusDist.equals(0.0f)) {
                            return 805306880;
                        }
                        return 805306624;
                    }
                    if (focusMode.equals(2)) {
                        return 805306496;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870916: {
                    Float focalLen = captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
                    if (focalLen == null || CaptureResult.LENS_FOCAL_LENGTH == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    return focalLen;
                }
                case 536870920: {
                    Pair focusRange = captureResult.get(CaptureResult.LENS_FOCUS_RANGE);
                    if (focusRange != null && CaptureResult.LENS_FOCUS_RANGE != null) {
                        float[] focusValueRange = new float[]{((Float) focusRange.first).floatValue(), ((Float) focusRange.second).floatValue()};
                        return focusValueRange;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870928: {
                    Integer maxRegions = cci.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                    if (maxRegions != null && CameraCharacteristics.CONTROL_MAX_REGIONS_AF != null && maxRegions > 0 && CaptureResult.CONTROL_AF_REGIONS != null) {
                        MeteringRectangle[] regions = captureResult.get(CaptureResult.CONTROL_AF_REGIONS);
                        if (regions == null || regions.length == 0) {
                            return null;
                        }
                        Rect activeArraySize = cci.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        if (activeArraySize == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        Rect focusRegionRect = regions[0].getRect();
                        float[] vufFocusRegion = new float[]{focusRegionRect.left / (activeArraySize.width() - 1), focusRegionRect.top / (activeArraySize.height() - 1), focusRegionRect.right / (activeArraySize.width() - 1), focusRegionRect.bottom / (activeArraySize.height() - 1), (regions[0].getMeteringWeight() - 0) / 1000};
                        return vufFocusRegion;
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
                    Integer expComp = captureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
                    if (expComp != null && CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION != null) {
                        return expComp;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536871424: {
                    Range expCompRange = cci.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
                    if (expCompRange == null || CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    int[] exposureCompRange = new int[]{(Integer) expCompRange.getLower(), (Integer) expCompRange.getUpper()};
                    return exposureCompRange;
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
                    Float focalLen = captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
                    if (focalLen == null || CaptureResult.LENS_FOCAL_LENGTH == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    return focalLen;
                }
                case 536887296: {
                    SystemTools.setSystemErrorCode(6);
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
                    Integer vidStabMode = captureResult.get(CaptureResult.CONTROL_VIDEO_STABILIZATION_MODE);
                    if (vidStabMode == null || CaptureResult.CONTROL_VIDEO_STABILIZATION_MODE == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    if (vidStabMode.equals(1)) {
                        return true;
                    }
                    return false;
                }
            }
            return null;
        } catch (Exception e) {
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

    private class AutofocusRunner
            extends CameraCaptureSession.CaptureCallback {
        private CameraCacheInfo mCCI;
        private CaptureRequest mCancelRequest;
        private CaptureRequest mFocusRequest;

        public AutofocusRunner(CameraCacheInfo cci) {
            this.mCCI = cci;
            this.mCancelRequest = null;
            this.mFocusRequest = null;
        }

        public boolean triggerAutofocus() throws CameraAccessException {
            if (this.mCCI == null || this.mCCI.builder == null || this.mCCI.session == null) {
                return false;
            }
            Integer mode = this.mCCI.builder.get(CaptureRequest.CONTROL_AF_MODE);
            if (CaptureRequest.CONTROL_AF_MODE == null || mode == null) {
                return false;
            }
            if (mode != 1 && mode != 2) {
                return false;
            }
            this.mCCI.isAutoFocusing = true;
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            this.mCancelRequest = this.mCCI.builder.build();
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            this.mFocusRequest = this.mCCI.builder.build();
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            this.mCCI.session.capture(this.mCancelRequest, this, this.mCCI.handler);
            return true;
        }

        public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
            super.onCaptureCompleted(session, request, result);
            Integer afState = result.get(CaptureResult.CONTROL_AF_STATE);
            if (request.equals(this.mCancelRequest) && afState == 0) {
                try {
                    this.mCCI.session.capture(this.mFocusRequest, this, this.mCCI.handler);
                } catch (CameraAccessException cameraAccessException) {
                }
            } else if (request.equals(this.mFocusRequest) && (afState == 4 || afState == 5)) {
                this.mCCI.isAutoFocusing = false;
            }
        }
    }

    private class OnFrameCapturedCallback
            extends CameraCaptureSession.CaptureCallback {
        CameraCacheInfo mCCI;

        public OnFrameCapturedCallback(CameraCacheInfo cci) {
            this.mCCI = cci;
        }

        public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
            if (this.mCCI != null) {
                this.mCCI.lastResult = result;
            }
        }
    }

    private class OnCameraDataAvailable
            implements ImageReader.OnImageAvailableListener {
        private int actualCaptureFormat;
        private int[] actualBufferSize;
        private int DEBUG_FORMAT;
        private ByteBuffer[] testYUVBuffers;
        private int currentTestBufferIndex;

        public OnCameraDataAvailable() {
            this.actualCaptureFormat = 268439808;
            this.actualBufferSize = null;
            this.DEBUG_FORMAT = 0;
            this.testYUVBuffers = new ByteBuffer[2];
            this.currentTestBufferIndex = 0;
        }

        public void onImageAvailable(ImageReader reader) {
            Trace.beginSection("onImageAvailable (java)");
            Integer index = Camera2_Preview.this.mCameraCacheInfoIndexCache.get(reader);
            if (index == null) {
                DebugLog.LOGE("Camera2_Preview", "Unable to find reader in the index cache!");
                Trace.endSection();
                return;
            }
            CameraCacheInfo _cci = Camera2_Preview.this.mCameraCacheInfos.get(index);
            if (_cci == null) {
                DebugLog.LOGE("Camera2_Preview", "Unable to find CCI in list!");
                Trace.endSection();
                return;
            }
            if (!_cci.imageSemaphore.tryAcquire()) {
                DebugLog.LOGE("Camera2_Preview", "Unable to aquire image semaphore, need to free some buffers!!");
                Trace.endSection();
                return;
            }
            Image img = null;
            if (reader.getMaxImages() > 0 && (img = reader.acquireLatestImage()) != null) {
                long timestamp = img.getTimestamp();
                if (this.actualCaptureFormat == 268439808) {
                    this.actualCaptureFormat = this.getImageFormat(img);
                }
                if (this.DEBUG_FORMAT == 268439818) {
                    this.testYUVBuffers[this.currentTestBufferIndex] = this.convertNV21toYV12Contigious(img, this.testYUVBuffers[this.currentTestBufferIndex]);
                    img.close();
                    Camera2_Preview.this.newFrameAvailable(_cci.deviceHandle, index, _cci.bufferWidth, _cci.bufferHeight, this.actualBufferSize, 268439818, this.testYUVBuffers[this.currentTestBufferIndex], timestamp);
                    this.currentTestBufferIndex = (this.currentTestBufferIndex + 1) % 2;
                } else if (this.DEBUG_FORMAT == 268439828) {
                    this.testYUVBuffers[this.currentTestBufferIndex] = this.convertNV21toYUV420Contigious(img, this.testYUVBuffers[this.currentTestBufferIndex]);
                    img.close();
                    Camera2_Preview.this.newFrameAvailable(_cci.deviceHandle, index, _cci.bufferWidth, _cci.bufferHeight, this.actualBufferSize, 268439828, this.testYUVBuffers[this.currentTestBufferIndex], timestamp);
                    this.currentTestBufferIndex = (this.currentTestBufferIndex + 1) % 2;
                } else {
                    Camera2_Preview.this.newFrameAvailable(_cci.deviceHandle, index, _cci.bufferWidth, _cci.bufferHeight, this.actualBufferSize, this.actualCaptureFormat, img.getPlanes()[0].getBuffer(), timestamp);
                    img.close();
                }
            }
            _cci.imageSemaphore.release();
            Trace.endSection();
        }

        private ByteBuffer convertNV21toYUV420Contigious(Image img, ByteBuffer buff) {
            Image.Plane y = img.getPlanes()[0];
            Image.Plane u = img.getPlanes()[1];
            Image.Plane v = img.getPlanes()[2];
            int height = img.getHeight();
            int width = img.getWidth();
            int bufferSize = height * width * 12 / 8;
            int lumaPaddingX = 0;
            int lumaPaddingY = 0;
            int chromaPaddingX = 0;
            int chromaPaddingY = 0;
            if (this.actualBufferSize != null) {
                bufferSize = this.actualBufferSize[0] * this.actualBufferSize[1] + 2 * this.actualBufferSize[2] * this.actualBufferSize[3];
                lumaPaddingX = this.actualBufferSize[0] - width;
                lumaPaddingY = this.actualBufferSize[1] - height;
                chromaPaddingX = this.actualBufferSize[2] - width / 2;
                chromaPaddingY = this.actualBufferSize[3] - height / 2;
            }
            return this.convertNV21toPaddedYUV(buff, y, v, u, height, width, bufferSize, lumaPaddingX, lumaPaddingY, chromaPaddingX, chromaPaddingY);
        }

        private ByteBuffer convertNV21toYV12Contigious(Image img, ByteBuffer buff) {
            Image.Plane y = img.getPlanes()[0];
            Image.Plane u = img.getPlanes()[1];
            Image.Plane v = img.getPlanes()[2];
            int height = img.getHeight();
            int width = img.getWidth();
            int bufferSize = height * width * 12 / 8;
            int lumaPaddingX = 0;
            int lumaPaddingY = 0;
            int chromaPaddingX = 0;
            int chromaPaddingY = 0;
            if (this.actualBufferSize != null) {
                bufferSize = this.actualBufferSize[0] * this.actualBufferSize[1] + 2 * this.actualBufferSize[2] * this.actualBufferSize[3];
                lumaPaddingX = this.actualBufferSize[0] - width;
                lumaPaddingY = this.actualBufferSize[1] - height;
                chromaPaddingX = this.actualBufferSize[2] - width / 2;
                chromaPaddingY = this.actualBufferSize[3] - height / 2;
            }
            return this.convertNV21toPaddedYUV(buff, y, u, v, height, width, bufferSize, lumaPaddingX, lumaPaddingY, chromaPaddingX, chromaPaddingY);
        }

        private ByteBuffer convertNV21toPaddedYUV(ByteBuffer buff, Image.Plane y, Image.Plane u, Image.Plane v, int height, int width, int bufferSize, int lumaPaddingX, int lumaPaddingY, int chromaPaddingX, int chromaPaddingY) {
            int row;
            int p;
            int p2;
            int col;
            ByteBuffer out = buff != null ? buff : ByteBuffer.allocateDirect(bufferSize);
            out.rewind();
            if (lumaPaddingX == 0) {
                out.put(y.getBuffer());
            } else {
                int actualLimit = y.getBuffer().limit();
                while (y.getBuffer().hasRemaining()) {
                    y.getBuffer().limit(y.getBuffer().position() + width);
                    out.put(y.getBuffer());
                    for (p = 0; p < lumaPaddingX; ++p) {
                        out.put((byte) 0);
                    }
                    y.getBuffer().limit(actualLimit);
                }
            }
            if (lumaPaddingY > 0) {
                for (p2 = 0; p2 < lumaPaddingY * this.actualBufferSize[0]; ++p2) {
                    out.put((byte) 0);
                }
            }
            for (row = 0; row < height / 2; ++row) {
                for (col = 0; col < width / 2; ++col) {
                    out.put(u.getBuffer().get());
                    if (!u.getBuffer().hasRemaining()) continue;
                    u.getBuffer().get();
                }
                for (p = 0; p < chromaPaddingX; ++p) {
                    out.put((byte) 0);
                }
            }
            if (chromaPaddingY > 0) {
                for (p2 = 0; p2 < chromaPaddingY * this.actualBufferSize[2]; ++p2) {
                    out.put((byte) 0);
                }
            }
            for (row = 0; row < height / 2; ++row) {
                for (col = 0; col < width / 2; ++col) {
                    out.put(v.getBuffer().get());
                    if (!v.getBuffer().hasRemaining()) continue;
                    v.getBuffer().get();
                }
                for (p = 0; p < chromaPaddingX; ++p) {
                    out.put((byte) 0);
                }
            }
            if (chromaPaddingY > 0) {
                for (p2 = 0; p2 < chromaPaddingY * this.actualBufferSize[2]; ++p2) {
                    out.put((byte) 0);
                }
            }
            out.flip();
            return out;
        }

        private int getImageFormat(Image img) {
            if (img == null || img.getPlanes().length != 3 || img.getFormat() != 35) {
                return 268439808;
            }
            Image.Plane y = img.getPlanes()[0];
            Image.Plane u = img.getPlanes()[1];
            Image.Plane v = img.getPlanes()[2];
            if (y.getPixelStride() != 1 || y.getRowStride() != img.getWidth()) {
                return 268439808;
            }
            if (u.getPixelStride() != v.getPixelStride() || u.getRowStride() != v.getRowStride()) {
                return 268439808;
            }
            long[] buffers = new long[]{Camera2_Preview.this.getBufferAddress(y.getBuffer()), Camera2_Preview.this.getBufferAddress(u.getBuffer()), Camera2_Preview.this.getBufferAddress(v.getBuffer())};
            if (buffers[0] == 0 || buffers[1] == 0 || buffers[2] == 0) {
                return 268439808;
            }
            if (u.getPixelStride() == 2) {
                if (buffers[1] + 1 == buffers[2]) {
                    return 268439815;
                }
                if (buffers[2] + 1 == buffers[1]) {
                    return 268439817;
                }
            }
            if (u.getPixelStride() == 1) {
                if (buffers[1] < buffers[2]) {
                    if (buffers[1] + (long) (img.getHeight() / 2 * (img.getWidth() / 2)) != buffers[2]) {
                        this.actualBufferSize = new int[4];
                        this.actualBufferSize[0] = y.getRowStride();
                        this.actualBufferSize[1] = (int) ((buffers[1] - buffers[0]) / (long) y.getRowStride());
                        this.actualBufferSize[2] = u.getRowStride();
                        this.actualBufferSize[3] = (int) ((buffers[2] - buffers[1]) / (long) u.getRowStride());
                    }
                    return 268439818;
                }
                if (buffers[2] + (long) (img.getHeight() / 2 * (img.getWidth() / 2)) != buffers[1]) {
                    this.actualBufferSize = new int[4];
                    this.actualBufferSize[0] = y.getRowStride();
                    this.actualBufferSize[1] = (int) ((buffers[2] - buffers[0]) / (long) y.getRowStride());
                    this.actualBufferSize[2] = u.getRowStride();
                    this.actualBufferSize[3] = (int) ((buffers[1] - buffers[2]) / (long) u.getRowStride());
                }
                return 268439828;
            }
            DebugLog.LOGE("Camera2_Preview", "Unable to detect a supported image format, Unknown Image Format");
            return 268439808;
        }
    }

    public class CameraCacheInfo {
        int deviceID;
        long deviceHandle;
        String deviceIDString;
        CameraCharacteristics characteristics;
        CameraDevice device;
        CameraCaptureSession session;
        CaptureRequest.Builder builder;
        CaptureResult lastResult;
        List<Surface> surfaces;
        ImageReader reader;
        Image[] images;
        Semaphore imageSemaphore;
        Handler handler;
        HandlerThread thread;
        int bufferWidth;
        int bufferHeight;
        int bufferFormatPL;
        int requestWidth;
        int requestHeight;
        int requestFormatAndroid;
        int requestFramerate;
        int overrideWidth;
        int overrideHeight;
        int overrideFormatAndroid;
        int[] caps;
        int status;
        boolean isAutoFocusing;
    }

}

