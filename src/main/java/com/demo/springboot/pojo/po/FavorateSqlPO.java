package com.demo.springboot.pojo.po;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.util.Date;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/13
 * @time 10:07
 */
@Data
public class FavorateSqlPO{
    /**主键id*/
    private Integer id;

    /**数据库名称*/
    private String databaseName;

    /**添加时间*/
    private Date adddate;

    /**描述*/
    private String name;

    /**sql语句*/
    private String sqlText;
}
