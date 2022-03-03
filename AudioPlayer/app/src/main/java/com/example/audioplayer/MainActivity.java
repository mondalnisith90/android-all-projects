package com.example.audioplayer;

import android.Manifest;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String []songsName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       listView=(ListView)findViewById(R.id.listview);
      // displaySongsInListView();
      // findAllAudioSongs(Environment.getExternalStorageDirectory());
       permission();





    }




    public  void permission()
    {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        //findAllAudioSongs(Environment.getExternalStorageDirectory());
                          displaySongsInListView();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();

                    }
                }).check();
    }

    public ArrayList<File> findAllAudioSongs(File file)
    {
        ArrayList<File> arrayList=new ArrayList<File>();
        File []allFile=file.listFiles();
        for(File randomFile : allFile)
        {
            if (randomFile.isDirectory() && !randomFile.isHidden())
            {
                arrayList.addAll(findAllAudioSongs(randomFile));
            }
            else if (randomFile.getName().endsWith(".mp3"))
            {
                arrayList.add(randomFile);
            }
        }
        return arrayList;
    }

    public void  displaySongsInListView()
    {
        final ArrayList<File> allAudioSongs=findAllAudioSongs(Environment.getExternalStorageDirectory());
        songsName=new String[allAudioSongs.size()];
        for (int i = 0; i < allAudioSongs.size(); i++)
        {
            songsName[i]=allAudioSongs.get(i).getName();
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songsName);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+allAudioSongs.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}































