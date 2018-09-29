package com.goulala.rxjavareftroftmvpproject.common.mvp;

/**
 * view的基类
 */
public interface BaseView {

    //显示加载对话框
    void showLoadingDialog(String message);

    //取消加载对话框
    void dismissLoadingDialog();

    //请求数据失败
    void onRequestFailure(String message);

    //网络或者数据异常
    void onNewWorkOrDateJsonException(String message);


}
