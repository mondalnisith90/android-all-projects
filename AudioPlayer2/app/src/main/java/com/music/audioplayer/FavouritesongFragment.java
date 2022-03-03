package com.music.audioplayer;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class FavouritesongFragment extends Fragment implements ThreeDotClickEventInterface,BottomSheetDialogItemClickInterface,OnClickInterface,LongClickInterface {


    private RecyclerView recyclerView;
    private SharedPreferences sharedPreferences;
    private ArrayList<CustomFile> allFiles;
    private int savedNextSongIndex;
    private MyRecyclerViewAdapterForFavouriteFragment myRecyclerViewAdapterForFavouriteFragment;
    private HomeActivity homeActivity;
    private boolean isLongItemClickEventExist=false;
    private int totalSelectedItem=0;

    public FavouritesongFragment(){}

    @SuppressLint("ValidFragment")
    public FavouritesongFragment(HomeActivity homeActivity)
    {
        this.homeActivity=homeActivity;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getActivity().getSharedPreferences("favourite_song_path", Context.MODE_PRIVATE);
        savedNextSongIndex=0;
        allFiles=new ArrayList<>();
        int nextSongIndex=sharedPreferences.getInt("nextSongIndex",0);
        if (nextSongIndex>savedNextSongIndex)
        {
            readAllFilesFromSharedPrafrence(savedNextSongIndex);
            savedNextSongIndex=nextSongIndex;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("CHECK","FavouriteSongFragment onCreateView() is Called ");
        View view = inflater.inflate(R.layout.fragment_favouritesong, container, false);
        recyclerView = view.findViewById(R.id.recycler_view3);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
//        Log.d("CHECK","FavouriteSongFragment onStart() is Called ");
//        int nextSongIndex=sharedPreferences.getInt("nextSongIndex",0);
//
//        if (nextSongIndex>savedNextSongIndex)
//        {
//            Log.e("CHECK","CONDITION IS TRUE savedNextSongIndex "+savedNextSongIndex);
//            Log.e("CHECK","CONDITION IS TRUE nextSongIndex "+nextSongIndex);
//            readAllFilesFromSharedPrafrence(savedNextSongIndex);
//            assignFilesData();
//            myRecyclerViewAdapter.notifyDataSetChanged();
//            savedNextSongIndex=nextSongIndex;
//        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Log.d("CHECK","FavouriteSongFragment onActivityCreated() is Called ");
//        Log.d("CHECK","FavouriteSongFragment onStart() is Called ");
        int nextSongIndex=sharedPreferences.getInt("nextSongIndex",0);

        if (nextSongIndex>savedNextSongIndex)
        {
            readAllFilesFromSharedPrafrence(savedNextSongIndex);
//            myRecyclerViewAdapter.notifyDataSetChanged();
            savedNextSongIndex=nextSongIndex;
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myRecyclerViewAdapterForFavouriteFragment=new MyRecyclerViewAdapterForFavouriteFragment(this,homeActivity,allFiles);
        recyclerView.setAdapter(myRecyclerViewAdapterForFavouriteFragment);

    }


    public void refreshRecyclerView()
    {
        if (myRecyclerViewAdapterForFavouriteFragment!=null)
        {
            int nextSongIndex=sharedPreferences.getInt("nextSongIndex",0);
            if (nextSongIndex>savedNextSongIndex)
            {
                readAllFilesFromSharedPrafrence(savedNextSongIndex);
                savedNextSongIndex=nextSongIndex;
            }
            myRecyclerViewAdapterForFavouriteFragment.notifyDataSetChanged();
        }
    }

    public void refreshRecyclerViewAdapter()
    {
        if (myRecyclerViewAdapterForFavouriteFragment!=null){
            myRecyclerViewAdapterForFavouriteFragment.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recyclerView=null;
        myRecyclerViewAdapterForFavouriteFragment=null;
    }

    private void readAllFilesFromSharedPrafrence(int savedNextSongIndex)
    {
        int counter=sharedPreferences.getInt("nextSongIndex",0);
        String path;
        File file;
        for (int i=savedNextSongIndex;i<counter;i++)
        {
            path=sharedPreferences.getString("pathOfSong"+i,"null");
            file=new File(path);
            if (file.exists())
            {
                allFiles.add(0,new CustomFile(file,false,false,true,null));
            }
        }

    }


    @Override
    public void threeDotClickedEvent(View view) {
        String path=null;
        RelativeLayout rootLayout= (RelativeLayout) view.getParent().getParent().getParent();
        TextView path_textView =rootLayout.findViewById(R.id.path);
        TextView rowPositionNumberTextView=rootLayout.findViewById(R.id.row_position_number);
        int rowPositionNumber=Integer.parseInt(rowPositionNumberTextView.getText().toString());
        path=path_textView.getText().toString();
        BottomSheetDialogForFavouriteSongFragment dialogForFavouriteSongFragment=new BottomSheetDialogForFavouriteSongFragment(this,path,rowPositionNumber);
        dialogForFavouriteSongFragment.show(getFragmentManager(),"ABC");
    }

    @Override
    public void bottomDialogItemClicked(View view, String path,int rowPositionNumber) {
        switch (view.getId())
        {
            case R.id.play:
            {
                Toast.makeText(getContext(), "play is Clicked", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),MusicControlActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.share:
            {
                Toast.makeText(getContext(), "share is Clicked", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.remove:
            {
                removeFileFromFavouriteList(path,rowPositionNumber);
                break;
            }
            case R.id.details:
            {
                Intent intent=new Intent(getActivity(),SongInfoActivity.class);
                intent.putExtra("path",path);
                startActivity(intent);
                homeActivity.overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
                break;
            }
            case R.id.play_list:
            {
                FragmentCommunicationInterface fragmentCommunicationInterface=homeActivity;
                File file=new File(path);
                fragmentCommunicationInterface.sendFile(file);
                break;
            }
        }
    }

    private void removeFileFromFavouriteList(String path,int rowPositionNumber)
    {
        FavouriteFiles favouriteFiles=new FavouriteFiles(this);
        boolean isRemoved=favouriteFiles.removePathFromFavouriteList(path);
        if (isRemoved)
        {
            savedNextSongIndex=sharedPreferences.getInt("nextSongIndex",0);
            allFiles.remove(rowPositionNumber);
            myRecyclerViewAdapterForFavouriteFragment.notifyDataSetChanged();
            Toast.makeText(getContext(), "File is Removed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getContext(), "File not Removed", Toast.LENGTH_SHORT).show();
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
        homeActivity.isfragment3Selected=false;
        if (homeActivity.isfragment0Selected||homeActivity.isfragment1Selected||homeActivity.isfragment2Selected)
        {
            homeActivity.isAnyFragmentItemSelected=true;
        }
        else
        {
            homeActivity.isAnyFragmentItemSelected=false;
        }
        homeActivity.HideActionBar();
        isLongItemClickEventExist=false;
        myRecyclerViewAdapterForFavouriteFragment.notifyDataSetChanged();

    }

    public int getTotalSelectedItemsNumber()
    {
        return totalSelectedItem;
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
        if (file.exists())
        {
            CustomFile customFile = allFiles.get(rowPositionNumber);
            if (!customFile.isSelectedMark())
            {
                isLongItemClickEventExist=true;
                imageView.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
                threeDot.setVisibility(View.GONE);
                totalSelectedItem = totalSelectedItem + 1;
                homeActivity.setActionBarTitle(totalSelectedItem + " item Selected");
                homeActivity.isAnyFragmentItemSelected=true;
                homeActivity.isfragment3Selected=true;
                customFile.setSelectedMark(true);
                customFile.setThreeDotIconVisibility(false);
            }
        }
        homeActivity.bottomMenuForLongClickEventVisible();

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
                imageView.setBackgroundResource(R.drawable.ic_favorite_border1);
                if (totalSelectedItem>0)
                {
                    totalSelectedItem=totalSelectedItem-1;
                }
                homeActivity.setActionBarTitle(totalSelectedItem+" item Selected");
                if (totalSelectedItem==0)
                {
                    homeActivity.HideActionBar();
                    isLongItemClickEventExist=false;
                    homeActivity.isfragment3Selected=false;
                    if (homeActivity.isfragment0Selected||homeActivity.isfragment1Selected||homeActivity.isfragment2Selected)
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
            Intent intent=new Intent(getActivity(),MusicControlActivity.class);
            startActivity(intent);
//            Toast.makeText(getContext(),"SERVICE IS STARTED",Toast.LENGTH_SHORT).show();
        }
    }

}








