package com.goulala.rxjavareftroftmvpproject.common.lib;

import android.app.Application;

/**
 * application的基类
 */
public class LibApplication extends Application {

    protected static LibApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
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

    public static LibApplication getInstance() {
        return instance;
    }
}
