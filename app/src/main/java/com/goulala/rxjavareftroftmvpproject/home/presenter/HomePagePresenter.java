package com.goulala.rxjavareftroftmvpproject.home.presenter;

import com.goulala.rxjavareftroftmvpproject.common.base.ApiClient;
import com.goulala.rxjavareftroftmvpproject.common.base.ResultResponse;
import com.goulala.rxjavareftroftmvpproject.common.mvp.BasePresenter;
import com.goulala.rxjavareftroftmvpproject.common.retrofit.ApiServiceCallback;
import com.goulala.rxjavareftroftmvpproject.common.retrofit.RetrofitFactory;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;
import com.goulala.rxjavareftroftmvpproject.home.view.IHomeView;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by: Z_B on 2018/9/4.
 * Function:
 */
public class HomePagePresenter extends BasePresenter<IHomeView> {
    public HomePagePresenter(IHomeView mvpView) {
        super(mvpView);
    }

    public void getHomeDateList() {
        Observable<ResultResponse<HomeDateBean>> homeObservable = apiService.getHomeDateList();

        Observable<ResultResponse<HomeDateBean>> retrofitObservable = RetrofitFactory.getInstance().getHomeDateList();

        ApiServiceCallback<HomeDateBean> homeApiCall = new ApiServiceCallback<HomeDateBean>() {
            @Override
            public void onStartRequest() {

            }

            @Override
            public void onSuccess(HomeDateBean response) {

            }
        };

        addSubscription(retrofitObservable, homeApiCall);
    }


}
