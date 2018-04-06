package com.example.elianxi_dengluzhuce.view;

import com.example.elianxi_dengluzhuce.model.bean.ShowBean;

import java.util.List;

/**上拉刷新下拉加载
 * Created by 石头 on 2018/4/6.
 */

public interface GoodVIew {
    //展示数据
    void showGoodsList(List<ShowBean.DataBean> show_list);

    //刷新
    void getRegFresh(List<ShowBean.DataBean> list);

    //加载
    void getLoadMore(List<ShowBean.DataBean> list);

    //获取page
    String getpage();

}
