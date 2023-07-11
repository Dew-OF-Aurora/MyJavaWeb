package org.aurora.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:Aurora
 * @create: 2023-05-31 15:36
 * @Description: 三部曲, 一个交换机绑定了2个队列
 */
@Configuration
public class RabbitConfig {

    //注入扇形交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("exchange.fanout");
    }

    //定义队列
    @Bean
    public Queue queueA(){
        return new Queue("queue.fanout.a");
    }
    @Bean
    public Queue queueB(){
        return new Queue("queue.fanout.b");
    }

    //绑定交换机和队列,形参名必须和注入bean名一致,一个交换机对应2个队列
    @Bean
    public Binding bindingA(FanoutExchange fanoutExchange,Queue queueA){
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }
    @Bean
    public Binding bindingB(FanoutExchange fanoutExchange,Queue queueB){
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }

}
