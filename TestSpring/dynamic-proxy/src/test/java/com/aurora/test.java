package com.aurora;

import com.aurora.service.cglib.GoodService;
import com.aurora.service.cglib.TimeMethodInterceptor;
import com.aurora.service.jdkproxy.OrderService;
import com.aurora.service.jdkproxy.OrderServiceImpl;
import com.aurora.service.jdkproxy.TimerInvocationHandler;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author:Aurora
 * @create: 2023-01-04 21:19
 * @Description:
 */
public class test {
    @Test
    public void test1(){
        OrderService target = new OrderServiceImpl();
        OrderService proxyInstance = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new TimerInvocationHandler(target));
        System.out.println(proxyInstance.buy());
    }
    @Test
    public void test2(){
        Enhancer enhancer = new Enhancer();
        //传递目标类
        enhancer.setSuperclass(GoodService.class);
        //设置方法拦截器
        enhancer.setCallback(new TimeMethodInterceptor());
        GoodService goodServiceProxy = (GoodService) enhancer.create();
        goodServiceProxy.ask();
    }
}
