package com.music.audioplayer;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MyRecyclerViewForFolder extends RecyclerView.Adapter<MyRecyclerViewForFolder.MyViewHolder>
{
    private ArrayList<CustomFile> entireFolders;
    private FoldersongFragment foldersongFragment;
    private SharedPraferanceForSavingColors sharedPraferanceForSavingColors;
    private SharedPraferenceForSingleRowAppearence sharedPraferenceForSingleRowAppearence;


    public MyRecyclerViewForFolder(FoldersongFragment foldersongFragment,HomeActivity homeActivity,ArrayList<CustomFile> entireFolders)
    {
        this.foldersongFragment=foldersongFragment;
        this.entireFolders=entireFolders;
        sharedPraferanceForSavingColors=new SharedPraferanceForSavingColors(homeActivity);
        sharedPraferenceForSingleRowAppearence=new SharedPraferenceForSingleRowAppearence(homeActivity);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_apperance_for_folder,viewGroup,false);
        view.setOnClickListener(foldersongFragment);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        CustomFile customFile=entireFolders.get(i);
        File folder = customFile.getFile();
        Song song = new Song();
        myViewHolder.folderIcon.setColorFilter(Color.parseColor(sharedPraferanceForSavingColors.getSavedFolderIconColor()));
        myViewHolder.folderTitle.setText(song.getFileName(folder));
        myViewHolder.folderTitle.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFolderTitleColor()));
        myViewHolder.folderPath.setText(song.getFilePath(folder));
        myViewHolder.folderPath.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFolderPathColor()));
        myViewHolder.folderPath.setVisibility(sharedPraferenceForSingleRowAppearence.getFolderPathVisivility());
        myViewHolder.folderItemNumber.setText(song.getFolderItemsNumber(folder)+" items");
        myViewHolder.folderItemNumber.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFolderItemColor()));
        myViewHolder.folderDateTime.setText(song.getFileDateTimeInfo(folder));
        myViewHolder.folderDateTime.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFolderDateTimeInfoColor()));
        myViewHolder.folderDateTime.setVisibility(sharedPraferenceForSingleRowAppearence.getFolderDateTimeInfoVisivility());

    }

    @Override
    public int getItemCount() {
        if (entireFolders != null) {
            return entireFolders.size();
        } else
        {
            return 0;
        }

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView folderTitle,folderItemNumber,folderDateTime,folderPath;
        public ImageView folderIcon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            folderIcon=itemView.findViewById(R.id.folder_icon);
            folderTitle=itemView.findViewById(R.id.folder_title);
            folderItemNumber=itemView.findViewById(R.id.folder_item_number);
            folderDateTime=itemView.findViewById(R.id.folder_date_time);
            folderPath=itemView.findViewById(R.id.folder_path);

        }
    }
}












