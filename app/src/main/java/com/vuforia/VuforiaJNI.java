/*
 * Decompiled with CFR 0_123.
 */
package com.vuforia;

import com.vuforia.Area;
import com.vuforia.Box3D;
import com.vuforia.CameraCalibration;
import com.vuforia.CameraDevice;
import com.vuforia.CameraField;
import com.vuforia.CustomViewerParameters;
import com.vuforia.CylinderTarget;
import com.vuforia.CylinderTargetResult;
import com.vuforia.DataSet;
import com.vuforia.Device;
import com.vuforia.DeviceTrackableResult;
import com.vuforia.DeviceTracker;
import com.vuforia.EyewearCalibrationProfileManager;
import com.vuforia.EyewearCalibrationReading;
import com.vuforia.EyewearDevice;
import com.vuforia.EyewearUserCalibrator;
import com.vuforia.Frame;
import com.vuforia.GLTextureData;
import com.vuforia.GLTextureUnit;
import com.vuforia.HandheldTransformModel;
import com.vuforia.HeadTransformModel;
import com.vuforia.Image;
import com.vuforia.ImageTarget;
import com.vuforia.ImageTargetBuilder;
import com.vuforia.ImageTargetResult;
import com.vuforia.InstanceId;
import com.vuforia.Marker;
import com.vuforia.MarkerResult;
import com.vuforia.MarkerTracker;
import com.vuforia.Matrix34F;
import com.vuforia.Matrix44F;
import com.vuforia.Mesh;
import com.vuforia.MultiTarget;
import com.vuforia.MultiTargetResult;
import com.vuforia.Obb2D;
import com.vuforia.Obb3D;
import com.vuforia.ObjectTarget;
import com.vuforia.ObjectTargetResult;
import com.vuforia.ObjectTracker;
import com.vuforia.Prop;
import com.vuforia.PropResult;
import com.vuforia.Reconstruction;
import com.vuforia.ReconstructionFromTarget;
import com.vuforia.Rectangle;
import com.vuforia.RectangleInt;
import com.vuforia.Renderer;
import com.vuforia.RenderingPrimitives;
import com.vuforia.RotationalDeviceTracker;
import com.vuforia.SmartTerrainBuilder;
import com.vuforia.SmartTerrainTrackable;
import com.vuforia.SmartTerrainTracker;
import com.vuforia.State;
import com.vuforia.StateUpdater;
import com.vuforia.Surface;
import com.vuforia.SurfaceResult;
import com.vuforia.TargetFinder;
import com.vuforia.TargetSearchResult;
import com.vuforia.TextTracker;
import com.vuforia.TextureData;
import com.vuforia.TextureUnit;
import com.vuforia.Trackable;
import com.vuforia.TrackableResult;
import com.vuforia.TrackableSource;
import com.vuforia.Tracker;
import com.vuforia.TrackerManager;
import com.vuforia.TransformModel;
import com.vuforia.Type;
import com.vuforia.UpdateCallback;
import com.vuforia.Vec2F;
import com.vuforia.Vec2I;
import com.vuforia.Vec3F;
import com.vuforia.Vec3I;
import com.vuforia.Vec4F;
import com.vuforia.Vec4I;
import com.vuforia.VideoBackgroundConfig;
import com.vuforia.VideoBackgroundTextureInfo;
import com.vuforia.VideoMode;
import com.vuforia.ViewList;
import com.vuforia.ViewerParameters;
import com.vuforia.ViewerParametersList;
import com.vuforia.VirtualButton;
import com.vuforia.VirtualButtonResult;
import com.vuforia.VuMarkTarget;
import com.vuforia.VuMarkTargetResult;
import com.vuforia.VuMarkTemplate;
import com.vuforia.Word;
import com.vuforia.WordList;
import com.vuforia.WordResult;
import java.math.BigInteger;
import java.nio.ByteBuffer;

class VuforiaJNI {
    VuforiaJNI() {
    }

    public static final native boolean setHint(long var0, int var2);

    public static final native void registerCallback(long var0, UpdateCallback var2);

    public static final native boolean setFrameFormat(int var0, boolean var1);

    public static final native int getBitsPerPixel(int var0);

    public static final native boolean requiresAlpha();

    public static final native int getBufferSize(int var0, int var1, int var2);

    public static final native void onResume();

    public static final native void onPause();

    public static final native void onSurfaceCreated();

    public static final native void onSurfaceChanged(int var0, int var1);

    public static final native String getLibraryVersion();

    public static final native long new_Type__SWIG_0();

    public static final native long new_Type__SWIG_1(short var0);

    public static final native boolean Type_isOfType(long var0, Type var2, long var3, Type var5);

    public static final native void delete_Type(long var0);

    public static final native void Matrix34F_data_set(long var0, Matrix34F var2, float[] var3);

    public static final native float[] Matrix34F_data_get(long var0, Matrix34F var2);

    public static final native long new_Matrix34F__SWIG_0();

    public static final native long new_Matrix34F__SWIG_1(long var0, Matrix34F var2);

    public static final native void delete_Matrix34F(long var0);

    public static final native void Matrix44F_data_set(long var0, Matrix44F var2, float[] var3);

    public static final native float[] Matrix44F_data_get(long var0, Matrix44F var2);

    public static final native long new_Matrix44F__SWIG_0();

    public static final native long new_Matrix44F__SWIG_1(long var0, Matrix44F var2);

    public static final native void delete_Matrix44F(long var0);

    public static final native long new_Vec2F__SWIG_0();

    public static final native long new_Vec2F__SWIG_1(float[] var0);

    public static final native long new_Vec2F__SWIG_2(float var0, float var1);

    public static final native void Vec2F_data_set(long var0, Vec2F var2, float[] var3);

    public static final native float[] Vec2F_data_get(long var0, Vec2F var2);

    public static final native long new_Vec2F__SWIG_3(long var0, Vec2F var2);

    public static final native void delete_Vec2F(long var0);

    public static final native long new_Vec3F__SWIG_0();

    public static final native long new_Vec3F__SWIG_1(float[] var0);

    public static final native long new_Vec3F__SWIG_2(float var0, float var1, float var2);

    public static final native void Vec3F_data_set(long var0, Vec3F var2, float[] var3);

    public static final native float[] Vec3F_data_get(long var0, Vec3F var2);

    public static final native long new_Vec3F__SWIG_3(long var0, Vec3F var2);

    public static final native void delete_Vec3F(long var0);

    public static final native long new_Vec4F__SWIG_0();

    public static final native long new_Vec4F__SWIG_1(float[] var0);

    public static final native long new_Vec4F__SWIG_2(float var0, float var1, float var2, float var3);

    public static final native void Vec4F_data_set(long var0, Vec4F var2, float[] var3);

    public static final native float[] Vec4F_data_get(long var0, Vec4F var2);

    public static final native long new_Vec4F__SWIG_3(long var0, Vec4F var2);

    public static final native void delete_Vec4F(long var0);

    public static final native long new_Vec2I__SWIG_0();

    public static final native long new_Vec2I__SWIG_1(int[] var0);

    public static final native long new_Vec2I__SWIG_2(int var0, int var1);

    public static final native void Vec2I_data_set(long var0, Vec2I var2, int[] var3);

    public static final native int[] Vec2I_data_get(long var0, Vec2I var2);

    public static final native long new_Vec2I__SWIG_3(long var0, Vec2I var2);

    public static final native void delete_Vec2I(long var0);

    public static final native long new_Vec3I__SWIG_0();

    public static final native long new_Vec3I__SWIG_1(int[] var0);

    public static final native void Vec3I_data_set(long var0, Vec3I var2, int[] var3);

    public static final native int[] Vec3I_data_get(long var0, Vec3I var2);

    public static final native void delete_Vec3I(long var0);

    public static final native long new_Vec4I__SWIG_0();

    public static final native long new_Vec4I__SWIG_1(int[] var0);

    public static final native void Vec4I_data_set(long var0, Vec4I var2, int[] var3);

