package com.demo.springboot.config;

import com.demo.springboot.annotation.myannotations.MyImportBeanDefinitionRegistrar;
import com.demo.springboot.annotation.myannotations.MyImportSelector;
import com.demo.springboot.annotation.pojo.Person;
import com.demo.springboot.annotation.pojo.Pet;
import com.demo.springboot.annotation.myannotations.MyTypeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/10
 * @time 15:23
 */
@Slf4j
@Configuration
@Import(value = {Pet.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@ComponentScan(value = "com.demo",includeFilters =
    @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class),useDefaultFilters = false)
//    @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class))
public class AnnotationConfig {


    /** @Lazy 是在第一次获取时，创建对象,以后获取就不需要创建了，直接从容器中获取，因为它是单实例*/
    @Lazy
    @Bean(value = "configPerson")
    public Person person(){
        log.info("创建person对象！");
       return new Person("tt",28);
    }
}
