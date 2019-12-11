package com.example.mvp_lib.view;

import com.example.mvp_lib.service.entity.LoginResponseBean;

public interface LoginView extends View{

    public void loginSuccess(String bean);

    public void loginEorror(String errorStr);
}
