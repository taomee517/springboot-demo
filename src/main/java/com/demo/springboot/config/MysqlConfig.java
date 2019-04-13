package com.demo.springboot.config;

import com.demo.springboot.annotation.pojo.MysqlInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 18:15
 */
@Configuration
public class MysqlConfig {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Profile(value = "dev")
    @Bean(value = "devMysqlInfo")
    public MysqlInfo mysqlInfo(){
       return new MysqlInfo(url,username,"dev");
    }

    @Profile(value = "local")
    @Bean(value = "localMysqlInfo")
    public MysqlInfo lmysqlInfo(){
        return new MysqlInfo(url,username,"local");
    }
}
