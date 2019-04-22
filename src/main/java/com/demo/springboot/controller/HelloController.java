package com.demo.springboot.controller;

import com.demo.springboot.annotation.pojo.DatabaseInfo;
import com.demo.springboot.annotation.pojo.Horse;
import com.demo.springboot.config.EnvConfig;
import com.demo.springboot.util.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Hello World!
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\4\9 0009 20:58
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello,World!";
    }

    @RequestMapping(value = "/dbInfo",method = RequestMethod.GET)
    public DatabaseInfo getDatabaseInfo(){
        ApplicationContext context = new AnnotationConfigApplicationContext(EnvConfig.class);
        DatabaseInfo info = context.getBean(DatabaseInfo.class);
        return info;
    }

    @RequestMapping(value = "/horse",method = RequestMethod.GET)
    public Horse getHorse(){
        return SpringContextUtil.getBean(Horse.class);
    }

    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String demo(Map<String,Object> map){
        map.put("text","<h3>ThemeLeaf语法测试之th:text/th:utext</h3>");
        List<String> users = Arrays.asList("Jackson","Lincoln","Bush");
        map.put("users",users);
        return "demo";
    }

    @RequestMapping(value = {"/","/index.html"},method = RequestMethod.GET)
    public String index(){
        return "login_origin";
    }


}
