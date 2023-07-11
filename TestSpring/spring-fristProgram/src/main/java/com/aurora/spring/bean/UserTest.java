package com.aurora.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author:Aurora
 * @create: 2022-12-30 11:45
 * @Description:
 */
public class UserTest implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean, BeanPostProcessor {
    private String str;
    public UserTest(){
        //第一步,无参构造函数构建
    }
    public void setStr(String str) {
        this.str = str;
        //第二步,为属性赋值
    }
    @Override
    public void setBeanName(String name) {
        //Aware第三步,获取bean名
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //Aware第三步
    }
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        //Aware第三步
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //第四步,bean后处理器的before
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        //Initializing第五步
    }
    // 这个方法需要自己写，自己配。方法名随意。
    public void initBean(){
        //第六步初始化bin
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //第七步,bean后处理器的After
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
    //第八步,调用bean
    @Override
    public void destroy() throws Exception {
        //Disposable的第九步,销毁之前
    }
    public void destroyBean(){
        //第十步,销毁
    }
}
