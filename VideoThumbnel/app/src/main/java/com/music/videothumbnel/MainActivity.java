package com.music.videothumbnel;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ImageView imageThumbnel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageThumbnel=findViewById(R.id.image_thumbnel);
        String path="/storage/emulated/0/All/Nisith.mp4";
        File file=new File(path);
        Log.d("ABCD","is File Exist "+file.exists());
        Bitmap thumbnel;
        thumbnel= ThumbnailUtils.createVideoThumbnail(path, MediaStore.Video.Thumbnails.MICRO_KIND);
        imageThumbnel.setImageBitmap(thumbnel);
    }
}
