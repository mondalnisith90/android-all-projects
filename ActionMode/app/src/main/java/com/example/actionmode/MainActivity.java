package com.example.actionmode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ActionMode mactionMode=null;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text_view);
        toolbar=findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mactionMode==null) {
                    mactionMode = startSupportActionMode(new ActionMode.Callback() {
                        @Override
                        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                            actionMode.getMenuInflater().inflate(R.menu.example_menu,menu);
                            return true;
                        }

                        @Override
                        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                            return false;
                        }

                        @Override
                        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

                            switch (menuItem.getItemId())
                            {
                                case R.id.delete:
                                    Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                                    actionMode.finish();
                                    break;
                                case R.id.search:
                                    Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                                    actionMode.finish();
                                    break;
                            }

                            return true;
                        }

                        @Override
                        public void onDestroyActionMode(ActionMode actionMode) {

                            mactionMode=null;
                        }
                    });
                }

                return true;
            }
        });



    }
}
