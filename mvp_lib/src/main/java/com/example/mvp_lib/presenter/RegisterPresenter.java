package com.example.mvp_lib.presenter;

import android.util.Log;
import com.example.mvp_lib.service.RetrofitHelper;
import com.example.mvp_lib.service.RetrofitService;
import com.example.mvp_lib.service.entity.RegisterBean;
import com.example.mvp_lib.service.manager.RegisterManager;
import com.example.mvp_lib.view.RegistView;
import com.example.mvp_lib.view.View;
import java.io.IOException;
import java.util.HashMap;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 注册逻辑
 */
public class RegisterPresenter implements IPresenter{

    private Retrofit retrofit;
    private RegisterManager manager;
    private RegistView registView;
    private RegisterBean rBean;


    @Override
    public void distroy() {

    }

    @Override
    public void attchView(View view) {
        registView = (RegistView) view;

    }

    public void registerInfo(String phoneNum,String passwd){

        manager = new RegisterManager("http://172.81.227.127:8088/");

        HashMap<String,String> param = new HashMap<>();
        param.put(phoneNum,phoneNum);
        param.put(passwd,passwd);

        Observable<RegisterBean> beanObservable = manager.regist(param);
        beanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean bean) {
                        rBean = bean;
                    }

                    @Override
                    public void onError(Throwable e) {
                        registView.error(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        registView.success(rBean);
                    }
                });
    }

}
