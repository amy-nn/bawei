package com.example.mvp_lib.service;

import android.util.Log;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 1.初始化HttpClient
 * 2.初初化retrofit
 * 3.获得RetrofitService对象
 */
public class RetrofitHelper {

    private OkHttpClient client;
    private Retrofit retrofit;
    private RetrofitService service;
    private static String baseUrl;

    private static RetrofitHelper helper = null;

    private RetrofitHelper(String baseUrl){
        this.baseUrl = baseUrl;
        init();
        initRetrofitService();
    }

    public static RetrofitHelper getHelper(String baseUrl){
        if(helper == null){
            synchronized (RetrofitHelper.class){
                if(helper == null){
                    helper = new RetrofitHelper(baseUrl);
                }
            }
        }
        return helper;
    }


    public void init(){
        client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Response response = chain.proceed(request);
                        Log.d("amy",response.message().toString());
                        Log.d("amy",request.url().toString());
                        return response;
                    }
                })
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

    }


    /**
     * 获得服务
     * @return
     */
    private void initRetrofitService(){
        service = retrofit.create(RetrofitService.class);
    }

    /**
     * 返回接口对象
     * @return
     */
    public RetrofitService getService(){
        return service;
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

}
