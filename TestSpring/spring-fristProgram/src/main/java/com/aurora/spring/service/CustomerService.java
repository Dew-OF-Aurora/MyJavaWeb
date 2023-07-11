package com.aurora.spring.service;

import com.aurora.spring.dao.UserDao;

public class CustomerService {
    private UserDao userDao;

    public CustomerService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insert(){
        userDao.insert();
    }
}
