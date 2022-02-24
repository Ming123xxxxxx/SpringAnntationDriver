package com.config;

import bean.MyFactoryBean;
import bean.Person;
import conditional.LinuxCondition;
import conditional.MyImportBeanDefinitionRegistrar;
import conditional.MyImportSelector;
import conditional.WindowCondition;
import dao.BookDao;
import org.springframework.context.annotation.*;
import service.BookService;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/15 11:38
 */
@Configuration
/*
 * 给容器中注册组件:
 * 1.给自己写的类注册组件(包扫描+组件标注注解):@Controller、@Service、@Repository、@Component
 * 2.导入第三方包里面的组件:@Bean
 * 3.快速给容器导入一个组件:@Import
 *    (1)@Import(要导入到容器中的组件);容器中就会自动注册该组件,组件名默认为全类名
 *    (2)ImportSelector:返回需要导入的组件的全类名数组
 *    (3)ImportBeanDefinitionRegister:手动注册bean动容器中
 * 4.使用Spring提供的FactoryBean(工厂Bean)
 *    (1)默认获取到的是工厂bean调用getObject()创建并返回的对象
 *    (2)要获取工厂bean本身,需要在bean的名字前加个&,如"&myFactoryBean"
 * */
//导入一个组件
//@Import(BookDao.class)
//导入多个组件
@Import({BookDao.class, BookService.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfigTwo {

    //默认是单实例的
    @Bean("person")
    //prototype:多实例的,IOC容器启动并不会去调用方法创建对象放在容器中，每次获取的时候才会调用方法创建对象
    //singleton:单实例的(默认值),IOC容器启动会调用方法创建对象放到IOC容器中,以后没戳去就是直接从容器(map.get())中拿
    //request:同一次请求创建一个实例
    //session:痛一个session创建一个实例
    @Scope("singleton")
    //懒加载:必须在单实例下使用
    //单实例bean:默认在容器启动时创建对象
    //懒加载:容器启动不创建对象,第一次使用(获取)Bean创建对象,并初始化
    @Lazy
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("黄忠",70);
    }


    //@Conditional:可以使用在方法或者类上面
    //@Conditional:若放在类上,则必须满足@Conditional的条件,这个类中配置的所有bean注册才会生效
    //@Conditional:若放在方法上,则必须满足@Conditional的条件,这个方法的bean注册才会生效
    //@Conditional:括号中传入的是一个Condition数组
    //@Conditional:按照一定的条件进行判断,满足条件给容器中注册bean
    @Conditional({WindowCondition.class})
    @Bean("Gates")
    public Person person1(){
           return new Person("Gates",50);
    }

    @Conditional({LinuxCondition.class})
    @Bean("Linus")
    public Person person2(){
           return new Person("Linus",60);
    }

    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }
}
