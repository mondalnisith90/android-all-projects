package com.nisith.retrofitexample;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<Photo> photoList;
    private  OnCardViewClickListener onCardViewClickListener;



    public interface OnCardViewClickListener{
        //Card View Click Listener
         void onCardViewClick(String imageUrl);
    }

    public MyRecyclerViewAdapter(List<Photo> photoList, OnCardViewClickListener  onCardViewClickListener){
        this.photoList = photoList;
        this.onCardViewClickListener = onCardViewClickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_apperance,viewGroup,false);
        return new MyViewHolder(view,onCardViewClickListener,photoList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Photo photoObj = photoList.get(position);
        myViewHolder.id.setText(""+photoObj.getId());
        myViewHolder.albumId.setText(""+photoObj.getAlbumId());
        myViewHolder.title.setText(photoObj.getTitle());
        Picasso.get().load(photoObj.getThumbnailUrl()).error(R.drawable.ic_android_black_24dp).into(myViewHolder.imageThumbnail);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageThumbnail;
        public TextView id,albumId,title;

        MyViewHolder(@NonNull View itemView,final OnCardViewClickListener onCardViewClickListener,final List<Photo> photoList) {
            super(itemView);
            imageThumbnail = itemView.findViewById(R.id.image_thumbnail);
            id = itemView.findViewById(R.id.id);
            albumId = itemView.findViewById(R.id.album_id);
            title = itemView.findViewById(R.id.album_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    onCardViewClickListener.onCardViewClick(photoList.get(position).getUrl());
                }
            });


        }
    }
}
