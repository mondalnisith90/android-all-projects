package com.music.trainyatra;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {


    private ArrayList<Station> allStationInfoArrayList;
    private OnCardViewClickListener onCardViewClickListener;


   public MyRecyclerViewAdapter(ArrayList<Station> allStationInfoArrayList,OnCardViewClickListener onCardViewClickListener){
       this.allStationInfoArrayList = allStationInfoArrayList;
       this.onCardViewClickListener = onCardViewClickListener;

   }


   public interface OnCardViewClickListener{
       void onCardViewClick(int position);
   }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_layout,viewGroup,false);
        return new MyViewHolder(view,onCardViewClickListener);
    }





    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

           if (position == 0) {
               myViewHolder.nextStationTag.setText("SOURCE STATION : ");
           } else if (position == allStationInfoArrayList.size() - 1) {
               myViewHolder.nextStationTag.setText("LAST STATION : ");
           } else {
               myViewHolder.nextStationTag.setText("NEXT STATION : ");
           }
           myViewHolder.stationName.setText(allStationInfoArrayList.get(position).getStationName());
           myViewHolder.arrivalTime.setText(allStationInfoArrayList.get(position).getArriavleTime());
           myViewHolder.distance.setText("DISTANCE : "+allStationInfoArrayList.get(position).getDistance()+" KM");
           myViewHolder.departureTime.setText(allStationInfoArrayList.get(position).getDepartureTime());
           myViewHolder.haltTime.setText("HALT : "+allStationInfoArrayList.get(position).getHalt()+" Minutes");
           myViewHolder.day.setText("DAY "+allStationInfoArrayList.get(position).getRunningDay());

    }

    @Override
    public int getItemCount() {
       int totalItem = 0;
       if (allStationInfoArrayList != null){
           totalItem = allStationInfoArrayList.size();
       }
        return totalItem;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        public TextView nextStationTag,stationName,arrivalTime,departureTime,distance,haltTime,day,details;

        private OnCardViewClickListener onCardViewClickListener;

        public MyViewHolder(@NonNull View itemView,OnCardViewClickListener obj) {
            super(itemView);
            nextStationTag = itemView.findViewById(R.id.next_station);
            stationName = itemView.findViewById(R.id.station_name);
            arrivalTime = itemView.findViewById(R.id.arriaval_time_value);
            departureTime = itemView.findViewById(R.id.departure_time_value);
            distance = itemView.findViewById(R.id.distance);
            haltTime = itemView.findViewById(R.id.halt_time);
            day = itemView.findViewById(R.id.day);
            details = itemView.findViewById(R.id.details);
            onCardViewClickListener = obj;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCardViewClickListener.onCardViewClick(getAdapterPosition());
                }
            });


        }
    }

}
