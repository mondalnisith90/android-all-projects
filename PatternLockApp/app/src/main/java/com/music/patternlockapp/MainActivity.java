package com.music.patternlockapp;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PatternLockView patternLockView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        patternLockView = findViewById(R.id.pattern_lock_view);
        patternLockView.addPatternLockListener(new MyPatternLockView());

//        PackageManager packageManager = getPackageManager();
//        List<ApplicationInfo> applicationInfos = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
//        for (int i=0;i<applicationInfos.size();i++){
//            Log.d("ABCD",""+applicationInfos.get(i).packageName);
//        }

    }



    private class MyPatternLockView implements PatternLockViewListener
    {

        @Override
        public void onStarted() {

        }

        @Override
        public void onProgress(List<PatternLockView.Dot> progressPattern) {

        }

        @Override
        public void onComplete(List<PatternLockView.Dot> pattern) {
            if(PatternLockUtils.patternToString(patternLockView,pattern).equalsIgnoreCase("246308")){

                //apply bind Service to unlock lock
                //game lock pattern
                finish();
            }else {
                Toast.makeText(getApplicationContext(),"Incorrect Pattern",Toast.LENGTH_SHORT).show();
                SystemClock.sleep(100);
                patternLockView.clearPattern();
            }
        }

        @Override
        public void onCleared() {

        }
    }

}




  /*  final PackageManager pm = getPackageManager();
    //get a list of installed apps.
    List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

for (ApplicationInfo packageInfo : packages) {
        Log.d(TAG, "Installed package :" + packageInfo.packageName);
        Log.d(TAG, "Source dir : " + packageInfo.sourceDir);
        */

















