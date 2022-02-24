package tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/23 12:23
 */

/*
* 原理:
* 1.@EnableTransactionManagement利用TransactionManagementConfigurationSelector给容器中导入组件
*                     导入两个组件:
*                     (1)AutoProxyRegistrar:给容器中注册一个InfrastructureAdvisorAutoProxyCreator组件
*                        InfrastructureAdvisorAutoProxyCreator:利用后置处理器机制在对象创建以后,包装对象,返回一个代理对象(增强器),代理对象执行方法利用拦截器链进行调用
*                     (2)ProxyTransactionManagementConfiguration:
*                                (a)给容器中注册事务增强器;
*                                        事务增强其要用事务注解的信息,AnnotationTransactionAttributeSource解析事务注解
*                                (b)事务拦截器:
*                                        TransactionInterceptor:保存了事务属性信息,事务管理器
*                                        他是一个MenthodInterceptor;在目标方法执行的时候;执行拦截器链,事务拦截器
*                                                  (I)先获取事务相关的属性
*                                                  (II)在获取PlantformTransactionManager，如果没有事先执行TransactionManager,最终会从容器中按照类型获取一个在获取PlantformTransactionManager
*                                                  (III)执行目标方法,如果异常,获取到事务管理器,利用事务管理回滚操作，如果正常,利用事务管理器提交事务
* */
@EnableTransactionManagement
@ComponentScan("tx")
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource= new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("262007");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //Spring对@Configuration类会特殊处理,给容器中加组件的方法,多次调用都只是从从容器总找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return  jdbcTemplate;
    }

    //注册事务管理器在容器中
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return  new DataSourceTransactionManager(dataSource());
    }

}
