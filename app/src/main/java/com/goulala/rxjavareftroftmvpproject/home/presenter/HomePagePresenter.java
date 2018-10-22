package com.goulala.rxjavareftroftmvpproject.home.presenter;

import android.content.Context;

import com.goulala.rxjavareftroftmvpproject.common.base.ResultResponse;
import com.goulala.rxjavareftroftmvpproject.common.mvp.BasePresenter;
import com.goulala.rxjavareftroftmvpproject.common.retrofit.ApiServiceCallback;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;
import com.goulala.rxjavareftroftmvpproject.home.view.IHomeView;

/**
 * Created by: Z_B on 2018/9/4.
 * Function: presenter 请求数据
 */
public class HomePagePresenter extends BasePresenter<IHomeView> {
    public HomePagePresenter(IHomeView mvpView) {
        super(mvpView);
    }

    public void getHomeDateList(final Context context) {

        addDisposableObserver(apiService.getLoginDateList(), new ApiServiceCallback<HomeDateBean>() {

            @Override
            public void onSuccess(HomeDateBean response) {
                if (response != null) {
                    mvpView.getHomeDateSuccess(response);
                }
            }

        });
    }


}
