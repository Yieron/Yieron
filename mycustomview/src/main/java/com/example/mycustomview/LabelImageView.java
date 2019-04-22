package com.example.mycustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class LabelImageView extends View {
    private Paint textPaint;
    private Paint backgroundPaint;

    public LabelImageView(Context context) {
        this(context,null);
    }

    public LabelImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LabelImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
    }
}