    public static final native int[] Vec4I_data_get(long var0, Vec4I var2);

    public static final native void delete_Vec4I(long var0);

    public static final native long new_VideoMode__SWIG_0();

    public static final native int VideoMode_Width_get(long var0, VideoMode var2);

    public static final native int VideoMode_Height_get(long var0, VideoMode var2);

    public static final native float VideoMode_Framerate_get(long var0, VideoMode var2);

    public static final native long new_VideoMode__SWIG_1(long var0, VideoMode var2);

    public static final native void delete_VideoMode(long var0);

    public static final native long Trackable_getClassType();

    public static final native long Trackable_getType(long var0, Trackable var2);

    public static final native boolean Trackable_isOfType(long var0, Trackable var2, long var3, Type var5);

    public static final native int Trackable_getId(long var0, Trackable var2);

    public static final native String Trackable_getName(long var0, Trackable var2);

    public static final native boolean Trackable_startExtendedTracking(long var0, Trackable var2);

    public static final native boolean Trackable_stopExtendedTracking(long var0, Trackable var2);

    public static final native boolean Trackable_isExtendedTrackingStarted(long var0, Trackable var2);

    public static final native void delete_Trackable(long var0);

    public static final native long TrackableResult_getClassType();

    public static final native long TrackableResult_getType(long var0, TrackableResult var2);

    public static final native boolean TrackableResult_isOfType(long var0, TrackableResult var2, long var3, Type var5);

    public static final native double TrackableResult_getTimeStamp(long var0, TrackableResult var2);

    public static final native int TrackableResult_getStatus(long var0, TrackableResult var2);

    public static final native long TrackableResult_getTrackable(long var0, TrackableResult var2);

    public static final native long TrackableResult_getPose(long var0, TrackableResult var2);

    public static final native int TrackableResult_getCoordinateSystem(long var0, TrackableResult var2);

    public static final native void delete_TrackableResult(long var0);

    public static final native long Tracker_getClassType();

    public static final native long Tracker_getType(long var0, Tracker var2);

    public static final native boolean Tracker_isOfType(long var0, Tracker var2, long var3, Type var5);

    public static final native boolean Tracker_start(long var0, Tracker var2);

    public static final native void Tracker_stop(long var0, Tracker var2);

    public static final native void delete_Tracker(long var0);

    public static final native int Mesh_getNumVertices(long var0, Mesh var2);

    public static final native boolean Mesh_hasPositions(long var0, Mesh var2);

    public static final native ByteBuffer Mesh_getPositions(long var0, Mesh var2);

    public static final native boolean Mesh_hasNormals(long var0, Mesh var2);

    public static final native ByteBuffer Mesh_getNormals(long var0, Mesh var2);

    public static final native boolean Mesh_hasUVs(long var0, Mesh var2);

    public static final native ByteBuffer Mesh_getUVs(long var0, Mesh var2);

    public static final native int Mesh_getNumTriangles(long var0, Mesh var2);

    public static final native ByteBuffer Mesh_getTriangles(long var0, Mesh var2);

    public static final native void delete_Mesh(long var0);

    public static final native long SmartTerrainTrackable_getClassType();

    public static final native long SmartTerrainTrackable_getMesh(long var0, SmartTerrainTrackable var2);

    public static final native int SmartTerrainTrackable_getRevision(long var0, SmartTerrainTrackable var2);

    public static final native long SmartTerrainTrackable_getLocalPose(long var0, SmartTerrainTrackable var2);

    public static final native long SmartTerrainTrackable_getParent(long var0, SmartTerrainTrackable var2);

    public static final native long SmartTerrainTrackable_getChildrenCount(long var0, SmartTerrainTrackable var2);

    public static final native long SmartTerrainTrackable_getChild(long var0, SmartTerrainTrackable var2, long var3);

    public static final native void delete_SmartTerrainTrackable(long var0);

    public static final native long Reconstruction_getClassType();

    public static final native long Reconstruction_getType(long var0, Reconstruction var2);

    public static final native boolean Reconstruction_setMaximumArea(long var0, Reconstruction var2, long var3, Rectangle var5);

    public static final native boolean Reconstruction_getMaximumArea(long var0, Reconstruction var2, long var3, Rectangle var5);

    public static final native void Reconstruction_setNavMeshPadding(long var0, Reconstruction var2, float var3);

    public static final native boolean Reconstruction_start(long var0, Reconstruction var2);

    public static final native boolean Reconstruction_stop(long var0, Reconstruction var2);

    public static final native boolean Reconstruction_reset(long var0, Reconstruction var2);

    public static final native boolean Reconstruction_isReconstructing(long var0, Reconstruction var2);

    public static final native long new_Obb2D__SWIG_0();

    public static final native long new_Obb2D__SWIG_1(long var0, Obb2D var2);

    public static final native long new_Obb2D__SWIG_2(long var0, Vec2F var2, long var3, Vec2F var5, float var6);

    public static final native long Obb2D_getCenter(long var0, Obb2D var2);

    public static final native long Obb2D_getHalfExtents(long var0, Obb2D var2);

    public static final native float Obb2D_getRotation(long var0, Obb2D var2);

    public static final native void delete_Obb2D(long var0);

    public static final native long new_Obb3D__SWIG_0();

    public static final native long new_Obb3D__SWIG_1(long var0, Obb3D var2);

    public static final native long new_Obb3D__SWIG_2(long var0, Vec3F var2, long var3, Vec3F var5, float var6);

    public static final native long Obb3D_getCenter(long var0, Obb3D var2);

    public static final native long Obb3D_getHalfExtents(long var0, Obb3D var2);

    public static final native float Obb3D_getRotationZ(long var0, Obb3D var2);

    public static final native void delete_Obb3D(long var0);

    public static final native int Area_getType(long var0, Area var2);

    public static final native void delete_Area(long var0);

    public static final native long new_Box3D__SWIG_0();

    public static final native long new_Box3D__SWIG_1(long var0, Box3D var2);

    public static final native long new_Box3D__SWIG_2(long var0, Vec3F var2, long var3, Vec3F var5);

    public static final native long Box3D_getMinimumPosition(long var0, Box3D var2);

    public static final native long Box3D_getMaximumPosition(long var0, Box3D var2);

    public static final native void delete_Box3D(long var0);

    public static final native long CameraCalibration_getSize(long var0, CameraCalibration var2);

    public static final native long CameraCalibration_getFocalLength(long var0, CameraCalibration var2);

    public static final native long CameraCalibration_getPrincipalPoint(long var0, CameraCalibration var2);

    public static final native long CameraCalibration_getDistortionParameters(long var0, CameraCalibration var2);

    public static final native long CameraCalibration_getFieldOfViewRads(long var0, CameraCalibration var2);

    public static final native long new_CameraField();

    public static final native int CameraField_Type_get(long var0, CameraField var2);

    public static final native String CameraField_Key_get(long var0, CameraField var2);

    public static final native void delete_CameraField(long var0);

    public static final native long CameraDevice_getInstance();

    public static final native boolean CameraDevice_init__SWIG_0(long var0, CameraDevice var2, int var3);

    public static final native boolean CameraDevice_init__SWIG_1(long var0, CameraDevice var2);

    public static final native boolean CameraDevice_deinit(long var0, CameraDevice var2);

    public static final native boolean CameraDevice_start(long var0, CameraDevice var2);

    public static final native boolean CameraDevice_stop(long var0, CameraDevice var2);

    public static final native int CameraDevice_getNumVideoModes(long var0, CameraDevice var2);

    public static final native long CameraDevice_getVideoMode(long var0, CameraDevice var2, int var3);

    public static final native int CameraDevice_getCameraDirection(long var0, CameraDevice var2);

    public static final native boolean CameraDevice_selectVideoMode(long var0, CameraDevice var2, int var3);

    public static final native long CameraDevice_getCameraCalibration(long var0, CameraDevice var2);

    public static final native boolean CameraDevice_setFlashTorchMode(long var0, CameraDevice var2, boolean var3);

