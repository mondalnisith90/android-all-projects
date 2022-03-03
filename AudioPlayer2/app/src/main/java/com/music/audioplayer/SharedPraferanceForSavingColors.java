package com.music.audioplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPraferanceForSavingColors {
    private SharedPreferences sharedPreferences;

    public SharedPraferanceForSavingColors(ColorSettingActivity colorSettingActivity)
    {
        this.sharedPreferences=colorSettingActivity.getSharedPreferences("color", Context.MODE_PRIVATE);
    }

    public SharedPraferanceForSavingColors(HomeActivity homeActivity)
    {
        this.sharedPreferences=homeActivity.getSharedPreferences("color", Context.MODE_PRIVATE);
    }

    public SharedPraferanceForSavingColors(FolderSongDisplayActivity folderSongDisplayActivity)
    {
        this.sharedPreferences=folderSongDisplayActivity.getSharedPreferences("color", Context.MODE_PRIVATE);
    }

    public SharedPraferanceForSavingColors(FolderHigherciSongDisplayActivity folderHigherciSongDisplayActivity)
    {
        this.sharedPreferences=folderHigherciSongDisplayActivity.getSharedPreferences("color", Context.MODE_PRIVATE);
    }


    public void saveFolderIconColor(String folderIconColor)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("folder_icon_color",folderIconColor);
            editor.commit();
        }
    }
    public void saveFolderPathColor(String folderPathColor)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("folder_path_color",folderPathColor);
            editor.commit();
        }
    }
    public void saveFolderItemColor(String folderItemColor)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("folder_item_color",folderItemColor);
            editor.commit();
        }
    }
    public void saveFolderDateTimeInfoColor(String folderDateTimeInfoColor)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("folder_dateTime_info_color",folderDateTimeInfoColor);
            editor.commit();
        }
    }
    public void saveFolderTitleColor(String folderTitleColor)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("folder_title_color",folderTitleColor);
            editor.commit();
        }
    }

    public void saveFileTitleColor(String fileTitleColor)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("file_title_color",fileTitleColor);
            editor.commit();
        }
    }
    public void saveFileSizeColor(String fileSizeColor)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("file_size_color",fileSizeColor);
            editor.commit();
        }
    }
    public void saveFileDateTimeInfoColor(String fileDateTimeInfoColor)
    {
        if (sharedPreferences!=null)
        {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("file_dateTie_info_color",fileDateTimeInfoColor);
            editor.commit();
        }
    }


    public String getSavedFolderIconColor()
    {
        String colorValue="#0091EA";
        if (sharedPreferences!=null)
        {
            colorValue=sharedPreferences.getString("folder_icon_color","#0091EA");
        }
        return colorValue;
    }
    public String getSavedFolderPathColor()
    {
        String colorValue="#00FFFF";
        if (sharedPreferences!=null)
        {
            colorValue=sharedPreferences.getString("folder_path_color","#00FFFF");
        }
        return colorValue;
    }
    public String getSavedFolderItemColor()
    {
        String colorValue="#AA00EE";
        if (sharedPreferences!=null)
        {
            colorValue=sharedPreferences.getString("folder_item_color","#AA00EE");
        }
        return colorValue;
    }
    public String getSavedFolderDateTimeInfoColor()
    {
        String colorValue="#AA00EE";
        if (sharedPreferences!=null)
        {
            colorValue=sharedPreferences.getString("folder_dateTime_info_color","#AA00EE");
        }
        return colorValue;
    }
    public String getSavedFolderTitleColor()
    {
        String colorValue="#0000FF";
        if (sharedPreferences!=null)
        {
            colorValue=sharedPreferences.getString("folder_title_color","#0000FF");
        }
        return colorValue;
    }

    public String getSavedFileTitleColor()
    {
        String colorValue="#0000FF";
        if (sharedPreferences!=null)
        {
            colorValue=sharedPreferences.getString("file_title_color","#0000FF");
        }
        return colorValue;
    }
    public String getSavedFileSizeColor()
    {
        String colorValue="#AA00EE";
        if (sharedPreferences!=null)
        {
            colorValue=sharedPreferences.getString("file_size_color","#AA00EE");
        }
        return colorValue;
    }
    public String getSavedFileDateTimeInfoColor()
    {
        String colorValue="#AA00EE";
        if (sharedPreferences!=null)
        {
            colorValue=sharedPreferences.getString("file_dateTie_info_color","#AA00EE");
        }
        return colorValue;
    }

}

















