package com.miaoqi.spring.demo2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {

    /**
     * 生命周期的配置
     */
    @Test
    public void demo1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDao customerDao = (CustomerDao) ctx.getBean("customerDao");
        customerDao.save();
        ctx.close();
    }

    /**
     * Bean的作用范围配置
     */
    @Test
    public void demo2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDao customerDao1 = (CustomerDao) ctx.getBean("customerDao");
        CustomerDao customerDao2 = (CustomerDao) ctx.getBean("customerDao");
        System.out.println(customerDao1 == customerDao2);
        ctx.close();
    }

}
