package com.music.runtimepermission;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String permission[]={Manifest.permission.WRITE_SETTINGS};
    int requestCode=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_SETTINGS)!= PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,permission,requestCode);
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_SETTINGS)){
                AlertDialog.Builder builder=new AlertDialog.Builder(this)
                        .setTitle("Permission")
                        .setMessage("This Permission is neceaary to run this application")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                ActivityCompat.requestPermissions(MainActivity.this,permission,requestCode);
                            }
                        });
                builder.create().show();
//                ActivityCompat.requestPermissions(this,permission,requestCode);
            }else {

                ActivityCompat.requestPermissions(this,permission,requestCode);
            }
        }

        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Toast.makeText(this, "onRequestPermissionsResult() is Called", Toast.LENGTH_SHORT).show();
       // Toast.makeText(this, "Request Code="+requestCode+"  Permission="+permissions[1]+"  GrantResults="+grantResults[1], Toast.LENGTH_SHORT).show();

       boolean value = Settings.System.canWrite(getApplicationContext());
       Toast.makeText(getApplicationContext(),""+value,Toast.LENGTH_LONG).show();
        if (!value){
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            startActivity(intent);
        }
    }
}













