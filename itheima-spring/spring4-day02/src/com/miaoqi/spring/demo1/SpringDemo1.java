package com.miaoqi.spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的IOC注解开发的测试类
 * @author miaoqi
 *
 */
public class SpringDemo1 {

    // 传统方式
    @Test
    public void demo1() {
        //        UserDao userDao = new UserDaoImpl();
        //        userDao.save();

        //        UserDaoImpl userDaoImpl = new UserDaoImpl();
        //        userDaoImpl.setName("aaa");
        //        userDaoImpl.save();
    }

    // Spring的IOC的注解方式
    @Test
    public void demo2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        userDao.save();
    }

    @Test
    public void demo3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.save();
    }

}
