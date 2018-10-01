/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
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
 *  android.util.Rational
 *  android.util.Size
 *  android.view.Surface
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.vuforia.ar.pl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
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
import android.os.Looper;
import android.os.Trace;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import com.vuforia.ar.pl.DebugLog;
import com.vuforia.ar.pl.SystemTools;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(value=21)
public class Camera2_Preview {
    private Vector<CameraCacheInfo> mCameraCacheInfos = null;
    private Vector<CameraCacheInfo> mCameraCacheInfosInProgress = null;
    private HashMap<ImageReader, Integer> mCameraCacheInfoIndexCache = null;
    private Context mContext;
    private CameraManager mCameraManager;
    private Semaphore mOpenCloseSemaphore = new Semaphore(1);
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
    private static final int AR_CAMERA_EXPOSUREMODE_MANUAL = 805339136;
    private static final int AR_CAMERA_EXPOSUREMODE_SHUTTER_PRIORITY = 805371904;
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
    private static final int AR_CAMERA_IMAGE_FORMAT_YUV420P = 268439828;
    private static final int[] CAMERA_VALID_IMAGE_FORMAT_PL = new int[]{268439817, 268439815, 268439818, 268439828};
    private static final int NUM_CAPTURE_BUFFERS = 2;
    private static final int NUM_MAX_CAMERAOPEN_RETRY = 10;
    private static final int TIME_CAMERAOPEN_RETRY_DELAY_MS = 250;
    private static final String MODULENAME = "Camera2_Preview";
    private static final int MAX_LOWEST_FPS_ALLOWED = 150;
    private static final int MAX_HIGHEST_FPS_ALLOWED = 300;
    private static final Range<Integer> EMPTY_RANGE = new Range((Comparable)Integer.valueOf(0), (Comparable)Integer.valueOf(0));
    private static final String FOCUS_MODE_NORMAL = "normal";
    private int mIsPermissionGranted = -1;

