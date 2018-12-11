package com.example.tsaohanwen.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLdata extends SQLiteOpenHelper{
    private final static String DB="DB";//資料庫名
    private final static String TB="TB";//資料表
    private final static int VS=2;//版本
    public SQLdata(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //super(context, name, factory, version);
        super(context, DB, null, VS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}