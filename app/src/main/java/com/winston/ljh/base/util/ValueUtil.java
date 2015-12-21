package com.winston.ljh.base.util;

import android.content.Context;

/**
 * Created by OF-G40-449 on 2015/12/21.
 * dp px sp 转换
 */
public class ValueUtil {
    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param dpValue dp的值
     * @param context 上下文
     * @return px的值
     */
    public static int dp2px(float dpValue, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue px的值
     * @param context 上下文
     * @return dp的值
     */
    public static int px2dp(float pxValue, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue px的值
     * @param context 上下文
     * @return ps的值
     */
    public static int px2sp(float pxValue, Context context) {
        return (int) (pxValue / context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue sp的值
     * @param context 上下文
     * @return px的值
     */
    public static int sp2px(float spValue, Context context) {
        return (int) (spValue * context.getResources().getDisplayMetrics().scaledDensity + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue sp的值
     * @param context 上下文
     * @return dp的值
     */
    public static int sp2dp(float spValue, Context context) {
        return px2dp(sp2px(spValue, context), context);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param dpValue sp的值
     * @param context 上下文
     * @return sp的值
     */
    public static int dp2sp(float dpValue, Context context) {
        return px2sp(dp2px(dpValue, context), context);
    }

}
