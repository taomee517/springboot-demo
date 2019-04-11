package com.demo.springboot.test;

import com.demo.springboot.annotation.pojo.*;
import com.demo.springboot.config.LifecycleConfig;
import com.demo.springboot.util.SpringContextUtil;
import com.demo.springboot.util.SpringEnvUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Spring boot测试类
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\4\10 0010 21:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {

    @Resource
    DatabaseInfo database;

    @Autowired
    Horse horse;

    @Test
    public void databaseIoc(){
        System.out.println(database);
        System.out.println(horse);
    }

    @Test
    public void lifecycleShow(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        log.info("容器创建完成！");
        Monkey miki = context.getBean(Monkey.class);
        log.info("从容器中取出一只猴子:" + miki.getNickName());
        context.registerShutdownHook();
        log.info("现在关闭容器！");
    }

    @Test
    public void getBean(){
        Horse horse = (Horse) SpringContextUtil.getBean("horse");
        System.out.println(horse);

        MysqlInfo mysql = SpringContextUtil.getBean(MysqlInfo.class);
        System.out.println(mysql);

        System.out.println("当前的配置环境是：" + SpringEnvUtil.getProfileType());
    }
}
