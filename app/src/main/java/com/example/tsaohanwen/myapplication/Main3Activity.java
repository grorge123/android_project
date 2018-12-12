package com.example.tsaohanwen.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main3Activity extends Activity {
    public SQLdata DH=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        DH=new SQLdata(this);
        add("123");//加入資料
    }

    private void add(String s) {
        SQLiteDatabase db=DH.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("_title",s.toString());//載入資料123
        db.insert("TB",null,values);//寫入資料123
        ListView LV1=(ListView)findViewById(R.id.LV);//讀取元件
        //查詢資料庫並載入
        Cursor cursor=db.query("TB",new String[]{"_id","_title"},null,null,null,null,null);
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
        cursor.moveToFirst();
        //叫出資料庫的資料
        for(int i=0;i<cursor.getCount();i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("_id",cursor.getString(0));
            item.put("_title",cursor.getString(1));
            items.add(item);//新增
            cursor.moveToNext();
        }
        SimpleAdapter SA=new SimpleAdapter(this,items,android.R.layout.simple_expandable_list_item_2,new String[]{"_id","_title"},new int[]{android.R.id.text1,android.R.id.text2});
        LV1.setAdapter(SA);
    }

}
