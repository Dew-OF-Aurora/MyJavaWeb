package com.aurora.config;

import com.aurora.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:Aurora
 * @create: 2023-06-14 16:10
 * @Description:
 */

/**
 * spring配置类 == xml配置文件
 * spring2.x 更新：
 * proxyBeanMethods：代理bean的方法
 * Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的, spring容器会检查该Bean是否已经在容器中 存在】
 * Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 * 组件依赖必须使用Full模式默认。其他默认是否Lite模式
 * 组件依赖：如果一个UserBean需要使用PetBean创建， 如果使用Full模式，在主程序中User.Pet和IOC容器中的Pet是一致的
 */
//@Import({User.class})
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    //@ConditionalOnBean(name = "user312")
    @Bean
    public User user123() {
        return User.builder().username("张三").age(18).build();
    }
}
