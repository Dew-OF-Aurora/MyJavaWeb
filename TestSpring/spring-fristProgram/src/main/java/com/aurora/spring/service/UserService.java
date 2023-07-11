package com.aurora.spring.service;

import com.aurora.spring.dao.UserDao;

public class UserService {
    private UserDao userDao;

    //提供一个注入方法,spring调用
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(){
        userDao.insert();
    }
}
