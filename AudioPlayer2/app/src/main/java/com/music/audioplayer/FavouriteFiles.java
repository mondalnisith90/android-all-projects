package com.music.audioplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Map;
import java.util.Set;

public class FavouriteFiles
{
//    private AllsongFragment allsongFragment;
//    private FolderSongDisplayActivity folderSongDisplayActivity;
//    private FolderHigherciSongDisplayActivity folderHigherciSongDisplayActivity;
    private SharedPreferences sharedPreferences;

    public FavouriteFiles(FavouritesongFragment favouritesongFragment)
    {
        sharedPreferences=favouritesongFragment.getActivity().getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
    }

    public FavouriteFiles(FoldersongFragment foldersongFragment) {
        sharedPreferences=foldersongFragment.getActivity().getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
    }

    public FavouriteFiles(AllsongFragment allsongFragment) {
        sharedPreferences=allsongFragment.getActivity().getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
    }


    public FavouriteFiles(FolderHigherciSongDisplayActivity folderHigherciSongDisplayActivity) {
        sharedPreferences=folderHigherciSongDisplayActivity.getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
    }

    public FavouriteFiles(FolderSongDisplayActivity folderSongDisplayActivity) {
        sharedPreferences=folderSongDisplayActivity.getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
    }


    public FavouriteFiles(HomeActivity homeActivity) {
        sharedPreferences=homeActivity.getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
    }

    public void setFavouriteFilePathInSharedpraferance(String path)
    {
        int i=sharedPreferences.getInt("nextSongIndex",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("pathOfSong"+i,path);
        editor.putInt("nextSongIndex",i+1);
        editor.commit();
    }

    public boolean removePathFromFavouriteList(String path)
    {
        boolean isRemoved=false;
        for (int i=0;i<sharedPreferences.getInt("nextSongIndex",0);i++)
        {
           String filePath=sharedPreferences.getString("pathOfSong"+i,"null");
           if (filePath.equals(path))
           {
               sheftFileToPreviousIndex(i);
               isRemoved=true;
               Log.e("NISITH",""+sharedPreferences.getInt("nextSongIndex",0));
               break;
           }
        }
        return isRemoved;
    }

    private void sheftFileToPreviousIndex(int index)
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        int i;
        for (i=index;i<sharedPreferences.getInt("nextSongIndex",0)-1;i++)
        {
            String filePath=sharedPreferences.getString("pathOfSong"+(i+1),"null");
            editor.putString("pathOfSong"+i,filePath);
            editor.commit();
        }
        editor.putInt("nextSongIndex",i);
        editor.commit();
    }



}






















