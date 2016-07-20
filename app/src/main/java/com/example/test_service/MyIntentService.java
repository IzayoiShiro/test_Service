package com.example.test_service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 杨天宇 on 2016/7/20.
 */
public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // 打印当前线程的ID
        Log.i(TAG, "onHandleIntent: Thread id is " + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: onDestroy executed");
    }
}
