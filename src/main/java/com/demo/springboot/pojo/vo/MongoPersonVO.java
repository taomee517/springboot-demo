package com.demo.springboot.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/13
 * @time 10:07
 */
@Data
@ApiModel("mongo测试视图对象")
@Document(collection = "mongo_person")
public class MongoPersonVO implements Serializable {

    @Id
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("职位")
    private String position;

}
