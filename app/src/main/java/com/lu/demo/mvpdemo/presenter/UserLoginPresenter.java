package com.lu.demo.mvpdemo.presenter;

import android.os.Handler;

import com.lu.demo.mvpdemo.bean.User;
import com.lu.demo.mvpdemo.biz.IUserBiz;
import com.lu.demo.mvpdemo.biz.OnLoginListener;
import com.lu.demo.mvpdemo.biz.UserBiz;
import com.lu.demo.mvpdemo.view.IUserLoginView;


/**
 * Created by L on 16/11/10.
 */
public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;

    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userBiz = new UserBiz();
        this.userLoginView = userLoginView;


    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassWord(), new OnLoginListener() {
            @Override
            public void loginsuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFialed() {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear() {
        userLoginView.clearPassWord();
        userLoginView.clearUserName();
    }

}
