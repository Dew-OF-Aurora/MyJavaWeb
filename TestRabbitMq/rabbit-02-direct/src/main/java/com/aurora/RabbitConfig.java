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

    private String ExChangNormal;
    private String ExChangDlx;
    private String queueNormal;
    private String queueDlx;

    //创建交换机
    @Bean
    public DirectExchange ExChangNormal(){
        return ExchangeBuilder.directExchange(ExChangNormal).build();
    }
    @Bean
    public DirectExchange ExChangDlx(){
        return ExchangeBuilder.directExchange(ExChangDlx).build();
    }
    //创建队列
    @Bean
    public Queue queueNormal(){
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange",ExChangDlx);
        //携带的死信路由key
        arguments.put("x-dead-letter-routing-key","error");
        return QueueBuilder.durable(queueNormal)
                .withArguments(arguments)
                .build();
    }
    @Bean
    public Queue queueDlx(){
        return QueueBuilder.durable(queueDlx).build();
    }
    //建立连接
    @Bean
    public Binding bindingA(DirectExchange ExChangNormal,Queue queueNormal){
        return BindingBuilder.bind(queueNormal).to(ExChangNormal).with("info");
    }
    @Bean
    public Binding bindingB(DirectExchange ExChangDlx,Queue queueDlx){
        return BindingBuilder.bind(queueDlx).to(ExChangDlx).with("error");
    }
}
