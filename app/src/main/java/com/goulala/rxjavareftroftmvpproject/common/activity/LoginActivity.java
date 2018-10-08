package com.goulala.rxjavareftroftmvpproject.common.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.goulala.rxjavareftroftmvpproject.R;
import com.goulala.rxjavareftroftmvpproject.common.base.BaseMvpActivity;
import com.goulala.rxjavareftroftmvpproject.home.adapter.SecondAdapter;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;
import com.goulala.rxjavareftroftmvpproject.home.presenter.HomePagePresenter;
import com.goulala.rxjavareftroftmvpproject.home.view.IHomeView;

import java.util.List;

public class LoginActivity extends BaseMvpActivity<HomePagePresenter> implements IHomeView {


    private List<HomeDateBean.DataBean> homeDateList;

    private SecondAdapter secondAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void bindViews() {
        initTitle("登录界面");
        recyclerView = get(R.id.recyclerView);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        getDate();
        secondAdapter = new SecondAdapter(homeDateList, R.layout.include_home_page_item_view);
        recyclerView.setAdapter(secondAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void getDate() {
        mvpPresenter.getHomeDateList(mContext);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void getHomeDateSuccess(HomeDateBean homeDateBean) {
        if (homeDateBean != null) {
            homeDateList = homeDateBean.getData();
            if (homeDateList != null) {
                secondAdapter.setData(homeDateList);
            }
        }

    }

    @Override
    public void onRequestFailure(String message) {

    }

    @Override
    public void onNewWorkException(String message) {

    }

    @Override
    protected HomePagePresenter createPresenter() {
        return new HomePagePresenter(this);
    }
}
