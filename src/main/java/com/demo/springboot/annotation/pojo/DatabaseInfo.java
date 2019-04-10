package com.demo.springboot.annotation.pojo;

import lombok.Data;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/10
 * @time 15:14
 */
@Data
public class DatabaseInfo {
    private String host;
    private Integer port;
    private String password;

    public DatabaseInfo() {
    }

    public DatabaseInfo(String host, Integer port, String password) {
        this.host = host;
        this.port = port;
        this.password = password;
    }
}
