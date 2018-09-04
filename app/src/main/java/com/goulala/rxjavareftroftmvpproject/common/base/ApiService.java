package com.goulala.rxjavareftroftmvpproject.common.base;

import android.database.Observable;

import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 网络请求
 */
public interface ApiService {

    //新闻头条的key

    String NEW_KEY = "7227d50e4ceb0ba0bba7b7090a4ded98";

    String NEW_URL = "http://v.juhe.cn/toutiao/index?type=top&key=" + NEW_KEY;
    //baseUrl
    String API_SERVER_URL = "http://v.juhe.cn/toutiao/";

    @GET("?type=top&key=7227d50e4ceb0ba0bba7b7090a4ded98")
    Observable<ResultResponse<HomeDateBean>> getHomeDateList();


}
