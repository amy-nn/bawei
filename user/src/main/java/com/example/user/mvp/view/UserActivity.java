package com.example.user.mvp.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.lib_core.mvp.view.BaseActivity;
import com.example.user.R;
import com.example.user.mvp.contract.LoginContract;
import com.example.user.mvp.model.LoginModel;
import com.example.user.mvp.presenter.LoginPresenter;

@Route(path = "/user/UserActivity")
public class UserActivity extends BaseActivity {

    private Button button;
    private EditText userName;
    private EditText userPassword;
    private LoginPresenter loginPresenter;

    @Override
    public int layout() {
        return R.layout.activity_user;
    }

    @Override
    public void initData() {

        //LoginContract.LoginIModel mModel, LoginContract.LoginView view
        loginPresenter = new LoginPresenter(new LoginModel(), new LoginContract.LoginView() {
            @Override
            public String getUserName() {
                return userName.getText().toString();
            }

            @Override
            public String getUserPassword() {
                return userPassword.getText().toString();
            }

            @Override
            public void showToast(String string) {
                Toast.makeText(UserActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void init() {
        button = findViewById(R.id.registBtn);
        userName = findViewById(R.id.eName);
        userPassword = findViewById(R.id.ePasswd);
    }

    @Override
    public void setInject() {

    }

    /**
     * 注册方法
     * @param view
     */
    public void onRegist(View view) {

        loginPresenter.regist();
    }
}
