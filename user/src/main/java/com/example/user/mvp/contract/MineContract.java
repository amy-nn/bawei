package com.example.user.mvp.contract;

import com.example.lib_core.mvp.model.IModel;
import com.example.lib_core.mvp.view.IView;

/**
 * "我的"模块合约
 */
public interface MineContract {

    public interface MineIview extends IView{
        public void login();
        public void logout();

    }

    public interface MineIModel extends IModel{

    }
}
