package com.helloandroid.yieron.yieron;

import android.app.Application;

import com.mob.MobSDK;

/**
 * Created by howdo on 2017/1/11.
 */

public class YieronApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this);
    }
}
