package com.goulala.rxjavareftroftmvpproject.common.base;

import android.app.Application;

import com.goulala.rxjavareftroftmvpproject.common.utils.FileUtils;
import com.goulala.rxjavareftroftmvpproject.common.utils.SPUtils;

/**
 * application的基类
 */
public class BaseApplication extends Application {

    protected static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SPUtils.init(this);
        FileUtils.init("project");
//        initImageLoader();
    }

//    private void initImageLoader() {
//        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(
//                instance);
//        config.memoryCacheExtraOptions(480, 800);
//        config.diskCacheExtraOptions(720, 1280, null);
//        config.diskCacheSize(100 * 1024 * 1024); // 100 MiB
////        if (BuildConfig.DEBUG) {
////            config.writeDebugLogs(); // Remove for release app
////        }
//        ImageLoader.getInstance().init(config.build());
//    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
