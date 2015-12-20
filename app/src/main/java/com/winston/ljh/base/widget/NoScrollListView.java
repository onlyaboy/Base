package com.winston.ljh.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @author qinzx 不可滑动的listview，用来嵌套在其他可滑动的view里
 * 
 */
public class NoScrollListView extends ListView {

	public NoScrollListView(Context context) {
		super(context);
	}

	public NoScrollListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int mExpandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, mExpandSpec);
	}
}
