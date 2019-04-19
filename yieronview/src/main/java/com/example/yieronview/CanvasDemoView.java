package com.example.yieronview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.util.AttributeSet;
import android.view.View;

public class CanvasDemoView extends View {
    //1：创建一个画笔
    private Paint mPaint = new Paint();
    // a.创建Picture
    private Picture mPicture = new Picture();

    // 2.初始化画笔
    private void initPaint() {
        mPaint.setColor(Color.BLACK);       //设置画笔颜色
        mPaint.setStyle(Paint.Style.STROKE);  //设置画笔模式为
        mPaint.setStrokeWidth(10f);         //设置画笔宽度为1px
    }

    // b.录制内容方法
    private void recording() {
        // 开始录制 (接收返回值Canvas)
        Canvas canvas = mPicture.beginRecording(500, 500);
        // 创建一个画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        // 在Canvas中具体操作
        // 位移
        canvas.translate(250, 250);
        // 绘制一个圆
        canvas.drawCircle(0, 0, 100, paint);

        mPicture.endRecording();
    }


    public CanvasDemoView(Context context) {
        this(context, null);
    }

    public CanvasDemoView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
        recording();    // 调用录制
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(350, 400);  // 移动坐标系到屏幕中心
        canvas.scale(1, -1);                         // <-- 注意 翻转y坐标轴

        Path path = new Path();
        Path src = new Path();

        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        src.addCircle(0, 0, 100, Path.Direction.CW);

        path.addPath(src, 0, 200);

        mPaint.setColor(Color.BLACK);           // 绘制合并后的路径
        canvas.drawPath(path, mPaint);
    }
}
