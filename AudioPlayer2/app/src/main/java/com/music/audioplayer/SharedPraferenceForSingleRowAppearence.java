package com.music.audioplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

public class SharedPraferenceForSingleRowAppearence {
    private SharedPreferences sharedPreferences;
    public SharedPraferenceForSingleRowAppearence(SingleRowStyleActivity singleRowStyleActivity)
    {
        this.sharedPreferences=singleRowStyleActivity.getSharedPreferences("single_row_appearence", Context.MODE_PRIVATE);
    }

    public SharedPraferenceForSingleRowAppearence(HomeActivity homeActivity)
    {
        this.sharedPreferences=homeActivity.getSharedPreferences("single_row_appearence", Context.MODE_PRIVATE);
    }

    public SharedPraferenceForSingleRowAppearence(FolderHigherciSongDisplayActivity folderHigherciSongDisplayActivity)
    {
        this.sharedPreferences=folderHigherciSongDisplayActivity.getSharedPreferences("single_row_appearence", Context.MODE_PRIVATE);
    }

    public SharedPraferenceForSingleRowAppearence(FolderSongDisplayActivity folderSongDisplayActivity)
    {
        this.sharedPreferences=folderSongDisplayActivity.getSharedPreferences("single_row_appearence", Context.MODE_PRIVATE);
    }

    public void saveHideFolderpathValue(boolean hideFolderPathValue)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("hide_folder_path_value",hideFolderPathValue);
            editor.commit();
        }
    }


    public void saveHideFolderDateTimeInfoValue(boolean hideFolderDateTimeInfoValue)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("hide_folder_datetime_info_value",hideFolderDateTimeInfoValue);
            editor.commit();
        }
    }

    public void saveHideDateTimeInfoValue(boolean hideDateTimeInfoValue)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("hide_file_datetime_info_value",hideDateTimeInfoValue);
            editor.commit();
        }
    }

    public void saveHideFileSizeValue(boolean hideFileSizeValue)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("hide_File_size_value",hideFileSizeValue);
            editor.commit();
        }
    }


    public int getFolderPathVisivility()
    {
        int visibility=View.INVISIBLE;
        if (sharedPreferences!=null){
            if (sharedPreferences.getBoolean("hide_folder_path_value",false)){

            }else {
                visibility=View.VISIBLE;
            }
        }
        return visibility;
    }

    public int getFolderDateTimeInfoVisivility()
    {
        int visibility=View.INVISIBLE;
        if (sharedPreferences!=null){
            if (sharedPreferences.getBoolean("hide_folder_datetime_info_value",false)){

            }else {
                visibility=View.VISIBLE;
            }
        }
        return visibility;
    }


    public int getFileDateTimeInfoVisivility()
    {
        int visibility=View.INVISIBLE;
        if (sharedPreferences!=null){
            if (sharedPreferences.getBoolean("hide_file_datetime_info_value",false)){

            }else {
                visibility=View.VISIBLE;
            }
        }
        return visibility;
    }

    public int getFileSizeVisivility()
    {
        int visibility=View.INVISIBLE;
        if (sharedPreferences!=null){
            if (sharedPreferences.getBoolean("hide_File_size_value",false)){

            }else {
                visibility=View.VISIBLE;
            }
        }
        return visibility;
    }





    public boolean getHideFolderpathValue()
    {
        boolean savedValue= false;
        if (sharedPreferences!=null)
        {
            savedValue=sharedPreferences.getBoolean("hide_folder_path_value",false);
        }
        return savedValue;
    }

    public boolean getHideFolderDateTimeInfoValue()
    {
        boolean savedValue=false;
        if (sharedPreferences!=null)
        {
            savedValue=sharedPreferences.getBoolean("hide_folder_datetime_info_value",false);
        }
        return savedValue;
    }

    public boolean getHideDateTimeInfoValue()
    {
        boolean savedValue=false;
        if (sharedPreferences!=null)
        {
            savedValue=sharedPreferences.getBoolean("hide_file_datetime_info_value",false);
        }
        return savedValue;
    }

    public boolean getHideFileSizeValue()
    {
        boolean savedValue=false;
        if (sharedPreferences!=null)
        {
            savedValue=sharedPreferences.getBoolean("hide_File_size_value",false);
        }
        return savedValue;
    }

}










