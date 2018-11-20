package com.goulala.rxjavareftroftmvpproject.common.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.goulala.rxjavareftroftmvpproject.R;
import com.goulala.rxjavareftroftmvpproject.common.base.BaseMvpActivity;
import com.goulala.rxjavareftroftmvpproject.common.loading.LoadingController;
import com.goulala.rxjavareftroftmvpproject.common.loading.LoadingInterface;
import com.goulala.rxjavareftroftmvpproject.common.utils.BarUtils;
import com.goulala.rxjavareftroftmvpproject.common.utils.ScreenUtils;
import com.goulala.rxjavareftroftmvpproject.home.adapter.HomePageAdapter;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;
import com.goulala.rxjavareftroftmvpproject.home.presenter.HomePagePresenter;
import com.goulala.rxjavareftroftmvpproject.home.view.IHomeView;

import java.util.List;

public class LoginActivity extends BaseMvpActivity<HomePagePresenter> implements IHomeView {


    private List<HomeDateBean.DataBean> homeDateList;
    private HomePageAdapter homePageAdapter;
    private RecyclerView recyclerView;
    private LoadingController loadingController;

    public static final int NETWORK_ERROR = 0;
    public static final int ERROR = 1;
    public static final int EMPTY = 2;
    public static final int CONTENT = 3;

    @Override
    public void initData(@Nullable Bundle bundle) {
        if (ScreenUtils.isPortrait()) {
            ScreenUtils.adaptScreen4VerticalSlide(this, 365);
        } else {
            ScreenUtils.adaptScreen4HorizontalSlide(this, 667);
        }
    }

    @Override
    public int loadViewLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void bindViews(View contentView) {
        initTitle("登录界面");
        recyclerView = get(R.id.recyclerView);
        LinearLayout llRootLayout = get(R.id.ll_root_layout);
        BarUtils.addMarginTopEqualStatusBarHeight(llRootLayout);// 其实这个只需要调用一次即可

    }

    @Override
    public void processLogic(Bundle savedInstanceState) {
        request();
        homePageAdapter = new HomePageAdapter(homeDateList);
        recyclerView.setAdapter(homePageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        ScreenUtils.getScreenWidth();
        ScreenUtils.getScreenHeight();
    }

    @Override
    public void setClickListener(View view) {

    }

    @Override
    protected void onDestroy() {
        ScreenUtils.cancelAdaptScreen(this);
        super.onDestroy();
    }


    private void request() {

        loadingController = new LoadingController.Builder(this, recyclerView)
//                .setLoadingImageResource(R.drawable.anim_loading_frame)
//                .setLoadingMessage("加载中...")
                .setErrorMessage("加载失败，请稍后重试~")
                .setErrorImageResoruce(R.drawable.svg_data_error)
//                .setEmptyMessage("暂无数据~")
//                .setEmptyViewImageResource(R.drawable.svg_empty)
                .setOnNetworkErrorRetryClickListener(new LoadingInterface.OnClickListener() {
                    @Override
                    public void onClick() {
                        refresh(ERROR);
                    }
                })
                .setOnErrorRetryClickListener("点我重试", new LoadingInterface.OnClickListener() {
                    @Override
                    public void onClick() {
                        refresh(CONTENT);
                    }
                })
//                .setOnEmptyTodoClickListener("再次重试", new LoadingInterface.OnClickListener() {
//                    @Override
//                    public void onClick() {
//                        refresh(CONTENT);
//                    }
//                })
                .build();
        loadingController.showLoading();
//        refresh(NETWORK_ERROR);
        getDate();
    }

    private void refresh(final int showTarget) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (showTarget) {
                    case NETWORK_ERROR:
                        loadingController.showNetworkError();
                        break;
                    case ERROR:
                        loadingController.showError();
                        break;
                    case EMPTY:
                        loadingController.showEmpty();
                        break;
                    case CONTENT:
                        getDate();
                        break;
                }
            }
        }, 1000);
    }

    private void getDate() {
        mvpPresenter.getHomeDateList(mContext, 2);
    }


    @Override
    public void getHomeDateSuccess(HomeDateBean homeDateBean) {
        if (homeDateBean != null) {
            homeDateList = homeDateBean.getData();
            if (homeDateList != null && homeDateList.size() > 0) {
                homePageAdapter.setNewData(homeDateList);
                loadingController.dismissLoading();
            } else {
                loadingController.showEmpty();
            }
        }
    }

    @Override
    public void onRequestFailure(String message) {
        loadingController.showError();
    }

    @Override
    public void onNewWorkException(String message) {
        loadingController.showNetworkError();
    }

    @Override
    protected HomePagePresenter createPresenter() {
        return new HomePagePresenter(this);
    }


}
