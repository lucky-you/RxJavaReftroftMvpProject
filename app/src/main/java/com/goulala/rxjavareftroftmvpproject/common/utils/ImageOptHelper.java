package com.goulala.rxjavareftroftmvpproject.common.utils;

import android.graphics.Bitmap;

import com.goulala.rxjavareftroftmvpproject.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * ImageLoader加载图片的配置类
 */
public class ImageOptHelper {

    public static DisplayImageOptions.Builder getBaseBuilder() {
        return new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565);
    }


    /**
     * banner图片
     * @return
     */
    public static DisplayImageOptions getBannerImgOptions() {
        return getBaseBuilder()
                .showImageOnLoading(R.drawable.ic_default_image_view)
                .showImageForEmptyUri(R.drawable.ic_default_image_view)
                .build();
    }

    /**
     * 商品图片
     * @return
     */
    public static DisplayImageOptions getGoodsOptions() {
        return getBaseBuilder()
                .showImageOnLoading(R.drawable.ic_default_image_view)
                .showImageForEmptyUri(R.drawable.ic_default_image_view)
                .showImageOnFail(R.drawable.ic_default_image_view)
                .build();
    }

    /**
     * 大图
     * @return
     */
    public static DisplayImageOptions getBigImgOptions() {
        return getBaseBuilder().build();
    }

    /**
     * 用户图像
     */
    public static DisplayImageOptions getAvatarOptions() {
        return getBaseBuilder()
                .showImageOnLoading(R.drawable.ic_default_image_view)
                .showImageForEmptyUri(R.drawable.ic_default_image_view)
                .showImageOnFail(R.drawable.ic_default_image_view)
                .build();
    }

    public static DisplayImageOptions getCornerOptions(int cornerRadiusPixels) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .showImageOnLoading(R.drawable.ic_default_image_view)
                .showImageForEmptyUri(R.drawable.ic_default_image_view)
                .showImageOnFail(R.drawable.ic_default_image_view)
                .displayer(new RoundedBitmapDisplayer(cornerRadiusPixels)).build();
        return options;
    }
}
