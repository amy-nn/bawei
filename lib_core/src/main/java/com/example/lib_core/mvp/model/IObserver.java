package com.example.lib_core.mvp.model;

public interface IObserver<T> {

    public void success(T entity);

    public void error(String errorStr);
}
