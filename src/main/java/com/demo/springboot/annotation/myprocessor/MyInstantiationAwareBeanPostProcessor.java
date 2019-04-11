package com.demo.springboot.annotation.myprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 16:41
 */
@Slf4j
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        log.info("这是MyInstantiationAwareBeanPostProcessor实现类构造器！！");
    }

    // 接口方法、实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass,String beanName) throws BeansException {
        log.info("MyInstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
        return null;
    }

    // 接口方法、实例化Bean之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("MyInstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
        return bean;
    }
}