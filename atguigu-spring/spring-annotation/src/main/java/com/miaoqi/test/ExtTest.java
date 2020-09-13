package com.miaoqi.test;

import com.miaoqi.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

        // 发布事件；
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的时间")) {
        });

        applicationContext.close();
    }

}
