/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.pm.PackageManager
 *  android.content.res.AssetManager
 *  android.os.Environment
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.File;

public class FileTools {
    private static final int FILE_PATHTYPEINDEX_ABSOLUTE = -1;
    private static final int FILE_PATHTYPEINDEX_ANDROID_ASSETS = 0;
    private static final int FILE_PATHTYPEINDEX_ANDROID_PRIVATEAPPSTORAGE = 1;
    private static final int FILE_PATHTYPEINDEX_ANDROID_PRIVATEAPPCACHE = 2;
    private static final int FILE_PATHTYPEINDEX_ANDROID_MEDIASTORAGE = 3;
    private static final int FILE_PATHTYPEINDEX_ANDROID_DATALOCAL = 4;
    private static final int AR_FILE_POS_START = 0;
    private static final int AR_FILE_POS_CURRENT = 1;
    private static final int AR_FILE_POS_END = 2;
    private static final String MODULENAME = "FileTools";

    public static String getAbsolutePath(int pathTypeIndex, String relativePath) {
        String basePath = null;
        switch (pathTypeIndex) {
            case 1: {
                Activity activity = SystemTools.getActivityFromNative();
                if (activity == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                File fileDir = activity.getFilesDir();
                if (fileDir == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                basePath = fileDir.getAbsolutePath();
                break;
            }
            case 2: {
                Activity activity = SystemTools.getActivityFromNative();
                if (activity == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                File cacheDir = activity.getCacheDir();
                if (cacheDir == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                basePath = cacheDir.getAbsolutePath();
                break;
            }
            case 3: {
                File externalStorageDir = Environment.getExternalStorageDirectory();
                if (externalStorageDir == null) {
                    SystemTools.setSystemErrorCode(6);
                    return null;
                }
                basePath = externalStorageDir.getAbsolutePath();
                break;
            }
            default: {
                SystemTools.setSystemErrorCode(6);
                return null;
            }
        }
        if (basePath != null && relativePath != null) {
            if (basePath.length() > 0 && basePath.charAt(basePath.length() - 1) != '/') {
                basePath = basePath + "/";
            }
            basePath = basePath + relativePath;
        }
        return basePath;
    }

    public static boolean mediastorage_isAvailable() {
        String state = Environment.getExternalStorageState();
        return "mounted".equals(state) || "mounted_ro".equals(state);
    }

    public static boolean mediastorage_checkPermission() {
        try {
            Activity activity = SystemTools.getActivityFromNative();
            if (activity == null) {
                return false;
            }
            PackageManager pm = activity.getPackageManager();
            int isPermissionGranted = pm.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", activity.getPackageName());
            if (isPermissionGranted == 0) {
                return true;
            }
        }
        catch (Exception activity) {
            // empty catch block
        }
        return false;
    }

    public static AssetManager get_assetmanager() {
        Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        return activity.getAssets();
    }

    public static boolean asset_exists(String relativePath) {
        Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            return false;
        }
        AssetManager am = activity.getAssets();
        String[] listOfFiles = null;
        File relativePathFile = new File(relativePath);
        String pathOnly = relativePathFile.getParent();
        String fileNameOnly = relativePathFile.getName();
        try {
            listOfFiles = am.list(pathOnly == null ? "" : pathOnly);
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        int listLength = listOfFiles != null ? listOfFiles.length : 0;
        for (int i = 0; i < listLength; ++i) {
            if (listOfFiles[i].compareTo(fileNameOnly) != 0) continue;
            return true;
        }
        return false;
    }

    public static Object asset_open(String relativePath) {
        AssetFileInfo assetFileInfo = new AssetFileInfo();
        assetFileInfo.fileStream = null;
        assetFileInfo.relativePath = relativePath;
        assetFileInfo.filePos = 0;
        try {
            AssetManager am = SystemTools.getActivityFromNative().getAssets();
            assetFileInfo.fileStream = new BufferedInputStream(am.open(relativePath, 3), 8192);
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        return assetFileInfo;
    }

    public static boolean asset_close(Object fileObj) {
        try {
            AssetFileInfo assetFileInfo = (AssetFileInfo)fileObj;
            assetFileInfo.fileStream.close();
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        return true;
    }

    public static byte[] asset_read(Object fileObj, int bytesToRead) {
        byte[] buffer = null;
        try {
            AssetFileInfo assetFileInfo = (AssetFileInfo)fileObj;
            int availableBufferLength = assetFileInfo.fileStream.available();
            int bufferLengthToRead = availableBufferLength < bytesToRead ? availableBufferLength : bytesToRead;
            buffer = new byte[bufferLengthToRead];
            int bytesRead = assetFileInfo.fileStream.read(buffer, 0, bufferLengthToRead);
            assetFileInfo.filePos += (long)bytesRead;
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
            return null;
        }
        return buffer;
    }

    public static boolean asset_isEOF(Object fileObj) {
        int numBytesAvailable = 0;
        try {
            AssetFileInfo assetFileInfo = (AssetFileInfo)fileObj;
            numBytesAvailable = assetFileInfo.fileStream.available();
        }
        catch (Exception e) {
            SystemTools.setSystemErrorCode(6);
        }
        return numBytesAvailable == 0;
    }

    public static boolean asset_setPosition(Object fileObj, long offset, int origin) {
        AssetFileInfo assetFileInfo = (AssetFileInfo)fileObj;
        if (offset < 0) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        switch (origin) {
            case 0: {
                try {
                    assetFileInfo.fileStream.close();
                }
                catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
                try {
                    AssetManager am = SystemTools.getActivityFromNative().getAssets();
                    assetFileInfo.fileStream = new BufferedInputStream(am.open(assetFileInfo.relativePath, 3), 8192);
                    assetFileInfo.filePos = 0;
                    break;
                }
                catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            }
            case 1: {
                break;
            }
            case 2: {
                try {
                    int bytesAvailable = assetFileInfo.fileStream.available();
                    while (bytesAvailable != 0) {
                        long skipped = assetFileInfo.fileStream.skip(bytesAvailable);
                        assetFileInfo.filePos += skipped;
                        bytesAvailable = assetFileInfo.fileStream.available();
                    }
                    break;
                }
                catch (Exception e) {
                    SystemTools.setSystemErrorCode(6);
                    return false;
                }
            }
            default: {
                SystemTools.setSystemErrorCode(3);
                return false;
            }
        }
        if (offset != 0) {
            long skippedTotal = 0;
            try {
                long skipped;
                do {
                    skipped = assetFileInfo.fileStream.skip(offset - skippedTotal);
                    assetFileInfo.filePos += skipped;
                } while ((skippedTotal += skipped) < offset && assetFileInfo.fileStream.available() != 0);
            }
            catch (Exception e) {
                SystemTools.setSystemErrorCode(6);
                return false;
            }
        }
        return true;
    }

    public static long asset_getPosition(Object fileObj) {
        AssetFileInfo assetFileInfo = (AssetFileInfo)fileObj;
        return assetFileInfo.filePos;
    }

    public static class AssetFileInfo {
        String relativePath;
        BufferedInputStream fileStream;
        long filePos;
    }

}

