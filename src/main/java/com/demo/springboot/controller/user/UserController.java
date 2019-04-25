package com.demo.springboot.controller.user;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户Controller
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\4\24 0024 21:24
 */
@Controller
public class UserController {

    @PostMapping("/user/login")
    public String login(@PathParam("username") String username,
                        @PathParam("password") String password,
                        Map<String,String> map,
                        HttpSession session){
        if("taomee".equals(username)){
            session.setAttribute("user",username);
            map.put("msg","登录成功！");
            return "redirect:/dashboard.html";
        }else {
            map.put("msg","用户名不存在！");
            return "login_temp";
        }


    }
}
