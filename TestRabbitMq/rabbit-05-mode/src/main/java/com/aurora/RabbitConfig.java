package com.aurora;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Aurora
 * @create: 2023-06-02 09:26
 * @Description:
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "my")
@Slf4j
public class RabbitConfig{

    private String ExChangNormal;
    private String queueNormal;

    //创建交换机
    @Bean
    public DirectExchange ExChangNormal(){
        return ExchangeBuilder.directExchange(ExChangNormal).build();
    }
    @Bean
    public Queue queueNormal(){
        return QueueBuilder.durable(queueNormal).build();
    }
    //建立连接
    @Bean
    public Binding binding(DirectExchange ExChangNormal,Queue queueNormal){
        return BindingBuilder.bind(queueNormal).to(ExChangNormal).with("info");
    }

    //手动装配
    //@Bean
    //public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    //    RabbitTemplate template = new RabbitTemplate(connectionFactory);
    //    template.setConfirmCallback(new RabbitConfig());
    //    return template;
    //}

    //@Override
    //public void confirm(CorrelationData correlationData, boolean ack, String cause) {
    //    //这里的ack是交换机回复的
    //    log.info("关连ID：{}",correlationData.getId());
    //    if (ack){
    //        log.info("消息正确到达交换机");
    //        return;
    //    }
    //    log.error("消息没有到达交换机 cause:{}",cause);
    //}
}
