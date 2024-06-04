package com.aurora.spring.test;

import com.aurora.spring.bean.User;
import com.aurora.spring.service.CustomerService;
import com.aurora.spring.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FirstTest {
    @Test
    public void test1(){
        //从类路径下加载,启动spring,实例化创建对象
        //通过反射,调用无参数构造方法构造Bean
        //Class<?> aClass = Class.forName("com.aurora.spring.bean.User");
        //Object o = aClass.newInstance();
        //底层IoC实现方式:XML解析+工厂模式+反射机制
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //从绝对路径中加载
        //ApplicationContext applicationContext = new FileSystemXmlApplicationContext("");
        //使用Map<String,Object>存储bean
        User userBean = applicationContext.getBean("userBean",User.class);
        System.out.println(userBean);
        userBean.insert();
    }
    @Test
    public void test2(){
        //使用slf4j创建日志
        Logger logger = LoggerFactory.getLogger(FirstTest.class);
        logger.debug("我是一个debug");

    }
    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userServiceBean = applicationContext.getBean("userServiceBean", UserService.class);
        userServiceBean.saveUser();
    }
    @Test
    public void test4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        customerService.insert();
    }
}
