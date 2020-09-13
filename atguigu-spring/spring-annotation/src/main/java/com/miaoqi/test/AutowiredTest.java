package com.miaoqi.test;

import com.miaoqi.bean.Boss;
import com.miaoqi.config.MainConfigOfAutowired;
import com.miaoqi.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);

        Boss boss = ctx.getBean(Boss.class);
        System.out.println(boss);

        ctx.close();
    }

}
