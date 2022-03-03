package com.nisith.sqlitedatabaseexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyRecyclerViewAdapter.OnDeleteIconClickListener {

    private MySQLiteHelper mySQLiteHelper;
    private EditText nameEditText;
    private EditText passwordEditText;
    private Button createButton;
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.user_name);
        passwordEditText = findViewById(R.id.password);
        createButton = findViewById(R.id.create_button);
        recyclerView = findViewById(R.id.recycler_view);
        createButton.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mySQLiteHelper = new MySQLiteHelper(this);
        recyclerView.setHasFixedSize(true);
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(mySQLiteHelper.getCursor(),this);
        recyclerView.setAdapter(myRecyclerViewAdapter);




    }




    @Override
    public void onClick(View v) {
        if (nameEditText.getText().toString().trim().length()>0 && passwordEditText.getText().toString().trim().length()>0){
            String userName = nameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            boolean isSuccessfull = mySQLiteHelper.insertUserAccountIntoDataBase(userName,password);
            if (isSuccessfull){
                myRecyclerViewAdapter.setCursor(mySQLiteHelper.getCursor());
                myRecyclerViewAdapter.setNotifyItemInseretd(0);
                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Account Not Create", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Enter User Name and Password Properly", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDeleteIconClick(int position,int userId) {
        boolean isSuccessfull = mySQLiteHelper.deleteAccountFromDatabase(userId);
        if (isSuccessfull){
            myRecyclerViewAdapter.setNotifyItemRemove(position);
            myRecyclerViewAdapter.setCursor(mySQLiteHelper.getCursor());

        }else {
            Toast.makeText(this, "Account Not Delete", Toast.LENGTH_SHORT).show();
        }
    }
}
