package com.miaoqi.test;

import com.miaoqi.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class ProfileTest {
    // 1. 使用命令行参数 -Dspring.profiles.active=test
    @Test
    public void test01() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] beanNamesForType = ctx.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        ctx.close();
    }
}
