package com.example.lib_core.mvp.model;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * 模型层用于写请求
 */
public interface IModel {

    /**
     * 请求
     * @param observable
     * @param
     */
    public void request(Observable<?> observable,BaseObserver observer);
}
