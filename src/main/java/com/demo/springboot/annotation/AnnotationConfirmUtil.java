package com.demo.springboot.annotation;

import com.demo.springboot.annotation.pojo.Person;
import com.demo.springboot.config.AnnotationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/10
 * @time 15:13
 */
public class AnnotationConfirmUtil {
    public static void main(String[] args) {
        //从xml文件中获取对象
        getXmlBean();
        //从配置文件中获取对象
        getConfigBean();
    }

    public static void getXmlBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 根据xml文件中的bean id获取
        Person person = (Person)context.getBean("person");
        System.out.println("从xml文件中获取对象：");
        System.out.println(person);
    }

    public static void getConfigBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Person person = (Person) context.getBean("configPerson");
        System.out.println("从配置文件中获取对象");
        System.out.println(person);
    }
}
