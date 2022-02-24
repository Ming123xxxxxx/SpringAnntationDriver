package com.config;

import bean.Car;
import bean.InitAndDestoryBean;
import bean.Jsr;
import bean.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/17 10:23
 */

//bean的生命周期:bean的创建-->初始化-->销毁的过程
    //1.容器管理bean的生命周期
    //2.可以自定义初始化和销毁方法,容器在bean进行到当前生命周期的时候来调用自定义的初始化和销毁的方法
    //
    //构造器(对象创建):
    //(1)单实例:在容器启动的时候创建对象
    //(2)多实例:在每次获取的时候创建对象
    //
    //初始化:对象创建完成,并赋值好,调用初始化方法
    //销毁:
    //    (1)单实例:容器关闭的时候
    //    (2)多实例:容器不会管理这个bean,容器不会调用销毁方法
    //
    //指定初始化的方法:
    //1.在配置文件中指定init-method和destroy-method的方法
    //2.在@Bean注解中指示init-method和destroy-method的方法
    //3.通过让Bean实现InitializingBean(定义初始化逻辑),DisposableBean(定义销毁逻辑)
    //4.可以使用JSR250中的注解:
                 //(a)@PostConstruct:在bean创建完成并且属性赋值完成,来执行初始化方法
                 //(b)@PreDestroy:在容器销毁bean之前通知我们来进行清理工作
    //5.BeanPostProcessor:bean的后置处理器，在bean的初始化前后进行一些处理工作
                 //(a)postProcessBeforeInitialization:在初始化之前工作
                 //(b)postProcessAfterInitialization:在初始化之后工作
    //
@Configuration
public class MainConfigIfLifeCycle {

//    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }

    @Bean
    public InitAndDestoryBean initAndDestoryBean(){
        return new InitAndDestoryBean();
    }

    @Bean
    public Jsr jsr(){
        return new Jsr();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

}
