package com.example.elianxi_dengluzhuce.view;

/**
 * 注册 接口
 * Created by 石头 on 2018/4/5.
 */

public interface IRegView {
    //注册
//    成功
    void register();

    //失败
    void regError(String error);

    //获得注册的 姓名
    String getMobile();

    //获得注册的 密码
    String getPassword();
}
