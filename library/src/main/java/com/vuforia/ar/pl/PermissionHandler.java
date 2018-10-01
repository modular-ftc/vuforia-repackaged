/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.app.FragmentTransaction
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.vuforia.ar.pl;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.ArrayList;

public class PermissionHandler {
    private static final String MODULENAME = "PermissionHandler";
    private static final int AR_PERMISSIONS_STATUS_FAILED = 0;
    private static final int AR_PERMISSIONS_STATUS_REQUESTED = 1;
    private static final int AR_PERMISSIONS_STATUS_DENIED = 2;
    private static final int AR_PERMISSIONS_STATUS_GRANTED = 3;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    private boolean mIsPermissionsRequested = false;
    private int mPermissionsStatus = 0;
    private String[] mPermissionsArrayToRequest;

    public int requestPermissions(Activity activity, String[] arrstring) {
        if (this.mPermissionsStatus == 3 || this.mPermissionsStatus == 1 || this.mPermissionsStatus == 2) {
            return this.mPermissionsStatus;
        }
        if (activity == null) {
            return 0;
        }
        PackageManager packageManager = activity.getPackageManager();
        ArrayList<String> arrayList = new ArrayList<String>(arrstring.length);
        for (int i = 0; i < arrstring.length; ++i) {
            if (packageManager.checkPermission(arrstring[i], activity.getPackageName()) == 0) continue;
            arrayList.add(arrstring[i]);
        }
        if (arrayList.isEmpty()) {
            this.mPermissionsStatus = 3;
        }
        if (Build.VERSION.SDK_INT >= 23 && !this.mIsPermissionsRequested && !arrayList.isEmpty()) {
            try {
                FragmentManager fragmentManager = activity.getFragmentManager();
                this.mPermissionsArrayToRequest = arrayList.toArray(new String[arrayList.size()]);
                PermissionsRequestFragment permissionsRequestFragment = new PermissionsRequestFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(0, (Fragment)permissionsRequestFragment);
                fragmentTransaction.commit();
                this.mPermissionsStatus = 1;
            }
            catch (Exception exception) {
                return 0;
            }
        }
        return this.mPermissionsStatus;
    }

    public class PermissionsRequestFragment
    extends Fragment {
        public void onStart() {
            super.onStart();
            if (!PermissionHandler.this.mIsPermissionsRequested) {
                this.requestPermissions(PermissionHandler.this.mPermissionsArrayToRequest, 100);
                PermissionHandler.this.mIsPermissionsRequested = true;
            }
        }

        private void removeSelf() {
            FragmentManager fragmentManager = this.getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove((Fragment)this);
            fragmentTransaction.commit();
        }

        public void onRequestPermissionsResult(int n, String[] arrstring, int[] arrn) {
            if (n != 100) {
                return;
            }
            for (int i = 0; i < arrn.length; ++i) {
                if (arrn[i] != -1) continue;
                PermissionHandler.this.mPermissionsStatus = 2;
                break;
            }
            if (PermissionHandler.this.mPermissionsStatus != 2) {
                PermissionHandler.this.mPermissionsStatus = 3;
            }
            this.removeSelf();
        }
    }

}

