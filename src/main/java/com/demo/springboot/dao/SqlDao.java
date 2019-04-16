package com.demo.springboot.dao;

import com.demo.springboot.pojo.po.FavorateSqlPO;
import com.demo.springboot.pojo.vo.FavorateSqlVO;
import com.demo.springboot.service.SqlService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/13
 * @time 10:03
 */
@Service
public class SqlDao implements SqlService {

    @Autowired
    /**jdbcTemplate在JdbcTemplateAutoConfiguration类中被自动注入
     * datasource对象DataSourceConfiguration.Generic类中被自动注入
     * springboot配置文件的属性被封装到DataSourceProperties类中
     */
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Boolean insert(){
        FavorateSqlPO po = new FavorateSqlPO();
        po.setAdddate(new Date());
        po.setSqlText("select * from favoriatesql");
        po.setDatabaseName("db_terminal");
        po.setName("测试语句");
        String sql = "insert into favoriatesql (database_name,adddate,sql_text) values (?,?,?)";
        int count = jdbcTemplate.update(sql,po.getDatabaseName(),po.getAdddate(),po.getSqlText());
        int a = 1/0;
        return count > 0;
    }

    @Override
    public List<FavorateSqlVO> query(){
        String sql = "select * from favoriatesql";
        /**需要BeanPropertyRowMapper对象对单行数据记录与对象属性进行转换*/
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper(FavorateSqlVO.class));
    }
}
