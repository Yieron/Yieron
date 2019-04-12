package com.example.yieronview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class Utils {

	public static StateListDrawable getStateListDrawable(Context context) {
		StateListDrawable sd = new StateListDrawable();
		Drawable normal = context.getResources().getDrawable(
				R.drawable.dark_color);
		Drawable pressed = context.getResources().getDrawable(
				R.drawable.white_color);
		Drawable focus = context.getResources().getDrawable(
				R.drawable.white_color);
		// 注意该处的顺序，只要有一个状态与之相配，背景就会被换掉
		// 所以不要把大范围放在前面了，如果sd.addState(new[]{},normal)放在第一个的话，就没有什么效果了
		sd.addState(new int[] { android.R.attr.state_enabled,
				android.R.attr.state_focused }, focus);
		sd.addState(new int[] { android.R.attr.state_selected,
				android.R.attr.state_enabled }, pressed);
		sd.addState(new int[] { android.R.attr.state_focused }, focus);
		sd.addState(new int[] { android.R.attr.state_pressed }, pressed);
		sd.addState(new int[] {}, normal);
		return sd;
	}
}
