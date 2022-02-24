package com.service;

import org.springframework.stereotype.Service;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/26 12:33
 */
@Service
public class HelloService {

    public String sayHello(String name){
        return "Hello"+name;
    }
}
