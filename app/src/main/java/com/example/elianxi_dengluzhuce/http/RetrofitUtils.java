package com.example.elianxi_dengluzhuce.http;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 石头 on 2018/4/5.
 */

public class RetrofitUtils {


    private static RetrofitUtils retrofitUtils;
    private final Retrofit retrofit;

    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils == null) {
            retrofitUtils = new RetrofitUtils();
        }
        return retrofitUtils;
    }

    public RetrofitUtils() {
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.base_url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public <T> T createService(Class<T> t) {
        T t1 = retrofit.create(t);
        return t1;
    }
}
