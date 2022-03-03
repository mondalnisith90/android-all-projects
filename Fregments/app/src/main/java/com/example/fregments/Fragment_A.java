package com.example.fregments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_A extends Fragment
{
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MainActivity mainActivity;

    public Fragment_A(){}
    @SuppressLint("ValidFragment")
    public Fragment_A(MainActivity mainActivity)
    {
        this.mainActivity=mainActivity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("ABCD","onAttach() is Called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ABCD","onCreate() is Called");


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_,container,false);
        ImageView imageView=view.findViewById(R.id.image_view);
        FrameLayout frameLayout=view.findViewById(R.id.frame_layout);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BlankFragment blankFragment=new BlankFragment();
                fragmentManager=getFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.frame_layout,blankFragment);
                fragmentTransaction.addToBackStack(null);
//                mainActivity.getViewPager().setVisibility(View.GONE);
                fragmentTransaction.commit();

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("ABCD","onActivityCreadted() is Called");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("ABCD","onStart() is Called");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("ABCD","onResume() is Called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("ABCD","onPause() is Called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("ABCD","onStop() is Called");
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ABCD","onSaveInstanceState() is Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("ABCD","onDestroyView() is Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ABCD","onDestroy() is Called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("ABCD","onDetach() is Called");

    }
}




































