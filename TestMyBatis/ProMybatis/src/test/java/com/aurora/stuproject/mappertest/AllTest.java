package com.aurora.stuproject.mappertest;

import com.aurora.stuproject.mapper.ClassMapper;
import com.aurora.stuproject.mapper.StudentMapper;
import com.aurora.stuproject.pojo.Class;
import com.aurora.stuproject.pojo.Student;
import com.aurora.stuproject.utils.SqlSessionUtil;
import org.junit.Test;

public class AllTest {
    @Test
    public void test1(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        mapper.InsertToStudent(4,"赵六",1001);
        SqlSessionUtil.commit();
    }
    @Test
    public void test2(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        Student student = mapper.selectByIdStep1(1);
        System.out.println(student.getSname());
    }

    @Test
    public void test3(){
        ClassMapper mapper = SqlSessionUtil.openSession().getMapper(ClassMapper.class);
        Class aClass = mapper.selectByCidStep1(1000);
        System.out.println(aClass);
    }
}
