package com.example.tsaohanwen.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.security.PublicKey;
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
        Button  button1 = (Button)findViewById(R.id.button1);
        Button  button2 = (Button)findViewById(R.id.button2);
        DH=new SQLdata(this);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                add("123");//加入資料;
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                del();
            }
        });

    }
    private  void del(){
        String id ="123";
        SQLiteDatabase db = DH.getWritableDatabase();
        db.delete("TB","_title="+id,null);
    }
    private void add(String s) {
        SQLiteDatabase db=DH.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("_title",s.toString());//載入資料123
        db.insert("TB",null,values);//寫入資料123
        ListView LV1=(ListView)findViewById(R.id.LV);//讀取元件
        //查詢資料庫並載入
        Cursor cursor=db.query("TB",new String[]{"_idd","_title"},null,null,null,null,null);
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
        cursor.moveToFirst();
        //叫出資料庫的資料
        for(int i=0;i<cursor.getCount();i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("_idd",cursor.getString(0));
            item.put("_title",cursor.getString(1));
            items.add(item);//新增
            cursor.moveToNext();
        }
        SimpleAdapter SA=new SimpleAdapter(this,items,android.R.layout.simple_expandable_list_item_2,new String[]{"_idd","_title"},new int[]{android.R.id.text1,android.R.id.text2});
        LV1.setAdapter(SA);
    }

}
