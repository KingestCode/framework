package com.miaoqi.test;

import com.miaoqi.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    public void test01() {
        System.out.println("容器创建完成");
        ctx.close();
    }

}
