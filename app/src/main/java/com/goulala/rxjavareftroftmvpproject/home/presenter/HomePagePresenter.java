package com.goulala.rxjavareftroftmvpproject.home.presenter;

import com.goulala.rxjavareftroftmvpproject.common.base.ApiClient;
import com.goulala.rxjavareftroftmvpproject.common.base.ApiService;
import com.goulala.rxjavareftroftmvpproject.common.base.SubscriberCallBack;
import com.goulala.rxjavareftroftmvpproject.common.mvp.BasePresenter;
import com.goulala.rxjavareftroftmvpproject.common.retrofit.RetrofitFactory;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;
import com.goulala.rxjavareftroftmvpproject.home.view.IHomeView;

import io.reactivex.Observable;

/**
 * Created by: Z_B on 2018/9/4.
 * Function:
 */
public class HomePagePresenter extends BasePresenter<IHomeView> {
    public HomePagePresenter(IHomeView mvpView) {
        super(mvpView);
    }

    public void getHomeDateList() {

    }



}
