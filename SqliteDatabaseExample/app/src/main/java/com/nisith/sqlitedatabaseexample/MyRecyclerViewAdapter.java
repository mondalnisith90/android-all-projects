package com.nisith.sqlitedatabaseexample;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private Cursor cursor;
    private OnDeleteIconClickListener onDeleteIconClickListener;
    public interface OnDeleteIconClickListener{
        void onDeleteIconClick(int position,int userId);
    }

    public MyRecyclerViewAdapter(Cursor cursor,OnDeleteIconClickListener onDeleteIconClickListener){
        this.cursor = cursor;
        this.onDeleteIconClickListener = onDeleteIconClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_single_row,viewGroup,false);
        return new MyViewHolder(view,onDeleteIconClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        cursor.moveToPosition(position);
        int userId = (cursor.getInt(cursor.getColumnIndex(MySQLiteHelper.getColumnId())));
        String userName = cursor.getString(cursor.getColumnIndex(MySQLiteHelper.getColumnName()));
        String password = cursor.getString(cursor.getColumnIndex(MySQLiteHelper.getColumnPassword()));
        String date = cursor.getString(cursor.getColumnIndex(MySQLiteHelper.getColumnDate()));
        myViewHolder.mUserName.setText(userName);
        myViewHolder.mPassword.setText(password);
        myViewHolder.mDate.setText(date);
        myViewHolder.deletImageIcon.setTag(userId);

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mUserName,mPassword,mDate;
        ImageView deletImageIcon;

        public MyViewHolder(@NonNull View itemView,final OnDeleteIconClickListener onDeleteIconClickListener) {
            super(itemView);
            mUserName = itemView.findViewById(R.id.name_text_view);
            mPassword = itemView.findViewById(R.id.password_text_view);
            mDate = itemView.findViewById(R.id.date_text_view);
            deletImageIcon = itemView.findViewById(R.id.delete_image_view);
            deletImageIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int userId = (int) v.getTag();
                    onDeleteIconClickListener.onDeleteIconClick(getAdapterPosition(),userId);
                }
            });
        }
    }

    public void setCursor(Cursor newCursor){
        if (cursor!=null){
            cursor.close();
        }
        cursor = newCursor;
    }
    public void setNotifyItemInseretd(int position){
//        notifyItemInserted(position);
        notifyDataSetChanged();
    }

    public void setNotifyItemRemove(int position){
        notifyItemRemoved(position);
//        notifyDataSetChanged();
    }

}
