package com.aurora.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {
    private final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert(){
        logger.info("数据库插入");
    }
}