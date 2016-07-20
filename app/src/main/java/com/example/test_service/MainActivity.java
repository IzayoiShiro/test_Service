package com.example.test_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import static com.example.test_service.R.id.start_intent_service;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button mStartService,mStopService,mBindService,mUnbindService,mStartIntentService;
    private static final String TAG = "MainActivity";
    private MyService.DownloadBinder mBinder;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mBinder = (MyService.DownloadBinder) iBinder;
            mBinder.startDownload();
            mBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartService = (Button) findViewById(R.id.startService);
        mStopService = (Button) findViewById(R.id.stopService);
        mStartService.setOnClickListener(this);
        mStopService.setOnClickListener(this);
        mBindService = (Button) findViewById(R.id.bindService);
        mUnbindService = (Button) findViewById(R.id.unbindService);
        mBindService.setOnClickListener(this);
        mUnbindService.setOnClickListener(this);
        mStartIntentService = (Button) findViewById(start_intent_service);
        mStartIntentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startService:
                Log.i(TAG, "onClick: StartService");
                Intent startIntent = new Intent(MainActivity.this,MyService.class);
                startService(startIntent);
                break;
            case R.id.stopService:
                Log.i(TAG, "onClick: StopService");
                Intent stopIntent = new Intent(MainActivity.this,MyService.class);
                stopService(stopIntent);
                break;
            case R.id.bindService:
                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent, mConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbindService:
                unbindService(mConnection);
                break;
            case R.id.start_intent_service:
                Log.i(TAG, "onClick: Thread id is "+Thread.currentThread().getId());
                Intent intentService = new Intent(this,MyIntentService.class);
                startService(intentService);
                break;
            default:
                break;
        }
    }
}
