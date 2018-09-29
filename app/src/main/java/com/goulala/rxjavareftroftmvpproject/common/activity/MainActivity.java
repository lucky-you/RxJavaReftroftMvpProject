package com.goulala.rxjavareftroftmvpproject.common.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.util.Log;
import android.widget.LinearLayout;

import com.goulala.rxjavareftroftmvpproject.R;
import com.goulala.rxjavareftroftmvpproject.common.base.BaseActivity;
import com.goulala.rxjavareftroftmvpproject.common.base.BaseMvpActivity;
import com.goulala.rxjavareftroftmvpproject.home.adapter.HomePageAdapter;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;
import com.goulala.rxjavareftroftmvpproject.home.presenter.HomePagePresenter;
import com.goulala.rxjavareftroftmvpproject.home.view.IHomeView;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * 程序的主入口
 */
public class MainActivity extends BaseMvpActivity<HomePagePresenter> implements IHomeView {

    private HomePageAdapter homePageAdapter;
    private List<HomeDateBean.DataBean> homeDateList;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void bindViews() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mvpPresenter.getHomeDateList();
        Log.d("xy", "开始请求数据");
        homePageAdapter = new HomePageAdapter(homeDateList);
        initCommonRecyclerView(homePageAdapter, new DividerItemDecoration(mContext, LinearLayout.VERTICAL));

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected HomePagePresenter createPresenter() {
        return new HomePagePresenter(this);
    }

    @Override
    public void getHomeDate(HomeDateBean homeDateBean) {
        homeDateList = homeDateBean.getData();
        if (homeDateList != null && homeDateList.size() > 0) {
            homePageAdapter.setNewData(homeDateList);
        }
    }

    @Override
    public void requestFailed() {

    }

    @Override
    public void showLoadingDialog(String message) {

    }

    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void onRequestFailure(String message) {

    }

    @Override
    public void onNewWorkOrDateJsonException(String message) {

    }

}
