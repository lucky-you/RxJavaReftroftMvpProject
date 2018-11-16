package com.goulala.rxjavareftroftmvpproject.home.presenter;

import android.content.Context;

import com.goulala.rxjavareftroftmvpproject.common.mvp.BasePresenter;
import com.goulala.rxjavareftroftmvpproject.common.retrofit.ApiServiceCallback;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;
import com.goulala.rxjavareftroftmvpproject.home.view.IHomeView;

import io.reactivex.Observable;

/**
 * Created by: Z_B on 2018/9/4.
 * Function: presenter 请求数据
 */
public class HomePagePresenter extends BasePresenter<IHomeView> {
    public HomePagePresenter(IHomeView mvpView) {
        super(mvpView);
    }

    public void getHomeDateList(final Context context, int type) {
        Observable observable;
        if (1 == type) {
            observable = apiService.getHomeDateList();
        } else {
            observable = apiService.getLoginDateList();
        }
        addDisposableObserver(observable, new ApiServiceCallback<HomeDateBean>() {

            @Override
            public void onSuccess(HomeDateBean response) {
                if (response != null) {
                    mvpView.getHomeDateSuccess(response);
                }
            }

            @Override
            public void onErrorThrowable(String errorMessage) {
                mvpView.onNewWorkException(errorMessage);
            }

            @Override
            public void onFailure(String failureMessage) {
                mvpView.onRequestFailure(failureMessage);
            }
        });
    }


}
