package com.music.audioplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.io.File;
import java.util.ArrayList;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter
{
    private FoldersongFragment foldersongFragment;
    private AllsongFragment allsongFragment;
    private PlayListFragment playListFragment;
    private FavouritesongFragment favouritesongFragment;
    private HomeActivity homeActivity;
    private ArrayList<CustomFile> playListFiles;

    public MyFragmentPagerAdapter(FragmentManager fm, HomeActivity homeActivity, ArrayList<CustomFile> playListFiles)
    {
        super(fm);
        this.homeActivity=homeActivity;
        this.playListFiles=playListFiles;
    }



    @Override
    public Fragment getItem(int i)
    {
        Fragment fragment=null;
        switch (i)
        {
            case 0:

                fragment=new FoldersongFragment(homeActivity);
                foldersongFragment= (FoldersongFragment) fragment;
                break;

            case 1:
                fragment=new AllsongFragment(homeActivity);
                allsongFragment=(AllsongFragment) fragment;
                break;
            case 2:
                fragment=new PlayListFragment(homeActivity,playListFiles);
                playListFragment= (PlayListFragment) fragment;
                break;
            case 3:
                fragment=new FavouritesongFragment(homeActivity);
                favouritesongFragment= (FavouritesongFragment) fragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount()
    {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        String title=null;

        switch (position)
        {
            case 0:
                title="FOLDER";
                break;
            case 1:
                title="ALL SONGS";
                break;
            case 2:
                title="PLAY LIST";
                break;
            case 3:
                title="FAVOURITE";
                break;

        }
        return title;
    }



    public AllsongFragment getAllsongFragmentObject() {
        return allsongFragment;
    }
    public PlayListFragment getPlayListFragmentObject() {
        return playListFragment;
    }
    public FoldersongFragment getFolderFragmentObject() {
        return foldersongFragment;
    }
    public FavouritesongFragment getFavouriteSongFragmentObject() {
        return favouritesongFragment;
    }


}
