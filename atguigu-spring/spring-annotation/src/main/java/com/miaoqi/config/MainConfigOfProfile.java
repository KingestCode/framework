package com.miaoqi.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Spring提供的可以根据当前的环境, 动态激活和切换一系列组件的功能
 *
 * 开发环境, 测试环境, 生产环境
 * 数据库: (/A)(/B)(/C)
 *
 * @Profile: 指定组件在哪个环境下才会被注册到容器中, 不指定的话任何情况下都能注册
 *      1. 加了环境标识的bean, 只有这个环境被激活的时候才能注册到容器中, 默认是default环境
 * @author miaoqi
 * @date 2018/8/15
 */
@Configuration
@PropertySource("classpath:dbconfig.properties")
public class MainConfigOfProfile {

    @Value("${db.username}")
    private String user;

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/taotao");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/pinyougoudb");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
    }

}
