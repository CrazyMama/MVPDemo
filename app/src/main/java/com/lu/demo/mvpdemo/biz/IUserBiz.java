package com.lu.demo.mvpdemo.biz;

/**
 * Created by L on 16/11/10.
 */

public interface IUserBiz {
    public void login(String username, String password ,OnLoginListener loginListener);

}
