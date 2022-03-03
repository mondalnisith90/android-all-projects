package com.music.audioplayer;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class ApplicationThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_theme);
        Toolbar toolbar=findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null)
        {
            actionBar.setTitle("Background Theme");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        CardView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12,image13,
                image14,image15,image16,image17,image18,image19,image20,image21,image22,image23,image24,image25,
                image26,image27,image28,image29,image30,image31;
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        image4=findViewById(R.id.image4);
        image5=findViewById(R.id.image5);
        image6=findViewById(R.id.image6);
        image7=findViewById(R.id.image7);
        image8=findViewById(R.id.image8);
        image9=findViewById(R.id.image9);
        image10=findViewById(R.id.image10);
        image11=findViewById(R.id.image11);
        image12=findViewById(R.id.image12);
        image13=findViewById(R.id.image13);
        image14=findViewById(R.id.image14);
        image15=findViewById(R.id.image15);
        image17=findViewById(R.id.image17);
        image18=findViewById(R.id.image18);
        image19=findViewById(R.id.image19);
        image20=findViewById(R.id.image20);
        image21=findViewById(R.id.image21);
        image22=findViewById(R.id.image22);
        image23=findViewById(R.id.image23);
        image24=findViewById(R.id.image24);
        image25=findViewById(R.id.image25);
        image26=findViewById(R.id.image26);
        image27=findViewById(R.id.image27);
        image28=findViewById(R.id.image28);
        image29=findViewById(R.id.image29);
        image30=findViewById(R.id.image30);
        image31=findViewById(R.id.image31);

        image1.setOnClickListener(new MyOnClickListener());
        image2.setOnClickListener(new MyOnClickListener());
        image3.setOnClickListener(new MyOnClickListener());
        image4.setOnClickListener(new MyOnClickListener());
        image5.setOnClickListener(new MyOnClickListener());
        image6.setOnClickListener(new MyOnClickListener());
        image7.setOnClickListener(new MyOnClickListener());
        image8.setOnClickListener(new MyOnClickListener());
        image9.setOnClickListener(new MyOnClickListener());
        image10.setOnClickListener(new MyOnClickListener());
        image11.setOnClickListener(new MyOnClickListener());
        image12.setOnClickListener(new MyOnClickListener());
        image13.setOnClickListener(new MyOnClickListener());
        image14.setOnClickListener(new MyOnClickListener());
        image15.setOnClickListener(new MyOnClickListener());
        image17.setOnClickListener(new MyOnClickListener());
        image18.setOnClickListener(new MyOnClickListener());
        image19.setOnClickListener(new MyOnClickListener());
        image20.setOnClickListener(new MyOnClickListener());
        image21.setOnClickListener(new MyOnClickListener());
        image22.setOnClickListener(new MyOnClickListener());
        image23.setOnClickListener(new MyOnClickListener());
        image24.setOnClickListener(new MyOnClickListener());
        image25.setOnClickListener(new MyOnClickListener());
        image26.setOnClickListener(new MyOnClickListener());
        image27.setOnClickListener(new MyOnClickListener());
        image28.setOnClickListener(new MyOnClickListener());
        image29.setOnClickListener(new MyOnClickListener());
        image30.setOnClickListener(new MyOnClickListener());
        image31.setOnClickListener(new MyOnClickListener());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 16908332://For Back Button Press in Toolbar
            {
                finish();
                overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
            }
        }
        return true;
    }

    private class MyOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            AlertDialogForThemeImage alertDialogForThemeImage=null;
            int imageDrawableValue;
            switch (v.getId())
            {
                case R.id.image1:
                {
                    imageDrawableValue=R.drawable.ic_favorite;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image2:
                {
                    imageDrawableValue=R.drawable.ic_favorite7;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }

                case R.id.image3:
                {
                    imageDrawableValue=R.drawable.ic_favorite1;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image4:
                {
                    imageDrawableValue=R.drawable.ic_favorite4;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image5:
                {
                    imageDrawableValue=R.drawable.ic_favorite5;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image6:
                {
                    imageDrawableValue=R.drawable.ic_favorite2;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image7:
                {
                    imageDrawableValue=R.drawable.ic_favorite_border;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image8:
                {
                    imageDrawableValue=R.drawable.ic_favorite_border2;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image9:
                {
                    imageDrawableValue=R.drawable.ic_favorite_border3;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image10:
                {
                    imageDrawableValue=R.drawable.ic_favorite_border5;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image11:
                {
                    imageDrawableValue=R.drawable.ic_favorite_border6;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image12:
                {
                    imageDrawableValue=R.drawable.ic_favorite_border8;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image13:
                {
                    imageDrawableValue=R.drawable.ic_favorite_border9;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image14:
                {
                    imageDrawableValue=R.drawable.ic_favorite_border10;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image15:
                {
                    imageDrawableValue=R.drawable.ic_favorite_border;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }

                case R.id.image17:
                {
                    imageDrawableValue=R.drawable.ic_music_note;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image18:
                {
                    imageDrawableValue=R.drawable.ic_music_note1;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image19:
                {
                    imageDrawableValue=R.drawable.ic_music_note2;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image20:
                {
                    imageDrawableValue=R.drawable.ic_music_note3;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image21:
                {
                    imageDrawableValue=R.drawable.ic_music_note4;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image22:
                {
                    imageDrawableValue=R.drawable.ic_music_note5;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image23:
                {
                    imageDrawableValue=R.drawable.ic_music_note6;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }

                case R.id.image24:
                {
                    imageDrawableValue=R.drawable.ic_android_icon1;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image25:
                {
                    imageDrawableValue=R.drawable.ic_android_icon2;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image26:
                {
                    imageDrawableValue=R.drawable.ic_android_icon3;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image27:
                {
                    imageDrawableValue=R.drawable.ic_android_icon4;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image28:
                {
                    imageDrawableValue=R.drawable.ic_flower;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image29:
                {
                    imageDrawableValue=R.drawable.ic_flower1;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image30:
                {
                    imageDrawableValue=R.drawable.ic_flower2;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }
                case R.id.image31:
                {
                    imageDrawableValue=R.drawable.ic_flower3;
                    alertDialogForThemeImage=new AlertDialogForThemeImage(ApplicationThemeActivity.this,imageDrawableValue);
                    alertDialogForThemeImage.show(getSupportFragmentManager(),"dialog");
                    break;
                }

            }

        }
    }
}




























