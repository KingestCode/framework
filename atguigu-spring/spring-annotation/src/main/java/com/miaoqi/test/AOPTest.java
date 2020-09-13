package com.miaoqi.test;

import com.miaoqi.aop.MathCalculator;
import com.miaoqi.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator mathCalculator = ctx.getBean(MathCalculator.class);
        mathCalculator.div(0, 0);
        ctx.close();
    }
}
