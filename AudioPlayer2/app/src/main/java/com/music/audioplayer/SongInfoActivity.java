package com.music.audioplayer;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;

public class SongInfoActivity extends AppCompatActivity {

    private TextView title,fileName,fileLocation,fileSize,fileDateTime,artistName,album;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);
        title = findViewById(R.id.song_title);
         fileName = findViewById(R.id.file_name);
         fileLocation = findViewById(R.id.file_location);
          fileSize= findViewById(R.id.file_size);
          fileDateTime= findViewById(R.id.date_time);
          artistName=findViewById(R.id.artist);
          album=findViewById(R.id.album);
          title.setSelected(true);
        Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        String path=intent.getStringExtra("path");
        songInformation(path);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 16908332://For Back Button Press in Toolbar
            {
                finish();
                overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }

    private void songInformation(String path)
    {
        File file=new File(path);
        if (file.exists())
        {
            Song song=new Song();
            MediaMetadataRetriever mediaMetadataRetriever=new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(path);
            String Title=mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
            if (title!=null) {
                title.setText(Title);
            }
            else {
              title.setText(song.getFileName(file));
            }
            fileName.setText(song.getFileName(file));
            fileLocation.setText(path);
            fileSize.setText(song.getFileSize(file)+" MB");
            fileDateTime.setText(song.getFileDateTimeInfo(file));
            String artist_name=mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
            if (artist_name!=null) {
                artistName.setText(artist_name);
            }
            else {
                artistName.setText("UNKNOWN");
            }

            String Album=mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
            if (Album!=null) {
                album.setText(Album);
            }
            else{
                album.setText("UNKNOWN");
            }

        }
    }

}