    public static final native boolean CameraDevice_setFocusMode(long var0, CameraDevice var2, int var3);

    public static final native boolean CameraDevice_setField__SWIG_0(long var0, CameraDevice var2, String var3, String var4);

    public static final native boolean CameraDevice_setField__SWIG_1(long var0, CameraDevice var2, String var3, long var4);

    public static final native boolean CameraDevice_setField__SWIG_2(long var0, CameraDevice var2, String var3, float var4);

    public static final native boolean CameraDevice_setField__SWIG_3(long var0, CameraDevice var2, String var3, boolean var4);

    public static final native boolean CameraDevice_setField__SWIG_4(long var0, CameraDevice var2, String var3, long[] var4);

    public static final native int CameraDevice_getNumFields(long var0, CameraDevice var2);

    public static final native boolean CameraDevice_getCameraField(long var0, CameraDevice var2, int var3, long var4, CameraField var6);

    public static final native boolean CameraDevice_getFieldString(long var0, CameraDevice var2, String var3, String var4, long var5);

    public static final native boolean CameraDevice_getFieldInt64(long var0, CameraDevice var2, String var3, long[] var4);

    public static final native boolean CameraDevice_getFieldFloat(long var0, CameraDevice var2, String var3, float[] var4);

    public static final native boolean CameraDevice_getFieldBool(long var0, CameraDevice var2, String var3, boolean[] var4);

    public static final native boolean CameraDevice_getFieldInt64Range(long var0, CameraDevice var2, String var3, long[] var4);

    public static final native void delete_CameraDevice(long var0);

    public static final native long ObjectTarget_getClassType();

    public static final native String ObjectTarget_getUniqueTargetId(long var0, ObjectTarget var2);

    public static final native long ObjectTarget_getSize(long var0, ObjectTarget var2);

    public static final native boolean ObjectTarget_setSize(long var0, ObjectTarget var2, long var3, Vec3F var5);

    public static final native void delete_ObjectTarget(long var0);

    public static final native long ObjectTargetResult_getClassType();

    public static final native long ObjectTargetResult_getTrackable(long var0, ObjectTargetResult var2);

    public static final native void delete_ObjectTargetResult(long var0);

    public static final native long CylinderTarget_getClassType();

    public static final native float CylinderTarget_getSideLength(long var0, CylinderTarget var2);

    public static final native boolean CylinderTarget_setSideLength(long var0, CylinderTarget var2, float var3);

    public static final native float CylinderTarget_getTopDiameter(long var0, CylinderTarget var2);

    public static final native boolean CylinderTarget_setTopDiameter(long var0, CylinderTarget var2, float var3);

    public static final native float CylinderTarget_getBottomDiameter(long var0, CylinderTarget var2);

    public static final native boolean CylinderTarget_setBottomDiameter(long var0, CylinderTarget var2, float var3);

    public static final native void delete_CylinderTarget(long var0);

    public static final native long CylinderTargetResult_getClassType();

    public static final native long CylinderTargetResult_getTrackable(long var0, CylinderTargetResult var2);

    public static final native void delete_CylinderTargetResult(long var0);

    public static final native boolean DataSet_exists(String var0, int var1);

    public static final native boolean DataSet_load(long var0, DataSet var2, String var3, int var4);

    public static final native int DataSet_getNumTrackables(long var0, DataSet var2);

    public static final native long DataSet_getTrackable(long var0, DataSet var2, int var3);

    public static final native long DataSet_createTrackable(long var0, DataSet var2, long var3, TrackableSource var5);

    public static final native long DataSet_createMultiTarget(long var0, DataSet var2, String var3);

    public static final native boolean DataSet_destroy(long var0, DataSet var2, long var3, Trackable var5);

    public static final native boolean DataSet_hasReachedTrackableLimit(long var0, DataSet var2);

    public static final native boolean DataSet_isActive(long var0, DataSet var2);

    public static final native void delete_DataSet(long var0);

    public static final native long EyewearCalibrationProfileManager_getMaxCount(long var0, EyewearCalibrationProfileManager var2);

    public static final native long EyewearCalibrationProfileManager_getUsedCount(long var0, EyewearCalibrationProfileManager var2);

    public static final native boolean EyewearCalibrationProfileManager_isProfileUsed(long var0, EyewearCalibrationProfileManager var2, int var3);

    public static final native int EyewearCalibrationProfileManager_getActiveProfile(long var0, EyewearCalibrationProfileManager var2);

    public static final native boolean EyewearCalibrationProfileManager_setActiveProfile(long var0, EyewearCalibrationProfileManager var2, int var3);

    public static final native long EyewearCalibrationProfileManager_getCameraToEyePose(long var0, EyewearCalibrationProfileManager var2, int var3, int var4);

    public static final native long EyewearCalibrationProfileManager_getEyeProjection(long var0, EyewearCalibrationProfileManager var2, int var3, int var4);

    public static final native boolean EyewearCalibrationProfileManager_setCameraToEyePose(long var0, EyewearCalibrationProfileManager var2, int var3, int var4, long var5, Matrix34F var7);

    public static final native boolean EyewearCalibrationProfileManager_setEyeProjection(long var0, EyewearCalibrationProfileManager var2, int var3, int var4, long var5, Matrix34F var7);

    public static final native short[] EyewearCalibrationProfileManager_getProfileName(long var0, EyewearCalibrationProfileManager var2, int var3);

    public static final native boolean EyewearCalibrationProfileManager_setProfileName(long var0, EyewearCalibrationProfileManager var2, int var3, short[] var4);

    public static final native boolean EyewearCalibrationProfileManager_clearProfile(long var0, EyewearCalibrationProfileManager var2, int var3);

    public static final native void delete_EyewearCalibrationProfileManager(long var0);

    public static final native void EyewearCalibrationReading_Pose_set(long var0, EyewearCalibrationReading var2, long var3, Matrix34F var5);

    public static final native long EyewearCalibrationReading_Pose_get(long var0, EyewearCalibrationReading var2);

    public static final native void EyewearCalibrationReading_Scale_set(long var0, EyewearCalibrationReading var2, float var3);

    public static final native float EyewearCalibrationReading_Scale_get(long var0, EyewearCalibrationReading var2);

    public static final native void EyewearCalibrationReading_CenterX_set(long var0, EyewearCalibrationReading var2, float var3);

    public static final native float EyewearCalibrationReading_CenterX_get(long var0, EyewearCalibrationReading var2);

    public static final native void EyewearCalibrationReading_CenterY_set(long var0, EyewearCalibrationReading var2, float var3);

    public static final native float EyewearCalibrationReading_CenterY_get(long var0, EyewearCalibrationReading var2);

    public static final native long new_EyewearCalibrationReading();

    public static final native void delete_EyewearCalibrationReading(long var0);

    public static final native boolean EyewearUserCalibrator_init(long var0, EyewearUserCalibrator var2, long var3, long var5, float var7, float var8);

    public static final native float EyewearUserCalibrator_getMinScaleHint(long var0, EyewearUserCalibrator var2);

    public static final native float EyewearUserCalibrator_getMaxScaleHint(long var0, EyewearUserCalibrator var2);

    public static final native float EyewearUserCalibrator_getDrawingAspectRatio(long var0, EyewearUserCalibrator var2, long var3, long var5);

    public static final native boolean EyewearUserCalibrator_isStereoStretched(long var0, EyewearUserCalibrator var2);

    public static final native boolean EyewearUserCalibrator_getProjectionMatrix(long var0, EyewearUserCalibrator var2, long[] var3, int var4, long var5, Matrix34F var7, long var8, Matrix34F var10);

    public static final native int EyewearUserCalibrator_getProjectionMatrices(long var0, EyewearUserCalibrator var2, long[] var3, int var4, long[] var5, int var6, long var7, Matrix34F var9, long var10, Matrix34F var12, long var13, Matrix34F var15, long var16, Matrix34F var18);

    public static final native void delete_EyewearUserCalibrator(long var0);

