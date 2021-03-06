package com.demo.springboot.config;

import com.demo.springboot.aspect.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * WebMvc配置，指定登录页访问路径
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\4\22 0022 22:40
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login_temp");
        registry.addViewController("/index.html").setViewName("login_temp");
        registry.addViewController("/dashboard.html").setViewName("/user/dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**.html")
                .excludePathPatterns("/index.html","/login_temp.html","/");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    public class MyLocaleResolver implements LocaleResolver{
        @Override
        public Locale resolveLocale(HttpServletRequest httpServletRequest) {
            String l = httpServletRequest.getParameter("l");
            Locale locale = Locale.getDefault();
            if(!StringUtils.isEmpty(l)){
                String[] localInfo = l.split("_");
                //locale[0] 语言信息 locale[1] 国家信息
                locale = new Locale(localInfo[0],localInfo[1]);
            }
            return locale;
        }

        @Override
        public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

        }
    }


}
