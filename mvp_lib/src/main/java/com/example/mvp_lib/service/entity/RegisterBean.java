package com.example.mvp_lib.service.entity;

/**
 * {
 *   "calendar": "",
 *   "headImg": "",
 *   "introduction": "",
 *   "sex": "",
 *   "userAddress": "",
 *   "phoneNum": 0,
 *   "userPassWord": "string",
 *   "userId": 1
 * }
 *
 * 注册响应
 */
public class RegisterBean {

    public String calendar;
    public String headImg;
    public String introduction;
    public String sex;
    public String userAddress;
    public long phoneNum;
    public String userPassWord;
    public long userId;


    @Override
    public String toString() {
        return "RegisterBean{" +
                "calendar='" + calendar + '\'' +
                ", headImg='" + headImg + '\'' +
                ", introduction='" + introduction + '\'' +
                ", sex='" + sex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", phoneNum=" + phoneNum +
                ", userPassWord='" + userPassWord + '\'' +
                ", userId=" + userId +
                '}';
    }
}
