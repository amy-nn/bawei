package com.example.user;

import android.content.Context;

import com.example.lib_core.base.BaseApplication;

public class UserApp extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        getInstance();
    }

    private static UserApp userApp = null;

    public static UserApp getInstance(){

        if(userApp == null){
            userApp = new UserApp();
        }
        return userApp;
    }

}
