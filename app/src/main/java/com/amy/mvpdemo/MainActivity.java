package com.amy.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.amy.mvpdemo.R;
import com.example.mvp_lib.presenter.LoginPresenter;
import com.example.mvp_lib.presenter.RegisterPresenter;
import com.example.mvp_lib.service.entity.LoginBean;
import com.example.mvp_lib.service.entity.LoginResponseBean;
import com.example.mvp_lib.service.entity.RegisterBean;
import com.example.mvp_lib.view.LoginView;
import com.example.mvp_lib.view.RegistView;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private RegisterPresenter presenter;
    private EditText phoneNum,passwd;
    private TextView showResult;
    private String phoneNumStr,passwdStr;
    private LoginPresenter loginPresenter;

    private RegistView registView = new RegistView() {
        @Override
        public void success(RegisterBean bean) {

            showResult.setText(bean.toString());
        }

        @Override
        public void error(String errorMsg) {
            showResult.setText(errorMsg);
        }
    };


    private LoginView loginView = new LoginView() {
        @Override
        public void loginSuccess(String bean) {
            showResult.setText(bean.toString());
        }

        @Override
        public void loginEorror(String errorStr) {
            showResult.setText(errorStr);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        presenter.attchView(registView);
        loginPresenter.attchView(loginView);

    }


    public void init(){
        phoneNum = findViewById(R.id.name);
        passwd = findViewById(R.id.passwd);
        showResult = findViewById(R.id.showResult);

        presenter = new RegisterPresenter();
        loginPresenter = new LoginPresenter();
    }

    /**
     * 注册
     * @param view
     */
    public void regist(View view) {


        phoneNumStr = phoneNum.getText().toString();
        passwdStr = passwd.getText().toString();
        presenter.registerInfo(phoneNumStr,passwdStr);

    }


    /**
     * 登陆
     * @param view
     */
    public void login(View view) {

        phoneNumStr = phoneNum.getText().toString();
        passwdStr = passwd.getText().toString();
//        LoginBean bean = new LoginBean();
//        bean.phoneNum = phoneNumStr;
//        bean.userPassWord = passwdStr;

        HashMap<String,String> bean = new HashMap<>();
        bean.put("phoneNum",phoneNumStr);
        bean.put("userPassWord",passwdStr);

        loginPresenter.userLogin(bean);
    }
}
