package com.miaoqi.config;

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
 * 声明式事物:
 *
 * 搭建环境:
 * 1. 导入相关依赖
 *      数据源, 数据库驱动, Spring-jdbc模块
 * 2. 配置数据源, JdbcTemplate(Spring提供的简化数据库操作的工具)操作数据
 * 3. 给方法上标注@Transactional 表示当前方法是一个事物方法
 * 4. 配置@EnableTransactionManagement开启事物注解
 * 5. 配置事物管理器
 *
 * @author miaoqi
 * @date 2018/8/17
 */
@EnableTransactionManagement
@Configuration
@ComponentScan({"com.miaoqi.tx"})
public class MainConfigOfTx {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("miaoqi");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mytest");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        // Spring对@Configuration类会特殊处理, 给容器中加组件的方法, 多次调用都只是从容器中查找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    // 注册事务管理器到容器中
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }

}
