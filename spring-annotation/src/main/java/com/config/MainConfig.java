package com.config;

import bean.Person;
import org.springframework.context.annotation.*;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/14 12:15
 */
//配置类==配置文件
@Configuration//告诉Spring这是一个配置类

//@ComponentScan的value:指定要扫描的包,若不写则默认扫描全部,
//扫描一个包:value="controller"
//扫描多个包:value={"controller","service","dao"}
//excludeFilters = Filter[]:指定扫描的时候按照扫描规则排除那些组件
//includeFilters = Filter[]:扫描的时候只包含哪些组件,使用此注解时，需要将userDefaultFilters设置为false
//@ComponentScan(
//        value={"controller","service","dao"},
//        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class})},
////        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class, Service.class})},
//        useDefaultFilters = false)

//可以使用@ComponentScans来定义多个@ComponentScan规则
@ComponentScans(
        value = {
                @ComponentScan(
                        value={"controller","service","dao"},
                        includeFilters = {
                                                        //FilterType.ANNOTATION:根据注解扫描
//                                          @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class})
                                                        //FilterType.ASSIGNABLE_TYPE:按照给定的类型扫描
//                                         ,@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
                                                        //FilterType.CUSTOM:自定义扫描规则
                                         @ComponentScan.Filter(type = FilterType.CUSTOM,classes ={MyTypeFilter.class} )
                        },

                        useDefaultFilters = false)
        }
)
public class MainConfig {

    //@Bean:给容器中注册一个bean,类型为返回值的类型,id默认是用方法名作为id
    //默认person类型的组件在ioc容器中的名字为方法名，若要指定名字,则可以在@Bean中输出指定的名字
    @Bean("person1")
    public Person person(){
        return new Person("李四",20);
    }
}
