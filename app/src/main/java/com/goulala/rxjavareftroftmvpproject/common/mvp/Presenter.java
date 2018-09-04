package com.goulala.rxjavareftroftmvpproject.common.mvp;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
