package com.demo.springboot.annotation.myprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 16:45
 */
@Slf4j
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        log.info("这是MyBeanFactoryPostProcessor实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
        log.info("MyBeanFactoryPostProcessor调用postProcessBeanFactory方法");
//        BeanDefinition bd = arg0.getBeanDefinition("monkey");
//        bd.getPropertyValues().addPropertyValue("nickName", "Yota");
    }

}