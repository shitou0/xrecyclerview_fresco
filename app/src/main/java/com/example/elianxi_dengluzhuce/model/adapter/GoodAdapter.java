package com.example.elianxi_dengluzhuce.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elianxi_dengluzhuce.R;
import com.example.elianxi_dengluzhuce.model.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
import java.util.SimpleTimeZone;

/**
 * Created by 石头 on 2018/4/6.
 */

public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.MyViewHolder> {

    Context context;
    List<ShowBean.DataBean> list;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<ShowBean.DataBean> getList() {
        return list;
    }

    public void setList(List<ShowBean.DataBean> list) {
        this.list = list;
    }

    public GoodAdapter(Context context, List<ShowBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.xrecycler_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String image_url = list.get(position).getImages().split("\\|")[0];
        holder.getXrecycler_img().setImageURI(image_url);
        holder.getGoods_text().setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView goods_text;
        private SimpleDraweeView xrecycler_img;

        public TextView getGoods_text() {
            return goods_text;
        }

        public SimpleDraweeView getXrecycler_img() {
            return xrecycler_img;
        }

        public void setXrecycler_img(SimpleDraweeView xrecycler_img) {
            this.xrecycler_img = xrecycler_img;
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            xrecycler_img = itemView.findViewById(R.id.xrecycler_img);
            goods_text = itemView.findViewById(R.id.xrecycler_text);
        }
    }

}
