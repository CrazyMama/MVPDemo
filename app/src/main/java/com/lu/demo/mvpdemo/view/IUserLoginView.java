package com.lu.demo.mvpdemo.view;

import com.lu.demo.mvpdemo.bean.User;

/**
 * Created by L on 16/11/10.
 */

public interface IUserLoginView {
    void clearUserName();
    void clearPassWord();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
    String getUserName();
    String getPassWord();
}
