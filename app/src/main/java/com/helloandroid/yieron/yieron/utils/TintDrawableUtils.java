package com.helloandroid.yieron.yieron.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;

import com.helloandroid.yieron.yieron.R;

/**
 * Description:
 */
public class TintDrawableUtils {

    private TintDrawableUtils() {

    }

    /**
     * 为Drawable着色
     * @param drawable
     * @param colors
     * @return
     */
    public static Drawable tintDrawable(Drawable drawable, ColorStateList colors) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }

    public static int getPrimaryColor(Context context) {
        TypedArray array = context.obtainStyledAttributes(new int[]{R.attr.colorPrimary});
        int colorPrimary = array.getColor(0, 0x311b92);
        array.recycle();
        return colorPrimary;
    }
}
