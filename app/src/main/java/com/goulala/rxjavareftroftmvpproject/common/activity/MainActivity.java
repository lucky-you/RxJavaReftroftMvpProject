package com.goulala.rxjavareftroftmvpproject.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.goulala.rxjavareftroftmvpproject.R;
import com.goulala.rxjavareftroftmvpproject.common.base.BaseMvpActivity;
import com.goulala.rxjavareftroftmvpproject.common.utils.BarUtils;
import com.goulala.rxjavareftroftmvpproject.home.adapter.HomePageAdapter;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;
import com.goulala.rxjavareftroftmvpproject.home.presenter.HomePagePresenter;
import com.goulala.rxjavareftroftmvpproject.home.view.IHomeView;

import java.util.List;

/**
 * 程序的主入口
 */
public class MainActivity extends BaseMvpActivity<HomePagePresenter> implements IHomeView {


    private HomePageAdapter homePageAdapter;
    private List<HomeDateBean.DataBean> homeDateList;
    private LinearLayout llRootLayout;

    @Override
    protected HomePagePresenter createPresenter() {
        return new HomePagePresenter(this);
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int loadViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void bindViews(View contentView) {
        initTitle("基础框架")
                .noBack()
                .setRightText("登录")
                .setRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intentToActivity(LoginActivity.class);
                    }
                });
        llRootLayout = get(R.id.ll_root_layout);
        BarUtils.addMarginTopEqualStatusBarHeight(llRootLayout);// 其实这个只需要调用一次即可
    }

    @Override
    public void processLogic(Bundle savedInstanceState) {
        Log.d("xy", "开始请求数据");
        homePageAdapter = new HomePageAdapter(homeDateList);
        initCommonRecyclerView(homePageAdapter, new DividerItemDecoration(mContext, LinearLayout.VERTICAL));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDate();
    }

    private void getDate() {
        mvpPresenter.getHomeDateList(mContext, 1);
    }

    @Override
    public void setClickListener(View view) {

    }

    @Override
    public void getHomeDateSuccess(HomeDateBean homeDateBean) {
        homeDateList = homeDateBean.getData();
        if (homeDateList != null && homeDateList.size() > 0) {
            homePageAdapter.setNewData(homeDateList);
        }
    }

    @Override
    public void onNewWorkException(String message) {
        showToast(message);
    }

    @Override
    public void onRequestFailure(String message) {
        showToast(message);
    }
}
