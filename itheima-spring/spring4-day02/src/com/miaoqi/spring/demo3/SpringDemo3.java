package com.miaoqi.spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3 {

    @Test
    public void demo1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService) ctx.getBean("productService");
        productService.save();
    }

}
