package com.demo.springboot.annotation.pojo;

import lombok.Data;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/10
 * @time 15:14
 */
@Data
public class MysqlInfo {
    private String url;
    private String username;
    private String password;

    public MysqlInfo() {
    }

    public MysqlInfo(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
}
