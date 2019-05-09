package com.example.yieronview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

public class CanvasDemoView extends View {
    //1：创建一个画笔
    private Paint mPaint = new Paint();

    public CanvasDemoView(Context context) {
        this(context, null);
    }

    public CanvasDemoView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    // 2.初始化画笔
    private void initPaint() {
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(50);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setPathEffect(new CornerPathEffect(30));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0, 600, 600, mPaint);
    }
}
