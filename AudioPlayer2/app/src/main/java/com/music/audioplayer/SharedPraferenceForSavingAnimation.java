package com.music.audioplayer;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPraferenceForSavingAnimation {

    private SharedPreferences sharedPreferences;
    public SharedPraferenceForSavingAnimation(SettingActivity settingActivity)
    {
        this.sharedPreferences=settingActivity.getSharedPreferences("theme_image", Context.MODE_PRIVATE);
    }

    public SharedPraferenceForSavingAnimation(MusicControlActivity musicControlActivity)
    {
        this.sharedPreferences=musicControlActivity.getSharedPreferences("theme_image", Context.MODE_PRIVATE);
    }


    public void saveAnimationName(String animationName)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("animation_name",animationName);
            editor.commit();
        }
    }

    public String getSavedAnimationName()
    {
        String animationName="solid_love_animation";
        if (sharedPreferences!=null)
        {
            animationName=sharedPreferences.getString("animation_name","solid_love_animation");
        }
        return animationName;
    }

}
