package com.aurora.service.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author:Aurora
 * @create: 2023-01-05 11:27
 * @Description:
 */
public class TimeMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //o是目标对象, objects是参数
        System.out.println("方法拦截器");
        Object retValue = methodProxy.invokeSuper(o, objects);
        return retValue;
    }
}
