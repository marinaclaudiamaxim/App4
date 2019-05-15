package com.example.app4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class TheService extends Service {

    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID) {
        Toast.makeText( TheService.this, "Service started", Toast.LENGTH_LONG ).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        Toast.makeText( TheService.this, "Service destroyed", Toast.LENGTH_LONG ).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
