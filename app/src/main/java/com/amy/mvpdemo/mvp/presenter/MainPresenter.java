package com.amy.mvpdemo.mvp.presenter;

import com.amy.mvpdemo.mvp.contract.MainContract;
import com.example.lib_core.mvp.presenter.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.MainIModel,MainContract.MainIView> {

    public MainPresenter(MainContract.MainIModel mModel, MainContract.MainIView view) {
        super(mModel, view);
    }
}
