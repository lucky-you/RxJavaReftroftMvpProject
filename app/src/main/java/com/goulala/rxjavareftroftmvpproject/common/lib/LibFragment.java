package com.goulala.rxjavareftroftmvpproject.common.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goulala.rxjavareftroftmvpproject.common.bean.EventNotice;
import com.goulala.rxjavareftroftmvpproject.common.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

public abstract class LibFragment extends Fragment implements View.OnClickListener {

    protected Context mContext;
    protected LibApplication application;
    protected boolean isFirst = true;//是否第一次加载
    protected View rootView;
    private boolean isViewCreate = false;//view是否创建
    private boolean isViewVisible = false;//view是否可见

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return loadViewLayout(inflater, container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        isViewCreate = true;
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        this.mContext = context;
        super.onAttach(context);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        application = (LibApplication) getActivity().getApplication();
        rootView = view;
        initView(view);
    }

    /**
     * 初始化界面
     */
    private void initView(View view) {
        bindViews(view);
        processLogic();
        setListener();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        isViewVisible = isVisibleToUser;
        if (isVisibleToUser && isViewCreate) {
            visibleToUser();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onResume() {
        if (isViewVisible) {
            visibleToUser();
        }
        super.onResume();
    }

    /**
     * 懒加载
     * 让用户可见
     * 第一次加载
     */
    protected void firstLoad() {

    }

    /**
     * 懒加载
     * 让用户可见
     */
    protected void visibleToUser() {
        if (isFirst) {
            firstLoad();
            isFirst = false;
        }
    }

    /**
     * 加载布局
     */
    protected abstract View loadViewLayout(LayoutInflater inflater, ViewGroup container);

    /**
     * find控件
     *
     * @param view
     */
    protected abstract void bindViews(View view);

    /**
     * 处理数据
     */
    protected abstract void processLogic();

    /**
     * 设置监听
     */
    protected abstract void setListener();

    /**
     * 界面跳转
     *
     * @param tarActivity
     */
    protected void intent2Activity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(mContext, tarActivity);
        startActivity(intent);
    }

    /**
     * 显示Toast
     *
     * @param msg
     */
    protected void showToast(String msg) {
        ToastUtils.showToast(msg);
    }

    protected void showLog(String msg) {
        Logger.i(msg);
    }

    @Override
    public void onClick(View v) {

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
    public void onDestroyView() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroyView();
    }
}
