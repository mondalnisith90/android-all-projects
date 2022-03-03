package com.music.audioplayer;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPraferenceForTextStyle {
    private SharedPreferences sharedPreferences;

    public SharedPraferenceForTextStyle(SettingActivity settingActivity)
    {
        this.sharedPreferences=settingActivity.getSharedPreferences("text_style_file", Context.MODE_PRIVATE);
    }

    public SharedPraferenceForTextStyle(HomeActivity homeActivity)
    {
        this.sharedPreferences=homeActivity.getSharedPreferences("text_style_file", Context.MODE_PRIVATE);
    }

    public void  saveTextStyleValue(String textStyle)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("text_style_value",textStyle);
            editor.commit();
        }
    }
    public String getSavedTextStyleValue()
    {
        String textStyleValue="normal";
        if (sharedPreferences!=null)
        {
             textStyleValue=sharedPreferences.getString("text_style_value","normal");
        }
        return textStyleValue;
    }

}
