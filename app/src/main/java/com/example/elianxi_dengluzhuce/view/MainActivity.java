package com.example.elianxi_dengluzhuce.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elianxi_dengluzhuce.R;
import com.example.elianxi_dengluzhuce.model.MyModel;
import com.example.elianxi_dengluzhuce.presenter.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登陆界面
 * 1.首先登陆
 * 2.假如没有注册过 就跳转到注册界面进行注册
 */
public class MainActivity extends AppCompatActivity implements IMyView {

    @BindView(R.id.edit_name)
    EditText edit_Name;
    @BindView(R.id.edit_pass)
    EditText edit_Pass;
    @BindView(R.id.btn_denglu)
    Button btn_Denglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    //成功的方法
    @Override
    public void loginSuccess() {
        Log.d("aaa", "-------登陆成功，欢迎使用------");
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, GoodActivity.class));
    }

    //失败的方法
    @Override
    public void loginError(String error) {
        Log.d("aaa", "-------登陆失败，请注册------");
        Toast.makeText(this, "登陆失败，请注册", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, RegActivity.class));
    }

    //获得用户名
    @Override
    public String getMobile() {
        return edit_Name.getText().toString();
    }

    //获得密码
    @Override
    public String getPassword() {
        return edit_Pass.getText().toString();
    }

    //登陆点击事件
    @OnClick(R.id.btn_denglu)
    public void onViewClicked() {
        Presenter presenter = new Presenter();
        presenter.LoginPresenter(new MyModel(presenter), this);
        Log.d("aaa", "-----登陆成功-----");
    }
}
