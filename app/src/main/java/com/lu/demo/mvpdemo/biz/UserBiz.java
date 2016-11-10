package com.lu.demo.mvpdemo.biz;

import com.lu.demo.mvpdemo.bean.User;

/**
 * Created by L on 16/11/10.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登陆成功

                if ("lu".equals(username)&&"123".equals(password)){
                    User user= new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginsuccess(user);

                }else {
                    loginListener.loginFialed();
                }

            }
        }.start(


        );
    }
}
