package com.demo.springboot.config;

import com.demo.springboot.annotation.myprocessor.MyBeanFactoryPostProcessor;
import com.demo.springboot.annotation.myprocessor.MyBeanPostProcessor;
import com.demo.springboot.annotation.myprocessor.MyInstantiationAwareBeanPostProcessor;
import com.demo.springboot.annotation.pojo.Monkey;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 15:24
 * @desc Spring bean的详细生命周期文献：https://www.cnblogs.com/zrtqsk/p/3735273.html
 */
@Configuration
public class LifecycleConfig {

    /**
     * bean的生命周期：bean的创建->初始化->销毁的过程
     * 容器管理bean的生命周期：
     * 我们可以自定义初始化方法和销毁的方法：容器在bean进行到当前的生命周期的时候，来调用我们自定义的初始化方法和销毁方法
     * 构造（对象创建）：
     *      单实例：在容器启动的时候创建对象
     *      多实例：在每次获取的时候来创建对象
     * 初始化方法：
     *      对象创建完成，并赋值好，调用初始化方法
     * 销毁方法：
     *      单实例的bean:在容器关闭的时候进行销毁
     *      多实例的bean:容器不会管理这个bean,容器不会调用销毁的方法
     *
     * 1)指定初始化方法和销毁方法；
     *          -我们可以通过@Bean(initMethod = "init",destroyMethod = "destroy")来指定初始化方法和销毁方法
     *          相当于xml配置文件bean标签里面的 init-method="" 和 destroy-method="" 属性
     *
     *
     *
     */

    @Bean(initMethod = "init",destroyMethod = "destroy0")
    /**ConfigurableBeanFactory.SCOPE_PROTOTYPE 代表多实例
     * ConfigurableBeanFactory.SCOPE_SINGLETON 代表单例
     */
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Monkey monkey(){
        Monkey monkey = new Monkey();
        monkey.setNickName("miki");
        return monkey;
    }

    @Bean
    public BeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public InstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor(){
        return new MyInstantiationAwareBeanPostProcessor();
    }

    @Bean
    public BeanFactoryPostProcessor myBeanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }

}
