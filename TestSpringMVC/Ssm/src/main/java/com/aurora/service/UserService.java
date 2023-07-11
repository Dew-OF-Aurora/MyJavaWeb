package com.aurora.service;

import com.aurora.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    List<User> queryUserPage(Integer startRows);

    List<User> selectUserPage(@Param("userName")String userName, @Param("userSex")String userSex, @Param("startRows")Integer startRows);

    Integer getRowCount(@Param("userName")String userName, @Param("userSex")String userSex);

    Integer createUser(User user);

    Integer deleteUserById(String userId);

    Integer deleteUserByIdList(@Param("list") List userIds);

    Integer updateUserById(User user);
}
