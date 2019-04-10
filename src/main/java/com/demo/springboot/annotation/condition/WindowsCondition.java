package com.demo.springboot.annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/10
 * @time 17:00
 */
public class WindowsCondition implements Condition {
    /**
     * @param context 判断条件
     * @param metadata 注释信息
     * @return boolean
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
