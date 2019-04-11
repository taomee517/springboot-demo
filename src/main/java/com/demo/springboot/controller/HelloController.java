package com.demo.springboot.controller;

import com.demo.springboot.annotation.pojo.DatabaseInfo;
import com.demo.springboot.annotation.pojo.Horse;
import com.demo.springboot.config.AnnotationConfig;
import com.demo.springboot.config.DatabaseConfig;
import com.demo.springboot.util.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello World!
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\4\9 0009 20:58
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello,World!";
    }

    @RequestMapping(value = "/dbInfo",method = RequestMethod.GET)
    public DatabaseInfo getDatabaseInfo(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        DatabaseInfo info = context.getBean(DatabaseInfo.class);
        return info;
    }

    @RequestMapping(value = "/horse",method = RequestMethod.GET)
    public Horse getHorse(){
        return SpringContextUtil.getBean(Horse.class);
    }


}
