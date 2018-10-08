package com.goulala.rxjavareftroftmvpproject.common.retrofit;


import com.goulala.rxjavareftroftmvpproject.common.base.ResultResponse;
import com.goulala.rxjavareftroftmvpproject.common.utils.ExceptionHelper;
import com.goulala.rxjavareftroftmvpproject.common.utils.ToastUtils;

import io.reactivex.observers.DisposableObserver;

/**
 * 请求结果的回调
 */
public abstract class ApiServiceCallback<T> extends DisposableObserver<ResultResponse<? extends T>> {


    @Override
    protected void onStart() {
        onStartRequest();
    }

    @Override
    public void onNext(ResultResponse response) {
        if (0 == response.error_code) {
            onSuccess((T) response.result);
        } else {
            ToastUtils.showToast(response.reason);
            onFailure(response.reason);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        onThrowable(throwable);
        ExceptionHelper.handleException(throwable);
    }


    @Override
    public void onComplete() {
        onFinish();
    }

    /**
     * 网络请求开始
     */
    public void onStartRequest() {

    }

    /**
     * 网络请求成功
     */
    public abstract void onSuccess(T response);

    /**
     * 网络请求失败
     */
    public void onFailure(String failure) {
    }


    /**
     * 网络请求异常
     */
    public void onThrowable(Throwable throwable) {
    }


    /**
     * 网络请求结束
     */
    public void onFinish() {

    }


}
