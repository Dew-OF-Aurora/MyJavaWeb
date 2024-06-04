package com.powernode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class MessageService {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMsg() {
        {
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setHeader("x-delay",25000);//第一条消息 延迟时间
            //messageProperties.setExpiration("25000"); 不要用这个
            Message message = MessageBuilder.withBody("hello world 1".getBytes())
                    .andProperties(messageProperties)
                    .build();
            rabbitTemplate.convertAndSend("exchange.delay.4", "plugin", message);
            log.info("消息发送完毕，发送时间为：{}", new Date());
        }
        {
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setHeader("x-delay",15000);//第二条消息 延迟时间
            //messageProperties.setExpiration("15000"); 不要用这个
            Message message = MessageBuilder.withBody("hello world 2".getBytes())
                    .andProperties(messageProperties)
                    .build();
            rabbitTemplate.convertAndSend("exchange.delay.4", "plugin", message);
            log.info("消息发送完毕，发送时间为：{}", new Date());
        }
    }
}
