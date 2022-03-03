package com.music.patternlockapp;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())){

            Intent intent1 = new Intent(context,MyService.class);
            context.startService(intent1);

        }

    }
}
