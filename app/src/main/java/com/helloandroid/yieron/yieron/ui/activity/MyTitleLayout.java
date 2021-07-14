package com.helloandroid.yieron.yieron.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.helloandroid.yieron.yieron.R;

public class MyTitleLayout extends LinearLayout {
    public MyTitleLayout(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_title_navigation, this);

        Button btnBack = findViewById(R.id.nav_back);
        Button btnEdit = findViewById(R.id.nav_edit);

        btnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });

        btnEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"编辑",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
