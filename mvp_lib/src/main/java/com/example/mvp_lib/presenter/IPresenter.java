package com.example.mvp_lib.presenter;

import com.example.mvp_lib.view.View;

/**
 * 管理生命周期
 */
public interface IPresenter {

    public void distroy();

    public void attchView(View view);
}
