package com.demo.springboot.controller.test;

import com.demo.springboot.pojo.vo.FavorateSqlVO;
import com.demo.springboot.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/13
 * @time 10:30
 */
@RestController
@RequestMapping(value = "/jdbc")
public class JdbcDemoController {
    @Autowired
    SqlService sqlService;

    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public ResponseEntity<Boolean> insert(){
        return ResponseEntity.ok(sqlService.insert());
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<List<FavorateSqlVO>> query(){
        return ResponseEntity.ok(sqlService.query());
    }
}
