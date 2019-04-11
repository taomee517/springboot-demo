package com.demo.springboot.annotation.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

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
@Data
public class Monkey implements InitializingBean, DisposableBean {
    String nickName;
    public Monkey(){
        log.info("monkey --> constructor");
    }

    @PostConstruct
    public void play(){
        log.info("monkey --> postConstruct --> play");
    }

    public void init() {
        log.info("monkey --> init");
    }

    @PreDestroy
    public void dead(){
        log.info("monkey --> preDestroy --> dead");
    }

    @Override
    public void destroy() throws Exception {
        log.info("monkey --> destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("monkey --> afterPropertiesSet");
    }
}
