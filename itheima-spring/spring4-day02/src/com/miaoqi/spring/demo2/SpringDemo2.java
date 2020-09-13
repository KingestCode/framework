package com.miaoqi.spring.demo2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {

    @Test
    public void demo1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService1 = (CustomerService) ctx.getBean("customerService");
        System.out.println(customerService1);
        CustomerService customerService2 = (CustomerService) ctx.getBean("customerService");
        System.out.println(customerService2);
        ctx.close();
    }

}
