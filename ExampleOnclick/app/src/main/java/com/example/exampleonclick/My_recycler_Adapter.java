package com.example.exampleonclick;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class My_recycler_Adapter extends RecyclerView.Adapter<My_recycler_Adapter.MyViewHolder> {
    @NonNull

    //called by LayoutManager

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

      // LayoutInflater.from().inflate(R.layout)
        return null;
    }

    //called by LayoutManager

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView textView1,textView2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.text_view1);
            textView2=itemView.findViewById(R.id.text_view2);

        }
    }

}
