package com.amy.mvpdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.amy.mvpdemo.mvp.contract.MainContract;
import com.example.lib_core.mvp.view.BaseActivity;
import com.example.user.mvp.view.fragment.MineFragment;
import java.util.ArrayList;

@Route(path = "/app/MainActivity")
public class MainActivity extends BaseActivity implements MainContract.MainIView, View.OnClickListener {

    private TextView homeText;
    private TextView hotelText;
    private TextView mineText;
    private RelativeLayout homeLayout;
    private RelativeLayout mineLayout;
    private MineFragment mineFragment;
    private FragmentManager fragmentManager;

    /**
     * 用来存所有的Fragment
     */
    private ArrayList<Fragment> fragments = null;

    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        //初始化Fragment
        mineFragment = new MineFragment();
        if(fragments == null)
            fragments = new ArrayList<>();

        fragments.add(mineFragment);

        showFragment();
    }

    @Override
    public void init() {
        homeText = findViewById(R.id.homeText);
        hotelText = findViewById(R.id.hotelText);
        mineText = findViewById(R.id.mineText);
        homeLayout = findViewById(R.id.homeLayout);
        mineLayout = findViewById(R.id.mineLayout);
        homeLayout.setOnClickListener(this);
        mineLayout.setOnClickListener(this);
    }

    @Override
    public void setInject() {

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.homeLayout){
//            ARouter.getInstance().build("/user/UserActivity").navigation();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.hide(mineFragment);
            transaction.commit();
        }
        else if(v.getId() == R.id.mineLayout){
           // ARouter.getInstance().build("/userModel/mineFragment").navigation();
            /**
             * 显示Fragment
             */
//            Toast.makeText(this, "我的", Toast.LENGTH_SHORT).show();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.show(mineFragment);
            transaction.commit();
        }
    }

    /**
     * 添加Fragment
     */
    public void showFragment(){
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.homeFrame,mineFragment);
        transaction.commit();
    }
}
