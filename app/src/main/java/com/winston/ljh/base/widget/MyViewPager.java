package com.winston.ljh.base.widget;

/**
 * Created by liujinhua on 15/12/20.
 * 可以禁止滑动的ViewPager
 */

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {

    private boolean canScroll = false;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.canScroll) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        /* return false;//super.onTouchEvent(arg0); */
        if (canScroll)
            return super.onTouchEvent(arg0);
        else
            return false;
    }

}