package com.winston.ljh.base.DataInterface;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.winston.ljh.base.util.http.HttpHelper;
import com.winston.ljh.base.util.http.HttpResponse;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;

/**
 * Created by OF-G40-449 on 2015/12/14.
 */
public class DataInterface {

    private static DataInterface mDataInterface;

    private DataInterface() {
    }

    public static DataInterface getInstance(){
        if (mDataInterface == null){
            mDataInterface = new DataInterface();
        }
        return mDataInterface;
    }

    public void text(RequestParams params,HttpResponse responseHandler){
        HttpHelper.get("http://www.baidu.com",params,  responseHandler);
    }

}
