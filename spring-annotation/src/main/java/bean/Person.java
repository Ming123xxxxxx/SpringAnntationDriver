package bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/14 12:03
 */
public class Person {

    //使用@Value赋值:
    //1.基本数值
    //2.可以写SpEl,#{}
    //3.可以写${},取出配置文件【properties】中的值(在运行的环境变量里的值)

    @Value("张三")
    private String name;
    @Value("#{20-4}")
    private int age;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
