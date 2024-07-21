package com.aurora.service;

import com.aurora.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(){
        return helloProperties.getPrefix() + helloProperties.getSuffix();
    }

}
