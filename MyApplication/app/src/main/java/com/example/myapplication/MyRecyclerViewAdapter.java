package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>
{
    private ArrayList<RowItem> dataArrayList;
    private ArrayList<RowItem> selectedDataArrayList;
    private String []number;
    private int []images;
    private  MainActivity mainActivity;
    private boolean checkBox_status;
    private View view;


    public MyRecyclerViewAdapter(ArrayList<RowItem> dataArrayList,ArrayList<RowItem> selectedDataArrayList, String []number, int []images,boolean checkBox_status, MainActivity mainActivity) {

        this.dataArrayList=dataArrayList;
        this.selectedDataArrayList=selectedDataArrayList;
        this.number=number;
        this.images=images;
        this.checkBox_status=checkBox_status;
        this.mainActivity=mainActivity;
    }

    public void setCheckBoxStatus(boolean checkBox_status)
    {
        this.checkBox_status=checkBox_status;
    }

    public void selectItem(View view,int checked_item_position)
    {
        CheckBox checkBox=view.findViewById(R.id.check_box);
        //TextView textView=view.findViewById(R.id.text_view14);
        if (checkBox.getVisibility()==View.VISIBLE)
        {
        if(checkBox.isChecked())
        {
            checkBox.setChecked(false);
            changedataArrayList(checked_item_position,false);
            selectedDataArrayList.remove(dataArrayList.get(checked_item_position));

        }
        else
        {
            checkBox.setChecked(true);
            changedataArrayList(checked_item_position,true);
            selectedDataArrayList.add(dataArrayList.get(checked_item_position));
        }
        }

    }


    public void changedataArrayList(int position,boolean b)
    {
        dataArrayList.get(position).setShow_checkBox(b);
    }

    @NonNull
    //called by LayoutManager

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       // Log.d("ABCD","onCreateViewHolder() Position Valuenis "+i);
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_layout,viewGroup,false);
        view.setOnLongClickListener(mainActivity);
        view.setOnClickListener(mainActivity);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    public View getCurrentView()
    {
        return view;
    }

    //called by LayoutManager

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
       //Log.d("ABCD","adapter Position is "+viewHolder.getAdapterPosition());

        viewHolder.textView14.setText(dataArrayList.get(i).getName());
        viewHolder.imageView.setBackgroundResource(R.drawable.ic_beach);
        view=viewHolder.view;
        CheckBox  checkBox=viewHolder.checkBox;
        if(checkBox_status)
        {
            checkBox.setVisibility(View.VISIBLE);
            if(dataArrayList.get(i).isShow_checkBox())
            {
                checkBox.setChecked(true);
            }
            else
            {
                checkBox.setChecked(false);
            }
        }
        else
        {
            checkBox.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();

    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView textView14;
        public ImageView imageView;
        public CheckBox checkBox;
        public View view;
        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.image_view);
            textView14=(TextView) itemView.findViewById(R.id.text_view14);
            checkBox=itemView.findViewById(R.id.check_box);
            view=itemView;
//            itemView.setOnLongClickListener((View.OnLongClickListener) context);
              //itemView.setOnClickListener(click);


        }


    }


}
