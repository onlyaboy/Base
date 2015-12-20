package com.winston.ljh.base.util;

import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by OF-G40-449 on 2015/12/14.
 */
public class ImageLoaderUtil {


    //初始化ImageLoader
    public static void init(Context context){
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context).threadPoolSize(10)
                .threadPriority(Thread.NORM_PRIORITY)
                .memoryCache(new LruMemoryCache(50 * 1024 * 1024))
                .memoryCacheSize(50 * 1024 * 1024)
                .denyCacheImageMultipleSizesInMemory().diskCacheFileCount(1000)
                .defaultDisplayImageOptions(getDefaultOption())
                .tasksProcessingOrder(QueueProcessingType.FIFO).build();
        ImageLoader.getInstance().init(config);
    }


    //默认的DisplayImageOptions
    public static DisplayImageOptions getDefaultOption(){

        DisplayImageOptions  options = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true).cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .bitmapConfig(Bitmap.Config.RGB_565).build();
        return options;
    }
}
