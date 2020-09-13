package com.miaoqi.jdbc.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miaoqi.jdbc.domain.Account;

/**
 * JDBC模板的使用
 * @author miaoqi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcDemo2 {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    // 保存操作
    @Test
    public void demo1() {
        jdbcTemplate.update("insert into account values(null,?,?)", "菊花", 1000d);
    }

    // 修改操作
    @Test
    public void demo2() {
        jdbcTemplate.update("update account set name = ? where id = ?", "哈哈哈哈", 6);
    }

    // 删除操作
    @Test
    public void demo3() {
        jdbcTemplate.update("delete from account where id = ?", 6);
    }

    // 查询操作
    @Test
    public void demo4() {
        String name = jdbcTemplate.queryForObject("select name from account where id = ?", String.class, 5);
        System.out.println(name);
    }

    // 查询操作
    @Test
    public void demo5() {
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }

    // 封装到一个对象中
    @Test
    public void demo6() {
        Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new MyRowMapper(), 5);
        System.out.println(account);
    }

    // 查询多条记录
    @Test
    public void demo7() {
        List<Account> list = jdbcTemplate.query("select * from account", new MyRowMapper());
        for (Account account : list) {
            System.out.println(account);
        }
    }

    class MyRowMapper implements RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setName(rs.getString("name"));
            account.setPrice(rs.getDouble("money"));
            return account;
        }

    }

}
