package com.config;

import com.controller.MyFirstInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/26 12:25
 */
//Spring的容器只扫描Controller
//useDefaultFilters:禁用默认的过滤规则
@ComponentScan(value = "com",includeFilters ={
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    //配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //默认所有的页面都从/WEB-INF/xxx.jsp
//        registry.jsp();

        //自定义所有的页面都从/WEB-INF/views/xxx.jsp
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    //静态资源访问
    //相当于xml配置文件中的<mvc:default-servlet-handler/>
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //相当于xml配置文件中的<mvc:interceptors>
        registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
    }
}
