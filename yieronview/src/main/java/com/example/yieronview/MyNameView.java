package com.example.yieronview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class MyNameView extends RelativeLayout {

    private Context mContext;

    public MyNameView(Context context) {
        this(context, null);
    }

    public MyNameView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyNameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.my_view_btn, this, true);
    }
}
