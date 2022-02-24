package com.config;

import bean.Car;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/21 14:02
 */
@Profile("test")
//从外部引入配置文件
@PropertySource("classpath:/db.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private String DriverClass;
    private StringValueResolver valueResolver;

    @Bean
    public Car car(){
        return new Car();
    }

    @Profile("test")
    @Bean("TextDatasource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql//localhost:3306/test");
        dataSource.setDriverClass(DriverClass);
        return dataSource;
    }

    @Profile("dev")
    @Bean("DevDatasource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql//localhost:3306/bookcity");
        dataSource.setDriverClass(DriverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean("ProdDatasource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql//localhost:3306/books");
        dataSource.setDriverClass(DriverClass);
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.valueResolver=stringValueResolver;
        DriverClass=valueResolver.resolveStringValue("${db.driverClass}");
    }
}
