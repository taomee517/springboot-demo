package com.demo.springboot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 17:44
 */


@Configuration
/**此处注解不一定非要Configuration,
 * 只要是能被Spring管理的注解就行，如 @Component
 * 它可以在Spring启动过程中被实例化，对Static的IOC容器赋值 *
 */
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.context = applicationContext;
    }

    public static ApplicationContext getContext(){
        return context;
    }

    /** 根据对象名从Spring IOC容器中获取对象
     *
     * @param name 对象名
     * @return Spring IOC容器中管理的对象
     */
    public static Object getBean(String name){
        return context.getBean(name);
    }

    /**根据类名获取对象
     *
     * @param clz 继承T的类名
     * @param <T> Spring IOC容器中管理的对象
     * @return
     */
    public static <T> T getBean(Class<? extends T> clz ){
        return context.getBean(clz);
    }
}
