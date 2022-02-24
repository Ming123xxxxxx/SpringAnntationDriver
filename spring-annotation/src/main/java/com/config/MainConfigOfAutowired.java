package com.config;

import bean.Car;
import bean.Factorys;
import dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/19 12:03
 */

/*
*自动装配:Spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖关系赋值
*         (1)Autowired(Spring定义的):自动注入
*                  (a)默认优先按照类型去容器中找对应的组件
*                  (b)如果找到多个相同类型的组件,再将属性的名称作为组件的id去容器中查找
*                  (c)使用@Qualifier指定要装配的组件id，而不是用属性名
*                  (d)自动装配默认一定要将属性赋值好,不然会报错,
*                     不过可以通过 @Autowired(required = false)来使得属性不是一定要赋值，不赋值也不报错
*                  (e)@Primary:让Spring进行自动装配的时候，默认使用首选的bean
*                     也可以及时需用@Qualifier指定需要装配的bean的名字
*         (2)Spring还支持使用@Resource(JSP250)和Inject(JSR330)[这两都是Java规范注解]
*                  (a)@Resource:可以和@Autowired一样实现自动装配功能,默认是按照组件名称进行自动装配的
*                             但是没有支持@Primary功能和类似于@Autowired(required = false)的功能
*                  (b)@Inject:使用此注解需要导入javax.inject依赖,此注解和@Autowired的功能一样
*                             但是没有支持类似于@Autowired(required = false)的功能
*                  (c)@Resource和@Inject由AutowiredAnnotationBeanPostProcessor解析完成自动装配功能
*         (3)@Autowired:(构造器,参数,方法,属性):都是从容器中获取参数组件的值
*                  (a)标注在方法上:@Bean+方法参数,参数从容器中获取;默认不写@Autowired,效果也都是一样的,都是自动装配
*                                spring容器创建当前对象，就会调用方法,完成赋值。方法使用的参数,自定义类型的值从IOC容器中获取
*                  (b)标注在构造器上:如果组件只有一个有参构造器,这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
*                                默认加在IOC容器中的组件,容器启动会调用无参构造器创建对象,再进行初始化赋值等操作
*                  (c)放在参数位置:
*         (4)自定义组件想要使用Spring容器底层的一些组件(ApplicationContext,BeanFactory,xxx);
*                  自定义组件实现xxxAware;在创建对象的时候,会调用接口规定的方法注入相关组件;Aware
*                  把Spring底层一些组件注入到自定义的Bean中
*                  xxxAware的功能时使用xxxProcessor处理的
* */

@Configuration
@ComponentScan({"service","dao","controller","bean"})
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
       BookDao bookDao = new BookDao();
       bookDao.setLable("2");
       return  bookDao;
    }

    //@Bean标注的方法创建对象的时候,方法参数的值从容器中获取
    @Bean
    public Factorys factorys(Car car){
        Factorys factorys = new Factorys();
        factorys.setCar(car);
        return factorys;
    }
}
