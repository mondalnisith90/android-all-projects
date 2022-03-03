package com.example.listview;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ListView;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

  


}

class SingleRow{
    String name;
    int age;
    SingleRow(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
}

class MyBaseAdapter extends BaseAdapter
{
    Context context;
    String []name;
    int []age;

    ArrayList<SingleRow> list;

    MyBaseAdapter(Context c,String []name,int []age)
    {
        list=new ArrayList<SingleRow>();
        this.context=c;
        this.name=name;
        this.age=age;
        for (int i=0;i<15;i++)
        {
            list.add(new SingleRow(name[i],age[i]));

        }

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflate= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row=inflate.inflate(R.layout.activity_main2,parent,false);
        TextView tv1=(TextView)row.findViewById(R.id.textView1);
        TextView tv2=(TextView) row.findViewById(R.id.textView2);
        SingleRow temp=list.get(position);
        tv1.setText(temp.name);
        tv2.setText(temp.age);
        return row;
    }
}