    private boolean checkPermission() {
        if (this.mIsPermissionGranted == 0) {
            return true;
        }
        try {
            Activity activity = SystemTools.getActivityFromNative();
            PackageManager packageManager = activity.getPackageManager();
            this.mIsPermissionGranted = packageManager.checkPermission("android.permission.CAMERA", activity.getPackageName());
            if (this.mIsPermissionGranted == 0) {
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
        int n4 = -1;
        switch (n3) {
            case 268443664: {
                break;
            }
            case 268443665: {
                n4 = 1;
                break;
            }
            case 268443666: {
                n4 = 0;
                break;
            }
            default: {
                SystemTools.setSystemErrorCode(2);
                return -1;
            }
        }
        try {
            String[] arrstring = this.mCameraManager.getCameraIdList();
            for (int i = 0; i < arrstring.length; ++i) {
                CameraCharacteristics cameraCharacteristics = this.mCameraManager.getCameraCharacteristics(arrstring[i]);
                if (n4 >= 0 && n4 != (Integer)cameraCharacteristics.get(CameraCharacteristics.LENS_FACING) || n >= 0 && n != i) continue;
                return i;
            }
        }
        catch (CameraAccessException cameraAccessException) {
            // empty catch block
        }
        SystemTools.setSystemErrorCode(6);
        return -1;
    }

    private CameraCacheInfo getCameraCacheInfo(int n) {
        if (n < 0 || n >= this.mCameraCacheInfos.size()) {
            return null;
        }
        return this.mCameraCacheInfos.get(n);
    }

    private boolean setCustomCameraParams(CameraCacheInfo cameraCacheInfo, String string) {
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null) {
            return false;
        }
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
            Class<?> class_ = object.getClass();
            if (class_ == String.class || class_ == Integer.class) {
                if (this.mapStringToKey(string2, cameraCacheInfo.characteristics, object) != null) {
                    cameraCacheInfo.builder.set(this.mapStringToKey(string2, cameraCacheInfo.characteristics, object), object);
                    continue;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    private <T> CaptureRequest.Key<T> mapStringToKey(String string, CameraCharacteristics cameraCharacteristics, T t) {
        List list = cameraCharacteristics.getAvailableCaptureRequestKeys();
        for (CaptureRequest.Key key : list) {
            if (!key.getName().equals(string)) continue;
            return key;
        }
        return null;
    }

    private boolean setCameraCaptureParams(CameraCacheInfo cameraCacheInfo, int[] arrn, int[] arrn2) {
        int n;
        Size[] arrsize;
        if (arrn != null || arrn2 != null) {
            cameraCacheInfo.overrideWidth = arrn2 != null ? arrn2[0] : arrn[0];
            cameraCacheInfo.overrideHeight = arrn2 != null ? arrn2[1] : arrn[1];
            cameraCacheInfo.overrideFormatPL = arrn2 != null ? arrn2[2] : arrn[2];
            cameraCacheInfo.overrideFormatAndroid = this.translateImageFormatPLToAndroid(arrn2 != null ? arrn2[2] : arrn[2]);
        }
        if (arrn == null) {
            return true;
        }
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null) {
            DebugLog.LOGE(MODULENAME, "CamCacheInfo not properly initialized in setCaptureParams");
            return false;
        }
        cameraCacheInfo.requestWidth = arrn[0];
        cameraCacheInfo.requestHeight = arrn[1];
        cameraCacheInfo.requestFormatPL = arrn[2];
        cameraCacheInfo.requestFormatAndroid = this.translateImageFormatPLToAndroid(arrn[2]);
        cameraCacheInfo.requestFramerate = arrn[3];
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap)cameraCacheInfo.characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        Size[] arrsize2 = streamConfigurationMap.getOutputSizes(cameraCacheInfo.requestFormatAndroid);
        if (arrsize2 == null) {
            DebugLog.LOGD(MODULENAME, String.format("setCameraCaptureParams: format not supported. : %d", arrn[2]));
            return false;
        }
        boolean bl = false;
        Size[] arrsize3 = arrsize2;
        int n2 = arrsize3.length;
        for (n = 0; n < n2 && !(bl = (arrsize = arrsize3[n]).equals((Object)new Size(cameraCacheInfo.requestWidth, cameraCacheInfo.requestHeight))); ++n) {
        }
        if (!bl) {
            DebugLog.LOGD(MODULENAME, String.format("setCameraCaptureParams: size not supported. : %d, %d", cameraCacheInfo.requestWidth, cameraCacheInfo.requestHeight));
            return false;
        }
        arrsize3 = (Range[])cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        Size size = null;
        n = Integer.MAX_VALUE;
        for (Size size2 : arrsize3) {
            int n3;
            if ((Integer)size2.getLower() >= 150 || (Integer)size2.getUpper() >= 300) {
                DebugLog.LOGW(MODULENAME, String.format("Detected odd fps values from Camera2 API: low=%d, high=%d.  Using first fps range as default instead of searching for perfect fit.", size2.getLower(), size2.getUpper()));
                size = arrsize3[0];
                break;
            }
            if (!size2.contains((Comparable)Integer.valueOf(cameraCacheInfo.requestFramerate)) || (n3 = (Integer)size2.getUpper() - (Integer)size2.getLower()) >= n) continue;
            size = size2;
            n = n3;
        }
        if (size == null) {
            DebugLog.LOGD(MODULENAME, String.format("setCameraCaptureParams: fps range not supported.", new Object[0]));
            return false;
        }
        cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, size);
        return true;
    }

    private boolean setupPreviewBuffer(CameraCacheInfo cameraCacheInfo) {
        cameraCacheInfo.reader = ImageReader.newInstance((int)cameraCacheInfo.requestWidth, (int)cameraCacheInfo.requestHeight, (int)cameraCacheInfo.requestFormatAndroid, (int)2);
        cameraCacheInfo.imageSemaphore = new Semaphore(2);
        cameraCacheInfo.images = new Image[2];
        cameraCacheInfo.bufferWidth = cameraCacheInfo.requestWidth == cameraCacheInfo.overrideWidth ? cameraCacheInfo.reader.getWidth() : cameraCacheInfo.overrideWidth;
        cameraCacheInfo.bufferHeight = cameraCacheInfo.requestHeight == cameraCacheInfo.overrideHeight ? cameraCacheInfo.reader.getHeight() : cameraCacheInfo.overrideHeight;
        int n = cameraCacheInfo.requestFormatAndroid == cameraCacheInfo.overrideFormatAndroid ? cameraCacheInfo.reader.getImageFormat() : cameraCacheInfo.overrideFormatAndroid;
        cameraCacheInfo.bufferFormatPL = cameraCacheInfo.requestFormatPL == cameraCacheInfo.overrideFormatPL ? cameraCacheInfo.requestFormatPL : cameraCacheInfo.overrideFormatPL;
        cameraCacheInfo.reader.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new OnCameraDataAvailable(), cameraCacheInfo.handler);
        if (cameraCacheInfo.surfaces == null) {
            cameraCacheInfo.surfaces = new LinkedList<Surface>();
        }
        cameraCacheInfo.surfaces.clear();
        cameraCacheInfo.surfaces.add(cameraCacheInfo.reader.getSurface());
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

    private int translateImageFormatPLToAndroid(int n) {
        for (int i = 0; i < CAMERA_VALID_IMAGE_FORMAT_PL.length; ++i) {
            if (n != CAMERA_VALID_IMAGE_FORMAT_PL[i]) continue;
            return 35;
        }
        return 0;
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

    private List<Integer> getSupportedPreviewFrameRates(CameraCharacteristics cameraCharacteristics) {
        Range[] arrrange = (Range[])cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        int n = Integer.MAX_VALUE;
        int n2 = Integer.MIN_VALUE;
        for (Range range : arrrange) {
            n = Math.min(n, (Integer)range.getLower());
            n2 = Math.max(n2, (Integer)range.getUpper());
        }
        LinkedList linkedList = new LinkedList();
        if (n < 0 || n >= 150 || n2 < 0 || n2 >= 300) {
            DebugLog.LOGW(MODULENAME, String.format("Detected odd fps values from Camera2 API: low=%d, high=%d.  Using saner defaults instead.", n, n2));
            linkedList.add(30);
        } else {
            block1 : for (int i = n; i <= n2; ++i) {
                for (Range range : arrrange) {
                    if (!range.contains((Comparable)Integer.valueOf(i))) continue;
                    linkedList.add(i);
                    continue block1;
                }
            }
        }
        return linkedList;
    }

    private boolean checkCameraManager() {
        if (this.mCameraManager != null) {
            return true;
        }
        Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            return false;
        }
        Application application = activity.getApplication();
        if (application == null) {
            return false;
        }
        this.mCameraManager = (CameraManager)application.getSystemService("camera");
        if (this.mCameraManager == null) {
            return false;
        }
        return true;
    }

    private static int compareHardwareSupportLevel(int n, int n2) {
        if (n == n2) {
            return 0;
        }
        if (n == 2) {
            return n2 >= 0 ? -1 : 1;
        }
        if (n2 == 2) {
            return n >= 0 ? 1 : -1;
        }
        return n - n2;
    }

    private void cleanupHandlerThread(CameraCacheInfo cameraCacheInfo) {
        cameraCacheInfo.handler = null;
        cameraCacheInfo.thread.quitSafely();
        cameraCacheInfo.thread = null;
    }

    private native void newFrameAvailable(long var1, int var3, int var4, int var5, int[] var6, int var7, ByteBuffer var8, Object var9);

    private native long getBufferAddress(ByteBuffer var1);

    public boolean init() {
        this.mCameraCacheInfos = new Vector<E>();
        this.mCameraCacheInfosInProgress = new Vector<E>();
        this.mCameraCacheInfoIndexCache = new HashMap<K, V>();
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
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        SystemTools.setSystemErrorCode(6);
        return -1;
    }

    public int getOrientation(int n) {
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
                String[] arrstring = this.mCameraManager.getCameraIdList();
                if (n < arrstring.length) {
                    CameraCharacteristics cameraCharacteristics = this.mCameraManager.getCameraCharacteristics(arrstring[n]);
                    return (Integer)cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        SystemTools.setSystemErrorCode(6);
        return -1;
    }

    public int getDirection(int n) {
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
                String[] arrstring = this.mCameraManager.getCameraIdList();
                if (n < arrstring.length) {
                    CameraCharacteristics cameraCharacteristics = this.mCameraManager.getCameraCharacteristics(arrstring[n]);
                    Integer n2 = (Integer)cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    switch (n2) {
                        case 1: {
                            return 268443665;
                        }
                        case 0: {
                            return 268443666;
                        }
                    }
                    return 268443664;
                }
            }
            catch (Exception exception) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
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

    public static boolean checkMinimumHardwareSupportLevel(int n, int n2) {
        try {
            int n3;
            if (n == 268443665) {
                n3 = 1;
            } else if (n == 268443666) {
                n3 = 0;
            } else {
                return false;
            }
            Activity activity = SystemTools.getActivityFromNative();
            CameraManager cameraManager = (CameraManager)activity.getSystemService("camera");
            String[] arrstring = cameraManager.getCameraIdList();
            for (int i = 0; i < arrstring.length; ++i) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(arrstring[i]);
                int n4 = (Integer)cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                if (n4 != n3) continue;
                int n5 = (Integer)cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                return Camera2_Preview.compareHardwareSupportLevel(n5, n2) >= 0;
            }
            return false;
        }
        catch (Exception exception) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int open(long l, int n, int n2, int n3, String string, int[] arrn, int[] arrn2) {
        int n4;
        boolean bl;
        if (!this.checkPermission()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (!this.checkCameraManager()) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        int n5 = this.getCameraDeviceIndex(n, n2, n3);
        if (n5 < 0) {
            return -1;
        }
        int n6 = -1;
        CameraCacheInfo cameraCacheInfo = null;
        int n7 = this.mCameraCacheInfos.size();
        for (n4 = 0; n4 < n7; ++n4) {
            cameraCacheInfo = this.mCameraCacheInfos.get(n4);
            if (cameraCacheInfo.deviceID != n5) continue;
            n6 = n4;
            break;
        }
        if (n6 < 0) {
            try {
                cameraCacheInfo = new CameraCacheInfo();
                cameraCacheInfo.deviceID = n5;
                cameraCacheInfo.deviceHandle = l;
                cameraCacheInfo.deviceIDString = this.mCameraManager.getCameraIdList()[cameraCacheInfo.deviceID];
                cameraCacheInfo.characteristics = this.mCameraManager.getCameraCharacteristics(cameraCacheInfo.deviceIDString);
                cameraCacheInfo.device = null;
                cameraCacheInfo.session = null;
                cameraCacheInfo.builder = null;
                cameraCacheInfo.surfaces = null;
                cameraCacheInfo.reader = null;
                cameraCacheInfo.images = null;
                cameraCacheInfo.imageSemaphore = null;
                cameraCacheInfo.overrideWidth = 0;
                cameraCacheInfo.bufferWidth = 0;
                cameraCacheInfo.overrideHeight = 0;
                cameraCacheInfo.bufferHeight = 0;
                cameraCacheInfo.bufferFormatPL = 268439808;
                cameraCacheInfo.overrideFormatPL = 268439808;
                cameraCacheInfo.overrideFormatAndroid = 0;
                cameraCacheInfo.caps = null;
                cameraCacheInfo.status = 268443649;
                cameraCacheInfo.isAutoFocusing = false;
                cameraCacheInfo.requestFormatPL = 268439817;
                cameraCacheInfo.requestFormatAndroid = 35;
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap)cameraCacheInfo.characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                Size[] arrsize = streamConfigurationMap.getOutputSizes(cameraCacheInfo.requestFormatAndroid);
                cameraCacheInfo.requestWidth = arrsize.length > 0 ? arrsize[0].getWidth() : 0;
                cameraCacheInfo.requestHeight = arrsize.length > 0 ? arrsize[0].getHeight() : 0;
            }
            catch (CameraAccessException cameraAccessException) {
                SystemTools.setSystemErrorCode(6);
                return -1;
            }
        }
        n4 = 0;
        int n8 = 10;
        cameraCacheInfo.thread = new HandlerThread(cameraCacheInfo.deviceIDString + "_camera_thread");
        cameraCacheInfo.thread.start();
        cameraCacheInfo.handler = new Handler(cameraCacheInfo.thread.getLooper());
        do {
            try {
                this.mOpenCloseSemaphore.acquire();
                this.mCameraCacheInfosInProgress.add(cameraCacheInfo);
                this.mCameraManager.openCamera(cameraCacheInfo.deviceIDString, new CameraDevice.StateCallback(){

                    /*
                     * WARNING - Removed try catching itself - possible behaviour change.
                     */
                    public void onOpened(CameraDevice cameraDevice) {
                        CameraCacheInfo cameraCacheInfo = null;
                        try {
                            for (CameraCacheInfo cameraCacheInfo2 : Camera2_Preview.this.mCameraCacheInfosInProgress) {
                                if (!cameraCacheInfo2.deviceIDString.equals(cameraDevice.getId())) continue;
                                cameraCacheInfo = cameraCacheInfo2;
                                cameraCacheInfo.device = cameraDevice;
                                cameraCacheInfo.builder = cameraDevice.createCaptureRequest(1);
                            }
                        }
                        catch (CameraAccessException cameraAccessException) {
                            cameraCacheInfo.builder = null;
                            cameraCacheInfo.device = null;
                        }
                        finally {
                            Camera2_Preview.this.mOpenCloseSemaphore.release();
                        }
                    }

                    public void onError(CameraDevice cameraDevice, int n) {
                        cameraDevice.close();
                        Camera2_Preview.this.mOpenCloseSemaphore.release();
                    }

                    public void onDisconnected(CameraDevice cameraDevice) {
                        cameraDevice.close();
                        Camera2_Preview.this.mOpenCloseSemaphore.release();
                    }
                }, cameraCacheInfo.handler);
                this.mOpenCloseSemaphore.acquire();
                this.mCameraCacheInfosInProgress.remove(cameraCacheInfo);
                this.mOpenCloseSemaphore.release();
                n4 = cameraCacheInfo.device != null && cameraCacheInfo.builder != null ? 1 : 0;
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (n4 != 0) continue;
            try {
                if (n8 <= 0) continue;
                Camera2_Preview camera2_Preview = this;
                synchronized (camera2_Preview) {
                    this.wait(250L);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        } while (n4 == 0 && n8-- > 0);
        if (cameraCacheInfo.device == null || cameraCacheInfo.builder == null) {
            SystemTools.setSystemErrorCode(6);
            this.cleanupHandlerThread(cameraCacheInfo);
            return -1;
        }
        boolean bl2 = arrn != null && arrn.length > 0 || arrn2 != null && arrn2.length > 0;
        boolean bl3 = bl = string != null && string.length() > 0;
        if (bl2 || bl) {
            boolean bl4;
            if (bl2) {
                if (arrn != null && arrn.length != 5) {
                    SystemTools.setSystemErrorCode(2);
                    this.cleanupHandlerThread(cameraCacheInfo);
                    return -1;
                }
                bl4 = this.setCameraCaptureParams(cameraCacheInfo, arrn, arrn2);
                if (!bl4) {
                    SystemTools.setSystemErrorCode(6);
                    this.cleanupHandlerThread(cameraCacheInfo);
                    return -1;
                }
            }
            if (bl && !(bl4 = this.setCustomCameraParams(cameraCacheInfo, string))) {
                SystemTools.setSystemErrorCode(2);
                this.cleanupHandlerThread(cameraCacheInfo);
                return -1;
            }
        }
        cameraCacheInfo.status = 268443650;
        if (n6 < 0) {
            this.mCameraCacheInfos.add(cameraCacheInfo);
            n6 = this.mCameraCacheInfos.size() - 1;
        }
        return n6;
    }

    public boolean close(int n) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        this.mCameraCacheInfoIndexCache.remove((Object)cameraCacheInfo.reader);
        boolean bl = false;
        try {
            if (cameraCacheInfo.session != null) {
                cameraCacheInfo.session.close();
            }
            if (cameraCacheInfo.device != null) {
                cameraCacheInfo.device.close();
            }
            if (cameraCacheInfo.reader != null) {
                cameraCacheInfo.reader.close();
            }
            bl = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        cameraCacheInfo.session = null;
        cameraCacheInfo.reader = null;
        cameraCacheInfo.images = null;
        cameraCacheInfo.status = 268443649;
        this.cleanupHandlerThread(cameraCacheInfo);
        System.gc();
        return bl;
    }

    public int[] getCameraCapabilities(int n) {
        Integer n2;
        boolean bl;
        int n3;
        StreamConfigurationMap streamConfigurationMap;
        Object object;
        if (!this.checkCameraManager()) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        if (cameraCacheInfo.caps != null) {
            return cameraCacheInfo.caps;
        }
        try {
            String string = this.mCameraManager.getCameraIdList()[cameraCacheInfo.deviceID];
            streamConfigurationMap = (StreamConfigurationMap)this.mCameraManager.getCameraCharacteristics(string).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        }
        catch (CameraAccessException cameraAccessException) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        Size[] arrsize = streamConfigurationMap.getOutputSizes(35);
        List<Integer> list = this.getSupportedPreviewFrameRates(cameraCacheInfo.characteristics);
        int[] arrn = (int[])cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        Arrays.sort(arrn);
        int[] arrn2 = (int[])cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        Arrays.sort(arrn2);
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(35);
        int n4 = arrsize != null ? arrsize.length : 0;
        int n5 = list != null ? list.size() : 0;
        int n6 = linkedList != null ? linkedList.size() : 0;
        float[] arrf = (float[])cameraCacheInfo.characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        boolean bl2 = bl = arrf != null && arrf.length > 0;
        if (bl) {
            object = arrf;
            int n7 = ((float[])object).length;
            for (n3 = 0; n3 < n7; n3 += 1) {
                float f = object[n3];
            }
        }
        if ((object = (Boolean)cameraCacheInfo.characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)) == null) {
            object = false;
        }
        n3 = (n2 = (Integer)cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)) != null && n2 > 0 ? 1 : 0;
        Range range = (Range)cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        boolean bl3 = range != null && !EMPTY_RANGE.equals((Object)range);
        Range range2 = (Range)cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
        boolean bl4 = range2 != null && !EMPTY_RANGE.equals((Object)range2);
        Range range3 = (Range)cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE);
        boolean bl5 = range2 != null && !EMPTY_RANGE.equals((Object)range3);
        int[] arrn3 = (int[])cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        int[] arrn4 = (int[])cameraCacheInfo.characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        boolean bl6 = arrn3 != null && arrn3.length > 1 || arrn4 != null && arrn4.length > 1;
        int n8 = 6 + n4 * 2 + n5 + n6;
        cameraCacheInfo.caps = new int[n8];
        int n9 = 0;
        cameraCacheInfo.caps[n9] = 536870912;
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870913, object.booleanValue());
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870914, arrn.length > 0);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870916, bl);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870928, (boolean)n3);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870944, arrn2.length > 0);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536871936, bl3);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536872960, bl3);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870976, bl4);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536871040, bl4);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536871168, bl5);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536871424, bl5);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536903680, bl);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536936448, bl);
        this.setCameraCapsBit(cameraCacheInfo, n9, 553648128, bl6);
        n9 = 1;
        cameraCacheInfo.caps[n9] = 536870912;
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870913, object.booleanValue());
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870914, arrn.length > 0);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870928, (boolean)n3);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870944, arrn2.length > 0);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536871936, bl3);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536870976, bl4);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536871168, bl5);
        this.setCameraCapsBit(cameraCacheInfo, n9, 536903680, bl);
        this.setCameraCapsBit(cameraCacheInfo, n9, 553648128, bl6);
        n9 = 2;
        cameraCacheInfo.caps[n9] = 805306368;
        if (object.booleanValue()) {
            this.setCameraCapsBit(cameraCacheInfo, n9, 805306369, true);
            this.setCameraCapsBit(cameraCacheInfo, n9, 805306370, true);
        }
        if (arrn != null) {
            this.setCameraCapsBit(cameraCacheInfo, n9, 805306384, Arrays.binarySearch(arrn, 1) != -1);
            this.setCameraCapsBit(cameraCacheInfo, n9, 805306400, Arrays.binarySearch(arrn, 1) != -1);
            this.setCameraCapsBit(cameraCacheInfo, n9, 805306432, Arrays.binarySearch(arrn, 3) != -1);
            this.setCameraCapsBit(cameraCacheInfo, n9, 805306496, Arrays.binarySearch(arrn, 2) != -1);
            this.setCameraCapsBit(cameraCacheInfo, n9, 805306624, Arrays.binarySearch(arrn, 0) != -1 && CaptureRequest.LENS_FOCUS_DISTANCE != null);
            this.setCameraCapsBit(cameraCacheInfo, n9, 805306880, Arrays.binarySearch(arrn, 0) != -1);
        }
        if (arrn2 != null) {
            this.setCameraCapsBit(cameraCacheInfo, n9, 805310464, Arrays.binarySearch(arrn2, 0) != -1);
            this.setCameraCapsBit(cameraCacheInfo, n9, 805339136, Arrays.binarySearch(arrn2, 0) != -1);
            this.setCameraCapsBit(cameraCacheInfo, n9, 805322752, Arrays.binarySearch(arrn2, 1) != -1);
        }
        cameraCacheInfo.caps[3] = n4;
        cameraCacheInfo.caps[4] = n5;
        cameraCacheInfo.caps[5] = n6;
        int n10 = 6;
        if (n4 > 0) {
            for (Size size : arrsize) {
                cameraCacheInfo.caps[n10] = size.getWidth();
                cameraCacheInfo.caps[n10 + 1] = size.getHeight();
                n10 += 2;
            }
        }
        if (n5 > 0) {
            for (Integer n11 : list) {
                cameraCacheInfo.caps[n10] = n11;
                ++n10;
            }
        }
        if (n6 > 0) {
            for (Integer n12 : linkedList) {
                cameraCacheInfo.caps[n10] = cameraCacheInfo.requestFormatPL;
                ++n10;
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
        boolean bl = this.setCameraCaptureParams(cameraCacheInfo, arrn, arrn2);
        if (!bl) {
            SystemTools.setSystemErrorCode(6);
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
        int[] arrn = null;
        try {
            arrn = new int[5];
            if (cameraCacheInfo.reader != null) {
                arrn[0] = cameraCacheInfo.reader.getWidth();
                arrn[1] = cameraCacheInfo.reader.getHeight();
            } else {
                arrn[0] = cameraCacheInfo.requestWidth;
                arrn[1] = cameraCacheInfo.requestHeight;
            }
            arrn[2] = cameraCacheInfo.requestFormatPL;
            if (cameraCacheInfo.builder != null) {
                Range range = (Range)cameraCacheInfo.builder.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
                arrn[3] = (Integer)range.getUpper();
            } else {
                arrn[3] = cameraCacheInfo.requestFramerate;
            }
            arrn[4] = 1;
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
            if (cameraCacheInfo.session == null) {
                this.mOpenCloseSemaphore.acquire();
                cameraCacheInfo.device.createCaptureSession(cameraCacheInfo.surfaces, new CameraCaptureSession.StateCallback(){

                    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                        CameraCacheInfo cameraCacheInfo = null;
                        for (CameraCacheInfo cameraCacheInfo2 : Camera2_Preview.this.mCameraCacheInfos) {
                            if (!cameraCacheInfo2.deviceIDString.equals(cameraCaptureSession.getDevice().getId())) continue;
                            cameraCacheInfo = cameraCacheInfo2;
                            break;
                        }
                        cameraCacheInfo.session = cameraCaptureSession;
                        for (Surface surface : cameraCacheInfo.surfaces) {
                            cameraCacheInfo.builder.addTarget(surface);
                        }
                        Camera2_Preview.this.mOpenCloseSemaphore.release();
                    }

                    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                        cameraCaptureSession.close();
                        Camera2_Preview.this.mOpenCloseSemaphore.release();
                    }
                }, cameraCacheInfo.handler);
                this.mOpenCloseSemaphore.acquire();
                this.mOpenCloseSemaphore.release();
                if (cameraCacheInfo.session == null) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            }
            cameraCacheInfo.session.setRepeatingRequest(cameraCacheInfo.builder.build(), (CameraCaptureSession.CaptureCallback)new OnFrameCapturedCallback(cameraCacheInfo), cameraCacheInfo.handler);
            cameraCacheInfo.status = 268443651;
            this.mCameraCacheInfoIndexCache.put(cameraCacheInfo.reader, n);
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
            cameraCacheInfo.session.abortCaptures();
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
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        if (!this.setCustomCameraParams(cameraCacheInfo, string)) {
            return false;
        }
        return true;
    }

    boolean setUntypedCameraParameter(int n, String string, Object object) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null || string == null || object == null) {
            SystemTools.setSystemErrorCode(4);
            return false;
        }
        List list = cameraCacheInfo.characteristics.getAvailableCaptureRequestKeys();
        for (int i = 0; i < list.size(); ++i) {
            CaptureRequest.Key key = (CaptureRequest.Key)list.get(i);
            if (!key.getName().equals(string)) continue;
            Object object2 = cameraCacheInfo.builder.get(key);
            if (!(object2 instanceof Integer || object2 instanceof Float || object2 instanceof Boolean || object2 instanceof Byte || object2 instanceof Long)) {
                return false;
            }
            if (object2 instanceof Byte && object instanceof Long) {
                object = new Byte(((Long)object).byteValue());
            }
            if (object2 instanceof Integer && object instanceof Long) {
                object = new Integer(((Long)object).intValue());
            }
            if (!object2.getClass().equals(object.getClass())) {
                return false;
            }
            try {
                cameraCacheInfo.builder.set(key, object);
                if (cameraCacheInfo.session != null) {
                    cameraCacheInfo.session.setRepeatingRequest(cameraCacheInfo.builder.build(), (CameraCaptureSession.CaptureCallback)new OnFrameCapturedCallback(cameraCacheInfo), cameraCacheInfo.handler);
                }
                return true;
            }
            catch (Exception exception) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
        SystemTools.setSystemErrorCode(6);
        return false;
    }

    Object getUntypedCameraParameter(int n, String string) {
        Object object;
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null || string == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        Object object2 = null;
        List list = cameraCacheInfo.characteristics.getAvailableCaptureRequestKeys();
        for (int i = 0; i < list.size(); ++i) {
            CaptureRequest.Key key = (CaptureRequest.Key)list.get(i);
            if (!key.getName().equals(string)) continue;
            object2 = cameraCacheInfo.builder.get(key);
            break;
        }
        List list2 = cameraCacheInfo.characteristics.getKeys();
        for (int i = 0; i < list2.size(); ++i) {
            object = (CameraCharacteristics.Key)list2.get(i);
            if (!object.getName().equals(string)) continue;
            object2 = cameraCacheInfo.characteristics.get(object);
            break;
        }
        if (object2 == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        if (object2 instanceof Long || object2 instanceof Float || object2 instanceof Boolean || object2 instanceof String) {
            return object2;
        }
        if (object2 instanceof Integer) {
            return new Long(((Integer)object2).longValue());
        }
        if (object2 instanceof Byte) {
            return new Long(((Byte)object2).longValue());
        }
        if (object2 instanceof Range) {
            Comparable comparable = ((Range)object2).getLower();
            object = ((Range)object2).getUpper();
            if (comparable instanceof Integer) {
                long[] arrl = new long[]{((Integer)comparable).longValue(), ((Integer)object).longValue()};
                return arrl;
            }
            if (comparable instanceof Long) {
                long[] arrl = new long[]{(Long)comparable, (Long)object};
                return arrl;
            }
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        SystemTools.setSystemErrorCode(6);
        return null;
    }

    int getUntypedCameraParameterType(int n, String string) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null || string == null) {
            SystemTools.setSystemErrorCode(4);
            return -1;
        }
        Object object = null;
        boolean bl = false;
        List list = cameraCacheInfo.characteristics.getAvailableCaptureRequestKeys();
        for (int i = 0; i < list.size(); ++i) {
            CaptureRequest.Key key = (CaptureRequest.Key)list.get(i);
            if (!key.getName().equals(string)) continue;
            object = cameraCacheInfo.builder.get(key);
            bl = true;
            break;
        }
        List list2 = cameraCacheInfo.characteristics.getKeys();
        for (int i = 0; i < list2.size(); ++i) {
            CameraCharacteristics.Key key = (CameraCharacteristics.Key)list2.get(i);
            if (!key.getName().equals(string)) continue;
            object = cameraCacheInfo.characteristics.get(key);
            bl = true;
            break;
        }
        if (!bl) {
            SystemTools.setSystemErrorCode(6);
            return -1;
        }
        if (object == null) {
            return -1;
        }
        if (object instanceof Integer) {
            return 1;
        }
        if (object instanceof Byte) {
            return 1;
        }
        if (object instanceof Long) {
            return 1;
        }
        if (object instanceof Float) {
            return 2;
        }
        if (object instanceof Boolean) {
            return 3;
        }
        if (object instanceof String) {
            return 0;
        }
        if (object instanceof Range) {
            Comparable comparable = ((Range)object).getLower();
            if (comparable instanceof Integer) {
                return 4;
            }
            if (comparable instanceof Long) {
                return 4;
            }
        }
        return -1;
    }

    int getNamedParameterCount(int n) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null) {
            SystemTools.setSystemErrorCode(4);
            return -1;
        }
        List list = cameraCacheInfo.characteristics.getAvailableCaptureRequestKeys();
        List list2 = cameraCacheInfo.characteristics.getKeys();
        return list.size() + list2.size();
    }

    String getNamedParameter(int n, int n2) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        List list = cameraCacheInfo.characteristics.getAvailableCaptureRequestKeys();
        List list2 = cameraCacheInfo.characteristics.getKeys();
        if (n2 < list.size()) {
            CaptureRequest.Key key = (CaptureRequest.Key)list.get(n2);
            if (key == null) {
                return null;
            }
            return key.getName();
        }
        if (n2 - list.size() < list2.size()) {
            CameraCharacteristics.Key key = (CameraCharacteristics.Key)list2.get(n2 - list.size());
            if (key == null) {
                return null;
            }
            return key.getName();
        }
        SystemTools.setSystemErrorCode(6);
        return null;
    }

    boolean setTypedCameraParameter(int n, int n2, Object object) {
        int n3;
        Object object2;
        boolean bl;
        CameraCacheInfo cameraCacheInfo;
        MeteringRectangle[] arrmeteringRectangle;
        int n4;
        Object object3;
        block99 : {
            cameraCacheInfo = this.getCameraCacheInfo(n);
            if (cameraCacheInfo == null || cameraCacheInfo.builder == null || cameraCacheInfo.characteristics == null) {
                SystemTools.setSystemErrorCode(4);
                return false;
            }
            bl = false;
            try {
                block3 : switch (n2) {
                    int n5;
                    case 541065216: {
                        if (CaptureRequest.CONTROL_CAPTURE_INTENT == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        n5 = ((Number)object).intValue();
                        cameraCacheInfo.builder.set(CaptureRequest.CONTROL_CAPTURE_INTENT, (Object)(n5 != 0 ? 3 : 1));
                        break;
                    }
                    case 536870913: {
                        if (CaptureRequest.FLASH_MODE == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        n5 = ((Number)object).intValue();
                        switch (n5) {
                            case 805306370: {
                                cameraCacheInfo.builder.set(CaptureRequest.FLASH_MODE, (Object)2);
                                break block3;
                            }
                            case 805306369: {
                                cameraCacheInfo.builder.set(CaptureRequest.FLASH_MODE, (Object)0);
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
                        object2 = (int[])cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
                        Arrays.sort((int[])object2);
                        int n6 = ((Number)object).intValue();
                        switch (n6) {
                            case 805306384: 
                            case 805306400: {
                                if (Arrays.binarySearch((int[])object2, 1) == -1) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_MODE, (Object)1);
                                bl = true;
                                break block3;
                            }
                            case 805306432: {
                                if (Arrays.binarySearch((int[])object2, 3) == -1) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_MODE, (Object)3);
                                break block3;
                            }
                            case 805306496: {
                                if (Arrays.binarySearch((int[])object2, 2) == -1) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_MODE, (Object)2);
                                bl = true;
                                break block3;
                            }
                            case 805306624: {
                                if (CaptureRequest.LENS_FOCUS_DISTANCE == null) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                if (Arrays.binarySearch((int[])object2, 0) == -1) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_MODE, (Object)0);
                                cameraCacheInfo.builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, (Object)Float.valueOf(0.0f));
                                break block3;
                            }
                            case 805306880: {
                                if (Arrays.binarySearch((int[])object2, 0) == -1) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_MODE, (Object)0);
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
                        Float f = Float.valueOf(((Number)object).floatValue());
                        cameraCacheInfo.builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, (Object)f);
                        break;
                    }
                    case 536870920: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536870928: {
                        float[] arrf = (float[])object;
                        if (arrf.length != 5) {
                            SystemTools.setSystemErrorCode(2);
                            return false;
                        }
                        if (arrf[0] < 0.0f || arrf[0] > 1.0f || arrf[1] < 0.0f || arrf[1] > 1.0f || arrf[2] < 0.0f || arrf[2] > 1.0f || arrf[3] < 0.0f || arrf[3] > 1.0f || arrf[4] < 0.0f || arrf[4] > 1.0f) {
                            SystemTools.setSystemErrorCode(2);
                            return false;
                        }
                        Integer n7 = (Integer)cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                        if (CaptureRequest.CONTROL_AF_REGIONS == null || n7 == null || n7 == 0) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        Rect rect = (Rect)cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        if (rect == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        arrmeteringRectangle = new MeteringRectangle[]{new MeteringRectangle(new Rect(Math.min((int)(arrf[0] * (float)rect.width()), rect.width() - 1), Math.min((int)(arrf[1] * (float)rect.height()), rect.height() - 1), Math.min((int)(arrf[2] * (float)rect.width()), rect.width() - 1), Math.min((int)(arrf[3] * (float)rect.height()), rect.height() - 1)), (int)(arrf[4] * 1000.0f + 0.0f))};
                        cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_REGIONS, (Object)arrmeteringRectangle);
                        bl = true;
                        break;
                    }
                    case 536870944: {
                        int n8 = ((Number)object).intValue();
                        int[] arrn = (int[])cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
                        if (arrn == null || CaptureRequest.CONTROL_AE_MODE == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        switch (n8) {
                            case 805310464: 
                            case 805339136: {
                                boolean bl2 = false;
                                int[] arrn2 = arrn;
                                n3 = arrn2.length;
                                for (n4 = 0; n4 < n3 && !(bl2 = (object3 = arrn2[n4]) == 0); ++n4) {
                                }
                                if (!bl2) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AE_MODE, (Object)0);
                                break block3;
                            }
                            case 805322752: {
                                int n9;
                                boolean bl3 = false;
                                int[] arrn3 = arrn;
                                n4 = arrn3.length;
                                for (object3 = 0; object3 < n4 && !(bl3 = (n9 = arrn3[object3]) == 1); ++object3) {
                                }
                                if (!bl3) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AE_MODE, (Object)1);
                                break block3;
                            }
                        }
                        SystemTools.setSystemErrorCode(3);
                        return false;
                    }
                    case 536870976: {
                        Range range = (Range)cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
                        if (range == null || CaptureRequest.SENSOR_SENSITIVITY == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        int n10 = ((Number)object).intValue();
                        if (range.contains((Comparable)Integer.valueOf(n10))) {
                            cameraCacheInfo.builder.set(CaptureRequest.SENSOR_SENSITIVITY, (Object)n10);
                            break;
                        }
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536871040: {
                        SystemTools.setSystemErrorCode(6);
                        return false;
                    }
                    case 536871168: {
                        Range range = (Range)cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE);
                        if (range == null || CaptureRequest.SENSOR_EXPOSURE_TIME == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        Long l = Math.round((double)((Number)object).floatValue() * 1.0E9);
                        if (range.contains((Comparable)l)) {
                            cameraCacheInfo.builder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, (Object)l);
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
                        float f = ((Number)object).floatValue();
                        Range range = (Range)cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
                        Rational rational = (Rational)cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
                        if (EMPTY_RANGE.equals((Object)range) || CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION == null || rational == null || CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        int n11 = Math.round(f / rational.floatValue());
                        if (range.contains((Comparable)Integer.valueOf(n11))) {
                            cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (Object)n11);
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
                        int n12 = ((Number)object).intValue();
                        switch (n12) {
                            case 806354944: {
                                if (CaptureRequest.CONTROL_AWB_LOCK == null) {
                                    SystemTools.setSystemErrorCode(6);
                                    return false;
                                }
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AWB_LOCK, (Object)true);
                                break block3;
                            }
                            case 809500672: {
                                if (CaptureRequest.CONTROL_AWB_LOCK != null && ((Boolean)cameraCacheInfo.builder.get(CaptureRequest.CONTROL_AWB_LOCK)).booleanValue()) {
                                    cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AWB_LOCK, (Object)false);
                                }
                                if (CaptureRequest.CONTROL_AWB_MODE != null) {
                                    cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AWB_MODE, (Object)1);
                                    break block3;
                                }
                                break block99;
                            }
                            default: {
                                SystemTools.setSystemErrorCode(3);
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
                        int n13 = ((Number)object).intValue();
                        float[] arrf = (float[])cameraCacheInfo.characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                        if (arrf == null || CaptureRequest.LENS_FOCAL_LENGTH == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        boolean bl4 = false;
                        for (float f : arrf) {
                            if (Math.abs(f - (float)n13) >= 0.01f) continue;
                            bl4 = true;
                            cameraCacheInfo.builder.set(CaptureRequest.LENS_FOCAL_LENGTH, (Object)Float.valueOf(f));
                            break;
                        }
                        if (!bl4) {
                            SystemTools.setSystemErrorCode(2);
                            return false;
                        }
                        break;
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
                        boolean bl5;
                        int[] arrn = (int[])cameraCacheInfo.characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
                        boolean bl6 = arrn != null && arrn.length > 1 && CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE != null;
                        int[] arrn4 = (int[])cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
                        boolean bl7 = bl5 = arrn4 != null && arrn4.length > 1 && CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE != null;
                        if (!bl6 && !bl5) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        n3 = ((Boolean)object).booleanValue() ? 1 : 0;
                        if (bl6) {
                            cameraCacheInfo.builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, (Object)0);
                        }
                        if (bl5) {
                            cameraCacheInfo.builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, (Object)0);
                        }
                        if (n3 != 0) {
                            if (bl6) {
                                cameraCacheInfo.builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, (Object)1);
                                break;
                            }
                            if (bl5) {
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, (Object)1);
                            }
                        }
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
        if (cameraCacheInfo.session != null) {
            try {
                cameraCacheInfo.session.setRepeatingRequest(cameraCacheInfo.builder.build(), (CameraCaptureSession.CaptureCallback)new OnFrameCapturedCallback(cameraCacheInfo), cameraCacheInfo.handler);
            }
            catch (CameraAccessException cameraAccessException) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
            if (bl) {
                try {
                    switch (n2) {
                        case 536870914: {
                            Integer n14 = (Integer)cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                            if (n14 != null && CameraCharacteristics.CONTROL_MAX_REGIONS_AF != null && n14 > 0 && CaptureRequest.CONTROL_AF_REGIONS != null && (object2 = (MeteringRectangle[])cameraCacheInfo.builder.get(CaptureRequest.CONTROL_AF_REGIONS)) != null && ((Object)object2).length > 0) {
                                MeteringRectangle[] arrmeteringRectangle2 = new MeteringRectangle[((Object)object2).length];
                                int n15 = 0;
                                arrmeteringRectangle = object2;
                                n3 = arrmeteringRectangle.length;
                                for (n4 = 0; n4 < n3; ++n4) {
                                    object3 = arrmeteringRectangle[n4];
                                    arrmeteringRectangle2[n15++] = new MeteringRectangle(object3.getRect(), 0);
                                }
                                cameraCacheInfo.builder.set(CaptureRequest.CONTROL_AF_REGIONS, (Object)arrmeteringRectangle2);
                            }
                        }
                        case 536870928: {
                            object2 = new AutofocusRunner(cameraCacheInfo);
                            if (!object2.triggerAutofocus()) {
                                SystemTools.setSystemErrorCode(6);
                                return false;
                            } else {
                                break;
                            }
                        }
                    }
                }
                catch (Exception exception) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            }
        }
        return true;
    }

    Object getTypedCameraParameter(int n, int n2) {
        CameraCacheInfo cameraCacheInfo = this.getCameraCacheInfo(n);
        if (cameraCacheInfo == null || cameraCacheInfo.characteristics == null) {
            SystemTools.setSystemErrorCode(4);
            return null;
        }
        CaptureResult captureResult = cameraCacheInfo.lastResult;
        try {
            switch (n2) {
                case 536870913: {
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    Integer n3 = (Integer)captureResult.get(CaptureResult.FLASH_MODE);
                    if (n3 == null || CaptureResult.FLASH_MODE == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    if (n3.equals(2)) {
                        return 805306370;
                    }
                    if (n3.equals(0)) {
                        return 805306369;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870914: {
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    Integer n4 = (Integer)captureResult.get(CaptureResult.CONTROL_AF_MODE);
                    if (n4 == null || CaptureResult.CONTROL_AF_MODE == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    if (n4.equals(1)) {
                        return cameraCacheInfo.isAutoFocusing ? 805306400 : 805306384;
                    }
                    if (n4.equals(3)) {
                        return 805306432;
                    }
                    if (n4.equals(0)) {
                        Float f = (Float)captureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
                        if (f == null || CaptureResult.LENS_FOCUS_DISTANCE == null || !f.equals(Float.valueOf(0.0f))) {
                            return 805306880;
                        }
                        return 805306624;
                    }
                    if (n4.equals(2)) {
                        return 805306496;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870916: {
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    Float f = (Float)captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
                    if (f == null || CaptureResult.LENS_FOCAL_LENGTH == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    return f;
                }
                case 536870920: {
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    Pair pair = (Pair)captureResult.get(CaptureResult.LENS_FOCUS_RANGE);
                    if (pair != null && CaptureResult.LENS_FOCUS_RANGE != null) {
                        float[] arrf = new float[]{((Float)pair.first).floatValue(), ((Float)pair.second).floatValue()};
                        return arrf;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870928: {
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    Integer n5 = (Integer)cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
                    if (n5 != null && CameraCharacteristics.CONTROL_MAX_REGIONS_AF != null && n5 > 0 && CaptureResult.CONTROL_AF_REGIONS != null) {
                        MeteringRectangle[] arrmeteringRectangle = (MeteringRectangle[])captureResult.get(CaptureResult.CONTROL_AF_REGIONS);
                        if (arrmeteringRectangle == null || arrmeteringRectangle.length == 0) {
                            return null;
                        }
                        Rect rect = (Rect)cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        if (rect == null) {
                            SystemTools.setSystemErrorCode(6);
                            return false;
                        }
                        Rect rect2 = arrmeteringRectangle[0].getRect();
                        float[] arrf = new float[]{rect2.left / (rect.width() - 1), rect2.top / (rect.height() - 1), rect2.right / (rect.width() - 1), rect2.bottom / (rect.height() - 1), (arrmeteringRectangle[0].getMeteringWeight() - 0) / 1000};
                        return arrf;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870944: {
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    Integer n6 = (Integer)captureResult.get(CaptureResult.CONTROL_AE_MODE);
                    if (n6 == null || CaptureResult.CONTROL_AE_MODE == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    if (n6.equals(0)) {
                        return 805339136;
                    }
                    if (n6.equals(1)) {
                        return 805322752;
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536870976: {
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    Integer n7 = (Integer)captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
                    if (n7 != null && CaptureResult.SENSOR_SENSITIVITY != null) {
                        return Float.valueOf(n7.floatValue());
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536871040: {
                    Range range = (Range)cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
                    if (range == null || CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    float[] arrf = new float[]{((Integer)range.getLower()).floatValue(), ((Integer)range.getUpper()).floatValue()};
                    return arrf;
                }
                case 536871168: {
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    Long l = (Long)captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
                    if (l != null && CaptureResult.SENSOR_EXPOSURE_TIME != null) {
                        return Float.valueOf((float)(l.doubleValue() / 1.0E9));
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536871424: {
                    Range range = (Range)cameraCacheInfo.characteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE);
                    if (range == null || CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    float[] arrf = new float[]{(float)(((Long)range.getLower()).doubleValue() / 1.0E9), (float)(((Long)range.getUpper()).doubleValue() / 1.0E9)};
                    return arrf;
                }
                case 536871936: {
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    Integer n8 = (Integer)captureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
                    Rational rational = (Rational)cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
                    if (n8 != null && CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION != null && rational != null && CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP != null) {
                        return Float.valueOf(rational.floatValue() * (float)n8.intValue());
                    }
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                case 536872960: {
                    Range range = (Range)cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
                    Rational rational = (Rational)cameraCacheInfo.characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
                    if (range == null || CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE == null || rational == null || CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    float[] arrf = new float[]{rational.floatValue() * (float)((Integer)range.getLower()).intValue(), rational.floatValue() * (float)((Integer)range.getUpper()).intValue()};
                    return arrf;
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
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    Float f = (Float)captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
                    if (f == null || CaptureResult.LENS_FOCAL_LENGTH == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    return f;
                }
                case 536936448: {
                    SystemTools.setSystemErrorCode(6);
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
                    Integer n9;
                    if (captureResult == null) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
                    }
                    boolean bl = false;
                    Integer n10 = (Integer)captureResult.get(CaptureResult.CONTROL_VIDEO_STABILIZATION_MODE);
                    if (n10 != null && CaptureResult.CONTROL_VIDEO_STABILIZATION_MODE != null) {
                        bl = true;
                        if (n10.equals(1)) {
                            return true;
                        }
                    }
                    if ((n9 = (Integer)captureResult.get(CaptureResult.LENS_OPTICAL_STABILIZATION_MODE)) != null && CaptureResult.LENS_OPTICAL_STABILIZATION_MODE != null) {
                        bl = true;
                        if (n9.equals(1)) {
                            return true;
                        }
                    }
                    if (!bl) {
                        SystemTools.setSystemErrorCode(6);
                        return null;
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

    private class AutofocusRunner
    extends CameraCaptureSession.CaptureCallback {
        private CameraCacheInfo mCCI;
        private CaptureRequest mCancelRequest;
        private CaptureRequest mFocusRequest;

        public AutofocusRunner(CameraCacheInfo cameraCacheInfo) {
            this.mCCI = cameraCacheInfo;
            this.mCancelRequest = null;
            this.mFocusRequest = null;
        }

        public boolean triggerAutofocus() throws CameraAccessException {
            if (this.mCCI == null || this.mCCI.builder == null || this.mCCI.session == null) {
                return false;
            }
            Integer n = (Integer)this.mCCI.builder.get(CaptureRequest.CONTROL_AF_MODE);
            if (CaptureRequest.CONTROL_AF_MODE == null || n == null) {
                return false;
            }
            if (n != 1 && n != 2) {
                return false;
            }
            this.mCCI.isAutoFocusing = true;
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, (Object)2);
            this.mCancelRequest = this.mCCI.builder.build();
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, (Object)0);
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, (Object)1);
            this.mFocusRequest = this.mCCI.builder.build();
            this.mCCI.builder.set(CaptureRequest.CONTROL_AF_TRIGGER, (Object)0);
            this.mCCI.session.capture(this.mCancelRequest, (CameraCaptureSession.CaptureCallback)this, this.mCCI.handler);
            return true;
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
            Integer n = (Integer)totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (captureRequest.equals((Object)this.mCancelRequest) && n == 0) {
                try {
                    cameraCaptureSession.capture(this.mFocusRequest, (CameraCaptureSession.CaptureCallback)this, this.mCCI.handler);
                }
                catch (CameraAccessException cameraAccessException) {}
            } else if (captureRequest.equals((Object)this.mFocusRequest) && (n == 4 || n == 5)) {
                this.mCCI.isAutoFocusing = false;
            }
        }
    }

    private class OnFrameCapturedCallback
    extends CameraCaptureSession.CaptureCallback {
        CameraCacheInfo mCCI;

        public OnFrameCapturedCallback(CameraCacheInfo cameraCacheInfo) {
            this.mCCI = cameraCacheInfo;
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            if (this.mCCI != null) {
                this.mCCI.lastResult = totalCaptureResult;
            }
        }
    }

    private class OnCameraDataAvailable
    implements ImageReader.OnImageAvailableListener {
        private int actualCaptureFormat = 268439808;
        private int[] actualBufferSize = null;

        private OnCameraDataAvailable() {
        }

        public void onImageAvailable(ImageReader imageReader) {
            Trace.beginSection((String)"onImageAvailable (java)");
            Integer n = (Integer)Camera2_Preview.this.mCameraCacheInfoIndexCache.get((Object)imageReader);
            if (n == null) {
                DebugLog.LOGE(Camera2_Preview.MODULENAME, "Unable to find reader in the index cache!");
                Trace.endSection();
                return;
            }
            CameraCacheInfo cameraCacheInfo = (CameraCacheInfo)Camera2_Preview.this.mCameraCacheInfos.get(n);
            if (cameraCacheInfo == null) {
                DebugLog.LOGE(Camera2_Preview.MODULENAME, "Unable to find CCI in list!");
                Trace.endSection();
                return;
            }
            if (!cameraCacheInfo.imageSemaphore.tryAcquire()) {
                DebugLog.LOGE(Camera2_Preview.MODULENAME, "Unable to aquire image semaphore, need to free some buffers!!");
                Trace.endSection();
                return;
            }
            Image image = null;
            if (imageReader.getMaxImages() > 0 && (image = imageReader.acquireLatestImage()) != null) {
                FrameInfo frameInfo = new FrameInfo();
                frameInfo.timestamp = image.getTimestamp();
                CaptureResult captureResult = cameraCacheInfo.lastResult;
                if (captureResult != null) {
                    Integer n2;
                    Long l = (Long)captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
                    if (l != null) {
                        frameInfo.exposureTime = l;
                        frameInfo.timestamp += l.longValue();
                    }
                    if ((n2 = (Integer)captureResult.get(CaptureResult.SENSOR_SENSITIVITY)) != null) {
                        frameInfo.iso = n2;
                    }
                }
                if (this.actualCaptureFormat == 268439808) {
                    this.actualCaptureFormat = this.getImageFormat(image);
                }
                Camera2_Preview.this.newFrameAvailable(cameraCacheInfo.deviceHandle, n, cameraCacheInfo.bufferWidth, cameraCacheInfo.bufferHeight, this.actualBufferSize, this.actualCaptureFormat, image.getPlanes()[0].getBuffer(), frameInfo);
                image.close();
            }
            cameraCacheInfo.imageSemaphore.release();
            Trace.endSection();
        }

        private int getImageFormat(Image image) {
            if (image == null || image.getPlanes().length != 3 || image.getFormat() != 35) {
                return 268439808;
            }
            Image.Plane plane = image.getPlanes()[0];
            Image.Plane plane2 = image.getPlanes()[1];
            Image.Plane plane3 = image.getPlanes()[2];
            if (plane.getPixelStride() != 1) {
                return 268439808;
            }
            if (plane2.getPixelStride() != plane3.getPixelStride() || plane2.getRowStride() != plane3.getRowStride()) {
                return 268439808;
            }
            long[] arrl = new long[]{Camera2_Preview.this.getBufferAddress(plane.getBuffer()), Camera2_Preview.this.getBufferAddress(plane2.getBuffer()), Camera2_Preview.this.getBufferAddress(plane3.getBuffer())};
            if (arrl[0] == 0L || arrl[1] == 0L || arrl[2] == 0L) {
                return 268439808;
            }
            if (plane2.getPixelStride() == 2) {
                if (arrl[1] + 1L == arrl[2]) {
                    this.actualBufferSize = this.calculateActualBufferSize(arrl[0], arrl[1], arrl[2], plane.getRowStride(), plane2.getRowStride(), image.getWidth(), image.getHeight(), 268439815);
                    return 268439815;
                }
                if (arrl[2] + 1L == arrl[1]) {
                    this.actualBufferSize = this.calculateActualBufferSize(arrl[0], arrl[2], arrl[1], plane.getRowStride(), plane2.getRowStride(), image.getWidth(), image.getHeight(), 268439817);
                    return 268439817;
                }
            }
            if (plane2.getPixelStride() == 1) {
                if (arrl[1] < arrl[2]) {
                    this.actualBufferSize = this.calculateActualBufferSize(arrl[0], arrl[1], arrl[2], plane.getRowStride(), plane2.getRowStride(), image.getWidth(), image.getHeight(), 268439818);
                    return 268439818;
                }
                this.actualBufferSize = this.calculateActualBufferSize(arrl[0], arrl[2], arrl[1], plane.getRowStride(), plane2.getRowStride(), image.getWidth(), image.getHeight(), 268439828);
                return 268439828;
            }
            DebugLog.LOGE(Camera2_Preview.MODULENAME, "Unable to detect a supported image format, Unknown Image Format");
            return 268439808;
        }

        private int[] calculateActualBufferSize(long l, long l2, long l3, int n, int n2, int n3, int n4, int n5) {
            int[] arrn = null;
            boolean bl = false;
            if ((n5 == 268439815 || n5 == 268439817) && l + (long)(n4 * n3) != l2) {
                bl = true;
            } else if (!(n5 != 268439818 && n5 != 268439828 || l + (long)(n4 * n3) == l2 && l2 + (long)(n4 / 2 * (n3 / 2)) == l3)) {
                bl = true;
            }
            if (bl) {
                arrn = new int[4];
                arrn[0] = n;
                arrn[1] = (int)((l2 - l) / (long)n);
                arrn[2] = n2;
                if (n5 == 268439815 || n5 == 268439817) {
                    arrn[3] = n4 / 2;
                } else if (n5 == 268439818 || n5 == 268439828) {
                    arrn[3] = (int)((l3 - l2) / (long)n2);
                }
            }
            return arrn;
        }
    }

    public class FrameInfo {
        long timestamp;
        long exposureTime;
        int iso;
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
        int requestFormatPL;
        int requestFormatAndroid;
        int requestFramerate;
        int overrideWidth;
        int overrideHeight;
        int overrideFormatPL;
        int overrideFormatAndroid;
        int[] caps;
        int status;
        boolean isAutoFocusing;
    }

}

