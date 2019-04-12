package com.demo.springboot.config;

import com.demo.springboot.aspect.LogAspects;
import com.demo.springboot.common.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/12
 * @time 14:08
 */
@Configuration
@EnableAspectJAutoProxy
/**开启基于注解的aop模式*/
public class AspectJConfig {

    @Bean
    public MathCalculator mathCalculator(){
        return  new MathCalculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
