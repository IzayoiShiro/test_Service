package com.example.test_service;

        import android.app.Activity;
        import android.content.ContentResolver;
        import android.content.ContentValues;
        import android.net.Uri;
        import android.os.Bundle;

public class MainActivity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver contentResolver = getContentResolver();
        Uri uri = Uri.parse("content://sms/");
        ContentValues values = new ContentValues();
        values.put("address", "10086");
        values.put("type", 1);
        values.put("date", System.currentTimeMillis());
        values.put("body", "妈的智障！！！");
        contentResolver.insert(uri, values);
//		new Thread() {
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(5000);
//					ContentResolver contentResolver = getContentResolver();
//					Uri uri = Uri.parse("content://sms/");
//					ContentValues values = new ContentValues();
//					values.put("address", "18865533398");
//					values.put("type", 1);
//					values.put("date", System.currentTimeMillis());
//					values.put("body", "贾小七你是SB");
//					contentResolver.insert(uri, values);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				super.run();
//			}
//		}.start();

    }

}
