package com.example.fregments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_B extends Fragment {







//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Log.d("ABCD","onAttach() is Called");
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.d("ABCD","onCreate() is Called");
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        Log.d("ABCD","onCreateView() is Called");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__b, container, false);
    }


//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Log.d("ABCD","onActivityCreadted() is Called");
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        Log.d("ABCD","onStart() is Called");
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.d("ABCD","onResume() is Called");
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        Log.d("ABCD","onPause() is Called");
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        Log.d("ABCD","onStop() is Called");
//    }
//
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        Log.d("ABCD","onSaveInstanceState() is Called");
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        Log.d("ABCD","onDestroyView() is Called");
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.d("ABCD","onDestroy() is Called");
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        Log.d("ABCD","onDetach() is Called");
//
//    }


}
