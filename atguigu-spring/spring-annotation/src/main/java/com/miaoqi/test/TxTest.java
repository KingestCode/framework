package com.miaoqi.test;

import com.miaoqi.config.MainConfigOfTx;
import com.miaoqi.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfTx.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.insertUser();
    }
}
