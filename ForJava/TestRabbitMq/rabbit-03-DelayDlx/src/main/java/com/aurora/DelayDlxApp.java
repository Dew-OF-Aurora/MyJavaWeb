package com.aurora;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author:Aurora
 * @create: 2023-06-02 09:16
 * @Description:
 */
@SpringBootApplication
public class DelayDlxApp implements ApplicationRunner {
    @Resource
    private TestService service;

    public static void main(String[] args) {
        SpringApplication.run(DelayDlxApp.class,args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        service.send();
    }
}
