package com.music.audioplayer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.Objects;

public class PlayListFiles
{
    private SharedPreferences sharedPreferences;
    Intent intent;


    public PlayListFiles(FoldersongFragment foldersongFragment) {
        sharedPreferences= Objects.requireNonNull(foldersongFragment.getActivity()).getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
    }

    public PlayListFiles(AllsongFragment allsongFragment) {
        sharedPreferences=allsongFragment.getActivity().getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
    }


    public PlayListFiles(FolderHigherciSongDisplayActivity folderHigherciSongDisplayActivity) {
        sharedPreferences=folderHigherciSongDisplayActivity.getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
    }

    public PlayListFiles(FolderSongDisplayActivity folderSongDisplayActivity) {
        sharedPreferences=folderSongDisplayActivity.getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
    }
}
