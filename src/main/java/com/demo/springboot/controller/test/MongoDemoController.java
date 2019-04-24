package com.demo.springboot.controller.test;

import com.demo.springboot.pojo.po.MongoPersonPO;
import com.demo.springboot.pojo.vo.MongoPersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/16
 * @time 10:00
 */
@RestController
@RequestMapping(value = "/mongo")
public class MongoDemoController {

    @Autowired
    /**MongoTemplate在MongoDataAutoConfiguration配置中被自动注入
     * springboot配置文件的属性被封装到MongoProperties类中
     */
    MongoTemplate mongoTemplate;

    @GetMapping(value = "/insert")
    public ResponseEntity<Boolean> insert(){
        MongoPersonPO person = new MongoPersonPO();
        person.setAge(30);
        person.setNickName("Nick");
        person.setPosition("Engineer");
        Boolean result = (mongoTemplate.insert(person)!=null);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/query")
    public ResponseEntity<List<MongoPersonVO>> query(){
        List<MongoPersonVO> vos = new ArrayList<>();
        /**collectionName可以通过find方法传入参数，
         * 也可以在映射的实体类上添加@Document(collection = "mongo_person")注解来指定
         */
//        String collectionName = "mongo_person";
//        return ResponseEntity.ok(mongoTemplate.find(new Query(),MongoPersonVO.class,collectionName));
        return ResponseEntity.ok(mongoTemplate.find(new Query(),MongoPersonVO.class));
    }


}
