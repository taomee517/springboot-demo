package com.demo.springboot.annotation.myannotations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 15:02
 * @desc 如果某些类没有添加任何注解，我们又想调用，可以手动的将其注册到Spring IOC容器
 */
@Slf4j
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition("com.demo.springboot.annotation.pojo.Pig");
        Boolean containsPet = registry.containsBeanDefinition("com.demo.springboot.annotation.pojo.Pet");
        if(containsPet){
            log.info("通过MyImportBeanDefinitionRegistrar注入对象: pig");
            registry.registerBeanDefinition("pig",beanDefinition);
        }
    }
}
