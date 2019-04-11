package com.demo.springboot.annotation.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 15:25
 * @desc 此类用于验证Bean的生命周期
 */
@Slf4j
public class Monkey implements InitializingBean, DisposableBean, BeanFactoryAware, BeanNameAware{
    private String nickName;
    private BeanFactory beanFactory;
    private String beanName;

    public Monkey(){
        log.info("monkey --> constructor");
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        log.info("monkey --> fieldsSetting");
        this.nickName = nickName;
    }

    public static Logger getLog() {
        return log;
    }

    @PostConstruct
    public void play(){
        log.info("monkey --> postConstruct --> play");
    }

    public void init() {
        log.info("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    public void destroy0(){
        log.info("【destroy-method】调用<bean>的destroy-method属性指定的销毁方法");
    }

    @PreDestroy
    public void dead(){
        log.info("monkey --> preDestroy --> dead");
    }

    @Override
    public void destroy() throws Exception {
        log.info("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        log.info("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = s;
    }
}
