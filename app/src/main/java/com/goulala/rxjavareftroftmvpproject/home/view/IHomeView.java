package com.goulala.rxjavareftroftmvpproject.home.view;

import com.goulala.rxjavareftroftmvpproject.common.mvp.IBaseView;
import com.goulala.rxjavareftroftmvpproject.home.model.HomeDateBean;

/**
 * Created by: Z_B on 2018/9/4.
 * Function:
 */
public interface IHomeView extends IBaseView {

    void getHomeDateSuccess(HomeDateBean homeDateBean);

}
