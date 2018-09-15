package com.goulala.rxjavareftroftmvpproject.common.retrofit;


import android.text.TextUtils;

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
        super.onStart();
        onStartRequest();
    }

    @Override
    public void onNext(ResultResponse response) {
        if (response.error_code == 0) {
            onSuccess((T) response.result);
        } else {
//            if (response.code == 400 && !TextUtils.isEmpty(response.msg)) {
//                ToastUtils.showToast(response.msg);
//            }
            onFailure(response);
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onThrowable(e);
        ExceptionHelper.handleException(e);
    }


    @Override
    public void onComplete() {
        onFinish();
    }

    /**
     * 开始
     */

    public abstract void onStartRequest();

    /**
     * 成功
     */
    public abstract void onSuccess(T response);


    /**
     * 异常
     */
    protected void onThrowable(Throwable response) {

    }

    /**
     * 失败
     */
    protected void onFailure(ResultResponse response) {
    }

    /**
     * 结束
     */
    protected void onFinish() {
    }
}
