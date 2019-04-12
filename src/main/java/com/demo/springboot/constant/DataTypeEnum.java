package com.demo.springboot.constant;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/12
 * @time 10:26
 */
@Getter
public enum DataTypeEnum {

    /**byte类型*/
    BYTE("byte","Byte","java.lang.Byte"),

    /**short类型*/
    SHORT("short","Short","java.lang.Short"),

    /**int类型*/
    INTEGER("int","Integer","java.lang.Integer"),

    /**long类型*/
    LONG("long","Long","java.lang.Long"),

    /**float类型*/
    FLOAT("float","Float","java.lang.Float"),

    /**double类型*/
    DOUBLE("double","Double","java.lang.Double"),

    /**boolean类型*/
    BOOLEAN("boolean","Boolean","java.lang.Boolean"),

    /**char类型*/
    CHARACTER("char","Character","java.lang.Character"),

    /**void类型*/
    VOID("void","Void","java.lang.Void");

    private String basicType;
    private String packageType;
    private String fullClassPath;

    public static final Map<String,DataTypeEnum> basicMap = new HashMap();

    DataTypeEnum(String basicType,String packageType,String fullClassPath){
        this.basicType = basicType;
        this.packageType = packageType;
        this.fullClassPath = fullClassPath;
    }

    static {
        DataTypeEnum[] allTypes = values();
        for(DataTypeEnum type : allTypes){
            basicMap.put(type.basicType,type);
        }
    }

}
