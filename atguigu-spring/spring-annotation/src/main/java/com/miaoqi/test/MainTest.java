package com.miaoqi.test;

import com.miaoqi.bean.Person;
import com.miaoqi.config.MainConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    // 配置的方式
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

    // 注解的方式
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (String string : beanNamesForType) {
            System.out.println(string);
        }
    }

}
