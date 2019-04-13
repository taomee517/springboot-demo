package com.demo.springboot.service;

import com.demo.springboot.pojo.vo.FavorateSqlVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/13
 * @time 10:22
 */
public interface SqlService {
    /**插入一下sql记录*/
    Boolean insert();

    /**查询所有sql记录*/
    List<FavorateSqlVO> query();
}
