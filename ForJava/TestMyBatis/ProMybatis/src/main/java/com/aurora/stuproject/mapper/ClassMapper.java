package com.aurora.stuproject.mapper;

import com.aurora.stuproject.pojo.Class;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {

    Class selectByIdStep2(@Param("cid") Integer id);
    Class selectByCollection(@Param("cid")Integer id);

    Class selectByCidStep1(@Param("cid")Integer id);
}
