package com.example.user.mvp.model;

import com.example.user.entity.UserBean;
import com.example.user.entity.UserBean2;

import java.util.HashMap;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface LoginApi {

    //@FormUrlEncoded
    @POST("/userinfoController/register")
    public Observable<UserBean2> regist(@Body RequestBody params);

    @POST("userinfoController/login")
    public Observable<UserBean2> login(@Body RequestBody loginParams);

}
