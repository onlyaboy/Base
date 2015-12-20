package com.winston.ljh.base.util.http;

import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import cz.msebera.android.httpclient.Header;

/**
 * Created by OF-G40-449 on 2015/12/14.
 */
public abstract class HttpResponse<T> extends TextHttpResponseHandler {
    private static Gson gson = new Gson();

    protected Class<T> clazz;

    @SuppressWarnings("unchecked")
    public HttpResponse() {
        super();
        @SuppressWarnings("rawtypes")
        Class clazz = getClass();

        while (clazz != Object.class) {
            Type t = clazz.getGenericSuperclass();
            if (t instanceof ParameterizedType) {
                Type[] args = ((ParameterizedType) t).getActualTypeArguments();
                if (args[0] instanceof Class) {
                    this.clazz = (Class<T>) args[0];
                    break;
                }
            }
            clazz = clazz.getSuperclass();
        }
    }


    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        onFailure(statusCode, throwable.toString());
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        T bean;
        try {
            bean = gson.fromJson(responseString, clazz);
        } catch (Exception e) {
            onFailure(statusCode, e.toString());
            return;
        }
        if (bean != null){
            onSuccess(bean);
        }else {
            onFailure(statusCode, "to " + clazz.getName() + " failure");
        }

    }

    public abstract void onSuccess(T bean);

    public abstract void onFailure(int statusCode, String errorMsg);

}
