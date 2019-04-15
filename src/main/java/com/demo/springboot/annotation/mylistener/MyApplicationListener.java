package com.demo.springboot.annotation.mylistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/15
 * @time 10:37
 */
@Component
@Slf4j
public class MyApplicationListener  implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("接收到一条消息：" + event);
    }
}
