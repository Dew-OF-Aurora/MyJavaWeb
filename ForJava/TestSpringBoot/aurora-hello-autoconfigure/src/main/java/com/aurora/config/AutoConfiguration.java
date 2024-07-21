package com.aurora.config;

import com.aurora.bean.HelloProperties;
import com.aurora.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({HelloProperties.class})
@ConditionalOnMissingBean(HelloService.class)
public class AutoConfiguration {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
