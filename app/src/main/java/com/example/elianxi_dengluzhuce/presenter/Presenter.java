package com.example.elianxi_dengluzhuce.presenter;

import android.util.Log;

import com.example.elianxi_dengluzhuce.model.IModel;
import com.example.elianxi_dengluzhuce.model.bean.RegBean;
import com.example.elianxi_dengluzhuce.model.bean.ShowBean;
import com.example.elianxi_dengluzhuce.model.bean.UserBean;
import com.example.elianxi_dengluzhuce.view.GoodVIew;
import com.example.elianxi_dengluzhuce.view.IMyView;
import com.example.elianxi_dengluzhuce.view.IRegView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 石头 on 2018/4/5.
 */

public class Presenter implements IPresenter {

    private IMyView iMyView;
    private IRegView iRegView;
    private GoodVIew goodVIew;

    //---------------------登陆-----------------------------
    @Override
    public void LoginPresenter(IModel iModel, IMyView iMyView) {
        this.iMyView = iMyView;
        Map<String, String> map = new HashMap<>();
        map.put("mobile", iMyView.getMobile());
        map.put("password", iMyView.getPassword());
        iModel.login(map);

    }

    //登陆成功
    @Override
    public void getLogin(UserBean userBean) {
        iMyView.loginSuccess();
    }

    //登陆失败
    @Override
    public void getErrorData(String string) {
        iMyView.loginError(string);
    }

    //-------------------------注册-------------------------------
    @Override
    public void regPresenter(IModel iModel, IRegView iRegView) {
        this.iRegView = iRegView;
        Map<String, String> map = new HashMap<>();
        map.put("mobile", iRegView.getMobile());
        map.put("password", iRegView.getPassword());
        iModel.reg(map);
    }

    @Override
    public void getReg(RegBean regBean) {
        iRegView.register();
    }

    @Override
    public void getRegErrorData(String string) {
        iRegView.regError(string);
    }

    //-------------------------展示商品-------------------------------
    @Override
    public void showgood(IModel iModel, GoodVIew goodVIew) {
        this.goodVIew = goodVIew;
        Map<String, String> map = new HashMap<>();
//        pscid=39&page=1
        map.put("pscid", "39");
        map.put("page", "1");
        iModel.showGood(map);
    }

    @Override
    public void getGoodListData(List<ShowBean.DataBean> show_list) {
        Log.d("ccc", "--------p层展示");
        goodVIew.showGoodsList(show_list);
    }

    //-------------------------刷新商品-------------------------------
    @Override
    public void regFresh(IModel iModel, GoodVIew goodVIew) {
        Log.d("ddd", "--------p层刷新");
        this.goodVIew = goodVIew;
        Map<String, String> map = new HashMap<>();
        map.put("page", goodVIew.getpage());
        map.put("pscid", "39");
        iModel.getRefresh(map);
    }

    @Override
    public void getRegFreshListData(List<ShowBean.DataBean> regfresh_list) {
        goodVIew.getLoadMore(regfresh_list);
    }

    //-------------------------加载商品-------------------------------
    @Override
    public void loadFresh(IModel iModel, GoodVIew goodVIew) {
        this.goodVIew = goodVIew;
        Map<String, String> map = new HashMap<>();
        map.put("page", goodVIew.getpage());
        map.put("pscid", "39");
        iModel.getLoadMore(map);
    }

    @Override
    public void getLoadListData(List<ShowBean.DataBean> load_list) {
        goodVIew.getLoadMore(load_list);
    }
}
