package com.goulala.rxjavareftroftmvpproject.home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.goulala.rxjavareftroftmvpproject.R;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;

import java.util.List;

/**
 * Created by: Z_B on 2018/9/4.
 * Function:
 */
public class HomePageAdapter extends BaseQuickAdapter<HomeDateBean.DataBean, BaseViewHolder> {
    public HomePageAdapter(@Nullable List<HomeDateBean.DataBean> data) {
        super(R.layout.include_home_page_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeDateBean.DataBean item) {
        helper.setText(R.id.tv_news_title, item.getTitle())
                .setText(R.id.tv_news_time, item.getDate());

    }
}
