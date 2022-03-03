package com.example.demoproject;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_C extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("ABC","FRAGMENT_C onCreateView() is Called");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__c, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("ABC","FRAGMENT_C onCreate() is Called");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("ABC","FRAGMENT_C onSaveInstanceState() is Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("ABC","FRAGMENT_C onDestroyView() is Called");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("ABC","FRAGMENT_C onAttach() is Called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("ABC","FRAGMENT_C onDetach() is Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("ABC","FRAGMENT_C onDestroy() is Called");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("ABC","FRAGMENT_C onActivityCreated() is Called");
    }
}
