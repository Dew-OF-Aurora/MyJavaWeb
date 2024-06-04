package com.aurora.service.impl;

import com.aurora.mapper.UserMapper;
import com.aurora.pojo.User;
import com.aurora.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Aurora
 * @create: 2023-02-04 23:21
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUserPage(Integer startRows) {
        return userMapper.queryUserPage(startRows);
    }

    @Override
    public List<User> selectUserPage(String userName, String userSex, Integer startRows) {
        return userMapper.selectUserPage(userName,userSex,startRows);
    }

    @Override
    public Integer getRowCount(String userName, String userSex) {
        return userMapper.getRowCount(userName,userSex);
    }

    @Override
    public Integer createUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer deleteUserById(String userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public Integer deleteUserByIdList(List userIds) {
        return userMapper.deleteUserByIdList(userIds);
    }

    @Override
    public Integer updateUserById(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
