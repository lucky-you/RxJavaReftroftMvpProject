package com.goulala.rxjavareftroftmvpproject.common.mvp;

import android.os.Bundle;

import com.goulala.rxjavareftroftmvpproject.R;
import com.goulala.rxjavareftroftmvpproject.common.base.BaseApplication;
import com.goulala.rxjavareftroftmvpproject.common.lib.LibActivity;
import com.goulala.rxjavareftroftmvpproject.common.utils.BarUtils;


public abstract class MvpActivity<P extends BasePresenter> extends LibActivity {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this, BaseApplication.getInstance().getResources().getColor(R.color.title_bar_color), 0);
        BarUtils.setStatusBarLightMode(this, true); //改变状态栏中的标识颜色<时间，电量>
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

}
