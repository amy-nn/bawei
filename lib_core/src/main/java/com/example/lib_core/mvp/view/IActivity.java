package com.example.lib_core.mvp.view;

public interface IActivity {

    //初始化布局id
    public int layout();
    //初始化数据
    public void initData();

    //初始化布局
    public void init();

    //依赖注入
    public void setInject();
}
