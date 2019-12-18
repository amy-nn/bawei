package com.example.lib_core.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.lib_core.mvp.presenter.IPresenter;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IActivity,IView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        setInject();
        init();
        initData();

    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, "ddd", Toast.LENGTH_SHORT).show();
    }
}
