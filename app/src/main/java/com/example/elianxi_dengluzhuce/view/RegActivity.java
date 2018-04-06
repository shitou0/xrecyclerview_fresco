package com.example.elianxi_dengluzhuce.view;

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
 * 注册页面
 */
public class RegActivity extends AppCompatActivity implements IRegView {

    @BindView(R.id.reg_edit_name)
    EditText reg_EditName;
    @BindView(R.id.reg_edit_pass)
    EditText reg_EditPass;
    @BindView(R.id.reg_btn_denglu)
    Button reg_BtnDenglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
    }
//注册按钮
    @OnClick(R.id.reg_btn_denglu)
    public void onViewClicked() {
        //调用p登录去
        Presenter presenter = new Presenter();
        presenter.regPresenter(new MyModel(presenter),this);

    }
//注册成功
    @Override
    public void register() {
        Log.d("bbb", "注册成功 --- 请登录");
        Toast.makeText(this, "注册成功 --- 请登录", Toast.LENGTH_SHORT).show();
    }
//注册失败
    @Override
    public void regError(String error) {
        Toast.makeText(RegActivity.this, "--" + error, Toast.LENGTH_SHORT).show();
    }
//获得姓名
    @Override
    public String getMobile() {
        return reg_EditName.getText().toString();
    }
//获得密码
    @Override
    public String getPassword() {
        return reg_EditPass.getText().toString();
    }
}
