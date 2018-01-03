package com.helloandroid.yieron.yieron.ui.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.helloandroid.yieron.yieron.R;
import com.helloandroid.yieron.yieron.utils.AppUtils;

/**
 * 此项目为基项目，集成了很多demo，方便在实际的项目中直接使用。
 * 同时，此项目为自己兴趣爱好和学习研究的工具项目，就像工具类一样，这是工具项目。
 * 此项目永久保存。
 * please contact me:15117958831
 * email:yieron@163.com
 * qq:2293264218
 * 2016年10月27日
 */
public class MainActivity extends AppCompatActivity {
    private static String mAppVersion = "";
    private static String api_version = "1.0.0";//v1.0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, getAppVersion(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, AppUtils.getAppPackageName(this), Toast.LENGTH_LONG).show();
    }

    private String getAppVersion() {
        if (TextUtils.isEmpty(mAppVersion)) {
            try {
                mAppVersion = getApplicationContext().getPackageManager()
                        .getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mAppVersion;
        
        //test
    }
}
