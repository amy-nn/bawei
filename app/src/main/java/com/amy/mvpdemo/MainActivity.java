package com.amy.mvpdemo;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.amy.mvpdemo.mvp.contract.MainContract;
import com.example.lib_core.mvp.view.BaseActivity;

@Route(path = "/app/MainActivity")
public class MainActivity extends BaseActivity implements MainContract.MainIView, View.OnClickListener {

    private TextView homeText;
    private TextView hotelText;
    private TextView mineText;
    private RelativeLayout homeLayout;

    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

    }

    @Override
    public void init() {
        homeText = findViewById(R.id.homeText);
        hotelText = findViewById(R.id.hotelText);
        mineText = findViewById(R.id.mineText);
        homeLayout = findViewById(R.id.homeLayout);
    }

    @Override
    public void setInject() {

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.homeLayout){
            ARouter.getInstance().build("/user/UserActivity").navigation();
        }
    }
}
