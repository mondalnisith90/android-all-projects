package com.music.audioplayer;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MusicControlActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ActionBar actionBar;
    private Switch animationSwitch;
    private ImageView themeImage;
    private SeekBar seekBar;
    private TextView leftTimmer,rightTimmer,marqueText;
    private Button replay,favourite,equlizer,musicSpeed,play,previous,next,lock,unLock,volume,previousSkeep,nextSkeep,repet,volumeOff,share;
    private SharedPreferenceForSavingTheme sharedPreferenceForSavingTheme;
    private boolean stopAnimationThread=false;
    private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_control);
        toolbar=findViewById(R.id.music_control_toolbar);
        animationSwitch=findViewById(R.id.animation_switch);
        themeImage=findViewById(R.id.image_view);
        seekBar=findViewById(R.id.seekbar);
        leftTimmer=findViewById(R.id.left_timmer);
        rightTimmer=findViewById(R.id.right_timmer);
        marqueText=findViewById(R.id.marque_text);
        replay=findViewById(R.id.replay_button);
        favourite=findViewById(R.id.favourite_buton);
        equlizer=findViewById(R.id.equalizer_button);
        musicSpeed=findViewById(R.id.music_speed_button);
        play=findViewById(R.id.play_button);
        previous=findViewById(R.id.previous_button);
        next=findViewById(R.id.next_button);
        lock=findViewById(R.id.lock_button);
        unLock=findViewById(R.id.unlock_button);
        volume=findViewById(R.id.volume_button);
        previousSkeep=findViewById(R.id.previous_skeep_button);
        nextSkeep=findViewById(R.id.next_skeep_button);
        repet=findViewById(R.id.repet_button);
        volumeOff=findViewById(R.id.volume_off_button);
        share=findViewById(R.id.share_button);
        sharedPreferenceForSavingTheme=new SharedPreferenceForSavingTheme(this);
        themeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animationSwitch.isChecked() && lock.getVisibility()==View.VISIBLE) {
                    Intent intent = new Intent(MusicControlActivity.this, ThemeActivity.class);
                    startActivity(intent);
                }
            }
        });

        animationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){//if Switch is ON, then Start Animation.
                    stopAnimationThread=false;
                    startAnimation();

                }else {//if Switch is OFF, then Show Theme Image.

                    showBackGroundTheme();
                    stopAnimationThread=true;
                }
            }
        });
        unLock.setVisibility(View.GONE);//when Activity is started
        lock.setOnClickListener(new MyOnClickListener());
        unLock.setOnClickListener(new MyOnClickListener());
        replay.setOnClickListener(new MyOnClickListener());
        favourite.setOnClickListener(new MyOnClickListener());
        equlizer.setOnClickListener(new MyOnClickListener());
        repet.setOnClickListener(new MyOnClickListener());
        volumeOff.setOnClickListener(new MyOnClickListener());

        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        if (actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }

    }


    private void startAnimation()//Just a Method To Reduce Code in onCheckedChange() Callback Method
    {
        SharedPraferenceForSavingAnimation sharedPraferenceForSavingAnimation=new SharedPraferenceForSavingAnimation(MusicControlActivity.this);
        String savedAnimation=sharedPraferenceForSavingAnimation.getSavedAnimationName();
        if (savedAnimation.equals("solid_love_animation")){

            int favouriteIconsArray[]={R.drawable.ic_favorite,R.drawable.ic_favorite1,R.drawable.ic_favorite2,R.drawable.ic_favorite3,
                    R.drawable.ic_favorite4,R.drawable.ic_favorite5,R.drawable.ic_favorite6,R.drawable.ic_favorite7,R.drawable.ic_favorite8};
            startAnimationThrea(favouriteIconsArray);

        }else if (savedAnimation.equals("border_love_animation")){
            int favouriteBorderIconsArray[]={R.drawable.ic_favorite_border1,R.drawable.ic_favorite_border2,R.drawable.ic_favorite_border3,R.drawable.ic_favorite_border5,
                    R.drawable.ic_favorite_border6,R.drawable.ic_favorite_border7,R.drawable.ic_favorite_border10,R.drawable.ic_favorite_border11};
            startAnimationThrea(favouriteBorderIconsArray);
        }else  if (savedAnimation.equals("android_animation")){
            int androidIconsArray[]={R.drawable.ic_android_icon1,R.drawable.ic_android_icon2,R.drawable.ic_android_icon3,R.drawable.ic_android_icon4,
                    R.drawable.ic_android_icon5,R.drawable.ic_android_icon6, R.drawable.ic_android_icon7,R.drawable.ic_android_icon8};
            startAnimationThrea(androidIconsArray);
        }else if (savedAnimation.equals("flower_animation")){
            int flowerIconsArray[]={R.drawable.ic_flower,R.drawable.ic_flower1,R.drawable.ic_flower2,R.drawable.ic_flower3,
                    R.drawable.ic_flower4,R.drawable.ic_flower5,R.drawable.ic_flower6,R.drawable.ic_flower7};
            startAnimationThrea(flowerIconsArray);
        }else if (savedAnimation.equals("brightness_animation")){
            int brightnessIconsArray[]={R.drawable.ic_brightness1,R.drawable.ic_brightness2,R.drawable.ic_brightness3,R.drawable.ic_brightness4,
                    R.drawable.ic_brightness5,R.drawable.ic_brightness6,R.drawable.ic_brightness7,R.drawable.ic_brightness8};
            startAnimationThrea(brightnessIconsArray);
        }else if (savedAnimation.equals("cake_animation")){
            int cakeIconsArray[]={R.drawable.ic_cake1,R.drawable.ic_cake2,R.drawable.ic_cake3,R.drawable.ic_cake4,
                    R.drawable.ic_cake5,R.drawable.ic_cake6,R.drawable.ic_cake7,R.drawable.ic_cake8};
            startAnimationThrea(cakeIconsArray);
        }else if (savedAnimation.equals("circle_animation")){
            int circleIconsArray[]={R.drawable.ic_circle1,R.drawable.ic_circle2,R.drawable.ic_circle3,R.drawable.ic_circle4,
                    R.drawable.ic_circle5,R.drawable.ic_circle6,R.drawable.ic_circle7,R.drawable.ic_circle8};
            startAnimationThrea(circleIconsArray);
        }else if (savedAnimation.equals("face_animation")){
            int faceIconsArray[]={R.drawable.ic_face1,R.drawable.ic_face2,R.drawable.ic_face3,R.drawable.ic_face4,
                    R.drawable.ic_face5,R.drawable.ic_face6,R.drawable.ic_face7,R.drawable.ic_face8};
            startAnimationThrea(faceIconsArray);
        }else if (savedAnimation.equals("full_moon_animation")){
            int fullMoonIconsArray[]={R.drawable.ic_fullmoon1,R.drawable.ic_fullmoon2,R.drawable.ic_fullmoon3,R.drawable.ic_fullmoon4,
                    R.drawable.ic_fullmoon5,R.drawable.ic_fullmoon6,R.drawable.ic_fullmoon7,R.drawable.ic_fullmoon8};
            startAnimationThrea(fullMoonIconsArray);
        }else if (savedAnimation.equals("half_moon_animation")){
            int falfMoonIconsArray[]={R.drawable.ic_moon1,R.drawable.ic_moon2,R.drawable.ic_moon3,R.drawable.ic_moon4,
                    R.drawable.ic_moon5,R.drawable.ic_moon6,R.drawable.ic_moon7,R.drawable.ic_moon8};
            startAnimationThrea(falfMoonIconsArray);
        }else if (savedAnimation.equals("music_note_animation")){
            int musicnoteIconsArray[]={R.drawable.ic_music_note1,R.drawable.ic_music_note2,R.drawable.ic_music_note3,R.drawable.ic_music_note4,
                    R.drawable.ic_music_note5,R.drawable.ic_music_note6,R.drawable.ic_music_note7,R.drawable.ic_music_note8};
            startAnimationThrea(musicnoteIconsArray);
        }else if (savedAnimation.equals("sun_animation")){
            int sunIconsArray[]={R.drawable.ic_sun1,R.drawable.ic_sun2,R.drawable.ic_sun3,R.drawable.ic_sun4,
                    R.drawable.ic_sun5,R.drawable.ic_sun6,R.drawable.ic_sun7,R.drawable.ic_sun8};
            startAnimationThrea(sunIconsArray);
        }else if (savedAnimation.equals("star_animation")){
            int starIconsArray[]={R.drawable.ic_star1,R.drawable.ic_star2,R.drawable.ic_star3,R.drawable.ic_star4,
                    R.drawable.ic_star5,R.drawable.ic_star6,R.drawable.ic_star7,R.drawable.ic_star8};
            startAnimationThrea(starIconsArray);
        }
    }

    private void startAnimationThrea(final int []iconsArray)
    {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    if (stopAnimationThread){
                        break;
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            themeImage.setBackgroundResource(iconsArray[counter]);
                        }
                    });
                    if (counter==7){
                        counter=0;
                    }else {
                        counter++;
                    }
                    SystemClock.sleep(1000);
