package com.demo.springboot.config;

import com.demo.springboot.annotation.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/10
 * @time 15:23
 */
@Configuration
public class AnnotationConfig {

    @Bean(value = "configPerson")
    public Person person(){
       return new Person("tt",28);
    }
}
