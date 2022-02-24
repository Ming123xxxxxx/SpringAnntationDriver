package bean;

import org.springframework.stereotype.Component;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/17 10:32
 */
@Component
public class Car {

    public Car(){
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car init...");
    }

    public void destory(){
        System.out.println("car destory...");
    }

}
