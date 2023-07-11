package org.aurora;

import lombok.extern.slf4j.Slf4j;
import org.aurora.service.MessageSendService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author:Aurora
 * @create: 2023-05-29 23:42
 * @Description:
 */
@SpringBootApplication
@Slf4j
public class Fanout implements ApplicationRunner {

    @Resource
    private MessageSendService messageSendService;

    public static void main(String[] args) {
        SpringApplication.run(Fanout.class,args);
    }

    //程序启动后运行
    @Override
    public void run(ApplicationArguments args) throws Exception {
        messageSendService.sendMsg();
    }
}
