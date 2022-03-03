package com.example.demoproject;


import android.content.Context;
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


public class Fragment_B extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private String []country;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        Log.e("ABC","FRAGMENT_B onCreateView() is Called");
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment__b, container, false);
        recyclerView=view.findViewById(R.id.recycler_view2);
        return view;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        Log.e("ABC","FRAGMENT_B onActivityCreated() is Called");
//        super.onActivityCreated(savedInstanceState);
//        country=getResources().getStringArray(R.array.country);
//        layoutManager=new LinearLayoutManager(getContext());
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(new MyRecyclerView(country));
//
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("ABC","FRAGMENT_B onCreate() is Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("ABC","FRAGMENT_B onDestroyView() is Called");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("ABC","FRAGMENT_B onSaveInstanceState() is Called");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("ABC","FRAGMENT_B onAttach() is Called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("ABC","FRAGMENT_B onDetach() is Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("ABC","FRAGMENT_B onDestroy() is Called");
    }

}
