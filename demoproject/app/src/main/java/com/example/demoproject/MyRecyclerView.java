package com.example.demoproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyViewHolder> {

    private String []name;

    public MyRecyclerView(String []name)
    {
        this.name=name;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row,viewGroup,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

        viewHolder.textView.setText(name[i]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text_view1);
        }
    }


}
