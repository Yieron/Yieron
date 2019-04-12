package com.example.yieronview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class YieronLayout extends RelativeLayout {

    private Context mContext;

    public YieronLayout(Context context) {
        this(context, null);
    }

    public YieronLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YieronLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        TypedArray ta = mContext.obtainStyledAttributes(attrs,
                R.styleable.circleView);
        if (ta != null) {
//            circleColor = ta.getColor(R.styleable.circleView_circleColor, 0);
//            arcColor = ta.getColor(R.styleable.circleView_arcColor, 0);
//            textColor = ta.getColor(R.styleable.circleView_textColor, 0);
//            textSize = ta.getDimension(R.styleable.circleView_textSize, 50);
//            text = ta.getString(R.styleable.circleView_text);
//            startAngle = ta.getInt(R.styleable.circleView_startAngle, 0);
//            sweepAngle = ta.getInt(R.styleable.circleView_sweepAngle, 90);
//            ta.recycle();
        }
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.my_view_btn, this, true);
    }
}