//                    Log.d("ABCD","Thread is Running");

                }

//                Log.e("ABCD","Thread is Stopped");
            }
        });
        thread.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        stopAnimationThread=true;
    }

    private void showBackGroundTheme()//Just aMethod To Reduce Code
    {
        String themeSource=sharedPreferenceForSavingTheme.getSavedThemeSource();
        if (themeSource==null)
        {
            themeImage.setBackgroundResource(R.drawable.ic_favorite5);
        }else if (themeSource.equals("application_theme")){
            int themeImageDrawableValue=sharedPreferenceForSavingTheme.getSavedThemeImageDrawableValue();

        }else if (themeSource.equals("gallery_theme")){

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
       showBackGroundTheme();
       if (animationSwitch.isChecked()){
           stopAnimationThread=false;
           startAnimation();
       }
    }

    private class MyOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            Drawable backgroundImage;
            Drawable drawableImage;
            switch (v.getId())
            {
                case R.id.lock_button:
                {

                    hideAllView();
                    break;
                }

                case R.id.unlock_button:
                {
                    showAllView();
                    break;
                }

                case R.id.replay_button:
                {
                   backgroundImage= replay.getBackground();
                   drawableImage=getResources().getDrawable(R.drawable.ic_replay);
                   if (backgroundImage.getConstantState().equals(drawableImage.getConstantState())) {
                       replay.setBackgroundResource(R.drawable.ic_replay_red);
                   }else {
                       replay.setBackgroundResource(R.drawable.ic_replay);
                   }
                    break;
                }
                case R.id.favourite_buton:
                {
                    backgroundImage= favourite.getBackground();
                    drawableImage=getResources().getDrawable(R.drawable.ic_favorite_white);
                    if (backgroundImage.getConstantState().equals(drawableImage.getConstantState())) {
                        favourite.setBackgroundResource(R.drawable.ic_favorite_red);
                    }else {
                        favourite.setBackgroundResource(R.drawable.ic_favorite_white);
                    }
                    break;
                }

                case R.id.equalizer_button:
                {
                    Intent intent=new Intent(MusicControlActivity.this,EqualizerActivity.class);
                    startActivity(intent);
                    break;
                }


                case R.id.repet_button:
                {
                    backgroundImage= repet.getBackground();
                    drawableImage=getResources().getDrawable(R.drawable.ic_repeat_black_24dp);
                    if (backgroundImage.getConstantState().equals(drawableImage.getConstantState())) {
                        repet.setBackgroundResource(R.drawable.ic_repeat_red);
                    }else {
                        repet.setBackgroundResource(R.drawable.ic_repeat_black_24dp);
                    }
                    break;
                }
                case R.id.volume_off_button:
                {
                    backgroundImage= volumeOff.getBackground();
                    drawableImage=getResources().getDrawable(R.drawable.ic_volume_off);
                    if (backgroundImage.getConstantState().equals(drawableImage.getConstantState())) {
                        volumeOff.setBackgroundResource(R.drawable.ic_volume_off_red);
                    }else {
                        volumeOff.setBackgroundResource(R.drawable.ic_volume_off);
                    }
                    break;
                }

            }

        }
    }


    private void hideAllView()
    {
        animationSwitch.setVisibility(View.INVISIBLE);
        seekBar.setVisibility(View.INVISIBLE);
        leftTimmer.setVisibility(View.INVISIBLE);
        rightTimmer.setVisibility(View.INVISIBLE);
        replay.setVisibility(View.INVISIBLE);
        favourite.setVisibility(View.INVISIBLE);
        equlizer.setVisibility(View.INVISIBLE);
        musicSpeed.setVisibility(View.INVISIBLE);
        lock.setVisibility(View.GONE);
        unLock.setVisibility(View.VISIBLE);//unlock Visible
        volume.setVisibility(View.INVISIBLE);
        previousSkeep.setVisibility(View.INVISIBLE);
        nextSkeep.setVisibility(View.INVISIBLE);
        repet.setVisibility(View.INVISIBLE);
        volumeOff.setVisibility(View.INVISIBLE);
        share.setVisibility(View.INVISIBLE);
        actionBar.hide();
    }


    private void showAllView()
    {
        animationSwitch.setVisibility(View.VISIBLE);
        seekBar.setVisibility(View.VISIBLE);
        leftTimmer.setVisibility(View.VISIBLE);
        rightTimmer.setVisibility(View.VISIBLE);
        replay.setVisibility(View.VISIBLE);
        favourite.setVisibility(View.VISIBLE);
        equlizer.setVisibility(View.VISIBLE);
        musicSpeed.setVisibility(View.VISIBLE);
        lock.setVisibility(View.VISIBLE);
        unLock.setVisibility(View.GONE);//unlock GONE
        volume.setVisibility(View.VISIBLE);
        previousSkeep.setVisibility(View.VISIBLE);
        nextSkeep.setVisibility(View.VISIBLE);
        repet.setVisibility(View.VISIBLE);
        volumeOff.setVisibility(View.VISIBLE);
        share.setVisibility(View.VISIBLE);
        actionBar.show();
    }


    @Override
    public void onBackPressed() {

        if (lock.getVisibility()==View.VISIBLE){
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.music_control_activity_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.song_detail:
            {
//                Toast.makeText(this, "Song Details is Clicked", Toast.LENGTH_SHORT).show();
                AlertDialogForSongDetails alertDialogForSongDetails=new AlertDialogForSongDetails();
                alertDialogForSongDetails.show(getSupportFragmentManager(),"dialog");
                break;
            }
            case R.id.stop_song:
            {
                Toast.makeText(this, "Stop Song is Clicked", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.equalizer:
            {
                Intent intent=new Intent(MusicControlActivity.this,EqualizerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.theme:
            {
                Intent intent=new Intent(MusicControlActivity.this,ThemeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.animation:
            {
                Intent intent=new Intent(MusicControlActivity.this,SettingActivity.class);
                startActivity(intent);
                break;

            }
            case R.id.soundControl:
            {
                Toast.makeText(this, "soundControl is Clicked", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.about_icons:
            {
                Toast.makeText(this, "about_icons is Clicked", Toast.LENGTH_SHORT).show();
                break;
            }

            case 16908332://For Back Button Press in Toolbar
            {
                if(lock.getVisibility()==View.VISIBLE){
                    finish();
                }
            }
        }
        return true;
    }
}
