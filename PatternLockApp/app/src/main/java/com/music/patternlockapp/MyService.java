package com.music.patternlockapp;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;

import java.io.FileDescriptor;
import java.util.List;

public class MyService extends Service {
//    @androidx.annotation.Nullable

    private MyService myService;



    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ABCD","onCreate() is Called");
        myService = this;

        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ActivityManager am = (ActivityManager) myService.getSystemService(ACTIVITY_SERVICE);
                    List<ActivityManager.RunningAppProcessInfo> taskInfo = am.getRunningAppProcesses();
                    Log.d("ABCD", "CURRENT Activity ::" + taskInfo.get(0).importance);
//                    ActivityManager.RunningAppProcessInfo
//                    ComponentName componentInfo = taskInfo.get(0);
//                    Log.d("ABCD", componentInfo.getClassName());
//
//                    if (taskInfo.get(0).topActivity.getPackageName().equals("com.android.dialer")){
////                        myService.startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                    }
                }
            }
        });
        thread.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("ABCD","onBind() is Called");
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("ABCD","onStartCommand() is Called");
//        PackageManager packageManager = getPackageManager();
//        List<ApplicationInfo> applicationInfos = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
//        for (int i=0;i<applicationInfos.size();i++){
//            Log.d("ABCD",""+applicationInfos.get(i).packageName);
//        }


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ABCD","onDestroy() is Called");
    }
}


/*


 ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
    List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
    Log.d("topActivity", "CURRENT Activity ::" + taskInfo.get(0).topActivity.getClassName());
    ComponentName componentInfo = taskInfo.get(0).topActivity;
    componentInfo.getPackageName();


*/
