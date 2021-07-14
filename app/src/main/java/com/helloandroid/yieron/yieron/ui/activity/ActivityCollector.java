package com.helloandroid.yieron.yieron.ui.activity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
        android.os.Process.killProcess(android.os.Process.myPid()); // 杀死基于自己进程中的程序

    }

}