    public static final native void delete_ViewerParameters(long var0);

    public static final native long new_ViewerParameters(long var0, ViewerParameters var2);

    public static final native float ViewerParameters_getVersion(long var0, ViewerParameters var2);

    public static final native String ViewerParameters_getName(long var0, ViewerParameters var2);

    public static final native String ViewerParameters_getManufacturer(long var0, ViewerParameters var2);

    public static final native int ViewerParameters_getButtonType(long var0, ViewerParameters var2);

    public static final native float ViewerParameters_getScreenToLensDistance(long var0, ViewerParameters var2);

    public static final native float ViewerParameters_getInterLensDistance(long var0, ViewerParameters var2);

    public static final native int ViewerParameters_getTrayAlignment(long var0, ViewerParameters var2);

    public static final native float ViewerParameters_getLensCentreToTrayDistance(long var0, ViewerParameters var2);

    public static final native long ViewerParameters_getNumDistortionCoefficients(long var0, ViewerParameters var2);

    public static final native float ViewerParameters_getDistortionCoefficient(long var0, ViewerParameters var2, int var3);

    public static final native long ViewerParameters_getFieldOfView(long var0, ViewerParameters var2);

    public static final native boolean ViewerParameters_containsMagnet(long var0, ViewerParameters var2);

    public static final native long ViewerParametersList_getListForAuthoringTools();

    public static final native void ViewerParametersList_setSDKFilter(long var0, ViewerParametersList var2, String var3);

    public static final native long ViewerParametersList_size(long var0, ViewerParametersList var2);

    public static final native long ViewerParametersList_get__SWIG_0(long var0, ViewerParametersList var2, long var3);

    public static final native long ViewerParametersList_get__SWIG_1(long var0, ViewerParametersList var2, String var3, String var4);

    public static final native long ViewerParametersList_begin(long var0, ViewerParametersList var2);

    public static final native long ViewerParametersList_end(long var0, ViewerParametersList var2);

    public static final native long ViewerParametersList_next(long var0, ViewerParametersList var2, long var3, ViewerParameters var5);

    public static final native void delete_ViewerParametersList(long var0);

    public static final native long new_CustomViewerParameters__SWIG_0(float var0, String var1, String var2);

    public static final native long new_CustomViewerParameters__SWIG_1(long var0, CustomViewerParameters var2);

    public static final native void CustomViewerParameters_setButtonType(long var0, CustomViewerParameters var2, int var3);

    public static final native void CustomViewerParameters_setScreenToLensDistance(long var0, CustomViewerParameters var2, float var3);

    public static final native void CustomViewerParameters_setInterLensDistance(long var0, CustomViewerParameters var2, float var3);

    public static final native void CustomViewerParameters_setTrayAlignment(long var0, CustomViewerParameters var2, int var3);

    public static final native void CustomViewerParameters_setLensCentreToTrayDistance(long var0, CustomViewerParameters var2, float var3);

    public static final native void CustomViewerParameters_clearDistortionCoefficients(long var0, CustomViewerParameters var2);

    public static final native void CustomViewerParameters_addDistortionCoefficient(long var0, CustomViewerParameters var2, float var3);

    public static final native void CustomViewerParameters_setFieldOfView(long var0, CustomViewerParameters var2, long var3, Vec4F var5);

    public static final native void CustomViewerParameters_setContainsMagnet(long var0, CustomViewerParameters var2, boolean var3);

    public static final native void delete_CustomViewerParameters(long var0);

    public static final native long ViewList_getNumViews(long var0, ViewList var2);

    public static final native int ViewList_getView(long var0, ViewList var2, int var3);

    public static final native boolean ViewList_contains(long var0, ViewList var2, int var3);

    public static final native void delete_ViewList(long var0);

    public static final native void delete_RenderingPrimitives(long var0);

    public static final native long new_RenderingPrimitives(long var0, RenderingPrimitives var2);

    public static final native long RenderingPrimitives_getRenderingViews(long var0, RenderingPrimitives var2);

    public static final native long RenderingPrimitives_getViewport(long var0, RenderingPrimitives var2, int var3);

    public static final native long RenderingPrimitives_getNormalizedViewport(long var0, RenderingPrimitives var2, int var3);

    public static final native long RenderingPrimitives_getProjectionMatrix__SWIG_0(long var0, RenderingPrimitives var2, int var3, int var4, boolean var5);

    public static final native long RenderingPrimitives_getProjectionMatrix__SWIG_1(long var0, RenderingPrimitives var2, int var3, int var4);

    public static final native long RenderingPrimitives_getEffectiveFov(long var0, RenderingPrimitives var2, int var3);

    public static final native long RenderingPrimitives_getViewportCentreToEyeAxis(long var0, RenderingPrimitives var2, int var3, int var4);

    public static final native long RenderingPrimitives_getEyeDisplayAdjustmentMatrix(long var0, RenderingPrimitives var2, int var3);

    public static final native long RenderingPrimitives_getVideoBackgroundTextureSize(long var0, RenderingPrimitives var2);

    public static final native long RenderingPrimitives_getVideoBackgroundProjectionMatrix__SWIG_0(long var0, RenderingPrimitives var2, int var3, int var4, boolean var5);

    public static final native long RenderingPrimitives_getVideoBackgroundProjectionMatrix__SWIG_1(long var0, RenderingPrimitives var2, int var3, int var4);

    public static final native long RenderingPrimitives_getVideoBackgroundMesh(long var0, RenderingPrimitives var2, int var3);

    public static final native long RenderingPrimitives_getDistortionTextureSize(long var0, RenderingPrimitives var2, int var3);

    public static final native long RenderingPrimitives_getDistortionTextureViewport(long var0, RenderingPrimitives var2, int var3);

    public static final native long RenderingPrimitives_getDistortionTextureMesh(long var0, RenderingPrimitives var2, int var3);

    public static final native long Device_getInstance();

    public static final native long Device_getClassType();

    public static final native long Device_getType(long var0, Device var2);

    public static final native boolean Device_isOfType(long var0, Device var2, long var3, Type var5);

    public static final native boolean Device_setMode(long var0, Device var2, int var3);

    public static final native int Device_getMode(long var0, Device var2);

    public static final native void Device_setViewerActive(long var0, Device var2, boolean var3);

    public static final native boolean Device_isViewerActive(long var0, Device var2);

    public static final native long Device_getViewerList(long var0, Device var2);

    public static final native boolean Device_selectViewer(long var0, Device var2, long var3, ViewerParameters var5);

    public static final native long Device_getSelectedViewer(long var0, Device var2);

    public static final native void Device_setConfigurationChanged(long var0, Device var2);

    public static final native long Device_getRenderingPrimitives(long var0, Device var2);

    public static final native void delete_Device(long var0);

    public static final native long EyewearDevice_getClassType();

    public static final native boolean EyewearDevice_isSeeThru(long var0, EyewearDevice var2);

    public static final native boolean EyewearDevice_isDualDisplay(long var0, EyewearDevice var2);

    public static final native boolean EyewearDevice_setDisplayExtended(long var0, EyewearDevice var2, boolean var3);

    public static final native boolean EyewearDevice_isDisplayExtended(long var0, EyewearDevice var2);

    public static final native boolean EyewearDevice_isDisplayExtendedGLOnly(long var0, EyewearDevice var2);

    public static final native int EyewearDevice_getScreenOrientation(long var0, EyewearDevice var2);

    public static final native boolean EyewearDevice_setPredictiveTracking(long var0, EyewearDevice var2, boolean var3);

    public static final native boolean EyewearDevice_isPredictiveTrackingEnabled(long var0, EyewearDevice var2);

    public static final native long EyewearDevice_getCalibrationProfileManager(long var0, EyewearDevice var2);

    public static final native long EyewearDevice_getUserCalibrator(long var0, EyewearDevice var2);

    public static final native void delete_EyewearDevice(long var0);

    public static final native long new_Frame__SWIG_0();

