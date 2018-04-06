package com.example.elianxi_dengluzhuce.model;

import com.example.elianxi_dengluzhuce.model.bean.RegBean;
import com.example.elianxi_dengluzhuce.model.bean.ShowBean;
import com.example.elianxi_dengluzhuce.model.bean.UserBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 石头 on 2018/4/5.
 */

public interface MyService {
    //登录
    @FormUrlEncoded
    @POST("user/login")
    Observable<UserBean> loginPost(@FieldMap Map<String,String> map);

    //注册
    @FormUrlEncoded
    @POST("user/reg")
    Observable<RegBean> regPost(@FieldMap Map<String,String> map);

    //展示商品列表
    @FormUrlEncoded
    @POST("/product/getProducts")
    Observable<ShowBean> getGoodsList(@FieldMap Map<String, String> map);

}
