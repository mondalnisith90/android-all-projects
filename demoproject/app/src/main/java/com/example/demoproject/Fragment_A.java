package com.example.demoproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragment_A extends Fragment
{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private String []name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        Log.e("ABC","FRAGMENT_A onCreateView() is Called");
        View view=inflater.inflate(R.layout.fragment_fragment_,container,false);
        recyclerView=view.findViewById(R.id.recycler_view1);
        return view;
    }





    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Log.e("ABC","FRAGMENT_A onActivityCreated() is Called");
//        name=getResources().getStringArray(R.array.name);
//        layoutManager=new LinearLayoutManager(getContext());
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(new MyRecyclerView(name));

    }
}
