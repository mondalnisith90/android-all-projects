package com.music.audioplayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyViewHolder> {
    private FolderSongDisplayActivity folderSongDisplayActivity=null;
    private AllsongFragment allsongFragment=null;
    private FavouritesongFragment favouritesongFragment;
    private LongClickInterface longClickInterface;
    private OnClickInterface onClickInterface;
    private String allSongName[];
    private String allSongPath[];
    private String allSongSize[];
    private String allSongDateTimeInfo[];
//    private int image,image1;

    public MyRecyclerView(FolderSongDisplayActivity folderSongDisplayActivity,String []allSongName,String []allSongSize,String []allSongPath,String []allSongDateTimeInfo)
    {
        this.folderSongDisplayActivity=folderSongDisplayActivity;
       this.allSongName=allSongName;
       this.allSongPath=allSongPath;
       this.allSongSize=allSongSize;
       this.allSongDateTimeInfo=allSongDateTimeInfo;
//       this.image=image;
//       this.image1=image1;
    }

    public MyRecyclerView(AllsongFragment allsongFragment,String []allSongName,String []allSongSize,String []allSongPath,String []allSongDateTimeInfo)
    {
        this.allsongFragment=allsongFragment;
        this.allSongName=allSongName;
        this.allSongPath=allSongPath;
        this.allSongSize=allSongSize;
        this.allSongDateTimeInfo=allSongDateTimeInfo;
//       this.image=image;
//       this.image1=image1;
    }

    public MyRecyclerView(FavouritesongFragment favouritesongFragment,String []allSongName,String []allSongSize,String []allSongPath,String []allSongDateTimeInfo)
    {
        this.favouritesongFragment=favouritesongFragment;
        this.allSongName=allSongName;
        this.allSongPath=allSongPath;
        this.allSongSize=allSongSize;
        this.allSongDateTimeInfo=allSongDateTimeInfo;
//       this.image=image;
//       this.image1=image1;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i)
    {

        if (allsongFragment!=null)
        {
            onClickInterface=allsongFragment;
            longClickInterface=allsongFragment;
        }
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_apperance,viewGroup,false);
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
                if (folderSongDisplayActivity==null)
                {
                     threeDotClickEventInterface=allsongFragment;
                }
                else if (allsongFragment==null)
                {
                    threeDotClickEventInterface=folderSongDisplayActivity;
                }

                threeDotClickEventInterface.threeDotClickedEvent(v);
            }
        });
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.title.setText(allSongName[i]);
        myViewHolder.song_size.setText(allSongSize[i]+" MB");
        myViewHolder.song_path.setText(allSongPath[i]);
        myViewHolder.song_path.setVisibility(View.INVISIBLE);
        myViewHolder.date_time.setText(allSongDateTimeInfo[i]);
        myViewHolder.imageView1.setBackgroundResource(R.drawable.ic_favorite);
        myViewHolder.imageView.setBackgroundResource(R.drawable.ic_more_vert);
        myViewHolder.selectedMark.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        if (allSongName!=null)
        {
            return allSongName.length;
        }
        else
        {
            return 0;
        }

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView title,song_size,song_path,date_time;
        public ImageView imageView,imageView1,selectedMark;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            song_size=itemView.findViewById(R.id.song_size);
            song_path=itemView.findViewById(R.id.path);
            date_time=itemView.findViewById(R.id.date_time);
            imageView1=itemView.findViewById(R.id.image_view1);
            imageView=itemView.findViewById(R.id.image_view);
            selectedMark=itemView.findViewById(R.id.right_mark);

        }
    }
}
