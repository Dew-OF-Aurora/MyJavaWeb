package com.aurora.stuproject.mapper;

import com.aurora.stuproject.pojo.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    void InsertToStudent (@Param("sid") int sid,@Param("sname")String sname, @Param("cid") int cid);

    Student selectById (@Param("sid") Integer id);

    Student selectByIdAssociation(@Param("sid") Integer id);
    Student selectByIdStep1(@Param("sid") Integer id);

    Student selectBySidStep2(@Param("cid") Integer id);

}
