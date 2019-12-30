package com.example.lib_core.base;

import android.app.Application;
import android.content.Context;

public abstract class BaseApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
