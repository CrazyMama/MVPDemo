package com.lu.demo.mvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lu.demo.mvpdemo.bean.User;
import com.lu.demo.mvpdemo.presenter.UserLoginPresenter;
import com.lu.demo.mvpdemo.view.IUserLoginView;



public class MainActivity extends Activity implements IUserLoginView {
    
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnClear;
    private Button mBtnLogin;
    private ProgressBar mPbLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        initView();


    }

    private void initView() {

        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);

        mBtnClear = (Button) findViewById(R.id.bt_clear);
        mBtnLogin = (Button) findViewById(R.id.bt_login);

        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);


        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassWord() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_LONG).show();
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString().trim();
    }

    @Override
    public String getPassWord() {

        return mEtPassword.getText().toString().trim();
    }
}
