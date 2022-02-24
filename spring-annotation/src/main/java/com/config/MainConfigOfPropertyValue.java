package com.config;

import bean.Human;
import bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/19 10:26
 */
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中
//加载完外部的配置文件以后使用${}去除配置文件中的值
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValue {

    @Bean
    public Person person(){
        return new Person();
    }

    @Bean
    public Human human(){
        return new Human();
    }
}
