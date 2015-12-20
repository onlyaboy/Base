package com.winston.ljh.base;

import android.app.Application;
import android.content.Context;

import com.winston.ljh.base.util.ImageLoaderUtil;

/**
 * Created by OF-G40-449 on 2015/12/14.
 */
public class MyApplication extends Application {
    private static MyApplication myApplication;
    private static Context  mContext;

    public MyApplication() {
        myApplication = this;
        mContext = getApplicationContext();
    }

    public static MyApplication getInstance() {
        return myApplication;
    }

    public static Context getContext() {
        return mContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ImageLoader
        ImageLoaderUtil.init(getApplicationContext());
    }


}
