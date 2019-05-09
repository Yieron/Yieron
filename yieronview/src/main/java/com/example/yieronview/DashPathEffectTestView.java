package com.example.yieronview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class DashPathEffectTestView extends View {
    private Paint mPaint = new Paint();
    private Path mPath = new Path();

    public DashPathEffectTestView(Context context) {
        this(context, null);
    }

    public DashPathEffectTestView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setPathEffect(new DashPathEffect(new float[]{200, 100}, 100));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.lineTo(0, 1720);
        canvas.save();
        canvas.translate(400, 100);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();
    }

}
