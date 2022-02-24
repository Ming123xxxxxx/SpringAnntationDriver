package bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/16 11:19
 */
public class MyFactoryBean implements FactoryBean<Factorys> {

    //返回一个对象,对象会添加到容器中
    //工厂bean获取的是调用getObject()创建的对象
    public Factorys getObject() throws Exception {
        System.out.println("注册Factorys到容器中---");
        return new Factorys();
    }

    public Class<?> getObjectType() {
        return Factorys.class;
    }

    //是否为单例
    //返回true:bean为单例,在容器中保存一份
    //返回false:bean为多实例,每次获取都会创建一个新的bean
    public boolean isSingleton() {
        return false;
    }
}
