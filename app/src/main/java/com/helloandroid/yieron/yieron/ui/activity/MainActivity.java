package com.helloandroid.yieron.yieron.ui.activity;

import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.helloandroid.yieron.yieron.R;
import com.helloandroid.yieron.yieron.utils.AppUtils;

/**
 * 此项目为基项目，集成了很多demo，方便在实际的项目中直接使用。
 * 同时，此项目为自己兴趣爱好和学习研究的工具项目，就像工具类一样，这是工具项目。
 * 此项目永久保存。
 * please contact me:16619862685
 * email:yieron@163.com
 * qq:2293264218
 * 2016年10月27日
 */
public class MainActivity extends AppCompatActivity {
    private static String mAppVersion = "";
    private static String api_version = "1.0.0";//v1.0
    private Button getMyContentProvider, addMyContentProvider, deleteMyContentProvider, updateMyContentProvider;
    private String newId;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, getAppVersion(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, AppUtils.getAppPackageName(this), Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        getMyContentProvider = (Button) findViewById(R.id.my_contentProvider_query);
        addMyContentProvider = (Button) findViewById(R.id.my_contentProvider_add);
        deleteMyContentProvider = (Button) findViewById(R.id.my_contentProvider_delete);
        updateMyContentProvider = (Button) findViewById(R.id.my_contentProvider_update);

        getMyContentProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: herehere1");
                Uri uri = Uri.parse("content://com.example.howdo.myapplication.provider/book");
                Log.d(TAG, "onClick: uri=" + uri);
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                Log.d(TAG, "onClick: cursor=" + cursor);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));

                        Log.d(TAG, "onClick: name = " + name);
                        Log.d(TAG, "onClick: author = " + author);
                        Log.d(TAG, "onClick: pages = " + pages);
                        Log.d(TAG, "onClick: price = " + price);

                    }
                    cursor.close();
                }
            }
        });
        addMyContentProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.howdo.myapplication.provider/book");
                ContentValues values = new ContentValues();
                values.put("name", "hello contenProvider");
                values.put("author", "Yully");
                values.put("pages", 668);
                values.put("price", 24.24);
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
                Log.d(TAG, "onClick: newId=" + newId);
            }
        });
        deleteMyContentProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.howdo.myapplication.provider/book/" + newId);
                getContentResolver().delete(uri, null, null);
            }
        });
        updateMyContentProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.howdo.myapplication.provider/book/" + newId);
                ContentValues values = new ContentValues();
                values.put("name", "Yieron1314");
                values.put("pages", 1314);
                values.put("price", 28.28);
                getContentResolver().update(uri, values, null, null);

            }
        });

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
    }
}
