package com.music.audioplayer;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceForSavingTheme {

    private SharedPreferences sharedPreferences;
    public SharedPreferenceForSavingTheme(ApplicationThemeActivity applicationThemeActivity)
    {
        this.sharedPreferences=applicationThemeActivity.getSharedPreferences("theme_image", Context.MODE_PRIVATE);
    }

    public SharedPreferenceForSavingTheme(MusicControlActivity musicControlActivity)
    {
        this.sharedPreferences=musicControlActivity.getSharedPreferences("theme_image", Context.MODE_PRIVATE);
    }

    public void saveThemeImageDrawableValue(int imageDrawableValue)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("image_drawable_value",imageDrawableValue);
            editor.commit();
        }
    }

    public void saveThemeSource(String themeSource)//Theme Source means from Application Theme or from Gallery Theme
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("theme_source",themeSource);
            editor.commit();
        }
    }

    public String getSavedThemeSource()
    {

        String sourceValue=null;
        if (sharedPreferences!=null)
        {
            sourceValue=sharedPreferences.getString("theme_source",null);
        }
        return sourceValue;
    }

    public int getSavedThemeImageDrawableValue()
    {
        int value=-1;
        if (sharedPreferences!=null)
        {
            value=sharedPreferences.getInt("image_drawable_value",-1);
        }
        return value;
    }
}
