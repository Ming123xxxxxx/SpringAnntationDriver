package bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/17 11:34
 */
public class Jsr {

    public Jsr(){
        System.out.println("Jsr constructor");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Jsr init");
    }

    //在容器移除对象之前执行
    @PreDestroy
    public void destroy(){
        System.out.println("Jsr destroy");
    }
}
