package com.example.testview;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String []name={"1","2","3","4","5","6","7","8","9","10","4","5","6","7","8","9","10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list_view);
        MyArrayAdapter myArrayAdapter=new MyArrayAdapter(getApplicationContext(),name);
        listView.setAdapter(myArrayAdapter);
       // DateFormat simpleDateFormat=new SimpleDateFormat("mm/dd/yyyy HH:mm:ss");
       // String format = simpleDateFormat.format(new Date(14208989809090909090));
        String milli="1564159802000";
        long foo=Long.parseLong(milli);
        Date date=new Date(foo);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMMM/dd/yyyy HH:mm");
        Log.d("ABCD",""+simpleDateFormat.format(date));



    }

    public class MyArrayAdapter extends ArrayAdapter
    {

        private  View root_layout;
        public MyArrayAdapter(Context context,String []name) {
            super(context,R.layout.activity2,name);
        }

        //@androidx.annotation.NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            root_layout=convertView;
            StoreObject storeObject=null;

            if(root_layout==null)
            {
                LayoutInflater layoutInflater=getLayoutInflater();
                root_layout=layoutInflater.inflate(R.layout.activity2,parent,false);
                storeObject=new StoreObject(root_layout);
                root_layout.setTag(storeObject);
            }
            else
            {
                storeObject= (StoreObject) root_layout.getTag();
            }
            storeObject.textView1.setText("Badsahi Angati part1 by satajit Roy.MP3");
            storeObject.textView2.setText("34.87 MB");
            storeObject.textView3.setText("15:11:2019");
            return root_layout;
        }
    }

    public class StoreObject
    {

        TextView textView1,textView2,textView3;
        public StoreObject(View root_layout)
        {
            textView1=(TextView)root_layout.findViewById(R.id.tv1);
            textView2=(TextView)root_layout.findViewById(R.id.tv2);
            textView3=(TextView)root_layout.findViewById(R.id.tv3);
        }


    }

}











