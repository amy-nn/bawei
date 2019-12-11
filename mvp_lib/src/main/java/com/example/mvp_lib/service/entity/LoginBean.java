package com.example.mvp_lib.service.entity;

/**
 * {
 *   "phoneNum": 123321,
 *   "userPassWord": "123456"
 * }
 * 登陆请求bean
 */
public class LoginBean {

    public String phoneNum;
    public String userPassWord;

    @Override
    public String toString() {
        return "LoginBean{" +
                "phoneNum='" + phoneNum + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                '}';
    }
}
