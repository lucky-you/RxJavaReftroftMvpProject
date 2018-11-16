package com.goulala.rxjavareftroftmvpproject.common.lib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.goulala.rxjavareftroftmvpproject.common.bean.EventNotice;
import com.goulala.rxjavareftroftmvpproject.common.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;


public abstract class LibActivity extends AppCompatActivity implements BaseView {

    protected Context mContext;
    protected View mContentView;
    /**
     * 上次点击时间
     */
    private long lastClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        ActivityManager.getAppInstance().addActivity(this);//将当前activity添加进入管理栈
        Bundle bundle = getIntent().getExtras();
        initData(bundle);
        setBaseView(loadViewLayout());
        bindViews(mContentView);
        processLogic(savedInstanceState);

    }


    @SuppressLint("ResourceType")
    protected void setBaseView(@LayoutRes int layoutId) {
        if (layoutId <= 0) return;
        setContentView(mContentView = LayoutInflater.from(this).inflate(layoutId, null));
    }

    /**
     * 判断是否快速点击
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    private boolean isFastClick() {
        long now = System.currentTimeMillis();
        if (now - lastClick >= 800) {
            lastClick = now;
            return false;
        }
        return true;
    }


    @Override
    public void onClick(View view) {
        if (!isFastClick()) setClickListener(view);
    }

    /**
     * 获取控件
     *
     * @param id  控件的id
     * @param <E>
     * @return
     */
    protected <E extends View> E get(int id) {
        return (E) findViewById(id);
    }

    /**
     * 界面跳转
     * @param tarActivity
     */
    protected void intentToActivity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(mContext, tarActivity);
        startActivity(intent);
    }

    /**
     * 显示Toast
     */
    protected void showToast(String msg) {
        ToastUtils.showToast(msg);
    }

    /**
     * 显示日志信息
     */
    protected void showLog(String log) {
        Logger.i(log);
    }

    /**
     * 注册事件通知
     */
    public void registerEvent() {
        EventBus.getDefault().register(this);
    }

    /**
     * 发送消息
     */
    public void EventPost(EventNotice notice) {
        EventBus.getDefault().post(notice);
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getAppInstance().removeActivity(this);//将当前activity移除管理栈
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }
}
