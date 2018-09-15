package com.goulala.rxjavareftroftmvpproject.home.presenter;

import com.goulala.rxjavareftroftmvpproject.common.mvp.BasePresenter;
import com.goulala.rxjavareftroftmvpproject.common.retrofit.ApiServiceCallback;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;
import com.goulala.rxjavareftroftmvpproject.home.view.IHomeView;

/**
 * Created by: Z_B on 2018/9/4.
 * Function:
 */
public class HomePagePresenter extends BasePresenter<IHomeView> {
    public HomePagePresenter(IHomeView mvpView) {
        super(mvpView);
    }

    public void getHomeDateList() {

        addSubscription(apiService.getHomeDateList(), new ApiServiceCallback<HomeDateBean>() {
            @Override
            public void onStartRequest() {

            }

            @Override
            public void onSuccess(HomeDateBean response) {
                if (response != null) {
                    mvpView.getHomeDate(response);
                }

            }
        });
    }


}
