package com.helloandroid.yieron.yieron.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.helloandroid.yieron.yieron.R;
import com.helloandroid.yieron.yieron.ui.fragment.BlankFragment;
import com.helloandroid.yieron.yieron.ui.fragment.FullscreenFragment;
import com.helloandroid.yieron.yieron.ui.fragment.dummy.BlankViewModelFragment;

public class FragmentActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_fragment, fragment);
        fragmentTransaction.commit();
    }
}