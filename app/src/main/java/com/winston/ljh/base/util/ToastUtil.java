package com.winston.ljh.base.util;

/**
 * Created by liujinhua on 15/12/12.
 */
import android.content.Context;
import android.widget.Toast;

import com.winston.ljh.base.config.Config;

/**
 * TODO Toast工具类
 */
public class ToastUtil {

    // 持续时间
    private static int lastTime = Toast.LENGTH_LONG;
    public static void show(Context context, String text) {
        show(context, text, lastTime);
    }

    public static void show(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
    }

    public static void show(Context context, String text, int time) {
        Toast.makeText(context, text, time).show();
    }

    public static void debug(Context context, String text) {
        if (Config.DEBUG) {
            debug(context, text, lastTime);
        }
    }

    public static void debug(Context context, String text, int time) {
        if (Config.DEBUG) {
            Toast.makeText(context, text, time).show();
        }
    }
}
