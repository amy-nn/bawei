package com.example.user.mvp.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import com.example.lib_core.base.BaseApplication;
import com.example.lib_core.mvp.model.BaseObserver;
import com.example.lib_core.mvp.presenter.BasePresenter;
import com.example.user.UserApp;
import com.example.user.entity.UserBean;
import com.example.user.entity.UserBean2;
import com.example.user.mvp.contract.LoginContract;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        jsonObject.addProperty("userName",name);
        jsonObject.addProperty("passwd",passwd);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
        mModel.registUser(body, new BaseObserver<UserBean2, LoginContract.LoginView>(view){

            @Override
            public void success(UserBean2 entity) {
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

    /**
     * 登录的具体逻辑
     */
    public void login(){

        String name = view.getUserName();
        String passwd = view.getUserPassword();

        Log.d("login","name-passwd"+name+passwd); //登陆功能成功

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userName",name);
        jsonObject.addProperty("passwd",passwd);

        final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
        mModel.loginUser(requestBody, new BaseObserver<UserBean2, LoginContract.LoginView>(view) {
            @Override
            public void success(UserBean2 entity) {
                Log.d("amy","login");
                view.showToast(entity.toString());

                /**
                 * 读取内存中是否有用户信息，如果有该用户则不加入内存中
                 */
                SharedPreferences sharedPreferences = UserApp.context.getSharedPreferences("data",Context.MODE_PRIVATE);
                if(sharedPreferences.getString("username","") == null || sharedPreferences.getString("username","")
                .isEmpty()){
                    //没有登录，则显示登录页面


                }
                else {
                    //显示登出页面

                }
            }

            @Override
            public void error(String errorStr) {
                view.showToast("登录失败"+errorStr);
            }
        });
    }


}
