package com.music.audioplayer;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class PlayListFragment extends Fragment implements ThreeDotClickEventInterface,BottomSheetDialogItemClickInterface,OnClickInterface,LongClickInterface
{
    private RecyclerView recyclerView;
    private ArrayList<CustomFile> playListFiles;
    private MyRecyclerViewAdapterForPlayListFragment myRecyclerViewAdapterForPlayListFragment;
    private HomeActivity homeActivity;
    private boolean isLongItemClickEventExist=false;
    private int totalSelectedItem=0;
    private ActionBar actionBar;

    public PlayListFragment(){}

    @SuppressLint("ValidFragment")
    public PlayListFragment(HomeActivity homeActivity,ArrayList<CustomFile> playListFiles)
    {
        this.homeActivity=homeActivity;
        this.playListFiles=playListFiles;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_playlist, container, false);
        recyclerView=view.findViewById(R.id.recycler_view4);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myRecyclerViewAdapterForPlayListFragment=new MyRecyclerViewAdapterForPlayListFragment(this,homeActivity,playListFiles);
        recyclerView.setAdapter(myRecyclerViewAdapterForPlayListFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        myRecyclerViewAdapterForPlayListFragment=null;
        recyclerView=null;
    }



    public void refreshRecyclerView()
    {
        if (myRecyclerViewAdapterForPlayListFragment!=null)
        {
            myRecyclerViewAdapterForPlayListFragment.notifyDataSetChanged();
        }
    }

    @Override
    public void threeDotClickedEvent(View view)
    {
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
    public void bottomDialogItemClicked(View view, String path,int rowPositionNumber)
    {
        switch (view.getId())
        {
            case R.id.play:
            {
//                Toast.makeText(getContext(), "play is Clicked", Toast.LENGTH_SHORT).show();
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
                File file=new File(path);
                if (file.exists())
                {
                    removeFileFromPlayList(rowPositionNumber);
                    myRecyclerViewAdapterForPlayListFragment.notifyDataSetChanged();
                    Toast.makeText(getContext(), "File is Removed", Toast.LENGTH_SHORT).show();
                }
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
        }
    }

    private void removeFileFromPlayList(int rowPositionNumber)
    {
        playListFiles.remove(rowPositionNumber);
    }



    public void unCheckAllSelectedRow()
    {
        for (CustomFile customFile:playListFiles)
        {
            customFile.setSelectedMark(false);
            customFile.setThreeDotIconVisibility(true);
        }
        totalSelectedItem=0;
        homeActivity.isfragment2Selected=false;
        if (homeActivity.isfragment0Selected||homeActivity.isfragment1Selected||homeActivity.isfragment3Selected)
        {
            homeActivity.isAnyFragmentItemSelected=true;
        }
        else
        {
            homeActivity.isAnyFragmentItemSelected=false;
        }
        homeActivity.HideActionBar();
        isLongItemClickEventExist=false;
        myRecyclerViewAdapterForPlayListFragment.notifyDataSetChanged();
    }


    public int getTotalSelectedItemsNumber()
    {
        return totalSelectedItem;
    }

    public ArrayList<File> getAllSelectedFiles()
    {
        ArrayList<File> arrayList=new ArrayList<>();
        for (CustomFile customFile:playListFiles)
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
            CustomFile customFile = playListFiles.get(rowPositionNumber);
            if (!customFile.isSelectedMark())
            {
                threeDot.setVisibility(View.GONE);
                isLongItemClickEventExist=true;
                imageView.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
                totalSelectedItem = totalSelectedItem + 1;
                homeActivity.setActionBarTitle(totalSelectedItem + " item Selected");
                homeActivity.isAnyFragmentItemSelected=true;
                homeActivity.isfragment2Selected=true;
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
            CustomFile customFile=playListFiles.get(rowPositionNumber);
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
                    homeActivity.isfragment2Selected=false;
                    if (homeActivity.isfragment0Selected||homeActivity.isfragment1Selected||homeActivity.isfragment3Selected)
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















