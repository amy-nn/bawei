package com.example.user.mvp.contract;

import com.example.lib_core.mvp.model.BaseObserver;
import com.example.lib_core.mvp.model.IModel;
import com.example.lib_core.mvp.view.IView;
import com.example.user.entity.UserBean;

import java.util.HashMap;
import java.util.Observer;

import okhttp3.RequestBody;

/**
 * 登陆合同（主要写具体view和Model的接口，规范）
 */
public interface LoginContract {

    public interface LoginView extends IView {

        //获得用户名
        public String getUserName();
        //获得密码
        public String getUserPassword();

    }

    public interface LoginIModel extends IModel{

        public void registUser(RequestBody data, BaseObserver<UserBean,LoginView> observer);
        public void loginUser(HashMap<String,String> data,BaseObserver<UserBean,LoginView> observer);
    }

}
