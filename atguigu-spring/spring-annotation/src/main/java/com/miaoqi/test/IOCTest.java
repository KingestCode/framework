package com.miaoqi.test;

import com.miaoqi.bean.Person;
import com.miaoqi.config.MainConfig;
import com.miaoqi.config.MainConfigOfIOC;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {

    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfIOC.class);

    @Test
    public void testImport() {
        printBeans(ctx);

        // 从FactoryBean获取的是调用getObject创建的对象,
        // Bean的名字是FactoryBean的id
        Object b2 = ctx.getBean("colorFactoryBean");
        Object b3 = ctx.getBean("colorFactoryBean");
        System.out.println(b2 == b3);
        // 如果想获取获取FactoryBean本身就加个&
        Object b4 = ctx.getBean("&colorFactoryBean");
        System.out.println(b4.getClass());
    }

    private void printBeans(AnnotationConfigApplicationContext ctx) {
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test03() {
        String[] names = ctx.getBeanNamesForType(Person.class);
        // 动态获取环境变量的值
        ConfigurableEnvironment environment = ctx.getEnvironment();
        System.out.println(environment.getProperty("os.name"));
        for (String name : names) {
            System.out.println(name);
        }
        Map<String, Person> persons = ctx.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    // 测试@Scope, @Lazy
    @Test
    public void test02() {
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String string : beanDefinitionNames) {
            System.out.println(string);
        }
        Object person1 = ctx.getBean("person");
        Object person2 = ctx.getBean("person");
        System.out.println(person1 == person2);
    }

    @Test
    public void test01() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String string : beanDefinitionNames) {
            System.out.println(string);
        }
    }

}