    public static final native long new_Frame__SWIG_1(long var0, Frame var2);

    public static final native void delete_Frame(long var0);

    public static final native double Frame_getTimeStamp(long var0, Frame var2);

    public static final native int Frame_getIndex(long var0, Frame var2);

    public static final native long Frame_getNumImages(long var0, Frame var2);

    public static final native long Frame_getImage(long var0, Frame var2, int var3);

    public static final native int Image_getWidth(long var0, Image var2);

    public static final native int Image_getHeight(long var0, Image var2);

    public static final native int Image_getStride(long var0, Image var2);

    public static final native int Image_getBufferWidth(long var0, Image var2);

    public static final native int Image_getBufferHeight(long var0, Image var2);

    public static final native int Image_getFormat(long var0, Image var2);

    public static final native ByteBuffer Image_getPixels(long var0, Image var2);

    public static final native long ImageTarget_getClassType();

    public static final native int ImageTarget_getNumVirtualButtons(long var0, ImageTarget var2);

    public static final native long ImageTarget_getVirtualButton__SWIG_0(long var0, ImageTarget var2, int var3);

    public static final native long ImageTarget_getVirtualButton__SWIG_1(long var0, ImageTarget var2, String var3);

    public static final native long ImageTarget_createVirtualButton(long var0, ImageTarget var2, String var3, long var4, Area var6);

    public static final native boolean ImageTarget_destroyVirtualButton(long var0, ImageTarget var2, long var3, VirtualButton var5);

    public static final native String ImageTarget_getMetaData(long var0, ImageTarget var2);

    public static final native void delete_ImageTarget(long var0);

    public static final native boolean ImageTargetBuilder_build(long var0, ImageTargetBuilder var2, String var3, float var4);

    public static final native void ImageTargetBuilder_startScan(long var0, ImageTargetBuilder var2);

    public static final native void ImageTargetBuilder_stopScan(long var0, ImageTargetBuilder var2);

    public static final native int ImageTargetBuilder_getFrameQuality(long var0, ImageTargetBuilder var2);

    public static final native long ImageTargetBuilder_getTrackableSource(long var0, ImageTargetBuilder var2);

    public static final native long ImageTargetResult_getClassType();

    public static final native long ImageTargetResult_getTrackable(long var0, ImageTargetResult var2);

    public static final native int ImageTargetResult_getNumVirtualButtons(long var0, ImageTargetResult var2);

    public static final native long ImageTargetResult_getVirtualButtonResult__SWIG_0(long var0, ImageTargetResult var2, int var3);

    public static final native long ImageTargetResult_getVirtualButtonResult__SWIG_1(long var0, ImageTargetResult var2, String var3);

    public static final native void delete_ImageTargetResult(long var0);

    public static final native long ObjectTracker_getClassType();

    public static final native long ObjectTracker_createDataSet(long var0, ObjectTracker var2);

    public static final native boolean ObjectTracker_destroyDataSet(long var0, ObjectTracker var2, long var3, DataSet var5);

    public static final native boolean ObjectTracker_activateDataSet(long var0, ObjectTracker var2, long var3, DataSet var5);

    public static final native boolean ObjectTracker_deactivateDataSet(long var0, ObjectTracker var2, long var3, DataSet var5);

    public static final native long ObjectTracker_getActiveDataSet__SWIG_0(long var0, ObjectTracker var2, int var3);

    public static final native long ObjectTracker_getActiveDataSet__SWIG_1(long var0, ObjectTracker var2);

    public static final native int ObjectTracker_getActiveDataSetCount(long var0, ObjectTracker var2);

    public static final native long ObjectTracker_getImageTargetBuilder(long var0, ObjectTracker var2);

    public static final native long ObjectTracker_getTargetFinder(long var0, ObjectTracker var2);

    public static final native boolean ObjectTracker_persistExtendedTracking(long var0, ObjectTracker var2, boolean var3);

    public static final native boolean ObjectTracker_resetExtendedTracking(long var0, ObjectTracker var2);

    public static final native void delete_ObjectTracker(long var0);

    public static final native long Marker_getClassType();

    public static final native long Marker_getSize(long var0, Marker var2);

    public static final native boolean Marker_setSize(long var0, Marker var2, long var3, Vec2F var5);

    public static final native int Marker_getMarkerId(long var0, Marker var2);

    public static final native int Marker_getMarkerType(long var0, Marker var2);

    public static final native void delete_Marker(long var0);

    public static final native long MarkerResult_getClassType();

    public static final native long MarkerResult_getTrackable(long var0, MarkerResult var2);

    public static final native void delete_MarkerResult(long var0);

    public static final native long MarkerTracker_getClassType();

    public static final native long MarkerTracker_createFrameMarker(long var0, MarkerTracker var2, int var3, String var4, long var5, Vec2F var7);

    public static final native boolean MarkerTracker_destroyMarker(long var0, MarkerTracker var2, long var3, Marker var5);

    public static final native int MarkerTracker_getNumMarkers(long var0, MarkerTracker var2);

    public static final native long MarkerTracker_getMarker(long var0, MarkerTracker var2, int var3);

    public static final native void delete_MarkerTracker(long var0);

    public static final native long MultiTarget_getClassType();

    public static final native int MultiTarget_getNumParts(long var0, MultiTarget var2);

    public static final native long MultiTarget_getPart__SWIG_0(long var0, MultiTarget var2, int var3);

    public static final native long MultiTarget_getPart__SWIG_1(long var0, MultiTarget var2, String var3);

    public static final native int MultiTarget_addPart(long var0, MultiTarget var2, long var3, Trackable var5);

    public static final native boolean MultiTarget_removePart(long var0, MultiTarget var2, int var3);

    public static final native boolean MultiTarget_setPartOffset(long var0, MultiTarget var2, int var3, long var4, Matrix34F var6);

    public static final native boolean MultiTarget_getPartOffset(long var0, MultiTarget var2, int var3, long var4, Matrix34F var6);

    public static final native void delete_MultiTarget(long var0);

    public static final native long MultiTargetResult_getClassType();

    public static final native long MultiTargetResult_getTrackable(long var0, MultiTargetResult var2);

    public static final native int MultiTargetResult_getNumPartResults(long var0, MultiTargetResult var2);

    public static final native long MultiTargetResult_getPartResult__SWIG_0(long var0, MultiTargetResult var2, int var3);

    public static final native long MultiTargetResult_getPartResult__SWIG_1(long var0, MultiTargetResult var2, String var3);

    public static final native void delete_MultiTargetResult(long var0);

    public static final native long new_Rectangle__SWIG_0();

    public static final native long new_Rectangle__SWIG_1(long var0, Rectangle var2);

    public static final native long new_Rectangle__SWIG_2(float var0, float var1, float var2, float var3);

    public static final native void delete_Rectangle(long var0);

    public static final native float Rectangle_getLeftTopX(long var0, Rectangle var2);

    public static final native float Rectangle_getLeftTopY(long var0, Rectangle var2);

    public static final native float Rectangle_getRightBottomX(long var0, Rectangle var2);

    public static final native float Rectangle_getRightBottomY(long var0, Rectangle var2);

    public static final native float Rectangle_getWidth(long var0, Rectangle var2);

    public static final native float Rectangle_getHeight(long var0, Rectangle var2);

    public static final native float Rectangle_getAreaSize(long var0, Rectangle var2);

    public static final native int Rectangle_getType(long var0, Rectangle var2);

    public static final native long new_RectangleInt__SWIG_0();

    public static final native long new_RectangleInt__SWIG_1(long var0, RectangleInt var2);

    public static final native long new_RectangleInt__SWIG_2(int var0, int var1, int var2, int var3);

    public static final native void delete_RectangleInt(long var0);

    public static final native int RectangleInt_getLeftTopX(long var0, RectangleInt var2);

    public static final native int RectangleInt_getLeftTopY(long var0, RectangleInt var2);

    public static final native int RectangleInt_getRightBottomX(long var0, RectangleInt var2);

