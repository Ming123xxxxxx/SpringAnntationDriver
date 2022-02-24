package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/21 12:35
 */
//默认加在IOC容器中的组件,容器启动会调用无参构造器创建对象,再进行初始化赋值等操作
@Component
public class Boss {

//    @Autowired
    private Car car;

    public Car getCar() {
        return car;
    }

    //标注在构造器上,构造器要用的组件,都是从容器中获取
    //@Autowired
    //标注在参数上
    public Boss(
            //@Autowired
                        Car car){
        this.car=car;
        System.out.println("Boss有参构造");
    }

    //标注在方法上,spring容器创建当前对象，就会调用方法,完成赋值
    //方法使用的参数,自定义类型的值从IOC容器中获取
    //@Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
