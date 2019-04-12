package com.demo.springboot.aspect;

import java.lang.annotation.*;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/12
 * @time 9:44
 * @desc 自定义切面注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyPointCut {
    String desc() default "";
}
