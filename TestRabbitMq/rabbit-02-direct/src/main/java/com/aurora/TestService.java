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
        Message msg = MessageBuilder.withBody("这是direct交换".getBytes()).build();
        //发送key为info
        rabbitTemplate.convertAndSend("exchange.direct.normal","info",msg);
        log.info("发送成功");
    }

    @RabbitListener(queues = "queue.direct.normal")
    public void getMsg(Message message, Channel channel) throws IOException {
        //获取消息属性
        MessageProperties messageProperties = message.getMessageProperties();
        //获取消息的唯一标识
        long deliveryTag = messageProperties.getDeliveryTag();
        try {
            byte[] body = message.getBody();
            log.info("接受到的消息:{}", new String(body));
            //模拟异常
            int a = 1/0;
            //手动确认，并且false表示只确认一条
            channel.basicAck(deliveryTag,false);
        }catch (Exception e){
            log.info("接受失败----{}",e.getMessage());
            //void basicNack(long deliveryTag, boolean multiple, boolean requeue)
            channel.basicNack(deliveryTag,false,false);

            //void basicReject(long deliveryTag, boolean requeue)
            channel.basicReject(deliveryTag,false);
            throw new RuntimeException(e);
        }
    }
}
