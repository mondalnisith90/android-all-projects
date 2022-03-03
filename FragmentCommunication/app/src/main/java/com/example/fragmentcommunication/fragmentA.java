package com.example.fragmentcommunication;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentA extends Fragment {

    private Button button;
    private EditText editText;
    private Context context;
    private OnFragmentCommunication communication;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communication= (OnFragmentCommunication) context;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment, container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button=(Button) getActivity().findViewById(R.id.button_A);
        editText=(EditText)getActivity().findViewById(R.id.edit_text_A);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                communication.onCommunication(editText.getText().toString());

            }
        });


    }
}





















