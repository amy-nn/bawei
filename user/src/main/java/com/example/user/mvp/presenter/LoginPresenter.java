package com.example.user.mvp.presenter;

import android.util.Log;
import com.example.lib_core.mvp.model.BaseObserver;
import com.example.lib_core.mvp.presenter.BasePresenter;
import com.example.user.entity.UserBean;
import com.example.user.mvp.contract.LoginContract;
import com.google.gson.JsonObject;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 调用LoginModel和View层
 */
public class LoginPresenter extends BasePresenter<LoginContract.LoginIModel,LoginContract.LoginView> {

    public LoginPresenter(LoginContract.LoginIModel mModel, LoginContract.LoginView view) {
        super(mModel, view);
    }

    /**
     * 调用model的注册功能
     */
    public void regist(){

        /**
         * public void registUser(HashMap<String,String> data, BaseObserver<UserBean,LoginView> observer);
         */
        String name = view.getUserName();
        String passwd = view.getUserPassword();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phoneNum",name);
        jsonObject.addProperty("userPassWord",passwd);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
        mModel.registUser(body, new BaseObserver<UserBean, LoginContract.LoginView>(view){

            @Override
            public void success(UserBean entity) {
                Log.d("amy","success"+entity.toString());
                view.showToast(entity.toString());
            }

            @Override
            public void error(String errorStr) {
                Log.d("amy","error"+errorStr);
                view.showToast(errorStr);
            }
        });
    }

    public void login(){

    }
}
