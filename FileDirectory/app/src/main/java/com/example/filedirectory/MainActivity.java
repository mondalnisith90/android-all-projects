package com.example.filedirectory;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textView,tv1;
    File file;
    ArrayList<String> arrayList;
    ListView listView;
    ArrayList<File> allSongs=new ArrayList<File>();
    ArrayList<File> allSongs1=new ArrayList<File>();
    ArrayAdapter<String> arrayAdapter;
    String []all_song_name;
    String []all_song_path;
    String []size_of_song;
    String []date_and_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);
        permission();
        if(allSongs!=null)
        {
            size_of_song=getSizeOfSongs(allSongs);
            date_and_time=getDateTimeOfSongs(allSongs);
            all_song_path=getAllSongPath(allSongs);
            displaySongs();
//            allSongs=null;

        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent service_intent=new Intent(getApplicationContext(),ForegroundService.class);
                Intent activity_intent=new Intent(getApplicationContext(),MusicControlActivity.class);
                activity_intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                service_intent.putExtra("position",position);
                service_intent.putExtra("all_song_name",all_song_name);
                service_intent.putExtra("all_song_path",all_song_path);
                service_intent.putExtra("come_from_activity",57080);
                startService(service_intent);
                startActivity(activity_intent);

            }
        });



    }




    public void permission() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response)
                    {
                        //read primary storage data
                         File primary_external_storage_file=Environment.getExternalStorageDirectory();
                         if(primary_external_storage_file.canRead())
                         {
                             allSongs.addAll(getMp3FilesFromSd(primary_external_storage_file));
                         }


                         //read secondary storage data

                         File random_files=new File("/storage");
                         File secondary_external_storage_file=null;
                         File []nested_files=random_files.listFiles();
                         if(nested_files!=null)
                         {
                             for (File file : nested_files) {
                                 if (file.canRead())
                                 {
                                     secondary_external_storage_file = file;
                                     allSongs1.addAll(getMp3FilesFromSd(secondary_external_storage_file));
                                 }
                             }
                         }
                         allSongs.addAll(allSongs1);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();

                    }
                }).check();
    }



    public ArrayList<File> getMp3FilesFromSd(File file)
    {
        ArrayList<File> arrayList=new ArrayList<File>();
        File []sub_root_files=file.listFiles();
        for (File folder : sub_root_files) {
                if (folder.isDirectory() && !folder.isHidden()) {
                    arrayList.addAll(getMp3FilesFromSd(folder));
                } else {
                    if (folder.getName().endsWith(".mp3")) {
                        arrayList.add(folder);
                    }
            }
        }
        return arrayList;
    }



    public  void displaySongs()
    {
        all_song_name=new String[allSongs.size()];
       for (int i=0;i<allSongs.size();i++)
       {
           all_song_name[i]=allSongs.get(i).getName();
       }
       MyArrayAdapter arrayAdapter=new MyArrayAdapter(getApplicationContext(),all_song_name,size_of_song,date_and_time);
       listView.setAdapter(arrayAdapter);
    }



    public class MyArrayAdapter extends ArrayAdapter
    {
        String []all_song_name;
        String []size_of_song;
        String []date_and_time;
        View root_view;

        public MyArrayAdapter(Context context,String []all_song_name,String []size_of_song,String []date_and_time)
        {
            super(context,R.layout.single_row,all_song_name);
            this.all_song_name=all_song_name;
            this.size_of_song=size_of_song;
            this.date_and_time=date_and_time;
        }

       // @androidx.annotation.NonNull
        @Override
        public View getView(int position,View convertView,ViewGroup parent)
        {
            root_view=convertView;
            StoreObject storeObject=null;
            if(root_view==null)
            {
                LayoutInflater layoutInflater=getLayoutInflater();
                root_view=layoutInflater.inflate(R.layout.single_row,parent,false);
                storeObject=new StoreObject(root_view);
                root_view.setTag(storeObject);
            }
            else
            {
                storeObject=(StoreObject) root_view.getTag();
            }
            storeObject.textView1.setText(all_song_name[position]);
            storeObject.textView2.setText(size_of_song[position]+" MB");
            storeObject.textView3.setText(date_and_time[position]);
            return root_view;
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



    public String[] getSizeOfSongs(ArrayList<File> arrayList)
    {
        String song_size[] = new String[arrayList.size()];
        double l;
        String value;
        for(int i=0;i<arrayList.size();i++)
        {
            l=arrayList.get(i).length()/1048576.0;
            song_size[i]=String.format("%.2f",l);
        }
        return song_size;
    }



    public String[] getDateTimeOfSongs(ArrayList<File> arrayList)
    {
        String []date_time=new String[arrayList.size()];
        String time;
        long milliSecond;
        SimpleDateFormat simpleDateFormat;
        for(int i=0;i<arrayList.size();i++)
        {
            time=""+arrayList.get(i).lastModified();
            milliSecond=Long.parseLong(time);
            simpleDateFormat=new SimpleDateFormat("MMMM/dd/yyyy  HH:mm");
            date_time[i]=simpleDateFormat.format(new Date(milliSecond));
        }
        return date_time;
    }

    public String[] getAllSongPath(ArrayList<File> arrayList)
    {
        String []all_song_path=new String[arrayList.size()];
        for (int i = 0; i <arrayList.size() ; i++)
        {
            all_song_path[i]=arrayList.get(i).getAbsolutePath();

        }
        return all_song_path;
    }
}


























