package com.example.yieronview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MyNameView extends RelativeLayout {
    private static final String TAG = "MyNameView";
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
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyNameView, defStyleAttr, 0);
        String name = typedArray.getString(R.styleable.MyNameView_yinName);
        String sex = typedArray.getString(R.styleable.MyNameView_yinSex);
        int age = typedArray.getInteger(R.styleable.MyNameView_yinAge, -1);
        boolean isMarried = typedArray.getBoolean(R.styleable.MyNameView_yinMarried, false);
        Log.e(TAG, "name = " + name + " , sex = " + sex + ",age=" + age + ",Married?" + isMarried);

        typedArray.recycle();
        initView();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.my_name_view, this, true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return super.generateLayoutParams(lp);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    @Override
    public void postInvalidate() {
        super.postInvalidate();
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        return super.requestFocus(direction, previouslyFocusedRect);
    }
}
