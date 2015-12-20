package com.winston.ljh.base.util;

import android.util.Log;

import com.winston.ljh.base.config.Config;

/**
 * Created by liujinhua on 15/12/12.
 */
public final class LogUtil {


    public static void v(String tag,String msg) {
        if(Config.SHOW_LOG) {
            Log.v(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if(Config.SHOW_LOG) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if(Config.SHOW_LOG) {
            Log.d(tag, msg);
        }
    }


    public static void w(String tag, String msg) {
        if(Config.SHOW_LOG) {
            Log.w(tag,msg);
        }
    }


    public static void e(String tag, String msg) {
        if(Config.SHOW_LOG) {
            Log.e(tag, msg);
        }
    }
}
