package com.demo.springboot.test;

import com.demo.springboot.annotation.pojo.DatabaseInfo;
import com.demo.springboot.annotation.pojo.Monkey;
import com.demo.springboot.config.LifecycleConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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

    @Test
    public void databaseIoc(){
        System.out.println(database);
    }

    @Test
    public void lifecycleShow(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        log.info("容器创建完成！");
        Monkey miki = context.getBean(Monkey.class);
        log.info("从容器中取出一只猴子:" + miki.getNickName());
        context.registerShutdownHook();
    }
}
