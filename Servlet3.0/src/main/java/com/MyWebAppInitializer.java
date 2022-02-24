package com;

import com.config.AppConfig;
import com.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/26 12:04
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //获取根容器的配置类:(Spring的配置文件) 父容器
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    //获取web容器的配置类(SpringMVC的配置文件) 子容器
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    //获取Dispatcher-Servlet的映射信息
    //   ”/“:拦截所有请求(包括静态资源(xx.js,xx.png)),但是不包括*.jsp
    //   "/*":拦截所有请求,连*.jsp都拦截,jsp页面是tomcat的jsp引擎解析的
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
