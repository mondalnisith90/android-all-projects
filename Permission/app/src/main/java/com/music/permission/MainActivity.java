package com.music.permission;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{


    private ImageView imageThumbnel;
    String path,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageThumbnel=findViewById(R.id.image_thumbnel);
        String path="/storage/emulated/0/All/Nisith.mp4";
        File file=new File(path);
        Log.d("ABCD","is File Exist "+file.exists());
        pmp();
        Log.d("ABCD","name "+name);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

    private void pmp()
    {
        String []permission={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this,permission))
        {

        }
        else {
            EasyPermissions.requestPermissions(this,"Need Permission",123,permission);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

        MediaMetadataRetriever mmr=new MediaMetadataRetriever();
        Uri uri=Uri.parse(path);
        mmr.setDataSource(path);
        InputStream inputStream=null;
        if (mmr.getEmbeddedPicture()!=null)
        {
            inputStream=new ByteArrayInputStream(mmr.getEmbeddedPicture());
        }
        byte []data=mmr.getEmbeddedPicture();
        Bitmap bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
        Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
        imageThumbnel.setImageBitmap(bitmap);
//        String name=mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
//        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms))
        {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }
}
