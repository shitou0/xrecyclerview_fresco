package com.example.elianxi_dengluzhuce.model;

import java.util.Map;

/**
 * Created by 石头 on 2018/4/5.
 */

public interface IModel {

    //登录
    void login(Map<String, String> map);

    //注册
    void reg(Map<String, String> map);

    //展示数据
    void showGood(Map<String, String> map);

    //刷新
    void getRefresh(Map<String, String> map);

    //加载
    void getLoadMore(Map<String, String> map);
}
