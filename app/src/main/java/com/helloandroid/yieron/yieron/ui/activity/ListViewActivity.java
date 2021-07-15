package com.helloandroid.yieron.yieron.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.helloandroid.yieron.yieron.R;

public class ListViewActivity extends AppCompatActivity {

    private String[] data = {"Apple", "orange"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listviewId = findViewById(R.id.list_view);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(ListViewActivity.this, android.R.layout.simple_list_item_1, data);
        listviewId.setAdapter(stringArrayAdapter);

    }
}