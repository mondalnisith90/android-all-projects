package com.nisith.sqlitedatabaseexample;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String database_name = "user_account";
    private static final int version_number = 1;
    private static final String table_name = "user";
    private static final String column_id = "_id";
    private static final String column_name = "name";
    private static final String column_password = "password";
    private static final String column_date = "date";

    public static String getColumnName(){
        return MySQLiteHelper.column_name;
    }

    public static String getColumnPassword(){
        return MySQLiteHelper.column_password;
    }

    public static String getColumnDate(){
        return MySQLiteHelper.column_date;
    }
    public static String getColumnId(){
        return MySQLiteHelper.column_id;
    }


    public MySQLiteHelper(Context context) {
        super(context, MySQLiteHelper.database_name, null, MySQLiteHelper.version_number);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query_create_table = "CREATE TABLE "+MySQLiteHelper.table_name+" ("+MySQLiteHelper.column_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +MySQLiteHelper.column_name+" VARCHAR(150) NOT NULL,"
                + MySQLiteHelper.column_password+" VARCHAR(100) NOT NULL,"
                +MySQLiteHelper.column_date+" VARCHAR(50) NOT NULL);" ;

        db.execSQL(query_create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertUserAccountIntoDataBase(String userName,String password){
        SQLiteDatabase db = getWritableDatabase();
        boolean isSuccessfull = true;
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.LONG).format(calendar.getTime());

        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.column_name,userName);
        contentValues.put(MySQLiteHelper.column_password,password);
        contentValues.put(MySQLiteHelper.column_date,currentDate);
        long rowId = db.insert(MySQLiteHelper.table_name,null,contentValues);
        if (rowId==-1){
            isSuccessfull = false;
        }
        return isSuccessfull;
    }

    public Cursor getCursor(){
        SQLiteDatabase db = getWritableDatabase();
        String []selectedColumns = {MySQLiteHelper.column_id,MySQLiteHelper.column_name,MySQLiteHelper.column_password,MySQLiteHelper.column_date};
        return db.query(MySQLiteHelper.table_name,selectedColumns,null,null,null,null,MySQLiteHelper.column_id+" DESC");
    }




    public boolean deleteAccountFromDatabase(int userId){
        boolean isSuccessfull = false;
        SQLiteDatabase db = getWritableDatabase();
        int affectedRows = db.delete(MySQLiteHelper.table_name,MySQLiteHelper.column_id+"="+userId,null);
        if (affectedRows>0){
            isSuccessfull = true;
        }
        return isSuccessfull;
    }



}

















