package com.goulala.rxjavareftroftmvpproject.common.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;


import com.goulala.rxjavareftroftmvpproject.common.utils.ToastUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;


/**
 * Created by Administrator
 * on 2016/5/18.
 */
public abstract class SubscriberCallBack<T> implements Subscriber<ResultResponse<T>> {

    private static Handler mDelivery;

    public SubscriberCallBack() {
        if (mDelivery == null)
            mDelivery = new Handler(Looper.getMainLooper());
    }


    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onError(final Throwable e) {
        e.printStackTrace();
        onThrowable(e);
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (e instanceof SocketTimeoutException) {
                    ToastUtils.showToast("网络连接超时");
                } else if (e instanceof SocketException) {
                    if (e instanceof ConnectException) {
                        ToastUtils.showToast("网络未连接");
                    } else {
                        ToastUtils.showToast("网络错误");
                    }
                }
                onError();
            }
        });
    }

    @Override
    public void onNext(ResultResponse response) {
        if (response.ret == 200) {
            onSuccess((T) response.data);
        } else {
            if (response.ret == 400 && !TextUtils.isEmpty(response.msg)) {
                ToastUtils.showToast(response.msg);
            }
            onFailure(response);
        }


    }


    public abstract void onSuccess(T model);


    public abstract void onThrowable(Throwable t);

    protected void onError() {

    }

    protected void onFailure(ResultResponse response) {
    }
}