    public static final native int RectangleInt_getRightBottomY(long var0, RectangleInt var2);

    public static final native int RectangleInt_getWidth(long var0, RectangleInt var2);

    public static final native int RectangleInt_getHeight(long var0, RectangleInt var2);

    public static final native int RectangleInt_getAreaSize(long var0, RectangleInt var2);

    public static final native int RectangleInt_getType(long var0, RectangleInt var2);

    public static final native long Renderer_getInstance();

    public static final native long Renderer_begin__SWIG_0(long var0, Renderer var2);

    public static final native void Renderer_begin__SWIG_1(long var0, Renderer var2, long var3, State var5);

    public static final native boolean Renderer_drawVideoBackground(long var0, Renderer var2);

    public static final native void Renderer_end(long var0, Renderer var2);

    public static final native boolean Renderer_updateVideoBackgroundTexture__SWIG_0(long var0, Renderer var2, long var3, TextureUnit var5);

    public static final native boolean Renderer_updateVideoBackgroundTexture__SWIG_1(long var0, Renderer var2);

    public static final native void Renderer_setVideoBackgroundConfig(long var0, Renderer var2, long var3, VideoBackgroundConfig var5);

    public static final native long Renderer_getVideoBackgroundConfig(long var0, Renderer var2);

    public static final native long Renderer_getVideoBackgroundTextureInfo(long var0, Renderer var2);

    public static final native boolean Renderer_setVideoBackgroundTexture(long var0, Renderer var2, long var3, TextureData var5);

    public static final native void Renderer_setARProjection(long var0, Renderer var2, float var3, float var4);

    public static final native boolean Renderer_setTargetFps(long var0, Renderer var2, int var3);

    public static final native int Renderer_getRecommendedFps__SWIG_0(long var0, Renderer var2, int var3);

    public static final native int Renderer_getRecommendedFps__SWIG_1(long var0, Renderer var2);

    public static final native void delete_Renderer(long var0);

    public static final native int TextureData_type(long var0, TextureData var2);

    public static final native int TextureUnit_type(long var0, TextureUnit var2);

    public static final native long new_GLTextureData__SWIG_0(int var0);

    public static final native long new_GLTextureData__SWIG_1();

    public static final native void delete_GLTextureData(long var0);

    public static final native void GLTextureData_VideoBackgroundTextureID_set(long var0, GLTextureData var2, int var3);

    public static final native int GLTextureData_VideoBackgroundTextureID_get(long var0, GLTextureData var2);

    public static final native long new_GLTextureUnit__SWIG_0(int var0);

    public static final native long new_GLTextureUnit__SWIG_1();

    public static final native void delete_GLTextureUnit(long var0);

    public static final native void GLTextureUnit_TextureUnit_set(long var0, GLTextureUnit var2, int var3);

    public static final native int GLTextureUnit_TextureUnit_get(long var0, GLTextureUnit var2);

    public static final native long new_State__SWIG_0();

    public static final native long new_State__SWIG_1(long var0, State var2);

    public static final native void delete_State(long var0);

    public static final native long State_getFrame(long var0, State var2);

    public static final native int State_getNumTrackables(long var0, State var2);

    public static final native long State_getTrackable(long var0, State var2, int var3);

    public static final native int State_getNumTrackableResults(long var0, State var2);

    public static final native long State_getTrackableResult(long var0, State var2, int var3);

    public static final native long StateUpdater_updateState(long var0, StateUpdater var2);

    public static final native long StateUpdater_getLatestState(long var0, StateUpdater var2);

    public static final native double StateUpdater_getCurrentTimeStamp(long var0, StateUpdater var2);

    public static final native void delete_StateUpdater(long var0);

    public static final native long Surface_getClassType();

    public static final native long Surface_getNavMesh(long var0, Surface var2);

    public static final native long Surface_getBoundingBox(long var0, Surface var2);

    public static final native int Surface_getNumMeshBoundaries(long var0, Surface var2);

    public static final native ByteBuffer Surface_getMeshBoundaries(long var0, Surface var2);

    public static final native void delete_Surface(long var0);

    public static final native long ReconstructionFromTarget_getClassType();

    public static final native boolean ReconstructionFromTarget_setInitializationTarget__SWIG_0(long var0, ReconstructionFromTarget var2, long var3, Trackable var5, long var6, Box3D var8);

    public static final native boolean ReconstructionFromTarget_setInitializationTarget__SWIG_1(long var0, ReconstructionFromTarget var2, long var3, Trackable var5, long var6, Box3D var8, long var9, Matrix34F var11);

    public static final native long ReconstructionFromTarget_getInitializationTarget(long var0, ReconstructionFromTarget var2);

    public static final native long Prop_getClassType();

    public static final native long Prop_getBoundingBox(long var0, Prop var2);

    public static final native long Prop_getLocalPosition(long var0, Prop var2);

    public static final native void delete_Prop(long var0);

    public static final native long PropResult_getClassType();

    public static final native long PropResult_getTrackable(long var0, PropResult var2);

    public static final native void delete_PropResult(long var0);

    public static final native long SurfaceResult_getClassType();

    public static final native long SurfaceResult_getTrackable(long var0, SurfaceResult var2);

    public static final native void delete_SurfaceResult(long var0);

    public static final native int TransformModel_getType(long var0, TransformModel var2);

    public static final native void delete_TransformModel(long var0);

    public static final native int HandheldTransformModel_getType(long var0, HandheldTransformModel var2);

    public static final native long new_HandheldTransformModel__SWIG_0();

    public static final native long new_HandheldTransformModel__SWIG_1(long var0, HandheldTransformModel var2);

    public static final native long new_HandheldTransformModel__SWIG_2(long var0, Vec3F var2);

    public static final native boolean HandheldTransformModel_setPivotPoint(long var0, HandheldTransformModel var2, long var3, Vec3F var5);

    public static final native long HandheldTransformModel_getPivotPoint(long var0, HandheldTransformModel var2);

    public static final native void delete_HandheldTransformModel(long var0);

    public static final native int HeadTransformModel_getType(long var0, HeadTransformModel var2);

    public static final native long new_HeadTransformModel__SWIG_0();

    public static final native long new_HeadTransformModel__SWIG_1(long var0, HeadTransformModel var2);

    public static final native long new_HeadTransformModel__SWIG_2(long var0, Vec3F var2);

    public static final native boolean HeadTransformModel_setPivotPoint(long var0, HeadTransformModel var2, long var3, Vec3F var5);

    public static final native long HeadTransformModel_getPivotPoint(long var0, HeadTransformModel var2);

    public static final native void delete_HeadTransformModel(long var0);

    public static final native long DeviceTrackable_getClassType();

    public static final native void delete_DeviceTrackable(long var0);

    public static final native long DeviceTrackableResult_getClassType();

    public static final native long DeviceTrackableResult_getTrackable(long var0, DeviceTrackableResult var2);

    public static final native void delete_DeviceTrackableResult(long var0);

    public static final native long DeviceTracker_getClassType();

    public static final native boolean DeviceTracker_setWorldToDeviceBaseTransform(long var0, DeviceTracker var2, long var3, Matrix34F var5);

    public static final native long DeviceTracker_getWorldToDeviceBaseTransform(long var0, DeviceTracker var2);

    public static final native void delete_DeviceTracker(long var0);

    public static final native long RotationalDeviceTracker_getClassType();

    public static final native boolean RotationalDeviceTracker_recenter(long var0, RotationalDeviceTracker var2);

    public static final native boolean RotationalDeviceTracker_setPosePrediction(long var0, RotationalDeviceTracker var2, boolean var3);

    public static final native boolean RotationalDeviceTracker_getPosePrediction(long var0, RotationalDeviceTracker var2);

    public static final native boolean RotationalDeviceTracker_setModelCorrection(long var0, RotationalDeviceTracker var2, long var3, TransformModel var5);

    public static final native long RotationalDeviceTracker_getModelCorrection(long var0, RotationalDeviceTracker var2);

