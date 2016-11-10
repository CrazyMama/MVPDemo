package com.lu.demo.mvpdemo.biz;

import com.lu.demo.mvpdemo.bean.User;

/**
 * Created by L on 16/11/10.
 */
public interface OnLoginListener {

    void loginsuccess(User user);
    void loginFialed();
}
