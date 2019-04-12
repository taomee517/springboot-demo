package com.demo.springboot.common;

import com.demo.springboot.aspect.MyPointCut;
import lombok.extern.slf4j.Slf4j;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/12
 * @time 9:39
 */
@Slf4j
public class MathCalculator {

    @MyPointCut(desc = "求和方法")
    public int sum(int x, int y){
        log.info("计算{}，{}的和",x,y);
        return x + y;
    }

    @MyPointCut(desc = "求乘积方法")
    public int multiplied(int x, int y){
        log.info("计算{}，{}的积",x,y);
        return x * y;
    }

    @MyPointCut(desc = "求商方法")
    public int div(int x, int y){
        log.info("计算{}，{}的商",x,y);
        return x / y;
    }
}