    public static final native long RotationalDeviceTracker_getDefaultHeadModel(long var0, RotationalDeviceTracker var2);

    public static final native long RotationalDeviceTracker_getDefaultHandheldModel(long var0, RotationalDeviceTracker var2);

    public static final native void delete_RotationalDeviceTracker(long var0);

    public static final native long SmartTerrainBuilder_getClassType();

    public static final native long SmartTerrainBuilder_getType(long var0, SmartTerrainBuilder var2);

    public static final native boolean SmartTerrainBuilder_isOfType(long var0, SmartTerrainBuilder var2, long var3, Type var5);

    public static final native long SmartTerrainBuilder_createReconstruction(long var0, SmartTerrainBuilder var2, long var3, Type var5);

    public static final native boolean SmartTerrainBuilder_destroyReconstruction(long var0, SmartTerrainBuilder var2, long var3, Reconstruction var5);

    public static final native long SmartTerrainBuilder_getNumReconstructions(long var0, SmartTerrainBuilder var2);

    public static final native boolean SmartTerrainBuilder_addReconstruction(long var0, SmartTerrainBuilder var2, long var3, Reconstruction var5);

    public static final native boolean SmartTerrainBuilder_removeReconstruction(long var0, SmartTerrainBuilder var2, long var3);

    public static final native long SmartTerrainBuilder_getReconstruction(long var0, SmartTerrainBuilder var2, long var3);

    public static final native boolean SmartTerrainBuilder_init(long var0, SmartTerrainBuilder var2);

    public static final native boolean SmartTerrainBuilder_deinit(long var0, SmartTerrainBuilder var2);

    public static final native void delete_SmartTerrainBuilder(long var0);

    public static final native long SmartTerrainTracker_getClassType();

    public static final native boolean SmartTerrainTracker_setScaleToMillimeter(long var0, SmartTerrainTracker var2, float var3);

    public static final native float SmartTerrainTracker_getScaleToMillimeter(long var0, SmartTerrainTracker var2);

    public static final native long SmartTerrainTracker_getSmartTerrainBuilder(long var0, SmartTerrainTracker var2);

    public static final native void delete_SmartTerrainTracker(long var0);

    public static final native String TargetSearchResult_getTargetName(long var0, TargetSearchResult var2);

    public static final native String TargetSearchResult_getUniqueTargetId(long var0, TargetSearchResult var2);

    public static final native float TargetSearchResult_getTargetSize(long var0, TargetSearchResult var2);

    public static final native String TargetSearchResult_getMetaData(long var0, TargetSearchResult var2);

    public static final native short TargetSearchResult_getTrackingRating(long var0, TargetSearchResult var2);

    public static final native void delete_TargetSearchResult(long var0);

    public static final native boolean TargetFinder_startInit(long var0, TargetFinder var2, String var3, String var4);

    public static final native int TargetFinder_getInitState(long var0, TargetFinder var2);

    public static final native void TargetFinder_waitUntilInitFinished(long var0, TargetFinder var2);

    public static final native boolean TargetFinder_deinit(long var0, TargetFinder var2);

    public static final native boolean TargetFinder_startRecognition(long var0, TargetFinder var2);

    public static final native boolean TargetFinder_stop(long var0, TargetFinder var2);

    public static final native boolean TargetFinder_isRequesting(long var0, TargetFinder var2);

    public static final native int TargetFinder_updateSearchResults__SWIG_0(long var0, TargetFinder var2, int var3);

    public static final native int TargetFinder_updateSearchResults__SWIG_1(long var0, TargetFinder var2);

    public static final native int TargetFinder_getResultCount(long var0, TargetFinder var2);

    public static final native long TargetFinder_getResult(long var0, TargetFinder var2, int var3);

    public static final native long TargetFinder_enableTracking(long var0, TargetFinder var2, long var3, TargetSearchResult var5);

    public static final native void TargetFinder_clearTrackables(long var0, TargetFinder var2);

    public static final native int TargetFinder_getNumImageTargets(long var0, TargetFinder var2);

    public static final native long TargetFinder_getImageTarget(long var0, TargetFinder var2, int var3);

    public static final native void delete_TargetFinder(long var0);

    public static final native boolean WordList_loadWordList(long var0, WordList var2, String var3, int var4);

    public static final native int WordList_addWordsFromFile(long var0, WordList var2, String var3, int var4);

    public static final native boolean WordList_addWordU(long var0, WordList var2, short[] var3);

    public static final native boolean WordList_removeWordU(long var0, WordList var2, short[] var3);

    public static final native boolean WordList_containsWordU(long var0, WordList var2, short[] var3);

    public static final native boolean WordList_unloadAllLists(long var0, WordList var2);

    public static final native boolean WordList_setFilterMode(long var0, WordList var2, int var3);

    public static final native int WordList_getFilterMode(long var0, WordList var2);

    public static final native boolean WordList_addWordToFilterListU(long var0, WordList var2, short[] var3);

    public static final native boolean WordList_removeWordFromFilterListU(long var0, WordList var2, short[] var3);

    public static final native boolean WordList_clearFilterList(long var0, WordList var2);

    public static final native boolean WordList_loadFilterList(long var0, WordList var2, String var3, int var4);

    public static final native int WordList_getFilterListWordCount(long var0, WordList var2);

    public static final native short[] WordList_getFilterListWordU(long var0, WordList var2, int var3);

    public static final native void delete_WordList(long var0);

    public static final native long TextTracker_getClassType();

    public static final native boolean TextTracker_setRegionOfInterest(long var0, TextTracker var2, long var3, RectangleInt var5, long var6, RectangleInt var8, int var9);

    public static final native void TextTracker_getRegionOfInterest(long var0, TextTracker var2, long var3, RectangleInt var5, long var6, RectangleInt var8, int[] var9);

    public static final native long TextTracker_getWordList(long var0, TextTracker var2);

    public static final native void delete_TextTracker(long var0);

    public static final native long new_TrackableSource();

    public static final native void delete_TrackableSource(long var0);

    public static final native long TrackerManager_getInstance();

    public static final native long TrackerManager_initTracker(long var0, TrackerManager var2, long var3, Type var5);

    public static final native long TrackerManager_getTracker(long var0, TrackerManager var2, long var3, Type var5);

    public static final native boolean TrackerManager_deinitTracker(long var0, TrackerManager var2, long var3, Type var5);

    public static final native long TrackerManager_getStateUpdater(long var0, TrackerManager var2);

    public static final native void delete_TrackerManager(long var0);

    public static final native void UpdateCallback_Vuforia_onUpdate(long var0, UpdateCallback var2, long var3, State var5);

    public static final native long new_UpdateCallback();

    public static final native void delete_UpdateCallback(long var0);

    public static final native void UpdateCallback_director_connect(UpdateCallback var0, long var1, boolean var3, boolean var4);

    public static final native void UpdateCallback_change_ownership(UpdateCallback var0, long var1, boolean var3);

    public static final native long new_VideoBackgroundConfig();

    public static final native void VideoBackgroundConfig_Enabled_set(long var0, VideoBackgroundConfig var2, boolean var3);

    public static final native boolean VideoBackgroundConfig_Enabled_get(long var0, VideoBackgroundConfig var2);

    public static final native void VideoBackgroundConfig_Position_set(long var0, VideoBackgroundConfig var2, long var3, Vec2I var5);

    public static final native long VideoBackgroundConfig_Position_get(long var0, VideoBackgroundConfig var2);

    public static final native void VideoBackgroundConfig_Size_set(long var0, VideoBackgroundConfig var2, long var3, Vec2I var5);

    public static final native long VideoBackgroundConfig_Size_get(long var0, VideoBackgroundConfig var2);

    public static final native void VideoBackgroundConfig_Reflection_set(long var0, VideoBackgroundConfig var2, int var3);

    public static final native int VideoBackgroundConfig_Reflection_get(long var0, VideoBackgroundConfig var2);

    public static final native void delete_VideoBackgroundConfig(long var0);

