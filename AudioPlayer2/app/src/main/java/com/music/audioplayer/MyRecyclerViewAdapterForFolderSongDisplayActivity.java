package com.music.audioplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MyRecyclerViewAdapterForFolderSongDisplayActivity extends RecyclerView.Adapter<MyRecyclerViewAdapterForFolderSongDisplayActivity.MyViewHolder> {

    private FolderSongDisplayActivity folderSongDisplayActivity=null;
    private ArrayList<CustomFile> allFiles;
    private LongClickInterface longClickInterface;
    private OnClickInterface onClickInterface;
    private MediaMetadataRetriever mediaMetadataRetriever;
    private SharedPraferanceForSavingColors sharedPraferanceForSavingColors;
    private SharedPraferenceForSingleRowAppearence sharedPraferenceForSingleRowAppearence;
    private Bitmap bitmap;



    public MyRecyclerViewAdapterForFolderSongDisplayActivity(FolderSongDisplayActivity folderSongDisplayActivity,ArrayList<CustomFile> allFiles)
    {
        this.folderSongDisplayActivity=folderSongDisplayActivity;
        this.allFiles=allFiles;
        mediaMetadataRetriever=new MediaMetadataRetriever();
        sharedPraferanceForSavingColors=new SharedPraferanceForSavingColors(folderSongDisplayActivity);
        sharedPraferenceForSingleRowAppearence=new SharedPraferenceForSingleRowAppearence(folderSongDisplayActivity);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {

        if (folderSongDisplayActivity!=null)
        {
            onClickInterface=folderSongDisplayActivity;
            longClickInterface=folderSongDisplayActivity;
        }
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_apperance,viewGroup,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickInterface.onItemClicked(v);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(viewGroup.getContext(),"Row is long Clicked",Toast.LENGTH_LONG).show();
                longClickInterface.onLongItemClick(v);
                return true;
            }
        });
        ImageView imageView=view.findViewById(R.id.image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreeDotClickEventInterface threeDotClickEventInterface=null;
                if (folderSongDisplayActivity!=null)
                {
                    threeDotClickEventInterface=folderSongDisplayActivity;
                }


                assert threeDotClickEventInterface != null;
                threeDotClickEventInterface.threeDotClickedEvent(v);
            }
        });
        MyRecyclerViewAdapterForFolderSongDisplayActivity.MyViewHolder myViewHolder=new MyRecyclerViewAdapterForFolderSongDisplayActivity.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        CustomFile customFile=allFiles.get(i);
        File file=customFile.getFile();
        Drawable drawableThumbnel=customFile.getDrawable();
        boolean selectedMark=customFile.isSelectedMark();
        Song song=new Song();
        myViewHolder.title.setText(song.getFileName(file));
        myViewHolder.title.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFileTitleColor()));
        myViewHolder.song_size.setText(song.getFileSize(file)+" MB");
        myViewHolder.song_size.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFileSizeColor()));
        myViewHolder.song_size.setVisibility(sharedPraferenceForSingleRowAppearence.getFileSizeVisivility());
        myViewHolder.song_path.setText(song.getFilePath(file));
        myViewHolder.song_path.setVisibility(View.INVISIBLE);
        myViewHolder.rowPositionNumber.setText(""+i);
        myViewHolder.rowPositionNumber.setVisibility(View.GONE);
        myViewHolder.date_time.setText(song.getFileDateTimeInfo(file));
        myViewHolder.date_time.setTextColor(Color.parseColor(sharedPraferanceForSavingColors.getSavedFileDateTimeInfoColor()));
        myViewHolder.date_time.setVisibility(sharedPraferenceForSingleRowAppearence.getFileDateTimeInfoVisivility());
        myViewHolder.selectedMark.setVisibility(View.GONE);
        myViewHolder.imageView.setBackgroundResource(R.drawable.ic_more_vert);
        if (customFile.isThreeDotIconVisivle())
        {
            myViewHolder.imageView.setVisibility(View.VISIBLE);
        }else{
            myViewHolder.imageView.setVisibility(View.GONE);
        }
        if (selectedMark)
        {
            myViewHolder.imageView1.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
        }
        else
        {
            if (drawableThumbnel!=null) {
                myViewHolder.imageView1.setBackground(customFile.getDrawable());
            }else {
                myViewHolder.imageView1.setBackgroundResource(R.drawable.ic_music_note);
            }
        }

    }

    @Override
    public int getItemCount()
    {
        if (allFiles!=null)
        {
            return allFiles.size();
        }
        else
        {
            return 0;
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title,song_size,song_path,rowPositionNumber,date_time;
        public ImageView imageView,imageView1,selectedMark;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            song_size=itemView.findViewById(R.id.song_size);
            song_path=itemView.findViewById(R.id.path);
            rowPositionNumber=itemView.findViewById(R.id.row_position_number);
            date_time=itemView.findViewById(R.id.date_time);
            imageView1=itemView.findViewById(R.id.image_view1);
            imageView=itemView.findViewById(R.id.image_view);
            selectedMark=itemView.findViewById(R.id.right_mark);
        }
    }
}
