package android.app;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ContextImpl extends Context {
    @Override
    public AssetManager getAssets() {
        throw new RuntimeException("STUB");
    }

    @Override
    public Resources getResources() {
        throw new RuntimeException("STUB");
    }

    @Override
    public PackageManager getPackageManager() {
        throw new RuntimeException("STUB");
    }

    @Override
    public ContentResolver getContentResolver() {
        throw new RuntimeException("STUB");
    }

    @Override
    public Looper getMainLooper() {
        throw new RuntimeException("STUB");
    }

    @Override
    public Context getApplicationContext() {
        throw new RuntimeException("STUB");
    }

    @Override
    public void setTheme(int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public Resources.Theme getTheme() {
        throw new RuntimeException("STUB");
    }

    @Override
    public ClassLoader getClassLoader() {
        throw new RuntimeException("STUB");
    }

    @Override
    public String getPackageName() {
        throw new RuntimeException("STUB");
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        throw new RuntimeException("STUB");
    }

    @Override
    public String getPackageResourcePath() {
        throw new RuntimeException("STUB");
    }

    @Override
    public String getPackageCodePath() {
        throw new RuntimeException("STUB");
    }

    @Override
    public SharedPreferences getSharedPreferences(String s, int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public boolean moveSharedPreferencesFrom(Context context, String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public boolean deleteSharedPreferences(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public FileInputStream openFileInput(String s) throws FileNotFoundException {
        throw new RuntimeException("STUB");
    }

    @Override
    public FileOutputStream openFileOutput(String s, int i) throws FileNotFoundException {
        throw new RuntimeException("STUB");
    }

    @Override
    public boolean deleteFile(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getFileStreamPath(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getDataDir() {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getFilesDir() {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getNoBackupFilesDir() {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getExternalFilesDir(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public File[] getExternalFilesDirs(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getObbDir() {
        throw new RuntimeException("STUB");
    }

    @Override
    public File[] getObbDirs() {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getCacheDir() {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getCodeCacheDir() {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getExternalCacheDir() {
        throw new RuntimeException("STUB");
    }

    @Override
    public File[] getExternalCacheDirs() {
        throw new RuntimeException("STUB");
    }

    @Override
    public File[] getExternalMediaDirs() {
        throw new RuntimeException("STUB");
    }

    @Override
    public String[] fileList() {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getDir(String s, int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String s, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        throw new RuntimeException("STUB");
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String s, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        throw new RuntimeException("STUB");
    }

    @Override
    public boolean moveDatabaseFrom(Context context, String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public boolean deleteDatabase(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public File getDatabasePath(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public String[] databaseList() {
        throw new RuntimeException("STUB");
    }

    @Override
    public Drawable getWallpaper() {
        throw new RuntimeException("STUB");
    }

    @Override
    public Drawable peekWallpaper() {
        throw new RuntimeException("STUB");
    }

    @Override
    public int getWallpaperDesiredMinimumWidth() {
        throw new RuntimeException("STUB");
    }

    @Override
    public int getWallpaperDesiredMinimumHeight() {
        throw new RuntimeException("STUB");
    }

    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        throw new RuntimeException("STUB");
    }

    @Override
    public void setWallpaper(InputStream inputStream) throws IOException {
        throw new RuntimeException("STUB");
    }

    @Override
    public void clearWallpaper() throws IOException {
        throw new RuntimeException("STUB");
    }

    @Override
    public void startActivity(Intent intent) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void startActivity(Intent intent, Bundle bundle) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void startActivities(Intent[] intents) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void startActivities(Intent[] intents, Bundle bundle) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i1, int i2) throws IntentSender.SendIntentException {
        throw new RuntimeException("STUB");
    }

    @Override
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i1, int i2, Bundle bundle) throws IntentSender.SendIntentException {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendBroadcast(Intent intent) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendBroadcast(Intent intent, String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String s, BroadcastReceiver broadcastReceiver, Handler handler, int i, String s1, Bundle bundle) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String s, BroadcastReceiver broadcastReceiver, Handler handler, int i, String s1, Bundle bundle) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendStickyBroadcast(Intent intent) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String s, Bundle bundle) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void removeStickyBroadcast(Intent intent) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i, String s, Bundle bundle) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        throw new RuntimeException("STUB");
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        throw new RuntimeException("STUB");
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String s, Handler handler) {
        throw new RuntimeException("STUB");
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String s, Handler handler, int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        throw new RuntimeException("STUB");
    }

    @Override
    public ComponentName startService(Intent intent) {
        throw new RuntimeException("STUB");
    }

    @Override
    public ComponentName startForegroundService(Intent intent) {
        throw new RuntimeException("STUB");
    }

    @Override
    public boolean stopService(Intent intent) {
        throw new RuntimeException("STUB");
    }

    @Override
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void unbindService(ServiceConnection serviceConnection) {
        throw new RuntimeException("STUB");
    }

    @Override
    public boolean startInstrumentation(ComponentName componentName, String s, Bundle bundle) {
        throw new RuntimeException("STUB");
    }

    @Override
    public Object getSystemService(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public String getSystemServiceName(Class<?> aClass) {
        throw new RuntimeException("STUB");
    }

    @Override
    public int checkPermission(String s, int i, int i1) {
        throw new RuntimeException("STUB");
    }

    @Override
    public int checkCallingPermission(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public int checkCallingOrSelfPermission(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public int checkSelfPermission(String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void enforcePermission(String s, int i, int i1, String s1) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void enforceCallingPermission(String s, String s1) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void enforceCallingOrSelfPermission(String s, String s1) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void grantUriPermission(String s, Uri uri, int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void revokeUriPermission(Uri uri, int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void revokeUriPermission(String s, Uri uri, int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public int checkUriPermission(Uri uri, int i, int i1, int i2) {
        throw new RuntimeException("STUB");
    }

    @Override
    public int checkCallingUriPermission(Uri uri, int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int i) {
        throw new RuntimeException("STUB");
    }

    @Override
    public int checkUriPermission(Uri uri, String s, String s1, int i, int i1, int i2) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void enforceUriPermission(Uri uri, int i, int i1, int i2, String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void enforceCallingUriPermission(Uri uri, int i, String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String s) {
        throw new RuntimeException("STUB");
    }

    @Override
    public void enforceUriPermission(Uri uri, String s, String s1, int i, int i1, int i2, String s2) {
        throw new RuntimeException("STUB");
    }

    @Override
    public Context createPackageContext(String s, int i) throws PackageManager.NameNotFoundException {
        throw new RuntimeException("STUB");
    }

    @Override
    public Context createContextForSplit(String s) throws PackageManager.NameNotFoundException {
        throw new RuntimeException("STUB");
    }

    @Override
    public Context createConfigurationContext(Configuration configuration) {
        throw new RuntimeException("STUB");
    }

    @Override
    public Context createDisplayContext(Display display) {
        throw new RuntimeException("STUB");
    }

    @Override
    public Context createDeviceProtectedStorageContext() {
        throw new RuntimeException("STUB");
    }

    @Override
    public boolean isDeviceProtectedStorage() {
        throw new RuntimeException("STUB");
    }
}
