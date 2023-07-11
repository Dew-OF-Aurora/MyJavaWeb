package com.aurora.service.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author:Aurora
 * @create: 2023-01-04 21:25
 * @Description:
 */
public class TimerInvocationHandler implements InvocationHandler {

    private Object target;
    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法的四要素
        System.out.println("动态代理代码执行..");
        return method.invoke(target, args);
    }
}
