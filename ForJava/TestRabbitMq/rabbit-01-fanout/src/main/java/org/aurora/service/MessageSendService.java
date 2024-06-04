package org.aurora.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author:Aurora
 * @create: 2023-05-31 15:50
 * @Description:
 */
@Component
@Slf4j
public class MessageSendService {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(){
        Message message = new Message("hello world".getBytes());
        rabbitTemplate.convertAndSend("exchange.fanout","",message);
        log.info("消息发送完毕----{}",new Date());
    }
}
