package com.demo.springboot.config;

import com.demo.springboot.annotation.condition.LinuxCondition;
import com.demo.springboot.annotation.condition.WindowsCondition;
import com.demo.springboot.annotation.pojo.DatabaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/10
 * @time 17:02
 */
@Slf4j
@Configuration
public class EnvConfig {

    @Bean(value = "windb")
    @Conditional(value = WindowsCondition.class)
    public DatabaseInfo windowsDatabaseInfo(){
       return new DatabaseInfo("127.0.0.1",3306,"123456");
    }

    @Bean(value = "linuxdb")
    @Conditional(value = LinuxCondition.class)
    public DatabaseInfo linuxDatabaseInfo(){
        return new DatabaseInfo("192.168.6.160",3306,"fastgo123");
    }
}
