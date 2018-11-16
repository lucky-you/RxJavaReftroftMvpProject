package com.goulala.rxjavareftroftmvpproject.common.retrofit;


import android.util.Log;

import com.google.gson.JsonParseException;
import com.goulala.rxjavareftroftmvpproject.common.base.ResultResponse;
import com.goulala.rxjavareftroftmvpproject.common.utils.ToastUtils;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

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
        String error;
        if (throwable instanceof SocketTimeoutException  //网络超时,网络连接异常
                || throwable instanceof ConnectException   //均视为网络异常
                || throwable instanceof UnknownHostException) {
            Log.e("TAG", "网络连接异常: " + throwable.getMessage());
            error = "网络连接异常";
            onErrorThrowable(error);
        } else if (throwable instanceof JsonParseException
                || throwable instanceof JSONException     //均视为解析错误
                || throwable instanceof java.text.ParseException) {
            Log.e("TAG", "数据解析异常: " + throwable.getMessage());
            error = "数据解析异常";
            onFailure(error);
        } else {
            Log.e("TAG", "错误: " + throwable.getMessage());
            error = "错误:" + throwable.getMessage();
            onFailure(error);
        }

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
    public void onFailure(String failureMessage) {

    }


    /**
     * 网络请求异常
     */
    public void onErrorThrowable(String errorMessage) {
    }

    /**
     * 网络请求结束
     */
    public void onFinish() {

    }


}
