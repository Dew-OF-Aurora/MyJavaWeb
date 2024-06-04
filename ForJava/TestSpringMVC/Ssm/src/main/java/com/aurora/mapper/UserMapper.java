package com.aurora.mapper;

import com.aurora.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User row);

    User selectByPrimaryKey(String userId);

    List<User> selectAll();

    int updateByPrimaryKey(User row);

    /**
     * 分页查询 User
     * @param startRows 起始页
     * @return List<User>
     */
    List<User> queryUserPage(Integer startRows);

    /**
     * 分页查询 User 带条件
     * @param userName
     * @param userSex
     * @param startRows
     * @return
     */
    List<User> selectUserPage(
            @Param("userName")String userName,
            @Param("userSex")String userSex,
            @Param("startRows")Integer startRows);

    /**
     * 查询 User 个数
     * @param userName
     * @param userSex
     * @return
     */
    Integer getRowCount(
            @Param("userName")String userName,
            @Param("userSex")String userSex);


    Integer deleteUserByIdList(@Param("list") List userIds);
}