package com.music.audioplayer;

import android.graphics.Color;
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

public class MyRecyclerViewAdapterForFavouriteFragment extends RecyclerView.Adapter<MyRecyclerViewAdapterForFavouriteFragment.MyViewHolder> {
    private FavouritesongFragment favouritesongFragment=null;
    private ThreeDotClickEventInterface threeDotClickEventInterface=null;
    private PlayListFragment playListFragment;
    private LongClickInterface longClickInterface;
    private OnClickInterface onClickInterface;
    private ArrayList<CustomFile> allFiles;
    private int images[]={R.drawable.ic_favorite_border,R.drawable.ic_favorite_border8,R.drawable.ic_favorite_border1,R.drawable.ic_favorite_border2,R.drawable.ic_favorite_border3,
            R.drawable.ic_favorite_border4,R.drawable.ic_favorite_border5,R.drawable.ic_favorite_border6,R.drawable.ic_favorite_border9,
            R.drawable.ic_favorite_border10,R.drawable.ic_favorite_border11,R.drawable.ic_favorite_border12,R.drawable.ic_favorite_border7};
    private int imageCounter=0;
    private SharedPraferanceForSavingColors sharedPraferanceForSavingColors;
    private SharedPraferenceForSingleRowAppearence sharedPraferenceForSingleRowAppearence;




    public MyRecyclerViewAdapterForFavouriteFragment(FavouritesongFragment favouritesongFragment,HomeActivity homeActivity, ArrayList<CustomFile> allFiles)
    {
        this.favouritesongFragment=favouritesongFragment;
        this.allFiles=allFiles;
        sharedPraferanceForSavingColors=new SharedPraferanceForSavingColors(homeActivity);
        sharedPraferenceForSingleRowAppearence=new SharedPraferenceForSingleRowAppearence(homeActivity);

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i)
    {

        if (favouritesongFragment!=null)
        {
            onClickInterface=favouritesongFragment;
            longClickInterface=favouritesongFragment;
            threeDotClickEventInterface=favouritesongFragment;
        }


        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_apperance_for_favourite_songfragment,viewGroup,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickInterface.onItemClicked(v);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClickInterface.onLongItemClick(v);
                return true;
            }
        });

        ImageView imageView=view.findViewById(R.id.image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (allsongFragment!=null)
//                {
//                    threeDotClickEventInterface=allsongFragment;
//                }
//                if (folderSongDisplayActivity!=null)
//                {
//                    threeDotClickEventInterface=folderSongDisplayActivity;
//                }


                threeDotClickEventInterface.threeDotClickedEvent(v);
            }
        });
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        CustomFile customFile=allFiles.get(i);
        File file=customFile.getFile();
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
        myViewHolder.imageView.setBackgroundResource(R.drawable.ic_more_vert);
        if (customFile.isThreeDotIconVisivle())
        {
            myViewHolder.imageView.setVisibility(View.VISIBLE);
        }else{
            myViewHolder.imageView.setVisibility(View.GONE);
        }
        if (customFile.isSelectedMark())
        {
            myViewHolder.imageView1.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
        }
        else
        {
            myViewHolder.imageView1.setBackgroundResource(images[imageCounter]);
        }

        if (imageCounter==12)
        {
            imageCounter=0;
        }
        else
        {
            imageCounter=imageCounter+1;
        }

    }


    @Override
    public int getItemCount() {
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
        public ImageView imageView,imageView1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            song_size=itemView.findViewById(R.id.song_size);
            song_path=itemView.findViewById(R.id.path);
            rowPositionNumber=itemView.findViewById(R.id.row_position_number);
            date_time=itemView.findViewById(R.id.date_time);
            imageView1=itemView.findViewById(R.id.image_view1);
            imageView=itemView.findViewById(R.id.image_view);

        }
    }
}