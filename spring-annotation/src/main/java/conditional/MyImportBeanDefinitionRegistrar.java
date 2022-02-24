package conditional;

import bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/16 10:44
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    //AnnotationMetadata:当前类的注解信息
    //BeanDefinitionRegistry:BeanDefinition注册类;
    //把所有需要添加到容器中的bean:调用BeanDefinitionRegistry.registerBeanDefinition手动注册进来
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //如果容器中的组件包含dao.bookDao和service.bookService则给RainBow注册一个组件.组件名为rainBow
        if(registry.containsBeanDefinition("dao.BookDao")&&registry.containsBeanDefinition("service.BookService")){
            //指定Bean定义信息(bean的类型)
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //手动注册一个指定的bean和bean名
            registry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }

}
