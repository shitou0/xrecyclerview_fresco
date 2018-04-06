package com.example.elianxi_dengluzhuce.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.elianxi_dengluzhuce.R;
import com.example.elianxi_dengluzhuce.model.MyModel;
import com.example.elianxi_dengluzhuce.model.adapter.GoodAdapter;
import com.example.elianxi_dengluzhuce.model.bean.ShowBean;
import com.example.elianxi_dengluzhuce.presenter.Presenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * xRecycler  上拉刷新 下拉加载
 */
public class GoodActivity extends AppCompatActivity implements GoodVIew {

    @BindView(R.id.good_xRecycler)
    XRecyclerView good_XRecycler;
    private GoodAdapter goodAdapter;
    List<ShowBean.DataBean> list = new ArrayList<>();
    int page = 1;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);
        ButterKnife.bind(this);
//        给xrecycler一个布局
//        初始化数据
        initviews();
        presenter = new Presenter();
        presenter.showgood(new MyModel(presenter), this);

    }

    //        初始化数据
    private void initviews() {
        good_XRecycler.setLayoutManager(new LinearLayoutManager(this));
//        setLoadingMoreEnabled允许下拉刷新
        good_XRecycler.setLoadingMoreEnabled(true);
//        setPullRefreshEnabled允许上拉加载
        good_XRecycler.setPullRefreshEnabled(true);
        good_XRecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            // 刷新
            @Override
            public void onRefresh() {
                page = 1;
                presenter.regFresh(new MyModel(presenter), GoodActivity.this);
                good_XRecycler.refreshComplete();
            }

            //加载
            @Override
            public void onLoadMore() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        presenter.loadFresh(new MyModel(presenter), GoodActivity.this);
                        good_XRecycler.loadMoreComplete();
                    }
                }, 1000);

            }
        });

    }

    //展示商品
    @Override
    public void showGoodsList(List<ShowBean.DataBean> show_list) {
        Log.d("ccc", "-展示列表activity--获取到集合--------" + show_list);
        goodAdapter = new GoodAdapter(this, show_list);
    //放入适配器
        good_XRecycler.setAdapter(goodAdapter);
    }

    //刷新
    @Override
    public void getRegFresh(List<ShowBean.DataBean> list) {
        this.list = list;
//        在适配器里面给集合一个get set 方法就可以直接拿到集合
        goodAdapter.setList(list);
//        notifyDataSetChanged刷新
        goodAdapter.notifyDataSetChanged();
    }

    //加载
    @Override
    public void getLoadMore(List<ShowBean.DataBean> list) {
        goodAdapter.getList().addAll(list);
        //  notifyDataSetChanged刷新
        goodAdapter.notifyDataSetChanged();
    }

    //获取page
    @Override
    public String getpage() {
        return page + "";
    }
}
