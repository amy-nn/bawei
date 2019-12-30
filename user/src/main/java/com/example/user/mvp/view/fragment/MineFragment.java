package com.example.user.mvp.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.lib_core.base.SPUtils;
import com.example.lib_core.mvp.view.BaseFragment;
import com.example.user.R;
import com.example.user.entity.UserBean2;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

@Route(path = "/userModel/mineFragment")
public class MineFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout logoutLayout; //已登录页面
    private RelativeLayout loginLayout; //未登录页面
    private LinearLayout logoutBtn;  //退出按钮布局
    private TextView exitBtn; //退出按钮
    private Button loginBtn; //登录按钮

    @Override
    public int layout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initData() {
        logoutLayout = getActivity().findViewById(R.id.logoutLayout);
        loginLayout = getActivity().findViewById(R.id.loginLayout1);
        logoutBtn = getActivity().findViewById(R.id.logoutBtn);
        loginBtn = loginLayout.findViewById(R.id.login_regist);
        exitBtn = getActivity().findViewById(R.id.logoutText);
        loginBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);

        /**
         * 判断用户是否已经登陆
         */
        String userName = SPUtils.getInstance().getString("username","");
        if(userName != null && !userName.isEmpty()){
            //说明已经登陆了
            logout();
        }
        else {
            login();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void setInject() {

    }

    @Override
    public void showToast(String string) {

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_regist){
            //Toast.makeText(getContext(), "登录注册", Toast.LENGTH_SHORT).show();
            ARouter.getInstance().build("/user/UserActivity").navigation();
        }
        else if(v.getId() == R.id.logoutText)
        {
            //点了退出按钮，清空数据，显示登录界面
            SPUtils.getInstance().remove("username");
            SPUtils.getInstance().remove("userInfo");
            login();
        }
    }

    /**
     * 默认显示未登陆状态(提醒用户登陆）
     */
    public void login(){

        loginLayout.setVisibility(View.VISIBLE);
        logoutBtn.setVisibility(View.GONE);
        logoutLayout.setVisibility(View.GONE);
    }


    /**
     * 显示已经登陆信息
     */
    public void logout(){
        loginLayout.setVisibility(View.GONE); //登录按钮不显示
        logoutLayout.setVisibility(View.VISIBLE); //登录信息显示
        logoutBtn.setVisibility(View.VISIBLE); //退出按钮出来

        //解析获得用户数据填充到界面上
        String json = "{userid=13, username='amy', calendar='null', headimg='null', introduction='null', phonenum='null', sex='null', useraddress='null', userpassword='123'}";
        //SPUtils.getInstance().getString("userInfo","");
        Log.d("amy","json-"+json);
        UserBean2 userBean2 = new Gson().fromJson(json,UserBean2.class);
        Log.d("amy",userBean2.toString());
        TextView userNameText = logoutLayout.findViewById(R.id.userText);
        userNameText.setText(userBean2.username);
        ImageView showHead = logoutLayout.findViewById(R.id.showImage);
        if(userBean2.headimg != null && !userBean2.headimg.isEmpty())
        {
//            new Thread(){
//                @Override
//                public void run() {
//                    super.run();
//                    try {
//                        OkHttpClient client = new OkHttpClient();
//                        Request request = new Request.Builder().url(userBean2.headimg).build();
//                        ResponseBody body = client.newCall(request).execute().body();
//                        InputStream inputStream = body.byteStream();
//                        Bitmap image = BitmapFactory.decodeStream(inputStream);
//                        showHead.setImageBitmap(image);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.start();
        }
    }
}
