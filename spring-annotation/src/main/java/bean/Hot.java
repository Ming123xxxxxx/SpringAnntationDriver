package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/21 13:28
 */
@Component
public class Hot implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("传入的IOC:"+applicationContext);
        this.applicationContext=applicationContext;
    }

    public void setBeanName(String name){
        System.out.println("当前Bean的名字:"+name);
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String s = stringValueResolver.resolveStringValue("你好${os.name} 我是#{30-21}");

        System.out.println("解析的字符串:"+s);

    }
}
