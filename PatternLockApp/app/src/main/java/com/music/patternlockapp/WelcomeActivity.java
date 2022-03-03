package com.music.patternlockapp;

import android.app.KeyguardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private int INTENT_AUTHENTICATE=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = new Intent(WelcomeActivity.this,MyService.class);
//        startService(intent);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!Settings.canDrawOverlays(getApplicationContext())) {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                    startActivityForResult(intent,0);
                }
            }
        });

        Button button_lock = findViewById(R.id.button_lock);
        button_lock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    KeyguardManager km = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

                    Log.d("ABC","value of km "+km.isKeyguardSecure());
//                    if (km.isKeyguardSecure()) {
                        Log.d("ABC","Condition is True");
                        Intent authIntent = km.createConfirmDeviceCredentialIntent("Title", "This is a Message");
                        startActivityForResult(authIntent, INTENT_AUTHENTICATE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == INTENT_AUTHENTICATE) {
            if (resultCode == RESULT_OK) {
                //do something you want when pass the security
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
