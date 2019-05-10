package com.example.yieronview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ComposePathEffectTestView extends View {
    private Paint mPaint = new Paint();
    private Path mPath = new Path();


    public ComposePathEffectTestView(Context context) {
        this(context, null);
    }

    public ComposePathEffectTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ComposePathEffectTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
