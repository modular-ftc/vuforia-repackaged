/*
 * Decompiled with CFR 0_132.
 */
package com.vuforia;

public class Tool {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Tool(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    public Tool() {
        this(VuforiaJNI.new_Tool(), true);
    }

    protected static long getCPtr(Tool obj) {
        return obj == null ? 0L : obj.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                VuforiaJNI.delete_Tool(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public static Matrix44F convertPose2GLMatrix(Matrix34F pose) {
        return new Matrix44F(VuforiaJNI.Tool_convertPose2GLMatrix(Matrix34F.getCPtr(pose), pose), true);
    }

    public static Matrix44F convert2GLMatrix(Matrix34F matrix34F) {
        return new Matrix44F(VuforiaJNI.Tool_convert2GLMatrix(Matrix34F.getCPtr(matrix34F), matrix34F), true);
    }

    public static Matrix44F convertPerspectiveProjection2GLMatrix(Matrix34F projection, float nearPlane, float farPlane) {
        return new Matrix44F(VuforiaJNI.Tool_convertPerspectiveProjection2GLMatrix(Matrix34F.getCPtr(projection), projection, nearPlane, farPlane), true);
    }

    public static Matrix44F getProjectionGL(CameraCalibration calib, float nearPlane, float farPlane) {
        return new Matrix44F(VuforiaJNI.Tool_getProjectionGL(CameraCalibration.getCPtr(calib), calib, nearPlane, farPlane), true);
    }

    public static Vec2F projectPoint(CameraCalibration calib, Matrix34F pose, Vec3F point) {
        return new Vec2F(VuforiaJNI.Tool_projectPoint(CameraCalibration.getCPtr(calib), calib, Matrix34F.getCPtr(pose), pose, Vec3F.getCPtr(point), point), true);
    }

    public static Matrix34F multiply(Matrix34F matLeft, Matrix34F matRight) {
        return new Matrix34F(VuforiaJNI.Tool_multiply__SWIG_0(Matrix34F.getCPtr(matLeft), matLeft, Matrix34F.getCPtr(matRight), matRight), true);
    }

    public static Matrix44F multiply(Matrix44F matLeft, Matrix44F matRight) {
        return new Matrix44F(VuforiaJNI.Tool_multiply__SWIG_1(Matrix44F.getCPtr(matLeft), matLeft, Matrix44F.getCPtr(matRight), matRight), true);
    }

    public static Vec4F multiply(Vec4F vec, Matrix44F mat) {
        return new Vec4F(VuforiaJNI.Tool_multiply__SWIG_2(Vec4F.getCPtr(vec), vec, Matrix44F.getCPtr(mat), mat), true);
    }

    public static Matrix44F multiplyGL(Matrix44F matLeft, Matrix44F matRight) {
        return new Matrix44F(VuforiaJNI.Tool_multiplyGL(Matrix44F.getCPtr(matLeft), matLeft, Matrix44F.getCPtr(matRight), matRight), true);
    }

    public static void setTranslation(Matrix34F pose, Vec3F translation) {
        VuforiaJNI.Tool_setTranslation(Matrix34F.getCPtr(pose), pose, Vec3F.getCPtr(translation), translation);
    }

    public static void setRotation(Matrix34F pose, Vec3F axis, float angle) {
        VuforiaJNI.Tool_setRotation(Matrix34F.getCPtr(pose), pose, Vec3F.getCPtr(axis), axis, angle);
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Tool) {
            equal = ((Tool) obj).swigCPtr == this.swigCPtr;
        }
        return equal;
    }
}

