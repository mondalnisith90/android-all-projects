package com.example.myapplication;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {

    private ActionMode myActionMode = null;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button add, delete, button, hide_button;
    private EditText editText1, editText2;
    private CheckBox checkBox;
    private MyRecyclerViewAdapter adapter;
    private boolean checkBox_status = false;
    private int checked_item_position = 0;
    private String name[];
    private String[] number;
    private ArrayList<RowItem> dataArrayList;
    private ArrayList<RowItem> selectedDataArrayList;
    private int[] images = {R.drawable.ic_battery, R.drawable.ic_beach,
            R.drawable.ic_bluetooth};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = getResources().getStringArray(R.array.name);
        number = getResources().getStringArray(R.array.number);
        //button=(Button)findViewById(R.id.button1);
        // hide_button=(Button)findViewById(R.id.button2);
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        dataArrayList = new ArrayList<RowItem>();
        selectedDataArrayList = new ArrayList<RowItem>();
        for (String name : name) {
            dataArrayList.add(new RowItem(name, false));
        }
        adapter = new MyRecyclerViewAdapter(dataArrayList, selectedDataArrayList, number, images, checkBox_status, this);
        recyclerView.setAdapter(adapter);


    }


    @Override
    public boolean onLongClick(View v) {
        adapter.setCheckBoxStatus(true);
        //checkBox_status=true;
        adapter.notifyDataSetChanged();
        if (myActionMode == null) {
            myActionMode = startSupportActionMode(myCallBack);
        }
        return true;
    }


    @Override
    public void onClick(View v) {
        checked_item_position = recyclerView.getChildAdapterPosition(v);
        adapter.selectItem(v, checked_item_position);
    }

    ActionMode.Callback myCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.my_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                case R.id.select: {
                    CheckBox checkBox = adapter.getCurrentView().findViewById(R.id.check_box);
//                    Log.e("ABCD",""+checkBox.isChecked());
                    if (!checkBox.isChecked()) {
                        for (RowItem rowItem : dataArrayList) {
                            rowItem.setShow_checkBox(true);
//                            Log.d("ABCD","True is Called");
                        }
                    } else {
                        for (RowItem rowItem : dataArrayList) {
                            rowItem.setShow_checkBox(false);
//                            Log.d("ABCD","False is Called");
                        }
                    }
                    adapter.notifyDataSetChanged();
                    break;
                }


                case R.id.addd: {
                    Toast.makeText(getApplicationContext(), "add", Toast.LENGTH_SHORT).show();
                    actionMode.finish();
                    break;
                }

                case R.id.delete: {
//                    Toast.makeText(getApplicationContext(),"delete",Toast.LENGTH_SHORT).show();
                    if (selectedDataArrayList.size() > 0) {
                        for (RowItem rowItem : selectedDataArrayList) {
                            dataArrayList.remove(rowItem);
                        }
                        Toast.makeText(MainActivity.this, selectedDataArrayList.size() + " Files Deleted", Toast.LENGTH_LONG).show();
                        selectedDataArrayList.removeAll(selectedDataArrayList);
                    }
                    adapter.setCheckBoxStatus(false);
                    adapter.notifyDataSetChanged();
                    actionMode.finish();
                    break;
                }
            }

            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

            for (RowItem rowItem : dataArrayList)
            {
                rowItem.setShow_checkBox(false);
            }
            adapter.setCheckBoxStatus(false);
            adapter.notifyDataSetChanged();
            myActionMode=null;

        }




    };
}











