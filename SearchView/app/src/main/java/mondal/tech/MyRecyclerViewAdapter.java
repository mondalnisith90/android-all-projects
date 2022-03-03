package mondal.tech;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private MainActivity mainActivity;
    private ArrayList<String> countryName;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row_apperance,viewGroup,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    public void setDataSource(ArrayList<String> countryName)
    {
        this.countryName=countryName;
    }

    public MyRecyclerViewAdapter(MainActivity mainActivity, ArrayList<String> countryName)
    {
        this.mainActivity=mainActivity;
        this.countryName=countryName;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i)
    {

        viewHolder.textView.setText(countryName.get(i));

    }

    @Override
    public int getItemCount() {
        return countryName.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textView;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView=itemView.findViewById(R.id.text_view);

        }
    }

}
