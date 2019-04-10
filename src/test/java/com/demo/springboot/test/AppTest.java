package com.demo.springboot.test;

import com.demo.springboot.annotation.pojo.DatabaseInfo;
import com.demo.springboot.annotation.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class AppTest {
    @Autowired
    Person person;

    @Resource
    DatabaseInfo database;

    @Test
    public void personIoc(){
        System.out.println(person);
        System.out.println(database);
    }
}
