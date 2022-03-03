package com.music.audioplayer;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;


public class FoldersongFragment extends Fragment implements View.OnClickListener,ClickEventInterface,LongClickInterface,ThreeDotClickEventInterface,BottomSheetDialogItemClickInterface{

    private ArrayList<CustomFile> entireFolders;
    private ArrayList<CustomFile> entireHigherciFoldersAndFiles;
    private int image1=R.drawable.ic_folder;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private boolean allFolder,folderHigherci;
    private boolean isFragmentViewDestroyed=false;
    private HomeActivity homeActivity;
    private boolean isLongItemClickEventExist=false;
    private int totalSelectedItem=0;
    private MyRecyclerViewForFolderHigherci myRecyclerViewForFolderHigherci;
    private MyRecyclerViewForFolder myRecyclerViewForFolder;

    public FoldersongFragment(){}

    @SuppressLint("ValidFragment")
    public FoldersongFragment(HomeActivity homeActivity)
    {
        this.homeActivity=homeActivity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences= Objects.requireNonNull(getActivity()).getSharedPreferences("folder_view_setting",Context.MODE_PRIVATE);
        allFolder=false;
        folderHigherci=false;
        entireFolders=new ArrayList<>();
        entireHigherciFoldersAndFiles=new ArrayList<>();

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Log.e("ACVD","onActivityCreated() is Called");
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        if (isFragmentViewDestroyed)
        {
            boolean value=sharedPreferences.getBoolean("radio1_isChecked",true);
            if (value)
            {
                myRecyclerViewForFolder=new MyRecyclerViewForFolder(this,homeActivity,entireFolders);
                recyclerView.setAdapter(myRecyclerViewForFolder);
            }
            else
            {
                myRecyclerViewForFolderHigherci=new MyRecyclerViewForFolderHigherci(this,homeActivity,entireHigherciFoldersAndFiles);
                recyclerView.setAdapter(myRecyclerViewForFolderHigherci);

            }

        }
    }


    public void refershRecyclerViewAdapterForFolderHigherci(){
        Log.d("ABCD","refershRecyclerViewAdapterForFolderHigherci() is Called");
        if (myRecyclerViewForFolderHigherci!=null){
            myRecyclerViewForFolderHigherci.notifyDataSetChanged();
            Log.d("ABCD","myRecyclerViewForFolderHigherci not Null");
        }else {
            Log.d("ABCD","myRecyclerViewForFolderHigherci is  Null");
        }
        if (myRecyclerViewForFolder!=null){
            myRecyclerViewForFolder.notifyDataSetChanged();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
//        Log.e("ACVD","onStart() is Called");
        boolean value = sharedPreferences.getBoolean("radio1_isChecked", true);
        if (entireFolders == null) {
            entireFolders = new ArrayList<>();
        }
        if (entireHigherciFoldersAndFiles == null) {
            entireHigherciFoldersAndFiles = new ArrayList<>();
        }
        if (value) {
            if (allFolder != true) {
                allFolder();
                myRecyclerViewForFolder=new MyRecyclerViewForFolder(this,homeActivity, entireFolders);
                recyclerView.setAdapter(myRecyclerViewForFolder);
                allFolder = true;
                folderHigherci = false;
                entireHigherciFoldersAndFiles = null;
            }
        } else if (folderHigherci != true) {
            folderHigherci();
            myRecyclerViewForFolderHigherci = new MyRecyclerViewForFolderHigherci(this,homeActivity, entireHigherciFoldersAndFiles);
            recyclerView.setAdapter(myRecyclerViewForFolderHigherci);
            allFolder = false;
            folderHigherci = true;
            entireFolders = null;
        }

    }


    private void allFolder() //just a method to reduce codes into onCreate() method
    {
        ArrayList<File> folders=new ArrayList<>();
        Song song=new Song();
        File primaryExternalStoragePath = Environment.getExternalStorageDirectory();
        if (primaryExternalStoragePath !=null)
        {
            folders.addAll(song.getFoldersContainingMp3File(primaryExternalStoragePath));
        }

        //For Reading SD card songs
        File file=new File("/storage");
        File secondaryExternalStoragePath = getSecondaryExternalStoragePath(file);
        if (secondaryExternalStoragePath !=null)
        {
            folders.addAll(song.getFoldersContainingMp3File(secondaryExternalStoragePath));
        }

        if (folders.size()>0)
        {
            for (File file1:folders)
            {
                entireFolders.add(new CustomFile(file1,false,true,false,null));
            }
        }
    }



    private void folderHigherci()
    {

        ArrayList<File> topLevelFolders=new ArrayList<File>();
        Song song=new Song();
        File primaryExternalStoragePath = Environment.getExternalStorageDirectory();
        if (primaryExternalStoragePath !=null)
        {
            topLevelFolders.add(new File("/129/0/mgh/t"));
            topLevelFolders.addAll(song.getRootFoldersContainingMp3Files(primaryExternalStoragePath));
        }
       // For Reading SD card songs
        File file=new File("/storage");
        File secondaryExternalStoragePath = getSecondaryExternalStoragePath(file);
        if (secondaryExternalStoragePath !=null)
        {
            topLevelFolders.add(new File("/135/78/nmh/ght/01"));
            topLevelFolders.addAll(song.getRootFoldersContainingMp3Files(secondaryExternalStoragePath));

        }
        if (topLevelFolders.size()>0)
        {
            MediaMetadataRetriever mediaMetadataRetriever=new MediaMetadataRetriever();
            byte []data;
            String filePath;
            Bitmap bitmap=null;
            Drawable drawable=null;
            for (File file1:topLevelFolders)
            {

                if (file1.isDirectory())
                {
                    entireHigherciFoldersAndFiles.add(new CustomFile(file1,false,true,false,null));
                }
                else
                {
                    if (file1.exists()) {
                        filePath = file1.getAbsolutePath();
                        mediaMetadataRetriever.setDataSource(filePath);
                        data = mediaMetadataRetriever.getEmbeddedPicture();
                        if (data != null) {
                            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                           drawable=new BitmapDrawable(getResources(),bitmap);
                        }
                    }else{
                        drawable=null;
                    }
                    entireHigherciFoldersAndFiles.add(new CustomFile(file1,false,false ,true,drawable));
                }
            }
        }
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFragmentViewDestroyed=true;
        layoutManager=null;
        recyclerView=null;
        myRecyclerViewForFolder=null;
        myRecyclerViewForFolderHigherci=null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_foldersong, container, false);
        recyclerView=view.findViewById(R.id.recycler_view_1);
        return view;
    }




