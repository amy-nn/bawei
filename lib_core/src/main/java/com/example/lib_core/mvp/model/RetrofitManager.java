package com.example.lib_core.mvp.model;

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
 * 初始化retrofit对象
 */
public class RetrofitManager {

    private Retrofit retrofit;
    private static RetrofitManager manager;

    private RetrofitManager(){

    }

    public synchronized static RetrofitManager getManager(){
        if(manager == null)
            manager = new RetrofitManager();
        return manager;
    }

    public Retrofit getRetrofit(){
        if(retrofit == null)
            buildRetrofit();
        return retrofit;
    }

    private void buildRetrofit(){

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Response response = chain.proceed(request);
                        Log.d("amy",request.url().toString());
                        Log.d("amy",response.message().toString());
                        return response;
                    }
                }).build();

         retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .baseUrl("http://172.81.227.127:8088/")
                .client(client)
                .build();
    }
}
