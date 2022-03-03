package com.example.simplediolag;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.dialog_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=getLayoutInflater();
                final View view=inflater.inflate(R.layout.castum_layout,null);
                final EditText user_name=(EditText) view.findViewById(R.id.user_name);
                final EditText password=(EditText)view.findViewById(R.id.password);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Dialog Box")
                        .setView(view)
                        .setMessage("This is a Dialog Box")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name=user_name.getText().toString();
                                String p=password.getText().toString();
                                Toast.makeText(MainActivity.this,"Your Name is "+name+"  Password is "+p,Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"You are Clicking On calcel Button",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setCancelable(false)
                        .setIcon(R.drawable.child);
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(MainActivity.this, "you click on Item 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item2:
                Toast.makeText(MainActivity.this, "you click on Item 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item3:
                Toast.makeText(MainActivity.this, "you click on Item 3", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item4:
                Toast.makeText(MainActivity.this, "you click on Item 4", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item5:
                Toast.makeText(MainActivity.this, "you click on Item 5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem1:
                Toast.makeText(MainActivity.this, "you click on subItem 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.subitem2:
                Toast.makeText(MainActivity.this, "you click on subItem 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem3:
                Toast.makeText(MainActivity.this, "you click on subItem 3", Toast.LENGTH_SHORT).show();
                break;

            case R.id.subitem4:
                Toast.makeText(MainActivity.this, "you click on subItem 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem5:
                Toast.makeText(MainActivity.this, "you click on subItem 5", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
