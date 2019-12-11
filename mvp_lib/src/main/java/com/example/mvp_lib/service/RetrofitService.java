package com.example.mvp_lib.service;

import com.example.mvp_lib.service.entity.LoginBean;
import com.example.mvp_lib.service.entity.LoginResponseBean;
import com.example.mvp_lib.service.entity.RegisterBean;
import java.util.HashMap;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * 网络访问层
 */
public interface RetrofitService {

    @POST("videouser/register")
    public Observable<RegisterBean> registerUser(@Body HashMap<String,String> parms);

    @POST("videouser/login")
    //public Observable<LoginResponseBean> loginUser(@Body LoginBean bean);
    public Observable<String> loginUser(@Body HashMap<String,String> bean);

}
