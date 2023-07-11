package com.aurora;

import lombok.Data;
import org.springframework.amqp.core.*;
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
public class RabbitConfig {

    private String ExChange;
    private String queueNormal;
    private String queueDlx;

    @Bean
    public DirectExchange directExchange(){
        return ExchangeBuilder.directExchange(ExChange).build();
    }
    @Bean
    public Queue queueNormal(){
        return QueueBuilder
                .durable(queueNormal)
                .ttl(25000)
                .deadLetterExchange(ExChange)
                .deadLetterRoutingKey("error")
                .build();
    }
    @Bean
    public Queue queueDlx(){
        return QueueBuilder.durable(queueDlx).build();
    }
    @Bean
    public Binding binding1(DirectExchange directExchange,Queue queueNormal){
        return BindingBuilder.bind(queueNormal).to(directExchange).with("order");
    }
    @Bean
    public Binding binding2(DirectExchange directExchange,Queue queueDlx){
        return BindingBuilder.bind(queueDlx).to(directExchange).with("error");
    }
}
