package com.example.lib_core.mvp.model;

import com.example.lib_core.mvp.view.IView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 执行请求
 */
public class BaseModel implements IModel{

    public void request(Observable<?> observable, BaseObserver observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
