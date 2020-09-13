package com.miaoqi.test;

import com.miaoqi.bean.Person;
import com.miaoqi.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertyValuesTest {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01() {
        printBeans(ctx);
        System.out.println("================");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
        ctx.close();
    }

    public void printBeans(AnnotationConfigApplicationContext ctx) {
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
