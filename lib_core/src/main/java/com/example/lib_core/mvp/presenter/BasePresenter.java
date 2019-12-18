package com.example.lib_core.mvp.presenter;
import com.example.lib_core.mvp.model.IModel;
import com.example.lib_core.mvp.view.IView;

/**
 * 调用View和Model
 * @param <M>
 * @param <V>
 */
public class BasePresenter<M extends IModel,V extends IView> implements IPresenter{

    protected M mModel;
    protected V view;

    public BasePresenter(M mModel,V view){
        this.mModel = mModel;
        this.view = view;
    }
}
