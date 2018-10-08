package com.goulala.rxjavareftroftmvpproject.home.adapter;

import android.widget.TextView;

import com.goulala.rxjavareftroftmvpproject.R;
import com.goulala.rxjavareftroftmvpproject.common.recyclerview.BaseViewHolder;
import com.goulala.rxjavareftroftmvpproject.common.recyclerview.adapter.SimpleAdapter;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/10/8
 * function  :
 */
public class SecondAdapter extends SimpleAdapter<HomeDateBean.DataBean> {
    public SecondAdapter(List<HomeDateBean.DataBean> list, int layoutId) {
        super(list, layoutId);
    }

    @Override
    protected void bind(BaseViewHolder holder, HomeDateBean.DataBean data) {
        holder.setText(R.id.tv_news_title,data.getTitle())
                .setText(R.id.tv_news_time,data.getDate());
    }
}
