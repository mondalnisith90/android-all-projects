package com.music.audioplayer;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import static com.music.audioplayer.R.drawable.ic_devices;

public class MyRecyclerViewForFolderHigherci extends RecyclerView.Adapter<MyRecyclerViewForFolderHigherci.MyViewHolder>
{

    private FolderHigherciSongDisplayActivity folderHigherciSongDisplayActivity=null;
    private FoldersongFragment foldersongFragment=null;
    private ClickEventInterface clickEventInterface;
    private LongClickInterface longClickInterface;
    private ThreeDotClickEventInterface threeDotClickEventInterface;
    private ArrayList<CustomFile> allFoldersAndFiles;
    private SharedPraferanceForSavingColors sharedPraferanceForSavingColors;
    private SharedPraferenceForSingleRowAppearence sharedPraferenceForSingleRowAppearence;

    public MyRecyclerViewForFolderHigherci(FolderHigherciSongDisplayActivity folderHigherciSongDisplayActivity,ArrayList<CustomFile> allFoldersAndFiles)
    {
        this.folderHigherciSongDisplayActivity=folderHigherciSongDisplayActivity;
        this.allFoldersAndFiles=allFoldersAndFiles;
        sharedPraferanceForSavingColors=new SharedPraferanceForSavingColors(folderHigherciSongDisplayActivity);
        sharedPraferenceForSingleRowAppearence=new SharedPraferenceForSingleRowAppearence(folderHigherciSongDisplayActivity);
    }

