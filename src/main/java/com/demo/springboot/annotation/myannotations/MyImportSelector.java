package com.demo.springboot.annotation.myannotations;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 14:51
 * @desc 根据全类名来导入组件
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.demo.springboot.annotation.pojo.Cat","com.demo.springboot.annotation.pojo.Dog"};
    }
}
