package com.demo.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * WebMvc配置，指定登录页访问路径
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\4\22 0022 22:40
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login_temp");
        registry.addViewController("/index.html").setViewName("login_temp");
    }

}
