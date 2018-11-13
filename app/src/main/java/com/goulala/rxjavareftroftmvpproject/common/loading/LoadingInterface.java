package com.goulala.rxjavareftroftmvpproject.common.loading;

/**
 * 回调
 */
public interface LoadingInterface {

    void showLoading();

    void showNetworkError();

    void showError();

    void showEmpty();

    void dismissLoading();

    interface OnClickListener {
        void onClick();
    }
}
