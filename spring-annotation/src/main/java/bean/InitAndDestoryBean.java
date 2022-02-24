package bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/17 11:19
 */
public class InitAndDestoryBean implements InitializingBean, DisposableBean {

    public InitAndDestoryBean(){
        System.out.println("InitAndDestoryBean  constructor");
    }

    //销毁方法
    public void destroy() throws Exception {
        System.out.println("InitAndDestoryBean  destroy");
    }

    //初始化方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitAndDestoryBean  afterPropertiesSet");
    }
}
