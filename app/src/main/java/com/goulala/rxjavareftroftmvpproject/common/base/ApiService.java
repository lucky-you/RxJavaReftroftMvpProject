package com.goulala.rxjavareftroftmvpproject.common.base;

import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 网络请求
 */
public interface ApiService {


    //baseUrl
    String API_SERVER_URL = "http://v.juhe.cn/toutiao/";

    @GET("?type=top&key=7227d50e4ceb0ba0bba7b7090a4ded98")
    Observable<ResultResponse<HomeDateBean>> getHomeDateList();


}
