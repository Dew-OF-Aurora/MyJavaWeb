package com.aurora;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author:Aurora
 * @create: 2023-06-08 15:22
 * @Description: Confirm回调函数
 */
//@Component
@Slf4j
public class MyConfirmCallBack implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        //这里的ack是交换机回复的
        log.info("关连ID：{}",correlationData.getId());
        if (ack){
            log.info("消息正确到达交换机");
            return;
        }

        log.error("消息没有到达交换机 cause:{}",cause);
    }
}
