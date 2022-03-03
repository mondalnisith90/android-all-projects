package com.music.audioplayer;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Objects;

@SuppressLint("ValidFragment")
public class AlertDialogForAnimation extends AppCompatDialogFragment {

    private SettingActivity settingActivity;
    private SharedPraferenceForSavingAnimation sharedPraferenceForSavingAnimation;

    public AlertDialogForAnimation(SettingActivity settingActivity)
    {
       this.settingActivity=settingActivity;
        sharedPraferenceForSavingAnimation=new SharedPraferenceForSavingAnimation(settingActivity);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater= Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.alert_dialog_for_animation_layout,null);
        final RadioGroup radioGroup=view.findViewById(R.id.radio_group2);
        RadioButton solidLoveAnimation,borderLoveAnimation,androidAnimation,flowerAnimaion,brightnessAnimation,cakeAnimation,circleAnimation,
                faceAnimation,fullMoonAnimation,halfMoonAnimation,musicNoteAnimation,sunAnimation,starAnimation;
        solidLoveAnimation=view.findViewById(R.id.solid_love);
        borderLoveAnimation=view.findViewById(R.id.border_love);
        androidAnimation=view.findViewById(R.id.android_animation);
        flowerAnimaion=view.findViewById(R.id.flower_animation);
        brightnessAnimation=view.findViewById(R.id.brightness_animation);
        cakeAnimation=view.findViewById(R.id.cake_animation);
        circleAnimation=view.findViewById(R.id.circle_animation);
        faceAnimation=view.findViewById(R.id.face_animation);
        fullMoonAnimation=view.findViewById(R.id.full_moon_animation);
        halfMoonAnimation=view.findViewById(R.id.half_moon_animation);
        musicNoteAnimation=view.findViewById(R.id.music_note_animation);
        sunAnimation=view.findViewById(R.id.sun_animation);
        starAnimation=view.findViewById(R.id.star_animation);

        String savedAnimationName=sharedPraferenceForSavingAnimation.getSavedAnimationName();
        if (savedAnimationName==null){
            borderLoveAnimation.setChecked(true);
        }else {
            if (savedAnimationName.equals("solid_love_animation")){
                solidLoveAnimation.setChecked(true);
            }else if (savedAnimationName.equals("border_love_animation")){
                borderLoveAnimation.setChecked(true);
            }else if (savedAnimationName.equals("android_animation")){
                androidAnimation.setChecked(true);
            }else if (savedAnimationName.equals("flower_animation")){
                flowerAnimaion.setChecked(true);
            }else if (savedAnimationName.equals("brightness_animation")){
                brightnessAnimation.setChecked(true);
            }else if (savedAnimationName.equals("cake_animation")){
                cakeAnimation.setChecked(true);
            }else if (savedAnimationName.equals("circle_animation")){
                circleAnimation.setChecked(true);
            }else if (savedAnimationName.equals("face_animation")){
                faceAnimation.setChecked(true);
            }else if (savedAnimationName.equals("full_moon_animation")){
                fullMoonAnimation.setChecked(true);
            }else if (savedAnimationName.equals("half_moon_animation")){
                halfMoonAnimation.setChecked(true);
            }else if (savedAnimationName.equals("music_note_animation")){
                musicNoteAnimation.setChecked(true);
            }else if (savedAnimationName.equals("sun_animation")){
                sunAnimation.setChecked(true);
            }else if (savedAnimationName.equals("star_animation")){
                starAnimation.setChecked(true);
            }
        }

        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("Set Animation")
        .setView(view)
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               switch (radioGroup.getCheckedRadioButtonId())
               {
                   case R.id.solid_love:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("solid_love_animation");
                       break;
                   }
                   case R.id.border_love:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("border_love_animation");
                       break;
                   }
                   case R.id.android_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("android_animation");
                       break;
                   }
                   case R.id.flower_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("flower_animation");
                       break;
                   }
                   case R.id.brightness_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("brightness_animation");
                       break;
                   }
                   case R.id.cake_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("cake_animation");
                       break;
                   }
                   case R.id.circle_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("circle_animation");
                       break;
                   }
                   case R.id.face_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("face_animation");
                       break;
                   }
                   case R.id.full_moon_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("full_moon_animation");
                       break;
                   }
                   case R.id.half_moon_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("half_moon_animation");
                       break;
                   }
                   case R.id.music_note_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("music_note_animation");
                       break;
                   }
                   case R.id.sun_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("sun_animation");
                       break;
                   }

                   case R.id.star_animation:
                   {
                       sharedPraferenceForSavingAnimation.saveAnimationName("star_animation");
                       break;
                   }
               }
            }
        })
        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }
}
