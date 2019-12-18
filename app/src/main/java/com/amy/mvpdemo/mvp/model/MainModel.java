package com.amy.mvpdemo.mvp.model;

import com.amy.mvpdemo.mvp.contract.MainContract;
import com.example.lib_core.mvp.model.BaseObserver;
import io.reactivex.Observable;

public class MainModel implements MainContract.MainIModel {

    @Override
    public void request(Observable<?> observable, BaseObserver observer) {

    }

}
