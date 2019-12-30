package com.amy.mvpdemo;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_core.base.BaseApplication;

/**
 * 初始化Arouter
 */
public class MainApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
