package com.example.audioplayer;

import android.Manifest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PlayMusic extends AppCompatActivity {
    private Button start,stop,play;
    private TextView tv1;
    private SeekBar seekBar;
    static MediaPlayer mediaPlayer;
    private ListView listView;
    private String []songsName;
    ArrayList<File> allsong;
    private MilliTime milliTime;
    private int stop_thread=1;
    private int update_seekbar=0;



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       // stop_thread=0;
        //outState.putInt("CURRENT_POSITION",mediaPlayer.getCurrentPosition());
        //outState.putString("TIME",milliTime.getTime(mediaPlayer.getCurrentPosition()));
        // mediaPlayer.stop();
         //mediaPlayer.release();
        //Toast.makeText(this, "onSaveInstanceState() is called ", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        start=(Button)findViewById(R.id.next_button);
        stop=(Button)findViewById(R.id.previous_button);
        tv1=(TextView)findViewById(R.id.text_view1);
        play=(Button)findViewById(R.id.play_button);
        seekBar=(SeekBar)findViewById(R.id.seekbar);
        tv1.setSelected(true);
        milliTime =new MilliTime();
            mediaPlayer=new MediaPlayer();
        if(savedInstanceState!=null)
        {
            update_seekbar=savedInstanceState.getInt("CURRENT_POSITION");

            //Toast.makeText(this, "SEEK BAR IS SETTED"+x, Toast.LENGTH_LONG).show();
        }









        permission();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t1=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        seekBar.setMax(mediaPlayer.getDuration());
                        int duration=mediaPlayer.getDuration()/1000;
                        int current=mediaPlayer.getCurrentPosition()/1000;
                        while (current<duration)
                        {
                            final int mycurrent=current;
                            final String time=milliTime.getTime(mycurrent*1000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv1.setText(" "+ time);
                                    seekBar.setProgress(mycurrent*1000);
                                }
                            });
                            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                                }

                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {

                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                  mediaPlayer.seekTo(seekBar.getProgress());

                                }
                            });
                            SystemClock.sleep(1000);
                            current=mediaPlayer.getCurrentPosition()/1000;
                            if(stop_thread==0)
                            {
                                break;
                            }
                        }

                    }
                });
                t1.start();


            }
        });




    }


    public  void permission()
    {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        //findAllAudioSongs(Environment.getExternalStorageDirectory());
                        //displaySongsInListView();
                         allsong=findAllAudioSongs(Environment.getExternalStorageDirectory());

                        try {
                            mediaPlayer.setDataSource(allsong.get(0).toString());
                            mediaPlayer.prepare();
                            if(!mediaPlayer.isPlaying())
                            {
                                mediaPlayer.start();
                                Toast.makeText(PlayMusic.this, "Media player is again started", Toast.LENGTH_SHORT).show();
                            }
                         // mediaPlayer.seekTo(update_seekbar);
                            //Toast.makeText(PlayMusic.this, "AFTER START", Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        stop.setOnClickListener(new View.OnClickListener()

                            {
                                @Override
                                public void onClick (View v){
                                if (mediaPlayer.isPlaying()) {
                                    stop_thread=0;
                                    mediaPlayer.stop();
                                    mediaPlayer.release();
                                }

                            }
                            });


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
                Toast.makeText(PlayMusic.this, ""+allAudioSongs.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }



}
