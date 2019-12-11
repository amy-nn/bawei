package com.example.mvp_lib.view;

import com.example.mvp_lib.service.entity.RegisterBean;

public interface RegistView extends View {

    public void success(RegisterBean bean);
    public void error(String errorMsg);
}
