package com.winston.ljh.base.util.http;

import android.content.Context;

import com.loopj.android.http.*;
/**
 * @Title: AsyncHttpUtil.java
 * @Package com.fhh.abx.util
 * @Description: 单例http client
 * @author wesley
 * @date Jun 16, 2015 1:25:31 PM
 * @version 1.0
 */
public class AsyncHttpUtil {

    private static AsyncHttpClient client;

    private AsyncHttpUtil(){

    }

    public static AsyncHttpClient getInstance(){
        if (client == null) {
            synchronized (AsyncHttpUtil.class) {
                if(client == null) {
                    client = new AsyncHttpClient();
                    client.setTimeout(10 * 3000);
                }
            }
        }
        return client;
    }

    public void cancelReqeust(Context context) {
        client.cancelRequests(context, true);
    }
}
