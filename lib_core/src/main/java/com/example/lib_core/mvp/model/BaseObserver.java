package com.example.lib_core.mvp.model;

import com.example.lib_core.mvp.view.IView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * 处理rxJava异步,观察者基类
 * @param <T>
 */
public abstract class BaseObserver<T,V extends IView> extends DisposableObserver<T> implements IObserver<T>{

    public V mview;
    public T entity;

    public BaseObserver(V mview){
        this.mview = mview;
    }

    @Override
    public void onNext(T t) {
        if(t != null && mview != null){
            mview.showToast("onNext");
            entity = t;
        }
    }

    @Override
    public void onError(Throwable e) {
        mview.showToast(e.getMessage().toString());
        error(e.getMessage().toString());
    }

    @Override
    public void onComplete() {
        success(entity);
    }
}
