package com.aurora;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author:Aurora
 * @create: 2023-06-02 09:38
 * @Description:
 */
@Service
@Slf4j
public class TestService{
    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        rabbitTemplate.setReturnsCallback(returned -> {
            log.error("消息未从交换机发送到队列 cause:{}",returned.getReplyText());
        });
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            //这里的ack是交换机回复的
            if (ack){
                log.info("消息正确到达交换机 关连ID：{}",correlationData.getId());
                return;
            }
            log.error("消息没有到达交换机 cause:{}",cause);
        });
    }

    public void send(){
        Message msg = MessageBuilder.withBody("这是Confirm模式".getBytes()).build();

        CorrelationData correlationData = new CorrelationData(); //关联数据
        correlationData.setId("order_12345");
        rabbitTemplate.convertAndSend("exchange.confirm.1","info",msg,correlationData);
        log.info("已发送");
    }

    //@RabbitListener(queues = "queue.direct.normal")
    public void getMsg(Message message, Channel channel) throws IOException{
    }

}
