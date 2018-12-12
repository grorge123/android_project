package com.example.tsaohanwen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private String value="test input";
    private Button button1,button2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //取得此Button的實體
       button1 = (Button)findViewById(R.id.button1);
       button2 = (Button)findViewById(R.id.button2);
        //實做OnClickListener界面
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                value="test input";
                StartNewActivity(1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               value="test transfer value";
               StartNewActivity(3);
           }
        });
    }
    protected void StartNewActivity(int type){
        //初始化Intent物件
        Intent intent = new Intent();
        if(type==1) {
            //從MainActivity 到Main2Activity
            intent.putExtra("value", value);
            intent.setClass(Main2Activity.this, MainActivity.class);
            //開啟Activity
        }else{
            intent.setClass(Main2Activity.this, Main3Activity.class);
        }
        startActivity(intent);
    }
}