    @Override
    public void onClick(View v) {
        TextView title=v.findViewById(R.id.folder_title);
        TextView path=v.findViewById(R.id.folder_path);
        Intent intent=new Intent( getActivity(),FolderSongDisplayActivity.class);
        intent.putExtra("folder_title",title.getText().toString());
        intent.putExtra("path",""+path.getText());
        startActivity(intent);
        homeActivity.overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
    }


    private File getSecondaryExternalStoragePath(File rootFolderPath)
    {
        File path=null;
        if (rootFolderPath!=null && rootFolderPath.exists())
        {
            File []fileList=rootFolderPath.listFiles();
            if (fileList.length>0)
            {
                for (File f:fileList)
                {
                    if (f.canRead())
                    {
                        path=f;
                    }
                }
            }
        }
        return path;
    }



    @Override
    public void threeDotClickedEvent(View view) {
        RelativeLayout rootView=(RelativeLayout) view.getParent().getParent().getParent();
        TextView path=rootView.findViewById(R.id.folder_higherci_path);
        BottomSheetdialogFragment bottomSheetdialogFragment=new BottomSheetdialogFragment(this,path.getText().toString());
        bottomSheetdialogFragment.show(getFragmentManager(),"abc");
    }


    @Override
    public void bottomDialogItemClicked(View view,String path,int rowPositionNumber) {
        switch (view.getId())
        {
            case R.id.play:
//                Toast.makeText(getContext(),"play is Clicked",Toast.LENGTH_SHORT).show();
//                SharedPreferences sharedPreferences=getActivity().getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
//                int i=sharedPreferences.getInt("nextSongIndex",0);
//                for (int j=0;j<i;j++)
//                {
//                    Log.d("SHARE",sharedPreferences.getString("pathOfSong"+j,"non"));
//
//                }
                Intent intent1=new Intent(getActivity(),MusicControlActivity.class);
                startActivity(intent1);

                break;
            case R.id.share:
                Toast.makeText(getContext(),"share is Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                AlertDialogForDelete alertDialogForDelete=new AlertDialogForDelete("file://"+path);
                alertDialogForDelete.show(getFragmentManager(),"ABC");
                break;
            case R.id.favourite:
                FavouriteFiles favouriteFiles=new FavouriteFiles(this);
                favouriteFiles.setFavouriteFilePathInSharedpraferance(path);
                Toast.makeText(getContext(),"File is added To Favourite List",Toast.LENGTH_SHORT).show();
                break;
            case R.id.details:
                Intent intent=new Intent(getContext(),SongInfoActivity.class);
                intent.putExtra("path",path);
                startActivity(intent);
                homeActivity.overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
                break;
            case R.id.play_list:
                FragmentCommunicationInterface fragmentCommunicationInterface=homeActivity;
                File file=new File(path);
                fragmentCommunicationInterface.sendFile(file);
                break;
        }
    }

    public void unCheckAllSelectedRow()
    {
        for (CustomFile customFile:entireHigherciFoldersAndFiles)
        {
            if (!customFile.isDirectory())
            {
                customFile.setSelectedMark(false);
                customFile.setThreeDotIconVisibility(true);
            }
        }
        totalSelectedItem=0;
        homeActivity.isfragment0Selected=false;
        if (homeActivity.isfragment1Selected||homeActivity.isfragment2Selected||homeActivity.isfragment3Selected)
        {
            homeActivity.isAnyFragmentItemSelected=true;
        }
        else
        {
            homeActivity.isAnyFragmentItemSelected=false;
        }
        homeActivity.HideActionBar();
        isLongItemClickEventExist=false;
        myRecyclerViewForFolderHigherci.notifyDataSetChanged();

    }


    public int getTotalSelectedItemsNumber()
    {
        return totalSelectedItem;
    }


    public ArrayList<File> getAllSelectedFiles()
    {
        ArrayList<File> arrayList=new ArrayList<>();
        for (CustomFile customFile:entireHigherciFoldersAndFiles)
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
        ImageView threeDot=view.findViewById(R.id.folder_higherciimage_view);
        ImageView imageView=view.findViewById(R.id.folder_higherci_image_view);
        TextView textView_path=view.findViewById(R.id.folder_higherci_path);
        TextView rowPositionNumberTextView=view.findViewById(R.id.row_position_number);
        int rowPositionNumber=Integer.parseInt(rowPositionNumberTextView.getText().toString());
        String path=textView_path.getText().toString();
        File file=new File(path);
        CustomFile customFile = entireHigherciFoldersAndFiles.get(rowPositionNumber);
        if (customFile.getFile().getName().endsWith(".mp3"))
        {
            isLongItemClickEventExist = true;
            if (file.exists()) {
                if (!customFile.isSelectedMark()) {
                    threeDot.setVisibility(View.GONE);
                    imageView.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
                    totalSelectedItem = totalSelectedItem + 1;
                    homeActivity.setActionBarTitle(totalSelectedItem + " item Selected");
                    homeActivity.isAnyFragmentItemSelected=true;
                    homeActivity.isfragment0Selected=true;
                    customFile.setSelectedMark(true);
                    customFile.setThreeDotIconVisibility(false);
                }
            }
            homeActivity.bottomMenuForLongClickEventVisible();
        }

    }


    @Override
    public void clickEvent(View view) {
        TextView title=view.findViewById(R.id.folder_higherci_title);
        TextView path=view.findViewById(R.id.folder_higherci_path);
        if (!path.getText().toString().equals("/129/0/mgh/t") && !path.getText().toString().equals("/135/78/nmh/ght/01"))
        {
            if (title.getText().toString().endsWith(".mp3")) // this means a mp3 file row is Clicked
            {
                if (isLongItemClickEventExist)
                {
                    TextView rowPositionNumberTextView=view.findViewById(R.id.row_position_number);
                    int rowPositionNumber=Integer.parseInt(rowPositionNumberTextView.getText().toString());
                    ImageView imageView=view.findViewById(R.id.folder_higherci_image_view);
                    ImageView threeDot=view.findViewById(R.id.folder_higherciimage_view);
                    CustomFile customFile=entireHigherciFoldersAndFiles.get(rowPositionNumber);
                    if (!customFile.isSelectedMark())
                    {
                        threeDot.setVisibility(View.GONE);
                        customFile.setSelectedMark(true);
                        customFile.setThreeDotIconVisibility(false);
                        imageView.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
                        totalSelectedItem=totalSelectedItem+1;
                        homeActivity.setActionBarTitle(totalSelectedItem+" item Selected");
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
                        homeActivity.setActionBarTitle(totalSelectedItem+" item Selected");
                        if (totalSelectedItem==0)
                        {
                            homeActivity.HideActionBar();
                            isLongItemClickEventExist=false;
                            homeActivity.isfragment0Selected=false;
                            if (homeActivity.isfragment1Selected||homeActivity.isfragment2Selected||homeActivity.isfragment3Selected)
                            {
                                homeActivity.isAnyFragmentItemSelected=true;
                            }
                            else
                            {
                                homeActivity.isAnyFragmentItemSelected=false;
                            }
                        }
                    }
                }
                else
                {
//                    Toast.makeText(getContext(),"SERVICE IS STARTED",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getActivity(),MusicControlActivity.class);
                    startActivity(intent);
                }



            } else // this means a Highercial Folder row is Clicked
            {
                Intent intent = new Intent(getActivity(), FolderHigherciSongDisplayActivity.class);
                intent.putExtra("folder_title",title.getText().toString());
                intent.putExtra("path", "" + path.getText());
                startActivity(intent);
                homeActivity.overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
            }
        }
    }

}









