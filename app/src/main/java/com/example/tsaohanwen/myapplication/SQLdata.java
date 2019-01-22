package com.example.tsaohanwen.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLdata extends SQLiteOpenHelper{
    private final static String DB="DB";//資料庫名
    private final static String TB="TB";//資料表
    private final static int VS=2;//版本
    public SQLdata(Context context) {
        //super(context, name, factory, version);
        super(context, DB, null, VS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String SQL="CREATE TABLE IF NOT EXISTS "+TB+"(_idd INTEGER PRIMARY KEY AUTOINCREMENT ,_title VARCHAR)";
        sqLiteDatabase.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        String SQL="DROP TABLE "+TB;
        db.execSQL(SQL);
    }
}