package com.aurora;

import com.aurora.pojo.User;
import com.aurora.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.aurora")
//@SpringBootApplication
public class Application implements ApplicationRunner {

    @Autowired
    private User user;

    @Autowired
    private HelloService helloService;

    public static void main(String[] args) {
        // SpringApplication.run(Application.class);
        // 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(Application.class);

        // 测试 输出所有组件名称
        String[] beanDefinitionNames = run.getBeanDefinitionNames();

        // 测试@import
        // User user = run.getBean("com.aurora.pojo.User", User.class);
        // System.out.println(user);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(user);
        System.out.println("321231231231");

        System.out.println(helloService.sayHello());
    }
}
