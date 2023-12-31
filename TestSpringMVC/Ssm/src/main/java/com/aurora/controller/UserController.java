package com.aurora.controller;

import com.aurora.pojo.User;
import com.aurora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author:Aurora
 * @create: 2023-02-05 22:08
 * @Description:
 */
//后端支持跨域访问
@CrossOrigin
//声明全体ajax请求,代替每个方法的@ResponeBody
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserPage")
    public List<User> queryUserPage(Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 5;
        int startRows = pageSize*(pageNow-1);
        return userService.queryUserPage(startRows);
    }

    @RequestMapping("/selectUserPage")
    public List<User> selectUserPage(String userName, String userSex, Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 5;
        int startRows = pageSize*(pageNow-1);
        return userService.selectUserPage(userName, userSex, startRows);
    }

    @RequestMapping("/getRowCount")

    public Integer getRowCount(String userName, String userSex) {
        return userService.getRowCount(userName, userSex);
    }

    @RequestMapping("/createUser")

    public Integer createUser(User user) {
        Random random = new Random();
        Integer number = random.nextInt(9000) + 1000;
        user.setUserId(System.currentTimeMillis() + String.valueOf(number));
        return userService.createUser(user);
    }

    @RequestMapping("/deleteUserById")

    public Integer deleteUserById(String userId) {
        return userService.deleteUserById(userId);
    }

    @RequestMapping(value = "/deleteUserByIdList")

    public Integer deleteUserByIdList(String userIdList) {
        String userIdListSub = userIdList.substring(0, userIdList.length()-1);
//        String[] userIds = userIdList.split(",");

        List userIds = new ArrayList();
        for (String userIdStr: userIdListSub.split(",")){
            userIds.add(userIdStr.trim());
        }
        return userService.deleteUserByIdList(userIds);
    }

    @RequestMapping("/updateUserById")

    public Integer updateUserById(User user, Date date) {
        return userService.updateUserById(user);
    }
}

