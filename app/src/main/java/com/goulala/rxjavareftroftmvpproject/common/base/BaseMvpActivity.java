package com.goulala.rxjavareftroftmvpproject.common.base;

import android.os.Bundle;

import com.goulala.rxjavareftroftmvpproject.common.mvp.BasePresenter;
import com.goulala.rxjavareftroftmvpproject.common.mvp.MvpActivity;


public abstract class BaseMvpActivity<P extends BasePresenter> extends MvpActivity<P> {


//    public RecyclerView initCommonRecyclerView(BaseQuickAdapter adapter, RecyclerView.ItemDecoration decoration) {
//        return initCommonRecyclerView(R.id.recyclerView, adapter, decoration);
//    }
//
//    public RecyclerView initCommonRecyclerView(@IdRes int id, BaseQuickAdapter adapter, RecyclerView.ItemDecoration decoration) {
//        RecyclerView recyclerView = (RecyclerView) findViewById(id);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        if (decoration != null) {
//            recyclerView.addItemDecoration(decoration);
//        }
//        recyclerView.setAdapter(adapter);
//        return recyclerView;
//    }
//
//    public RecyclerView initGridRecyclerView(@IdRes int id, BaseQuickAdapter adapter, RecyclerView.ItemDecoration decoration, int spanCount) {
//        RecyclerView recyclerView = (RecyclerView) findViewById(id);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
//        if (decoration != null) {
//            recyclerView.addItemDecoration(decoration);
//        }
//        recyclerView.setAdapter(adapter);
//        return recyclerView;
//    }
//
//    public RecyclerView initGridRecyclerView(BaseQuickAdapter adapter, RecyclerView.ItemDecoration decoration, int spanCount) {
//        return initGridRecyclerView(R.id.recyclerView, adapter, decoration, spanCount);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
