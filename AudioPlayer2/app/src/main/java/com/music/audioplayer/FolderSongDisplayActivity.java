package com.music.audioplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FolderSongDisplayActivity extends AppCompatActivity implements ThreeDotClickEventInterface,BottomSheetDialogItemClickInterface,LongClickInterface ,OnClickInterface{

    private ArrayList<CustomFile> folderFiles;
    private boolean isLongItemClickEventExist=false;
    private int totalSelectedItem=0;
    private MenuItem menuItem,sound_control,audio_speed,theme,unSelect,setting,help;
    private BottomNavigationView bottomNavigationView,bottomNavigationViewForLongClick;
    private SearchView searchView;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private SharedPreferences sharedPreferences;
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapterForFolderSongDisplayActivity myRecyclerViewAdapterForFolderSongDisplayActivity;
    private String folderTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder_song_display);
        recyclerView=findViewById(R.id.folder_song_display_recyclerview);
        toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        bottomNavigationView=findViewById(R.id.bottom_navigation_view);
        bottomNavigationViewForLongClick=findViewById(R.id.bottom_navigation_view_longClick);
        actionBar=getSupportActionBar();
        if (actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Intent intent=getIntent();
        folderTitle=intent.getStringExtra("folder_title");
        actionBar.setTitle(folderTitle);
        String path=intent.getStringExtra("path");
        File folder=new File(path);
        Song song=new Song();
        folderFiles=new ArrayList<>();
        ArrayList<File> folderSongs=new ArrayList<>();
        folderSongs.addAll(song.getFolderMp3Songs(folder));
        MediaMetadataRetriever mediaMetadataRetriever=new MediaMetadataRetriever();
        byte []data;
        String filePath=null;
        Bitmap bitmap=null;
        Drawable drawable=null;
        for (File file1:folderSongs)
        {
            filePath=file1.getAbsolutePath();
            mediaMetadataRetriever.setDataSource(filePath);
            data=mediaMetadataRetriever.getEmbeddedPicture();
            if (data!=null)
            {
                bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
                drawable=new BitmapDrawable(getResources(),bitmap);
            }
            folderFiles.add(new CustomFile(file1,false,false,true,drawable));
        }
        sharedPreferences=getSharedPreferences("play_list_files",MODE_PRIVATE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        myRecyclerViewAdapterForFolderSongDisplayActivity=new MyRecyclerViewAdapterForFolderSongDisplayActivity(this,folderFiles);
        recyclerView.setAdapter(myRecyclerViewAdapterForFolderSongDisplayActivity);
        bottomNavigationView.setOnNavigationItemSelectedListener(new MyBottomNavigationViewItemSelectListener());
        bottomNavigationViewForLongClick.setOnNavigationItemSelectedListener(new bottomNavigationViewForLongClickItemSelectedListeer(this));
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationViewForLongClick.setVisibility(View.GONE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (myRecyclerViewAdapterForFolderSongDisplayActivity!=null)
        {
            myRecyclerViewAdapterForFolderSongDisplayActivity.notifyDataSetChanged();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }

    class bottomNavigationViewForLongClickItemSelectedListeer implements BottomNavigationView.OnNavigationItemSelectedListener
    {
        private FolderSongDisplayActivity folderSongDisplayActivity;
        public bottomNavigationViewForLongClickItemSelectedListeer(FolderSongDisplayActivity folderSongDisplayActivity)
        {
            this.folderSongDisplayActivity=folderSongDisplayActivity;
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
        {
            switch (menuItem.getItemId())
            {
                case R.id.share:
                {
                    Toast.makeText(getApplicationContext(), "Share is Clicked", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.delete:
                {
                    Toast.makeText(getApplicationContext(), "Delete is Clicked", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.favourite:
                {
                    favouriteFuncion(folderSongDisplayActivity);
                    break;
                }

                case R.id.play_list:
                {
                    playListFunction(folderSongDisplayActivity);
                }
            }
            return true;
        }
    }


    private void playListFunction(FolderSongDisplayActivity folderSongDisplayActivity)//It's Just a method to reduce code in switch Case
    {

        if (getAllSelectedFiles().size()>0)
        {
            ArrayList<File> arrayList=getAllSelectedFiles();
            PlayListSharedPraferance playListSharedPraferance=new PlayListSharedPraferance(folderSongDisplayActivity);
            for (File f:arrayList)
            {
                playListSharedPraferance.setPlayListFilePathInSharedParferance(f.getAbsolutePath());
            }
            unCheckAllSelectedRow();
            Toast.makeText(getApplicationContext(), "Files are added To Play List", Toast.LENGTH_SHORT).show();
        }
    }


    private void favouriteFuncion(FolderSongDisplayActivity folderSongDisplayActivity)//It's Just a method to reduce code in switch Case
    {
        if (getAllSelectedFiles().size()>0)
        {
            ArrayList<File> arrayList = getAllSelectedFiles();
            FavouriteFiles favouriteFiles = new FavouriteFiles(folderSongDisplayActivity);
            for (File file : arrayList)
            {
                favouriteFiles.setFavouriteFilePathInSharedpraferance(file.getAbsolutePath());
            }
            unCheckAllSelectedRow();
            Toast.makeText(getApplicationContext(), "File is added To Favourite List", Toast.LENGTH_SHORT).show();
        }
    }


    class MyBottomNavigationViewItemSelectListener implements BottomNavigationView.OnNavigationItemSelectedListener
    {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
        {
            Intent intent;
            switch (menuItem.getItemId())
            {
                case R.id.home:
                    intent=new Intent(getApplicationContext(),HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    break;
                case R.id.setting:
                    intent=new Intent(getApplicationContext(),SettingActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    break;
                case R.id.storage_status:
                    intent=new Intent(getApplicationContext(),SongInfoActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    break;
                case R.id.play_list:
                    intent=new Intent(getApplicationContext(),SettingActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    break;
            }

            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.app_menu,menu);
        menuItem=menu.findItem(R.id.search_view);
        unSelect=menu.findItem(R.id.cancel);
        unSelect.setVisible(false);
        sound_control=menu.findItem(R.id.sound_control);
        audio_speed=menu.findItem(R.id.audio_speed);
        setting=menu.findItem(R.id.setting);
        theme=menu.findItem(R.id.theme);
        help=menu.findItem(R.id.help);
        searchView=(SearchView) menuItem.getActionView();
        expandModeAction();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent;
        switch (item.getItemId())
        {
            case R.id.setting:
            {
                intent=new Intent(FolderSongDisplayActivity.this,SettingActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.cancel:
                {
                HideActionBar();
                unCheckAllSelectedRow();
                break;
            }

            case 16908332://For Back Button Press in Toolbar
            {
                finish();
                overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
            }
        }
        return true;
    }

    private void expandModeAction()
    {
        menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                sound_control.setVisible(false);
                audio_speed.setVisible(false);
                unSelect.setVisible(false);
                setting.setVisible(false);
                theme.setVisible(false);
                help.setVisible(false);
                searchView.setIconifiedByDefault(true);
                searchView.setMaxWidth(Integer.MAX_VALUE);
                searchView.setQueryHint("Search songs");
                toolbar.setBackgroundColor(Color.BLUE);
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                toolbar.setBackgroundColor(Color.parseColor("#1976D2"));
                unSelect.setVisible(false);
                sound_control.setVisible(true);
                audio_speed.setVisible(true);
                setting.setVisible(true);
                theme.setVisible(true);
                help.setVisible(true);
                return true;
            }
        });
    }

    @Override
    public void threeDotClickedEvent(View view)
    {
        RelativeLayout rootView=(RelativeLayout) view.getParent().getParent().getParent();
        TextView path=rootView.findViewById(R.id.path);
        BottomSheetdialogFragment bottomSheetdialogFragment=new BottomSheetdialogFragment(this,path.getText().toString());
        bottomSheetdialogFragment.show(getSupportFragmentManager(),"ABC");

    }

    @Override
    public void bottomDialogItemClicked(View view,String path,int rowPositionNumber)
    {
        switch (view.getId())
        {
            case R.id.play:
//                Toast.makeText(getApplicationContext(),"play is Clicked",Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(FolderSongDisplayActivity.this,MusicControlActivity.class);
                startActivity(intent1);

                break;
            case R.id.share:
                Toast.makeText(getApplicationContext(),"share is Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                AlertDialogForDelete alertDialogForDelete=new AlertDialogForDelete(path);
                alertDialogForDelete.show(getSupportFragmentManager(),"ABC");
                break;
            case R.id.favourite:
                FavouriteFiles favouriteFiles=new FavouriteFiles(this);
                favouriteFiles.setFavouriteFilePathInSharedpraferance(path);
                Toast.makeText(getApplicationContext(),"File is added To Favourite List",Toast.LENGTH_SHORT).show();
                break;
            case R.id.details:
                Intent intent=new Intent(getApplicationContext(),SongInfoActivity.class);
                intent.putExtra("path",path);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
                break;
            case R.id.play_list:
                PlayListSharedPraferance playListSharedPraferance=new PlayListSharedPraferance(this);
                playListSharedPraferance.setPlayListFilePathInSharedParferance(path);
                Toast.makeText(getApplicationContext(),"File is added To PlayList",Toast.LENGTH_SHORT).show();
                break;
        }
    }



    public void setActionBarTitle(String title)
    {
        actionBar.setTitle(title);
        unSelect.setVisible(true);
        searchView.setVisibility(View.GONE);
        searchView.setBackgroundColor(Color.BLUE);
        bottomNavigationView.setVisibility(View.INVISIBLE);
        bottomNavigationViewForLongClick.setVisibility(View.VISIBLE);
        sound_control.setVisible(false);
        audio_speed.setVisible(false);
        setting.setVisible(false);
        theme.setVisible(false);
        help.setVisible(false);
    }

    public void HideActionBar()
    {
        actionBar.setTitle(folderTitle);
        unSelect.setVisible(false);
        searchView.setVisibility(View.VISIBLE);
        searchView.setBackgroundColor(Color.WHITE);
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationViewForLongClick.setVisibility(View.INVISIBLE);
        sound_control.setVisible(true);
        audio_speed.setVisible(true);
        setting.setVisible(true);
        theme.setVisible(true);
        help.setVisible(true);
    }

    public void unCheckAllSelectedRow()
    {
        for (CustomFile customFile:folderFiles)
        {
            customFile.setSelectedMark(false);
            customFile.setThreeDotIconVisibility(true);
        }
        totalSelectedItem=0;
        HideActionBar();
        isLongItemClickEventExist=false;
        myRecyclerViewAdapterForFolderSongDisplayActivity.notifyDataSetChanged();
    }

    public ArrayList<File> getAllSelectedFiles()
    {
        ArrayList<File> arrayList=new ArrayList<>();
        for (CustomFile customFile:folderFiles)
        {
            if (customFile.isSelectedMark())
            {
                arrayList.add(customFile.getFile());
            }
        }

        return arrayList;
    }


    @Override
    public void onLongItemClick(View view)
    {
        ImageView threeDot=view.findViewById(R.id.image_view);
        ImageView imageView=view.findViewById(R.id.image_view1);
        TextView textView_path=view.findViewById(R.id.path);
        TextView rowPositionNumberTextView=view.findViewById(R.id.row_position_number);
        int rowPositionNumber=Integer.parseInt(rowPositionNumberTextView.getText().toString());
        String path=textView_path.getText().toString();
        File file=new File(path);
        isLongItemClickEventExist=true;
        if (file.exists())
        {
            CustomFile customFile = folderFiles.get(rowPositionNumber);
            if (!customFile.isSelectedMark())
            {
                threeDot.setVisibility(View.GONE);
                imageView.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
                totalSelectedItem = totalSelectedItem + 1;
                setActionBarTitle(totalSelectedItem + " item Selected");
                customFile.setSelectedMark(true);
                customFile.setThreeDotIconVisibility(false);
            }
        }
       bottomMenuForLongClickEventVisible();

    }

    public void bottomMenuForLongClickEventVisible()
    {
        bottomNavigationView.setVisibility(View.GONE);
        bottomNavigationViewForLongClick.setVisibility(View.VISIBLE);
    }

    public void bottomMenuForLongClickEventInvisible()
    {
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationViewForLongClick.setVisibility(View.GONE);
    }



    @Override
    public void onItemClicked(View view)
    {

        if (isLongItemClickEventExist)
        {
            TextView rowPositionNumberTextView=view.findViewById(R.id.row_position_number);
            int rowPositionNumber=Integer.parseInt(rowPositionNumberTextView.getText().toString());
            ImageView imageView=view.findViewById(R.id.image_view1);
            ImageView threeDot=view.findViewById(R.id.image_view);
            CustomFile customFile=folderFiles.get(rowPositionNumber);
            if (!customFile.isSelectedMark())
            {
                threeDot.setVisibility(View.GONE);
                customFile.setSelectedMark(true);
                customFile.setThreeDotIconVisibility(false);
                imageView.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
                totalSelectedItem=totalSelectedItem+1;
                setActionBarTitle(totalSelectedItem+" item Selected");
            }
            else
            {
                threeDot.setVisibility(View.VISIBLE);
                customFile.setSelectedMark(false );
                customFile.setThreeDotIconVisibility(true);
                imageView.setBackground(customFile.getDrawable());
                if (totalSelectedItem>0)
                {
                    totalSelectedItem=totalSelectedItem-1;
                }
                setActionBarTitle(totalSelectedItem+" item Selected");
                if (totalSelectedItem==0)
                {
                    HideActionBar();
                    isLongItemClickEventExist=false;
                }
            }
        }
        else
        {
//            Toast.makeText(getApplicationContext(),"SERVICE IS STARTED",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(FolderSongDisplayActivity.this,MusicControlActivity.class);
            startActivity(intent);
        }

    }



}
















