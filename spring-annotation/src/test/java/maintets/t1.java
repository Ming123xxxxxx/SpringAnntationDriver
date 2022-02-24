package maintets;

import bean.*;
import com.config.*;
import controller.BookController;
import dao.BookDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import service.BookService;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/14 12:08
 */
public class t1 {

    //使用配置文件
    @Test
    public void test1(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    //使用配置类
    @Test
    public void test2(){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) applicationContext.getBean(Person.class);
        System.out.println(person);
        //获取Perosn类型的组件在ioc容器中的名字
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String name:beanNamesForType){
            System.out.println(name);
        }
    }

    @Test
    public void IOCtest(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        //可以看到容器中所有bean定义的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
    }

    @Test
    public void IOCtest2(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigTwo.class);
        //可以看到容器中所有bean定义的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
        System.out.println("IOC容器创建完成...");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean==bean2);

    }

    @Test
    public void IOCtest3(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigTwo.class);
        String[] beanDefinitionNames = applicationContext.getBeanNamesForType(Person.class);
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);

        System.out.println(beansOfType);

    }

    @Test
    public void IOCtest4(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigTwo.class);
        String[] beanDefinitionNames = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值:windows 10
        String property = environment.getProperty("os.name");
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);

        System.out.println(beansOfType);

    }

    @Test
    public void testImport(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigTwo.class);
        //获取所有注册的组件名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
        //工厂bean获取的是调用getObject()创建的对象
        Object myFactoryBean = applicationContext.getBean("myFactoryBean");
        Object myFactoryBean2 = applicationContext.getBean("myFactoryBean");
        System.out.println("myFactoryBean的类型:"+myFactoryBean.getClass());
        System.out.println(myFactoryBean==myFactoryBean2);

        Object myFactoryBean3 = applicationContext.getBean("&myFactoryBean");
        System.out.println("myFactoryBean3的类型:"+myFactoryBean3.getClass());
    }

    @Test
    public void testImportSelector(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigTwo.class);
        //获取所有注册的组件名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }

        System.out.println(applicationContext.getBean(BookController.class));
    }

    @Test
    public void initanddestroy(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigIfLifeCycle.class);
        System.out.println("容器创建成功");
        //关闭容器
        applicationContext.close();
    }

    @Test
    public void propertyvalue(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
        //获取所有注册的组件名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //获取环境变量中配置文件的值(因为配置文件中的值默认都加载到环境变量中)
        String property=environment.getProperty("human.name");
        System.out.println("property="+property);

        Human Human =(Human) applicationContext.getBean("human");
        System.out.println("Human:"+Human);
        //关闭容器
        applicationContext.close();
    }

    @Test
    public void aqp(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        //获取所有注册的组件名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }

        System.out.println(applicationContext.getBean(BookService.class).toString());

        System.out.println(applicationContext.getBean(BookDao.class));
        //关闭容器
        applicationContext.close();
    }

    @Test
    public void At(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        //获取所有注册的组件名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
        System.out.println(applicationContext.getBean(Boss.class));
        System.out.println(applicationContext.getBean(Factorys.class));
        System.out.println(applicationContext.getBean(Car.class));
        //关闭容器
        applicationContext.close();
    }

    @Test
    public void AtP(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        //获取所有注册的组件名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
        System.out.println(applicationContext.getBean(Hot.class));
        //关闭容器
        applicationContext.close();
    }

    //1.使用命令行动态参数:在虚拟机参数位置加载:-Dspring.profiles.active=test
    //2.代码的方式激活某种环境
    @Test
    public void profiletext(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        //2.1:创建一个applicationContext
        //2.2:设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test");
        //2.3:注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //2.4:启动刷新容器
        applicationContext.refresh();

        //获取所有注册的组件名字
        String[] beanDefinitionNames = applicationContext.getBeanNamesForType(DataSource.class);
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }

        //关闭容器
        applicationContext.close();
    }

}
