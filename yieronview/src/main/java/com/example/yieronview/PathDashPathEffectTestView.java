package com.example.yieronview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PathDashPathEffectTestView extends View {
    private Paint mPaint = new Paint();
    private Path rectPath = new Path();
    private Path ovalPath = new Path();
    private Path bulletPath = new Path();
    private Path starPath = new Path();
    private Path arcPath = new Path();


    public PathDashPathEffectTestView(Context context) {
        this(context, null);
    }

    public PathDashPathEffectTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public PathDashPathEffectTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0, 0, 50, 50);
        rectPath.addRect(rectF, Path.Direction.CW);
        ovalPath.addOval(rectF, Path.Direction.CW);
        bulletPath.lineTo(rectF.centerX(), rectF.top);
        bulletPath.addArc(rectF, -90, 180);
        bulletPath.lineTo(rectF.left, rectF.bottom);
        bulletPath.lineTo(rectF.left, rectF.top);
        // 星星形状
        PathMeasure pathMeasure = new PathMeasure(ovalPath, false);
        float length = pathMeasure.getLength();
        float split = length / 5;
        float[] starPos = new float[10];
        float[] pos = new float[2];
        float[] tan = new float[2];
        for (int i = 0; i < 5; i++) {
            pathMeasure.getPosTan(split * i, pos, tan);
            starPos[i * 2 + 0] = pos[0];
            starPos[i * 2 + 1] = pos[1];
        }
        starPath.moveTo(starPos[0], starPos[1]);
        starPath.lineTo(starPos[4], starPos[5]);
        starPath.lineTo(starPos[8], starPos[9]);
        starPath.lineTo(starPos[2], starPos[3]);
        starPath.lineTo(starPos[6], starPos[7]);
        starPath.lineTo(starPos[0], starPos[1]);
        Matrix matrix = new Matrix();
        matrix.postRotate(-90, rectF.centerX(), rectF.centerY());
        starPath.transform(matrix);

        canvas.translate(60, 100);
        // 绘制分割线 - 方形
        canvas.translate(0, 100);
        mPaint.setPathEffect(new PathDashPathEffect(rectPath, rectF.width() * 1.5f, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawLine(0, 0, 600, 0, mPaint);

        // 绘制分割线 - 圆形
        canvas.translate(0, 100);
        mPaint.setPathEffect(new PathDashPathEffect(ovalPath, rectF.width() * 1.5f, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawLine(0, 0, 600, 0, mPaint);

        // 绘制分割线 - 子弹型
        canvas.translate(0, 100);
        mPaint.setPathEffect(new PathDashPathEffect(bulletPath, rectF.width() * 1.5f, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawLine(0, 0, 600, 0, mPaint);

        // 绘制分割线 - 星型
        canvas.translate(0, 100);
        mPaint.setPathEffect(new PathDashPathEffect(starPath, rectF.width() * 1.5f, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawLine(0, 0, 600, 0, mPaint);

        canvas.translate(0, 100);
        arcPath.addArc(new RectF(100, 100, 500, 500), 30, 300);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(100);
        canvas.drawPath(arcPath, mPaint);

        Path borderPath = new Path();
        mPaint.getFillPath(arcPath, borderPath);    // getFillPath

        // 测试画笔，注意设置为 STROKE
        Paint testPaint = new Paint();
        testPaint.setStyle(Paint.Style.STROKE);
        testPaint.setStrokeWidth(2);
        testPaint.setAntiAlias(true);
        // 绘制通过 getFillPath 获取到的 Path
        canvas.drawPath(borderPath, testPaint);

    }
}
