package com.music.audioplayer;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class HomeActivity extends AppCompatActivity implements FragmentCommunicationInterface {

    private ViewPager viewPager;
    private SharedPreferences sharedPreferences;
    private FragmentManager fragmentManager;
    private BottomNavigationView bottomNavigationView,bottomNavigationViewForLongClick;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private SearchView searchView;
    private MenuItem menuItem;
    private MenuItem sound_control,audio_speed,theme,setting,help,unSelect;
    private MenuItem playListIcon,favouriteIcon;
    private ArrayList<CustomFile> playListFiles;
    private ArrayList<File> selectedFilesForLongClick;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private ActionBar actionBar;
    private long previousMilliTime=0;
    private int currentDisplayedFragmentId=0;
    private  ActivityManager.MemoryInfo mi;
    ActivityManager activityManager;
    long maxMemory;
    Runtime rt;
    private FoldersongFragment foldersongFragment;
    private PlayListFragment playListFragment;
    private AllsongFragment allsongFragment;
    private FavouritesongFragment favouritesongFragment;
    public boolean isAnyFragmentItemSelected=false;
    public boolean isfragment0Selected=false;
    public boolean isfragment1Selected=false;
    public boolean isfragment2Selected=false;
    public boolean isfragment3Selected=false;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tab_layout);
        toolbar=findViewById(R.id.app_toolbar);
        bottomNavigationView=findViewById(R.id.bottom_navigation_view);
        bottomNavigationViewForLongClick=findViewById(R.id.bottom_navigation_view_longClick);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        actionBar.setTitle("Audio Player");
        fragmentManager=getSupportFragmentManager();
        playListFiles=new ArrayList<>();
        selectedFilesForLongClick=new ArrayList<>();
        sharedPreferences=getSharedPreferences("play_list_files", Context.MODE_PRIVATE);
        permission(this);
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationViewForLongClick.setVisibility(View.GONE);

//        rt=Runtime.getRuntime();
//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    maxMemory = rt.maxMemory();
//                    Log.d("ABCD", "Heap size " + maxMemory);
//                    long used_memory = (rt.totalMemory() - rt.freeMemory());
//                    Log.d("ABCD", "Used Memory " + used_memory);
//                    Log.d("ABCD", "Avaible Memory " + (rt.maxMemory() - used_memory));
//                    SystemClock.sleep(2000);
//                }
//            }
//        });
//        thread.start();

