package com.example.app4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        if (Intent.ACTION_BOOT_COMPLETED.equals( intent.getAction() )) {
            Toast.makeText( context, "Boot completed", Toast.LENGTH_LONG ).show();
        }

        if(ConnectivityManager.CONNECTIVITY_ACTION.equals( intent.getAction() )) {
            Toast.makeText( context, "Connectivity changed", Toast.LENGTH_SHORT ).show();
        }
    }
}