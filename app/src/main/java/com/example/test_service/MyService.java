package com.example.test_service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

/**
 * Created by 杨天宇 on 2016/7/19.
 */
public class MyService extends Service {
    private static final String TAG = "MyService";
    private DownloadBinder mBinder = new DownloadBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.sym_def_app_icon);
        builder.setContentTitle("Notification Title");
        builder.setContentText("Notification comes");
        Notification notification = builder.build();
        startForeground(1, notification);
        Log.i(TAG, "onCreate: onCreate executed");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: onDestroy executed");
        super.onDestroy();
    }

    public class DownloadBinder extends Binder {
        public void startDownload() {
            Log.i(TAG, "startDownload: startDownload executed");
        }

        public int getProgress() {
            Log.i(TAG, "getProgress: getProgress executed");
            return 0;
        }

    }
}
