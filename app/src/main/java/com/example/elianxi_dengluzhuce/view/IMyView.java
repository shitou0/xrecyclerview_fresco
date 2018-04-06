package com.example.elianxi_dengluzhuce.view;

/**
 * 登陆接口
 * Created by 石头 on 2018/4/5.
 */

public interface IMyView {
    //登陆成功的方法
    void loginSuccess();

    //    登陆失败的方法
    void loginError(String error);

    //获得  登陆 姓名
    String getMobile();

    //获得  登陆 密码
    String getPassword();
}
