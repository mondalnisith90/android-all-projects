package com.example.filedirectory;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class ForegroundService extends Service {

    IBinder iBinder=new MyBinder();
    MediaPlayer mediaPlayer;
    String []all_song_path;
    String []all_song_name;
    int current_song_position;
    private int saved_seekbar_position;
    private String left_timmer_value;
    private Notification notification;
    private NotificationCompat.Builder notificationCompact;
    private final int previous_button_of_notification=30000;
    private final int play_pause_button_of_notification=30001;
    private final int next_button_of_notification=30002;
    private final int cancel_button_of_notification=30003;
    private final int come_from_activity=57080;
    private boolean destroy_service=false;
    private boolean is_Activity_exist=true;


    //@androidx.annotation.Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public class MyBinder extends Binder
    {
        public ForegroundService getForgroundService()
        {
            return ForegroundService.this;
        }
    }


    @Override
    public void onCreate() {
        mediaPlayer=null;
        all_song_path=null;
        all_song_name=null;
//        notification=getNotification("");
//        startForeground(7,notification);
        Log.d("ABCDE","onCreate() is Called");


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        Log.d("ABCDE","onStartCommand() is Called");

        if(all_song_name==null)
        {
//            Log.e("ABCDE","all_song_name is null");
            all_song_name=intent.getStringArrayExtra("all_song_name");
        }
        if (all_song_path==null)
        {
//            Log.e("ABCDE","all_song_path is null");
           all_song_path=intent.getStringArrayExtra("all_song_path");
        }
        if(intent.getIntExtra("come_from_activity",-79)==come_from_activity)
        {
            startMusic(intent.getIntExtra("position",0));
//            Log.d("ABCD","condition is true");
        }

        switch (intent.getIntExtra("come_from_notification",35463))
        {
            case previous_button_of_notification:
            {
                playPreviousSong();
                break;
            }

            case play_pause_button_of_notification:
            {
                if(musicIsPlaying())
                {
                    pauseMusic();
                    startForeground(7,getNotification(R.drawable.play,all_song_name[current_song_position]));
                }
                else
                {
                    remuseMusic();
                    startForeground(7,getNotification(R.drawable.pause,all_song_name[current_song_position]));

                }
                break;
            }

            case next_button_of_notification:
            {
                playNextSong();
                break;
            }

            case cancel_button_of_notification:
            {
                destroy_service=true;
                stopSelf();
                break;
            }


        }

        return START_NOT_STICKY;
    }


   //startMusic()
    public void startMusic(int position){
        if (mediaPlayer==null)
        {
            mediaPlayer=new MediaPlayer();
            Uri media_path=Uri.parse(all_song_path[position]);
            try {
                mediaPlayer.setDataSource(getApplicationContext(),media_path);
                mediaPlayer.prepare();
                mediaPlayer.start();
                current_song_position=position;
                startForeground(7,getNotification(R.drawable.pause,all_song_name[current_song_position]));
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if(current_song_position<all_song_name.length-1)
                        {
                            current_song_position=current_song_position+1;

                        }
                        else
                        {
                            current_song_position=current_song_position;
                        }
                        mp.reset();
                        Uri media_path=Uri.parse(all_song_path[current_song_position]);
                        try {
                            mediaPlayer.setDataSource(getApplicationContext(),media_path);
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                            startForeground(7,getNotification(R.drawable.pause,all_song_name[current_song_position]));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(position!=current_song_position)
        {
            mediaPlayer.reset();
            Uri media_path=Uri.parse(all_song_path[position]);
            try {
                mediaPlayer.setDataSource(getApplicationContext(),media_path);
                mediaPlayer.prepare();
                mediaPlayer.start();
                current_song_position=position;
                startForeground(7,getNotification(R.drawable.pause,all_song_name[current_song_position]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


   /// //pauseMusic()

    public void pauseMusic()
    {
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
            startForeground(7,getNotification(R.drawable.play,all_song_name[current_song_position]));
        }
    }


   //// //remuseMusic()

    public void remuseMusic()
    {
        if(!mediaPlayer.isPlaying())
        {
            mediaPlayer.start();
            startForeground(7,getNotification(R.drawable.pause,all_song_name[current_song_position]));
        }
    }


    /////getCurrentSongDuration()
    public int getCurrentSongDuration()
    {
        return mediaPlayer.getDuration();
    }


    //////getCurrentSongPosition()
    public int getCurrentSongPosition()
    {
        return mediaPlayer.getCurrentPosition();
    }


    ///////playNextSong()
    public void playNextSong()
    {
        if(current_song_position<all_song_name.length-1)
        {
            startMusic(current_song_position+1);
        }
        else if(current_song_position==all_song_name.length-1)
        {
            mediaPlayer.reset();
            Uri media_path=Uri.parse(all_song_path[current_song_position]);
            try {
                mediaPlayer.setDataSource(getApplicationContext(),media_path);
                mediaPlayer.prepare();
                mediaPlayer.start();
                startForeground(7,getNotification(R.drawable.pause,all_song_name[current_song_position]));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    ///////playPreviousSong()
    public void playPreviousSong()
    {
        if(current_song_position>0)
        {
            startMusic(current_song_position-1);
        }
        else if(current_song_position==0)
        {
            mediaPlayer.reset();
            Uri media_path=Uri.parse(all_song_path[current_song_position]);
            try {
                mediaPlayer.setDataSource(getApplicationContext(),media_path);
                mediaPlayer.prepare();
                mediaPlayer.start();
                startForeground(7,getNotification(R.drawable.pause,all_song_name[current_song_position]));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /////setSeekTo()
    public void setSeekTo(int millisecond)
    {
        mediaPlayer.seekTo(millisecond);
    }


    ////getCurrentSongName()
    public String getCurrentSongName()
    {
        return all_song_name[current_song_position];
    }

    //// musicIsPlaying()
    public boolean musicIsPlaying()
    {
        return mediaPlayer.isPlaying();
    }


    public int getCurrentSongIndex()
    {
        return current_song_position;
    }




    public void saveSeekbarPosition(int position)
    {
        saved_seekbar_position=position;
    }

    public int getSavedSeekbarPosition()
    {
        return saved_seekbar_position;
    }



    public void savedLeftTimmerValue(String timmerValue)
    {
        left_timmer_value=timmerValue;
    }


    public String getSavedLeftTimmerValue()
    {
        return left_timmer_value;
    }


    public void setActivityExistance(boolean exist)
    {
        is_Activity_exist=exist;
    }

    public boolean getServiceStatus()
    {
        return destroy_service;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        Log.d("ABCDE","onDestroy() is Called");
    }

    public Notification getNotification(int notification_play_pause_icon,String notificationText)
    {
        int previous_requestCode=11,pause_play_requestCode=12,next_requestCode=13,cancel_requestCode=14;
        Intent activity_intent=new Intent(getApplicationContext(),MusicControlActivity.class);
        activity_intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent activity_pendingIntent=PendingIntent.getActivity(getApplicationContext(),1,activity_intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intent_previous=new Intent(getApplicationContext(),ForegroundService.class);
        intent_previous.putExtra("come_from_notification",previous_button_of_notification);
        PendingIntent previous_button_pendingIntent=PendingIntent.getService(getApplicationContext(),previous_requestCode,intent_previous,PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intent_play_pause=new Intent(getApplicationContext(),ForegroundService.class);
        intent_play_pause.putExtra("come_from_notification",play_pause_button_of_notification);
        PendingIntent play_pause_pendingIntent=PendingIntent.getService(getApplicationContext(),pause_play_requestCode,intent_play_pause,PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intent_next=new Intent(getApplicationContext(),ForegroundService.class);
        intent_next.putExtra("come_from_notification",next_button_of_notification);
       PendingIntent next_pendingIntent=PendingIntent.getService(getApplicationContext(),next_requestCode,intent_next,PendingIntent.FLAG_UPDATE_CURRENT);

       Intent cancel_intent=new Intent(getApplicationContext(),ForegroundService.class);
       cancel_intent.putExtra("come_from_notification",cancel_button_of_notification);
       PendingIntent calcel_pendingIntent=PendingIntent.getService(getApplicationContext(),cancel_requestCode,cancel_intent,PendingIntent.FLAG_UPDATE_CURRENT);


        notificationCompact=new NotificationCompat.Builder(getApplicationContext(),"Nisith")
                .setContentTitle("Audio Player")
                .setContentText(""+notificationText)
                .setSmallIcon(R.drawable.icon_audio_track)
                .setContentIntent(activity_pendingIntent)
                .addAction(R.drawable.previous,"",previous_button_pendingIntent)
                .addAction(notification_play_pause_icon,"",play_pause_pendingIntent)
                .addAction(R.drawable.next,"",next_pendingIntent)
                .addAction(R.drawable.icon_cancle,"",calcel_pendingIntent)
                .setStyle(new android.support.v4.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(0,1,2)
                        )
                .setPriority(NotificationCompat.PRIORITY_MAX)
                 .setSubText("Hello Nisith");
        return notificationCompact.build();
    }


}





























