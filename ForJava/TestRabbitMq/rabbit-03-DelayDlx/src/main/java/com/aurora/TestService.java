package com.aurora;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author:Aurora
 * @create: 2023-06-02 09:38
 * @Description:
 */
@Service
@Slf4j
public class TestService {
    @Resource
    private RabbitTemplate rabbitTemplate;
    public void send(){
        Message msg = MessageBuilder.withBody("这是Dlx实现的延迟队列".getBytes()).build();
        //发送key为info
        rabbitTemplate.convertAndSend("exchange.delay.1","order",msg);
        log.info("发送成功");
    }

    @RabbitListener(queues = "queue.delay.Dlx")
    public void getMsg(Message message, Channel channel) throws IOException {
        byte[] body = message.getBody();
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        log.info("死信 接受到的消息:{}", new String(body));
    }
}
