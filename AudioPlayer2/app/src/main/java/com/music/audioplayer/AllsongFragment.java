package com.music.audioplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;


@SuppressLint("ValidFragment")
public class AllsongFragment extends Fragment implements ThreeDotClickEventInterface,BottomSheetDialogItemClickInterface,LongClickInterface,OnClickInterface {

    private int image1=R.drawable.ic_favorite;
    private int image=R.drawable.ic_more_vert;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private HomeActivity homeActivity;
    private ArrayList<CustomFile> selectedFilesFromLongClick;
    private boolean isLongItemClickEventExist=false;
    private ArrayList<CustomFile> allFiles;
    private int totalSelectedItem=0;
    private MyRecyclerViewAdapterForAllSongFragment myRecyclerViewAdapterForAllSongFragment;



    @SuppressLint("ValidFragment")
    public AllsongFragment(HomeActivity homeActivity)
    {
        this.homeActivity=homeActivity;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<File> folders=new ArrayList<File>();
        allFiles=new ArrayList<>();
        selectedFilesFromLongClick=new ArrayList<>();
        Song song = new Song();
        //For Reading Device Storage Songs
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
             ArrayList<File> allSongFile = new ArrayList<File>(song.getAllSongFile(folders));//all .mp3 files
             MediaMetadataRetriever mediaMetadataRetriever=new MediaMetadataRetriever();
             byte []data=null;
             String path;
             Bitmap bitmap;
             Drawable drawable=null;
             for (File file1:allSongFile)
             {
                 path=file1.getAbsolutePath();
                 try {
                     mediaMetadataRetriever.setDataSource(path);
                     data=mediaMetadataRetriever.getEmbeddedPicture();
                 }catch (OutOfMemoryError e){drawable=null;}
                 if (data!=null)
                 {
                     try {
                         bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
                         drawable=new BitmapDrawable(getResources(),bitmap);
                     }catch (OutOfMemoryError error)
                     {
                         drawable=null;
                     }

                 }
                 allFiles.add(new CustomFile(file1,false,false,true,drawable));
             }
         }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_allsong, container, false);
        recyclerView=view.findViewById(R.id.recycler_view_2);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        myRecyclerViewAdapterForAllSongFragment=new MyRecyclerViewAdapterForAllSongFragment(this,homeActivity,allFiles);
        recyclerView.setAdapter(myRecyclerViewAdapterForAllSongFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        layoutManager=null;
        recyclerView=null;
    }

    public void refreshRecyclerViewAdapter()
    {
        if (myRecyclerViewAdapterForAllSongFragment!=null)
        {
            myRecyclerViewAdapterForAllSongFragment.notifyDataSetChanged();
        }
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
       TextView path=rootView.findViewById(R.id.path);
        BottomSheetdialogFragment bottomSheetdialogFragment=new BottomSheetdialogFragment(this,path.getText().toString());
        bottomSheetdialogFragment.show(getFragmentManager(),"ABC");
    }

    @Override
    public void bottomDialogItemClicked(View view,String path,int rowPositionNumber) {
        switch (view.getId())
        {
            case R.id.play:
//                Toast.makeText(getContext(),"play is Clicked",Toast.LENGTH_SHORT).show();
                Intent s_intent=new Intent(getActivity(),MusicControlActivity.class);
                startActivity(s_intent);
                break;
            case R.id.share:
                Toast.makeText(getContext(),"share is Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                AlertDialogForDelete alertDialogForDelete=new AlertDialogForDelete(path);
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
        for (CustomFile customFile:allFiles)
        {
            customFile.setSelectedMark(false);
            customFile.setThreeDotIconVisibility(true);
        }
        totalSelectedItem=0;
        homeActivity.isfragment1Selected=false;
        if (homeActivity.isfragment0Selected||homeActivity.isfragment2Selected||homeActivity.isfragment3Selected)
        {
            homeActivity.isAnyFragmentItemSelected=true;
        }
        else
        {
            homeActivity.isAnyFragmentItemSelected=false;
        }
        homeActivity.HideActionBar();
        isLongItemClickEventExist=false;
        myRecyclerViewAdapterForAllSongFragment.notifyDataSetChanged();

    }

    public int getTotalSelectedItemsNumber()
    {
        return totalSelectedItem;
    }

    public void setTotalSelectedItemsNumber(int value)
    {
        totalSelectedItem=value;
    }


    public ArrayList<File> getAllSelectedFiles()
    {
        ArrayList<File> arrayList=new ArrayList<>();
        for (CustomFile customFile:allFiles)
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
           CustomFile customFile = allFiles.get(rowPositionNumber);
           if (!customFile.isSelectedMark())
           {
               threeDot.setVisibility(View.GONE);
               imageView.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
               totalSelectedItem = totalSelectedItem + 1;
               homeActivity.setActionBarTitle(totalSelectedItem + " item Selected");
               homeActivity.isAnyFragmentItemSelected=true;
               homeActivity.isfragment1Selected=true;
               customFile.setSelectedMark(true);
               customFile.setThreeDotIconVisibility(false);
               selectedFilesFromLongClick.add(new CustomFile(file,false,false,false,null));
           }
       }
       homeActivity.bottomMenuForLongClickEventVisible();
    }

    @Override
    public void onItemClicked(View view) {
        if (isLongItemClickEventExist)
        {
            TextView rowPositionNumberTextView=view.findViewById(R.id.row_position_number);
            int rowPositionNumber=Integer.parseInt(rowPositionNumberTextView.getText().toString());
            ImageView threeDot=view.findViewById(R.id.image_view);
            ImageView imageView=view.findViewById(R.id.image_view1);
            CustomFile customFile=allFiles.get(rowPositionNumber);
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
                    homeActivity.isfragment1Selected=false;
                    if (homeActivity.isfragment0Selected||homeActivity.isfragment2Selected||homeActivity.isfragment3Selected)
                    {
                        homeActivity.isAnyFragmentItemSelected=true;
                    }
                    else
                    {
                        homeActivity.isAnyFragmentItemSelected=false;
                    }
                    homeActivity.HideActionBar();
                    isLongItemClickEventExist=false;
                }
            }
        }
        else
        {
//            Toast.makeText(getContext(),"SERVICE IS STARTED",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getActivity(),MusicControlActivity.class);
            startActivity(intent);
        }
    }
}















