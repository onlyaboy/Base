package com.winston.ljh.base.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winston.ljh.base.DataInterface.DataInterface;

import java.lang.ref.WeakReference;

/**
 * Created by liujinhua on 15/12/11.
 * Fragment的抽象类，子类通过重写：findView，initListener，initUI进行页面初始化工作
 * 通过重写：onClick方法，进行view点击事件处理 如果页面要求统一动画效果，可在该类中实现
 * 通过重写：handleMessage，使用mHandler可以防止Handler防止内存泄漏
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    protected final String TAG = this.getClass().getSimpleName();
    protected Context mContext;
    protected DataInterface mDtaInterface = DataInterface.getInstance();

    /**
     * Instances of static inner classes do not hold an implicit
     * reference to their outer class.
     */
    private static class MyHandler extends Handler {
        private final WeakReference<BaseFragment> mFragment;

        public MyHandler(BaseFragment fragment) {
            mFragment = new WeakReference<BaseFragment>(fragment);
        }

        @Override
        public void handleMessage(Message msg) {
            BaseFragment fragment = mFragment.get();
            if (fragment != null) {
                fragment.handleMessage(msg);
            }
        }
    }

    private final MyHandler mHandler = new MyHandler(this);

    public BaseFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findView();
        initListener();
        initUI();
    }

    /**
     * 子类必须实现该方法，设置页面布局文件并查找所需要的View 调用:setContentView(int layoutResID)设置页面布局
     * 调用：findViewById(int id)查找所需要的View
     */
    protected abstract void findView();

    /**
     * 子类必须实现该方法，给控件设置相关监听
     */
    protected abstract void initListener();

    /**
     * 子类必须实现该方法，初始化页面数据
     */
    protected abstract void initUI();

    /**
     * 根据id获取控件
     */
    protected View findViewById(int id) {
        return getView().findViewById(id);
    }

    @Override
    public void onClick(View v) {

    }

    protected void startActivity(Class<? extends Activity> clzss) {
        Intent intent = new Intent(mContext, clzss);
        startActivity(intent);
    }


    protected void handleMessage(Message msg){
getContext();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
