package com.controller;

import com.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/26 12:32
 */
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(){
        String tomcat = helloService.sayHello("tomcat");
        return tomcat;
    }

    //从/WEB-INF/views/下拿取success.jsp
    @RequestMapping("/suc")
    public String success(){
        return "success";
    }
}
