package com.example.yieronview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class ScaleGestureDemoView extends View {
    private static final String TAG = "ScaleGestureDemoView";

    private ScaleGestureDetector mScaleGestureDetector;
    private Paint mPaint = new Paint();
    private Path mPath = new Path();

    public ScaleGestureDemoView(Context context) {
        this(context, null);
    }

    public ScaleGestureDemoView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 1);
    }

    public ScaleGestureDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
        initAttr();
        initScaleGestureDetector();
    }

    private void initScaleGestureDetector() {
        mScaleGestureDetector = new ScaleGestureDetector(getContext(),
                new ScaleGestureDetector.SimpleOnScaleGestureListener() {
                    @Override
                    public boolean onScaleBegin(ScaleGestureDetector detector) {
                        return true;
                    }

                    @Override
                    public boolean onScale(ScaleGestureDetector detector) {
                        return true;
                    }

                    @Override
                    public void onScaleEnd(ScaleGestureDetector detector) {

                    }
                });
    }

    private void initAttr() {

    }

    private void initPaint() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleGestureDetector.onTouchEvent(event);
        return true;
    }
}
