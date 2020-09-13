package com.miaoqi.spring.demo1;

import org.junit.Test;

public class SpringDemo1 {

    @Test
    public void demo1() {
        UserDao userDao = new UserDaoImpl();
        // 创建代理
        UserDao proxy = new JdkProxy(userDao).createProxy();
        proxy.save();
        proxy.find();
        proxy.update();
        proxy.delete();
    }

}
