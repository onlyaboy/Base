package com.winston.ljh.base.ui.base;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.winston.ljh.base.DataInterface.DataInterface;
import java.lang.ref.WeakReference;

/**
 * Created by liujinhua on 15/12/11.
 * Activity的抽象类，子类通过重写：findView，initListener，initUI进行页面初始化工作
 * 通过重写：onClick方法，进行view点击事件处理 如果页面要求统一动画效果，可在该类中实现
 * 通过重写：handleMessage，使用mHandler可以防止Handler防止内存泄漏
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    protected final String TAG = this.getClass().getSimpleName();
    protected Context mContext;
    protected DataInterface mDtaInterface;

    /**
     * Instances of static inner classes do not hold an implicit
     * reference to their outer class.
     */
    private static class MyHandler extends Handler {
        private final WeakReference<BaseActivity> mActivity;

        public MyHandler(BaseActivity activity) {
            mActivity = new WeakReference<BaseActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            BaseActivity activity = mActivity.get();
            if (activity != null) {
                activity.handleMessage(msg);
            }
        }
    }

    private final MyHandler mHandler = new MyHandler(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏title
        mContext = this;
        mDtaInterface = DataInterface.getInstance();
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
     * 进行view点击事件处理 如果页面要求统一动画效果，可在该类中实现
     * @param v 被点击的view
     */
    @Override
    public void onClick(View v) {
    }


    protected void startActivity(Class<? extends Activity> clzss) {
        Intent intent = new Intent(mContext, clzss);
        startActivity(intent);
    }


    protected void handleMessage(Message  msg){

    }

}
