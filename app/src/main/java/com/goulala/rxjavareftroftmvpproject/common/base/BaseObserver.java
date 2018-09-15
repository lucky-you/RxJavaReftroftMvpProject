package com.goulala.rxjavareftroftmvpproject.common.base;

import android.accounts.NetworkErrorException;
import android.content.Context;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Observer的基类
 */

public abstract class BaseObserver<T> implements Observer<ResultResponse<T>> {
    protected Context mContext;

    public BaseObserver(Context cxt) {
        this.mContext = cxt;
    }

    public BaseObserver() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    @Override
    public void onNext(ResultResponse<T> tResultResponse) {
        onRequestEnd();
        if (1 == tResultResponse.error_code) {
            try {
                onSuccess(tResultResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                onCodeError(tResultResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        onRequestEnd();
        try {
            if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof UnknownHostException) {
                onFailure(e, true);
            } else {
                onFailure(e, false);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
    }

    /**
     * 返回成功
     */
    protected abstract void onSuccess(ResultResponse<T> response) throws Exception;

    /**
     * 返回成功了,但是code错误
     */
    protected void onCodeError(ResultResponse<T> response) throws Exception {

    }

    /**
     * 返回失败
     *
     * @param isNetWorkError 是否是网络错误
     */
    protected abstract void onFailure(Throwable e, boolean isNetWorkError) throws Exception;

    /**
     * 开始请求
     */
    protected void onRequestStart() {
        showProgressDialog();
    }

    /**
     * 请求结束
     */
    protected void onRequestEnd() {
        closeProgressDialog();
    }

    /**
     * 打开提示框
     */
    public void showProgressDialog() {
//        LoadDialog.show(mContext, mContext.getString(R.string.The_loading));
    }


    /**
     * 关闭提示框
     */
    public void closeProgressDialog() {
//        LoadDialog.dismiss(mContext);
    }

}