//        setPageradapterListener();
        bottomNavigationViewForLongClick.setOnNavigationItemSelectedListener(new MyOnNavigationItemSelectedListener(this));
        playListIcon=bottomNavigationViewForLongClick.getMenu().findItem(R.id.play_list);
        favouriteIcon=bottomNavigationViewForLongClick.getMenu().findItem(R.id.favourite);

        setPageradapterListener();


    }


    private void setPageradapterListener()
    {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentDisplayedFragmentId=i;
                switch (i)
                {
                    case 0:
                    {
                        if (foldersongFragment==null)
                        {
                            foldersongFragment = myFragmentPagerAdapter.getFolderFragmentObject();
                        }
                        if (foldersongFragment.getTotalSelectedItemsNumber()>0)
                        {
                            setActionBarTitle(foldersongFragment.getTotalSelectedItemsNumber() + " items Selected");
                        }
                        else if (isAnyFragmentItemSelected) {
                            HideActionBar();
//                            Log.d("ABCD","HideActionBar() is Called");
                        }
                        break;

                    }
                    case 1:
                    {
                        if (allsongFragment==null)
                        {
                            allsongFragment = myFragmentPagerAdapter.getAllsongFragmentObject();
                        }
                        if (allsongFragment.getTotalSelectedItemsNumber()>0)
                        {
                            setActionBarTitle(allsongFragment.getTotalSelectedItemsNumber() + " items Selected");
                        }
                        else if (isAnyFragmentItemSelected)
                        {
                            HideActionBar();
//                            Log.d("ABCD","HideActionBar() is Called");
                        }
                        break;
                    }
                    case 2:
                    {
                        if (playListFragment==null)
                        {
                            playListFragment = myFragmentPagerAdapter.getPlayListFragmentObject();
                        }
                        if (playListFragment.getTotalSelectedItemsNumber()>0)
                        {
                            setActionBarTitle(playListFragment.getTotalSelectedItemsNumber() + " items Selected");
                        }
                        else if (isAnyFragmentItemSelected)
                        {
                            HideActionBar();
//                            Log.d("ABCD","HideActionBar() is Called");
                        }
                        break;
                    }
                    case 3:
                    {
                        if (favouritesongFragment==null)
                        {
                            favouritesongFragment = myFragmentPagerAdapter.getFavouriteSongFragmentObject();
                        }
                        if (favouritesongFragment.getTotalSelectedItemsNumber()>0)
                        {
                            setActionBarTitle(favouritesongFragment.getTotalSelectedItemsNumber() + " items Selected");
                        }
                        else if (isAnyFragmentItemSelected)
                        {
                            HideActionBar();
//                            Log.d("ABCD","HideActionBar() is Called");
                        }
                       break;
                    }
                }


            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }






    @Override
    protected void onStart() {
        super.onStart();
        bottomNavigationView.setSelectedItemId(R.id.home);
        int nextFileIndex=sharedPreferences.getInt("nextSongIndex",0);
        if (nextFileIndex>0)
        {
            PlayListSharedPraferance playListSharedPraferance=new PlayListSharedPraferance(this);
            playListFiles.addAll(playListSharedPraferance.getAllFiles(nextFileIndex));
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("nextSongIndex",0);
            editor.commit();
            PlayListFragment playListFragment=myFragmentPagerAdapter.getPlayListFragmentObject();
            if (playListFragment!=null)
            {
                playListFragment.refreshRecyclerView();
            }
        }

        if (allsongFragment!=null) {
            allsongFragment.refreshRecyclerViewAdapter();
        }
        if (playListFragment!=null){
            playListFragment.refreshRecyclerView();
        }

        if (favouritesongFragment!=null){
            favouritesongFragment.refreshRecyclerViewAdapter();
        }
        if (myFragmentPagerAdapter!=null) {
        FoldersongFragment foldersongFragment1=myFragmentPagerAdapter.getFolderFragmentObject();
        if (foldersongFragment1!=null) {
            foldersongFragment1.refershRecyclerViewAdapterForFolderHigherci();
        }
        }



    }


    private void permission(final HomeActivity homeActivity)
    {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {

                        if (report.areAllPermissionsGranted())
                        {

                            String path="/storage/emulated/0/All/TT.mp3";
                            File file=new File(path);
                            Log.d("ABCD","is File Exist "+file.exists());
                            MediaMetadataRetriever mmr=new MediaMetadataRetriever();
                            mmr.setDataSource(path);
//                            InputStream inputStream=null;
//                            if (mmr.getEmbeddedPicture()!=null)
//                            {
//                                inputStream=new ByteArrayInputStream(mmr.getEmbeddedPicture());
//                            }

//                            byte []data=mmr.getEmbeddedPicture();
//                            Bitmap bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
//                            imageView100.setImageBitmap(bitmap);
//                            String name=mmr.extractMetadata(MediaMetadataRetriever.);
//                            Log.d("ABCD","value "+inputStream);
//                            Toast.makeText(getApplicationContext(), ""+name, Toast.LENGTH_SHORT).show();





                            myFragmentPagerAdapter=new MyFragmentPagerAdapter(fragmentManager,homeActivity,playListFiles);
                            viewPager.setAdapter(myFragmentPagerAdapter);
                            tabLayout.setupWithViewPager(viewPager);
                            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                                @Override
                                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                                    Intent intent=null;
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
                            });

                        }
                        if (report.isAnyPermissionPermanentlyDenied())
                        {

                        }

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

                        token.continuePermissionRequest();
                    }
                }).withErrorListener(new PermissionRequestErrorListener() {
            @Override
            public void onError(DexterError error) {
                Toast.makeText(getApplicationContext(),"SOME ERROR",Toast.LENGTH_LONG).show();
            }
        }).onSameThread()
        .check();
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
                intent=new Intent(HomeActivity.this,SettingActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.cancel:
            {
                HideActionBar();
                if (currentDisplayedFragmentId==0)
                {
                    FoldersongFragment foldersongFragment=myFragmentPagerAdapter.getFolderFragmentObject();
                    foldersongFragment.unCheckAllSelectedRow();
                }
                if (currentDisplayedFragmentId==1)
                {
                    AllsongFragment allsongFragment=myFragmentPagerAdapter.getAllsongFragmentObject();
                    allsongFragment.unCheckAllSelectedRow();
                }
                if (currentDisplayedFragmentId==2)
                {
                    PlayListFragment playListFragment=myFragmentPagerAdapter.getPlayListFragmentObject();
                    playListFragment.unCheckAllSelectedRow();
                }
                if (currentDisplayedFragmentId==3)
                {
                    FavouritesongFragment favouritesongFragment=myFragmentPagerAdapter.getFavouriteSongFragmentObject();
                    favouritesongFragment.unCheckAllSelectedRow();
                }
            }
        }
        return true;
    }

    private void expandModeAction()
    {
        menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                tabLayout.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.INVISIBLE);
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
                tabLayout.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);
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
    public void sendFile(File file)
    {
        addFilesToArrayList(file);
        Toast.makeText(getApplicationContext(),"File is added To PlayList ",Toast.LENGTH_SHORT).show();
    }

    private void addFilesToArrayList(File file)
    {
        byte []data;
        MediaMetadataRetriever mediaMetadataRetriever;
        Drawable drawable=null;
        Bitmap bitmap;
        String path;
        if (file.exists())
        {
            path=file.getAbsolutePath();
            mediaMetadataRetriever=new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(path);
            data=mediaMetadataRetriever.getEmbeddedPicture();
            if (data!=null)
            {
                bitmap=BitmapFactory.decodeByteArray(data,0,data.length);
                drawable=new BitmapDrawable(getResources(),bitmap);
            }
            playListFiles.add(new CustomFile(file,false,false,true,drawable));
            PlayListFragment playListFragment=myFragmentPagerAdapter.getPlayListFragmentObject();
            if (playListFragment!=null)
            {
                playListFragment.refreshRecyclerView();
            }
        }
    }

    public void SetSelectedFilesToArrayList(ArrayList<File> files)
    {
        selectedFilesForLongClick.addAll(files);
    }

    private void addFilesListToArrayList(ArrayList<File> file)
    {
        if (file.size()>0)
        {
            MediaMetadataRetriever mediaMetadataRetriever=new MediaMetadataRetriever();
            byte []data;
            String path=null;
            Bitmap bitmap=null;
            Drawable drawable=null;
            for (File f:file)
            {
                path=f.getAbsolutePath();
                mediaMetadataRetriever.setDataSource(path);
                data=mediaMetadataRetriever.getEmbeddedPicture();
                if (data!=null)
                {
                    bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
                    drawable=new BitmapDrawable(getResources(),bitmap);
                }
                playListFiles.add(new CustomFile(f,false,false,true,drawable));
            }
            PlayListFragment playListFragment = myFragmentPagerAdapter.getPlayListFragmentObject();
            if (playListFragment != null) {
                playListFragment.refreshRecyclerView();
            }
        }
    }

    @Override
    public void onBackPressed() {
        long currentMillitime=SystemClock.currentThreadTimeMillis();

        Log.d("TIME","Time "+currentMillitime);
        if (currentMillitime-previousMilliTime>40) {
            previousMilliTime=currentMillitime;
            toast=Toast.makeText(getApplicationContext(),"Press Back Button Again To Exit",Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            toast.cancel();
            super.onBackPressed();
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
        if(currentDisplayedFragmentId==2)
        {
            playListIcon.setVisible(false);
        }
        else
        {
            playListIcon.setVisible(true);
        }
        if (currentDisplayedFragmentId==3)
        {
            favouriteIcon.setVisible(false);
        }
        else
        {
            favouriteIcon.setVisible(true);
        }
        sound_control.setVisible(false);
        audio_speed.setVisible(false);
        setting.setVisible(false);
        theme.setVisible(false);
        help.setVisible(false);
    }

    public void HideActionBar()
    {
        actionBar.setTitle("Audio Player");
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

    public class MyOnNavigationItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        private HomeActivity homeActivity;
        public MyOnNavigationItemSelectedListener(HomeActivity homeActivity)
        {
            this.homeActivity=homeActivity;
        }
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId())
            {
                case R.id.share:
                {
                    Toast.makeText(homeActivity.getApplicationContext(), "Share is Clicked", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.delete:
                {

                    switch (currentDisplayedFragmentId)
                    {
                        case 3:
                        {

                        }
                    }


                    Toast.makeText(homeActivity.getApplicationContext(), "Delete is Clicked", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.favourite:
                {

                    switch (currentDisplayedFragmentId)
                    {
                        case 0: {
                            addSelectedFilesToFavouriteList0(homeActivity);
                            isAnyFragmentItemSelected=false;
                            break;
                        }
                        case 1: {
                            addSelectedFilesToFavouriteList1(homeActivity);
                            isAnyFragmentItemSelected=false;
                            break;
                        }
                        case 2: {
                            isAnyFragmentItemSelected=false;
                            break;
                        }
                        case 3: {
                            playListFunction3();
                            isAnyFragmentItemSelected=false;
                            break;
                        }
                    }
                    break;
                }

                case R.id.play_list:
                {

                    switch (currentDisplayedFragmentId)
                    {
                        case 0:
                        {
                            playListFunction0();
                            isAnyFragmentItemSelected=false;
                            break;
                        }
                        case 1:
                        {
                            playListFunction1();
                            isAnyFragmentItemSelected=false;
                            break;
                        }
                        case 2:
                        {
                            isAnyFragmentItemSelected=false;
                            break;
                        }
                        case 3:
                        {
                            playListFunction3();
                            isAnyFragmentItemSelected=false;
                            break;
                        }
                    }

                    break;
                }
            }
            return true;
        }
    }


    private void addSelectedFilesToFavouriteList0(HomeActivity homeActivity)
    {
        FoldersongFragment foldersongFragment=myFragmentPagerAdapter.getFolderFragmentObject();
        if (foldersongFragment.getTotalSelectedItemsNumber()>0)
        {
            ArrayList<File> fileList=foldersongFragment.getAllSelectedFiles();
            FavouriteFiles favouriteFiles=new FavouriteFiles(homeActivity);
            for (File f:fileList)
            {
                favouriteFiles.setFavouriteFilePathInSharedpraferance(f.getAbsolutePath());
            }
            foldersongFragment.unCheckAllSelectedRow();
            FavouritesongFragment favouritesongFragment=myFragmentPagerAdapter.getFavouriteSongFragmentObject();
            favouritesongFragment.refreshRecyclerView();
            HideActionBar();
            Toast.makeText(getApplicationContext(), " Files Are Added To Favourite List", Toast.LENGTH_SHORT).show();
        }
    }

    private void addSelectedFilesToFavouriteList1(HomeActivity homeActivity)
    {
        AllsongFragment allsongFragment=myFragmentPagerAdapter.getAllsongFragmentObject();
        if (allsongFragment.getTotalSelectedItemsNumber()>0)
        {
            ArrayList<File> fileList=allsongFragment.getAllSelectedFiles();
            FavouriteFiles favouriteFiles=new FavouriteFiles(homeActivity);
            for (File f:fileList)
            {
                favouriteFiles.setFavouriteFilePathInSharedpraferance(f.getAbsolutePath());
            }
            allsongFragment.unCheckAllSelectedRow();
            FavouritesongFragment favouritesongFragment=myFragmentPagerAdapter.getFavouriteSongFragmentObject();
            favouritesongFragment.refreshRecyclerView();
            HideActionBar();
            Toast.makeText(getApplicationContext(), " Files Are Added To Favourite List", Toast.LENGTH_SHORT).show();
        }
    }


//    private void addSelectedFilesToFavouriteList3(HomeActivity homeActivity)
//    {
//        PlayListFragment playListFragment=myFragmentPagerAdapter.getPlayListFragmentObject();
//        if (playListFragment.getTotalSelectedItemsNumber()>0)
//        {
//            ArrayList<File> fileList=playListFragment.getAllSelectedFiles();
//            FavouriteFiles favouriteFiles=new FavouriteFiles(homeActivity);
//            for (File f:fileList)
//            {
//                favouriteFiles.setFavouriteFilePathInSharedpraferance(f.getAbsolutePath());
//            }
//            playListFragment.unCheckAllSelectedRow();
//            FavouritesongFragment favouritesongFragment=myFragmentPagerAdapter.getFavouriteSongFragmentObject();
//            favouritesongFragment.refreshRecyclerView();
//            HideActionBar();
//            Toast.makeText(getApplicationContext(), " Files Are Added To Favourite List", Toast.LENGTH_SHORT).show();
//        }
//    }


    private void playListFunction0()//Just a method to Reduce code in Switch Case
    {
        FoldersongFragment foldersongFragment=myFragmentPagerAdapter.getFolderFragmentObject();
        if (foldersongFragment.getTotalSelectedItemsNumber()>0)
        {
            addFilesListToArrayList(foldersongFragment.getAllSelectedFiles());
            Toast.makeText(getApplicationContext(), " Files Are Added To Play List", Toast.LENGTH_SHORT).show();
            foldersongFragment.unCheckAllSelectedRow();
            HideActionBar();
        }
    }


    private void playListFunction1()//Just a method to Reduce code in Switch Case
    {
        AllsongFragment allsongFragment=myFragmentPagerAdapter.getAllsongFragmentObject();
        if (allsongFragment.getTotalSelectedItemsNumber()>0)
        {
            addFilesListToArrayList(allsongFragment.getAllSelectedFiles());
            Toast.makeText(getApplicationContext(), " Files Are Added To Play List", Toast.LENGTH_SHORT).show();
            allsongFragment.unCheckAllSelectedRow();
            HideActionBar();
        }
    }

    private void playListFunction3()//Just a method to Reduce code in Switch Case
    {
        FavouritesongFragment favouritesongFragment=myFragmentPagerAdapter.getFavouriteSongFragmentObject();
        if (favouritesongFragment.getTotalSelectedItemsNumber()>0)
        {
            addFilesListToArrayList(favouritesongFragment.getAllSelectedFiles());
            Toast.makeText(getApplicationContext(), " Files Are Added To Play List", Toast.LENGTH_SHORT).show();
            favouritesongFragment.unCheckAllSelectedRow();
            HideActionBar();
        }
    }


}

