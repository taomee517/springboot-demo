package com.demo.springboot.annotation;

import com.demo.springboot.annotation.pojo.Person;
import com.demo.springboot.config.AnnotationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/10
 * @time 15:13
 */
@Slf4j
public class AnnotationConfirmUtil {
    public static void main(String[] args) {
        log.info("从xml文件中获取对象：" + getXmlBean());
        log.info("从配置文件中获取对象: " + getConfigBean());
    }

    public static Person getXmlBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 根据xml文件中的bean id获取
        return (Person)context.getBean("person");
    }

    public static Person getConfigBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        // 可以根据对象名来获取，也可以根据类名来获取
        // Person person01 = context.getBean(Person.class);
        return (Person) context.getBean("configPerson");
    }
}
