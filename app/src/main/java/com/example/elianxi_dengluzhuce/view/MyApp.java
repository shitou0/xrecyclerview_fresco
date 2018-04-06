package com.example.elianxi_dengluzhuce.view;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**   fresco  加载图片
 * Created by 石头 on 2018/4/6.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       Fresco.initialize(this);
    }
}
