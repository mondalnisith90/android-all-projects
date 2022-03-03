package com.music.trainyatra;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

public class MySharedPraferance {
    private SharedPreferences sharedPreferences;
    public MySharedPraferance(AppCompatActivity appCompatActivity,String file_name){
        sharedPreferences = appCompatActivity.getSharedPreferences(file_name, Context.MODE_PRIVATE);
    }

    public void saveData(String key,String value){
        if (sharedPreferences!=null){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key,value);
            editor.commit();
        }
    }

    public String getData(String key){
        String result="";
        if (sharedPreferences!=null){
             result = sharedPreferences.getString(key,"");
        }

        return result;

    }

}
