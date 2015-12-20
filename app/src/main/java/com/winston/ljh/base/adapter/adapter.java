package com.winston.ljh.base.adapter;

import android.content.Context;

import com.winston.ljh.base.adapter.base.BaseAdapterHelper;
import com.winston.ljh.base.adapter.base.QuickAdapter;

/**
 * Created by OF-G40-449 on 2015/12/14.
 */
public class adapter extends QuickAdapter<String>{
    public adapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    @Override
    protected void convert(int position, BaseAdapterHelper helper, String item) {

    }
}