    public static final native long VideoBackgroundTextureInfo_TextureSize_get(long var0, VideoBackgroundTextureInfo var2);

    public static final native long VideoBackgroundTextureInfo_ImageSize_get(long var0, VideoBackgroundTextureInfo var2);

    public static final native int VideoBackgroundTextureInfo_PixelFormat_get(long var0, VideoBackgroundTextureInfo var2);

    public static final native long new_VideoBackgroundTextureInfo();

    public static final native void delete_VideoBackgroundTextureInfo(long var0);

    public static final native boolean VirtualButton_setArea(long var0, VirtualButton var2, long var3, Area var5);

    public static final native long VirtualButton_getArea(long var0, VirtualButton var2);

    public static final native boolean VirtualButton_setSensitivity(long var0, VirtualButton var2, int var3);

    public static final native boolean VirtualButton_setEnabled(long var0, VirtualButton var2, boolean var3);

    public static final native boolean VirtualButton_isEnabled(long var0, VirtualButton var2);

    public static final native String VirtualButton_getName(long var0, VirtualButton var2);

    public static final native int VirtualButton_getID(long var0, VirtualButton var2);

    public static final native long VirtualButtonResult_getVirtualButton(long var0, VirtualButtonResult var2);

    public static final native boolean VirtualButtonResult_isPressed(long var0, VirtualButtonResult var2);

    public static final native long Word_getClassType();

    public static final native short[] Word_getStringU(long var0, Word var2);

    public static final native int Word_getLength(long var0, Word var2);

    public static final native int Word_getNumCodeUnits(long var0, Word var2);

    public static final native long Word_getSize(long var0, Word var2);

    public static final native long Word_getMask(long var0, Word var2);

    public static final native long Word_getLetterBoundingBox(long var0, Word var2, int var3);

    public static final native void delete_Word(long var0);

    public static final native long WordResult_getClassType();

    public static final native long WordResult_getTrackable(long var0, WordResult var2);

    public static final native long WordResult_getObb(long var0, WordResult var2);

    public static final native void delete_WordResult(long var0);

    public static final native long VuMarkTemplate_getClassType();

    public static final native String VuMarkTemplate_getVuMarkUserData(long var0, VuMarkTemplate var2);

    public static final native void VuMarkTemplate_setTrackingFromRuntimeAppearance(long var0, VuMarkTemplate var2, boolean var3);

    public static final native boolean VuMarkTemplate_isTrackingFromRuntimeAppearanceEnabled(long var0, VuMarkTemplate var2);

    public static final native long VuMarkTemplate_getOrigin(long var0, VuMarkTemplate var2);

    public static final native void delete_VuMarkTemplate(long var0);

    public static final native ByteBuffer InstanceId_getBuffer(long var0, InstanceId var2);

    public static final native long InstanceId_getLength(long var0, InstanceId var2);

    public static final native BigInteger InstanceId_getNumericValue(long var0, InstanceId var2);

    public static final native int InstanceId_getDataType(long var0, InstanceId var2);

    public static final native void delete_InstanceId(long var0);

    public static final native long VuMarkTarget_getClassType();

    public static final native long VuMarkTarget_getTemplate(long var0, VuMarkTarget var2);

    public static final native long VuMarkTarget_getInstanceId(long var0, VuMarkTarget var2);

    public static final native long VuMarkTarget_getInstanceImage(long var0, VuMarkTarget var2);

    public static final native void delete_VuMarkTarget(long var0);

    public static final native long VuMarkTargetResult_getClassType();

    public static final native long VuMarkTargetResult_getTrackable(long var0, VuMarkTargetResult var2);

    public static final native int VuMarkTargetResult_getId(long var0, VuMarkTargetResult var2);

    public static final native void delete_VuMarkTargetResult(long var0);

    public static final native long Tool_convertPose2GLMatrix(long var0, Matrix34F var2);

    public static final native long Tool_convert2GLMatrix(long var0, Matrix34F var2);

    public static final native long Tool_convertPerspectiveProjection2GLMatrix(long var0, Matrix34F var2, float var3, float var4);

    public static final native long Tool_getProjectionGL(long var0, CameraCalibration var2, float var3, float var4);

    public static final native long Tool_projectPoint(long var0, CameraCalibration var2, long var3, Matrix34F var5, long var6, Vec3F var8);

    public static final native long Tool_multiply__SWIG_0(long var0, Matrix34F var2, long var3, Matrix34F var5);

    public static final native long Tool_multiply__SWIG_1(long var0, Matrix44F var2, long var3, Matrix44F var5);

    public static final native long Tool_multiply__SWIG_2(long var0, Vec4F var2, long var3, Matrix44F var5);

    public static final native long Tool_multiplyGL(long var0, Matrix44F var2, long var3, Matrix44F var5);

    public static final native void Tool_setTranslation(long var0, Matrix34F var2, long var3, Vec3F var5);

    public static final native void Tool_setRotation(long var0, Matrix34F var2, long var3, Vec3F var5, float var6);

    public static final native long new_Tool();

    public static final native void delete_Tool(long var0);

    public static final native long SmartTerrainTrackable_SWIGUpcast(long var0);

    public static final native long ObjectTarget_SWIGUpcast(long var0);

    public static final native long ObjectTargetResult_SWIGUpcast(long var0);

    public static final native long CylinderTarget_SWIGUpcast(long var0);

    public static final native long CylinderTargetResult_SWIGUpcast(long var0);

    public static final native long CustomViewerParameters_SWIGUpcast(long var0);

    public static final native long EyewearDevice_SWIGUpcast(long var0);

    public static final native long ImageTarget_SWIGUpcast(long var0);

    public static final native long ImageTargetResult_SWIGUpcast(long var0);

    public static final native long ObjectTracker_SWIGUpcast(long var0);

    public static final native long Marker_SWIGUpcast(long var0);

    public static final native long MarkerResult_SWIGUpcast(long var0);

    public static final native long MarkerTracker_SWIGUpcast(long var0);

    public static final native long MultiTarget_SWIGUpcast(long var0);

    public static final native long MultiTargetResult_SWIGUpcast(long var0);

    public static final native long Rectangle_SWIGUpcast(long var0);

    public static final native long RectangleInt_SWIGUpcast(long var0);

    public static final native long GLTextureData_SWIGUpcast(long var0);

    public static final native long GLTextureUnit_SWIGUpcast(long var0);

    public static final native long Surface_SWIGUpcast(long var0);

    public static final native long ReconstructionFromTarget_SWIGUpcast(long var0);

    public static final native long Prop_SWIGUpcast(long var0);

    public static final native long PropResult_SWIGUpcast(long var0);

    public static final native long SurfaceResult_SWIGUpcast(long var0);

    public static final native long HandheldTransformModel_SWIGUpcast(long var0);

    public static final native long HeadTransformModel_SWIGUpcast(long var0);

    public static final native long DeviceTrackable_SWIGUpcast(long var0);

    public static final native long DeviceTrackableResult_SWIGUpcast(long var0);

    public static final native long DeviceTracker_SWIGUpcast(long var0);

    public static final native long RotationalDeviceTracker_SWIGUpcast(long var0);

    public static final native long SmartTerrainTracker_SWIGUpcast(long var0);

    public static final native long WordList_SWIGUpcast(long var0);

    public static final native long TextTracker_SWIGUpcast(long var0);

    public static final native long Word_SWIGUpcast(long var0);

    public static final native long WordResult_SWIGUpcast(long var0);

    public static final native long VuMarkTemplate_SWIGUpcast(long var0);

    public static final native long VuMarkTarget_SWIGUpcast(long var0);

    public static final native long VuMarkTargetResult_SWIGUpcast(long var0);

    public static void SwigDirector_UpdateCallback_Vuforia_onUpdate(UpdateCallback self, long state) {
        self.Vuforia_onUpdate(new State(state, false));
    }

    private static final native void swig_module_init();

    static {
        VuforiaJNI.swig_module_init();
    }
}