    public MyRecyclerViewForFolderHigherci(FoldersongFragment foldersongFragment,HomeActivity homeActivity,ArrayList<CustomFile> allFoldersAndFiles)
    {
        this.foldersongFragment=foldersongFragment;
        this.allFoldersAndFiles=allFoldersAndFiles;
        sharedPraferanceForSavingColors=new SharedPraferanceForSavingColors(homeActivity);
        sharedPraferenceForSingleRowAppearence=new SharedPraferenceForSingleRowAppearence(homeActivity);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        if (folderHigherciSongDisplayActivity!=null)
        {
            clickEventInterface=folderHigherciSongDisplayActivity;
            longClickInterface=folderHigherciSongDisplayActivity;
            threeDotClickEventInterface=folderHigherciSongDisplayActivity;
        }
        if (foldersongFragment!=null)
        {
            clickEventInterface=foldersongFragment;
            longClickInterface=foldersongFragment;
            threeDotClickEventInterface=foldersongFragment;
        }

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_apperance_for_folder_higherci,viewGroup,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEventInterface.clickEvent(v);
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClickInterface.onLongItemClick(v);
                return true;
            }
        });

        ImageView threeDot=view.findViewById(R.id.folder_higherciimage_view);
        threeDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threeDotClickEventInterface.threeDotClickedEvent(v);
            }
        });

        MyRecyclerViewForFolderHigherci.MyViewHolder myViewHolder=new MyRecyclerViewForFolderHigherci.MyViewHolder(view);
        return myViewHolder;

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        CustomFile customFile=allFoldersAndFiles.get(i);
        File file=customFile.getFile();
        Song song=new Song();
        Drawable drawableThumbnel=customFile.getDrawable();
        myViewHolder.rowPositionNumber.setText(""+i);
        if (file.exists())
        {
            if (customFile.isDirectory()) {
                myViewHolder.dateTimeInfo.setVisibility(View.VISIBLE);
                myViewHolder.fileThumblen.setVisibility(View.INVISIBLE);
                myViewHolder.folderIconImageView.setVisibility(View.VISIBLE);
                myViewHolder.folderItem.setVisibility(View.VISIBLE);
                myViewHolder.title.setText(song.getFileName(file));
                myViewHolder.title.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFolderTitleColor()));
                myViewHolder.folderPath.setText(song.getFilePath(file));
                myViewHolder.folderPath.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFolderPathColor()));
                myViewHolder.folderPath.setVisibility(sharedPraferenceForSingleRowAppearence.getFolderPathVisivility());
                myViewHolder.dateTimeInfo.setText(song.getFileDateTimeInfo(file));
                myViewHolder.dateTimeInfo.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFolderDateTimeInfoColor()));
                myViewHolder.dateTimeInfo.setVisibility(sharedPraferenceForSingleRowAppearence.getFolderDateTimeInfoVisivility());
                myViewHolder.threeDot.setVisibility(View.INVISIBLE);
                myViewHolder.folderIconImageView.setColorFilter(Color.parseColor(sharedPraferanceForSavingColors.getSavedFolderIconColor()));
                myViewHolder.folderItem.setText(song.getHighericalFolderItemsNumber(file)+" items");
                myViewHolder.folderItem.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFolderItemColor()));
            }
            else {
                myViewHolder.dateTimeInfo.setVisibility(View.VISIBLE);
                myViewHolder.fileThumblen.setVisibility(View.VISIBLE);
                myViewHolder.folderIconImageView.setVisibility(View.INVISIBLE);
                myViewHolder.folderItem.setVisibility(View.VISIBLE);
                myViewHolder.title.setText(song.getFileName(file));
                myViewHolder.title.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFileTitleColor()));
                myViewHolder.threeDot.setBackgroundResource(R.drawable.ic_more_vert);
                myViewHolder.threeDot.setVisibility(View.VISIBLE);
                myViewHolder.folderPath.setText(song.getFilePath(file));
                myViewHolder.folderPath.setVisibility(View.GONE);
                myViewHolder.folderItem.setText(song.getFileSize(file) + " MB");
                myViewHolder.folderItem.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFileSizeColor()));
                myViewHolder.folderItem.setVisibility(sharedPraferenceForSingleRowAppearence.getFileSizeVisivility());
                myViewHolder.dateTimeInfo.setText(song.getFileDateTimeInfo(file));
                myViewHolder.dateTimeInfo.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFileDateTimeInfoColor()));
                myViewHolder.dateTimeInfo.setVisibility(sharedPraferenceForSingleRowAppearence.getFileDateTimeInfoVisivility());
                if (customFile.isSelectedMark())
                {
                    myViewHolder.folderIconImageView.setVisibility(View.INVISIBLE);
                    myViewHolder.fileThumblen.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
                }
                else
                {
                    if (drawableThumbnel!=null) {
                        myViewHolder.fileThumblen.setBackground(customFile.getDrawable());
                    }else {
                        myViewHolder.folderIconImageView.setVisibility(View.INVISIBLE);
                        myViewHolder.fileThumblen.setBackgroundResource(R.drawable.ic_music_note);
                    }


                }
            }

        }
        else if (file.getAbsolutePath().equals("/129/0/mgh/t"))
        {
            Bitmap bitmap= BitmapFactory.decodeResource(foldersongFragment.getResources(),R.drawable.ic_devices);
            Log.e("ASCDF","Device Storage path "+file.getAbsolutePath());
            myViewHolder.title.setText("From Device Storage");
            myViewHolder.title.setTextColor(Color.RED);
            myViewHolder.folderPath.setVisibility(View.GONE);
            myViewHolder.folderPath.setText("/129/0/mgh/t");
            myViewHolder.dateTimeInfo.setVisibility(View.INVISIBLE);
            myViewHolder.threeDot.setVisibility(View.GONE);
//            myViewHolder.fileThumblen.setImageBitmap(bitmap);
            myViewHolder.fileThumblen.setBackgroundResource(R.drawable.ic_devices);
            myViewHolder.fileThumblen.setVisibility(View.VISIBLE);
            myViewHolder.folderIconImageView.setVisibility(View.INVISIBLE);
            myViewHolder.folderItem.setVisibility(View.INVISIBLE);
        }
        else if (file.getAbsolutePath().equals("/135/78/nmh/ght/01"))
        {
            myViewHolder.title.setText("From SD Card");
            myViewHolder.title.setTextColor(Color.RED);
            myViewHolder.folderPath.setVisibility(View.GONE);
            myViewHolder.folderPath.setText("/135/78/nmh/ght/01");
            myViewHolder.dateTimeInfo.setVisibility(View.INVISIBLE);
            myViewHolder.threeDot.setVisibility(View.GONE);
            myViewHolder.fileThumblen.setVisibility(View.VISIBLE);
            myViewHolder.fileThumblen.setBackgroundResource(R.drawable.ic_sd_storage_red);
            myViewHolder.folderIconImageView.setVisibility(View.INVISIBLE);
            myViewHolder.folderItem.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        if (allFoldersAndFiles!=null)
        {
            return allFoldersAndFiles.size();
        }
        else
        {
            return 0;
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title,dateTimeInfo,folderItem,folderPath,rowPositionNumber;
        public ImageView folderIconImageView,fileThumblen,threeDot;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            folderIconImageView=itemView.findViewById(R.id.folder_icon_image_view);
            title=itemView.findViewById(R.id.folder_higherci_title);
            dateTimeInfo=itemView.findViewById(R.id.folder_higherci_date_time);
            folderItem=itemView.findViewById(R.id.folder_higherci_item_number);
            folderPath=itemView.findViewById(R.id.folder_higherci_path);
            rowPositionNumber=itemView.findViewById(R.id.row_position_number);
            fileThumblen=itemView.findViewById(R.id.folder_higherci_image_view);
            threeDot=itemView.findViewById(R.id.folder_higherciimage_view);
        }
    }
}
