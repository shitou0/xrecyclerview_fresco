package com.example.elianxi_dengluzhuce.model;

import android.util.Log;

import com.example.elianxi_dengluzhuce.http.RetrofitUtils;
import com.example.elianxi_dengluzhuce.model.bean.RegBean;
import com.example.elianxi_dengluzhuce.model.bean.ShowBean;
import com.example.elianxi_dengluzhuce.model.bean.UserBean;
import com.example.elianxi_dengluzhuce.presenter.IPresenter;

import java.util.Map;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 石头 on 2018/4/5.
 */

public class MyModel implements IModel {
    private IPresenter iPresenter;

    public MyModel(IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    //    ----------------------------登陆------------------------------
    @Override
    public void login(Map<String, String> map) {
        RetrofitUtils retrofitUtils = RetrofitUtils.getRetrofitUtils();
        MyService myService = retrofitUtils.createService(MyService.class);
        myService.loginPost(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("aaa", "----完成登陆-----");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("aaa", "----失败登陆-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        Log.d("aaa", "----正在执行 登陆-----");

                        if (userBean.getCode().equals("0")) {
                            iPresenter.getLogin(userBean);
                        } else {
                            iPresenter.getErrorData("请注册");
                        }
                    }
                });


    }

    //-------------------------------------注册-----------------------------------
    @Override
    public void reg(Map<String, String> map) {
        RetrofitUtils retrofitUtils = RetrofitUtils.getRetrofitUtils();
        MyService myService = retrofitUtils.createService(MyService.class);
        myService.regPost(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("bbb", "----完成注册-----");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bbb", "----失败注册-----" + e.getMessage());
                        iPresenter.getRegErrorData("注册失败");
                    }

                    @Override
                    public void onNext(RegBean regBean) {
                        //chuanru presenter
                        Log.d("bbb", "----正在执行注册-----");

                        if (regBean.getCode().equals("0")) {
                            iPresenter.getReg(regBean);
                        } else {
                            iPresenter.getRegErrorData("注册失败");
                        }
                    }
                });
    }

    //-----------------------------------展示商品------------------------------------
    @Override
    public void showGood(Map<String, String> map) {
        RetrofitUtils instance = RetrofitUtils.getRetrofitUtils();
        MyService myService = instance.createService(MyService.class);
        Observable<ShowBean> observable = myService.getGoodsList(map);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("ccc", "onCompleted()-获取商品展示完成----------------");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ccc", "onError()-获取商品展示异常----------------" + e.getMessage());
                    }

                    @Override
                    public void onNext(ShowBean showBean) {
                        Log.d("ccc", "onNext()-获取商品展示-正在执行----------------" + showBean);
                        if (showBean.getCode().equals("0")) {
                            iPresenter.getGoodListData(showBean.getData());
                        }
                    }
                });
    }

    //-----------------------------------刷新----------------------------
    @Override
    public void getRefresh(Map<String, String> map) {
        RetrofitUtils instance = RetrofitUtils.getRetrofitUtils();
        MyService myService = instance.createService(MyService.class);
        Observable<ShowBean> observable = myService.getGoodsList(map);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("ddd", "onCompleted()-刷新完成----------------");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ddd", "onError()-刷新展示异常----------------" + e.getMessage());
                    }

                    @Override
                    public void onNext(ShowBean showBean) {
                        Log.d("ddd", "onNext()-刷新-正在执行----------------" + showBean);
                        if (showBean.getCode().equals("0")) {
                            iPresenter.getRegFreshListData(showBean.getData());
                        }
                    }
                });
    }

    //---------------------------加载----------------------------
    @Override
    public void getLoadMore(Map<String, String> map) {
        RetrofitUtils instance = RetrofitUtils.getRetrofitUtils();
        MyService myService = instance.createService(MyService.class);
        Observable<ShowBean> observable = myService.getGoodsList(map);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("eee", "onCompleted()-加载完成----------------");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("eee", "onError()-加载展示异常----------------" + e.getMessage());
                    }

                    @Override
                    public void onNext(ShowBean showBean) {
                        Log.d("eee", "onNext()-加载-正在执行----------------" + showBean);
                        if (showBean.getCode().equals("0")) {
                            iPresenter.getLoadListData(showBean.getData());
                        }
                    }
                });
    }
}
