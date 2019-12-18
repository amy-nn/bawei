package com.example.mvp_lib.presenter;

import android.util.Log;

import com.example.mvp_lib.service.RetrofitHelper;
import com.example.mvp_lib.service.entity.LoginBean;
import com.example.mvp_lib.service.entity.LoginResponseBean;
import com.example.mvp_lib.service.manager.RegisterManager;
import com.example.mvp_lib.view.LoginView;
import com.example.mvp_lib.view.View;
import java.util.HashMap;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class LoginPresenter implements IPresenter{

    private RegisterManager manager;
    private LoginView loginView;
    private LoginResponseBean responseBean;
    private Retrofit retrofit;


    @Override
    public void distroy() {

    }

    @Override
    public void attchView(View view) {
        loginView = (LoginView) view;
    }

    /**
     * 实现具体的登陆逻辑
     */
    public void userLogin(HashMap<String,String> bean)
    {
        manager = new RegisterManager("http://172.81.227.127:8088/");
        Observable<String> loginObservable = manager.login(bean); //RxJava异步
        loginObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String loginResponseBean) {
                        //responseBean = loginResponseBean;
                        Log.d("amy","onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginView.loginEorror("错误");
                        Log.d("amy","error");
                    }

                    @Override
                    public void onComplete() {
                       //loginView.loginSuccess(responseBean);
                        loginView.loginSuccess("成功");
                        Log.d("amy","success");
                    }
                });
    }


}
