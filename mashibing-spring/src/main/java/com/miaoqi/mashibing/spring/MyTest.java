package com.miaoqi.mashibing.spring;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyTest {

    @Test
    public void test() throws Exception {
        UserController userController = new UserController();
        Class clazz = userController.getClass();
        // 创建 UserService
        UserService userService = new UserService();
        // 获取类中的属性值
        Field serviceField = clazz.getDeclaredField("userService");
        // 在访问时如果是私有的访问类型, 也可以直接访问
        serviceField.setAccessible(true);
        // 获取属性名称
        String name = serviceField.getName();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        String methodName = "set" + name;
        // 获取方法对象
        Method method = clazz.getMethod(methodName, UserService.class);
        // 执行 set 方法
        method.invoke(userController, userService);
        System.out.println(userController.getUserService());
    }

}
