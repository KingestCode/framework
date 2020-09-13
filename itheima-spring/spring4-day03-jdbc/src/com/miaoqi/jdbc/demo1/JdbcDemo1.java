package com.miaoqi.jdbc.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JDBC模板的使用
 * @author miaoqi
 *
 */
public class JdbcDemo1 {

    // jdbc模板的使用类似于Dbutils
    @Test
    public void demo1() {
        // 创建连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring4_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        // 创建jdbc模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into account values(null, ?, ?)", "苗骐", 100000d);
    }

}
