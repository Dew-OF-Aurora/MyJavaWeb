package com.aurora.spring.factorybean;

import com.aurora.spring.bean.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author:Aurora
 * @create: 2022-12-30 09:36
 * @Description:
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
