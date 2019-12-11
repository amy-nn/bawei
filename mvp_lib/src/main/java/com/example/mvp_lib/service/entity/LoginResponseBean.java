package com.example.mvp_lib.service.entity;

/**
 * {
 *   "calendar": "string",
 *   "headImg": "string",
 *   "introduction": "string",
 *   "phoneNum": 0,
 *   "sex": "string",
 *   "userAddress": "string",
 *   "userId": 0,
 *   "userPassWord": "string"
 * }
 *
 * 登录响应实体类
 */
public class LoginResponseBean {

    public String calendar;
    public String headImg;
    public String introduction;
    public String phoneNum;
    public String sex;
    public String userAddress;
    public String userId;
    public String userPassWord;

    @Override
    public String toString() {
        return "LoginResponseBean{" +
                "calendar='" + calendar + '\'' +
                ", headImg='" + headImg + '\'' +
                ", introduction='" + introduction + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", sex='" + sex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userId='" + userId + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                '}';
    }
}
