package com.music.audioplayer;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class BottomSheetDialogForFavouriteSongFragment extends BottomSheetdialogFragment
{
    private LinearLayout play,share,remove,details,playList;
    private String path;
    private FavouritesongFragment favouritesongFragment=null;
    private PlayListFragment playListFragment=null;
    private BottomSheetDialogItemClickInterface bottomSheetDialogItemClickInterface;
    private int rowPositionNumber;

    @SuppressLint("ValidFragment")
    public BottomSheetDialogForFavouriteSongFragment(FavouritesongFragment favouritesongFragment,String path,int rowPositionNumber)
    {
        this.favouritesongFragment=favouritesongFragment;
        this.path=path;
        this.rowPositionNumber=rowPositionNumber;
    }
    @SuppressLint("ValidFragment")
    public BottomSheetDialogForFavouriteSongFragment(PlayListFragment playListFragment,String path,int rowPositionNumber)
    {
        this.playListFragment=playListFragment;
        this.path=path;
        this.rowPositionNumber=rowPositionNumber;
    }

    public BottomSheetDialogForFavouriteSongFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (favouritesongFragment!=null)
        {
            bottomSheetDialogItemClickInterface=favouritesongFragment;
        }
        if (playListFragment!=null)
        {
            bottomSheetDialogItemClickInterface=playListFragment;
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.bottom_sheet_ui_forfavourite_song_fragment,container,false);
        play=view.findViewById(R.id.play);
        share=view.findViewById(R.id.share);
        remove=view.findViewById(R.id.remove);
        details=view.findViewById(R.id.details);
        playList=view.findViewById(R.id.play_list);
        if (playListFragment!=null)
        {
            playList.setVisibility(View.GONE);
        }
        play.setOnClickListener(new MyOnClickListener());
        share.setOnClickListener(new MyOnClickListener());
        remove.setOnClickListener(new MyOnClickListener());
        details.setOnClickListener(new MyOnClickListener());
        playList.setOnClickListener(new MyOnClickListener());
        return view;
    }

    class MyOnClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            bottomSheetDialogItemClickInterface.bottomDialogItemClicked(v,path,rowPositionNumber);
            dismiss();
        }
    }
}
