package com.example.user.entity;

/**
 * "userid": 7,
 *   "username": "13",
 *   "calendar": null,
 *   "headimg": null,
 *   "introduction": null,
 *   "phonenum": null,
 *   "sex": null,
 *   "useraddress": null,
 *   "userpassword": "string"
 */
public class UserBean2 {

    public long userid;
    public String username;
    public String calendar;
    public String headimg;
    public String introduction;
    public String phonenum;
    public String sex;
    public String useraddress;
    public String userpassword;

    @Override
    public String toString() {
        return "UserBean2{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", calendar='" + calendar + '\'' +
                ", headimg='" + headimg + '\'' +
                ", introduction='" + introduction + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", sex='" + sex + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}
