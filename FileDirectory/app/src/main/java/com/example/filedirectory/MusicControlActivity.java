package com.example.filedirectory;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.filedirectory.R.*;

public class MusicControlActivity extends AppCompatActivity {
    private Button playButton,nextButton,previousButton;
    private SeekBar seekBar;
    private TextView songTitle,leftTimmer,rightTimmer;
    private ServiceConnection connection;
    private ForegroundService foregroundService=null;
    private ForegroundService.MyBinder myBinder;
    private boolean stop_thread=false;
    private int store_seekbar_position;
    private String store_left_timmer_value;
    private boolean check_connection=false;
    private int previous_activity_play_pause_icon= R.drawable.pause;
    private String previous_activity_song_name;
    private CalculateTime time=new CalculateTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_control);
        songTitle=(TextView)findViewById(R.id.song_title);
        playButton=(Button)findViewById(R.id.play_button) ;
        nextButton=(Button)findViewById(R.id.next_button) ;
        previousButton=(Button)findViewById(R.id.previous_button) ;
        seekBar=(SeekBar)findViewById(R.id.seekbar);
        leftTimmer=(TextView)findViewById(id.left_timmer);
        rightTimmer=(TextView)findViewById(id.right_timmer);
        connection=new MyServiceConnection();
        Intent bind_intent=new Intent(getApplicationContext(),ForegroundService.class);
        bindService(bind_intent,connection,BIND_AUTO_CREATE);





        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foregroundService!=null)
                {
                    if(foregroundService.musicIsPlaying())
                    {
                        foregroundService.pauseMusic();
                        playButton.setBackgroundResource(R.drawable.play);
                    }
                    else
                    {
                        foregroundService.setSeekTo(store_seekbar_position);
                        foregroundService.remuseMusic();
                        playButton.setBackgroundResource(R.drawable.pause);

                    }
                }
            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(foregroundService!=null)
                {
                    foregroundService.playNextSong();
                    playButton.setBackgroundResource(drawable.pause);
                    check_connection=true;
                }
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(foregroundService!=null)
                {
                    foregroundService.playPreviousSong();
                    playButton.setBackgroundResource(drawable.pause);
                    check_connection=true;
                }
            }
        });
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(check_connection)
        {
            foregroundService.saveSeekbarPosition(store_seekbar_position);
            foregroundService.savedLeftTimmerValue(store_left_timmer_value);
            foregroundService.setActivityExistance(false);
            stop_thread=true;
            foregroundService=null;
            myBinder=null;
            unbindService(connection);
        }
    }


    public class MyServiceConnection implements ServiceConnection
    {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder= (ForegroundService.MyBinder) service;
            foregroundService=myBinder.getForgroundService();
            songTitle.setSelected(true);
            check_connection=true;
            foregroundService.setActivityExistance(true);
            seekBar.setMax(foregroundService.getCurrentSongDuration());
            seekBar.setProgress(foregroundService.getSavedSeekbarPosition());
            store_seekbar_position=foregroundService.getSavedSeekbarPosition();
            rightTimmer.setText(time.getTime(foregroundService.getCurrentSongDuration()));
            leftTimmer.setText(foregroundService.getSavedLeftTimmerValue());
            store_left_timmer_value=foregroundService.getSavedLeftTimmerValue();//doubt
           songTitle.setText(foregroundService.getCurrentSongName());
           songTitle.setSelected(true);
            Thread thread=new Thread(new MyThread());
           thread.start();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    public class MyThread implements Runnable
    {
        CalculateTime calculateTime=new CalculateTime();
        String timmer;

        @Override
        public void run() {

            Log.d("ABCDE","Thread is Started;");
            while (true) {

               if(foregroundService.getServiceStatus())
               {
                   stop_thread=true;  ///it's not necessary. but for good programming pratics
                   finish();
               }
                if(foregroundService.musicIsPlaying())
                {
                    seekBar.setMax(foregroundService.getCurrentSongDuration());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run()
                        {
                            playButton.setBackgroundResource(R.drawable.pause);
                            seekBar.setProgress(foregroundService.getCurrentSongPosition());
                            if(foregroundService.getCurrentSongPosition()<=1500)   ////1500 is in milliSecond in this case
                            {
                                songTitle.setText(foregroundService.getCurrentSongName());
                                songTitle.setSelected(true);
                            }
                            rightTimmer.setText(calculateTime.getTime(foregroundService.getCurrentSongDuration()));
                            timmer=calculateTime.getTime(foregroundService.getCurrentSongPosition());
                            leftTimmer.setText(timmer);
                            rightTimmer.setText(calculateTime.getTime(foregroundService.getCurrentSongDuration()));
                        }
                    });
                    store_seekbar_position=seekBar.getProgress();
                    store_left_timmer_value=timmer;

                }
                else
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            playButton.setBackgroundResource(R.drawable.play);
                        }
                    });
                }




                    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {    // Every time listener is Attached this is not a Efficient Way
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(final SeekBar seekBar) {

                        store_seekbar_position=seekBar.getProgress();
                        store_left_timmer_value= (String) leftTimmer.getText();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                leftTimmer.setText(calculateTime.getTime(seekBar.getProgress()));
                            }
                        });
                        if(foregroundService.musicIsPlaying())
                        {
                            foregroundService.setSeekTo(seekBar.getProgress());
                        }
                    }
                });
                SystemClock.sleep(800);
                if(stop_thread)
                {
                    break;
                }


            }

        }

    }


}























