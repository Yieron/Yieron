package com.helloandroid.yieron.yieron.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.helloandroid.yieron.yieron.R;
import com.helloandroid.yieron.yieron.ui.activity.ui.viewmodel.ViewModelFragment;

public class ViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_model_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ViewModelFragment.newInstance())
                    .commitNow();
        }
    }
}
