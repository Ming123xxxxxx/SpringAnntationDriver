package conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/15 12:21
 */
//判断是否为Windows系统
public class WindowCondition implements Condition{
    //ConditionContext:判断条件能使用的上下午(环境)
    //AnnotatedTypeMetadata:注释信息
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        //能获取到IOC使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();

        //获取到类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();

        //能获取到环境信息
        Environment environment = conditionContext.getEnvironment();

        //能获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");

        //可以判断容器中的bean注册情况,也可以给容器中注册bean
        boolean person = registry.containsBeanDefinition("person");

        //判断是否包含windows,是则返回true
        if(property.contains("Windows")){
            return true;
        }

        return false;
    }
}
