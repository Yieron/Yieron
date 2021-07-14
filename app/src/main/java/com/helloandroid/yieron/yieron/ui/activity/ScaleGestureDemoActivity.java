package com.helloandroid.yieron.yieron.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.helloandroid.yieron.yieron.R;

public class ScaleGestureDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_gesture_demo);
    }

    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,ScaleGestureDemoActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }
}
