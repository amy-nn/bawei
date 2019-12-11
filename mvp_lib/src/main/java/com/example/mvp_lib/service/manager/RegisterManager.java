package com.example.mvp_lib.service.manager;

import com.example.mvp_lib.service.RetrofitHelper;
import com.example.mvp_lib.service.RetrofitService;
import com.example.mvp_lib.service.entity.LoginBean;
import com.example.mvp_lib.service.entity.LoginResponseBean;
import com.example.mvp_lib.service.entity.RegisterBean;

import java.util.HashMap;

import io.reactivex.Observable;


/**
 * 注册管理
 */
public class RegisterManager {


    private RetrofitService retrofitService;
    private String baseUrl;

    public RegisterManager(String baseUrl){
        this.baseUrl = baseUrl;
    }

    /**
     * 调用RetrofitService接口中的方法
     * @return
     */
    public Observable<RegisterBean> regist(HashMap<String,String> params){
        retrofitService = RetrofitHelper.getHelper(baseUrl).getService();
        return retrofitService.registerUser(params);
    }

    /**
     * Manger调用接口中的方法
     * @param bean
     * @return
     */
    public Observable<String> login(HashMap<String,String> bean){
        retrofitService = RetrofitHelper.getHelper(baseUrl).getService();
        return retrofitService.loginUser(bean);
    }


}
