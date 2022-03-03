package com.music.audioplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class BottomSheetdialogFragment extends BottomSheetDialogFragment
{
    private BottomSheetDialogItemClickInterface bottomSheetDialogItemClickInterface;
    private FoldersongFragment foldersongFragment=null;
    private AllsongFragment allsongFragment=null;
    private FolderSongDisplayActivity folderSongDisplayActivity=null;
    private FolderHigherciSongDisplayActivity folderHigherciSongDisplayActivity=null;
    private String path;
    private int rowPositionNumber;


    @SuppressLint("ValidFragment")
    public BottomSheetdialogFragment(FoldersongFragment foldersongFragment,String path)
    {
        this.foldersongFragment=foldersongFragment;
        this.path=path;
    }
    @SuppressLint("ValidFragment")
    public BottomSheetdialogFragment(AllsongFragment allsongFragment,String path)
    {
        this.allsongFragment=allsongFragment;
        this.path=path;
    }

    @SuppressLint("ValidFragment")
    public BottomSheetdialogFragment(FolderSongDisplayActivity  folderSongDisplayActivity,String path)
    {
        this.folderSongDisplayActivity=folderSongDisplayActivity;
        this.path=path;
    }

    @SuppressLint("ValidFragment")
    public BottomSheetdialogFragment(FolderHigherciSongDisplayActivity  folderHigherciSongDisplayActivity,String path)
    {
        this.folderHigherciSongDisplayActivity=folderHigherciSongDisplayActivity;
        this.path=path;
    }
    public BottomSheetdialogFragment(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (foldersongFragment!=null)
        {
            bottomSheetDialogItemClickInterface=foldersongFragment;
        }
        if (allsongFragment!=null)
        {
            bottomSheetDialogItemClickInterface=allsongFragment;
        }
        if (folderSongDisplayActivity!=null)
        {
            bottomSheetDialogItemClickInterface=folderSongDisplayActivity;
        }
        if (folderHigherciSongDisplayActivity!=null)
        {
            bottomSheetDialogItemClickInterface=folderHigherciSongDisplayActivity;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.bottom_sheet_fragment,container,false);
        LinearLayout play=view.findViewById(R.id.play);
        LinearLayout share=view.findViewById(R.id.share);
        LinearLayout delete=view.findViewById(R.id.delete);
        LinearLayout favourite=view.findViewById(R.id.favourite);
        LinearLayout file_info=view.findViewById(R.id.details);
        LinearLayout play_list=view.findViewById(R.id.play_list);
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomSheetDialogItemClickInterface.bottomDialogItemClicked(v,path,rowPositionNumber);
                    dismiss();
                }
            });

            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomSheetDialogItemClickInterface.bottomDialogItemClicked(v,path,rowPositionNumber);
                    dismiss();
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomSheetDialogItemClickInterface.bottomDialogItemClicked(v,path,rowPositionNumber);
                    dismiss();
                }
            });

            favourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomSheetDialogItemClickInterface.bottomDialogItemClicked(v,path,rowPositionNumber);
                    dismiss();
                }
            });

            file_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomSheetDialogItemClickInterface.bottomDialogItemClicked(v,path,rowPositionNumber);
                    dismiss();
                }
            });
            play_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomSheetDialogItemClickInterface.bottomDialogItemClicked(v,path,rowPositionNumber);
                    dismiss();
                }
            });
        return view;
    }
}
