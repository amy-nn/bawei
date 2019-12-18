package com.amy.mvpdemo;

import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 初始化Arouter
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
