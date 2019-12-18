package com.example.user.mvp.model;

import com.example.user.entity.UserBean;
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
    @POST("/videouser/register")
    public Observable<UserBean> regist(@Body RequestBody params);

    public Observable<UserBean> login();
}
