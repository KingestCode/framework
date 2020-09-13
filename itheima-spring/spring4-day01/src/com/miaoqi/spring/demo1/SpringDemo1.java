package com.miaoqi.spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的入门
 * @author miaoqi
 *
 */
public class SpringDemo1 {

    /**
     * 传统方式的调用
     */
    @Test
    public void demo1() {
        UserDao userService = new UserDaoHibernateImpl();
        userService.save();
    }

    /**
     * Spring的方式调用
     */
    @Test
    public void demo2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        userDao.save();
    }

}
