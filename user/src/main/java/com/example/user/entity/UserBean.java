package com.example.user.entity;

/**
 * 用户响应数据
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
 */
public class UserBean {

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
        return "UserBean{" +
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
