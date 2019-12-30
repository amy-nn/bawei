package com.example.user.mvp.model;

import com.example.lib_core.mvp.model.BaseModel;
import com.example.lib_core.mvp.model.BaseObserver;
import com.example.lib_core.mvp.model.RetrofitManager;
import com.example.user.entity.UserBean;
import com.example.user.entity.UserBean2;
import com.example.user.mvp.contract.LoginContract;
import com.google.gson.JsonObject;
import java.util.HashMap;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

/**
 * 具体的逻辑
 */
public class LoginModel extends BaseModel implements LoginContract.LoginIModel {

    Retrofit retrofit;

    @Override
    public void registUser(RequestBody data, BaseObserver<UserBean2, LoginContract.LoginView> observer) {

        if(retrofit == null)
            retrofit = RetrofitManager.getManager().getRetrofit();
        Observable<UserBean2> observable = retrofit.create(LoginApi.class).regist(data);
        request(observable,observer);
    }

    @Override
    public void loginUser(RequestBody data, BaseObserver<UserBean2, LoginContract.LoginView> observer) {

        if(retrofit == null)
            retrofit = RetrofitManager.getManager().getRetrofit(); //获得retrofit对象

        Observable<UserBean2> observable = retrofit.create(LoginApi.class).login(data);
        request(observable,observer);
    }
}
