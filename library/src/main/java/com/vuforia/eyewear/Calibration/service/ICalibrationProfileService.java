/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.vuforia.eyewear.Calibration.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICalibrationProfileService
extends IInterface {
    public int getMaxProfileCount() throws RemoteException;

    public int getUsedProfileCount() throws RemoteException;

    public boolean isProfileUsed(int var1) throws RemoteException;

    public int getActiveProfile() throws RemoteException;

    public boolean setActiveProfile(int var1) throws RemoteException;

    public String getProfileName(int var1) throws RemoteException;

    public boolean setProfileName(int var1, String var2) throws RemoteException;

    public float[] getCameraToEyePose(int var1, int var2) throws RemoteException;

    public float[] getEyeProjection(int var1, int var2) throws RemoteException;

    public boolean setCameraToEyePose(int var1, int var2, float[] var3) throws RemoteException;

    public boolean setEyeProjection(int var1, int var2, float[] var3) throws RemoteException;

    public boolean clearProfile(int var1) throws RemoteException;

    public static abstract class Stub
    extends Binder
    implements ICalibrationProfileService {
        private static final String DESCRIPTOR = "com.vuforia.eyewear.Calibration.service.ICalibrationProfileService";
        static final int TRANSACTION_getMaxProfileCount = 1;
        static final int TRANSACTION_getUsedProfileCount = 2;
        static final int TRANSACTION_isProfileUsed = 3;
        static final int TRANSACTION_getActiveProfile = 4;
        static final int TRANSACTION_setActiveProfile = 5;
        static final int TRANSACTION_getProfileName = 6;
        static final int TRANSACTION_setProfileName = 7;
        static final int TRANSACTION_getCameraToEyePose = 8;
        static final int TRANSACTION_getEyeProjection = 9;
        static final int TRANSACTION_setCameraToEyePose = 10;
        static final int TRANSACTION_setEyeProjection = 11;
        static final int TRANSACTION_clearProfile = 12;

        public Stub() {
            this.attachInterface((IInterface)this, DESCRIPTOR);
        }

        public static ICalibrationProfileService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterface != null && iInterface instanceof ICalibrationProfileService) {
                return (ICalibrationProfileService)iInterface;
            }
            return new Proxy(iBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
            switch (n) {
                case 1598968902: {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                case 1: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n3 = this.getMaxProfileCount();
                    parcel2.writeNoException();
                    parcel2.writeInt(n3);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n4 = this.getUsedProfileCount();
                    parcel2.writeNoException();
                    parcel2.writeInt(n4);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n5 = parcel.readInt();
                    boolean bl = this.isProfileUsed(n5);
                    parcel2.writeNoException();
                    parcel2.writeInt(bl ? 1 : 0);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n6 = this.getActiveProfile();
                    parcel2.writeNoException();
                    parcel2.writeInt(n6);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n7 = parcel.readInt();
                    boolean bl = this.setActiveProfile(n7);
                    parcel2.writeNoException();
                    parcel2.writeInt(bl ? 1 : 0);
                    return true;
                }
                case 6: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n8 = parcel.readInt();
                    String string = this.getProfileName(n8);
                    parcel2.writeNoException();
                    parcel2.writeString(string);
                    return true;
                }
                case 7: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n9 = parcel.readInt();
                    String string = parcel.readString();
                    boolean bl = this.setProfileName(n9, string);
                    parcel2.writeNoException();
                    parcel2.writeInt(bl ? 1 : 0);
                    return true;
                }
                case 8: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n10 = parcel.readInt();
                    int n11 = parcel.readInt();
                    float[] arrf = this.getCameraToEyePose(n10, n11);
                    parcel2.writeNoException();
                    parcel2.writeFloatArray(arrf);
                    return true;
                }
                case 9: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n12 = parcel.readInt();
                    int n13 = parcel.readInt();
                    float[] arrf = this.getEyeProjection(n12, n13);
                    parcel2.writeNoException();
                    parcel2.writeFloatArray(arrf);
                    return true;
                }
                case 10: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n14 = parcel.readInt();
                    int n15 = parcel.readInt();
                    float[] arrf = parcel.createFloatArray();
                    boolean bl = this.setCameraToEyePose(n14, n15, arrf);
                    parcel2.writeNoException();
                    parcel2.writeInt(bl ? 1 : 0);
                    return true;
                }
                case 11: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n16 = parcel.readInt();
                    int n17 = parcel.readInt();
                    float[] arrf = parcel.createFloatArray();
                    boolean bl = this.setEyeProjection(n16, n17, arrf);
                    parcel2.writeNoException();
                    parcel2.writeInt(bl ? 1 : 0);
                    return true;
                }
                case 12: {
                    parcel.enforceInterface(DESCRIPTOR);
                    int n18 = parcel.readInt();
                    boolean bl = this.clearProfile(n18);
                    parcel2.writeNoException();
                    parcel2.writeInt(bl ? 1 : 0);
                    return true;
                }
            }
            return super.onTransact(n, parcel, parcel2, n2);
        }

        private static class Proxy
        implements ICalibrationProfileService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public int getMaxProfileCount() throws RemoteException {
                int n;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    n = parcel2.readInt();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return n;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public int getUsedProfileCount() throws RemoteException {
                int n;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    n = parcel2.readInt();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return n;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public boolean isProfileUsed(int n) throws RemoteException {
                boolean bl;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcel.writeInt(n);
                    this.mRemote.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    bl = 0 != parcel2.readInt();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return bl;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public int getActiveProfile() throws RemoteException {
                int n;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    n = parcel2.readInt();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return n;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public boolean setActiveProfile(int n) throws RemoteException {
                boolean bl;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcel.writeInt(n);
                    this.mRemote.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    bl = 0 != parcel2.readInt();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return bl;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public String getProfileName(int n) throws RemoteException {
                String string;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcel.writeInt(n);
                    this.mRemote.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    string = parcel2.readString();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return string;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public boolean setProfileName(int n, String string) throws RemoteException {
                boolean bl;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcel.writeInt(n);
                    parcel.writeString(string);
                    this.mRemote.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    bl = 0 != parcel2.readInt();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return bl;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public float[] getCameraToEyePose(int n, int n2) throws RemoteException {
                float[] arrf;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcel.writeInt(n);
                    parcel.writeInt(n2);
                    this.mRemote.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    arrf = parcel2.createFloatArray();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return arrf;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public float[] getEyeProjection(int n, int n2) throws RemoteException {
                float[] arrf;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcel.writeInt(n);
                    parcel.writeInt(n2);
                    this.mRemote.transact(9, parcel, parcel2, 0);
                    parcel2.readException();
                    arrf = parcel2.createFloatArray();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return arrf;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public boolean setCameraToEyePose(int n, int n2, float[] arrf) throws RemoteException {
                boolean bl;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcel.writeInt(n);
                    parcel.writeInt(n2);
                    parcel.writeFloatArray(arrf);
                    this.mRemote.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    bl = 0 != parcel2.readInt();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return bl;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public boolean setEyeProjection(int n, int n2, float[] arrf) throws RemoteException {
                boolean bl;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcel.writeInt(n);
                    parcel.writeInt(n2);
                    parcel.writeFloatArray(arrf);
                    this.mRemote.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    bl = 0 != parcel2.readInt();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return bl;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public boolean clearProfile(int n) throws RemoteException {
                boolean bl;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcel.writeInt(n);
                    this.mRemote.transact(12, parcel, parcel2, 0);
                    parcel2.readException();
                    bl = 0 != parcel2.readInt();
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
                return bl;
            }
        }

    }

}

