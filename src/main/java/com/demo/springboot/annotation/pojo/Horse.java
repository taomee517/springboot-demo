package com.demo.springboot.annotation.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 17:30
 */
@Data
@Component
public class Horse {
    @Value("${horse.nickName}")
    private String nickName;

    @Value("${horse.owner}")
    private String owner;
}
