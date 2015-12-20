package com.winston.ljh.base.util.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by liujinhua on 15/12/13.
 */
public class HttpHelper {

    private static AsyncHttpClient client = AsyncHttpUtil.getInstance();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);
    }

    public static void get(String url, Objects bean, AsyncHttpResponseHandler responseHandler) {
        client.get(url, toRequestParams(bean), responseHandler);
    }

    public static void post(String url, Objects bean, AsyncHttpResponseHandler responseHandler) {
        client.post(url, toRequestParams(bean), responseHandler);
    }


    private static RequestParams toRequestParams(Objects obj){

        RequestParams params = new RequestParams();
        try {
            Class type = obj.getClass();
            Field[] fields = type.getDeclaredFields();
            for(int i=0; i<fields.length; i++){
                Field f = fields[i];
                f.setAccessible(true);
                params.put(f.getName(),f.get(obj));
                System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(obj));
            }
        }catch (Exception e){
        }

        return params;
    }
}
