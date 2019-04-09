package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot Demo项目启动类
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\4\9 0009 20:51
 * @Desc
 *     1.创建一个空的Maven项目
 *     2.引入spring boot的相关依赖
 *     3.编写一个Spring Boot主程序,用于启动项目,并填加注解@SpringbootApplication,以示启动程序
 *     4.编写Controller,Service
 *     5.运行启动程序,测试
 *     6.简化布署,添加maven打包插件,默认内置tomcat
 * @详细学习笔记：http://luckyqiang.top/2018/07/10/Spring%20Boot/
 * @J2EE的整体整合解决方案和自动配置都在spring-boot-autoconfigure-1.5.9.RELEASE.jar
 */
@SpringBootApplication
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class,args);
    }
}
