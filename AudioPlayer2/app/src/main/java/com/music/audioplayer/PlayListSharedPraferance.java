package com.music.audioplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class PlayListSharedPraferance
{
    private SharedPreferences sharedPreferences;
    private HomeActivity homeActivity;
    private FolderSongDisplayActivity folderSongDisplayActivity;
    private FolderHigherciSongDisplayActivity folderHigherciSongDisplayActivity;
    public PlayListSharedPraferance(HomeActivity homeActivity)
    {
        this.homeActivity=homeActivity;
        sharedPreferences=homeActivity.getSharedPreferences("play_list_files",Context.MODE_PRIVATE);
    }
    public PlayListSharedPraferance(FolderSongDisplayActivity folderSongDisplayActivity)
    {
        this.folderSongDisplayActivity=folderSongDisplayActivity;
        sharedPreferences=folderSongDisplayActivity.getSharedPreferences("play_list_files", Context.MODE_PRIVATE);
    }

    public PlayListSharedPraferance(FolderHigherciSongDisplayActivity folderHigherciSongDisplayActivity)
    {
        this.folderHigherciSongDisplayActivity=folderHigherciSongDisplayActivity;
        sharedPreferences=folderHigherciSongDisplayActivity.getSharedPreferences("play_list_files", Context.MODE_PRIVATE);
    }


    public void setPlayListFilePathInSharedParferance(String path)
    {
        int i=sharedPreferences.getInt("nextSongIndex",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("pathOfSong"+i,path);
        editor.putInt("nextSongIndex",i+1);
        editor.commit();
    }

    public ArrayList<CustomFile> getAllFiles(int nextFileIndex)
    {
        ArrayList<CustomFile> allFiles=new ArrayList<>();
        String path;
        File file;
        MediaMetadataRetriever mediaMetadataRetriever=new MediaMetadataRetriever();
        byte []data;
        Bitmap bitmap;
        Drawable drawable=null;
        for (int i=0;i<nextFileIndex;i++)
        {
            path=sharedPreferences.getString("pathOfSong"+i,"null");
            file=new File(path);
            if (file.exists())
            {
                mediaMetadataRetriever.setDataSource(path);
                data=mediaMetadataRetriever.getEmbeddedPicture();
                if (data!=null)
                {
                    bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
                    if (homeActivity!=null) {
                        drawable=new BitmapDrawable(homeActivity.getResources(),bitmap);
                    } else if (folderSongDisplayActivity!=null) {
                        drawable=new BitmapDrawable(folderSongDisplayActivity.getResources(),bitmap);
                    }else if (folderHigherciSongDisplayActivity!=null){
                        drawable=new BitmapDrawable(folderHigherciSongDisplayActivity.getResources(),bitmap);
                    }else {
                        drawable=null;
                    }

                    }
                }
                allFiles.add(new CustomFile(file,false,false,true,drawable));
            }
        return allFiles;
    }

    public int getNextFileIndex()
    {
        return sharedPreferences.getInt("nextSongIndex",0);
    }
}
